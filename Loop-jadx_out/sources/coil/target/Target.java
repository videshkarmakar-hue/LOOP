package coil.target;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Target.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0017J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, m195d2 = {"Lcoil/target/Target;", "", "onError", "", "error", "Landroid/graphics/drawable/Drawable;", "onStart", "placeholder", "onSuccess", "result", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface Target {
    void onError(Drawable error);

    void onStart(Drawable placeholder);

    void onSuccess(Drawable result);

    /* JADX INFO: renamed from: coil.target.Target$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: Target.kt */
    public final /* synthetic */ class CC {
        public static void $default$onStart(Target _this, Drawable placeholder) {
        }

        public static void $default$onError(Target _this, Drawable error) {
        }

        public static void $default$onSuccess(Target _this, Drawable result) {
        }
    }

    /* JADX INFO: compiled from: Target.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static void onStart(Target $this, Drawable placeholder) {
            CC.$default$onStart($this, placeholder);
        }

        @Deprecated
        public static void onError(Target $this, Drawable error) {
            CC.$default$onError($this, error);
        }

        @Deprecated
        public static void onSuccess(Target $this, Drawable result) {
            CC.$default$onSuccess($this, result);
        }
    }
}
