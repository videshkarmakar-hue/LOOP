package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;
import org.apache.commons.compress.utils.BoundedInputStream;

/* JADX INFO: loaded from: classes18.dex */
public class ScatterZipOutputStream implements Closeable {
    private final ScatterGatherBackingStore backingStore;
    private final Queue<CompressedEntry> items = new ConcurrentLinkedQueue();
    private final StreamCompressor streamCompressor;

    private static class CompressedEntry {
        final long compressedSize;
        final long crc;
        final long size;
        final ZipArchiveEntryRequest zipArchiveEntryRequest;

        public CompressedEntry(ZipArchiveEntryRequest zipArchiveEntryRequest, long crc, long compressedSize, long size) {
            this.zipArchiveEntryRequest = zipArchiveEntryRequest;
            this.crc = crc;
            this.compressedSize = compressedSize;
            this.size = size;
        }

        public ZipArchiveEntry transferToArchiveEntry() {
            ZipArchiveEntry entry = this.zipArchiveEntryRequest.getZipArchiveEntry();
            entry.setCompressedSize(this.compressedSize);
            entry.setSize(this.size);
            entry.setCrc(this.crc);
            entry.setMethod(this.zipArchiveEntryRequest.getMethod());
            return entry;
        }
    }

    public ScatterZipOutputStream(ScatterGatherBackingStore backingStore, StreamCompressor streamCompressor) {
        this.backingStore = backingStore;
        this.streamCompressor = streamCompressor;
    }

    public void addArchiveEntry(ZipArchiveEntryRequest zipArchiveEntryRequest) throws IOException {
        InputStream payloadStream = zipArchiveEntryRequest.getPayloadStream();
        try {
            this.streamCompressor.deflate(payloadStream, zipArchiveEntryRequest.getMethod());
            payloadStream.close();
            this.items.add(new CompressedEntry(zipArchiveEntryRequest, this.streamCompressor.getCrc32(), this.streamCompressor.getBytesWrittenForLastEntry(), this.streamCompressor.getBytesRead()));
        } catch (Throwable th) {
            payloadStream.close();
            throw th;
        }
    }

    public void writeTo(ZipArchiveOutputStream target) throws IOException {
        this.backingStore.closeForWriting();
        InputStream data = this.backingStore.getInputStream();
        for (CompressedEntry compressedEntry : this.items) {
            BoundedInputStream rawStream = new BoundedInputStream(data, compressedEntry.compressedSize);
            target.addRawArchiveEntry(compressedEntry.transferToArchiveEntry(), rawStream);
            rawStream.close();
        }
        data.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.backingStore.close();
    }

    public static ScatterZipOutputStream fileBased(File file) throws FileNotFoundException {
        return fileBased(file, -1);
    }

    public static ScatterZipOutputStream fileBased(File file, int compressionLevel) throws FileNotFoundException {
        ScatterGatherBackingStore bs = new FileBasedScatterGatherBackingStore(file);
        StreamCompressor sc = StreamCompressor.create(compressionLevel, bs);
        return new ScatterZipOutputStream(bs, sc);
    }
}
