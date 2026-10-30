package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.layout.SubcomposeLayoutKt;
import androidx.compose.p001ui.layout.SubcomposeMeasureScope;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a¤\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0080\u0001\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u009a\u0001\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0001\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a¤\u0001\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001e\u001a\u0080\u0001\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010#\u001a\u0090\u0001\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010#\u001an\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a~\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00102\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, m195d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "Landroidx/compose/material3/TabIndicatorScope;", "Lkotlin/ExtensionFunctionType;", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImp", "ScrollableTabRowImp-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = C1979Dp.m6801constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX INFO: renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2718PrimaryTabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier modifier2;
        int $dirty;
        long containerColor3;
        long contentColor3;
        Function2<? super Composer, ? super Integer, Unit> function2M2134getLambda1$material3_release;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function6;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1884787284);
        ComposerKt.sourceInformation($composer2, "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)151@7498L21,152@7562L19,153@7641L235,167@8006L76:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer2.changed(containerColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function3RememberComposableLambda = function3;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function3RememberComposableLambda = function3;
            $dirty2 |= $composer2.changedInstance(function3RememberComposableLambda) ? 16384 : 8192;
        } else {
            function3RememberComposableLambda = function3;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function5 = function2;
        } else if ((196608 & $changed) == 0) {
            function5 = function2;
            $dirty2 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function2;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            function7 = function3RememberComposableLambda;
            function8 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer2, 6);
                }
                if (i5 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2021049253, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                            invoke(tabIndicatorScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TabIndicatorScope $this$null, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C154@7666L204:TabRow.kt#uh7d8r");
                            int $dirty3 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty3 |= ($changed2 & 8) == 0 ? $composer3.changed($this$null) : $composer3.changedInstance($this$null) ? 4 : 2;
                            }
                            int $dirty4 = $dirty3;
                            if (($dirty4 & 19) != 18 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2021049253, $dirty4, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:154)");
                                }
                                TabRowDefaults.INSTANCE.m2713PrimaryIndicator10LGxhE($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, true), C1979Dp.INSTANCE.m6821getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, $composer3, 196656, 28);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }, $composer2, 54);
                }
                if (i6 != 0) {
                    function2M2134getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2134getLambda1$material3_release();
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function6 = function3RememberComposableLambda;
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2134getLambda1$material3_release = function5;
                    function6 = function3RememberComposableLambda;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2134getLambda1$material3_release = function5;
                    modifier2 = modifier;
                    function6 = function3RememberComposableLambda;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2134getLambda1$material3_release = function5;
                    function6 = function3RememberComposableLambda;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1884787284, $dirty, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:166)");
            }
            m2724TabRowImplDTcfvLk(modifier2, containerColor3, contentColor3, function6, function2M2134getLambda1$material3_release, function4, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = function6;
            function8 = function2M2134getLambda1$material3_release;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function9 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function8;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$2
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

                public final void invoke(Composer composer, int i7) {
                    TabRowKt.m2718PrimaryTabRowpAZo6Ak(selectedTabIndex, modifier5, j, j2, function9, function10, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2722SecondaryTabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier modifier2;
        int $dirty;
        long containerColor3;
        long contentColor3;
        Function2<? super Composer, ? super Integer, Unit> function2M2135getLambda2$material3_release;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function6;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1909540706);
        ComposerKt.sourceInformation($composer2, "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)208@10476L23,209@10542L21,210@10635L144,220@10909L76:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer2.changed(containerColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function3RememberComposableLambda = function3;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function3RememberComposableLambda = function3;
            $dirty2 |= $composer2.changedInstance(function3RememberComposableLambda) ? 16384 : 8192;
        } else {
            function3RememberComposableLambda = function3;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function5 = function2;
        } else if ((196608 & $changed) == 0) {
            function5 = function2;
            $dirty2 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function2;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            function7 = function3RememberComposableLambda;
            function8 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getSecondaryContainerColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    contentColor2 = TabRowDefaults.INSTANCE.getSecondaryContentColor($composer2, 6);
                }
                if (i5 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(286693261, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                            invoke(tabIndicatorScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TabIndicatorScope $this$null, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C211@10660L113:TabRow.kt#uh7d8r");
                            int $dirty3 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty3 |= ($changed2 & 8) == 0 ? $composer3.changed($this$null) : $composer3.changedInstance($this$null) ? 4 : 2;
                            }
                            if (($dirty3 & 19) != 18 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(286693261, $dirty3, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:211)");
                                }
                                TabRowDefaults.INSTANCE.m2714SecondaryIndicator9IZ8Weo($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, false), 0.0f, 0L, $composer3, 3072, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }, $composer2, 54);
                }
                if (i6 != 0) {
                    function2M2135getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2135getLambda2$material3_release();
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function6 = function3RememberComposableLambda;
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2135getLambda2$material3_release = function5;
                    function6 = function3RememberComposableLambda;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2135getLambda2$material3_release = function5;
                    modifier2 = modifier;
                    function6 = function3RememberComposableLambda;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2135getLambda2$material3_release = function5;
                    function6 = function3RememberComposableLambda;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1909540706, $dirty, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:219)");
            }
            m2724TabRowImplDTcfvLk(modifier2, containerColor3, contentColor3, function6, function2M2135getLambda2$material3_release, function4, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = function6;
            function8 = function2M2135getLambda2$material3_release;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function9 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function8;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$2
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

                public final void invoke(Composer composer, int i7) {
                    TabRowKt.m2722SecondaryTabRowpAZo6Ak(selectedTabIndex, modifier5, j, j2, function9, function10, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2723TabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier modifier2;
        int $dirty;
        long containerColor3;
        long contentColor3;
        Function2<? super Composer, ? super Integer, Unit> function2M2136getLambda3$material3_release;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1199178586);
        ComposerKt.sourceInformation($composer2, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)300@15207L21,301@15271L19,302@15375L222,314@15727L90:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer2.changed(containerColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function3RememberComposableLambda = function3;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function3RememberComposableLambda = function3;
            $dirty2 |= $composer2.changedInstance(function3RememberComposableLambda) ? 16384 : 8192;
        } else {
            function3RememberComposableLambda = function3;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function5 = function2;
        } else if ((196608 & $changed) == 0) {
            function5 = function2;
            $dirty2 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function2;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if (($dirty2 & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            function7 = function3RememberComposableLambda;
            function8 = function5;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer2, 6);
                }
                if (i5 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2052073983, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C304@15472L109:TabRow.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2052073983, $changed2, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:303)");
                            }
                            if (selectedTabIndex < list.size()) {
                                TabRowDefaults.INSTANCE.m2714SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer3, 3072, 6);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                }
                if (i6 != 0) {
                    function2M2136getLambda3$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2136getLambda3$material3_release();
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function6 = function3RememberComposableLambda;
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2136getLambda3$material3_release = function5;
                    function6 = function3RememberComposableLambda;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2136getLambda3$material3_release = function5;
                    modifier2 = modifier;
                    function6 = function3RememberComposableLambda;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    function2M2136getLambda3$material3_release = function5;
                    function6 = function3RememberComposableLambda;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1199178586, $dirty, -1, "androidx.compose.material3.TabRow (TabRow.kt:313)");
            }
            m2725TabRowWithSubcomposeImplDTcfvLk(modifier2, containerColor3, contentColor3, function6, function2M2136getLambda3$material3_release, function4, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = function6;
            function8 = function2M2136getLambda3$material3_release;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function9 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function8;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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

                public final void invoke(Composer composer, int i7) {
                    TabRowKt.m2723TabRowpAZo6Ak(selectedTabIndex, modifier5, j, j2, function9, function10, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    public static final void m2724TabRowImplDTcfvLk(final Modifier modifier, final long containerColor, final long contentColor, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation($composer2, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)371@17531L3982,367@17401L4112:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(containerColor) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, $dirty2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:366)");
            }
            SurfaceKt.m2666SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    Object value$iv2;
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C372@17553L1344,415@19057L21,417@19104L2403,410@18907L2600:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-65106680, $changed2, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:372)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer3, 474062794, "CC(remember):TabRow.kt#9igjgp");
                        Object it$iv = $composer3.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new TabRowKt$TabRowImpl$1$scope$1$1();
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final TabRowKt$TabRowImpl$1$scope$1$1 scope = (TabRowKt$TabRowImpl$1$scope$1$1) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        boolean z = true;
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function5 = function3;
                        List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function4, function2, ComposableLambdaKt.rememberComposableLambda(1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C415@19065L11:TabRow.kt#uh7d8r");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1236693605, $changed3, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:415)");
                                }
                                function5.invoke(scope, $composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54)});
                        ComposerKt.sourceInformationMarkerStart($composer3, 474064345, "CC(remember):TabRow.kt#9igjgp");
                        Object it$iv2 = $composer3.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                                @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                                    return MultiContentMeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                                }

                                @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                                    return MultiContentMeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                                }

                                @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                                    return MultiContentMeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                                }

                                @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                                    return MultiContentMeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                                }

                                @Override // androidx.compose.p001ui.layout.MultiContentMeasurePolicy
                                /* JADX INFO: renamed from: measure-3p2s80s */
                                public final MeasureResult mo816measure3p2s80s(MeasureScope $this$Layout, List<? extends List<? extends Measurable>> list, long constraints) {
                                    List<? extends Measurable> list2 = list.get(0);
                                    List<? extends Measurable> list3 = list.get(1);
                                    List<? extends Measurable> list4 = list.get(2);
                                    int tabRowWidth = Constraints.m6744getMaxWidthimpl(constraints);
                                    int tabCount = list2.size();
                                    final Ref.IntRef tabWidth = new Ref.IntRef();
                                    if (tabCount > 0) {
                                        tabWidth.element = tabRowWidth / tabCount;
                                    }
                                    Object initial$iv = 0;
                                    List<? extends Measurable> list5 = list2;
                                    Object accumulator$iv = initial$iv;
                                    int index$iv$iv = 0;
                                    int size = list5.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = list5.get(index$iv$iv);
                                        Measurable curr = (Measurable) item$iv$iv;
                                        Object initial$iv2 = initial$iv;
                                        int max = ((Number) accumulator$iv).intValue();
                                        accumulator$iv = Integer.valueOf(Math.max(curr.maxIntrinsicHeight(tabWidth.element), max));
                                        index$iv$iv++;
                                        initial$iv = initial$iv2;
                                        list5 = list5;
                                    }
                                    final int tabRowHeight = ((Number) accumulator$iv).intValue();
                                    TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = scope;
                                    ArrayList arrayList = new ArrayList(tabCount);
                                    int i = 0;
                                    while (i < tabCount) {
                                        int index = i;
                                        float contentWidth = $this$Layout.mo564toDpu2uoSUM(Math.min(list2.get(index).maxIntrinsicWidth(tabRowHeight), tabWidth.element));
                                        float arg0$iv = TabKt.getHorizontalTextPadding();
                                        int tabCount2 = tabCount;
                                        float other$iv = C1979Dp.m6801constructorimpl(2 * arg0$iv);
                                        C1979Dp c1979DpM6799boximpl = C1979Dp.m6799boximpl(C1979Dp.m6801constructorimpl(contentWidth - other$iv));
                                        float contentWidth2 = 24;
                                        float indicatorWidth = ((C1979Dp) ComparisonsKt.maxOf(c1979DpM6799boximpl, C1979Dp.m6799boximpl(C1979Dp.m6801constructorimpl(contentWidth2)))).m6815unboximpl();
                                        float arg0$iv2 = $this$Layout.mo564toDpu2uoSUM(tabWidth.element);
                                        arrayList.add(new TabPosition(C1979Dp.m6801constructorimpl(index * arg0$iv2), $this$Layout.mo564toDpu2uoSUM(tabWidth.element), indicatorWidth, null));
                                        i++;
                                        tabCount = tabCount2;
                                    }
                                    tabRowKt$TabRowImpl$1$scope$1$1.setTabPositions(arrayList);
                                    List<? extends Measurable> list6 = list2;
                                    int $i$f$fastMap = 0;
                                    List target$iv = new ArrayList(list6.size());
                                    List<? extends Measurable> list7 = list6;
                                    int $i$f$fastForEach = 0;
                                    int index$iv$iv2 = 0;
                                    for (int size2 = list7.size(); index$iv$iv2 < size2; size2 = size2) {
                                        Object item$iv$iv2 = list7.get(index$iv$iv2);
                                        Measurable it = (Measurable) item$iv$iv2;
                                        List<? extends Measurable> list8 = list6;
                                        int i2 = tabWidth.element;
                                        int $i$f$fastMap2 = $i$f$fastMap;
                                        int $i$f$fastMap3 = tabWidth.element;
                                        target$iv.add(it.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, i2, $i$f$fastMap3, tabRowHeight, tabRowHeight)));
                                        index$iv$iv2++;
                                        list6 = list8;
                                        $i$f$fastMap = $i$f$fastMap2;
                                        list7 = list7;
                                        $i$f$fastForEach = $i$f$fastForEach;
                                    }
                                    final List tabPlaceables = target$iv;
                                    List<? extends Measurable> list9 = list3;
                                    int $i$f$fastMap4 = 0;
                                    List target$iv2 = new ArrayList(list9.size());
                                    List<? extends Measurable> list10 = list9;
                                    int $i$f$fastForEach2 = 0;
                                    int index$iv$iv3 = 0;
                                    int size3 = list10.size();
                                    while (index$iv$iv3 < size3) {
                                        Object item$iv$iv3 = list10.get(index$iv$iv3);
                                        int $i$f$fastMap5 = $i$f$fastMap4;
                                        Measurable it2 = (Measurable) item$iv$iv3;
                                        target$iv2.add(it2.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0)));
                                        index$iv$iv3++;
                                        list9 = list9;
                                        $i$f$fastMap4 = $i$f$fastMap5;
                                        list10 = list10;
                                        $i$f$fastForEach2 = $i$f$fastForEach2;
                                    }
                                    final List dividerPlaceables = target$iv2;
                                    List<? extends Measurable> list11 = list4;
                                    int $i$f$fastMap6 = 0;
                                    List target$iv3 = new ArrayList(list11.size());
                                    List<? extends Measurable> list12 = list11;
                                    int $i$f$fastForEach3 = 0;
                                    int index$iv$iv4 = 0;
                                    int size4 = list12.size();
                                    while (index$iv$iv4 < size4) {
                                        Object item$iv$iv4 = list12.get(index$iv$iv4);
                                        int $i$f$fastMap7 = $i$f$fastMap6;
                                        Measurable it3 = (Measurable) item$iv$iv4;
                                        List<? extends Measurable> list13 = list12;
                                        int i3 = tabWidth.element;
                                        int $i$f$fastForEach4 = $i$f$fastForEach3;
                                        int $i$f$fastForEach5 = tabWidth.element;
                                        target$iv3.add(it3.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, i3, $i$f$fastForEach5, 0, tabRowHeight)));
                                        index$iv$iv4++;
                                        list11 = list11;
                                        $i$f$fastMap6 = $i$f$fastMap7;
                                        list12 = list13;
                                        $i$f$fastForEach3 = $i$f$fastForEach4;
                                    }
                                    final List indicatorPlaceables = target$iv3;
                                    return MeasureScope.CC.layout$default($this$Layout, tabRowWidth, tabRowHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            List<Placeable> list14 = tabPlaceables;
                                            Ref.IntRef intRef = tabWidth;
                                            int size5 = list14.size();
                                            for (int index$iv = 0; index$iv < size5; index$iv++) {
                                                Object item$iv = list14.get(index$iv);
                                                int index2 = index$iv;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index2 * intRef.element, 0, 0.0f, 4, null);
                                            }
                                            List<Placeable> list15 = dividerPlaceables;
                                            int i4 = tabRowHeight;
                                            int size6 = list15.size();
                                            for (int index$iv2 = 0; index$iv2 < size6; index$iv2++) {
                                                Object item$iv2 = list15.get(index$iv2);
                                                Placeable placeable = (Placeable) item$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i4 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List<Placeable> list16 = indicatorPlaceables;
                                            int i5 = tabRowHeight;
                                            int size7 = list16.size();
                                            for (int index$iv3 = 0; index$iv3 < size7; index$iv3++) {
                                                Object item$iv3 = list16.get(index$iv3);
                                                Placeable it4 = (Placeable) item$iv3;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it4, 0, i5 - it4.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1376093675, "CC(remember):Layout.kt#9igjgp");
                        if ((((432 & 896) ^ 384) <= 256 || !$composer3.changed(multiContentMeasurePolicy)) && (432 & 384) != 256) {
                            z = false;
                        }
                        boolean invalid$iv$iv = z;
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        int $changed$iv$iv = 432 & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxWidth$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts.invoke($composer3, Integer.valueOf(($changed$iv$iv$iv >> 6) & 14));
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 896) | 12582912 | (($dirty2 << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
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
                    TabRowKt.m2724TabRowImplDTcfvLk(modifier, containerColor, contentColor, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    public static final void m2725TabRowWithSubcomposeImplDTcfvLk(final Modifier modifier, final long containerColor, final long contentColor, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation($composer2, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)589@25020L2076,585@24890L2206:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(containerColor) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, $dirty2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:584)");
            }
            SurfaceKt.m2666SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier), null, containerColor, contentColor, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C590@25072L2018,590@25030L2060:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, $changed2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:590)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -1028159151, "CC(remember):TabRow.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(function4) | $composer3.changed(function2) | $composer3.changed(function3);
                    final Function2<Composer, Integer, Unit> function5 = function4;
                    final Function2<Composer, Integer, Unit> function6 = function2;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function7 = function3;
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2731invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2731invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                int tabRowWidth = Constraints.m6744getMaxWidthimpl(constraints);
                                List<Measurable> listSubcompose = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function5);
                                int tabCount = listSubcompose.size();
                                final Ref.IntRef tabWidth = new Ref.IntRef();
                                if (tabCount > 0) {
                                    tabWidth.element = tabRowWidth / tabCount;
                                }
                                Object initial$iv = 0;
                                Object accumulator$iv = initial$iv;
                                int index$iv$iv = 0;
                                int size = listSubcompose.size();
                                while (index$iv$iv < size) {
                                    Object item$iv$iv = listSubcompose.get(index$iv$iv);
                                    Measurable curr = (Measurable) item$iv$iv;
                                    int max = ((Number) accumulator$iv).intValue();
                                    accumulator$iv = Integer.valueOf(Math.max(curr.maxIntrinsicHeight(tabWidth.element), max));
                                    index$iv$iv++;
                                    initial$iv = initial$iv;
                                }
                                final int tabRowHeight = ((Number) accumulator$iv).intValue();
                                List<Measurable> list = listSubcompose;
                                int $i$f$fastMap = 0;
                                List target$iv = new ArrayList(list.size());
                                List<Measurable> list2 = list;
                                int size2 = list2.size();
                                int index$iv$iv2 = 0;
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = list2.get(index$iv$iv2);
                                    List list3 = target$iv;
                                    Measurable it = (Measurable) item$iv$iv2;
                                    list3.add(it.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, tabWidth.element, tabWidth.element, tabRowHeight, tabRowHeight)));
                                    index$iv$iv2++;
                                    size2 = size2;
                                    list = list;
                                    $i$f$fastMap = $i$f$fastMap;
                                    tabRowWidth = tabRowWidth;
                                    list2 = list2;
                                }
                                final int tabRowWidth2 = tabRowWidth;
                                final List tabPlaceables = target$iv;
                                ArrayList arrayList = new ArrayList(tabCount);
                                for (int i = 0; i < tabCount; i++) {
                                    int index = i;
                                    float contentWidth = $this$SubcomposeLayout.mo564toDpu2uoSUM(Math.min(listSubcompose.get(index).maxIntrinsicWidth(tabRowHeight), tabWidth.element));
                                    float arg0$iv = TabKt.getHorizontalTextPadding();
                                    float other$iv = C1979Dp.m6801constructorimpl(contentWidth - C1979Dp.m6801constructorimpl(2 * arg0$iv));
                                    float indicatorWidth = ((C1979Dp) ComparisonsKt.maxOf(C1979Dp.m6799boximpl(other$iv), C1979Dp.m6799boximpl(C1979Dp.m6801constructorimpl(24)))).m6815unboximpl();
                                    float arg0$iv2 = $this$SubcomposeLayout.mo564toDpu2uoSUM(tabWidth.element);
                                    arrayList.add(new TabPosition(C1979Dp.m6801constructorimpl(index * arg0$iv2), $this$SubcomposeLayout.mo564toDpu2uoSUM(tabWidth.element), indicatorWidth, null));
                                }
                                final ArrayList tabPositions = arrayList;
                                final Function2<Composer, Integer, Unit> function8 = function6;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function9 = function7;
                                return MeasureScope.CC.layout$default($this$SubcomposeLayout, tabRowWidth2, tabRowHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        List<Placeable> list4 = tabPlaceables;
                                        Ref.IntRef intRef = tabWidth;
                                        int size3 = list4.size();
                                        for (int index$iv = 0; index$iv < size3; index$iv++) {
                                            Object item$iv = list4.get(index$iv);
                                            int index2 = index$iv;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index2 * intRef.element, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> listSubcompose2 = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function8);
                                        long j = constraints;
                                        int i2 = tabRowHeight;
                                        int size4 = listSubcompose2.size();
                                        int index$iv2 = 0;
                                        while (index$iv2 < size4) {
                                            Object item$iv2 = listSubcompose2.get(index$iv2);
                                            Measurable it2 = (Measurable) item$iv2;
                                            Placeable placeable = it2.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(j, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(j) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(j) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(j) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(j) : 0));
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, null);
                                            index$iv2++;
                                            listSubcompose2 = listSubcompose2;
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function10 = function9;
                                        final List<TabPosition> list5 = tabPositions;
                                        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
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

                                            public final void invoke(Composer $composer4, int $changed3) {
                                                ComposerKt.sourceInformation($composer4, "C633@26896L23:TabRow.kt#uh7d8r");
                                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                                    $composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, $changed3, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:633)");
                                                }
                                                function10.invoke(list5, $composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i3 = tabRowWidth2;
                                        int i4 = tabRowHeight;
                                        int size5 = listSubcompose3.size();
                                        for (int index$iv3 = 0; index$iv3 < size5; index$iv3++) {
                                            Object item$iv3 = listSubcompose3.get(index$iv3);
                                            Measurable it3 = (Measurable) item$iv3;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, it3.mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(i3, i4)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) value$iv, $composer3, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 896) | 12582912 | (($dirty2 << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
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
                    TabRowKt.m2725TabRowWithSubcomposeImplDTcfvLk(modifier, containerColor, contentColor, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final void m2717PrimaryScrollableTabRowqhFBPw4(final int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        float f;
        Modifier.Companion modifier2;
        ScrollState scrollState2;
        Function2<? super Composer, ? super Integer, Unit> function2M2137getLambda4$material3_release;
        int $dirty;
        float edgePadding2;
        ScrollState scrollState3;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1763241113);
        ComposerKt.sourceInformation($composer3, "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)679@29446L21,680@29512L21,681@29576L19,683@29751L352,697@30233L327:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ((i & 4) == 0 && $composer3.changed(scrollState)) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = edgePadding;
        } else if ((196608 & $changed) == 0) {
            f = edgePadding;
            $dirty2 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = edgePadding;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            scrollState3 = scrollState;
            function5 = function3;
            function2M2137getLambda4$material3_release = function2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding2 = f;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                    $dirty2 &= -897;
                } else {
                    scrollState2 = scrollState;
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                float edgePadding3 = i5 != 0 ? TabRowDefaults.INSTANCE.m2715getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f;
                ComposableLambda composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(438091970, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                        invoke((List<TabPosition>) list, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C685@29846L75,686@29949L138:TabRow.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(438091970, $changed2, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:684)");
                        }
                        if (selectedTabIndex < list.size()) {
                            TabRowDefaults.INSTANCE.m2713PrimaryIndicator10LGxhE(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), invoke$lambda$0(AnimateAsStateKt.m363animateDpAsStateAjpBEmI(list.get(selectedTabIndex).getContentWidth(), null, null, null, $composer4, 0, 14)), 0.0f, 0L, null, $composer4, ProfileVerifier.CompilationStatus.f245xf2722a21, 28);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    private static final float invoke$lambda$0(State<C1979Dp> state) {
                        Object thisObj$iv = state.getValue();
                        return ((C1979Dp) thisObj$iv).m6815unboximpl();
                    }
                }, $composer3, 54) : function3;
                if (i7 != 0) {
                    function2M2137getLambda4$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2137getLambda4$material3_release();
                    $dirty = $dirty2;
                    edgePadding2 = edgePadding3;
                    scrollState3 = scrollState2;
                    function5 = composableLambdaRememberComposableLambda;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    function2M2137getLambda4$material3_release = function2;
                    $dirty = $dirty2;
                    edgePadding2 = edgePadding3;
                    scrollState3 = scrollState2;
                    function5 = composableLambdaRememberComposableLambda;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    modifier2 = modifier;
                    scrollState3 = scrollState;
                    function5 = function3;
                    function2M2137getLambda4$material3_release = function2;
                    $dirty = $dirty2 & (-57345);
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding2 = f;
                } else {
                    modifier2 = modifier;
                    scrollState3 = scrollState;
                    function5 = function3;
                    function2M2137getLambda4$material3_release = function2;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding2 = f;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1763241113, $dirty, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:696)");
            }
            $composer2 = $composer3;
            m2720ScrollableTabRowImpqhFBPw4(selectedTabIndex, function5, modifier2, containerColor3, contentColor3, edgePadding2, function2M2137getLambda4$material3_release, function4, scrollState3, $composer3, ($dirty & 14) | (($dirty >> 15) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016) | (29360128 & ($dirty >> 3)) | (($dirty << 18) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final ScrollState scrollState4 = scrollState3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final float f2 = edgePadding2;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function6 = function5;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function2M2137getLambda4$material3_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
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

                public final void invoke(Composer composer, int i8) {
                    TabRowKt.m2717PrimaryScrollableTabRowqhFBPw4(selectedTabIndex, modifier3, scrollState4, j, j2, f2, function6, function7, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final void m2721SecondaryScrollableTabRowqhFBPw4(final int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        float f;
        Modifier.Companion modifier2;
        ScrollState scrollState2;
        Function2<? super Composer, ? super Integer, Unit> function2M2138getLambda5$material3_release;
        int $dirty;
        float edgePadding2;
        ScrollState scrollState3;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1821940917);
        ComposerKt.sourceInformation($composer3, "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)751@33181L21,752@33247L23,753@33313L21,755@33490L148,765@33768L326:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ((i & 4) == 0 && $composer3.changed(scrollState)) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = edgePadding;
        } else if ((196608 & $changed) == 0) {
            f = edgePadding;
            $dirty2 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = edgePadding;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            scrollState3 = scrollState;
            function5 = function3;
            function2M2138getLambda5$material3_release = function2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding2 = f;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                    $dirty2 &= -897;
                } else {
                    scrollState2 = scrollState;
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getSecondaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getSecondaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                float edgePadding3 = i5 != 0 ? TabRowDefaults.INSTANCE.m2715getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f;
                ComposableLambda composableLambdaRememberComposableLambda = i6 != 0 ? ComposableLambdaKt.rememberComposableLambda(-115843248, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                        invoke((List<TabPosition>) list, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C756@33531L101:TabRow.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-115843248, $changed2, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:756)");
                        }
                        TabRowDefaults.INSTANCE.m2714SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer4, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54) : function3;
                if (i7 != 0) {
                    function2M2138getLambda5$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2138getLambda5$material3_release();
                    $dirty = $dirty2;
                    edgePadding2 = edgePadding3;
                    scrollState3 = scrollState2;
                    function5 = composableLambdaRememberComposableLambda;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    function2M2138getLambda5$material3_release = function2;
                    $dirty = $dirty2;
                    edgePadding2 = edgePadding3;
                    scrollState3 = scrollState2;
                    function5 = composableLambdaRememberComposableLambda;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    modifier2 = modifier;
                    scrollState3 = scrollState;
                    function5 = function3;
                    function2M2138getLambda5$material3_release = function2;
                    $dirty = $dirty2 & (-57345);
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding2 = f;
                } else {
                    modifier2 = modifier;
                    scrollState3 = scrollState;
                    function5 = function3;
                    function2M2138getLambda5$material3_release = function2;
                    $dirty = $dirty2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding2 = f;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1821940917, $dirty, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:764)");
            }
            $composer2 = $composer3;
            m2720ScrollableTabRowImpqhFBPw4(selectedTabIndex, function5, modifier2, containerColor3, contentColor3, edgePadding2, function2M2138getLambda5$material3_release, function4, scrollState3, $composer3, ($dirty & 14) | (($dirty >> 15) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016) | (29360128 & ($dirty >> 3)) | (($dirty << 18) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final ScrollState scrollState4 = scrollState3;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final float f2 = edgePadding2;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function6 = function5;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function2M2138getLambda5$material3_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
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

                public final void invoke(Composer composer, int i8) {
                    TabRowKt.m2721SecondaryScrollableTabRowqhFBPw4(selectedTabIndex, modifier3, scrollState4, j, j2, f2, function6, function7, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m2719ScrollableTabRowsKfQg0A(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function2M2139getLambda6$material3_release;
        Modifier modifier2;
        long containerColor3;
        long contentColor3;
        float edgePadding3;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        int $dirty;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation($composer3, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)818@36620L21,819@36684L19,821@36859L148,840@37446L21,831@37137L336:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            edgePadding2 = edgePadding;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 16384 : 8192;
        } else {
            edgePadding2 = edgePadding;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function3RememberComposableLambda = function3;
        } else if ((196608 & $changed) == 0) {
            function3RememberComposableLambda = function3;
            $dirty2 |= $composer3.changedInstance(function3RememberComposableLambda) ? 131072 : 65536;
        } else {
            function3RememberComposableLambda = function3;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function4) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            function2M2139getLambda6$material3_release = function2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
            function5 = function3RememberComposableLambda;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                }
                if (i5 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2715getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C822@36900L101:TabRow.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-913748678, $changed2, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:822)");
                            }
                            TabRowDefaults.INSTANCE.m2714SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54);
                }
                if (i7 != 0) {
                    modifier2 = modifier3;
                    function2M2139getLambda6$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2139getLambda6$material3_release();
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    function5 = function3RememberComposableLambda;
                    $dirty = $dirty2;
                } else {
                    function2M2139getLambda6$material3_release = function2;
                    modifier2 = modifier3;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    function5 = function3RememberComposableLambda;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    modifier2 = modifier;
                    function2M2139getLambda6$material3_release = function2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    function5 = function3RememberComposableLambda;
                    $dirty = $dirty2 & (-7169);
                } else {
                    modifier2 = modifier;
                    function2M2139getLambda6$material3_release = function2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    function5 = function3RememberComposableLambda;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-497821003, $dirty, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:830)");
            }
            $composer2 = $composer3;
            m2720ScrollableTabRowImpqhFBPw4(selectedTabIndex, function5, modifier2, containerColor3, contentColor3, edgePadding3, function2M2139getLambda6$material3_release, function4, ScrollKt.rememberScrollState(0, $composer3, 0, 1), $composer3, ($dirty & 14) | (($dirty >> 12) & 112) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (458752 & ($dirty << 3)) | (3670016 & $dirty) | (29360128 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final long j = containerColor3;
            final long j2 = contentColor3;
            final float f = edgePadding3;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function6 = function5;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function2M2139getLambda6$material3_release;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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

                public final void invoke(Composer composer, int i8) {
                    TabRowKt.m2719ScrollableTabRowsKfQg0A(selectedTabIndex, modifier4, j, j2, f, function6, function7, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ScrollableTabRowImp-qhFBPw4, reason: not valid java name */
    public static final void m2720ScrollableTabRowImpqhFBPw4(final int selectedTabIndex, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, final ScrollState scrollState, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long j;
        float f;
        Modifier.Companion modifier2;
        long contentColor2;
        float edgePadding2;
        Function2<? super Composer, ? super Integer, Unit> function2M2140getLambda7$material3_release;
        float edgePadding3;
        Modifier modifier3;
        long contentColor3;
        long containerColor3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Composer $composer2 = $composer.startRestartGroup(-1696166011);
        ComposerKt.sourceInformation($composer2, "C(ScrollableTabRowImp)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)849@37697L21,850@37761L19,862@38124L3872,858@38012L3984:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                j = contentColor;
                int i4 = $composer2.changed(j) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                j = contentColor;
            }
            $dirty |= i4;
        } else {
            j = contentColor;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = edgePadding;
        } else if ((196608 & $changed) == 0) {
            f = edgePadding;
            $dirty |= $composer2.changed(f) ? 131072 : 65536;
        } else {
            f = edgePadding;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(scrollState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function5 = function2;
            containerColor3 = containerColor2;
            contentColor3 = j;
            edgePadding3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer2, 6);
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer2, 6);
                    $dirty &= -57345;
                } else {
                    contentColor2 = j;
                }
                edgePadding2 = i5 != 0 ? TabRowDefaults.INSTANCE.m2715getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f;
                function2M2140getLambda7$material3_release = i6 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.m2140getLambda7$material3_release() : function2;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    contentColor2 = j;
                    edgePadding2 = f;
                    modifier2 = modifier;
                    function2M2140getLambda7$material3_release = function2;
                } else {
                    modifier2 = modifier;
                    contentColor2 = j;
                    edgePadding2 = f;
                    function2M2140getLambda7$material3_release = function2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1696166011, $dirty, -1, "androidx.compose.material3.ScrollableTabRowImp (TabRow.kt:857)");
            }
            final float f2 = edgePadding2;
            final Function2<? super Composer, ? super Integer, Unit> function6 = function2M2140getLambda7$material3_release;
            float edgePadding4 = edgePadding2;
            SurfaceKt.m2666SurfaceT9BRK9s(modifier2, null, containerColor2, contentColor2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv$iv;
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C863@38155L24,864@38212L185,877@38665L3325,870@38406L3584:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1178901494, $changed2, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:863)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 121290664, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(scrollState) | $composer3.changed(coroutineScope);
                        ScrollState scrollState2 = scrollState;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new ScrollableTabData(scrollState2, coroutineScope);
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState, false, null, false, 14, null)));
                        ComposerKt.sourceInformationMarkerStart($composer3, 121291117, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(f2) | $composer3.changed(function4) | $composer3.changed(function6) | $composer3.changed(function3) | $composer3.changedInstance(scrollableTabData) | $composer3.changed(selectedTabIndex);
                        final float f3 = f2;
                        final Function2<Composer, Integer, Unit> function7 = function4;
                        final Function2<Composer, Integer, Unit> function8 = function6;
                        final int i7 = selectedTabIndex;
                        final Function3<List<TabPosition>, Composer, Integer, Unit> function9 = function3;
                        Object value$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2 || value$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m2729invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2729invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                    int minTabWidth = $this$SubcomposeLayout.mo561roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                    final int padding = $this$SubcomposeLayout.mo561roundToPx0680j_4(f3);
                                    List<Measurable> listSubcompose = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function7);
                                    Object initial$iv = 0;
                                    Object accumulator$iv = initial$iv;
                                    int index$iv$iv = 0;
                                    int size = listSubcompose.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = listSubcompose.get(index$iv$iv);
                                        Measurable measurable = (Measurable) item$iv$iv;
                                        int curr = ((Number) accumulator$iv).intValue();
                                        accumulator$iv = Integer.valueOf(Math.max(curr, measurable.maxIntrinsicHeight(Integer.MAX_VALUE)));
                                        index$iv$iv++;
                                        initial$iv = initial$iv;
                                    }
                                    final int layoutHeight = ((Number) accumulator$iv).intValue();
                                    long tabConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : minTabWidth, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : layoutHeight, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : layoutHeight);
                                    final List tabPlaceables = new ArrayList();
                                    final List tabContentWidths = new ArrayList();
                                    List<Measurable> list = listSubcompose;
                                    int $i$f$fastForEach = 0;
                                    int index$iv = 0;
                                    for (int size2 = list.size(); index$iv < size2; size2 = size2) {
                                        Object item$iv = list.get(index$iv);
                                        Measurable it = (Measurable) item$iv;
                                        Placeable placeable = it.mo5644measureBRTryo0(tabConstraints);
                                        List<Measurable> list2 = list;
                                        float contentWidth = $this$SubcomposeLayout.mo564toDpu2uoSUM(Math.min(it.maxIntrinsicWidth(placeable.getHeight()), placeable.getWidth()));
                                        float arg0$iv = TabKt.getHorizontalTextPadding();
                                        int $i$f$fastForEach2 = $i$f$fastForEach;
                                        float other$iv = C1979Dp.m6801constructorimpl(2 * arg0$iv);
                                        float other$iv2 = C1979Dp.m6801constructorimpl(contentWidth - other$iv);
                                        tabPlaceables.add(placeable);
                                        tabContentWidths.add(C1979Dp.m6799boximpl(other$iv2));
                                        index$iv++;
                                        list = list2;
                                        $i$f$fastForEach = $i$f$fastForEach2;
                                    }
                                    Object accumulator$iv2 = Integer.valueOf(padding * 2);
                                    int size3 = tabPlaceables.size();
                                    for (int index$iv$iv2 = 0; index$iv$iv2 < size3; index$iv$iv2++) {
                                        Object item$iv$iv2 = tabPlaceables.get(index$iv$iv2);
                                        Placeable measurable2 = (Placeable) item$iv$iv2;
                                        int curr2 = ((Number) accumulator$iv2).intValue();
                                        accumulator$iv2 = Integer.valueOf(curr2 + measurable2.getWidth());
                                    }
                                    final int layoutWidth = ((Number) accumulator$iv2).intValue();
                                    final Function2<Composer, Integer, Unit> function10 = function8;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i8 = i7;
                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function11 = function9;
                                    return MeasureScope.CC.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            final List tabPositions = new ArrayList();
                                            int left = padding;
                                            List<Placeable> list3 = tabPlaceables;
                                            SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                            List<C1979Dp> list4 = tabContentWidths;
                                            int index$iv2 = 0;
                                            int size4 = list3.size();
                                            while (index$iv2 < size4) {
                                                Object item$iv2 = list3.get(index$iv2);
                                                Placeable placeable2 = (Placeable) item$iv2;
                                                int index = index$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, left, 0, 0.0f, 4, null);
                                                tabPositions.add(new TabPosition(subcomposeMeasureScope.mo564toDpu2uoSUM(left), subcomposeMeasureScope.mo564toDpu2uoSUM(placeable2.getWidth()), list4.get(index).m6815unboximpl(), null));
                                                left += placeable2.getWidth();
                                                index$iv2++;
                                                list3 = list3;
                                            }
                                            List<Measurable> listSubcompose2 = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function10);
                                            long j2 = constraints;
                                            int i9 = layoutWidth;
                                            int i10 = layoutHeight;
                                            int index$iv3 = 0;
                                            for (int size5 = listSubcompose2.size(); index$iv3 < size5; size5 = size5) {
                                                Object item$iv3 = listSubcompose2.get(index$iv3);
                                                Measurable it2 = (Measurable) item$iv3;
                                                Placeable placeable3 = it2.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(j2, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(j2) : i9, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(j2) : i9, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(j2) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(j2) : 0));
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable3, 0, i10 - placeable3.getHeight(), 0.0f, 4, null);
                                                index$iv3++;
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<List<TabPosition>, Composer, Integer, Unit> function12 = function11;
                                            List<Measurable> listSubcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                public final void invoke(Composer $composer4, int $changed3) {
                                                    ComposerKt.sourceInformation($composer4, "C944@41537L23:TabRow.kt#uh7d8r");
                                                    if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                                        $composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(358596038, $changed3, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:944)");
                                                    }
                                                    function12.invoke(tabPositions, $composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i11 = layoutWidth;
                                            int i12 = layoutHeight;
                                            int size6 = listSubcompose3.size();
                                            for (int index$iv4 = 0; index$iv4 < size6; index$iv4++) {
                                                Object item$iv4 = listSubcompose3.get(index$iv4);
                                                Measurable it3 = (Measurable) item$iv4;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it3.mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(i11, i12)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut($this$SubcomposeLayout, padding, tabPositions, i8);
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) value$iv2, $composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 12582912 | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            edgePadding3 = edgePadding4;
            modifier3 = modifier2;
            contentColor3 = contentColor2;
            containerColor3 = containerColor2;
            function5 = function2M2140getLambda7$material3_release;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j2 = containerColor3;
            final long j3 = contentColor3;
            final float f3 = edgePadding3;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$2
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

                public final void invoke(Composer composer, int i7) {
                    TabRowKt.m2720ScrollableTabRowImpqhFBPw4(selectedTabIndex, function3, modifier4, j2, j3, f3, function7, function4, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
