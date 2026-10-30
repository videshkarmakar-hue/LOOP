package androidx.compose.p001ui.state;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: ToggleableState.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m195d2 = {"ToggleableState", "Landroidx/compose/ui/state/ToggleableState;", DownloadUtil.CookieScheme.VALUE, "", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ToggleableStateKt {
    public static final ToggleableState ToggleableState(boolean value) {
        return value ? ToggleableState.On : ToggleableState.Off;
    }
}
