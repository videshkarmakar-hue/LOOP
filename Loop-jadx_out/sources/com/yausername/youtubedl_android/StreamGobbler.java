package com.yausername.youtubedl_android;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamGobbler.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m195d2 = {"Lcom/yausername/youtubedl_android/StreamGobbler;", "Ljava/lang/Thread;", "buffer", "Ljava/lang/StringBuffer;", "stream", "Ljava/io/InputStream;", "(Ljava/lang/StringBuffer;Ljava/io/InputStream;)V", "run", "", "Companion", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class StreamGobbler extends Thread {
    private static final String TAG = StreamGobbler.class.getSimpleName();
    private final StringBuffer buffer;
    private final InputStream stream;

    public StreamGobbler(StringBuffer buffer, InputStream stream) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.buffer = buffer;
        this.stream = stream;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Reader in = new InputStreamReader(this.stream, StandardCharsets.UTF_8);
            while (true) {
                int it = in.read();
                if (it != -1) {
                    this.buffer.append((char) it);
                } else {
                    return;
                }
            }
        } catch (IOException e) {
        }
    }
}
