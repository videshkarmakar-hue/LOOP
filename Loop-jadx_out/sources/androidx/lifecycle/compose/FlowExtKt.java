package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: FlowExt.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001aI\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000e\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m195d2 = {"collectAsStateWithLifecycle", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "initialValue", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycle-runtime-compose_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FlowExtKt {
    public static final <T> State<T> collectAsStateWithLifecycle(StateFlow<? extends T> stateFlow, LifecycleOwner lifecycleOwner, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(743249048);
        ComposerKt.sourceInformation($composer, "C(collectAsStateWithLifecycle)P(1,2)56@2460L7,59@2600L162:FlowExt.kt#2vxrgp");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer);
            lifecycleOwner = (LifecycleOwner) objConsume;
        }
        if ((i & 2) != 0) {
            minActiveState = Lifecycle.State.STARTED;
        }
        if ((i & 4) != 0) {
            CoroutineContext context2 = EmptyCoroutineContext.INSTANCE;
            context = context2;
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(stateFlow, stateFlow.getValue(), lifecycleOwner.getLifecycleRegistry(), minActiveState, context, $composer, ($changed & 14) | (($changed << 3) & 7168) | (57344 & ($changed << 3)), 0);
        $composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    public static final <T> State<T> collectAsStateWithLifecycle(StateFlow<? extends T> stateFlow, Lifecycle lifecycle, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1858162195);
        ComposerKt.sourceInformation($composer, "C(collectAsStateWithLifecycle)P(1,2)93@4123L147:FlowExt.kt#2vxrgp");
        if ((i & 2) != 0) {
            minActiveState = Lifecycle.State.STARTED;
        }
        if ((i & 4) != 0) {
            CoroutineContext context2 = EmptyCoroutineContext.INSTANCE;
            context = context2;
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(stateFlow, stateFlow.getValue(), lifecycle, minActiveState, context, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168) | (57344 & ($changed << 3)), 0);
        $composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    public static final <T> State<T> collectAsStateWithLifecycle(Flow<? extends T> flow, T t, LifecycleOwner lifecycleOwner, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1485997211);
        ComposerKt.sourceInformation($composer, "C(collectAsStateWithLifecycle)P(1,2,3)128@5650L7,131@5790L164:FlowExt.kt#2vxrgp");
        if ((i & 2) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer);
            lifecycleOwner = (LifecycleOwner) objConsume;
        }
        if ((i & 4) != 0) {
            minActiveState = Lifecycle.State.STARTED;
        }
        if ((i & 8) != 0) {
            CoroutineContext context2 = EmptyCoroutineContext.INSTANCE;
            context = context2;
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(flow, t, lifecycleOwner.getLifecycleRegistry(), minActiveState, context, $composer, ($changed & 14) | ((($changed >> 3) & 8) << 3) | ($changed & 112) | ($changed & 7168) | (57344 & $changed), 0);
        $composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    public static final <T> State<T> collectAsStateWithLifecycle(Flow<? extends T> flow, T t, Lifecycle lifecycle, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(1977777920);
        ComposerKt.sourceInformation($composer, "C(collectAsStateWithLifecycle)P(1,2,3)168@7418L359,168@7349L428:FlowExt.kt#2vxrgp");
        Lifecycle.State minActiveState2 = (i & 4) != 0 ? Lifecycle.State.STARTED : minActiveState;
        CoroutineContext context2 = (i & 8) != 0 ? EmptyCoroutineContext.INSTANCE : context;
        Object[] objArr = {flow, lifecycle, minActiveState2, context2};
        $composer.startReplaceableGroup(-669833712);
        ComposerKt.sourceInformation($composer, "CC(remember):FlowExt.kt#9igjgp");
        boolean invalid$iv = $composer.changed(lifecycle) | $composer.changed(minActiveState2) | $composer.changed(context2) | $composer.changed(flow);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new FlowExtKt$collectAsStateWithLifecycle$1$1(lifecycle, minActiveState2, context2, flow, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer.endReplaceableGroup();
        State<T> stateProduceState = SnapshotStateKt.produceState((Object) t, objArr, (Function2) value$iv, $composer, (($changed >> 3) & 8) | (($changed >> 3) & 14));
        $composer.endReplaceableGroup();
        return stateProduceState;
    }
}
