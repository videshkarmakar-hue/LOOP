package com.yausername.youtubedl_android;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YoutubeDLResponse.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, m195d2 = {"Lcom/yausername/youtubedl_android/YoutubeDLResponse;", "", "command", "", "", "exitCode", "", "elapsedTime", "", "out", NotificationCompat.CATEGORY_ERROR, "(Ljava/util/List;IJLjava/lang/String;Ljava/lang/String;)V", "getCommand", "()Ljava/util/List;", "getElapsedTime", "()J", "getErr", "()Ljava/lang/String;", "getExitCode", "()I", "getOut", "library_release"}, m196k = 1, m197mv = {1, 7, 1}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class YoutubeDLResponse {
    private final List<String> command;
    private final long elapsedTime;
    private final String err;
    private final int exitCode;
    private final String out;

    public YoutubeDLResponse(List<String> command, int exitCode, long elapsedTime, String out, String err) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(err, "err");
        this.command = command;
        this.exitCode = exitCode;
        this.elapsedTime = elapsedTime;
        this.out = out;
        this.err = err;
    }

    public final List<String> getCommand() {
        return this.command;
    }

    public final int getExitCode() {
        return this.exitCode;
    }

    public final long getElapsedTime() {
        return this.elapsedTime;
    }

    public final String getOut() {
        return this.out;
    }

    public final String getErr() {
        return this.err;
    }
}
