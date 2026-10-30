package com.videshkarmakar.loop.ui.common;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HapticFeedback.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005J\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/videshkarmakar/loop/ui/common/HapticFeedback;", "", "()V", "longPressHapticFeedback", "", "Landroid/view/View;", "slightHapticFeedback", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HapticFeedback {
    public static final int $stable = 0;
    public static final HapticFeedback INSTANCE = new HapticFeedback();

    private HapticFeedback() {
    }

    public final boolean slightHapticFeedback(View $this$slightHapticFeedback) {
        Intrinsics.checkNotNullParameter($this$slightHapticFeedback, "<this>");
        return $this$slightHapticFeedback.performHapticFeedback(4);
    }

    public final boolean longPressHapticFeedback(View $this$longPressHapticFeedback) {
        Intrinsics.checkNotNullParameter($this$longPressHapticFeedback, "<this>");
        return $this$longPressHapticFeedback.performHapticFeedback(0);
    }
}
