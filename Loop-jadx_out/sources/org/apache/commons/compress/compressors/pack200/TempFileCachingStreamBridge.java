package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes18.dex */
class TempFileCachingStreamBridge extends StreamBridge {

    /* JADX INFO: renamed from: f */
    private final File f588f = File.createTempFile("commons-compress", "packtemp");

    TempFileCachingStreamBridge() throws IOException {
        this.f588f.deleteOnExit();
        this.out = new FileOutputStream(this.f588f);
    }

    @Override // org.apache.commons.compress.compressors.pack200.StreamBridge
    InputStream getInputView() throws IOException {
        this.out.close();
        return new FileInputStream(this.f588f) { // from class: org.apache.commons.compress.compressors.pack200.TempFileCachingStreamBridge.1
            @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                TempFileCachingStreamBridge.this.f588f.delete();
            }
        };
    }
}
