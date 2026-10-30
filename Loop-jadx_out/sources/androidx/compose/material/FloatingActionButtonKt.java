package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
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
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
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
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0088\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aq\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m195d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FloatingActionButtonKt {
    private static final float FabSize = C1979Dp.m6801constructorimpl(56);
    private static final float ExtendedFabSize = C1979Dp.m6801constructorimpl(48);
    private static final float ExtendedFabIconPadding = C1979Dp.m6801constructorimpl(12);
    private static final float ExtendedFabTextPadding = C1979Dp.m6801constructorimpl(20);

    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    public static final void m1717FloatingActionButtonbogVsAg(final Function0<Unit> function0, Modifier modifier, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        long backgroundColor2;
        int $dirty;
        FloatingActionButtonElevation elevation2;
        int $dirty2;
        Shape shape3;
        long contentColor2;
        int $dirty3;
        int $dirty4;
        final long contentColor3;
        MutableInteractionSource interactionSource3;
        long contentColor4;
        Modifier modifier3;
        Shape shape4;
        long backgroundColor3;
        FloatingActionButtonElevation elevation3;
        Object value$iv;
        int $dirty5;
        Composer $composer2 = $composer.startRestartGroup(1028985328);
        ComposerKt.sourceInformation($composer2, "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)83@3890L6,84@3978L6,85@4022L32,86@4132L11,97@4531L28,99@4619L408,91@4310L717:FloatingActionButton.kt#jmzs0o");
        int $dirty6 = $changed;
        if ((i & 1) != 0) {
            $dirty6 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty6 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty6 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty6 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty6 |= 384;
            interactionSource2 = interactionSource;
        } else if (($changed & 384) == 0) {
            interactionSource2 = interactionSource;
            $dirty6 |= $composer2.changed(interactionSource2) ? 256 : 128;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 2048 : 1024;
                $dirty6 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty6 |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer2.changed(backgroundColor2) ? 16384 : 8192;
                $dirty6 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty6 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                $dirty5 = $dirty6;
                int i6 = $composer2.changed(contentColor) ? 131072 : 65536;
                $dirty = $dirty5 | i6;
            } else {
                $dirty5 = $dirty6;
            }
            $dirty = $dirty5 | i6;
        } else {
            $dirty = $dirty6;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                elevation2 = elevation;
                int i7 = $composer2.changed(elevation2) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                elevation2 = elevation;
            }
            $dirty |= i7;
        } else {
            elevation2 = elevation;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentColor4 = contentColor;
            interactionSource3 = interactionSource2;
            shape4 = shape2;
            backgroundColor3 = backgroundColor2;
            elevation3 = elevation2;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                MutableInteractionSource interactionSource4 = i3 != 0 ? null : interactionSource2;
                if ((i & 8) != 0) {
                    int $dirty7 = $dirty & (-7169);
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty2 = $dirty7;
                } else {
                    $dirty2 = $dirty;
                    shape3 = shape2;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1629getSecondary0d7_KjU();
                }
                if ((i & 32) != 0) {
                    $dirty3 = $dirty2 & (-458753);
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 12) & 14);
                } else {
                    contentColor2 = contentColor;
                    $dirty3 = $dirty2;
                }
                if ((i & 64) != 0) {
                    $dirty4 = $dirty3 & (-3670017);
                    modifier2 = modifier4;
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m1713elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer2, CpioConstants.C_ISBLK, 15);
                    shape2 = shape3;
                    interactionSource2 = interactionSource4;
                    contentColor3 = contentColor2;
                    backgroundColor2 = backgroundColor2;
                } else {
                    modifier2 = modifier4;
                    shape2 = shape3;
                    $dirty4 = $dirty3;
                    interactionSource2 = interactionSource4;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty4 = $dirty & (-3670017);
                    contentColor3 = contentColor;
                } else {
                    contentColor3 = contentColor;
                    $dirty4 = $dirty;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028985328, $dirty4, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:88)");
            }
            $composer2.startReplaceGroup(-2057936383);
            ComposerKt.sourceInformation($composer2, "90@4266L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2057936362, "CC(remember):FloatingActionButton.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                interactionSource2 = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource5 = interactionSource2;
            SurfaceKt.m1810SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6062getButtono7Vup1c());
                }
            }, 1, null), false, shape2, backgroundColor2, contentColor3, null, elevation2.elevation(interactionSource5, $composer2, ($dirty4 >> 15) & 112).getValue().m6815unboximpl(), interactionSource5, ComposableLambdaKt.rememberComposableLambda(1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
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
                    ComposerKt.sourceInformation($composer3, "C100@4701L320,100@4629L392:FloatingActionButton.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1972871863, $changed2, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:100)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4293getAlphaimpl(contentColor3)));
                        final Function2<Composer, Integer, Unit> function3 = function2;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                ComposerKt.sourceInformation($composer4, "C101@4746L10,101@4765L246,101@4715L296:FloatingActionButton.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1867794295, $changed3, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:101)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography($composer4, 6).getButton();
                                    final Function2<Composer, Integer, Unit> function4 = function3;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.2.1.1
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

                                        public final void invoke(Composer $composer5, int $changed4) {
                                            Function0<ComposeUiNode> function1;
                                            ComposerKt.sourceInformation($composer5, "C102@4783L214:FloatingActionButton.kt#jmzs0o");
                                            if (($changed4 & 3) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1567914264, $changed4, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:102)");
                                                }
                                                Modifier modifier$iv = SizeKt.m897defaultMinSizeVpY3zN4(Modifier.INSTANCE, FloatingActionButtonKt.FabSize, FloatingActionButtonKt.FabSize);
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                                                Function2<Composer, Integer, Unit> function5 = function4;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                int $changed$iv$iv = (54 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer5.startReusableNode();
                                                if ($composer5.getInserting()) {
                                                    function1 = constructor;
                                                    $composer5.createNode(function1);
                                                } else {
                                                    function1 = constructor;
                                                    $composer5.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer5);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i8 = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i9 = ((54 >> 6) & 112) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 638020714, "C106@4986L9:FloatingActionButton.kt#jmzs0o");
                                                function5.invoke($composer5, 0);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                $composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }, $composer4, 54), $composer4, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty4 & 14) | 805306368 | ($dirty4 & 7168) | (57344 & $dirty4) | (458752 & $dirty4), 68);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource3 = interactionSource2;
            contentColor4 = contentColor3;
            modifier3 = modifier2;
            shape4 = shape2;
            backgroundColor3 = backgroundColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Shape shape5 = shape4;
            final long j = backgroundColor3;
            final long j2 = contentColor4;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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
                    FloatingActionButtonKt.m1717FloatingActionButtonbogVsAg(function0, modifier5, mutableInteractionSource, shape5, j, j2, floatingActionButtonElevation, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    public static final void m1716ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, FloatingActionButtonElevation elevation, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function4;
        long j;
        long contentColor2;
        Modifier.Companion modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        MutableInteractionSource interactionSource2;
        CornerBasedShape shape2;
        long backgroundColor2;
        FloatingActionButtonElevation elevation2;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Shape shape3;
        MutableInteractionSource interactionSource3;
        long backgroundColor3;
        long contentColor3;
        FloatingActionButtonElevation elevation3;
        Composer $composer2 = $composer.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation($composer2, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)152@7254L6,153@7342L6,154@7386L32,155@7496L11,168@7878L487,157@7516L849:FloatingActionButton.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function4 = function3;
        } else if (($changed & 3072) == 0) {
            function4 = function3;
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        } else {
            function4 = function3;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= ((i & 32) == 0 && $composer2.changed(shape)) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                j = backgroundColor;
                int i5 = $composer2.changed(j) ? 1048576 : 524288;
                $dirty |= i5;
            } else {
                j = backgroundColor;
            }
            $dirty |= i5;
        } else {
            j = backgroundColor;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer2.changed(contentColor2) ? 8388608 : 4194304;
                $dirty |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i6;
        } else {
            contentColor2 = contentColor;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(elevation)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            interactionSource3 = interactionSource;
            shape3 = shape;
            elevation3 = elevation;
            function6 = function4;
            contentColor3 = contentColor2;
            backgroundColor3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function5 = i3 != 0 ? null : function4;
                interactionSource2 = i4 != 0 ? null : interactionSource;
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty &= -458753;
                } else {
                    shape2 = shape;
                }
                if ((i & 64) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1629getSecondary0d7_KjU();
                    $dirty &= -3670017;
                } else {
                    backgroundColor2 = j;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    elevation2 = FloatingActionButtonDefaults.INSTANCE.m1713elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, $composer2, CpioConstants.C_ISBLK, 15);
                    $dirty &= -234881025;
                } else {
                    elevation2 = elevation;
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
                    interactionSource2 = interactionSource;
                    shape2 = shape;
                    $dirty &= -234881025;
                    function5 = function4;
                    backgroundColor2 = j;
                    modifier2 = modifier;
                    elevation2 = elevation;
                } else {
                    modifier2 = modifier;
                    interactionSource2 = interactionSource;
                    shape2 = shape;
                    function5 = function4;
                    backgroundColor2 = j;
                    elevation2 = elevation;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555720195, $dirty, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:156)");
            }
            Modifier modifier4 = modifier2;
            m1717FloatingActionButtonbogVsAg(function0, SizeKt.m917sizeInqDBjuR0$default(modifier4, ExtendedFabSize, ExtendedFabSize, 0.0f, 0.0f, 12, null), interactionSource2, shape2, backgroundColor2, contentColor2, elevation2, ComposableLambdaKt.rememberComposableLambda(1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$1
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
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C170@7984L375:FloatingActionButton.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1418981691, $changed2, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
                        }
                        float startPadding = function5 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                        Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, startPadding, 0.0f, FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 10, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function7 = function5;
                        Function2<Composer, Integer, Unit> function8 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
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
                            function1 = constructor;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor;
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
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i8 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1435223672, "C181@8343L6:FloatingActionButton.kt#jmzs0o");
                        $composer3.startReplaceGroup(-1435223672);
                        ComposerKt.sourceInformation($composer3, "178@8247L6,179@8270L46");
                        if (function7 != null) {
                            function7.invoke($composer3, 0);
                            SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabIconPadding), $composer3, 6);
                        }
                        $composer3.endReplaceGroup();
                        function8.invoke($composer3, 0);
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
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 12582912 | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (($dirty >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            function6 = function5;
            shape3 = shape2;
            interactionSource3 = interactionSource2;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function6;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Shape shape4 = shape3;
            final long j2 = backgroundColor3;
            final long j3 = contentColor3;
            final FloatingActionButtonElevation floatingActionButtonElevation = elevation3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                    FloatingActionButtonKt.m1716ExtendedFloatingActionButtonwqdebIU(function2, function0, modifier5, function7, mutableInteractionSource, shape4, j2, j3, floatingActionButtonElevation, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
