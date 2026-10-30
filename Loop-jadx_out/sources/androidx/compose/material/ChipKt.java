package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
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

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0090\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÆ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, m195d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ChipKt {
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float HorizontalPadding = C1979Dp.m6801constructorimpl(12);
    private static final float LeadingIconStartSpacing = C1979Dp.m6801constructorimpl(4);
    private static final float LeadingIconEndSpacing = C1979Dp.m6801constructorimpl(8);
    private static final float TrailingIconSpacing = C1979Dp.m6801constructorimpl(8);
    private static final float SelectedIconContainerSize = C1979Dp.m6801constructorimpl(24);

    public static final void Chip(final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, ChipColors colors, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        MutableInteractionSource mutableInteractionSource;
        Shape shape2;
        ChipColors chipColors;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Modifier.Companion modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        CornerBasedShape shape3;
        BorderStroke border2;
        ChipColors colors2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Modifier modifier3;
        boolean enabled3;
        MutableInteractionSource interactionSource3;
        Shape shape4;
        BorderStroke border3;
        ChipColors colors3;
        Composer $composer2 = $composer.startRestartGroup(-368396408);
        ComposerKt.sourceInformation($composer2, "C(Chip)P(7,6,3,4,8!2,5)93@4288L6,95@4405L12,99@4550L21,105@4747L24,109@4905L1458,100@4576L1787:Chip.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 3072) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer2.changed(mutableInteractionSource) ? 2048 : 1024;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i5 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                shape2 = shape;
            }
            $dirty |= i5;
        } else {
            shape2 = shape;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(border) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                chipColors = colors;
                int i7 = $composer2.changed(chipColors) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                chipColors = colors;
            }
            $dirty |= i7;
        } else {
            chipColors = colors;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
            function4 = function2;
        } else if (($changed & 12582912) == 0) {
            function4 = function2;
            $dirty |= $composer2.changedInstance(function4) ? 8388608 : 4194304;
        } else {
            function4 = function2;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            border3 = border;
            shape4 = shape2;
            function6 = function4;
            colors3 = chipColors;
            enabled3 = enabled;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                interactionSource2 = i4 != 0 ? null : mutableInteractionSource;
                if ((i & 16) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty &= -57345;
                } else {
                    shape3 = shape2;
                }
                border2 = i6 != 0 ? null : border;
                if ((i & 64) != 0) {
                    colors2 = ChipDefaults.INSTANCE.m1610chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer2, 1572864, 63);
                    $dirty &= -3670017;
                } else {
                    colors2 = colors;
                }
                function5 = i8 != 0 ? null : function2;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    $dirty &= -3670017;
                    interactionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                    function5 = function4;
                    colors2 = chipColors;
                    border2 = border;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                    function5 = function4;
                    colors2 = chipColors;
                    border2 = border;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-368396408, $dirty, -1, "androidx.compose.material.Chip (Chip.kt:98)");
            }
            final State<Color> stateContentColor = colors2.contentColor(enabled2, $composer2, (($dirty >> 6) & 14) | (($dirty >> 15) & 112));
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.1
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
            long jM4301unboximpl = colors2.backgroundColor(enabled2, $composer2, (($dirty >> 6) & 14) | (($dirty >> 15) & 112)).getValue().m4301unboximpl();
            long jChip$lambda$0 = Chip$lambda$0(stateContentColor);
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            final ChipColors chipColors2 = colors2;
            final boolean z = enabled2;
            Function2<? super Composer, ? super Integer, Unit> function8 = function5;
            SurfaceKt.m1810SurfaceLPr_se0(function0, modifierSemantics$default, enabled2, shape3, jM4301unboximpl, Color.m4289copywmQWz5c(jChip$lambda$0, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jChip$lambda$0) : 1.0f, (14 & 2) != 0 ? Color.m4297getRedimpl(jChip$lambda$0) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jChip$lambda$0) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jChip$lambda$0) : 0.0f), border2, 0.0f, interactionSource2, ComposableLambdaKt.rememberComposableLambda(139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2
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
                    ComposerKt.sourceInformation($composer3, "C110@4987L1370,110@4915L1442:Chip.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(139076687, $changed2, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4293getAlphaimpl(ChipKt.Chip$lambda$0(stateContentColor))));
                        final Function2<Composer, Integer, Unit> function9 = function7;
                        final ChipColors chipColors3 = chipColors2;
                        final boolean z2 = z;
                        final Function3<RowScope, Composer, Integer, Unit> function10 = function3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1
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
                                ComposerKt.sourceInformation($composer4, "C112@5057L10,113@5088L1259,111@5001L1346:Chip.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(667535631, $changed3, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer4, 6).getBody2();
                                    final Function2<Composer, Integer, Unit> function11 = function9;
                                    final ChipColors chipColors4 = chipColors3;
                                    final boolean z3 = z2;
                                    final Function3<RowScope, Composer, Integer, Unit> function12 = function10;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.rememberComposableLambda(-1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.2.1.1
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
                                            float fM6801constructorimpl;
                                            Function0<ComposeUiNode> function1;
                                            ComposerKt.sourceInformation($composer5, "C114@5106L1227:Chip.kt#jmzs0o");
                                            if (($changed4 & 3) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1131213696, $changed4, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                                }
                                                Modifier modifierM898defaultMinSizeVpY3zN4$default = SizeKt.m898defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1613getMinHeightD9Ej5fM(), 1, null);
                                                if (function11 == null) {
                                                    fM6801constructorimpl = ChipKt.HorizontalPadding;
                                                } else {
                                                    fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                                                }
                                                Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(modifierM898defaultMinSizeVpY3zN4$default, fM6801constructorimpl, 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, null);
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function13 = function11;
                                                ChipColors chipColors5 = chipColors4;
                                                boolean z4 = z3;
                                                Function3<RowScope, Composer, Integer, Unit> function14 = function12;
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
                                                int i9 = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer5, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                                int $changed5 = ((432 >> 6) & 112) | 6;
                                                RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart($composer5, 2084788958, "C138@6306L9:Chip.kt#jmzs0o");
                                                $composer5.startReplaceGroup(2084788958);
                                                ComposerKt.sourceInformation($composer5, "129@5759L47,130@5869L32,131@5926L267,136@6218L45");
                                                if (function13 != null) {
                                                    SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, ChipKt.LeadingIconStartSpacing), $composer5, 6);
                                                    State<Color> stateLeadingIconContentColor = chipColors5.leadingIconContentColor(z4, $composer5, 0);
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(invoke$lambda$1$lambda$0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4293getAlphaimpl(invoke$lambda$1$lambda$0(stateLeadingIconContentColor))))}, function13, $composer5, 0);
                                                    SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, ChipKt.LeadingIconEndSpacing), $composer5, 6);
                                                }
                                                $composer5.endReplaceGroup();
                                                function14.invoke($this$invoke_u24lambda_u241, $composer5, Integer.valueOf($changed5 & 14));
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

                                        private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                            Object thisObj$iv = state.getValue();
                                            return ((Color) thisObj$iv).m4301unboximpl();
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
            }, $composer2, 54), $composer2, ($dirty & 14) | 805306368 | ($dirty & 896) | (($dirty >> 3) & 7168) | (3670016 & ($dirty << 3)) | (234881024 & ($dirty << 15)), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function8;
            modifier3 = modifier2;
            enabled3 = enabled2;
            interactionSource3 = interactionSource2;
            shape4 = shape3;
            border3 = border2;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = enabled3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            final Shape shape5 = shape4;
            final BorderStroke borderStroke = border3;
            final ChipColors chipColors3 = colors3;
            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3
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
                    ChipKt.Chip(function0, modifier4, z2, mutableInteractionSource2, shape5, borderStroke, chipColors3, function9, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Chip$lambda$0(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    /* JADX WARN: Code duplicated, block: B:88:0x0105  */
    public static final void FilterChip(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, SelectableChipColors colors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        BorderStroke border2;
        int $dirty;
        Shape shape2;
        SelectableChipColors colors2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Shape shape3;
        Modifier modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        BorderStroke border3;
        SelectableChipColors colors3;
        int $dirty2;
        boolean enabled3;
        Modifier modifier4;
        SelectableChipColors colors4;
        Composer $composer2;
        int i2;
        Composer $composer3 = $composer.startRestartGroup(-1259208246);
        ComposerKt.sourceInformation($composer3, "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)190@8782L6,192@8909L18,199@9240L31,206@9478L34,210@9652L3966,200@9276L4342:Chip.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer3.changed(interactionSource) ? 16384 : 8192;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer3.changed(shape)) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty3 |= 1572864;
            border2 = border;
        } else if (($changed & 1572864) == 0) {
            border2 = border;
            $dirty3 |= $composer3.changed(border2) ? 1048576 : 524288;
        } else {
            border2 = border;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) != 0) {
                i2 = 4194304;
            } else {
                if ((16777216 & $changed) == 0 ? $composer3.changed(colors) : $composer3.changedInstance(colors)) {
                    i2 = 8388608;
                } else {
                    i2 = 4194304;
                }
            }
            $dirty3 |= i2;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer3.changedInstance(function3) ? 536870912 : 268435456;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function4) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function5) ? 32 : 16;
        }
        if (($dirty3 & 306783379) == 306783378 && ($dirty1 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled3 = enabled;
            interactionSource2 = interactionSource;
            shape3 = shape;
            colors4 = colors;
            function8 = function2;
            function7 = function3;
            function6 = function4;
            $composer2 = $composer3;
            border3 = border2;
            modifier4 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i4 != 0 ? true : enabled;
                MutableInteractionSource interactionSource3 = i5 != 0 ? null : interactionSource;
                if ((i & 32) != 0) {
                    $dirty = $dirty3 & (-458753);
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                } else {
                    $dirty = $dirty3;
                    shape2 = shape;
                }
                if (i6 != 0) {
                    border2 = null;
                }
                if ((i & 128) != 0) {
                    colors2 = ChipDefaults.INSTANCE.m1611filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 805306368, 511);
                    $dirty &= -29360129;
                } else {
                    colors2 = colors;
                }
                Function2<? super Composer, ? super Integer, Unit> function9 = i7 != 0 ? null : function2;
                Function2<? super Composer, ? super Integer, Unit> function10 = i8 != 0 ? null : function3;
                if (i9 != 0) {
                    function7 = function10;
                    function8 = function9;
                    shape3 = shape2;
                    modifier3 = modifier5;
                    function6 = null;
                    enabled2 = enabled4;
                    interactionSource2 = interactionSource3;
                    border3 = border2;
                    colors3 = colors2;
                    $dirty2 = $dirty;
                } else {
                    function6 = function4;
                    function7 = function10;
                    function8 = function9;
                    shape3 = shape2;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                    interactionSource2 = interactionSource3;
                    border3 = border2;
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 128) != 0) {
                    interactionSource2 = interactionSource;
                    shape3 = shape;
                    colors3 = colors;
                    function8 = function2;
                    function7 = function3;
                    function6 = function4;
                    border3 = border2;
                    modifier3 = modifier2;
                    $dirty2 = (-29360129) & $dirty3;
                    enabled2 = enabled;
                } else {
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    shape3 = shape;
                    colors3 = colors;
                    function8 = function2;
                    function7 = function3;
                    function6 = function4;
                    border3 = border2;
                    modifier3 = modifier2;
                    $dirty2 = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1259208246, $dirty2, $dirty1, "androidx.compose.material.FilterChip (Chip.kt:197)");
            }
            final State<Color> stateContentColor = colors3.contentColor(enabled2, selected, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 15) & 896));
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6063getCheckboxo7Vup1c());
                }
            }, 1, null);
            long jM4301unboximpl = colors3.backgroundColor(enabled2, selected, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 15) & 896)).getValue().m4301unboximpl();
            long jM4301unboximpl2 = stateContentColor.getValue().m4301unboximpl();
            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function12 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function13 = function6;
            final SelectableChipColors selectableChipColors = colors3;
            final boolean z = enabled2;
            enabled3 = enabled2;
            modifier4 = modifier3;
            colors4 = colors3;
            $composer2 = $composer3;
            SurfaceKt.m1811SurfaceNy5ogXk(selected, function0, modifierSemantics$default, enabled3, shape3, jM4301unboximpl, Color.m4289copywmQWz5c(jM4301unboximpl2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl2) : 1.0f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl2) : 0.0f), border3, 0.0f, interactionSource2, ComposableLambdaKt.rememberComposableLambda(722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C211@9740L3872,211@9662L3950:Chip.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(722126431, $changed2, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:211)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4293getAlphaimpl(stateContentColor.getValue().m4301unboximpl())));
                        final Function2<Composer, Integer, Unit> function14 = function11;
                        final boolean z2 = selected;
                        final Function2<Composer, Integer, Unit> function15 = function12;
                        final Function2<Composer, Integer, Unit> function16 = function13;
                        final Function3<RowScope, Composer, Integer, Unit> function17 = function5;
                        final SelectableChipColors selectableChipColors2 = selectableChipColors;
                        final boolean z3 = z;
                        final State<Color> state = stateContentColor;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.2.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C213@9810L10,214@9841L3761,212@9754L3848:Chip.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1582291359, $changed3, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:212)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer5, 6).getBody2();
                                    final Function2<Composer, Integer, Unit> function18 = function14;
                                    final boolean z4 = z2;
                                    final Function2<Composer, Integer, Unit> function19 = function15;
                                    final Function2<Composer, Integer, Unit> function20 = function16;
                                    final Function3<RowScope, Composer, Integer, Unit> function21 = function17;
                                    final SelectableChipColors selectableChipColors3 = selectableChipColors2;
                                    final boolean z5 = z3;
                                    final State<Color> state2 = state;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.rememberComposableLambda(-1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.2.1.1
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

                                        public final void invoke(Composer $composer6, int $changed4) {
                                            float fM6801constructorimpl;
                                            float fM6801constructorimpl2;
                                            Function0<ComposeUiNode> function1;
                                            Function0<ComposeUiNode> function22;
                                            String str;
                                            Function0<ComposeUiNode> function23;
                                            ComposerKt.sourceInformation($composer6, "C215@9859L3729:Chip.kt#jmzs0o");
                                            if (($changed4 & 3) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1543702066, $changed4, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:215)");
                                                }
                                                Modifier modifierM898defaultMinSizeVpY3zN4$default = SizeKt.m898defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m1613getMinHeightD9Ej5fM(), 1, null);
                                                if (function18 == null && (!z4 || function19 == null)) {
                                                    fM6801constructorimpl = ChipKt.HorizontalPadding;
                                                } else {
                                                    fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                                                }
                                                if (function20 == null) {
                                                    fM6801constructorimpl2 = ChipKt.HorizontalPadding;
                                                } else {
                                                    fM6801constructorimpl2 = C1979Dp.m6801constructorimpl(0);
                                                }
                                                Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(modifierM898defaultMinSizeVpY3zN4$default, fM6801constructorimpl, 0.0f, fM6801constructorimpl2, 0.0f, 10, null);
                                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function24 = function18;
                                                boolean z6 = z4;
                                                Function2<Composer, Integer, Unit> function25 = function19;
                                                Function3<RowScope, Composer, Integer, Unit> function26 = function21;
                                                Function2<Composer, Integer, Unit> function27 = function20;
                                                SelectableChipColors selectableChipColors4 = selectableChipColors3;
                                                boolean z7 = z5;
                                                State<Color> state3 = state2;
                                                ComposerKt.sourceInformationMarkerStart($composer6, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                                int $changed$iv$iv = (432 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer6.startReusableNode();
                                                if ($composer6.getInserting()) {
                                                    function1 = constructor;
                                                    $composer6.createNode(function1);
                                                } else {
                                                    function1 = constructor;
                                                    $composer6.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer6);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i10 = ($changed$iv$iv$iv >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                                int i11 = ((432 >> 6) & 112) | 6;
                                                RowScope $this$invoke_u24lambda_u242 = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -1943412022, "C278@13061L264:Chip.kt#jmzs0o");
                                                $composer6.startReplaceGroup(-1943412022);
                                                ComposerKt.sourceInformation($composer6, "239@10921L47,240@10993L1955,276@12973L45");
                                                if (function24 != null || (z6 && function25 != null)) {
                                                    SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, ChipKt.LeadingIconStartSpacing), $composer6, 6);
                                                    ComposerKt.sourceInformationMarkerStart($composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    Modifier modifier$iv2 = Modifier.INSTANCE;
                                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                                    int $changed$iv$iv2 = (0 << 3) & 112;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                    CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
                                                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                                                    if (!($composer6.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer6.startReusableNode();
                                                    if ($composer6.getInserting()) {
                                                        function22 = constructor2;
                                                        $composer6.createNode(function22);
                                                    } else {
                                                        function22 = constructor2;
                                                        $composer6.useNode();
                                                    }
                                                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer6);
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                                    }
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                                    int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    int i13 = ((0 >> 6) & 112) | 6;
                                                    ComposerKt.sourceInformationMarkerStart($composer6, 649985710, "C:Chip.kt#jmzs0o");
                                                    $composer6.startReplaceGroup(649985710);
                                                    ComposerKt.sourceInformation($composer6, "242@11116L141,246@11290L297");
                                                    if (function24 != null) {
                                                        State<Color> stateLeadingIconColor = selectableChipColors4.leadingIconColor(z7, z6, $composer6, 0);
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(stateLeadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4293getAlphaimpl(stateLeadingIconColor.getValue().m4301unboximpl())))}, function24, $composer6, 0);
                                                    }
                                                    $composer6.endReplaceGroup();
                                                    $composer6.startReplaceGroup(-1943411208);
                                                    ComposerKt.sourceInformation($composer6, "265@12441L451");
                                                    if (!z6 || function25 == null) {
                                                        str = "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp";
                                                    } else {
                                                        Modifier.Companion overlayModifier = Modifier.INSTANCE;
                                                        long iconColor = state3.getValue().m4301unboximpl();
                                                        $composer6.startReplaceGroup(649986541);
                                                        ComposerKt.sourceInformation($composer6, "263@12334L34");
                                                        if (function24 != null) {
                                                            Modifier modifierM905requiredSize3ABfNKs = SizeKt.m905requiredSize3ABfNKs(Modifier.INSTANCE, ChipKt.SelectedIconContainerSize);
                                                            long iconColor2 = state3.getValue().m4301unboximpl();
                                                            overlayModifier = ClipKt.clip(BackgroundKt.m453backgroundbw27NRU(modifierM905requiredSize3ABfNKs, iconColor2, RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                            iconColor = selectableChipColors4.backgroundColor(z7, z6, $composer6, 0).getValue().m4301unboximpl();
                                                        }
                                                        $composer6.endReplaceGroup();
                                                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                                                        ComposerKt.sourceInformationMarkerStart($composer6, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                                                        int $changed$iv$iv3 = (48 << 3) & 112;
                                                        ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                        CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
                                                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, overlayModifier);
                                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                                        str = "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp";
                                                        ComposerKt.sourceInformationMarkerStart($composer6, -692256719, str);
                                                        if (!($composer6.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        $composer6.startReusableNode();
                                                        if ($composer6.getInserting()) {
                                                            function23 = constructor3;
                                                            $composer6.createNode(function23);
                                                        } else {
                                                            function23 = constructor3;
                                                            $composer6.useNode();
                                                        }
                                                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer6);
                                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                                        }
                                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                                        int i14 = ($changed$iv$iv$iv3 >> 6) & 14;
                                                        ComposerKt.sourceInformationMarkerStart($composer6, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                        int i15 = ((48 >> 6) & 112) | 6;
                                                        ComposerKt.sourceInformationMarkerStart($composer6, 333805226, "C269@12654L204:Chip.kt#jmzs0o");
                                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(iconColor)), function25, $composer6, ProvidedValue.$stable);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        $composer6.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                        ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    }
                                                    $composer6.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    $composer6.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                                    SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, ChipKt.LeadingIconEndSpacing), $composer6, 6);
                                                } else {
                                                    str = "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp";
                                                }
                                                $composer6.endReplaceGroup();
                                                Modifier modifier$iv3 = RowScope.CC.weight$default($this$invoke_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                                                ComposerKt.sourceInformationMarkerStart($composer6, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                                int $changed$iv$iv4 = (432 << 3) & 112;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                                                CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
                                                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
                                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -692256719, str);
                                                if (!($composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer6.startReusableNode();
                                                if ($composer6.getInserting()) {
                                                    $composer6.createNode(constructor4);
                                                } else {
                                                    $composer6.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3795constructorimpl($composer6);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                                                    $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                                                    $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                                                }
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                                int i16 = ($changed$iv$iv$iv4 >> 6) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer6, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                                                function26.invoke(RowScopeInstance.INSTANCE, $composer6, Integer.valueOf(((432 >> 6) & 112) | 6));
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                $composer6.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                $composer6.startReplaceGroup(-1181292549);
                                                ComposerKt.sourceInformation($composer6, "285@13398L43,286@13466L14,287@13505L43");
                                                if (function27 != null) {
                                                    SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, ChipKt.TrailingIconSpacing), $composer6, 6);
                                                    function27.invoke($composer6, 0);
                                                    SpacerKt.Spacer(SizeKt.m918width3ABfNKs(Modifier.INSTANCE, ChipKt.TrailingIconSpacing), $composer6, 6);
                                                }
                                                $composer6.endReplaceGroup();
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                $composer6.endNode();
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }, $composer5, 54), $composer5, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | (($dirty2 >> 3) & 57344) | (29360128 & ($dirty2 << 3)) | (1879048192 & ($dirty2 << 15)), 6, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z2 = enabled3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final Shape shape4 = shape3;
            final BorderStroke borderStroke = border3;
            final SelectableChipColors selectableChipColors2 = colors4;
            final Function2<? super Composer, ? super Integer, Unit> function14 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3
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

                public final void invoke(Composer composer, int i10) {
                    ChipKt.FilterChip(selected, function0, modifier6, z2, mutableInteractionSource, shape4, borderStroke, selectableChipColors2, function14, function15, function16, function5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
