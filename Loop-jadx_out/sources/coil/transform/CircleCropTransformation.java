package coil.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.size.Size;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CircleCropTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m195d2 = {"Lcoil/transform/CircleCropTransformation;", "Lcoil/transform/Transformation;", "()V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "transform", "Landroid/graphics/Bitmap;", "input", "size", "Lcoil/size/Size;", "(Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CircleCropTransformation implements Transformation {
    private final String cacheKey = getClass().getName();

    @Override // coil.transform.Transformation
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil.transform.Transformation
    public Object transform(Bitmap input, Size size, Continuation<? super Bitmap> continuation) {
        Paint paint = new Paint(3);
        int minSize = Math.min(input.getWidth(), input.getHeight());
        float radius = minSize / 2.0f;
        Bitmap.Config config$iv = Bitmaps.getSafeConfig(input);
        Bitmap output = Bitmap.createBitmap(minSize, minSize, config$iv);
        Canvas c$iv = new Canvas(output);
        c$iv.drawCircle(radius, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        c$iv.drawBitmap(input, radius - (input.getWidth() / 2.0f), radius - (input.getHeight() / 2.0f), paint);
        return output;
    }

    public boolean equals(Object other) {
        return other instanceof CircleCropTransformation;
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}
