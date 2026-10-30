package com.yausername.youtubedl_android;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamProcessExtractor.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m195d2 = {"Lcom/yausername/youtubedl_android/StreamProcessExtractor;", "Ljava/lang/Thread;", "buffer", "Ljava/lang/StringBuffer;", "stream", "Ljava/io/InputStream;", "callback", "Lkotlin/Function3;", "", "", "", "", "(Ljava/lang/StringBuffer;Ljava/io/InputStream;Lkotlin/jvm/functions/Function3;)V", "eta", "p", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "pAria2c", NotificationCompat.CATEGORY_PROGRESS, "convertToSeconds", "", "minutes", "seconds", "getEta", "line", "getProgress", "processOutputLine", "run", "Companion", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class StreamProcessExtractor extends Thread {
    private static final long ETA = -1;
    private static final int GROUP_MINUTES = 2;
    private static final int GROUP_PERCENT = 1;
    private static final int GROUP_SECONDS = 3;
    private static final float PERCENT = -1.0f;
    private final StringBuffer buffer;
    private final Function3<Float, Long, String, Unit> callback;
    private long eta;
    private final Pattern p;
    private final Pattern pAria2c;
    private float progress;
    private final InputStream stream;
    private static final String TAG = StreamProcessExtractor.class.getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    public StreamProcessExtractor(StringBuffer buffer, InputStream stream, Function3<? super Float, ? super Long, ? super String, Unit> function3) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.buffer = buffer;
        this.stream = stream;
        this.callback = function3;
        this.p = Pattern.compile("\\[download\\]\\s+(\\d+\\.\\d)% .* ETA (\\d+):(\\d+)");
        this.pAria2c = Pattern.compile("\\[#\\w{6}.*\\((\\d*\\.*\\d+)%\\).*?((\\d+)m)*((\\d+)s)*]");
        this.progress = PERCENT;
        this.eta = -1L;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Reader input = new InputStreamReader(this.stream, StandardCharsets.UTF_8);
            StringBuilder currentLine = new StringBuilder();
            while (true) {
                int it = input.read();
                if (it != -1) {
                    this.buffer.append((char) it);
                    if (it == 13 || (it == 10 && this.callback != null)) {
                        String line = currentLine.toString();
                        Intrinsics.checkNotNullExpressionValue(line, "currentLine.toString()");
                        processOutputLine(line);
                        currentLine.setLength(0);
                    } else {
                        currentLine.append((char) it);
                    }
                } else {
                    return;
                }
            }
        } catch (IOException e) {
        }
    }

    private final void processOutputLine(String line) {
        Function3<Float, Long, String, Unit> function3 = this.callback;
        if (function3 != null) {
            function3.invoke(Float.valueOf(getProgress(line)), Long.valueOf(getEta(line)), line);
        }
    }

    private final float getProgress(String line) {
        Matcher matcher = this.p.matcher(line);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            Intrinsics.checkNotNullExpressionValue(strGroup, "matcher.group(GROUP_PERCENT)");
            float it = Float.parseFloat(strGroup);
            this.progress = it;
            return it;
        }
        Matcher mAria2c = this.pAria2c.matcher(line);
        if (mAria2c.find()) {
            String strGroup2 = mAria2c.group(1);
            Intrinsics.checkNotNullExpressionValue(strGroup2, "mAria2c.group(1)");
            float it2 = Float.parseFloat(strGroup2);
            this.progress = it2;
            return it2;
        }
        return this.progress;
    }

    private final long getEta(String line) {
        Matcher matcher = this.p.matcher(line);
        if (matcher.find()) {
            int it = convertToSeconds(matcher.group(2), matcher.group(3));
            this.eta = it;
            return it;
        }
        Matcher mAria2c = this.pAria2c.matcher(line);
        if (mAria2c.find()) {
            int it2 = convertToSeconds(mAria2c.group(3), mAria2c.group(5));
            this.eta = it2;
            return it2;
        }
        return this.eta;
    }

    private final int convertToSeconds(String minutes, String seconds) {
        if (seconds == null) {
            return 0;
        }
        return minutes == null ? Integer.parseInt(seconds) : (Integer.parseInt(minutes) * 60) + Integer.parseInt(seconds);
    }
}
