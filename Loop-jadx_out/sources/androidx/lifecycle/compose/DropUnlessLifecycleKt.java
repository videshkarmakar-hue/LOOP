package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DropUnlessLifecycle.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m195d2 = {"dropUnlessResumed", "Lkotlin/Function0;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "block", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "dropUnlessStarted", "dropUnlessStateIsAtLeast", "state", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "lifecycle-runtime-compose_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DropUnlessLifecycleKt {
    private static final Function0<Unit> dropUnlessStateIsAtLeast(final Lifecycle.State state, final LifecycleOwner lifecycleOwner, final Function0<Unit> function0, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(-2057956404);
        ComposerKt.sourceInformation($composer, "C(dropUnlessStateIsAtLeast)P(2,1)48@1927L7,56@2225L107:DropUnlessLifecycle.kt#2vxrgp");
        if ((i & 2) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer);
            lifecycleOwner = (LifecycleOwner) objConsume;
        }
        if (!(state != Lifecycle.State.DESTROYED)) {
            throw new IllegalArgumentException("Target state is not allowed to be `Lifecycle.State.DESTROYED` because Compose disposes of the composition before `Lifecycle.Event.ON_DESTROY` observers are invoked.".toString());
        }
        $composer.startReplaceableGroup(-2059970288);
        ComposerKt.sourceInformation($composer, "CC(remember):DropUnlessLifecycle.kt#9igjgp");
        boolean invalid$iv = $composer.changed(lifecycleOwner) | $composer.changed(state) | $composer.changed(function0);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0<Unit>() { // from class: androidx.lifecycle.compose.DropUnlessLifecycleKt$dropUnlessStateIsAtLeast$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (lifecycleOwner.getLifecycleRegistry().getState().isAtLeast(state)) {
                        function0.invoke();
                    }
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        Function0<Unit> function1 = (Function0) value$iv;
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return function1;
    }

    public static final Function0<Unit> dropUnlessStarted(LifecycleOwner lifecycleOwner, Function0<Unit> function0, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1207869935);
        ComposerKt.sourceInformation($composer, "C(dropUnlessStarted)P(1)80@3057L7,82@3105L62:DropUnlessLifecycle.kt#2vxrgp");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer);
            lifecycleOwner = (LifecycleOwner) objConsume;
        }
        Function0<Unit> function0DropUnlessStateIsAtLeast = dropUnlessStateIsAtLeast(Lifecycle.State.STARTED, lifecycleOwner, function0, $composer, (($changed << 3) & 112) | 6 | (($changed << 3) & 896), 0);
        $composer.endReplaceableGroup();
        return function0DropUnlessStateIsAtLeast;
    }

    public static final Function0<Unit> dropUnlessResumed(LifecycleOwner lifecycleOwner, Function0<Unit> function0, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1331131589);
        ComposerKt.sourceInformation($composer, "C(dropUnlessResumed)P(1)104@4047L7,106@4095L62:DropUnlessLifecycle.kt#2vxrgp");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd($composer);
            lifecycleOwner = (LifecycleOwner) objConsume;
        }
        Function0<Unit> function0DropUnlessStateIsAtLeast = dropUnlessStateIsAtLeast(Lifecycle.State.RESUMED, lifecycleOwner, function0, $composer, (($changed << 3) & 112) | 6 | (($changed << 3) & 896), 0);
        $composer.endReplaceableGroup();
        return function0DropUnlessStateIsAtLeast;
    }
}
