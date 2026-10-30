package org.apache.commons.compress.archivers.jar;

import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

/* JADX INFO: loaded from: classes18.dex */
public class JarArchiveEntry extends ZipArchiveEntry {
    private final Certificate[] certificates;
    private final Attributes manifestAttributes;

    public JarArchiveEntry(ZipEntry entry) throws ZipException {
        super(entry);
        this.manifestAttributes = null;
        this.certificates = null;
    }

    public JarArchiveEntry(String name) {
        super(name);
        this.manifestAttributes = null;
        this.certificates = null;
    }

    public JarArchiveEntry(ZipArchiveEntry entry) throws ZipException {
        super(entry);
        this.manifestAttributes = null;
        this.certificates = null;
    }

    public JarArchiveEntry(JarEntry entry) throws ZipException {
        super(entry);
        this.manifestAttributes = null;
        this.certificates = null;
    }

    @Deprecated
    public Attributes getManifestAttributes() {
        return this.manifestAttributes;
    }

    @Deprecated
    public Certificate[] getCertificates() {
        if (this.certificates != null) {
            Certificate[] certs = new Certificate[this.certificates.length];
            System.arraycopy(this.certificates, 0, certs, 0, certs.length);
            return certs;
        }
        return null;
    }
}
