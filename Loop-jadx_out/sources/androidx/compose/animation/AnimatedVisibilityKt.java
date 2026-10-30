package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AnimatedVisibility.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0091\u0001\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aa\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010 \u001aJ\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00012\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00070\"¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010#\u001a[\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010$\u001ak\u0010%\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010&\u001am\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010'\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020(2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010)\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020(2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010*\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020+2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010,\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020+2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010-\u001a9\u0010.\u001a\u00020\u0003\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010/\u001a\u0002H\bH\u0003¢\u0006\u0002\u00100\"\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u00061²\u0006\"\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\"\u0004\b\u0000\u0010\bX\u008a\u0084\u0002²\u0006\u0010\u00103\u001a\u00020\u0001\"\u0004\b\u0000\u0010\bX\u008a\u0084\u0002"}, m195d2 = {"exitFinished", "", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "AnimatedEnterExitImpl", "", ExifInterface.GPS_DIRECTION_TRUE, "transition", "visible", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "shouldDisposeBlock", "Lkotlin/Function2;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "initiallyVisible", "Lkotlin/Function0;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnimatedVisibilityKt {
    public static final void AnimatedVisibility(final boolean visible, Modifier modifier, EnterTransition enter, ExitTransition exit, String label, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        EnterTransition enterTransition;
        ExitTransition exitTransition;
        String label2;
        Modifier modifier3;
        ExitTransition exit2;
        String label3;
        EnterTransition enter2;
        Composer $composer2 = $composer.startRestartGroup(2088733774);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)134@7013L32,135@7050L84:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(visible) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            enterTransition = enter;
        } else if (($changed & 384) == 0) {
            enterTransition = enter;
            $dirty |= $composer2.changed(enterTransition) ? 256 : 128;
        } else {
            enterTransition = enter;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            exitTransition = exit;
        } else if (($changed & 3072) == 0) {
            exitTransition = exit;
            $dirty |= $composer2.changed(exitTransition) ? 2048 : 1024;
        } else {
            exitTransition = exit;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            label2 = label;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 16384 : 8192;
        } else {
            label2 = label;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            exit2 = exitTransition;
            label3 = label2;
            enter2 = enterTransition;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            EnterTransition enter3 = i3 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition;
            exit2 = i4 != 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition;
            if (i5 != 0) {
                label2 = "AnimatedVisibility";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2088733774, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:133)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(visible), label2, $composer2, ($dirty2 & 14) | (($dirty2 >> 9) & 112), 0);
            AnimatedVisibilityImpl(transition, new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.1
                public final Boolean invoke(boolean it) {
                    return Boolean.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier3, enter3, exit2, function3, $composer2, (($dirty2 << 3) & 896) | 48 | (($dirty2 << 3) & 7168) | (($dirty2 << 3) & 57344) | (458752 & $dirty2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label3 = label2;
            enter2 = enter3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final EnterTransition enterTransition2 = enter2;
            final ExitTransition exitTransition2 = exit2;
            final String str = label3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AnimatedVisibilityKt.AnimatedVisibility(visible, modifier4, enterTransition2, exitTransition2, str, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void AnimatedVisibility(final RowScope $this$AnimatedVisibility, final boolean visible, Modifier modifier, EnterTransition enter, ExitTransition exit, String label, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        EnterTransition enterTransition;
        ExitTransition exitTransition;
        String label2;
        Modifier modifier3;
        String label3;
        ExitTransition exit2;
        EnterTransition enter2;
        Composer $composer2 = $composer.startRestartGroup(-1741346906);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)209@11318L32,210@11355L84:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(visible) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 3072;
            enterTransition = enter;
        } else if (($changed & 3072) == 0) {
            enterTransition = enter;
            $dirty |= $composer2.changed(enterTransition) ? 2048 : 1024;
        } else {
            enterTransition = enter;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            exitTransition = exit;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            exitTransition = exit;
            $dirty |= $composer2.changed(exitTransition) ? 16384 : 8192;
        } else {
            exitTransition = exit;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            label2 = label;
        } else if ((196608 & $changed) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 131072 : 65536;
        } else {
            label2 = label;
        }
        if ((i & 32) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ((599185 & $dirty2) == 599184 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enter2 = enterTransition;
            exit2 = exitTransition;
            label3 = label2;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            EnterTransition enter3 = i3 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null)) : enterTransition;
            ExitTransition exit3 = i4 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null)) : exitTransition;
            if (i5 != 0) {
                label2 = "AnimatedVisibility";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1741346906, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:208)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(visible), label2, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 12) & 112), 0);
            AnimatedVisibilityImpl(transition, new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.3
                public final Boolean invoke(boolean it) {
                    return Boolean.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier3, enter3, exit3, function3, $composer2, ($dirty2 & 896) | 48 | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty2 >> 3) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label3 = label2;
            exit2 = exit3;
            enter2 = enter3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final EnterTransition enterTransition2 = enter2;
            final ExitTransition exitTransition2 = exit2;
            final String str = label3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AnimatedVisibilityKt.AnimatedVisibility($this$AnimatedVisibility, visible, modifier4, enterTransition2, exitTransition2, str, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void AnimatedVisibility(final ColumnScope $this$AnimatedVisibility, final boolean visible, Modifier modifier, EnterTransition enter, ExitTransition exit, String label, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        EnterTransition enterTransition;
        ExitTransition exitTransition;
        String label2;
        Modifier modifier3;
        String label3;
        ExitTransition exit2;
        EnterTransition enter2;
        Composer $composer2 = $composer.startRestartGroup(1766503102);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)282@15601L32,283@15638L84:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(visible) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 3072;
            enterTransition = enter;
        } else if (($changed & 3072) == 0) {
            enterTransition = enter;
            $dirty |= $composer2.changed(enterTransition) ? 2048 : 1024;
        } else {
            enterTransition = enter;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            exitTransition = exit;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            exitTransition = exit;
            $dirty |= $composer2.changed(exitTransition) ? 16384 : 8192;
        } else {
            exitTransition = exit;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            label2 = label;
        } else if ((196608 & $changed) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 131072 : 65536;
        } else {
            label2 = label;
        }
        if ((i & 32) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ((599185 & $dirty2) == 599184 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enter2 = enterTransition;
            exit2 = exitTransition;
            label3 = label2;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            EnterTransition enter3 = i3 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null)) : enterTransition;
            ExitTransition exit3 = i4 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null)) : exitTransition;
            if (i5 != 0) {
                label2 = "AnimatedVisibility";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1766503102, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:281)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(visible), label2, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 12) & 112), 0);
            AnimatedVisibilityImpl(transition, new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.5
                public final Boolean invoke(boolean it) {
                    return Boolean.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier3, enter3, exit3, function3, $composer2, ($dirty2 & 896) | 48 | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty2 >> 3) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label3 = label2;
            exit2 = exit3;
            enter2 = enter3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final EnterTransition enterTransition2 = enter2;
            final ExitTransition exitTransition2 = exit2;
            final String str = label3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AnimatedVisibilityKt.AnimatedVisibility($this$AnimatedVisibility, visible, modifier4, enterTransition2, exitTransition2, str, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void AnimatedVisibility(final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enter, ExitTransition exit, String label, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        EnterTransition enterTransition;
        ExitTransition exitTransition;
        String label2;
        Modifier modifier3;
        ExitTransition exit2;
        String label3;
        EnterTransition enter2;
        Composer $composer2 = $composer.startRestartGroup(-222898426);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)388@21027L39,389@21071L84:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(mutableTransitionState) : $composer2.changedInstance(mutableTransitionState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            enterTransition = enter;
        } else if (($changed & 384) == 0) {
            enterTransition = enter;
            $dirty |= $composer2.changed(enterTransition) ? 256 : 128;
        } else {
            enterTransition = enter;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            exitTransition = exit;
        } else if (($changed & 3072) == 0) {
            exitTransition = exit;
            $dirty |= $composer2.changed(exitTransition) ? 2048 : 1024;
        } else {
            exitTransition = exit;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            label2 = label;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 16384 : 8192;
        } else {
            label2 = label;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            exit2 = exitTransition;
            label3 = label2;
            enter2 = enterTransition;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            EnterTransition enter3 = i3 != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition;
            exit2 = i4 != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null)) : exitTransition;
            if (i5 != 0) {
                label2 = "AnimatedVisibility";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-222898426, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:387)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, label2, $composer2, MutableTransitionState.$stable | ($dirty2 & 14) | (($dirty2 >> 9) & 112), 0);
            AnimatedVisibilityImpl(transition, new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.7
                public final Boolean invoke(boolean it) {
                    return Boolean.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier3, enter3, exit2, function3, $composer2, (($dirty2 << 3) & 896) | 48 | (($dirty2 << 3) & 7168) | (($dirty2 << 3) & 57344) | (458752 & $dirty2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label3 = label2;
            enter2 = enter3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final EnterTransition enterTransition2 = enter2;
            final ExitTransition exitTransition2 = exit2;
            final String str = label3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier4, enterTransition2, exitTransition2, str, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void AnimatedVisibility(final RowScope $this$AnimatedVisibility, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enter, ExitTransition exit, String label, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        EnterTransition enterTransition;
        ExitTransition exitTransition;
        String label2;
        Modifier modifier3;
        ExitTransition exit2;
        EnterTransition enter2;
        String label3;
        Composer $composer2 = $composer.startRestartGroup(836509870);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)463@25390L39,464@25434L84:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(mutableTransitionState) : $composer2.changedInstance(mutableTransitionState) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 3072;
            enterTransition = enter;
        } else if (($changed & 3072) == 0) {
            enterTransition = enter;
            $dirty |= $composer2.changed(enterTransition) ? 2048 : 1024;
        } else {
            enterTransition = enter;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            exitTransition = exit;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            exitTransition = exit;
            $dirty |= $composer2.changed(exitTransition) ? 16384 : 8192;
        } else {
            exitTransition = exit;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            label2 = label;
        } else if ((196608 & $changed) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 131072 : 65536;
        } else {
            label2 = label;
        }
        if ((i & 32) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ((599185 & $dirty2) == 599184 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enter2 = enterTransition;
            exit2 = exitTransition;
            label3 = label2;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            EnterTransition enter3 = i3 != 0 ? EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)) : enterTransition;
            exit2 = i4 != 0 ? EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition;
            if (i5 != 0) {
                label2 = "AnimatedVisibility";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(836509870, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:462)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, label2, $composer2, MutableTransitionState.$stable | (($dirty2 >> 3) & 14) | (($dirty2 >> 12) & 112), 0);
            AnimatedVisibilityImpl(transition, new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.9
                public final Boolean invoke(boolean it) {
                    return Boolean.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier3, enter3, exit2, function3, $composer2, ($dirty2 & 896) | 48 | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty2 >> 3) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            enter2 = enter3;
            label3 = label2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final EnterTransition enterTransition2 = enter2;
            final ExitTransition exitTransition2 = exit2;
            final String str = label3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AnimatedVisibilityKt.AnimatedVisibility($this$AnimatedVisibility, mutableTransitionState, modifier4, enterTransition2, exitTransition2, str, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void AnimatedVisibility(final ColumnScope $this$AnimatedVisibility, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enter, ExitTransition exit, String label, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        EnterTransition enterTransition;
        ExitTransition exitTransition;
        String label2;
        Modifier modifier3;
        ExitTransition exit2;
        EnterTransition enter2;
        String label3;
        Composer $composer2 = $composer.startRestartGroup(-850656618);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)539@29845L39,540@29889L84:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(mutableTransitionState) : $composer2.changedInstance(mutableTransitionState) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 3072;
            enterTransition = enter;
        } else if (($changed & 3072) == 0) {
            enterTransition = enter;
            $dirty |= $composer2.changed(enterTransition) ? 2048 : 1024;
        } else {
            enterTransition = enter;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            exitTransition = exit;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            exitTransition = exit;
            $dirty |= $composer2.changed(exitTransition) ? 16384 : 8192;
        } else {
            exitTransition = exit;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            label2 = label;
        } else if ((196608 & $changed) == 0) {
            label2 = label;
            $dirty |= $composer2.changed(label2) ? 131072 : 65536;
        } else {
            label2 = label;
        }
        if ((i & 32) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ((599185 & $dirty2) == 599184 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enter2 = enterTransition;
            exit2 = exitTransition;
            label3 = label2;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            EnterTransition enter3 = i3 != 0 ? EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)) : enterTransition;
            exit2 = i4 != 0 ? EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition;
            if (i5 != 0) {
                label2 = "AnimatedVisibility";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850656618, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:538)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, label2, $composer2, MutableTransitionState.$stable | (($dirty2 >> 3) & 14) | (($dirty2 >> 12) & 112), 0);
            AnimatedVisibilityImpl(transition, new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.11
                public final Boolean invoke(boolean it) {
                    return Boolean.valueOf(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier3, enter3, exit2, function3, $composer2, ($dirty2 & 896) | 48 | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty2 >> 3) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            enter2 = enter3;
            label3 = label2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final EnterTransition enterTransition2 = enter2;
            final ExitTransition exitTransition2 = exit2;
            final String str = label3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AnimatedVisibilityKt.AnimatedVisibility($this$AnimatedVisibility, mutableTransitionState, modifier4, enterTransition2, exitTransition2, str, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final <T> void AnimatedVisibility(final Transition<T> transition, final Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enter, ExitTransition exit, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        EnterTransition enterTransition;
        ExitTransition exitTransition;
        Modifier modifier3;
        EnterTransition enter2;
        ExitTransition exit2;
        Composer $composer2 = $composer.startRestartGroup(1031950689);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(4,3,1,2)613@34218L79:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(transition) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 3072;
            enterTransition = enter;
        } else if (($changed & 3072) == 0) {
            enterTransition = enter;
            $dirty |= $composer2.changed(enterTransition) ? 2048 : 1024;
        } else {
            enterTransition = enter;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            exitTransition = exit;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            exitTransition = exit;
            $dirty |= $composer2.changed(exitTransition) ? 16384 : 8192;
        } else {
            exitTransition = exit;
        }
        if ((i & 16) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enter2 = enterTransition;
            exit2 = exitTransition;
        } else {
            if (i2 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                enter2 = enterTransition;
            } else {
                enter2 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            }
            if (i4 != 0) {
                exit2 = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            } else {
                exit2 = exitTransition;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1031950689, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:613)");
            }
            AnimatedVisibilityImpl(transition, function1, modifier3, enter2, exit2, function3, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final EnterTransition enterTransition2 = enter2;
            final ExitTransition exitTransition2 = exit2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier4, enterTransition2, exitTransition2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "AnimatedVisibility no longer accepts initiallyVisible as a parameter, please use AnimatedVisibility(MutableTransitionState, Modifier, ...) API instead", replaceWith = @ReplaceWith(expression = "AnimatedVisibility(transitionState = remember { MutableTransitionState(initiallyVisible) }\n.apply { targetState = visible },\nmodifier = modifier,\nenter = enter,\nexit = exit) {\ncontent() \n}", imports = {"androidx.compose.animation.core.MutableTransitionState"}))
    public static final void AnimatedVisibility(final boolean visible, Modifier modifier, final EnterTransition enter, final ExitTransition exit, final boolean initiallyVisible, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1121582420);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibility)P(5,4,1,2,3)*716@39055L53,721@39213L17,715@39016L214:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(visible) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enter) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(exit) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(initiallyVisible) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121582420, $dirty, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:715)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1845002991, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MutableTransitionState(Boolean.valueOf(initiallyVisible));
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableTransitionState $this$AnimatedVisibility_u24lambda_u241 = (MutableTransitionState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $this$AnimatedVisibility_u24lambda_u241.setTargetState$animation_core_release(Boolean.valueOf(visible));
            AnimatedVisibility((MutableTransitionState<Boolean>) $this$AnimatedVisibility_u24lambda_u241, modifier4, enter, exit, (String) null, ComposableLambdaKt.rememberComposableLambda(1996320812, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.16
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                    invoke(animatedVisibilityScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C722@39219L9:AnimatedVisibility.kt#xbi5r1");
                    if (($changed2 & 17) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1996320812, $changed2, -1, "androidx.compose.animation.AnimatedVisibility.<anonymous> (AnimatedVisibility.kt:722)");
                    }
                    function2.invoke($composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, MutableTransitionState.$stable | ProfileVerifier.CompilationStatus.f245xf2722a21 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.17
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    AnimatedVisibilityKt.AnimatedVisibility(visible, modifier5, enter, exit, initiallyVisible, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final <T> void AnimatedVisibilityImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enter, final ExitTransition exit, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(429978603);
        ComposerKt.sourceInformation($composer2, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)744@39958L415,741@39840L703:AnimatedVisibility.kt#xbi5r1");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(transition) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(enter) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(exit) ? 16384 : 8192;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429978603, $dirty2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:740)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2055976906, "CC(remember):AnimatedVisibility.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m314invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m314invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        long jIntSize;
                        final Placeable placeableMo5644measureBRTryo0 = measurable.mo5644measureBRTryo0(j);
                        if (measureScope.isLookingAhead() && !function1.invoke((T) transition.getTargetState()).booleanValue()) {
                            jIntSize = IntSize.INSTANCE.m6980getZeroYbymL2g();
                        } else {
                            jIntSize = IntSizeKt.IntSize(placeableMo5644measureBRTryo0.getWidth(), placeableMo5644measureBRTryo0.getHeight());
                        }
                        return MeasureScope.CC.layout$default(measureScope, IntSize.m6975getWidthimpl(jIntSize), IntSize.m6974getHeightimpl(jIntSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                Placeable.PlacementScope.place$default($this$layout, placeableMo5644measureBRTryo0, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AnimatedEnterExitImpl(transition, function1, LayoutModifierKt.layout(modifier, (Function3) value$iv), enter, exit, new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.2
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(EnterExitState current, EnterExitState target) {
                    return Boolean.valueOf(current == target && target == EnterExitState.PostExit);
                }
            }, null, function3, $composer2, ($dirty2 & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21 | ($dirty2 & 112) | ($dirty2 & 7168) | (57344 & $dirty2) | (29360128 & ($dirty2 << 6)), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enter, exit, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x014f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0172  */
    /* JADX WARN: Code duplicated, block: B:113:0x017b  */
    /* JADX WARN: Code duplicated, block: B:119:0x018f  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:128:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:131:0x01df  */
    /* JADX WARN: Code duplicated, block: B:134:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:137:0x021f  */
    /* JADX WARN: Code duplicated, block: B:138:0x022c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0242  */
    /* JADX WARN: Code duplicated, block: B:144:0x0292  */
    /* JADX WARN: Code duplicated, block: B:148:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:151:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:155:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:157:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:158:0x02df  */
    /* JADX WARN: Code duplicated, block: B:161:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:165:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:168:0x0337  */
    /* JADX WARN: Code duplicated, block: B:170:0x0349  */
    /* JADX WARN: Code duplicated, block: B:176:0x0356  */
    /* JADX WARN: Code duplicated, block: B:179:0x0361  */
    /* JADX WARN: Code duplicated, block: B:183:0x036e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:186:0x038b  */
    /* JADX WARN: Code duplicated, block: B:189:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:190:0x03be  */
    /* JADX WARN: Code duplicated, block: B:193:0x0408  */
    /* JADX WARN: Code duplicated, block: B:196:0x0414  */
    /* JADX WARN: Code duplicated, block: B:197:0x0418  */
    /* JADX WARN: Code duplicated, block: B:200:0x0446  */
    /* JADX WARN: Code duplicated, block: B:204:0x045c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:209:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:213:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:214:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:92:0x010b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x010d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0115  */
    /* JADX WARN: Code duplicated, block: B:99:0x012b  */
    public static final <T> void AnimatedEnterExitImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enter, final ExitTransition exit, final Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, OnLookaheadMeasured onLookaheadMeasured, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        int i2;
        boolean invalid$iv$iv;
        Object value$iv$iv;
        Object initialParentState$iv;
        Object it;
        int $changed2;
        int $changed3;
        int $dirty;
        Transition childTransition;
        State shouldDisposeBlockUpdated$delegate;
        boolean invalid$iv;
        C0178xd7829780 value$iv;
        boolean z;
        boolean invalid$iv2;
        Object value$iv2;
        AnimatedVisibilityScopeImpl scope;
        Modifier.Companion companionLayout;
        Object it$iv;
        Object value$iv3;
        int compositeKeyHash$iv;
        Function0<ComposeUiNode> constructor;
        Composer $this$Layout_u24lambda_u240$iv;
        boolean invalid$iv3;
        Object value$iv4;
        OnLookaheadMeasured onLookaheadMeasured2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final OnLookaheadMeasured onLookaheadMeasured3 = onLookaheadMeasured;
        Composer $composer2 = $composer.startRestartGroup(-891967166);
        ComposerKt.sourceInformation($composer2, "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4)789@41355L116,793@41514L40,800@41769L399,795@41594L574,816@42266L69,820@42481L39,834@43226L50,817@42348L942:AnimatedVisibility.kt#xbi5r1");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(transition) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(enter) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(exit) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 131072 : 65536;
        }
        int i3 = i & 64;
        int i4 = 1572864;
        if (i3 != 0) {
            $dirty2 |= i4;
        } else if ((1572864 & $changed) == 0) {
            i4 = ($changed & 2097152) == 0 ? $composer2.changed(onLookaheadMeasured3) : $composer2.changedInstance(onLookaheadMeasured3) ? 1048576 : 524288;
            $dirty2 |= i4;
        }
        if ((i & 128) == 0) {
            if ((12582912 & $changed) == 0) {
                i2 = $composer2.changedInstance(function3) ? 8388608 : 4194304;
            }
            if ((4793491 & $dirty2) == 4793490 || !$composer2.getSkipping()) {
                if (i3 != 0) {
                    onLookaheadMeasured3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891967166, $dirty2, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:785)");
                }
                if (!function1.invoke(transition.getTargetState()).booleanValue() || function1.invoke(transition.getCurrentState()).booleanValue() || transition.isSeeking() || transition.getHasInitialValueAnimations()) {
                    int $changed$iv = ($dirty2 & 14) | 48;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1215497572, "CC(createChildTransition)1787@72932L36,1788@72992L74,1789@73089L39,1790@73140L63:Transition.kt#pdpnli");
                    ComposerKt.sourceInformationMarkerStart($composer2, 1117150131, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv = ((($changed$iv & 14) ^ 6) <= 4 && $composer2.changed(transition)) || ($changed$iv & 6) == 4;
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (!invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = transition.getCurrentState();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    initialParentState$iv = value$iv$iv;
                    if (transition.isSeeking()) {
                        it = transition.getCurrentState();
                    } else {
                        it = initialParentState$iv;
                    }
                    $changed2 = ($changed$iv >> 3) & 112;
                    $composer2.startReplaceGroup(-466616829);
                    ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-466616829, $changed2, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                    }
                    Object initialState$iv = targetEnterExit(transition, function1, it, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed2 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object it2 = transition.getTargetState();
                    $changed3 = ($changed$iv >> 3) & 112;
                    $composer2.startReplaceGroup(-466616829);
                    ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-466616829, $changed3, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                    }
                    Object targetState$iv = targetEnterExit(transition, function1, it2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed3 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    $dirty = $dirty2;
                    childTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, initialState$iv, targetState$iv, "EnterExitTransition", $composer2, ($changed$iv & 14) | (($changed$iv << 6) & 7168));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    shouldDisposeBlockUpdated$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty >> 15) & 14);
                    Boolean boolInvoke = function2.invoke(childTransition.getCurrentState(), childTransition.getTargetState());
                    ComposerKt.sourceInformationMarkerStart($composer2, -918808031, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    invalid$iv = $composer2.changed(childTransition) | $composer2.changed(shouldDisposeBlockUpdated$delegate);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    State shouldDisposeAfterExit$delegate = SnapshotStateKt.produceState(boolInvoke, (Function2) value$iv, $composer2, 0);
                    if (getExitFinished(childTransition) || !AnimatedEnterExitImpl$lambda$6(shouldDisposeAfterExit$delegate)) {
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 14) == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        invalid$iv2 = z;
                        Object it$iv3 = $composer2.rememberedValue();
                        if (!invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                            $composer2.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv3;
                        }
                        scope = (AnimatedVisibilityScopeImpl) value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Modifier modifierCreateModifier = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                        $composer2.startReplaceGroup(-918807249);
                        ComposerKt.sourceInformation($composer2, "822@42630L499");
                        if (onLookaheadMeasured3 != null) {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            if (($dirty & 3670016) != 1048576 || (($dirty & 2097152) != 0 && $composer2.changedInstance(onLookaheadMeasured3))) {
                                invalid$iv3 = true;
                            } else {
                                invalid$iv3 = false;
                            }
                            Object it$iv4 = $composer2.rememberedValue();
                            if (!invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                        return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                    }

                                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                        final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                        OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured3;
                                        if ($this$layout.isLookingAhead()) {
                                            onLookaheadMeasured4.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                        }
                                        return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                invoke2(placementScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                                Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv4;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            companionLayout = LayoutModifierKt.layout(companion, (Function3) value$iv4);
                        } else {
                            companionLayout = Modifier.INSTANCE;
                        }
                        $composer2.endReplaceGroup();
                        Modifier modifier$iv = modifier.then(modifierCreateModifier.then(companionLayout));
                        ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        it$iv = $composer2.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                            $composer2.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        MeasurePolicy measurePolicy$iv = (AnimatedEnterExitMeasurePolicy) value$iv3;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                        CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv = ((384 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            $composer2.createNode(constructor);
                        } else {
                            $composer2.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                            $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                            $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i5 = ($changed$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                        function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    } else {
                        onLookaheadMeasured3 = onLookaheadMeasured3;
                    }
                } else {
                    onLookaheadMeasured3 = onLookaheadMeasured3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                onLookaheadMeasured2 = onLookaheadMeasured3;
            } else {
                $composer2.skipToGroupEnd();
                onLookaheadMeasured2 = onLookaheadMeasured3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i6) {
                        AnimatedVisibilityKt.AnimatedEnterExitImpl(transition, function1, modifier, enter, exit, function2, onLookaheadMeasured4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                    }
                });
            }
        }
        i2 = 12582912;
        $dirty2 |= i2;
        if ((4793491 & $dirty2) == 4793490) {
            if (i3 != 0) {
                onLookaheadMeasured3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891967166, $dirty2, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:785)");
            }
            if (function1.invoke(transition.getTargetState()).booleanValue()) {
                int $changed$iv2 = ($dirty2 & 14) | 48;
                ComposerKt.sourceInformationMarkerStart($composer2, 1215497572, "CC(createChildTransition)1787@72932L36,1788@72992L74,1789@73089L39,1790@73140L63:Transition.kt#pdpnli");
                ComposerKt.sourceInformationMarkerStart($composer2, 1117150131, "CC(remember):Transition.kt#9igjgp");
                if ((($changed$iv2 & 14) ^ 6) <= 4) {
                }
                Object it$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv) {
                }
                value$iv$iv = transition.getCurrentState();
                $composer2.updateRememberedValue(value$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                initialParentState$iv = value$iv$iv;
                if (transition.isSeeking()) {
                    it = transition.getCurrentState();
                } else {
                    it = initialParentState$iv;
                }
                $changed2 = ($changed$iv2 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed2, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object initialState$iv2 = targetEnterExit(transition, function1, it, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed2 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                Object it3 = transition.getTargetState();
                $changed3 = ($changed$iv2 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed3, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object targetState$iv2 = targetEnterExit(transition, function1, it3, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed3 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                $dirty = $dirty2;
                childTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, initialState$iv2, targetState$iv2, "EnterExitTransition", $composer2, ($changed$iv2 & 14) | (($changed$iv2 << 6) & 7168));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                shouldDisposeBlockUpdated$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty >> 15) & 14);
                Boolean boolInvoke2 = function2.invoke(childTransition.getCurrentState(), childTransition.getTargetState());
                ComposerKt.sourceInformationMarkerStart($composer2, -918808031, "CC(remember):AnimatedVisibility.kt#9igjgp");
                invalid$iv = $composer2.changed(childTransition) | $composer2.changed(shouldDisposeBlockUpdated$delegate);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv) {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                State shouldDisposeAfterExit$delegate2 = SnapshotStateKt.produceState(boolInvoke2, (Function2) value$iv, $composer2, 0);
                if (getExitFinished(childTransition)) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv6 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier2 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv7 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion2, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv2 = modifier.then(modifierCreateModifier2.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv2 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv2 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv2 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i6 = ($changed$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv8 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier3 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv9 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion3, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv3 = modifier.then(modifierCreateModifier3.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv3 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv3 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv3 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash3);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i7 = ($changed$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
            } else {
                int $changed$iv3 = ($dirty2 & 14) | 48;
                ComposerKt.sourceInformationMarkerStart($composer2, 1215497572, "CC(createChildTransition)1787@72932L36,1788@72992L74,1789@73089L39,1790@73140L63:Transition.kt#pdpnli");
                ComposerKt.sourceInformationMarkerStart($composer2, 1117150131, "CC(remember):Transition.kt#9igjgp");
                if ((($changed$iv3 & 14) ^ 6) <= 4) {
                }
                Object it$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv) {
                }
                value$iv$iv = transition.getCurrentState();
                $composer2.updateRememberedValue(value$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                initialParentState$iv = value$iv$iv;
                if (transition.isSeeking()) {
                    it = transition.getCurrentState();
                } else {
                    it = initialParentState$iv;
                }
                $changed2 = ($changed$iv3 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed2, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object initialState$iv3 = targetEnterExit(transition, function1, it, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed2 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                Object it4 = transition.getTargetState();
                $changed3 = ($changed$iv3 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed3, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object targetState$iv3 = targetEnterExit(transition, function1, it4, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed3 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                $dirty = $dirty2;
                childTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, initialState$iv3, targetState$iv3, "EnterExitTransition", $composer2, ($changed$iv3 & 14) | (($changed$iv3 << 6) & 7168));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                shouldDisposeBlockUpdated$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty >> 15) & 14);
                Boolean boolInvoke3 = function2.invoke(childTransition.getCurrentState(), childTransition.getTargetState());
                ComposerKt.sourceInformationMarkerStart($composer2, -918808031, "CC(remember):AnimatedVisibility.kt#9igjgp");
                invalid$iv = $composer2.changed(childTransition) | $composer2.changed(shouldDisposeBlockUpdated$delegate);
                Object it$iv10 = $composer2.rememberedValue();
                if (invalid$iv) {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                State shouldDisposeAfterExit$delegate3 = SnapshotStateKt.produceState(boolInvoke3, (Function2) value$iv, $composer2, 0);
                if (getExitFinished(childTransition)) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv11 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier4 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv12 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion4, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv4 = modifier.then(modifierCreateModifier4.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv4 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv4 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv4 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash4);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i8 = ($changed$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv13 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier5 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv14 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion5, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv5 = modifier.then(modifierCreateModifier5.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv5 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv5 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv5 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv5 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash5);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                    int i9 = ($changed$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onLookaheadMeasured2 = onLookaheadMeasured3;
        } else {
            if (i3 != 0) {
                onLookaheadMeasured3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891967166, $dirty2, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:785)");
            }
            if (function1.invoke(transition.getTargetState()).booleanValue()) {
                int $changed$iv4 = ($dirty2 & 14) | 48;
                ComposerKt.sourceInformationMarkerStart($composer2, 1215497572, "CC(createChildTransition)1787@72932L36,1788@72992L74,1789@73089L39,1790@73140L63:Transition.kt#pdpnli");
                ComposerKt.sourceInformationMarkerStart($composer2, 1117150131, "CC(remember):Transition.kt#9igjgp");
                if ((($changed$iv4 & 14) ^ 6) <= 4) {
                }
                Object it$iv$iv4 = $composer2.rememberedValue();
                if (!invalid$iv$iv) {
                }
                value$iv$iv = transition.getCurrentState();
                $composer2.updateRememberedValue(value$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                initialParentState$iv = value$iv$iv;
                if (transition.isSeeking()) {
                    it = transition.getCurrentState();
                } else {
                    it = initialParentState$iv;
                }
                $changed2 = ($changed$iv4 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed2, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object initialState$iv4 = targetEnterExit(transition, function1, it, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed2 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                Object it5 = transition.getTargetState();
                $changed3 = ($changed$iv4 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed3, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object targetState$iv4 = targetEnterExit(transition, function1, it5, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed3 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                $dirty = $dirty2;
                childTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, initialState$iv4, targetState$iv4, "EnterExitTransition", $composer2, ($changed$iv4 & 14) | (($changed$iv4 << 6) & 7168));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                shouldDisposeBlockUpdated$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty >> 15) & 14);
                Boolean boolInvoke4 = function2.invoke(childTransition.getCurrentState(), childTransition.getTargetState());
                ComposerKt.sourceInformationMarkerStart($composer2, -918808031, "CC(remember):AnimatedVisibility.kt#9igjgp");
                invalid$iv = $composer2.changed(childTransition) | $composer2.changed(shouldDisposeBlockUpdated$delegate);
                Object it$iv15 = $composer2.rememberedValue();
                if (invalid$iv) {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                State shouldDisposeAfterExit$delegate4 = SnapshotStateKt.produceState(boolInvoke4, (Function2) value$iv, $composer2, 0);
                if (getExitFinished(childTransition)) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv16 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier6 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion6 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv17 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion6, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv6 = modifier.then(modifierCreateModifier6.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv6 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv6 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv6 = ComposedModifierKt.materializeModifier($composer2, modifier$iv6);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv6 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash6);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                    int i10 = ($changed$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv18 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier7 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion7 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv19 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion7, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv7 = modifier.then(modifierCreateModifier7.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv7 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv7 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv7 = ComposedModifierKt.materializeModifier($composer2, modifier$iv7);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv7 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash7);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                    int i11 = ($changed$iv$iv7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
            } else {
                int $changed$iv5 = ($dirty2 & 14) | 48;
                ComposerKt.sourceInformationMarkerStart($composer2, 1215497572, "CC(createChildTransition)1787@72932L36,1788@72992L74,1789@73089L39,1790@73140L63:Transition.kt#pdpnli");
                ComposerKt.sourceInformationMarkerStart($composer2, 1117150131, "CC(remember):Transition.kt#9igjgp");
                if ((($changed$iv5 & 14) ^ 6) <= 4) {
                }
                Object it$iv$iv5 = $composer2.rememberedValue();
                if (!invalid$iv$iv) {
                }
                value$iv$iv = transition.getCurrentState();
                $composer2.updateRememberedValue(value$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                initialParentState$iv = value$iv$iv;
                if (transition.isSeeking()) {
                    it = transition.getCurrentState();
                } else {
                    it = initialParentState$iv;
                }
                $changed2 = ($changed$iv5 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed2, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object initialState$iv5 = targetEnterExit(transition, function1, it, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed2 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                Object it6 = transition.getTargetState();
                $changed3 = ($changed$iv5 >> 3) & 112;
                $composer2.startReplaceGroup(-466616829);
                ComposerKt.sourceInformation($composer2, "C790@41433L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466616829, $changed3, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:790)");
                }
                Object targetState$iv5 = targetEnterExit(transition, function1, it6, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($changed3 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                $dirty = $dirty2;
                childTransition = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, initialState$iv5, targetState$iv5, "EnterExitTransition", $composer2, ($changed$iv5 & 14) | (($changed$iv5 << 6) & 7168));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                shouldDisposeBlockUpdated$delegate = SnapshotStateKt.rememberUpdatedState(function2, $composer2, ($dirty >> 15) & 14);
                Boolean boolInvoke5 = function2.invoke(childTransition.getCurrentState(), childTransition.getTargetState());
                ComposerKt.sourceInformationMarkerStart($composer2, -918808031, "CC(remember):AnimatedVisibility.kt#9igjgp");
                invalid$iv = $composer2.changed(childTransition) | $composer2.changed(shouldDisposeBlockUpdated$delegate);
                Object it$iv110 = $composer2.rememberedValue();
                if (invalid$iv) {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = new C0178xd7829780(childTransition, shouldDisposeBlockUpdated$delegate, null);
                    $composer2.updateRememberedValue(value$iv);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                State shouldDisposeAfterExit$delegate5 = SnapshotStateKt.produceState(boolInvoke5, (Function2) value$iv, $composer2, 0);
                if (getExitFinished(childTransition)) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv111 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier8 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion8 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv112 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion8, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv8 = modifier.then(modifierCreateModifier8.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv8 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv8 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv8 = ComposedModifierKt.materializeModifier($composer2, modifier$iv8);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv8 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash8);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                    int i12 = ($changed$iv$iv8 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -918807534, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    if (($dirty & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv2 = z;
                    Object it$iv113 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new AnimatedVisibilityScopeImpl(childTransition);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    scope = (AnimatedVisibilityScopeImpl) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifierCreateModifier9 = EnterExitTransitionKt.createModifier(childTransition, enter, exit, "Built-in", $composer2, (($dirty >> 6) & 112) | 3072 | (($dirty >> 6) & 896));
                    $composer2.startReplaceGroup(-918807249);
                    ComposerKt.sourceInformation($composer2, "822@42630L499");
                    if (onLookaheadMeasured3 != null) {
                        Modifier.Companion companion9 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -918807170, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if (($dirty & 3670016) != 1048576) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = true;
                        }
                        Object it$iv114 = $composer2.rememberedValue();
                        if (!invalid$iv3) {
                        }
                        value$iv4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m313invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m313invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                                final Placeable $this$invoke_3p2s80s_u24lambda_u240 = measurable.mo5644measureBRTryo0(constraints);
                                OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured3;
                                if ($this$layout.isLookingAhead()) {
                                    onLookaheadMeasured5.m344invokeozmzZPI(IntSizeKt.IntSize($this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight()));
                                }
                                return MeasureScope.CC.layout$default($this$layout, $this$invoke_3p2s80s_u24lambda_u240.getWidth(), $this$invoke_3p2s80s_u24lambda_u240.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                        Placeable.PlacementScope.place$default($this$layout2, $this$invoke_3p2s80s_u24lambda_u240, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        companionLayout = LayoutModifierKt.layout(companion9, (Function3) value$iv4);
                    } else {
                        companionLayout = Modifier.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                    Modifier modifier$iv9 = modifier.then(modifierCreateModifier9.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart($composer2, -918806574, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = new AnimatedEnterExitMeasurePolicy(scope);
                        $composer2.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MeasurePolicy measurePolicy$iv9 = (AnimatedEnterExitMeasurePolicy) value$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv9 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv9 = ComposedModifierKt.materializeModifier($composer2, modifier$iv9);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv9 = ((384 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(constructor);
                    } else {
                        $composer2.useNode();
                    }
                    $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!$this$Layout_u24lambda_u240$iv.getInserting()) {
                    }
                    $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash9);
                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                    int i13 = ($changed$iv$iv9 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -174036311, "C818@42390L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(scope, $composer2, Integer.valueOf(($dirty >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onLookaheadMeasured2 = onLookaheadMeasured3;
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i14) {
                    AnimatedVisibilityKt.AnimatedEnterExitImpl(transition, function1, modifier, enter, exit, function2, onLookaheadMeasured5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$4(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    private static final boolean AnimatedEnterExitImpl$lambda$6(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        return transition.getCurrentState() == EnterExitState.PostExit && transition.getTargetState() == EnterExitState.PostExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer $composer, int $changed) {
        Object value$iv;
        EnterExitState enterExitState;
        ComposerKt.sourceInformationMarkerStart($composer, 361571134, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, $changed, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:890)");
        }
        $composer.startMovableGroup(-721835284, transition);
        ComposerKt.sourceInformation($composer, "903@45517L34");
        if (transition.isSeeking()) {
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else {
            ComposerKt.sourceInformationMarkerStart($composer, -721834989, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState hasBeenVisible = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                hasBeenVisible.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) hasBeenVisible.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        }
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return enterExitState;
    }
}
