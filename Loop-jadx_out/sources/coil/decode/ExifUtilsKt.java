package coil.decode;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.util.Utils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: ExifUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\b\u001a\u00020\u0004*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u000b"}, m195d2 = {"RESPECT_PERFORMANCE_MIME_TYPES", "", "", "isRotated", "", "Lcoil/decode/ExifData;", "(Lcoil/decode/ExifData;)Z", "isSwapped", "supports", "Lcoil/decode/ExifOrientationPolicy;", "mimeType", "coil-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExifUtilsKt {
    private static final Set<String> RESPECT_PERFORMANCE_MIME_TYPES = SetsKt.setOf((Object[]) new String[]{Utils.MIME_TYPE_JPEG, Utils.MIME_TYPE_WEBP, Utils.MIME_TYPE_HEIC, Utils.MIME_TYPE_HEIF});

    /* JADX INFO: compiled from: ExifUtils.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExifOrientationPolicy.values().length];
            try {
                iArr[ExifOrientationPolicy.RESPECT_PERFORMANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ExifOrientationPolicy.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ExifOrientationPolicy.RESPECT_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSwapped(ExifData $this$isSwapped) {
        return $this$isSwapped.getRotationDegrees() == 90 || $this$isSwapped.getRotationDegrees() == 270;
    }

    public static final boolean isRotated(ExifData $this$isRotated) {
        return $this$isRotated.getRotationDegrees() > 0;
    }

    public static final boolean supports(ExifOrientationPolicy $this$supports, String mimeType) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$supports.ordinal()]) {
            case 1:
                return mimeType != null && RESPECT_PERFORMANCE_MIME_TYPES.contains(mimeType);
            case 2:
                return false;
            case 3:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
