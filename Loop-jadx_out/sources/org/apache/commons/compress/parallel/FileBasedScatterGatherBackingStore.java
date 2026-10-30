package org.apache.commons.compress.parallel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes18.dex */
public class FileBasedScatterGatherBackingStore implements ScatterGatherBackingStore {
    private boolean closed;

    /* JADX INFO: renamed from: os */
    private final FileOutputStream f593os;
    private final File target;

    public FileBasedScatterGatherBackingStore(File target) throws FileNotFoundException {
        this.target = target;
        this.f593os = new FileOutputStream(target);
    }

    @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStore
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.target);
    }

    @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStore
    public void closeForWriting() throws IOException {
        if (!this.closed) {
            this.f593os.close();
            this.closed = true;
        }
    }

    @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStore
    public void writeOut(byte[] data, int offset, int length) throws IOException {
        this.f593os.write(data, offset, length);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        closeForWriting();
        this.target.delete();
    }
}
