package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier;

/* JADX INFO: loaded from: classes18.dex */
public class ParallelScatterZipCreator {
    private final ScatterGatherBackingStoreSupplier backingStoreSupplier;
    private long compressionDoneAt;

    /* JADX INFO: renamed from: es */
    private final ExecutorService f571es;
    private final List<Future<Object>> futures;
    private long scatterDoneAt;
    private final long startedAt;
    private final List<ScatterZipOutputStream> streams;
    private final ThreadLocal<ScatterZipOutputStream> tlScatterStreams;

    private static class DefaultBackingStoreSupplier implements ScatterGatherBackingStoreSupplier {
        final AtomicInteger storeNum;

        private DefaultBackingStoreSupplier() {
            this.storeNum = new AtomicInteger(0);
        }

        @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier
        public ScatterGatherBackingStore get() throws IOException {
            File tempFile = File.createTempFile("parallelscatter", "n" + this.storeNum.incrementAndGet());
            return new FileBasedScatterGatherBackingStore(tempFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ScatterZipOutputStream createDeferred(ScatterGatherBackingStoreSupplier scatterGatherBackingStoreSupplier) throws IOException {
        ScatterGatherBackingStore bs = scatterGatherBackingStoreSupplier.get();
        StreamCompressor sc = StreamCompressor.create(-1, bs);
        return new ScatterZipOutputStream(bs, sc);
    }

    public ParallelScatterZipCreator() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    public ParallelScatterZipCreator(ExecutorService executorService) {
        this(executorService, new DefaultBackingStoreSupplier());
    }

    public ParallelScatterZipCreator(ExecutorService executorService, ScatterGatherBackingStoreSupplier backingStoreSupplier) {
        this.streams = Collections.synchronizedList(new ArrayList());
        this.futures = new ArrayList();
        this.startedAt = System.currentTimeMillis();
        this.compressionDoneAt = 0L;
        this.tlScatterStreams = new ThreadLocal<ScatterZipOutputStream>() { // from class: org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public ScatterZipOutputStream initialValue() {
                try {
                    ScatterZipOutputStream scatterStream = ParallelScatterZipCreator.this.createDeferred(ParallelScatterZipCreator.this.backingStoreSupplier);
                    ParallelScatterZipCreator.this.streams.add(scatterStream);
                    return scatterStream;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        this.backingStoreSupplier = backingStoreSupplier;
        this.f571es = executorService;
    }

    public void addArchiveEntry(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier source) {
        submit(createCallable(zipArchiveEntry, source));
    }

    public final void submit(Callable<Object> callable) {
        this.futures.add(this.f571es.submit(callable));
    }

    public final Callable<Object> createCallable(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier source) {
        int method = zipArchiveEntry.getMethod();
        if (method == -1) {
            throw new IllegalArgumentException("Method must be set on zipArchiveEntry: " + zipArchiveEntry);
        }
        final ZipArchiveEntryRequest zipArchiveEntryRequest = ZipArchiveEntryRequest.createZipArchiveEntryRequest(zipArchiveEntry, source);
        return new Callable<Object>() { // from class: org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator.2
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                ((ScatterZipOutputStream) ParallelScatterZipCreator.this.tlScatterStreams.get()).addArchiveEntry(zipArchiveEntryRequest);
                return null;
            }
        };
    }

    public void writeTo(ZipArchiveOutputStream targetStream) throws ExecutionException, InterruptedException, IOException {
        for (Future<?> future : this.futures) {
            future.get();
        }
        this.f571es.shutdown();
        this.f571es.awaitTermination(60000L, TimeUnit.SECONDS);
        this.compressionDoneAt = System.currentTimeMillis();
        for (ScatterZipOutputStream scatterStream : this.streams) {
            scatterStream.writeTo(targetStream);
            scatterStream.close();
        }
        this.scatterDoneAt = System.currentTimeMillis();
    }

    public ScatterStatistics getStatisticsMessage() {
        return new ScatterStatistics(this.compressionDoneAt - this.startedAt, this.scatterDoneAt - this.compressionDoneAt);
    }
}
