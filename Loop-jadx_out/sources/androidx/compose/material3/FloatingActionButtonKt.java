package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u001a|\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008e\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001aq\u0010&\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aq\u0010)\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010(\u001aq\u0010+\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m195d2 = {"ExtendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "ExtendedFabEndIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "ExtendedFabMinimumWidth", "ExtendedFabStartIconPadding", "ExtendedFabTextPadding", "ExtendedFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FloatingActionButtonKt {
    private static final float ExtendedFabStartIconPadding = C1979Dp.m6801constructorimpl(16);
    private static final float ExtendedFabEndIconPadding = C1979Dp.m6801constructorimpl(12);
    private static final float ExtendedFabTextPadding = C1979Dp.m6801constructorimpl(20);
    private static final float ExtendedFabMinimumWidth = C1979Dp.m6801constructorimpl(80);
    private static final ExitTransition ExtendedFabCollapseAnimation = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, MotionTokens.INSTANCE.getEasingLinearCubicBezier(), 2, null), 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, null), Alignment.INSTANCE.getStart(), false, null, 12, null));
    private static final EnterTransition ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 100, MotionTokens.INSTANCE.getEasingLinearCubicBezier()), 0.0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, null), Alignment.INSTANCE.getStart(), false, null, 12, null));

    /* JADX INFO: renamed from: FloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2267FloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long containerColor, long contentColor, FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        long containerColor2;
        final long contentColor2;
        FloatingActionButtonElevation elevation2;
        Modifier.Companion modifier2;
        Shape shape3;
        int $dirty;
        long contentColor3;
        MutableInteractionSource interactionSource2;
        int $dirty2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource mutableInteractionSource;
        MutableInteractionSource interactionSource4;
        Modifier modifier3;
        Shape shape4;
        long containerColor3;
        long contentColor4;
        FloatingActionButtonElevation elevation3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-731723913);
        ComposerKt.sourceInformation($composer2, "C(FloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)99@4927L5,100@4991L14,101@5033L31,102@5142L11,115@5657L54,117@5771L539,108@5378L932:FloatingActionButton.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                shape2 = shape;
                int i3 = $composer2.changed(shape2) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty3 |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty3 |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty3 |= i5;
        } else {
            contentColor2 = contentColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                elevation2 = elevation;
                int i6 = $composer2.changed(elevation2) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                elevation2 = elevation;
            }
            $dirty3 |= i6;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changed(interactionSource) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty3) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            interactionSource4 = interactionSource;
            shape4 = shape2;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    shape3 = FloatingActionButtonDefaults.INSTANCE.getShape($composer2, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                    containerColor2 = FloatingActionButtonDefaults.INSTANCE.getContainerColor($composer2, 6);
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty3 & (-57345);
                    contentColor3 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty3 >> 9) & 14);
                } else {
                    $dirty = $dirty3;
                    contentColor3 = contentColor2;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m2259elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer2, CpioConstants.C_ISBLK, 15);
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                } else {
                    interactionSource2 = interactionSource;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    int i8 = $dirty3 & (-458753);
                    interactionSource2 = interactionSource;
                    $dirty2 = i8;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty2 = $dirty3;
                    interactionSource2 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-731723913, $dirty2, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:105)");
            }
            $composer2.startReplaceGroup(2094976080);
            ComposerKt.sourceInformation($composer2, "107@5334L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, 2094976101, "CC(remember):FloatingActionButton.kt#9igjgp");
                interactionSource3 = interactionSource2;
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource3 = interactionSource2;
                mutableInteractionSource = interactionSource3;
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource5 = mutableInteractionSource;
            SurfaceKt.m2669Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6062getButtono7Vup1c());
                }
            }, 1, null), false, shape2, containerColor2, contentColor2, elevation2.getDefaultElevation(), elevation2.shadowElevation$material3_release(interactionSource5, $composer2, ($dirty2 >> 12) & 112).getValue().m6815unboximpl(), null, interactionSource5, ComposableLambdaKt.rememberComposableLambda(1249316354, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2
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
                    ComposerKt.sourceInformation($composer3, "C120@5890L10,121@5961L343,118@5781L523:FloatingActionButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1249316354, $changed2, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:118)");
                        }
                        long j = contentColor2;
                        TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont());
                        final Function2<Composer, Integer, Unit> function3 = function2;
                        ProvideContentColorTextStyleKt.m3015ProvideContentColorTextStyle3JVO9M(j, textStyleFromToken, ComposableLambdaKt.rememberComposableLambda(-1771489750, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                Function0<ComposeUiNode> function1;
                                ComposerKt.sourceInformation($composer4, "C122@5975L319:FloatingActionButton.kt#uh7d8r");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1771489750, $changed3, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:122)");
                                    }
                                    Modifier modifier$iv = SizeKt.m897defaultMinSizeVpY3zN4(Modifier.INSTANCE, FabPrimaryTokens.INSTANCE.m3313getContainerWidthD9Ej5fM(), FabPrimaryTokens.INSTANCE.m3312getContainerHeightD9Ej5fM());
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function4 = function3;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                    int $changed$iv$iv = (54 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function1 = constructor;
                                        $composer4.createNode(function1);
                                    } else {
                                        function1 = constructor;
                                        $composer4.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i9 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i10 = ((54 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1007141251, "C129@6283L9:FloatingActionButton.kt#uh7d8r");
                                    function4.invoke($composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty2 & 14) | (($dirty2 << 3) & 7168) | (($dirty2 << 3) & 57344) | (458752 & ($dirty2 << 3)), 6, 260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource4 = interactionSource3;
            modifier3 = modifier2;
            shape4 = shape2;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Shape shape5 = shape4;
            final long j = containerColor3;
            final long j2 = contentColor4;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
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

                public final void invoke(Composer composer, int i9) {
                    FloatingActionButtonKt.m2267FloatingActionButtonXz6DiA(function0, modifier4, shape5, j, j2, floatingActionButtonElevation, mutableInteractionSource2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: SmallFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2269SmallFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long containerColor, long contentColor, FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        long containerColor2;
        long contentColor2;
        FloatingActionButtonElevation elevation2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier2;
        Shape shape3;
        int $dirty;
        long contentColor3;
        MutableInteractionSource interactionSource2;
        int $dirty2;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        Shape shape4;
        long containerColor3;
        long contentColor4;
        FloatingActionButtonElevation elevation3;
        Composer $composer2 = $composer.startRestartGroup(1444748300);
        ComposerKt.sourceInformation($composer2, "C(SmallFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)165@8182L10,166@8251L14,167@8293L31,168@8402L11,172@8517L431:FloatingActionButton.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                shape2 = shape;
                int i3 = $composer2.changed(shape2) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty3 |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty3 |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty3 |= i5;
        } else {
            contentColor2 = contentColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                elevation2 = elevation;
                int i6 = $composer2.changed(elevation2) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                elevation2 = elevation;
            }
            $dirty3 |= i6;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((1572864 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer2.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if (($dirty3 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
            interactionSource3 = mutableInteractionSource;
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    shape3 = FloatingActionButtonDefaults.INSTANCE.getSmallShape($composer2, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                    containerColor2 = FloatingActionButtonDefaults.INSTANCE.getContainerColor($composer2, 6);
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty3 & (-57345);
                    contentColor3 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty3 >> 9) & 14);
                } else {
                    $dirty = $dirty3;
                    contentColor3 = contentColor2;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m2259elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer2, CpioConstants.C_ISBLK, 15);
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                } else {
                    interactionSource2 = mutableInteractionSource;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 = $dirty3 & (-458753);
                    interactionSource2 = mutableInteractionSource;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty2 = $dirty3;
                    interactionSource2 = mutableInteractionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1444748300, $dirty2, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:171)");
            }
            m2267FloatingActionButtonXz6DiA(function0, SizeKt.m917sizeInqDBjuR0$default(modifier2, FabPrimarySmallTokens.INSTANCE.m3302getContainerWidthD9Ej5fM(), FabPrimarySmallTokens.INSTANCE.m3301getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape2, containerColor2, contentColor2, elevation2, interactionSource2, function2, $composer2, ($dirty2 & 14) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (3670016 & $dirty2) | (29360128 & $dirty2), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interactionSource3 = interactionSource2;
            shape4 = shape2;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Shape shape5 = shape4;
            final long j = containerColor3;
            final long j2 = contentColor4;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$1
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
                    FloatingActionButtonKt.m2269SmallFloatingActionButtonXz6DiA(function0, modifier4, shape5, j, j2, floatingActionButtonElevation, mutableInteractionSource2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: LargeFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2268LargeFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long containerColor, long contentColor, FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        long containerColor2;
        long contentColor2;
        FloatingActionButtonElevation elevation2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier2;
        Shape shape3;
        int $dirty;
        long contentColor3;
        MutableInteractionSource interactionSource2;
        int $dirty2;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        Shape shape4;
        long containerColor3;
        long contentColor4;
        FloatingActionButtonElevation elevation3;
        Composer $composer2 = $composer.startRestartGroup(-1650866856);
        ComposerKt.sourceInformation($composer2, "C(LargeFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)218@10820L10,219@10889L14,220@10931L31,221@11040L11,225@11155L431:FloatingActionButton.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                shape2 = shape;
                int i3 = $composer2.changed(shape2) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty3 |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty3 |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty3 |= i5;
        } else {
            contentColor2 = contentColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                elevation2 = elevation;
                int i6 = $composer2.changed(elevation2) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                elevation2 = elevation;
            }
            $dirty3 |= i6;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if ((1572864 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer2.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if (($dirty3 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
            interactionSource3 = mutableInteractionSource;
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    shape3 = FloatingActionButtonDefaults.INSTANCE.getLargeShape($composer2, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                    containerColor2 = FloatingActionButtonDefaults.INSTANCE.getContainerColor($composer2, 6);
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty3 & (-57345);
                    contentColor3 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty3 >> 9) & 14);
                } else {
                    $dirty = $dirty3;
                    contentColor3 = contentColor2;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m2259elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer2, CpioConstants.C_ISBLK, 15);
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                } else {
                    interactionSource2 = mutableInteractionSource;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 = $dirty3 & (-458753);
                    interactionSource2 = mutableInteractionSource;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty2 = $dirty3;
                    interactionSource2 = mutableInteractionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1650866856, $dirty2, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:224)");
            }
            m2267FloatingActionButtonXz6DiA(function0, SizeKt.m917sizeInqDBjuR0$default(modifier2, FabPrimaryLargeTokens.INSTANCE.m3291getContainerWidthD9Ej5fM(), FabPrimaryLargeTokens.INSTANCE.m3290getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape2, containerColor2, contentColor2, elevation2, interactionSource2, function2, $composer2, ($dirty2 & 14) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (3670016 & $dirty2) | (29360128 & $dirty2), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interactionSource3 = interactionSource2;
            shape4 = shape2;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Shape shape5 = shape4;
            final long j = containerColor3;
            final long j2 = contentColor4;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$1
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
                    FloatingActionButtonKt.m2268LargeFloatingActionButtonXz6DiA(function0, modifier4, shape5, j, j2, floatingActionButtonElevation, mutableInteractionSource2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2266ExtendedFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long containerColor, long contentColor, FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        long containerColor2;
        long contentColor2;
        FloatingActionButtonElevation elevation2;
        Modifier.Companion modifier2;
        Shape shape3;
        int $dirty;
        long contentColor3;
        MutableInteractionSource interactionSource2;
        int $dirty2;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        Shape shape4;
        long containerColor3;
        long contentColor4;
        FloatingActionButtonElevation elevation3;
        Composer $composer2 = $composer.startRestartGroup(-326283107);
        ComposerKt.sourceInformation($composer2, "C(ExtendedFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)274@13596L16,275@13671L14,276@13713L31,277@13822L11,289@14209L332,281@13946L595:FloatingActionButton.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                shape2 = shape;
                int i3 = $composer2.changed(shape2) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer2.changed(containerColor2) ? 2048 : 1024;
                $dirty3 |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty3 |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty3 |= i5;
        } else {
            contentColor2 = contentColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                elevation2 = elevation;
                int i6 = $composer2.changed(elevation2) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                elevation2 = elevation;
            }
            $dirty3 |= i6;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changed(interactionSource) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty3) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            interactionSource3 = interactionSource;
            shape4 = shape2;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    shape3 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape($composer2, 6);
                } else {
                    shape3 = shape2;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                    containerColor2 = FloatingActionButtonDefaults.INSTANCE.getContainerColor($composer2, 6);
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty3 & (-57345);
                    contentColor3 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty3 >> 9) & 14);
                } else {
                    $dirty = $dirty3;
                    contentColor3 = contentColor2;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m2259elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer2, CpioConstants.C_ISBLK, 15);
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                } else {
                    interactionSource2 = interactionSource;
                    shape2 = shape3;
                    contentColor2 = contentColor3;
                    $dirty2 = $dirty;
                    containerColor2 = containerColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    int i8 = $dirty3 & (-458753);
                    interactionSource2 = interactionSource;
                    $dirty2 = i8;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty2 = $dirty3;
                    interactionSource2 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-326283107, $dirty2, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:280)");
            }
            m2267FloatingActionButtonXz6DiA(function0, modifier2, shape2, containerColor2, contentColor2, elevation2, interactionSource2, ComposableLambdaKt.rememberComposableLambda(398457247, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$1
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
                    ComposerKt.sourceInformation($composer3, "C290@14219L316:FloatingActionButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(398457247, $changed2, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:290)");
                        }
                        Modifier modifier$iv = PaddingKt.m870paddingVpY3zN4$default(SizeKt.m917sizeInqDBjuR0$default(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabMinimumWidth, 0.0f, 0.0f, 0.0f, 14, null), FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 2, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
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
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        function4.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf(((438 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
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
            }, $composer2, 54), $composer2, ($dirty2 & 14) | 12582912 | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (3670016 & $dirty2), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interactionSource3 = interactionSource2;
            shape4 = shape2;
            containerColor3 = containerColor2;
            contentColor4 = contentColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Shape shape5 = shape4;
            final long j = containerColor3;
            final long j2 = contentColor4;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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

                public final void invoke(Composer composer, int i9) {
                    FloatingActionButtonKt.m2266ExtendedFloatingActionButtonXz6DiA(function0, modifier4, shape5, j, j2, floatingActionButtonElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    public static final void m2265ExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, Modifier modifier, boolean expanded, Shape shape, long containerColor, long contentColor, FloatingActionButtonElevation elevation, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final boolean expanded2;
        Shape shape2;
        int $dirty;
        FloatingActionButtonElevation elevation2;
        MutableInteractionSource mutableInteractionSource;
        int $dirty2;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        int $dirty3;
        FloatingActionButtonElevation elevation3;
        MutableInteractionSource interactionSource2;
        long contentColor3;
        int $dirty4;
        long containerColor3;
        boolean expanded3;
        long containerColor4;
        MutableInteractionSource interactionSource3;
        Modifier modifier3;
        Shape shape4;
        long contentColor4;
        FloatingActionButtonElevation elevation4;
        int $dirty5;
        Composer $composer2 = $composer.startRestartGroup(-1387401842);
        ComposerKt.sourceInformation($composer2, "C(ExtendedFloatingActionButton)P(9,4,7,6,3,8,0:c#ui.graphics.Color,1:c#ui.graphics.Color)345@17130L16,346@17205L14,347@17247L31,348@17356L11,359@17697L1006,351@17434L1269:FloatingActionButton.kt#uh7d8r");
        int $dirty6 = $changed;
        if ((i & 1) != 0) {
            $dirty6 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty6 |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty6 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty6 |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty6 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty6 |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty6 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty6 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty6 |= CpioConstants.C_ISBLK;
            expanded2 = expanded;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            expanded2 = expanded;
            $dirty6 |= $composer2.changed(expanded2) ? 16384 : 8192;
        } else {
            expanded2 = expanded;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 131072 : 65536;
                $dirty6 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty6 |= i4;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            $dirty6 |= ((i & 64) == 0 && $composer2.changed(containerColor)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                $dirty5 = $dirty6;
                int i5 = $composer2.changed(contentColor) ? 8388608 : 4194304;
                $dirty = $dirty5 | i5;
            } else {
                $dirty5 = $dirty6;
            }
            $dirty = $dirty5 | i5;
        } else {
            $dirty = $dirty6;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0) {
                elevation2 = elevation;
                int i6 = $composer2.changed(elevation2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty |= i6;
            } else {
                elevation2 = elevation;
            }
            $dirty |= i6;
        } else {
            elevation2 = elevation;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty |= 805306368;
            mutableInteractionSource = interactionSource;
        } else if ((805306368 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer2.changed(mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($dirty & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            containerColor4 = containerColor;
            contentColor4 = contentColor;
            expanded3 = expanded2;
            shape4 = shape2;
            interactionSource3 = mutableInteractionSource;
            elevation4 = elevation2;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean expanded4 = i3 != 0 ? true : expanded2;
                if ((i & 32) != 0) {
                    int $dirty7 = $dirty & (-458753);
                    shape3 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape($composer2, 6);
                    $dirty2 = $dirty7;
                } else {
                    $dirty2 = $dirty;
                    shape3 = shape2;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                    containerColor2 = FloatingActionButtonDefaults.INSTANCE.getContainerColor($composer2, 6);
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 128) != 0) {
                    $dirty3 = $dirty2 & (-29360129);
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty2 >> 18) & 14);
                } else {
                    contentColor2 = contentColor;
                    $dirty3 = $dirty2;
                }
                if ((i & 256) != 0) {
                    elevation3 = FloatingActionButtonDefaults.INSTANCE.m2259elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer2, CpioConstants.C_ISBLK, 15);
                    $dirty3 &= -234881025;
                } else {
                    elevation3 = elevation2;
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    modifier2 = modifier4;
                    elevation2 = elevation3;
                    shape2 = shape3;
                    contentColor3 = contentColor2;
                    expanded2 = expanded4;
                    $dirty4 = $dirty3;
                    containerColor3 = containerColor2;
                } else {
                    interactionSource2 = interactionSource;
                    modifier2 = modifier4;
                    elevation2 = elevation3;
                    shape2 = shape3;
                    contentColor3 = contentColor2;
                    expanded2 = expanded4;
                    $dirty4 = $dirty3;
                    containerColor3 = containerColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty4 = $dirty & (-234881025);
                    interactionSource2 = mutableInteractionSource;
                    containerColor3 = containerColor;
                    contentColor3 = contentColor;
                } else {
                    containerColor3 = containerColor;
                    interactionSource2 = mutableInteractionSource;
                    $dirty4 = $dirty;
                    contentColor3 = contentColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1387401842, $dirty4, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:350)");
            }
            boolean expanded5 = expanded2;
            m2267FloatingActionButtonXz6DiA(function0, modifier2, shape2, containerColor3, contentColor3, elevation2, interactionSource2, ComposableLambdaKt.rememberComposableLambda(1172118032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                    float startPadding;
                    float endPadding;
                    float fM3313getContainerWidthD9Ej5fM;
                    ComposerKt.sourceInformation($composer3, "C363@17859L838:FloatingActionButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1172118032, $changed2, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:360)");
                        }
                        if (expanded2) {
                            startPadding = FloatingActionButtonKt.ExtendedFabStartIconPadding;
                        } else {
                            startPadding = C1979Dp.m6801constructorimpl(0);
                        }
                        if (expanded2) {
                            endPadding = FloatingActionButtonKt.ExtendedFabTextPadding;
                        } else {
                            endPadding = C1979Dp.m6801constructorimpl(0);
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        if (expanded2) {
                            fM3313getContainerWidthD9Ej5fM = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                        } else {
                            fM3313getContainerWidthD9Ej5fM = FabPrimaryTokens.INSTANCE.m3313getContainerWidthD9Ej5fM();
                        }
                        Modifier modifierM872paddingqDBjuR0$default = PaddingKt.m872paddingqDBjuR0$default(SizeKt.m917sizeInqDBjuR0$default(companion, fM3313getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), startPadding, 0.0f, endPadding, 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical start = expanded2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function4 = function3;
                        boolean z = expanded2;
                        final Function2<Composer, Integer, Unit> function5 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(start, centerVertically, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierM872paddingqDBjuR0$default);
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
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i8 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScope $this$invoke_u24lambda_u240 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1419543781, "C373@18307L6,378@18501L186,374@18326L361:FloatingActionButton.kt#uh7d8r");
                        function4.invoke($composer3, 0);
                        AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u240, z, (Modifier) null, FloatingActionButtonKt.ExtendedFabExpandAnimation, FloatingActionButtonKt.ExtendedFabCollapseAnimation, (String) null, ComposableLambdaKt.rememberComposableLambda(176242764, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3$1$1
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

                            public final void invoke(AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer4, int $changed3) {
                                Function0<ComposeUiNode> function1;
                                ComposerKt.sourceInformation($composer4, "C379@18519L154:FloatingActionButton.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(176242764, $changed3, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:379)");
                                }
                                Modifier modifier$iv = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3$1$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                                    }
                                });
                                Function2<Composer, Integer, Unit> function6 = function5;
                                ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv2 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    function1 = constructor2;
                                    $composer4.createNode(function1);
                                } else {
                                    function1 = constructor2;
                                    $composer4.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer4);
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                }
                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                int i10 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, 180817645, "C380@18579L49,381@18649L6:FloatingActionButton.kt#uh7d8r");
                                SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabEndIconPadding), $composer4, 6);
                                function6.invoke($composer4, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, ((((384 >> 6) & 112) | 6) & 14) | 1600512, 18);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
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
            }, $composer2, 54), $composer2, (($dirty4 >> 6) & 14) | 12582912 | (($dirty4 >> 6) & 112) | (($dirty4 >> 9) & 896) | (($dirty4 >> 9) & 7168) | (($dirty4 >> 9) & 57344) | (($dirty4 >> 9) & 458752) | (3670016 & ($dirty4 >> 9)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            expanded3 = expanded5;
            containerColor4 = containerColor3;
            interactionSource3 = interactionSource2;
            modifier3 = modifier2;
            shape4 = shape2;
            contentColor4 = contentColor3;
            elevation4 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z = expanded3;
            final Shape shape5 = shape4;
            final long j = containerColor4;
            final long j2 = contentColor4;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation4;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$4
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
                    FloatingActionButtonKt.m2265ExtendedFloatingActionButtonElI57k(function2, function3, function0, modifier5, z, shape5, j, j2, floatingActionButtonElevation, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
