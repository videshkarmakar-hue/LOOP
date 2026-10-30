package org.apache.commons.io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes18.dex */
public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset cset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file, TailerListener listener) {
        this(file, listener, 1000L);
    }

    public Tailer(File file, TailerListener listener, long delayMillis) {
        this(file, listener, delayMillis, false);
    }

    public Tailer(File file, TailerListener listener, long delayMillis, boolean end) {
        this(file, listener, delayMillis, end, 4096);
    }

    public Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen) {
        this(file, listener, delayMillis, end, reOpen, 4096);
    }

    public Tailer(File file, TailerListener listener, long delayMillis, boolean end, int bufSize) {
        this(file, listener, delayMillis, end, false, bufSize);
    }

    public Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize) {
        this(file, DEFAULT_CHARSET, listener, delayMillis, end, reOpen, bufSize);
    }

    public Tailer(File file, Charset cset, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize) {
        this.run = true;
        this.file = file;
        this.delayMillis = delayMillis;
        this.end = end;
        this.inbuf = new byte[bufSize];
        this.listener = listener;
        listener.init(this);
        this.reOpen = reOpen;
        this.cset = cset;
    }

    public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, int bufSize) {
        return create(file, listener, delayMillis, end, false, bufSize);
    }

    public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize) {
        return create(file, DEFAULT_CHARSET, listener, delayMillis, end, reOpen, bufSize);
    }

    public static Tailer create(File file, Charset charset, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize) {
        Tailer tailer = new Tailer(file, charset, listener, delayMillis, end, reOpen, bufSize);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end) {
        return create(file, listener, delayMillis, end, 4096);
    }

    public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen) {
        return create(file, listener, delayMillis, end, reOpen, 4096);
    }

    public static Tailer create(File file, TailerListener listener, long delayMillis) {
        return create(file, listener, delayMillis, false);
    }

    public static Tailer create(File file, TailerListener listener) {
        return create(file, listener, 1000L, false);
    }

    public File getFile() {
        return this.file;
    }

    protected boolean getRun() {
        return this.run;
    }

    public long getDelay() {
        return this.delayMillis;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile reader = null;
        long last = 0;
        long position = 0;
        while (getRun() && reader == null) {
            try {
                try {
                    try {
                        try {
                            reader = new RandomAccessFile(this.file, RAF_MODE);
                        } catch (FileNotFoundException e) {
                            this.listener.fileNotFound();
                        }
                        if (reader == null) {
                            Thread.sleep(this.delayMillis);
                        } else {
                            position = this.end ? this.file.length() : 0L;
                            last = this.file.lastModified();
                            reader.seek(position);
                        }
                    } catch (Throwable th) {
                        IOUtils.closeQuietly(reader);
                        throw th;
                    }
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    stop(e2);
                }
            } catch (Exception e3) {
                stop(e3);
            }
        }
        while (getRun()) {
            boolean newer = FileUtils.isFileNewer(this.file, last);
            long length = this.file.length();
            if (length < position) {
                this.listener.fileRotated();
                RandomAccessFile save = reader;
                try {
                    reader = new RandomAccessFile(this.file, RAF_MODE);
                    try {
                        readLines(save);
                    } catch (IOException ioe) {
                        this.listener.handle(ioe);
                    }
                    position = 0;
                    IOUtils.closeQuietly(save);
                } catch (FileNotFoundException e4) {
                    this.listener.fileNotFound();
                }
            } else {
                if (length > position) {
                    position = readLines(reader);
                    last = this.file.lastModified();
                } else if (newer) {
                    reader.seek(0L);
                    position = readLines(reader);
                    last = this.file.lastModified();
                }
                if (this.reOpen) {
                    IOUtils.closeQuietly(reader);
                }
                Thread.sleep(this.delayMillis);
                if (getRun() && this.reOpen) {
                    reader = new RandomAccessFile(this.file, RAF_MODE);
                    reader.seek(position);
                }
            }
        }
        IOUtils.closeQuietly(reader);
    }

    private void stop(Exception e) {
        this.listener.handle(e);
        stop();
    }

    public void stop() {
        this.run = false;
    }

    private long readLines(RandomAccessFile reader) throws IOException {
        int num;
        ByteArrayOutputStream lineBuf = new ByteArrayOutputStream(64);
        long pos = reader.getFilePointer();
        long rePos = pos;
        boolean seenCR = false;
        while (getRun() && (num = reader.read(this.inbuf)) != -1) {
            for (int i = 0; i < num; i++) {
                byte ch = this.inbuf[i];
                switch (ch) {
                    case 10:
                        seenCR = false;
                        this.listener.handle(new String(lineBuf.toByteArray(), this.cset));
                        lineBuf.reset();
                        rePos = ((long) i) + pos + 1;
                        break;
                    case 13:
                        if (seenCR) {
                            lineBuf.write(13);
                        }
                        seenCR = true;
                        break;
                    default:
                        if (seenCR) {
                            seenCR = false;
                            this.listener.handle(new String(lineBuf.toByteArray(), this.cset));
                            lineBuf.reset();
                            rePos = ((long) i) + pos + 1;
                        }
                        lineBuf.write(ch);
                        break;
                }
            }
            pos = reader.getFilePointer();
        }
        IOUtils.closeQuietly((OutputStream) lineBuf);
        reader.seek(rePos);
        if (this.listener instanceof TailerListenerAdapter) {
            ((TailerListenerAdapter) this.listener).endOfFileReached();
        }
        return rePos;
    }
}
