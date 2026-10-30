package org.apache.commons.compress.archivers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.arj.ArjArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.p010ar.ArArchiveInputStream;
import org.apache.commons.compress.archivers.p010ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class ArchiveStreamFactory {

    /* JADX INFO: renamed from: AR */
    public static final String f563AR = "ar";
    public static final String ARJ = "arj";
    public static final String CPIO = "cpio";
    public static final String DUMP = "dump";
    public static final String JAR = "jar";
    public static final String SEVEN_Z = "7z";
    public static final String TAR = "tar";
    public static final String ZIP = "zip";
    private final String encoding;
    private volatile String entryEncoding;

    public ArchiveStreamFactory() {
        this(null);
    }

    public ArchiveStreamFactory(String encoding) {
        this.entryEncoding = null;
        this.encoding = encoding;
        this.entryEncoding = encoding;
    }

    public String getEntryEncoding() {
        return this.entryEncoding;
    }

    @Deprecated
    public void setEntryEncoding(String entryEncoding) {
        if (this.encoding != null) {
            throw new IllegalStateException("Cannot overide encoding set by the constructor");
        }
        this.entryEncoding = entryEncoding;
    }

    public ArchiveInputStream createArchiveInputStream(String archiverName, InputStream in) throws ArchiveException {
        if (archiverName == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (in == null) {
            throw new IllegalArgumentException("InputStream must not be null.");
        }
        if (f563AR.equalsIgnoreCase(archiverName)) {
            return new ArArchiveInputStream(in);
        }
        if (ARJ.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new ArjArchiveInputStream(in, this.entryEncoding);
            }
            return new ArjArchiveInputStream(in);
        }
        if (ZIP.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new ZipArchiveInputStream(in, this.entryEncoding);
            }
            return new ZipArchiveInputStream(in);
        }
        if (TAR.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new TarArchiveInputStream(in, this.entryEncoding);
            }
            return new TarArchiveInputStream(in);
        }
        if (JAR.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new JarArchiveInputStream(in, this.entryEncoding);
            }
            return new JarArchiveInputStream(in);
        }
        if (CPIO.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new CpioArchiveInputStream(in, this.entryEncoding);
            }
            return new CpioArchiveInputStream(in);
        }
        if (DUMP.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new DumpArchiveInputStream(in, this.entryEncoding);
            }
            return new DumpArchiveInputStream(in);
        }
        if (SEVEN_Z.equalsIgnoreCase(archiverName)) {
            throw new StreamingNotSupportedException(SEVEN_Z);
        }
        throw new ArchiveException("Archiver: " + archiverName + " not found.");
    }

    public ArchiveOutputStream createArchiveOutputStream(String archiverName, OutputStream out) throws ArchiveException {
        if (archiverName == null) {
            throw new IllegalArgumentException("Archivername must not be null.");
        }
        if (out == null) {
            throw new IllegalArgumentException("OutputStream must not be null.");
        }
        if (f563AR.equalsIgnoreCase(archiverName)) {
            return new ArArchiveOutputStream(out);
        }
        if (ZIP.equalsIgnoreCase(archiverName)) {
            ZipArchiveOutputStream zip = new ZipArchiveOutputStream(out);
            if (this.entryEncoding != null) {
                zip.setEncoding(this.entryEncoding);
            }
            return zip;
        }
        if (TAR.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new TarArchiveOutputStream(out, this.entryEncoding);
            }
            return new TarArchiveOutputStream(out);
        }
        if (JAR.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new JarArchiveOutputStream(out, this.entryEncoding);
            }
            return new JarArchiveOutputStream(out);
        }
        if (CPIO.equalsIgnoreCase(archiverName)) {
            if (this.entryEncoding != null) {
                return new CpioArchiveOutputStream(out, this.entryEncoding);
            }
            return new CpioArchiveOutputStream(out);
        }
        if (SEVEN_Z.equalsIgnoreCase(archiverName)) {
            throw new StreamingNotSupportedException(SEVEN_Z);
        }
        throw new ArchiveException("Archiver: " + archiverName + " not found.");
    }

    public ArchiveInputStream createArchiveInputStream(InputStream in) throws ArchiveException {
        if (in == null) {
            throw new IllegalArgumentException("Stream must not be null.");
        }
        if (!in.markSupported()) {
            throw new IllegalArgumentException("Mark is not supported.");
        }
        byte[] signature = new byte[12];
        in.mark(signature.length);
        try {
            int signatureLength = IOUtils.readFully(in, signature);
            in.reset();
            if (ZipArchiveInputStream.matches(signature, signatureLength)) {
                return createArchiveInputStream(ZIP, in);
            }
            if (JarArchiveInputStream.matches(signature, signatureLength)) {
                return createArchiveInputStream(JAR, in);
            }
            if (ArArchiveInputStream.matches(signature, signatureLength)) {
                return createArchiveInputStream(f563AR, in);
            }
            if (CpioArchiveInputStream.matches(signature, signatureLength)) {
                return createArchiveInputStream(CPIO, in);
            }
            if (ArjArchiveInputStream.matches(signature, signatureLength)) {
                return createArchiveInputStream(ARJ, in);
            }
            if (SevenZFile.matches(signature, signatureLength)) {
                throw new StreamingNotSupportedException(SEVEN_Z);
            }
            byte[] dumpsig = new byte[32];
            in.mark(dumpsig.length);
            int signatureLength2 = IOUtils.readFully(in, dumpsig);
            in.reset();
            if (DumpArchiveInputStream.matches(dumpsig, signatureLength2)) {
                return createArchiveInputStream(DUMP, in);
            }
            byte[] tarheader = new byte[512];
            in.mark(tarheader.length);
            int signatureLength3 = IOUtils.readFully(in, tarheader);
            in.reset();
            if (TarArchiveInputStream.matches(tarheader, signatureLength3)) {
                return createArchiveInputStream(TAR, in);
            }
            if (signatureLength3 >= 512) {
                TarArchiveInputStream tais = null;
                try {
                    tais = new TarArchiveInputStream(new ByteArrayInputStream(tarheader));
                    if (tais.getNextTarEntry().isCheckSumOK()) {
                        return createArchiveInputStream(TAR, in);
                    }
                } catch (Exception e) {
                } finally {
                    IOUtils.closeQuietly(tais);
                }
            }
            throw new ArchiveException("No Archiver found for the stream signature");
        } catch (IOException e2) {
            throw new ArchiveException("Could not use reset and mark operations.", e2);
        }
    }
}
