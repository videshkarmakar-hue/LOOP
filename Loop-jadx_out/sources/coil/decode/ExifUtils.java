package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import coil.util.Bitmaps;
import kotlin.Metadata;
import okio.BufferedSource;

/* JADX INFO: compiled from: ExifUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m195d2 = {"Lcoil/decode/ExifUtils;", "", "()V", "PAINT", "Landroid/graphics/Paint;", "getExifData", "Lcoil/decode/ExifData;", "mimeType", "", "source", "Lokio/BufferedSource;", "policy", "Lcoil/decode/ExifOrientationPolicy;", "reverseTransformations", "Landroid/graphics/Bitmap;", "inBitmap", "exifData", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExifUtils {
    public static final ExifUtils INSTANCE = new ExifUtils();
    private static final Paint PAINT = new Paint(3);

    private ExifUtils() {
    }

    public final ExifData getExifData(String mimeType, BufferedSource source, ExifOrientationPolicy policy) {
        if (ExifUtilsKt.supports(policy, mimeType)) {
            ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(source.peek().inputStream()));
            return new ExifData(exifInterface.isFlipped(), exifInterface.getRotationDegrees());
        }
        return ExifData.NONE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0065  */
    public final Bitmap reverseTransformations(Bitmap inBitmap, ExifData exifData) {
        Bitmap outBitmap;
        if (!exifData.getIsFlipped() && !ExifUtilsKt.isRotated(exifData)) {
            return inBitmap;
        }
        Matrix matrix = new Matrix();
        float centerX = inBitmap.getWidth() / 2.0f;
        float centerY = inBitmap.getHeight() / 2.0f;
        if (exifData.getIsFlipped()) {
            matrix.postScale(-1.0f, 1.0f, centerX, centerY);
        }
        if (ExifUtilsKt.isRotated(exifData)) {
            matrix.postRotate(exifData.getRotationDegrees(), centerX, centerY);
        }
        RectF rect = new RectF(0.0f, 0.0f, inBitmap.getWidth(), inBitmap.getHeight());
        matrix.mapRect(rect);
        if (rect.left == 0.0f) {
            if (!(rect.top == 0.0f)) {
                matrix.postTranslate(-rect.left, -rect.top);
            }
        } else {
            matrix.postTranslate(-rect.left, -rect.top);
        }
        if (ExifUtilsKt.isSwapped(exifData)) {
            int width$iv = inBitmap.getHeight();
            int height$iv = inBitmap.getWidth();
            Bitmap.Config config$iv = Bitmaps.getSafeConfig(inBitmap);
            outBitmap = Bitmap.createBitmap(width$iv, height$iv, config$iv);
        } else {
            int width$iv2 = inBitmap.getWidth();
            int height$iv2 = inBitmap.getHeight();
            Bitmap.Config config$iv2 = Bitmaps.getSafeConfig(inBitmap);
            outBitmap = Bitmap.createBitmap(width$iv2, height$iv2, config$iv2);
        }
        Bitmap $this$applyCanvas$iv = outBitmap;
        Canvas c$iv = new Canvas($this$applyCanvas$iv);
        c$iv.drawBitmap(inBitmap, matrix, PAINT);
        inBitmap.recycle();
        return outBitmap;
    }
}
