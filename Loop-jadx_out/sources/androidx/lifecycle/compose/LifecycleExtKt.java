package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;

/* JADX INFO: compiled from: LifecycleExt.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m195d2 = {"currentStateAsState", "Landroidx/compose/runtime/State;", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "lifecycle-runtime-compose_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LifecycleExtKt {
    public static final State<Lifecycle.State> currentStateAsState(Lifecycle $this$currentStateAsState, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1892357376);
        ComposerKt.sourceInformation($composer, "C(currentStateAsState)31@1273L16:LifecycleExt.kt#2vxrgp");
        State<Lifecycle.State> stateCollectAsState = SnapshotStateKt.collectAsState($this$currentStateAsState.getCurrentStateFlow(), null, $composer, 0, 1);
        $composer.endReplaceableGroup();
        return stateCollectAsState;
    }
}
