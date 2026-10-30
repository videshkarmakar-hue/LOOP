package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.p001ui.AbsoluteAlignment;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.CacheDrawScope;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.draw.DrawResult;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.BlendMode;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.CanvasKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorFilter;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.p001ui.graphics.ImageBitmap;
import androidx.compose.p001ui.graphics.ImageBitmapConfig;
import androidx.compose.p001ui.graphics.ImageBitmapKt;
import androidx.compose.p001ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawContext;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawTransform;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.ViewConfiguration;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.style.ResolvedTextDirection;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.window.AndroidPopup_androidKt;
import androidx.compose.p001ui.window.PopupProperties;
import androidx.compose.p001ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t\u001aD\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\"\u0010 \u001a\u00020\u0014*\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m195d2 = {"HandlePopup", "", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "offsetProvider", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-pzduO1o", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidSelectionHandles_androidKt {
    /* JADX WARN: Code duplicated, block: B:85:0x0102  */
    /* JADX INFO: renamed from: SelectionHandle-pzduO1o, reason: not valid java name */
    public static final void m1458SelectionHandlepzduO1o(final OffsetProvider offsetProvider, final boolean isStartHandle, final ResolvedTextDirection direction, final boolean handlesCrossed, long minTouchTargetSize, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        long minTouchTargetSize2;
        long minTouchTargetSize3;
        int $dirty;
        Object value$iv;
        long minTouchTargetSize4;
        Composer $composer2 = $composer.startRestartGroup(-843755800);
        ComposerKt.sourceInformation($composer2, "C(SelectionHandle)P(5,2!2,3:c#ui.unit.DpSize)69@3042L326,80@3475L7,81@3579L1272,81@3487L1364:AndroidSelectionHandles.android.kt#eksfi3");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(offsetProvider) : $composer2.changedInstance(offsetProvider) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(isStartHandle) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(direction) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(handlesCrossed) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                minTouchTargetSize2 = minTouchTargetSize;
                int i2 = $composer2.changed(minTouchTargetSize2) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                minTouchTargetSize2 = minTouchTargetSize;
            }
            $dirty2 |= i2;
        } else {
            minTouchTargetSize2 = minTouchTargetSize;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 131072 : 65536;
        }
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            minTouchTargetSize4 = minTouchTargetSize2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    minTouchTargetSize3 = minTouchTargetSize2;
                    $dirty = $dirty2 & (-57345);
                } else {
                    minTouchTargetSize3 = minTouchTargetSize2;
                    $dirty = $dirty2;
                }
            } else if ((i & 16) != 0) {
                minTouchTargetSize3 = DpSize.INSTANCE.m6908getUnspecifiedMYxV2XQ();
                $dirty = $dirty2 & (-57345);
            } else {
                minTouchTargetSize3 = minTouchTargetSize2;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843755800, $dirty, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:64)");
            }
            final boolean isLeft = SelectionHandlesKt.isLeftSelectionHandle(isStartHandle, direction, handlesCrossed);
            AbsoluteAlignment absoluteAlignment = AbsoluteAlignment.INSTANCE;
            Alignment handleReferencePoint = isLeft ? absoluteAlignment.getTopRight() : absoluteAlignment.getTopLeft();
            ComposerKt.sourceInformationMarkerStart($composer2, 1221599223, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(offsetProvider))) | (($dirty & 112) == 32) | $composer2.changed(isLeft);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        long position = offsetProvider.mo1150provideF1C5BW0();
                        $this$semantics.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd, position, isLeft ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, OffsetKt.m4068isSpecifiedk4lQ0M(position), null));
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Modifier semanticsModifier = SemanticsModifierKt.semantics$default(modifier, false, (Function1) value$iv, 1, null);
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume;
            final long j = minTouchTargetSize3;
            long minTouchTargetSize5 = minTouchTargetSize3;
            HandlePopup(offsetProvider, handleReferencePoint, ComposableLambdaKt.rememberComposableLambda(280174801, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C82@3665L1180,82@3589L1256:AndroidSelectionHandles.android.kt#eksfi3");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(280174801, $changed2, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:82)");
                        }
                        ProvidedValue<ViewConfiguration> providedValueProvides = CompositionLocalsKt.getLocalViewConfiguration().provides(viewConfiguration);
                        final long j2 = j;
                        final boolean z = isLeft;
                        final Modifier modifier2 = semanticsModifier;
                        final OffsetProvider offsetProvider2 = offsetProvider;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1426434671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                Object value$iv2;
                                Function0<ComposeUiNode> function0;
                                Object value$iv3;
                                ComposerKt.sourceInformation($composer4, "C:AndroidSelectionHandles.android.kt#eksfi3");
                                if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1426434671, $changed3, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:83)");
                                }
                                long $this$isSpecified$iv = j2;
                                if ($this$isSpecified$iv != 9205357640488583168L) {
                                    $composer4.startReplaceGroup(-215396626);
                                    ComposerKt.sourceInformation($composer4, "92@4044L538");
                                    Arrangement.Horizontal arrangement = z ? Arrangement.Absolute.INSTANCE.getRight() : Arrangement.Absolute.INSTANCE.getLeft();
                                    Modifier modifierM909requiredSizeInqDBjuR0$default = SizeKt.m909requiredSizeInqDBjuR0$default(modifier2, DpSize.m6899getWidthD9Ej5fM(j2), DpSize.m6897getHeightD9Ej5fM(j2), 0.0f, 0.0f, 12, null);
                                    final OffsetProvider offsetProvider3 = offsetProvider2;
                                    boolean z2 = z;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(arrangement, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifierM909requiredSizeInqDBjuR0$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                    if (!($composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer4.startReusableNode();
                                    if ($composer4.getInserting()) {
                                        function0 = constructor;
                                        $composer4.createNode(function0);
                                    } else {
                                        function0 = constructor;
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
                                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    int i4 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -985380740, "C101@4460L40,99@4356L208:AndroidSelectionHandles.android.kt#eksfi3");
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -985380636, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                                    boolean invalid$iv2 = $composer4.changedInstance(offsetProvider3);
                                    Object it$iv2 = $composer4.rememberedValue();
                                    if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1$1$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                return Boolean.valueOf(OffsetKt.m4068isSpecifiedk4lQ0M(offsetProvider3.mo1150provideF1C5BW0()));
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv2;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(companion, (Function0) value$iv3, z2, $composer4, 6);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    $composer4.endReplaceGroup();
                                } else {
                                    $composer4.startReplaceGroup(-215395869);
                                    ComposerKt.sourceInformation($composer4, "108@4725L40,106@4620L201");
                                    Modifier modifier3 = modifier2;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -215395764, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                                    boolean invalid$iv3 = $composer4.changedInstance(offsetProvider2);
                                    final OffsetProvider offsetProvider4 = offsetProvider2;
                                    Object it$iv3 = $composer4.rememberedValue();
                                    if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                        value$iv2 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1$1$2$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                return Boolean.valueOf(OffsetKt.m4068isSpecifiedk4lQ0M(offsetProvider4.mo1150provideF1C5BW0()));
                                            }
                                        };
                                        $composer4.updateRememberedValue(value$iv2);
                                    } else {
                                        value$iv2 = it$iv3;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier3, (Function0) value$iv2, z, $composer4, 0);
                                    $composer4.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            minTouchTargetSize4 = minTouchTargetSize5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j2 = minTouchTargetSize4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    AndroidSelectionHandles_androidKt.m1458SelectionHandlepzduO1o(offsetProvider, isStartHandle, direction, handlesCrossed, j2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void SelectionHandleIcon(final Modifier modifier, final Function0<Boolean> function0, final boolean isLeft, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(2111672474);
        ComposerKt.sourceInformation($composer2, "C(SelectionHandleIcon)P(2)123@5009L129:AndroidSelectionHandles.android.kt#eksfi3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(isLeft) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111672474, $dirty, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:122)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m915sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), function0, isLeft), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.SelectionHandleIcon.1
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
                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(modifier, function0, isLeft, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final Modifier drawSelectionHandle(Modifier $this$drawSelectionHandle, final Function0<Boolean> function0, final boolean isLeft) {
        return ComposedModifierKt.composed$default($this$drawSelectionHandle, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.drawSelectionHandle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                Object value$iv;
                $composer.startReplaceGroup(-196777734);
                ComposerKt.sourceInformation($composer, "C134@5309L7,135@5352L742:AndroidSelectionHandles.android.kt#eksfi3");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-196777734, $changed, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:134)");
                }
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final long handleColor = ((SelectionColors) objConsume).getSelectionHandleColor();
                ComposerKt.sourceInformationMarkerStart($composer, -1183152542, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                boolean invalid$iv = $composer.changed(handleColor) | $composer.changed(function0) | $composer.changed(isLeft);
                final Function0<Boolean> function1 = function0;
                final boolean z = isLeft;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                            float radius = Size.m4118getWidthimpl($this$drawWithCache.m3940getSizeNHjbRc()) / 2.0f;
                            final ImageBitmap handleImage = AndroidSelectionHandles_androidKt.createHandleImage($this$drawWithCache, radius);
                            final ColorFilter colorFilter = ColorFilter.Companion.m4332tintxETnrds$default(ColorFilter.INSTANCE, handleColor, 0, 2, null);
                            final Function0<Boolean> function2 = function1;
                            final boolean z2 = z;
                            return $this$drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) throws Throwable {
                                    invoke2(contentDrawScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ContentDrawScope $this$onDrawWithContent) throws Throwable {
                                    long previousSize$iv$iv;
                                    DrawContext $this$withTransform_u24lambda_u246$iv$iv;
                                    $this$onDrawWithContent.drawContent();
                                    if (!function2.invoke().booleanValue()) {
                                        return;
                                    }
                                    if (z2) {
                                        ContentDrawScope $this$scale_u2dFgt4K4Q_u24default$iv = $this$onDrawWithContent;
                                        ImageBitmap imageBitmap = handleImage;
                                        ColorFilter colorFilter2 = colorFilter;
                                        long pivot$iv = $this$scale_u2dFgt4K4Q_u24default$iv.mo4772getCenterF1C5BW0();
                                        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$scale_u2dFgt4K4Q_u24default$iv.getDrawContext();
                                        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.mo4779getSizeNHjbRc();
                                        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
                                        try {
                                            DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
                                            $this$scale_Fgt4K4Q_u24lambda_u242$iv.mo4786scale0AR0LA0(-1.0f, 1.0f, pivot$iv);
                                            try {
                                                DrawScope.CC.m4848drawImagegbVJVH8$default($this$scale_u2dFgt4K4Q_u24default$iv, imageBitmap, 0L, 0.0f, null, colorFilter2, 0, 46, null);
                                                $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
                                                $this$withTransform_u24lambda_u246$iv$iv2.mo4780setSizeuvyYCjk(previousSize$iv$iv2);
                                            } catch (Throwable th) {
                                                th = th;
                                                $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                                previousSize$iv$iv = previousSize$iv$iv2;
                                                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                                                $this$withTransform_u24lambda_u246$iv$iv.mo4780setSizeuvyYCjk(previousSize$iv$iv);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            previousSize$iv$iv = previousSize$iv$iv2;
                                            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv2;
                                        }
                                    } else {
                                        DrawScope.CC.m4848drawImagegbVJVH8$default($this$onDrawWithContent, handleImage, 0L, 0.0f, null, colorFilter, 0, 46, null);
                                    }
                                }
                            });
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifierDrawWithCache = DrawModifierKt.drawWithCache($this$composed, (Function1) value$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return modifierDrawWithCache;
            }
        }, 1, null);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope $this$createHandleImage, float radius) {
        ImageBitmap imageBitmap;
        Canvas canvas;
        CanvasDrawScope drawScope;
        int edge = ((int) Math.ceil(radius)) * 2;
        ImageBitmap imageBitmap2 = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas2 = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope drawScope2 = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap2 == null || canvas2 == null || edge > imageBitmap2.getWidth() || edge > imageBitmap2.getHeight()) {
            ImageBitmap imageBitmap3 = ImageBitmapKt.m4524ImageBitmapx__hDU$default(edge, edge, ImageBitmapConfig.INSTANCE.m4518getAlpha8_sVssgQ(), false, null, 24, null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap3);
            Canvas canvas3 = CanvasKt.Canvas(imageBitmap3);
            HandleImageCache.INSTANCE.setCanvas(canvas3);
            imageBitmap = imageBitmap3;
            canvas = canvas3;
        } else {
            imageBitmap = imageBitmap2;
            canvas = canvas2;
        }
        if (drawScope2 == null) {
            CanvasDrawScope drawScope3 = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(drawScope3);
            drawScope = drawScope3;
        } else {
            drawScope = drawScope2;
        }
        LayoutDirection layoutDirection$iv = $this$createHandleImage.getLayoutDirection();
        long size$iv = androidx.compose.p001ui.geometry.SizeKt.Size(imageBitmap.getWidth(), imageBitmap.getHeight());
        CanvasDrawScope this_$iv = drawScope;
        CanvasDrawScope.DrawParams drawParams = this_$iv.getDrawParams();
        Density prevDensity$iv = drawParams.getDensity();
        LayoutDirection prevLayoutDirection$iv = drawParams.getLayoutDirection();
        Canvas prevCanvas$iv = drawParams.getCanvas();
        long prevSize$iv = drawParams.getSize();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240$iv.setDensity($this$createHandleImage);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setLayoutDirection(layoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setCanvas(canvas);
        $this$draw_yzxVdVo_u24lambda_u240$iv.m4778setSizeuvyYCjk(size$iv);
        canvas.save();
        CanvasDrawScope $this$createHandleImage_u24lambda_u241 = this_$iv;
        DrawScope.CC.m4858drawRectnJ9OG0$default($this$createHandleImage_u24lambda_u241, Color.INSTANCE.m4317getBlack0d7_KjU(), 0L, $this$createHandleImage_u24lambda_u241.mo4773getSizeNHjbRc(), 0.0f, null, null, BlendMode.INSTANCE.m4206getClear0nO6VwU(), 58, null);
        DrawScope.CC.m4858drawRectnJ9OG0$default($this$createHandleImage_u24lambda_u241, ColorKt.Color(4278190080L), Offset.INSTANCE.m4065getZeroF1C5BW0(), androidx.compose.p001ui.geometry.SizeKt.Size(radius, radius), 0.0f, null, null, 0, 120, null);
        DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$createHandleImage_u24lambda_u241, ColorKt.Color(4278190080L), radius, OffsetKt.Offset(radius, radius), 0.0f, null, null, 0, 120, null);
        canvas.restore();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.m4778setSizeuvyYCjk(prevSize$iv);
        return imageBitmap;
    }

    public static final void HandlePopup(final OffsetProvider positionProvider, final Alignment handleReferencePoint, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(476043083);
        ComposerKt.sourceInformation($composer2, "C(HandlePopup)P(2,1)248@8967L127,251@9099L190:AndroidSelectionHandles.android.kt#eksfi3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(positionProvider) : $composer2.changedInstance(positionProvider) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(handleReferencePoint) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(476043083, $dirty2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:247)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1205359348, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
            boolean z = true;
            boolean z2 = ($dirty2 & 112) == 32;
            if (($dirty2 & 14) != 4 && (($dirty2 & 8) == 0 || !$composer2.changed(positionProvider))) {
                z = false;
            }
            boolean invalid$iv = z2 | z;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new HandlePositionProvider(handleReferencePoint, positionProvider);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            HandlePositionProvider popupPositionProvider = (HandlePositionProvider) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidPopup_androidKt.Popup(popupPositionProvider, null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function2, $composer2, (($dirty2 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.HandlePopup.1
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
                    AndroidSelectionHandles_androidKt.HandlePopup(positionProvider, handleReferencePoint, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
