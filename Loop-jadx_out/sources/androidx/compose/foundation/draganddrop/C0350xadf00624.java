package androidx.compose.foundation.draganddrop;

import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1 */
/* JADX INFO: compiled from: AndroidDragAndDropSource.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* synthetic */ class C0350xadf00624 extends FunctionReferenceImpl implements Function1<CacheDrawScope, DrawResult> {
    C0350xadf00624(Object obj) {
        super(1, obj, CacheDrawScopeDragShadowCallback.class, "cachePicture", "cachePicture(Landroidx/compose/ui/draw/CacheDrawScope;)Landroidx/compose/ui/draw/DrawResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DrawResult invoke(CacheDrawScope p0) {
        return ((CacheDrawScopeDragShadowCallback) this.receiver).cachePicture(p0);
    }
}
