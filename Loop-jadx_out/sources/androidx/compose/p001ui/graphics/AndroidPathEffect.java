package androidx.compose.p001ui.graphics;

import android.graphics.PathEffect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidPathEffect.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m195d2 = {"Landroidx/compose/ui/graphics/AndroidPathEffect;", "Landroidx/compose/ui/graphics/PathEffect;", "nativePathEffect", "Landroid/graphics/PathEffect;", "(Landroid/graphics/PathEffect;)V", "getNativePathEffect", "()Landroid/graphics/PathEffect;", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidPathEffect implements PathEffect {
    private final PathEffect nativePathEffect;

    public AndroidPathEffect(PathEffect nativePathEffect) {
        this.nativePathEffect = nativePathEffect;
    }

    public final PathEffect getNativePathEffect() {
        return this.nativePathEffect;
    }
}
