package coil.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.request.DefaultRequestOptions;
import coil.request.ImageRequest;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.ViewSizeResolver;
import coil.target.ViewTarget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: coil.util.-Requests, reason: invalid class name */
/* JADX INFO: compiled from: Requests.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a3\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u000f\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, m195d2 = {"DEFAULT_REQUEST_OPTIONS", "Lcoil/request/DefaultRequestOptions;", "getDEFAULT_REQUEST_OPTIONS", "()Lcoil/request/DefaultRequestOptions;", "allowInexactSize", "", "Lcoil/request/ImageRequest;", "getAllowInexactSize", "(Lcoil/request/ImageRequest;)Z", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "drawable", "resId", "", "default", "(Lcoil/request/ImageRequest;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "coil-base_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Requests {
    private static final DefaultRequestOptions DEFAULT_REQUEST_OPTIONS = new DefaultRequestOptions(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);

    /* JADX INFO: renamed from: coil.util.-Requests$WhenMappings */
    /* JADX INFO: compiled from: Requests.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Precision.values().length];
            try {
                iArr[Precision.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Precision.INEXACT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Precision.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DefaultRequestOptions getDEFAULT_REQUEST_OPTIONS() {
        return DEFAULT_REQUEST_OPTIONS;
    }

    public static final Drawable getDrawableCompat(ImageRequest $this$getDrawableCompat, Drawable drawable, Integer resId, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (resId == null) {
            return drawable2;
        }
        if (resId.intValue() == 0) {
            return null;
        }
        return Contexts.getDrawableCompat($this$getDrawableCompat.getContext(), resId.intValue());
    }

    public static final boolean getAllowInexactSize(ImageRequest $this$allowInexactSize) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$allowInexactSize.getPrecision().ordinal()]) {
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                if ($this$allowInexactSize.getDefined().getSizeResolver() == null && ($this$allowInexactSize.getSizeResolver() instanceof DisplaySizeResolver)) {
                    return true;
                }
                return ($this$allowInexactSize.getTarget() instanceof ViewTarget) && ($this$allowInexactSize.getSizeResolver() instanceof ViewSizeResolver) && (((ViewTarget) $this$allowInexactSize.getTarget()).getView() instanceof ImageView) && ((ViewTarget) $this$allowInexactSize.getTarget()).getView() == ((ViewSizeResolver) $this$allowInexactSize.getSizeResolver()).getView();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
