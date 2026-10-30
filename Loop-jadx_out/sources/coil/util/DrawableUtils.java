package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DrawableUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m195d2 = {"Lcoil/util/DrawableUtils;", "", "()V", "DEFAULT_SIZE", "", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Landroid/graphics/Bitmap$Config;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "isConfigValid", "bitmap", "isSizeValid", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DrawableUtils {
    private static final int DEFAULT_SIZE = 512;
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    private DrawableUtils() {
    }

    public final Bitmap convertToBitmap(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean allowInexactSize) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (isConfigValid(bitmap, config) && isSizeValid(allowInexactSize, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable safeDrawable = drawable.mutate();
        int it = Utils.getWidth(safeDrawable);
        if (it <= 0) {
            it = 512;
        }
        int it2 = Utils.getHeight(safeDrawable);
        int it3 = it2 > 0 ? it2 : 512;
        double multiplier = DecodeUtils.computeSizeMultiplier(it, it3, Sizes.isOriginal(size) ? it : Utils.toPx(size.getWidth(), scale), Sizes.isOriginal(size) ? it3 : Utils.toPx(size.getHeight(), scale), scale);
        int bitmapWidth = MathKt.roundToInt(((double) it) * multiplier);
        int bitmapHeight = MathKt.roundToInt(((double) it3) * multiplier);
        Bitmap.Config config$iv = Bitmaps.toSoftware(config);
        Bitmap bitmap2 = Bitmap.createBitmap(bitmapWidth, bitmapHeight, config$iv);
        Rect $this$component1$iv = safeDrawable.getBounds();
        int oldLeft = $this$component1$iv.left;
        int oldTop = $this$component1$iv.top;
        int oldRight = $this$component1$iv.right;
        int oldBottom = $this$component1$iv.bottom;
        safeDrawable.setBounds(0, 0, bitmapWidth, bitmapHeight);
        safeDrawable.draw(new Canvas(bitmap2));
        safeDrawable.setBounds(oldLeft, oldTop, oldRight, oldBottom);
        return bitmap2;
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == Bitmaps.toSoftware(config);
    }

    private final boolean isSizeValid(boolean allowInexactSize, Bitmap bitmap, Size size, Scale scale) {
        if (allowInexactSize) {
            return true;
        }
        return DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), Sizes.isOriginal(size) ? bitmap.getWidth() : Utils.toPx(size.getWidth(), scale), Sizes.isOriginal(size) ? bitmap.getHeight() : Utils.toPx(size.getHeight(), scale), scale) == 1.0d;
    }
}
