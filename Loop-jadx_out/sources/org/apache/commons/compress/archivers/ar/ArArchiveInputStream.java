package org.apache.commons.compress.archivers.ar;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class ArArchiveInputStream extends ArchiveInputStream {
    private static final String BSD_LONGNAME_PATTERN = "^#1/\\d+";
    static final String BSD_LONGNAME_PREFIX = "#1/";
    private static final int BSD_LONGNAME_PREFIX_LEN = BSD_LONGNAME_PREFIX.length();
    private static final String GNU_LONGNAME_PATTERN = "^/\\d+";
    private static final String GNU_STRING_TABLE_NAME = "//";
    private final InputStream input;
    private long offset = 0;
    private ArArchiveEntry currentEntry = null;
    private byte[] namebuffer = null;
    private long entryOffset = -1;
    private final byte[] NAME_BUF = new byte[16];
    private final byte[] LAST_MODIFIED_BUF = new byte[12];
    private final byte[] ID_BUF = new byte[6];
    private final byte[] FILE_MODE_BUF = new byte[8];
    private final byte[] LENGTH_BUF = new byte[10];
    private boolean closed = false;

    public ArArchiveInputStream(InputStream pInput) {
        this.input = pInput;
    }

    public ArArchiveEntry getNextArEntry() throws IOException {
        String temp;
        long len;
        if (this.currentEntry != null) {
            long entryEnd = this.entryOffset + this.currentEntry.getLength();
            IOUtils.skip(this, entryEnd - this.offset);
            this.currentEntry = null;
        }
        long entryEnd2 = this.offset;
        if (entryEnd2 == 0) {
            byte[] expected = ArchiveUtils.toAsciiBytes(ArArchiveEntry.HEADER);
            byte[] realized = new byte[expected.length];
            int read = IOUtils.readFully(this, realized);
            if (read != expected.length) {
                throw new IOException("failed to read header. Occured at byte: " + getBytesRead());
            }
            for (int i = 0; i < expected.length; i++) {
                if (expected[i] != realized[i]) {
                    throw new IOException("invalid header " + ArchiveUtils.toAsciiString(realized));
                }
            }
        }
        if ((this.offset % 2 != 0 && read() < 0) || this.input.available() == 0) {
            return null;
        }
        IOUtils.readFully(this, this.NAME_BUF);
        IOUtils.readFully(this, this.LAST_MODIFIED_BUF);
        IOUtils.readFully(this, this.ID_BUF);
        int userId = asInt(this.ID_BUF, true);
        IOUtils.readFully(this, this.ID_BUF);
        IOUtils.readFully(this, this.FILE_MODE_BUF);
        IOUtils.readFully(this, this.LENGTH_BUF);
        byte[] expected2 = ArchiveUtils.toAsciiBytes(ArArchiveEntry.TRAILER);
        byte[] realized2 = new byte[expected2.length];
        int read2 = IOUtils.readFully(this, realized2);
        if (read2 != expected2.length) {
            throw new IOException("failed to read entry trailer. Occured at byte: " + getBytesRead());
        }
        for (int i2 = 0; i2 < expected2.length; i2++) {
            if (expected2[i2] != realized2[i2]) {
                throw new IOException("invalid entry trailer. not read the content? Occured at byte: " + getBytesRead());
            }
        }
        this.entryOffset = this.offset;
        String temp2 = ArchiveUtils.toAsciiString(this.NAME_BUF).trim();
        if (isGNUStringTable(temp2)) {
            this.currentEntry = readGNUStringTable(this.LENGTH_BUF);
            return getNextArEntry();
        }
        long len2 = asLong(this.LENGTH_BUF);
        if (temp2.endsWith("/")) {
            temp = temp2.substring(0, temp2.length() - 1);
            len = len2;
        } else {
            if (isGNULongName(temp2)) {
                int off = Integer.parseInt(temp2.substring(1));
                temp2 = getExtendedName(off);
            } else if (isBSDLongName(temp2)) {
                String temp3 = getBSDLongName(temp2);
                int nameLen = temp3.length();
                this.entryOffset += (long) nameLen;
                temp = temp3;
                len = len2 - ((long) nameLen);
            }
            temp = temp2;
            len = len2;
        }
        this.currentEntry = new ArArchiveEntry(temp, len, userId, asInt(this.ID_BUF, true), asInt(this.FILE_MODE_BUF, 8), asLong(this.LAST_MODIFIED_BUF));
        return this.currentEntry;
    }

    private String getExtendedName(int offset) throws IOException {
        if (this.namebuffer == null) {
            throw new IOException("Cannot process GNU long filename as no // record was found");
        }
        int i = offset;
        while (i < this.namebuffer.length) {
            if (this.namebuffer[i] != 10 && this.namebuffer[i] != 0) {
                i++;
            } else {
                if (this.namebuffer[i - 1] == 47) {
                    i--;
                }
                return ArchiveUtils.toAsciiString(this.namebuffer, offset, i - offset);
            }
        }
        throw new IOException("Failed to read entry: " + offset);
    }

    private long asLong(byte[] input) {
        return Long.parseLong(ArchiveUtils.toAsciiString(input).trim());
    }

    private int asInt(byte[] input) {
        return asInt(input, 10, false);
    }

    private int asInt(byte[] input, boolean treatBlankAsZero) {
        return asInt(input, 10, treatBlankAsZero);
    }

    private int asInt(byte[] input, int base) {
        return asInt(input, base, false);
    }

    private int asInt(byte[] input, int base, boolean treatBlankAsZero) {
        String string = ArchiveUtils.toAsciiString(input).trim();
        if (string.length() == 0 && treatBlankAsZero) {
            return 0;
        }
        return Integer.parseInt(string, base);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextArEntry();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.input.close();
        }
        this.currentEntry = null;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int toRead = len;
        if (this.currentEntry != null) {
            long entryEnd = this.entryOffset + this.currentEntry.getLength();
            if (len > 0 && entryEnd > this.offset) {
                toRead = (int) Math.min(len, entryEnd - this.offset);
            } else {
                return -1;
            }
        }
        int ret = this.input.read(b, off, toRead);
        count(ret);
        this.offset += ret > 0 ? ret : 0L;
        return ret;
    }

    public static boolean matches(byte[] signature, int length) {
        return length >= 8 && signature[0] == 33 && signature[1] == 60 && signature[2] == 97 && signature[3] == 114 && signature[4] == 99 && signature[5] == 104 && signature[6] == 62 && signature[7] == 10;
    }

    private static boolean isBSDLongName(String name) {
        return name != null && name.matches(BSD_LONGNAME_PATTERN);
    }

    private String getBSDLongName(String bsdLongName) throws IOException {
        int nameLen = Integer.parseInt(bsdLongName.substring(BSD_LONGNAME_PREFIX_LEN));
        byte[] name = new byte[nameLen];
        int read = IOUtils.readFully(this, name);
        if (read != nameLen) {
            throw new EOFException();
        }
        return ArchiveUtils.toAsciiString(name);
    }

    private static boolean isGNUStringTable(String name) {
        return GNU_STRING_TABLE_NAME.equals(name);
    }

    private ArArchiveEntry readGNUStringTable(byte[] length) throws IOException {
        int bufflen = asInt(length);
        this.namebuffer = new byte[bufflen];
        int read = IOUtils.readFully(this, this.namebuffer, 0, bufflen);
        if (read != bufflen) {
            throw new IOException("Failed to read complete // record: expected=" + bufflen + " read=" + read);
        }
        return new ArArchiveEntry(GNU_STRING_TABLE_NAME, bufflen);
    }

    private boolean isGNULongName(String name) {
        return name != null && name.matches(GNU_LONGNAME_PATTERN);
    }
}
