package androidx.compose.p001ui.graphics;

import android.graphics.Canvas;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidCanvas.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006*\n\u0010\f\"\u00020\u00012\u00020\u0001¨\u0006\r"}, m195d2 = {"EmptyCanvas", "Landroid/graphics/Canvas;", "nativeCanvas", "Landroidx/compose/ui/graphics/NativeCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "ActualCanvas", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "Canvas", "c", "NativeCanvas", "ui-graphics_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidCanvas_androidKt {
    private static final Canvas EmptyCanvas = new Canvas();

    public static final Canvas ActualCanvas(ImageBitmap image) {
        AndroidCanvas $this$ActualCanvas_u24lambda_u240 = new AndroidCanvas();
        $this$ActualCanvas_u24lambda_u240.setInternalCanvas(new Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(image)));
        return $this$ActualCanvas_u24lambda_u240;
    }

    public static final Canvas Canvas(Canvas c) {
        AndroidCanvas $this$Canvas_u24lambda_u241 = new AndroidCanvas();
        $this$Canvas_u24lambda_u241.setInternalCanvas(c);
        return $this$Canvas_u24lambda_u241;
    }

    public static final Canvas getNativeCanvas(Canvas $this$nativeCanvas) {
        Intrinsics.checkNotNull($this$nativeCanvas, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidCanvas");
        return ((AndroidCanvas) $this$nativeCanvas).getInternalCanvas();
    }
}
