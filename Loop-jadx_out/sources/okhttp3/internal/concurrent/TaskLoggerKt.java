package okhttp3.internal.concurrent;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: TaskLogger.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a$\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\u001a9\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\u0011\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, m195d2 = {"formatDuration", "", "ns", "", "log", "", "Ljava/util/logging/Logger;", "task", "Lokhttp3/internal/concurrent/Task;", Route.DOWNLOAD_QUEUE, "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Ljava/util/logging/Logger;Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TaskLoggerKt {
    public static final void taskLog(Logger $this$taskLog, Task task, TaskQueue queue, Function0<String> messageBlock) {
        Intrinsics.checkNotNullParameter($this$taskLog, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(messageBlock, "messageBlock");
        if ($this$taskLog.isLoggable(Level.FINE)) {
            log($this$taskLog, task, queue, messageBlock.invoke());
        }
    }

    public static final <T> T logElapsed(Logger $this$logElapsed, Task task, TaskQueue queue, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter($this$logElapsed, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(block, "block");
        long startNs = -1;
        boolean loggingEnabled = $this$logElapsed.isLoggable(Level.FINE);
        if (loggingEnabled) {
            startNs = queue.getTaskRunner().getBackend().nanoTime();
            log($this$logElapsed, task, queue, "starting");
        }
        try {
            T tInvoke = block.invoke();
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                log($this$logElapsed, task, queue, "finished run in " + formatDuration(queue.getTaskRunner().getBackend().nanoTime() - startNs));
            }
            return tInvoke;
        } finally {
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                long elapsedNs = queue.getTaskRunner().getBackend().nanoTime() - startNs;
                if (0 != 0) {
                    log($this$logElapsed, task, queue, "finished run in " + formatDuration(elapsedNs));
                } else {
                    log($this$logElapsed, task, queue, "failed a run in " + formatDuration(elapsedNs));
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Logger $this$log, Task task, TaskQueue queue, String message) {
        StringBuilder sbAppend = new StringBuilder().append(queue.getName()).append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%-22s", Arrays.copyOf(new Object[]{message}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        $this$log.fine(sbAppend.append(str).append(": ").append(task.getName()).toString());
    }

    public static final String formatDuration(long ns) {
        String s;
        if (ns <= -999500000) {
            s = ((ns - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (ns <= -999500) {
            s = ((ns - ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS)) + " ms";
        } else if (ns <= 0) {
            s = ((ns - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (ns < 999500) {
            s = ((((long) 500) + ns) / ((long) 1000)) + " µs";
        } else {
            s = ns < 999500000 ? ((((long) 500000) + ns) / ((long) DurationKt.NANOS_IN_MILLIS)) + " ms" : ((((long) 500000000) + ns) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%6s", Arrays.copyOf(new Object[]{s}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }
}
