package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.window.PopupPositionProvider;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001al\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020!0%¢\u0006\u0002\b'¢\u0006\u0002\b(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020!01¢\u0006\u0002\b'H\u0007¢\u0006\u0002\u00102\u001a&\u00103\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020.2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a+\u00108\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020.2\b\b\u0002\u00106\u001a\u000207H\u0007¢\u0006\u0002\u00109\u001a\u001a\u0010:\u001a\u00020,*\u00020,2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020.0<H\u0000\u001a\u001c\u0010=\u001a\u00020,*\u00020,2\u0006\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020.H\u0001\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\t\u0010\u0003\"\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0012\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u0003\"\u0016\u0010\u0014\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0017\u0010\u0003\"\u0010\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001d\u0010\u0003\"\u0016\u0010\u001e\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001f\u0010\u0003¨\u0006@²\u0006\f\u0010A\u001a\u0004\u0018\u00010BX\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020DX\u008a\u0084\u0002²\u0006\n\u0010E\u001a\u00020DX\u008a\u0084\u0002"}, m195d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "getActionLabelBottomPadding", "()F", "F", "ActionLabelMinHeight", "getActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "RichTooltipMaxWidth", "getRichTooltipMaxWidth", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "TextBottomPadding", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "TooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "Lkotlin/Function0;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "textVerticalPadding", "subheadExists", "actionExists", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "scale", "", "alpha"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TooltipKt {
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float SpacingBetweenTooltipAndAnchor = C1979Dp.m6801constructorimpl(4);
    private static final float TooltipMinHeight = C1979Dp.m6801constructorimpl(24);
    private static final float TooltipMinWidth = C1979Dp.m6801constructorimpl(40);
    private static final float PlainTooltipMaxWidth = C1979Dp.m6801constructorimpl(200);
    private static final float PlainTooltipVerticalPadding = C1979Dp.m6801constructorimpl(4);
    private static final float PlainTooltipHorizontalPadding = C1979Dp.m6801constructorimpl(8);
    private static final PaddingValues PlainTooltipContentPadding = PaddingKt.m862PaddingValuesYgX7TsA(PlainTooltipHorizontalPadding, PlainTooltipVerticalPadding);
    private static final float RichTooltipMaxWidth = C1979Dp.m6801constructorimpl(320);
    private static final float RichTooltipHorizontalPadding = C1979Dp.m6801constructorimpl(16);
    private static final float HeightToSubheadFirstLine = C1979Dp.m6801constructorimpl(28);
    private static final float HeightFromSubheadToTextFirstLine = C1979Dp.m6801constructorimpl(24);
    private static final float TextBottomPadding = C1979Dp.m6801constructorimpl(16);
    private static final float ActionLabelMinHeight = C1979Dp.m6801constructorimpl(36);
    private static final float ActionLabelBottomPadding = C1979Dp.m6801constructorimpl(8);

    public static final void TooltipBox(final PopupPositionProvider positionProvider, final Function3<? super CaretScope, ? super Composer, ? super Integer, Unit> function3, final TooltipState state, Modifier modifier, boolean focusable, boolean enableUserInput, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean focusable2;
        boolean z;
        Object value$iv;
        Object value$iv2;
        Modifier modifier3;
        boolean enableUserInput2;
        boolean focusable3;
        Composer $composer2 = $composer.startRestartGroup(1836749106);
        ComposerKt.sourceInformation($composer2, "C(TooltipBox)P(4,6,5,3,2,1)129@5506L64,130@5615L33,131@5665L257,140@5973L139,150@6198L64,148@6118L310:Tooltip.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(positionProvider) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(state) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            focusable2 = focusable;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            focusable2 = focusable;
            $dirty |= $composer2.changed(focusable2) ? 16384 : 8192;
        } else {
            focusable2 = focusable;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = enableUserInput;
        } else if ((196608 & $changed) == 0) {
            z = enableUserInput;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = enableUserInput;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((599187 & $dirty) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            focusable3 = focusable2;
            enableUserInput2 = z;
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                focusable2 = true;
            }
            boolean enableUserInput3 = i4 != 0 ? true : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1836749106, $dirty, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:127)");
            }
            final Transition transition = TransitionKt.updateTransition((MutableTransitionState) state.getTransition(), "tooltip transition", $composer2, MutableTransitionState.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 2029980260, "CC(remember):Tooltip.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState anchorBounds$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 2029980310, "CC(remember):Tooltip.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new CaretScope() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1
                    @Override // androidx.compose.material3.CaretScope
                    public Modifier drawCaret(Modifier $this$drawCaret, final Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function4) {
                        final MutableState<LayoutCoordinates> mutableState = anchorBounds$delegate;
                        return DrawModifierKt.drawWithCache($this$drawCaret, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$drawCaret$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                                return function4.invoke($this$drawWithCache, TooltipKt.TooltipBox$lambda$1(mutableState));
                            }
                        });
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final TooltipKt$TooltipBox$scope$1$1 scope = (TooltipKt$TooltipBox$scope$1$1) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function2 wrappedContent = ComposableLambdaKt.rememberComposableLambda(-1130808188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
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
                    Object value$iv3;
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C142@6041L21,141@5983L123:Tooltip.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1130808188, $changed2, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:141)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1995831633, "CC(remember):Tooltip.kt#9igjgp");
                        final MutableState<LayoutCoordinates> mutableState = anchorBounds$delegate;
                        Object it$iv3 = $composer3.rememberedValue();
                        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                    invoke2(layoutCoordinates);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LayoutCoordinates it) {
                                    mutableState.setValue(it);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) value$iv3);
                        Function2<Composer, Integer, Unit> function4 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (6 << 3) & 112;
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
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
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
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i6 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -824895490, "C144@6087L9:Tooltip.kt#uh7d8r");
                        function4.invoke($composer3, 0);
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
            }, $composer2, 54);
            BasicTooltip_androidKt.BasicTooltipBox(positionProvider, ComposableLambdaKt.rememberComposableLambda(-149611544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt.TooltipBox.1
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C150@6200L60:Tooltip.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-149611544, $changed2, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:150)");
                    }
                    Modifier modifier$iv = TooltipKt.animateTooltip(Modifier.INSTANCE, transition);
                    Function3<CaretScope, Composer, Integer, Unit> function4 = function3;
                    TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$1 = scope;
                    ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
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
                        function0 = constructor;
                        $composer3.createNode(function0);
                    } else {
                        function0 = constructor;
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
                    int i5 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i6 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -824895334, "C150@6249L9:Tooltip.kt#uh7d8r");
                    function4.invoke(tooltipKt$TooltipBox$scope$1$1, $composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), state, modifier4, focusable2, enableUserInput3, wrappedContent, $composer2, ($dirty & 14) | 1572912 | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            enableUserInput2 = enableUserInput3;
            focusable3 = focusable2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = focusable3;
            final boolean z3 = enableUserInput2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt.TooltipBox.2
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
                    TooltipKt.TooltipBox(positionProvider, function3, state, modifier5, z2, z3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates TooltipBox$lambda$1(MutableState<LayoutCoordinates> mutableState) {
        MutableState<LayoutCoordinates> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final TooltipState rememberTooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1413230530, "C(rememberTooltipState)468@18906L232:Tooltip.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialIsVisible = false;
        }
        if ((i & 2) != 0) {
            isPersistent = false;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, $changed, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:468)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 512856540, "CC(remember):Tooltip.kt#9igjgp");
        boolean invalid$iv = (((($changed & 112) ^ 48) > 32 && $composer.changed(isPersistent)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(mutatorMutex)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new TooltipStateImpl(initialIsVisible, isPersistent, mutatorMutex);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return tooltipStateImpl;
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState TooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(initialIsVisible, isPersistent, mutatorMutex);
    }

    public static final Modifier textVerticalPadding(Modifier $this$textVerticalPadding, boolean subheadExists, boolean actionExists) {
        if (!subheadExists && !actionExists) {
            return PaddingKt.m870paddingVpY3zN4$default($this$textVerticalPadding, 0.0f, PlainTooltipVerticalPadding, 1, null);
        }
        return PaddingKt.m872paddingqDBjuR0$default(AlignmentLineKt.m719paddingFromBaselineVpY3zN4$default($this$textVerticalPadding, HeightFromSubheadToTextFirstLine, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, null);
    }

    public static final Modifier animateTooltip(Modifier $this$animateTooltip, final Transition<Boolean> transition) {
        return ComposedModifierKt.composed($this$animateTooltip, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("animateTooltip");
                $this$null.getProperties().set("transition", transition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TooltipKt.animateTooltip.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            private static final float invoke$lambda$1(State<Float> state) {
                Object thisObj$iv = state.getValue();
                return ((Number) thisObj$iv).floatValue();
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                $composer.startReplaceGroup(-1498516085);
                ComposerKt.sourceInformation($composer, "C610@23498L583,629@24111L561:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498516085, $changed, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:610)");
                }
                Transition<Boolean> transition2 = transition;
                Function3 transitionSpec$iv = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                        return invoke(segment, composer, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer $composer2, int $changed2) {
                        TweenSpec tweenSpecTween$default;
                        $composer2.startReplaceGroup(386845748);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(386845748, $changed2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:612)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        } else {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer2.endReplaceGroup();
                        return tweenSpecTween$default;
                    }
                };
                ComposerKt.sourceInformationMarkerStart($composer, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                int $changed$iv$iv = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                int $changed2 = ($changed$iv$iv >> 9) & 112;
                boolean it = transition2.getCurrentState().booleanValue();
                $composer.startReplaceGroup(-1553362193);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, $changed2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:627)");
                }
                float f = it ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                Object initialValue$iv$iv = Float.valueOf(f);
                int $changed3 = ($changed$iv$iv >> 9) & 112;
                boolean it2 = transition2.getTargetState().booleanValue();
                $composer.startReplaceGroup(-1553362193);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, $changed3, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:627)");
                }
                float f2 = it2 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                Object targetValue$iv$iv = Float.valueOf(f2);
                State scale$delegate = TransitionKt.createTransitionAnimation(transition2, initialValue$iv$iv, targetValue$iv$iv, transitionSpec$iv.invoke(transition2.getSegment(), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "tooltip transition: scaling", $composer, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Transition<Boolean> transition3 = transition;
                Function3 transitionSpec$iv2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                        return invoke(segment, composer, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer $composer2, int $changed4) {
                        TweenSpec tweenSpecTween$default;
                        $composer2.startReplaceGroup(-281714272);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-281714272, $changed4, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:631)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                        } else {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer2.endReplaceGroup();
                        return tweenSpecTween$default;
                    }
                };
                ComposerKt.sourceInformationMarkerStart($composer, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                int $changed4 = ($changed$iv$iv2 >> 9) & 112;
                boolean it3 = transition3.getCurrentState().booleanValue();
                $composer.startReplaceGroup(2073045083);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, $changed4, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:646)");
                }
                float f3 = it3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                Object initialValue$iv$iv2 = Float.valueOf(f3);
                int $changed5 = ($changed$iv$iv2 >> 9) & 112;
                boolean it4 = transition3.getTargetState().booleanValue();
                $composer.startReplaceGroup(2073045083);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, $changed5, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:646)");
                }
                float f4 = it4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                Object targetValue$iv$iv2 = Float.valueOf(f4);
                State alpha$delegate = TransitionKt.createTransitionAnimation(transition3, initialValue$iv$iv2, targetValue$iv$iv2, transitionSpec$iv2.invoke(transition3.getSegment(), $composer, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "tooltip transition: alpha", $composer, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifierM4452graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default($this$composed, invoke$lambda$1(scale$delegate), invoke$lambda$1(scale$delegate), invoke$lambda$3(alpha$delegate), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return modifierM4452graphicsLayerAp8cVGQ$default;
            }

            private static final float invoke$lambda$3(State<Float> state) {
                Object thisObj$iv = state.getValue();
                return ((Number) thisObj$iv).floatValue();
            }
        });
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    public static final float getPlainTooltipMaxWidth() {
        return PlainTooltipMaxWidth;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipMaxWidth() {
        return RichTooltipMaxWidth;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final float getHeightToSubheadFirstLine() {
        return HeightToSubheadFirstLine;
    }

    public static final float getActionLabelMinHeight() {
        return ActionLabelMinHeight;
    }

    public static final float getActionLabelBottomPadding() {
        return ActionLabelBottomPadding;
    }
}
