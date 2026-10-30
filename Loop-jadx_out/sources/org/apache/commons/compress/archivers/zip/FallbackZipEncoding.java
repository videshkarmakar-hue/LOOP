package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes18.dex */
class FallbackZipEncoding implements ZipEncoding {
    private final String charsetName;

    public FallbackZipEncoding() {
        this.charsetName = null;
    }

    public FallbackZipEncoding(String charsetName) {
        this.charsetName = charsetName;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public boolean canEncode(String name) {
        return true;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public ByteBuffer encode(String name) throws IOException {
        if (this.charsetName == null) {
            return ByteBuffer.wrap(name.getBytes());
        }
        return ByteBuffer.wrap(name.getBytes(this.charsetName));
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public String decode(byte[] data) throws IOException {
        if (this.charsetName == null) {
            return new String(data);
        }
        return new String(data, this.charsetName);
    }
}
