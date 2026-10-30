package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u009c\u0002\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(H\u0007¢\u0006\u0002\u00106J\r\u0010\u001e\u001a\u00020\u0013H\u0007¢\u0006\u0002\u00107JÂ\u0003\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u0002092\b\b\u0002\u0010>\u001a\u0002092\b\b\u0002\u0010?\u001a\u0002092\b\b\u0002\u0010@\u001a\u0002092\b\b\u0002\u0010A\u001a\u0002092\b\b\u0002\u0010B\u001a\u0002092\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010E\u001a\u0002092\b\b\u0002\u0010F\u001a\u0002092\b\b\u0002\u0010G\u001a\u0002092\b\b\u0002\u0010H\u001a\u0002092\b\b\u0002\u0010I\u001a\u0002092\b\b\u0002\u0010J\u001a\u0002092\b\b\u0002\u0010K\u001a\u0002092\b\b\u0002\u0010L\u001a\u0002092\b\b\u0002\u0010M\u001a\u0002092\b\b\u0002\u0010N\u001a\u0002092\b\b\u0002\u0010O\u001a\u0002092\b\b\u0002\u0010P\u001a\u0002092\b\b\u0002\u0010Q\u001a\u0002092\b\b\u0002\u0010R\u001a\u0002092\b\b\u0002\u0010S\u001a\u0002092\b\b\u0002\u0010T\u001a\u0002092\b\b\u0002\u0010U\u001a\u0002092\b\b\u0002\u0010V\u001a\u0002092\b\b\u0002\u0010W\u001a\u0002092\b\b\u0002\u0010X\u001a\u0002092\b\b\u0002\u0010Y\u001a\u0002092\b\b\u0002\u0010Z\u001a\u0002092\b\b\u0002\u0010[\u001a\u0002092\b\b\u0002\u0010\\\u001a\u0002092\b\b\u0002\u0010]\u001a\u0002092\b\b\u0002\u0010^\u001a\u0002092\b\b\u0002\u0010_\u001a\u0002092\b\b\u0002\u0010`\u001a\u0002092\b\b\u0002\u0010a\u001a\u0002092\b\b\u0002\u0010b\u001a\u0002092\b\b\u0002\u0010c\u001a\u0002092\b\b\u0002\u0010d\u001a\u000209H\u0007ø\u0001\u0000¢\u0006\u0004\be\u0010fJ8\u00103\u001a\u0002042\b\b\u0002\u0010g\u001a\u00020\u00042\b\b\u0002\u0010h\u001a\u00020\u00042\b\b\u0002\u0010i\u001a\u00020\u00042\b\b\u0002\u0010j\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bk\u0010lR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00148AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, m195d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "focusedBorderThickness", "unfocusedBorderThickness", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", DownloadUtil.CookieScheme.VALUE, "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = C1979Dp.m6801constructorimpl(56);
    private static final float MinWidth = C1979Dp.m6801constructorimpl(280);
    private static final float UnfocusedBorderThickness = C1979Dp.m6801constructorimpl(1);
    private static final float FocusedBorderThickness = C1979Dp.m6801constructorimpl(2);

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1066756961, "C638@33626L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:638)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2467getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2468getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2469getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2466getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    public final void m2463ContainerBoxnbWgWpA(final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        int $dirty;
        Shape shape3;
        float focusedBorderThickness3;
        float unfocusedBorderThickness2;
        float focusedBorderThickness4;
        Shape shape4;
        Composer $composer2 = $composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation($composer2, "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)685@35508L5,689@35675L203,697@35919L25,700@36075L78,701@36162L148:TextFieldDefaults.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i2 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i2;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                focusedBorderThickness2 = focusedBorderThickness;
                int i3 = $composer2.changed(focusedBorderThickness2) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            $dirty2 |= i3;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                f = unfocusedBorderThickness;
                int i4 = $composer2.changed(f) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                f = unfocusedBorderThickness;
            }
            $dirty2 |= i4;
        } else {
            f = unfocusedBorderThickness;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(this) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape4 = shape2;
            focusedBorderThickness4 = focusedBorderThickness2;
            unfocusedBorderThickness2 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 16) != 0) {
                    shape2 = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer2, 6);
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    focusedBorderThickness2 = FocusedBorderThickness;
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = UnfocusedBorderThickness;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461761386, $dirty, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:688)");
            }
            Shape shape5 = shape3;
            State borderStroke = TextFieldDefaultsKt.m2811animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness3, unfocusedBorderThickness2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            boolean focused = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer2, ($dirty >> 6) & 14).getValue().booleanValue();
            long containerColor = colors.m2733containerColorXeAY9LY$material3_release(enabled, isError, focused);
            BoxKt.Box(BackgroundKt.m453backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) borderStroke.getValue(), shape5), SingleValueAnimationKt.m351animateColorAsStateeuL9pac(containerColor, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer2, 48, 12).getValue().m4301unboximpl(), shape5), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            focusedBorderThickness4 = focusedBorderThickness3;
            shape4 = shape5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Shape shape6 = shape4;
            final float f2 = focusedBorderThickness4;
            final float f3 = unfocusedBorderThickness2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    this.$tmp0_rcvr.m2463ContainerBoxnbWgWpA(enabled, isError, interactionSource, colors, shape6, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2462contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m2465contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2465contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m864PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -471651810, "C(colors)724@36930L11,724@36942L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:724)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, ($changed << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultOutlinedTextFieldColors;
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m2464colors0hiis_0(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart($composer, 1767617725, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)825@43734L11,825@43746L30:TextFieldDefaults.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedTextColor;
        long unfocusedTextColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedTextColor;
        long disabledTextColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledTextColor;
        long errorTextColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorTextColor;
        long focusedContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedContainerColor;
        long unfocusedContainerColor2 = (i & 32) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedContainerColor;
        long disabledContainerColor2 = (i & 64) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long errorContainerColor2 = (i & 128) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorContainerColor;
        long cursorColor2 = (i & 256) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 512) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorCursorColor;
        SelectionColors selectionColors2 = (i & 1024) != 0 ? null : selectionColors;
        long focusedBorderColor2 = (i & 2048) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedBorderColor;
        long unfocusedBorderColor2 = (i & 4096) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedBorderColor;
        long disabledBorderColor2 = (i & 8192) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledBorderColor;
        long errorBorderColor2 = (i & 16384) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorBorderColor;
        long focusedLeadingIconColor2 = (32768 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (65536 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedLeadingIconColor;
        long disabledLeadingIconColor2 = (131072 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledLeadingIconColor;
        long errorLeadingIconColor2 = (262144 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorLeadingIconColor;
        long focusedTrailingIconColor2 = (524288 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (1048576 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedTrailingIconColor;
        long disabledTrailingIconColor2 = (2097152 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledTrailingIconColor;
        long errorTrailingIconColor2 = (4194304 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorTrailingIconColor;
        long focusedLabelColor2 = (8388608 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedLabelColor;
        long unfocusedLabelColor2 = (16777216 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedLabelColor;
        long disabledLabelColor2 = (33554432 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledLabelColor;
        long errorLabelColor2 = (67108864 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorLabelColor;
        long focusedPlaceholderColor2 = (134217728 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedPlaceholderColor;
        long unfocusedPlaceholderColor2 = (268435456 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedPlaceholderColor;
        long disabledPlaceholderColor2 = (536870912 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledPlaceholderColor;
        long errorPlaceholderColor2 = (i & BasicMeasure.EXACTLY) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorPlaceholderColor;
        long focusedSupportingTextColor2 = (i2 & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedSupportingTextColor;
        long unfocusedSupportingTextColor2 = (i2 & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedSupportingTextColor;
        long disabledSupportingTextColor2 = (i2 & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledSupportingTextColor;
        long errorSupportingTextColor2 = (i2 & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorSupportingTextColor;
        long focusedPrefixColor2 = (i2 & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedPrefixColor;
        long unfocusedPrefixColor2 = (i2 & 32) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedPrefixColor;
        long disabledPrefixColor2 = (i2 & 64) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledPrefixColor;
        long errorPrefixColor2 = (i2 & 128) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorPrefixColor;
        long focusedSuffixColor2 = (i2 & 256) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedSuffixColor;
        long unfocusedSuffixColor2 = (i2 & 512) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedSuffixColor;
        long disabledSuffixColor2 = (i2 & 1024) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledSuffixColor;
        long errorSuffixColor2 = (i2 & 2048) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorSuffixColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767617725, $changed, $changed1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:825)");
        }
        TextFieldColors textFieldColorsM2734copyejIjP34 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, ($changed4 >> 6) & 112).m2734copyejIjP34(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2734copyejIjP34;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme $this$defaultOutlinedTextFieldColors, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -292363577, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:873)");
        }
        TextFieldColors it = $this$defaultOutlinedTextFieldColors.getDefaultOutlinedTextFieldColorsCached();
        $composer.startReplaceGroup(880962820);
        ComposerKt.sourceInformation($composer, "*886@47362L7");
        if (it == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long jM4326getTransparent0d7_KjU = Color.INSTANCE.m4326getTransparent0d7_KjU();
            long jM4326getTransparent0d7_KjU2 = Color.INSTANCE.m4326getTransparent0d7_KjU();
            long jM4326getTransparent0d7_KjU3 = Color.INSTANCE.m4326getTransparent0d7_KjU();
            long jM4326getTransparent0d7_KjU4 = Color.INSTANCE.m4326getTransparent0d7_KjU();
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor());
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getOutlineColor());
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor());
            long jM4289copywmQWz5c2 = Color.m4289copywmQWz5c(jFromToken9, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken9) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken9) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken9) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken9) : 0.0f);
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor());
            long jFromToken11 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor());
            long jFromToken12 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor());
            long jFromToken13 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor());
            long jM4289copywmQWz5c3 = Color.m4289copywmQWz5c(jFromToken13, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken13) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken13) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken13) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken13) : 0.0f);
            long jFromToken14 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor());
            long jFromToken15 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor());
            long jFromToken16 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor());
            long jFromToken17 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor());
            long jM4289copywmQWz5c4 = Color.m4289copywmQWz5c(jFromToken17, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken17) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken17) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken17) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken17) : 0.0f);
            long jFromToken18 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor());
            long jFromToken19 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor());
            long jFromToken20 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getLabelColor());
            long jFromToken21 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor());
            long jM4289copywmQWz5c5 = Color.m4289copywmQWz5c(jFromToken21, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken21) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken21) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken21) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken21) : 0.0f);
            long jFromToken22 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor());
            long jFromToken23 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor());
            long jFromToken24 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor());
            long jFromToken25 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor());
            long jM4289copywmQWz5c6 = Color.m4289copywmQWz5c(jFromToken25, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken25) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken25) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken25) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken25) : 0.0f);
            long jFromToken26 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor());
            long jFromToken27 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor());
            long jFromToken28 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getSupportingColor());
            long jFromToken29 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor());
            long jM4289copywmQWz5c7 = Color.m4289copywmQWz5c(jFromToken29, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken29) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken29) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken29) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken29) : 0.0f);
            long jFromToken30 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor());
            long jFromToken31 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jFromToken32 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jFromToken33 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jM4289copywmQWz5c8 = Color.m4289copywmQWz5c(jFromToken33, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken33) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken33) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken33) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken33) : 0.0f);
            long jFromToken34 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jFromToken35 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor());
            long jFromToken36 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor());
            long jFromToken37 = ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor());
            it = new TextFieldColors(jFromToken, jFromToken2, jM4289copywmQWz5c, jFromToken4, jM4326getTransparent0d7_KjU, jM4326getTransparent0d7_KjU2, jM4326getTransparent0d7_KjU3, jM4326getTransparent0d7_KjU4, jFromToken5, jFromToken6, (SelectionColors) objConsume, jFromToken7, jFromToken8, jM4289copywmQWz5c2, jFromToken10, jFromToken11, jFromToken12, jM4289copywmQWz5c3, jFromToken14, jFromToken15, jFromToken16, jM4289copywmQWz5c4, jFromToken18, jFromToken19, jFromToken20, jM4289copywmQWz5c5, jFromToken22, jFromToken23, jFromToken24, jM4289copywmQWz5c6, jFromToken26, jFromToken27, jFromToken28, jM4289copywmQWz5c7, jFromToken30, jFromToken31, jFromToken32, jM4289copywmQWz5c8, jFromToken34, jFromToken35, jFromToken36, Color.m4289copywmQWz5c(jFromToken37, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken37) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken37) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken37) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken37) : 0.0f), ColorSchemeKt.fromToken($this$defaultOutlinedTextFieldColors, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            $this$defaultOutlinedTextFieldColors.setDefaultOutlinedTextFieldColorsCached$material3_release(it);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return it;
    }

    public final void DecorationBox(final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean enabled, final boolean singleLine, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, Function2<? super Composer, ? super Integer, Unit> function9, TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> function10, Composer $composer, final int $changed, final int $changed1, final int i) {
        final boolean isError2;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        final TextFieldColors colors2;
        PaddingValues contentPadding2;
        int $dirty1;
        Function2<? super Composer, ? super Integer, Unit> function15;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Function2<? super Composer, ? super Integer, Unit> function17;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        PaddingValues contentPadding3;
        Function2<? super Composer, ? super Integer, Unit> function18;
        Function2<? super Composer, ? super Integer, Unit> function19;
        Function2<? super Composer, ? super Integer, Unit> function20;
        PaddingValues contentPadding4;
        Function2<? super Composer, ? super Integer, Unit> function21;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        boolean isError3;
        TextFieldColors colors3;
        Composer $composer2 = $composer.startRestartGroup(-350442135);
        ComposerKt.sourceInformation($composer2, "C(DecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1011@56267L8,1013@56379L159,1022@56555L709:TextFieldDefaults.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty2 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(singleLine) ? 2048 : 1024;
        }
        int i2 = 8192;
        if ((i & 16) != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(isError) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 536870912 : 268435456;
        }
        int i7 = i & 1024;
        if (i7 != 0) {
            $dirty2 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function6) ? 4 : 2;
        }
        int i8 = i & 2048;
        if (i8 != 0) {
            $dirty2 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function7) ? 32 : 16;
        }
        int i9 = i & 4096;
        if (i9 != 0) {
            $dirty2 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function8) ? 256 : 128;
        }
        int i10 = i & 8192;
        if (i10 != 0) {
            $dirty2 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function9) ? 2048 : 1024;
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16384) == 0 && $composer2.changed(colors)) {
                i2 = 16384;
            }
            $dirty2 |= i2;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= ((i & 32768) == 0 && $composer2.changed(contentPadding)) ? 131072 : 65536;
        }
        int i11 = i & 65536;
        if (i11 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function10) ? 1048576 : 524288;
        }
        if ((i & 131072) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty2 |= $composer2.changed(this) ? 8388608 : 4194304;
        }
        if (($dirty & 306783379) == 306783378 && (4793491 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            isError3 = isError;
            function21 = function3;
            function18 = function4;
            function19 = function5;
            function20 = function6;
            function22 = function7;
            function23 = function8;
            function24 = function9;
            colors3 = colors;
            contentPadding4 = contentPadding;
            function2RememberComposableLambda = function10;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                isError2 = i3 != 0 ? false : isError;
                function11 = i4 != 0 ? null : function3;
                Function2<? super Composer, ? super Integer, Unit> function25 = i5 != 0 ? null : function4;
                Function2<? super Composer, ? super Integer, Unit> function26 = i6 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function27 = i7 != 0 ? null : function6;
                function12 = i8 != 0 ? null : function7;
                function13 = i9 != 0 ? null : function8;
                function14 = i10 != 0 ? null : function9;
                if ((i & 16384) != 0) {
                    colors2 = colors($composer2, ($dirty2 >> 21) & 14);
                    $dirty2 &= -57345;
                } else {
                    colors2 = colors;
                }
                if ((i & 32768) != 0) {
                    contentPadding2 = m2462contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    $dirty2 &= -458753;
                } else {
                    contentPadding2 = contentPadding;
                }
                if (i11 != 0) {
                    Function2<? super Composer, ? super Integer, Unit> function28 = function25;
                    $dirty1 = $dirty2;
                    function16 = function26;
                    function17 = function27;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1448570018, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.1
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
                            ComposerKt.sourceInformation($composer3, "C1014@56393L135:TextFieldDefaults.kt#uh7d8r");
                            if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1448570018, $changed2, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1014)");
                                }
                                OutlinedTextFieldDefaults.INSTANCE.m2463ContainerBoxnbWgWpA(enabled, isError2, interactionSource, colors2, null, 0.0f, 0.0f, $composer3, 12582912, 112);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }, $composer2, 54);
                    contentPadding3 = contentPadding2;
                    function15 = function28;
                } else {
                    $dirty1 = $dirty2;
                    function15 = function25;
                    function16 = function26;
                    function17 = function27;
                    function2RememberComposableLambda = function10;
                    contentPadding3 = contentPadding2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16384) != 0) {
                    $dirty2 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty2 &= -458753;
                }
                isError2 = isError;
                function11 = function3;
                function16 = function5;
                function17 = function6;
                function12 = function7;
                function13 = function8;
                function14 = function9;
                colors2 = colors;
                contentPadding3 = contentPadding;
                function2RememberComposableLambda = function10;
                $dirty1 = $dirty2;
                function15 = function4;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350442135, $dirty, $dirty1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1021)");
            }
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, value, function2, visualTransformation, function11, function15, function16, function17, function12, function13, function14, singleLine, enabled, isError2, interactionSource, contentPadding3, colors2, function2RememberComposableLambda, $composer2, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty1 << 21) & 29360128) | (($dirty1 << 21) & 234881024) | (($dirty1 << 21) & 1879048192), (($dirty1 >> 9) & 14) | (($dirty >> 6) & 112) | ($dirty & 896) | (($dirty >> 9) & 7168) | (($dirty >> 3) & 57344) | (458752 & $dirty1) | (($dirty1 << 6) & 3670016) | (($dirty1 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function18 = function15;
            function19 = function16;
            function20 = function17;
            contentPadding4 = contentPadding3;
            function21 = function11;
            function22 = function12;
            function23 = function13;
            function24 = function14;
            isError3 = isError2;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z = isError3;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function21;
            final Function2<? super Composer, ? super Integer, Unit> function30 = function18;
            final Function2<? super Composer, ? super Integer, Unit> function31 = function19;
            final Function2<? super Composer, ? super Integer, Unit> function32 = function20;
            final Function2<? super Composer, ? super Integer, Unit> function33 = function22;
            final Function2<? super Composer, ? super Integer, Unit> function34 = function23;
            final Function2<? super Composer, ? super Integer, Unit> function35 = function24;
            final TextFieldColors textFieldColors = colors3;
            final PaddingValues paddingValues = contentPadding4;
            final Function2<? super Composer, ? super Integer, Unit> function36 = function2RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.2
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

                public final void invoke(Composer composer, int i12) {
                    OutlinedTextFieldDefaults.this.DecorationBox(value, function2, enabled, singleLine, visualTransformation, interactionSource, z, function29, function30, function31, function32, function33, function34, function35, textFieldColors, paddingValues, function36, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
