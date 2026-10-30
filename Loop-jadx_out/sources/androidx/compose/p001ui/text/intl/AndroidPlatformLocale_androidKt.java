package androidx.compose.p001ui.text.intl;

import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidPlatformLocale.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, m195d2 = {"createPlatformLocaleDelegate", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidPlatformLocale_androidKt {
    public static final PlatformLocaleDelegate createPlatformLocaleDelegate() {
        if (Build.VERSION.SDK_INT >= 24) {
            return new AndroidLocaleDelegateAPI24();
        }
        return new AndroidLocaleDelegateAPI23();
    }
}
