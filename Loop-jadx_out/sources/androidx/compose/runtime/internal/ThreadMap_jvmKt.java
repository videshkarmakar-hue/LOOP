package androidx.compose.runtime.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ThreadMap.jvm.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m195d2 = {"emptyThreadMap", "Landroidx/compose/runtime/internal/ThreadMap;", "getEmptyThreadMap", "()Landroidx/compose/runtime/internal/ThreadMap;", "runtime_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ThreadMap_jvmKt {
    private static final ThreadMap emptyThreadMap = new ThreadMap(0, new long[0], new Object[0]);

    public static final ThreadMap getEmptyThreadMap() {
        return emptyThreadMap;
    }
}
