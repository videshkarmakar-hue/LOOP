package androidx.compose.material3;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.window.PopupPositionProvider;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Label.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a^\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002"}, m195d2 = {"HandleInteractions", "", "enabled", "", "state", "Landroidx/compose/material3/BasicTooltipState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/material3/BasicTooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "Label", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "isPersistent", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LabelKt {
    public static final void Label(final Function3<? super CaretScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, MutableInteractionSource interactionSource, boolean isPersistent, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource;
        boolean isPersistent2;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource mutableInteractionSource2;
        LabelStateImpl state;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer2 = $composer.startRestartGroup(-544399326);
        ComposerKt.sourceInformation($composer2, "C(Label)P(3,4,1,2)73@3147L38,79@3377L33,80@3427L257,89@3735L139,99@3960L17,97@3880L249,106@4134L127:Label.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 4 : 2;
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
            mutableInteractionSource = interactionSource;
        } else if (($changed & 384) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer2.changed(mutableInteractionSource) ? 256 : 128;
        } else {
            mutableInteractionSource = interactionSource;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            isPersistent2 = isPersistent;
        } else if (($changed & 3072) == 0) {
            isPersistent2 = isPersistent;
            $dirty |= $composer2.changed(isPersistent2) ? 2048 : 1024;
        } else {
            isPersistent2 = isPersistent;
        }
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            interactionSource2 = mutableInteractionSource;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            interactionSource2 = i3 != 0 ? null : mutableInteractionSource;
            boolean isPersistent3 = i4 != 0 ? false : isPersistent2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-544399326, $dirty2, -1, "androidx.compose.material3.Label (Label.kt:69)");
            }
            $composer2.startReplaceGroup(-2061464869);
            ComposerKt.sourceInformation($composer2, "71@3009L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2061464848, "CC(remember):Label.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv;
                }
                mutableInteractionSource2 = (MutableInteractionSource) value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                mutableInteractionSource2 = interactionSource2;
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource3 = mutableInteractionSource2;
            PopupPositionProvider positionProvider = TooltipDefaults.INSTANCE.m2957rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer2, 48, 1);
            if (isPersistent3) {
                $composer2.startReplaceGroup(-2061464629);
                ComposerKt.sourceInformation($composer2, "75@3228L29");
                ComposerKt.sourceInformationMarkerStart($composer2, -2061464629, "CC(remember):Label.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new LabelStateImpl(false, false, 3, null);
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
                state = (LabelStateImpl) value$iv3;
            } else {
                $composer2.startReplaceGroup(-2061464582);
                ComposerKt.sourceInformation($composer2, "77@3275L56");
                state = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), $composer2, 0, 3);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2061464480, "CC(remember):Label.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, r6, 2, r6);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            final MutableState anchorBounds$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2061464430, "CC(remember):Label.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new CaretScope() { // from class: androidx.compose.material3.LabelKt$Label$scope$1$1
                    @Override // androidx.compose.material3.CaretScope
                    public Modifier drawCaret(Modifier $this$drawCaret, final Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function4) {
                        final MutableState<LayoutCoordinates> mutableState = anchorBounds$delegate;
                        return DrawModifierKt.drawWithCache($this$drawCaret, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.LabelKt$Label$scope$1$1$drawCaret$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                                return function4.invoke($this$drawWithCache, LabelKt.Label$lambda$3(mutableState));
                            }
                        });
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv4;
            }
            final LabelKt$Label$scope$1$1 scope = (LabelKt$Label$scope$1$1) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function2 wrappedContent = ComposableLambdaKt.rememberComposableLambda(1950723216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1
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
                    Object value$iv5;
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C91@3803L21,90@3745L123:Label.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1950723216, $changed2, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:90)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1482637739, "CC(remember):Label.kt#9igjgp");
                        final MutableState<LayoutCoordinates> mutableState = anchorBounds$delegate;
                        Object it$iv5 = $composer3.rememberedValue();
                        if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1$1$1
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
                            $composer3.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) value$iv5);
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -594506758, "C93@3849L9:Label.kt#uh7d8r");
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
            BasicTooltip_androidKt.BasicTooltipBox(positionProvider, ComposableLambdaKt.rememberComposableLambda(784196780, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt.Label.1
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
                    ComposerKt.sourceInformation($composer3, "C99@3968L7:Label.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(784196780, $changed2, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:99)");
                    }
                    function3.invoke(scope, $composer3, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), state, modifier3, false, false, wrappedContent, $composer2, (($dirty2 << 6) & 7168) | 1794096, 0);
            HandleInteractions(!isPersistent3, state, interactionSource3, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isPersistent2 = isPersistent3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final MutableInteractionSource mutableInteractionSource3 = interactionSource2;
            final boolean z = isPersistent2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt.Label.2
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
                    LabelKt.Label(function3, modifier4, mutableInteractionSource3, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates Label$lambda$3(MutableState<LayoutCoordinates> mutableState) {
        MutableState<LayoutCoordinates> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HandleInteractions(final boolean enabled, final BasicTooltipState state, final MutableInteractionSource interactionSource, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1479255681);
        ComposerKt.sourceInformation($composer2, "C(HandleInteractions)P(!1,2)121@4514L499,121@4480L533:Label.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1479255681, $dirty, -1, "androidx.compose.material3.HandleInteractions (Label.kt:119)");
            }
            if (enabled) {
                ComposerKt.sourceInformationMarkerStart($composer2, -404204266, "CC(remember):Label.kt#9igjgp");
                boolean invalid$iv = (($dirty & 896) == 256) | (($dirty & 112) == 32);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new LabelKt$HandleInteractions$1$1(interactionSource, state, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv, $composer2, ($dirty >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt.HandleInteractions.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    LabelKt.HandleInteractions(enabled, state, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
