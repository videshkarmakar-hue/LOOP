package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
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
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010+J¦\u0002\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010?J\r\u0010*\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010@JÂ\u0003\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020B2\b\b\u0002\u0010D\u001a\u00020B2\b\b\u0002\u0010E\u001a\u00020B2\b\b\u0002\u0010F\u001a\u00020B2\b\b\u0002\u0010G\u001a\u00020B2\b\b\u0002\u0010H\u001a\u00020B2\b\b\u0002\u0010I\u001a\u00020B2\b\b\u0002\u0010J\u001a\u00020B2\b\b\u0002\u0010K\u001a\u00020B2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010N\u001a\u00020B2\b\b\u0002\u0010O\u001a\u00020B2\b\b\u0002\u0010P\u001a\u00020B2\b\b\u0002\u0010Q\u001a\u00020B2\b\b\u0002\u0010R\u001a\u00020B2\b\b\u0002\u0010S\u001a\u00020B2\b\b\u0002\u0010T\u001a\u00020B2\b\b\u0002\u0010U\u001a\u00020B2\b\b\u0002\u0010V\u001a\u00020B2\b\b\u0002\u0010W\u001a\u00020B2\b\b\u0002\u0010X\u001a\u00020B2\b\b\u0002\u0010Y\u001a\u00020B2\b\b\u0002\u0010Z\u001a\u00020B2\b\b\u0002\u0010[\u001a\u00020B2\b\b\u0002\u0010\\\u001a\u00020B2\b\b\u0002\u0010]\u001a\u00020B2\b\b\u0002\u0010^\u001a\u00020B2\b\b\u0002\u0010_\u001a\u00020B2\b\b\u0002\u0010`\u001a\u00020B2\b\b\u0002\u0010a\u001a\u00020B2\b\b\u0002\u0010b\u001a\u00020B2\b\b\u0002\u0010c\u001a\u00020B2\b\b\u0002\u0010d\u001a\u00020B2\b\b\u0002\u0010e\u001a\u00020B2\b\b\u0002\u0010f\u001a\u00020B2\b\b\u0002\u0010g\u001a\u00020B2\b\b\u0002\u0010h\u001a\u00020B2\b\b\u0002\u0010i\u001a\u00020B2\b\b\u0002\u0010j\u001a\u00020B2\b\b\u0002\u0010k\u001a\u00020B2\b\b\u0002\u0010l\u001a\u00020B2\b\b\u0002\u0010m\u001a\u00020BH\u0007ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ8\u0010p\u001a\u00020=2\b\b\u0002\u0010q\u001a\u00020\u00042\b\b\u0002\u0010r\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ8\u0010w\u001a\u00020=2\b\b\u0002\u0010q\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010r\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bx\u0010vJ:\u0010y\u001a\u00020=2\b\b\u0002\u0010q\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010r\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bz\u0010vJ:\u0010{\u001a\u00020=2\b\b\u0002\u0010q\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010r\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u0004H\u0001ø\u0001\u0000¢\u0006\u0004\b|\u0010vJ:\u0010}\u001a\u00020=2\b\b\u0002\u0010q\u001a\u00020\u00042\b\b\u0002\u0010r\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b~\u0010vJ;\u0010\u007f\u001a\u00020=2\b\b\u0002\u0010q\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010r\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010vJQ\u0010\u0081\u0001\u001a\u00030\u0082\u0001*\u00030\u0082\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00158GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\u001e\u001a\u00020\u001f*\u00020 8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0087\u0001"}, m195d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape$annotations", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "shape", "getShape", "defaultTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "DecorationBox", DownloadUtil.CookieScheme.VALUE, "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = C1979Dp.m6801constructorimpl(56);
    private static final float MinWidth = C1979Dp.m6801constructorimpl(280);
    private static final float UnfocusedIndicatorThickness = C1979Dp.m6801constructorimpl(1);
    private static final float FocusedIndicatorThickness = C1979Dp.m6801constructorimpl(2);
    private static final float UnfocusedBorderThickness = UnfocusedIndicatorThickness;
    private static final float FocusedBorderThickness = FocusedIndicatorThickness;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2789getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2790getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1941327459, "C64@2935L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:64)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2801getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2802getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m2804getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* JADX INFO: renamed from: getFocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m2800getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x00f2  */
    public final void ContainerBox(final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, Shape shape, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        int $dirty;
        Shape shape3;
        Shape shape4;
        Composer $composer2 = $composer.startRestartGroup(918564008);
        ComposerKt.sourceInformation($composer2, "C(ContainerBox)P(1,3,2)107@4543L5,109@4598L25,112@4754L78,113@4841L173:TextFieldDefaults.kt#uh7d8r");
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
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changed(this) ? 131072 : 65536;
        }
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    shape3 = shape2;
                } else {
                    $dirty = $dirty2;
                    shape3 = shape2;
                }
            } else if ((i & 16) != 0) {
                $dirty = $dirty2 & (-57345);
                shape3 = INSTANCE.getShape($composer2, 6);
            } else {
                $dirty = $dirty2;
                shape3 = shape2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(918564008, $dirty, -1, "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:108)");
            }
            boolean focused = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer2, ($dirty >> 6) & 14).getValue().booleanValue();
            long containerColor = colors.m2733containerColorXeAY9LY$material3_release(enabled, isError, focused);
            Shape shape5 = shape3;
            shape4 = shape5;
            BoxKt.Box(m2791indicatorLinegv0btCI$default(this, BackgroundKt.m453backgroundbw27NRU(Modifier.INSTANCE, SingleValueAnimationKt.m351animateColorAsStateeuL9pac(containerColor, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer2, 48, 12).getValue().m4301unboximpl(), shape5), enabled, isError, interactionSource, colors, 0.0f, 0.0f, 48, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Shape shape6 = shape4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.ContainerBox.1
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
                    TextFieldDefaults.this.ContainerBox(enabled, isError, interactionSource, colors, shape6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2791indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) == 0) {
            f3 = f;
        } else {
            f3 = FocusedIndicatorThickness;
        }
        if ((i & 32) == 0) {
            f4 = f2;
        } else {
            f4 = UnfocusedIndicatorThickness;
        }
        return textFieldDefaults.m2805indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m2805indicatorLinegv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, final float focusedIndicatorLineThickness, final float unfocusedIndicatorLineThickness) {
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                $this$null.setName("indicatorLine");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("isError", Boolean.valueOf(isError));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("colors", colors);
                $this$null.getProperties().set("focusedIndicatorLineThickness", C1979Dp.m6799boximpl(focusedIndicatorLineThickness));
                $this$null.getProperties().set("unfocusedIndicatorLineThickness", C1979Dp.m6799boximpl(unfocusedIndicatorLineThickness));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                $composer.startReplaceGroup(-891038934);
                ComposerKt.sourceInformation($composer, "C152@6661L217:TextFieldDefaults.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891038934, $changed, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:152)");
                }
                State stroke = TextFieldDefaultsKt.m2811animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness, $composer, 0);
                Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) stroke.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
                return modifierDrawIndicatorLine;
            }
        });
    }

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2787contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2797contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2797contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m864PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2788contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m2798contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2798contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m864PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3_release$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2793supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = C1979Dp.m6801constructorimpl(0);
        }
        return textFieldDefaults.m2807supportingTextPaddinga9UjIt4$material3_release(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3_release, reason: not valid java name */
    public final PaddingValues m2807supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m864PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 831731228, "C(colors)208@8723L11,208@8735L22:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, $changed, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:208)");
        }
        TextFieldColors defaultTextFieldColors = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, ($changed << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultTextFieldColors;
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m2796colors0hiis_0(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart($composer, 1513344955, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,32,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)309@15545L11,309@15557L22:TextFieldDefaults.kt#uh7d8r");
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
        long focusedIndicatorColor2 = (i & 2048) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : focusedIndicatorColor;
        long unfocusedIndicatorColor2 = (i & 4096) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : unfocusedIndicatorColor;
        long disabledIndicatorColor2 = (i & 8192) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledIndicatorColor;
        long errorIndicatorColor2 = (i & 16384) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : errorIndicatorColor;
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
            ComposerKt.traceEventStart(1513344955, $changed, $changed1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:309)");
        }
        TextFieldColors textFieldColorsM2734copyejIjP34 = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, ($changed4 >> 6) & 112).m2734copyejIjP34(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2734copyejIjP34;
    }

    public final TextFieldColors getDefaultTextFieldColors(ColorScheme $this$defaultTextFieldColors, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1341970309, "C:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341970309, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:357)");
        }
        TextFieldColors it = $this$defaultTextFieldColors.getDefaultTextFieldColorsCached();
        $composer.startReplaceGroup(1801980647);
        ComposerKt.sourceInformation($composer, "*370@19267L7");
        if (it == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getFocusInputColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getDisabledInputColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getErrorInputColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getCaretColor());
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jFromToken11 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor());
            long jFromToken12 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor());
            long jFromToken13 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor());
            long jM4289copywmQWz5c2 = Color.m4289copywmQWz5c(jFromToken13, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken13) : FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken13) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken13) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken13) : 0.0f);
            long jFromToken14 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor());
            long jFromToken15 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor());
            long jFromToken16 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getLeadingIconColor());
            long jFromToken17 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor());
            long jM4289copywmQWz5c3 = Color.m4289copywmQWz5c(jFromToken17, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken17) : FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken17) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken17) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken17) : 0.0f);
            long jFromToken18 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor());
            long jFromToken19 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor());
            long jFromToken20 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getTrailingIconColor());
            long jFromToken21 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor());
            long jM4289copywmQWz5c4 = Color.m4289copywmQWz5c(jFromToken21, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken21) : FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken21) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken21) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken21) : 0.0f);
            long jFromToken22 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor());
            long jFromToken23 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getFocusLabelColor());
            long jFromToken24 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getLabelColor());
            long jFromToken25 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor());
            long jM4289copywmQWz5c5 = Color.m4289copywmQWz5c(jFromToken25, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken25) : FilledTextFieldTokens.INSTANCE.getDisabledLabelOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken25) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken25) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken25) : 0.0f);
            long jFromToken26 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getErrorLabelColor());
            long jFromToken27 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor());
            long jFromToken28 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor());
            long jFromToken29 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getDisabledInputColor());
            long jM4289copywmQWz5c6 = Color.m4289copywmQWz5c(jFromToken29, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken29) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken29) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken29) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken29) : 0.0f);
            long jFromToken30 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor());
            long jFromToken31 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor());
            long jFromToken32 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getSupportingColor());
            long jFromToken33 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor());
            long jM4289copywmQWz5c7 = Color.m4289copywmQWz5c(jFromToken33, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken33) : FilledTextFieldTokens.INSTANCE.getDisabledSupportingOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken33) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken33) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken33) : 0.0f);
            long jFromToken34 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor());
            long jFromToken35 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jFromToken36 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jFromToken37 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jM4289copywmQWz5c8 = Color.m4289copywmQWz5c(jFromToken37, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken37) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken37) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken37) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken37) : 0.0f);
            long jFromToken38 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputPrefixColor());
            long jFromToken39 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputSuffixColor());
            long jFromToken40 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputSuffixColor());
            long jFromToken41 = ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputSuffixColor());
            it = new TextFieldColors(jFromToken, jFromToken2, jM4289copywmQWz5c, jFromToken4, jFromToken5, jFromToken6, jFromToken7, jFromToken8, jFromToken9, jFromToken10, (SelectionColors) objConsume, jFromToken11, jFromToken12, jM4289copywmQWz5c2, jFromToken14, jFromToken15, jFromToken16, jM4289copywmQWz5c3, jFromToken18, jFromToken19, jFromToken20, jM4289copywmQWz5c4, jFromToken22, jFromToken23, jFromToken24, jM4289copywmQWz5c5, jFromToken26, jFromToken27, jFromToken28, jM4289copywmQWz5c6, jFromToken30, jFromToken31, jFromToken32, jM4289copywmQWz5c7, jFromToken34, jFromToken35, jFromToken36, jM4289copywmQWz5c8, jFromToken38, jFromToken39, jFromToken40, Color.m4289copywmQWz5c(jFromToken41, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken41) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken41) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken41) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken41) : 0.0f), ColorSchemeKt.fromToken($this$defaultTextFieldColors, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            $this$defaultTextFieldColors.setDefaultTextFieldColorsCached$material3_release(it);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return it;
    }

    public final void DecorationBox(final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean enabled, final boolean singleLine, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, Function2<? super Composer, ? super Integer, Unit> function9, Shape shape, TextFieldColors colors, PaddingValues contentPadding, Function2<? super Composer, ? super Integer, Unit> function10, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean isError2;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Shape shape2;
        TextFieldColors colors2;
        PaddingValues contentPadding2;
        TextFieldColors colors3;
        Function2<? super Composer, ? super Integer, Unit> function15;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Shape shape3;
        Function2<? super Composer, ? super Integer, Unit> function17;
        PaddingValues contentPadding3;
        int $dirty1;
        Shape shape4;
        Function2<? super Composer, ? super Integer, Unit> function18;
        Function2<? super Composer, ? super Integer, Unit> function19;
        Function2<? super Composer, ? super Integer, Unit> function20;
        TextFieldColors colors4;
        Function2<? super Composer, ? super Integer, Unit> function21;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        boolean isError3;
        Composer $composer2 = $composer.startRestartGroup(289640444);
        ComposerKt.sourceInformation($composer2, "C(DecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)498@28523L5,499@28564L8,506@28814L88,510@28919L707:TextFieldDefaults.kt#uh7d8r");
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
            if ((i & 16384) == 0 && $composer2.changed(shape)) {
                i2 = 16384;
            }
            $dirty2 |= i2;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= ((i & 32768) == 0 && $composer2.changed(colors)) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty2 |= ((i & 65536) == 0 && $composer2.changed(contentPadding)) ? 1048576 : 524288;
        }
        int i11 = i & 131072;
        if (i11 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function10) ? 8388608 : 4194304;
        }
        if ((i & 262144) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed1 & 100663296) == 0) {
            $dirty2 |= $composer2.changed(this) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 306783379) == 306783378 && (38347923 & $dirty2) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            isError3 = isError;
            function22 = function3;
            function24 = function4;
            function18 = function5;
            function19 = function6;
            function20 = function7;
            function21 = function8;
            function23 = function9;
            shape4 = shape;
            colors4 = colors;
            contentPadding3 = contentPadding;
            function2RememberComposableLambda = function10;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                isError2 = i3 != 0 ? false : isError;
                function11 = i4 != 0 ? null : function3;
                function12 = i5 != 0 ? null : function4;
                Function2<? super Composer, ? super Integer, Unit> function25 = i6 != 0 ? null : function5;
                Function2<? super Composer, ? super Integer, Unit> function26 = i7 != 0 ? null : function6;
                Function2<? super Composer, ? super Integer, Unit> function27 = i8 != 0 ? null : function7;
                function13 = i9 != 0 ? null : function8;
                function14 = i10 != 0 ? null : function9;
                if ((i & 16384) != 0) {
                    shape2 = INSTANCE.getShape($composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    shape2 = shape;
                }
                if ((32768 & i) != 0) {
                    colors2 = colors($composer2, ($dirty2 >> 24) & 14);
                    $dirty2 &= -458753;
                } else {
                    colors2 = colors;
                }
                if ((i & 65536) != 0) {
                    contentPadding2 = function11 == null ? m2788contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m2787contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    $dirty2 &= -3670017;
                } else {
                    contentPadding2 = contentPadding;
                }
                if (i11 != 0) {
                    int $dirty3 = $dirty2;
                    final boolean z = isError2;
                    final TextFieldColors textFieldColors = colors2;
                    final Shape shape5 = shape2;
                    Function2<Composer, Integer, Unit> function28 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.DecorationBox.1
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
                            ComposerKt.sourceInformation($composer3, "C507@28828L64:TextFieldDefaults.kt#uh7d8r");
                            if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-435523791, $changed2, -1, "androidx.compose.material3.TextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:507)");
                            }
                            TextFieldDefaults.INSTANCE.ContainerBox(enabled, z, interactionSource, textFieldColors, shape5, $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    };
                    Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                    colors3 = colors2;
                    function15 = function26;
                    function16 = function29;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-435523791, true, function28, $composer2, 54);
                    shape3 = shape2;
                    function17 = function25;
                    contentPadding3 = contentPadding2;
                    $dirty1 = $dirty3;
                } else {
                    int $dirty4 = $dirty2;
                    Function2<? super Composer, ? super Integer, Unit> function30 = function27;
                    colors3 = colors2;
                    function15 = function26;
                    function16 = function30;
                    function2RememberComposableLambda = function10;
                    shape3 = shape2;
                    function17 = function25;
                    contentPadding3 = contentPadding2;
                    $dirty1 = $dirty4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16384) != 0) {
                    $dirty2 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty2 &= -3670017;
                }
                isError2 = isError;
                function11 = function3;
                function12 = function4;
                function15 = function6;
                function16 = function7;
                function13 = function8;
                function14 = function9;
                shape3 = shape;
                colors3 = colors;
                contentPadding3 = contentPadding;
                function2RememberComposableLambda = function10;
                $dirty1 = $dirty2;
                function17 = function5;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(289640444, $dirty, $dirty1, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:509)");
            }
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, value, function2, visualTransformation, function11, function12, function17, function15, function16, function13, function14, singleLine, enabled, isError2, interactionSource, contentPadding3, colors3, function2RememberComposableLambda, $composer2, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty1 << 21) & 29360128) | (($dirty1 << 21) & 234881024) | (($dirty1 << 21) & 1879048192), (($dirty1 >> 9) & 14) | (($dirty >> 6) & 112) | ($dirty & 896) | (($dirty >> 9) & 7168) | (($dirty >> 3) & 57344) | (($dirty1 >> 3) & 458752) | (($dirty1 << 3) & 3670016) | (29360128 & $dirty1), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            function18 = function17;
            function19 = function15;
            function20 = function16;
            colors4 = colors3;
            function21 = function13;
            function22 = function11;
            function23 = function14;
            function24 = function12;
            isError3 = isError2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = isError3;
            final Function2<? super Composer, ? super Integer, Unit> function31 = function22;
            final Function2<? super Composer, ? super Integer, Unit> function32 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function33 = function18;
            final Function2<? super Composer, ? super Integer, Unit> function34 = function19;
            final Function2<? super Composer, ? super Integer, Unit> function35 = function20;
            final Function2<? super Composer, ? super Integer, Unit> function36 = function21;
            final Function2<? super Composer, ? super Integer, Unit> function37 = function23;
            final Shape shape6 = shape4;
            final TextFieldColors textFieldColors2 = colors4;
            final PaddingValues paddingValues = contentPadding3;
            final Function2<? super Composer, ? super Integer, Unit> function38 = function2RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.DecorationBox.2
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
                    TextFieldDefaults.this.DecorationBox(value, function2, enabled, singleLine, visualTransformation, interactionSource, z2, function31, function32, function33, function34, function35, function36, function37, shape6, textFieldColors2, paddingValues, function38, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -584749279, "C538@29976L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:538)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape($composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return shape;
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 611926497, "C545@30214L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, $changed, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:545)");
        }
        Shape shape = getShape($composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return shape;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2803getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2799getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2794textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2808textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2808textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return m2797contentPaddingWithLabela9UjIt4(start, end, top, bottom);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2795textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m2809textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2809textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return m2798contentPaddingWithoutLabela9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2792outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m2806outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2806outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.m2465contentPaddinga9UjIt4(start, top, end, bottom);
    }
}
