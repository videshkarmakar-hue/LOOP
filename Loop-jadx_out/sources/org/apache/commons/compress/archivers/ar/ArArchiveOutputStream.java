package org.apache.commons.compress.archivers.ar;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ArchiveUtils;

/* JADX INFO: loaded from: classes18.dex */
public class ArArchiveOutputStream extends ArchiveOutputStream {
    public static final int LONGFILE_BSD = 1;
    public static final int LONGFILE_ERROR = 0;
    private final OutputStream out;
    private ArArchiveEntry prevEntry;
    private long entryOffset = 0;
    private boolean haveUnclosedEntry = false;
    private int longFileMode = 0;
    private boolean finished = false;

    public ArArchiveOutputStream(OutputStream pOut) {
        this.out = pOut;
    }

    public void setLongFileMode(int longFileMode) {
        this.longFileMode = longFileMode;
    }

    private long writeArchiveHeader() throws IOException {
        byte[] header = ArchiveUtils.toAsciiBytes(ArArchiveEntry.HEADER);
        this.out.write(header);
        return header.length;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        if (this.prevEntry == null || !this.haveUnclosedEntry) {
            throw new IOException("No current entry to close");
        }
        if (this.entryOffset % 2 != 0) {
            this.out.write(10);
        }
        this.haveUnclosedEntry = false;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry pEntry) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        ArArchiveEntry pArEntry = (ArArchiveEntry) pEntry;
        if (this.prevEntry == null) {
            writeArchiveHeader();
        } else {
            if (this.prevEntry.getLength() != this.entryOffset) {
                throw new IOException("length does not match entry (" + this.prevEntry.getLength() + " != " + this.entryOffset);
            }
            if (this.haveUnclosedEntry) {
                closeArchiveEntry();
            }
        }
        this.prevEntry = pArEntry;
        writeEntryHeader(pArEntry);
        this.entryOffset = 0L;
        this.haveUnclosedEntry = true;
    }

    private long fill(long pOffset, long pNewOffset, char pFill) throws IOException {
        long diff = pNewOffset - pOffset;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                write(pFill);
            }
        }
        return pNewOffset;
    }

    private long write(String data) throws IOException {
        byte[] bytes = data.getBytes("ascii");
        write(bytes);
        return bytes.length;
    }

    private long writeEntryHeader(ArArchiveEntry pEntry) throws IOException {
        long offset;
        boolean mustAppendName;
        String n = pEntry.getName();
        if (this.longFileMode == 0 && n.length() > 16) {
            throw new IOException("filename too long, > 16 chars: " + n);
        }
        if (1 == this.longFileMode && (n.length() > 16 || n.contains(" "))) {
            long offset2 = 0 + write("#1/" + String.valueOf(n.length()));
            offset = offset2;
            mustAppendName = true;
        } else {
            long offset3 = 0 + write(n);
            offset = offset3;
            mustAppendName = false;
        }
        long offset4 = fill(offset, 16L, ' ');
        String m = "" + pEntry.getLastModified();
        if (m.length() > 12) {
            throw new IOException("modified too long");
        }
        long offset5 = fill(offset4 + write(m), 28L, ' ');
        String u = "" + pEntry.getUserId();
        if (u.length() > 6) {
            throw new IOException("userid too long");
        }
        long offset6 = fill(offset5 + write(u), 34L, ' ');
        String g = "" + pEntry.getGroupId();
        if (g.length() > 6) {
            throw new IOException("groupid too long");
        }
        long offset7 = fill(offset6 + write(g), 40L, ' ');
        String fm = "" + Integer.toString(pEntry.getMode(), 8);
        if (fm.length() > 8) {
            throw new IOException("filemode too long");
        }
        long offset8 = fill(offset7 + write(fm), 48L, ' ');
        String s = String.valueOf(pEntry.getLength() + ((long) (mustAppendName ? n.length() : 0)));
        if (s.length() <= 10) {
            long offset9 = fill(offset8 + write(s), 58L, ' ') + write(ArArchiveEntry.TRAILER);
            if (mustAppendName) {
                return offset9 + write(n);
            }
            return offset9;
        }
        throw new IOException("size too long");
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        count(len);
        this.entryOffset += (long) len;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
        this.out.close();
        this.prevEntry = null;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        return new ArArchiveEntry(inputFile, entryName);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        if (this.haveUnclosedEntry) {
            throw new IOException("This archive contains unclosed entries.");
        }
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        }
        this.finished = true;
    }
}
