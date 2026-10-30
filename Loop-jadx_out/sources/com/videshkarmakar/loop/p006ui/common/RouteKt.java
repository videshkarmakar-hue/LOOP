package com.videshkarmakar.loop.p006ui.common;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u0004¨\u0006\u0004"}, m195d2 = {"arg", "", "id", "", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RouteKt {
    public static final String arg(String $this$arg, String arg) {
        Intrinsics.checkNotNullParameter($this$arg, "<this>");
        Intrinsics.checkNotNullParameter(arg, "arg");
        return $this$arg + "/{" + arg + "}";
    }

    /* JADX INFO: renamed from: id */
    public static final String m184id(String $this$id, int id) {
        Intrinsics.checkNotNullParameter($this$id, "<this>");
        return $this$id + "/" + id;
    }
}
