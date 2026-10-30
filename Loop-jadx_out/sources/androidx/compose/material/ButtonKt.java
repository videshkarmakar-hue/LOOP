package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002"}, m195d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ButtonKt {
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        ButtonElevation buttonElevation;
        BorderStroke borderStroke;
        final PaddingValues contentPadding2;
        ButtonElevation elevation2;
        CornerBasedShape shape2;
        BorderStroke border2;
        ButtonColors colors2;
        int $dirty;
        Modifier modifier2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource mutableInteractionSource;
        MutableInteractionSource interactionSource4;
        Modifier modifier3;
        ButtonElevation elevation3;
        Shape shape3;
        BorderStroke border3;
        ButtonColors colors3;
        boolean enabled3;
        PaddingValues contentPadding3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-2116133464);
        ComposerKt.sourceInformation($composer2, "C(Button)P(8,7,5,6,4,9!2,3)97@4671L11,98@4717L6,100@4807L14,106@5091L21,112@5288L24,117@5536L699,107@5117L1118:Button.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            interactionSource2 = interactionSource;
        } else if (($changed & 3072) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed(interactionSource2) ? 2048 : 1024;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                buttonElevation = elevation;
                int i5 = $composer2.changed(buttonElevation) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                buttonElevation = elevation;
            }
            $dirty2 |= i5;
        } else {
            buttonElevation = elevation;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(shape)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            borderStroke = border;
        } else if ((1572864 & $changed) == 0) {
            borderStroke = border;
            $dirty2 |= $composer2.changed(borderStroke) ? 1048576 : 524288;
        } else {
            borderStroke = border;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(colors)) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
            contentPadding2 = contentPadding;
        } else if (($changed & 100663296) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            contentPadding2 = contentPadding;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty2;
        if ((306783379 & $dirty3) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            shape3 = shape;
            colors3 = colors;
            interactionSource4 = interactionSource2;
            border3 = borderStroke;
            contentPadding3 = contentPadding2;
            elevation3 = buttonElevation;
            enabled3 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i3 != 0 ? true : enabled2;
                MutableInteractionSource interactionSource5 = i4 != 0 ? null : interactionSource2;
                if ((i & 16) != 0) {
                    elevation2 = ButtonDefaults.INSTANCE.m1594elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, ProfileVerifier.CompilationStatus.f245xf2722a21, 31);
                    $dirty3 &= -57345;
                } else {
                    elevation2 = buttonElevation;
                }
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall();
                    $dirty3 &= -458753;
                } else {
                    shape2 = shape;
                }
                border2 = i6 != 0 ? null : border;
                if ((i & 128) != 0) {
                    colors2 = ButtonDefaults.INSTANCE.m1593buttonColorsro_MJ88(0L, 0L, 0L, 0L, $composer2, CpioConstants.C_ISBLK, 15);
                    $dirty3 &= -29360129;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $dirty = $dirty3;
                    contentPadding2 = ButtonDefaults.INSTANCE.getContentPadding();
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    interactionSource2 = interactionSource5;
                } else {
                    contentPadding2 = contentPadding;
                    $dirty = $dirty3;
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    interactionSource2 = interactionSource5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                shape2 = shape;
                colors2 = colors;
                $dirty = $dirty3;
                border2 = borderStroke;
                elevation2 = buttonElevation;
                modifier2 = modifier;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2116133464, $dirty, -1, "androidx.compose.material.Button (Button.kt:103)");
            }
            $composer2.startReplaceGroup(-423487505);
            ComposerKt.sourceInformation($composer2, "105@5020L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -423487484, "CC(remember):Button.kt#9igjgp");
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
            MutableInteractionSource interactionSource6 = mutableInteractionSource;
            final State<Color> stateContentColor = colors2.contentColor(enabled2, $composer2, (($dirty >> 6) & 14) | (($dirty >> 18) & 112));
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6062getButtono7Vup1c());
                }
            }, 1, null);
            long jM4301unboximpl = colors2.backgroundColor(enabled2, $composer2, (($dirty >> 6) & 14) | (($dirty >> 18) & 112)).getValue().m4301unboximpl();
            long jButton$lambda$1 = Button$lambda$1(stateContentColor);
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jButton$lambda$1, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jButton$lambda$1) : 1.0f, (14 & 2) != 0 ? Color.m4297getRedimpl(jButton$lambda$1) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jButton$lambda$1) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jButton$lambda$1) : 0.0f);
            $composer2.startReplaceGroup(-423487074);
            ComposerKt.sourceInformation($composer2, "115@5430L37");
            State<C1979Dp> stateElevation = elevation2 != null ? elevation2.elevation(enabled2, interactionSource6, $composer2, (($dirty >> 6) & 14) | (($dirty >> 6) & 896)) : null;
            $composer2.endReplaceGroup();
            SurfaceKt.m1810SurfaceLPr_se0(function0, modifierSemantics$default, enabled2, shape2, jM4301unboximpl, jM4289copywmQWz5c, border2, stateElevation != null ? stateElevation.getValue().m6815unboximpl() : C1979Dp.m6801constructorimpl(0), interactionSource6, ComposableLambdaKt.rememberComposableLambda(7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2
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
                    ComposerKt.sourceInformation($composer3, "C118@5618L611,118@5546L683:Button.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(7524271, $changed2, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:118)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4293getAlphaimpl(ButtonKt.Button$lambda$1(stateContentColor))));
                        final PaddingValues paddingValues = contentPadding2;
                        final Function3<RowScope, Composer, Integer, Unit> function4 = function3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1
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
                                ComposerKt.sourceInformation($composer4, "C120@5688L10,121@5720L499,119@5632L587:Button.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1699085201, $changed3, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:119)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography($composer4, 6).getButton();
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function3<RowScope, Composer, Integer, Unit> function5 = function4;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
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
                                            ComposerKt.sourceInformation($composer5, "C122@5738L467:Button.kt#jmzs0o");
                                            if (($changed4 & 3) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-630330208, $changed4, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
                                                }
                                                Modifier modifier$iv = PaddingKt.padding(SizeKt.m897defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1599getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1598getMinHeightD9Ej5fM()), paddingValues2);
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function6 = function5;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                                int $changed$iv$iv = (432 << 3) & 112;
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
                                                    $composer5.createNode(constructor);
                                                } else {
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
                                                ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                                function6.invoke(RowScopeInstance.INSTANCE, $composer5, Integer.valueOf(((432 >> 6) & 112) | 6));
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
            }, $composer2, 54), $composer2, ($dirty & 14) | 805306368 | ($dirty & 896) | (($dirty >> 6) & 7168) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource4 = interactionSource3;
            modifier3 = modifier2;
            elevation3 = elevation2;
            shape3 = shape2;
            border3 = border2;
            colors3 = colors2;
            enabled3 = enabled2;
            contentPadding3 = contentPadding2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z = enabled3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
            final ButtonElevation buttonElevation2 = elevation3;
            final Shape shape4 = shape3;
            final BorderStroke borderStroke2 = border3;
            final ButtonColors buttonColors = colors3;
            final PaddingValues paddingValues = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3
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
                    ButtonKt.Button(function0, modifier5, z, mutableInteractionSource2, buttonElevation2, shape4, borderStroke2, buttonColors, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Button$lambda$1(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    public static final void OutlinedButton(Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1776134358, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)174@8227L6,175@8284L14,176@8342L22,179@8482L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 4) != 0 ? true : enabled;
        MutableInteractionSource interactionSource2 = (i & 8) != 0 ? null : interactionSource;
        ButtonElevation elevation2 = (i & 16) != 0 ? null : elevation;
        Shape shape2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall() : shape;
        BorderStroke border2 = (i & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder($composer, 6) : border;
        ButtonColors colors2 = (i & 128) != 0 ? ButtonDefaults.INSTANCE.m1601outlinedButtonColorsRGew2ao(0L, 0L, 0L, $composer, 3072, 7) : colors;
        PaddingValues contentPadding2 = (i & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : contentPadding;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1776134358, $changed, -1, "androidx.compose.material.OutlinedButton (Button.kt:179)");
        }
        Button(function0, modifier2, enabled2, interactionSource2, elevation2, shape2, border2, colors2, contentPadding2, function3, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (29360128 & $changed) | (234881024 & $changed) | (1879048192 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void TextButton(Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, ButtonElevation elevation, Shape shape, BorderStroke border, ButtonColors colors, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 288797557, "C(TextButton)P(8,7,5,6,4,9!2,3)228@10754L6,230@10844L18,233@10990L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 4) != 0 ? true : enabled;
        MutableInteractionSource interactionSource2 = (i & 8) != 0 ? null : interactionSource;
        ButtonElevation elevation2 = (i & 16) != 0 ? null : elevation;
        Shape shape2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall() : shape;
        BorderStroke border2 = (i & 64) != 0 ? null : border;
        ButtonColors colors2 = (i & 128) != 0 ? ButtonDefaults.INSTANCE.m1602textButtonColorsRGew2ao(0L, 0L, 0L, $composer, 3072, 7) : colors;
        PaddingValues contentPadding2 = (i & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : contentPadding;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288797557, $changed, -1, "androidx.compose.material.TextButton (Button.kt:233)");
        }
        Button(function0, modifier2, enabled2, interactionSource2, elevation2, shape2, border2, colors2, contentPadding2, function3, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed) | (29360128 & $changed) | (234881024 & $changed) | (1879048192 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }
}
