package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.jar.JarInputStream;
import java.util.jar.Pack200;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class Pack200CompressorOutputStream extends CompressorOutputStream {
    private boolean finished;
    private final OutputStream originalOutput;
    private final Map<String, String> properties;
    private final StreamBridge streamBridge;

    public Pack200CompressorOutputStream(OutputStream out) throws IOException {
        this(out, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorOutputStream(OutputStream out, Pack200Strategy mode) throws IOException {
        this(out, mode, null);
    }

    public Pack200CompressorOutputStream(OutputStream out, Map<String, String> props) throws IOException {
        this(out, Pack200Strategy.IN_MEMORY, props);
    }

    public Pack200CompressorOutputStream(OutputStream out, Pack200Strategy mode, Map<String, String> props) throws IOException {
        this.finished = false;
        this.originalOutput = out;
        this.streamBridge = mode.newStreamBridge();
        this.properties = props;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.streamBridge.write(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        this.streamBridge.write(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int from, int length) throws IOException {
        this.streamBridge.write(b, from, length);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();
        try {
            this.streamBridge.stop();
        } finally {
            this.originalOutput.close();
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            this.finished = true;
            Pack200.Packer p = Pack200.newPacker();
            if (this.properties != null) {
                p.properties().putAll(this.properties);
            }
            JarInputStream ji = null;
            boolean success = false;
            try {
                JarInputStream jarInputStream = new JarInputStream(this.streamBridge.getInput());
                ji = jarInputStream;
                p.pack(jarInputStream, this.originalOutput);
                success = true;
            } finally {
                if (!success) {
                    IOUtils.closeQuietly(ji);
                }
            }
        }
    }
}
