package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.C1733R;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.DrawModifierKt;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Shadow;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawStyle;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.text.PlatformTextStyle;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontSynthesis;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.input.TextFieldValue;
import androidx.compose.p001ui.text.input.VisualTransformation;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.BaselineShift;
import androidx.compose.p001ui.text.style.LineHeightStyle;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextGeometricTransform;
import androidx.compose.p001ui.text.style.TextIndent;
import androidx.compose.p001ui.text.style.TextMotion;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.DpKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.util.MathHelpersKt;
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
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001aØ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020-2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001aì\u0001\u0010/\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u00109\u001ar\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001aR\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u0014\u0010R\u001a\u00020\f*\u00020\f2\u0006\u0010S\u001a\u00020TH\u0000\u001a\u009a\u0001\u0010U\u001a\u00020\u0006*\u00020V2\u0006\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010\\\u001a\u0004\u0018\u00010Z2\b\u0010]\u001a\u0004\u0018\u00010Z2\b\u0010^\u001a\u0004\u0018\u00010Z2\b\u0010_\u001a\u0004\u0018\u00010Z2\b\u0010`\u001a\u0004\u0018\u00010Z2\u0006\u0010a\u001a\u00020Z2\b\u0010b\u001a\u0004\u0018\u00010Z2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020$2\u0006\u0010d\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u000204H\u0002\u001a\u0080\u0001\u0010e\u001a\u00020\u0006*\u00020V2\u0006\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020$2\u0006\u0010f\u001a\u00020Z2\b\u0010\\\u001a\u0004\u0018\u00010Z2\b\u0010]\u001a\u0004\u0018\u00010Z2\b\u0010^\u001a\u0004\u0018\u00010Z2\b\u0010_\u001a\u0004\u0018\u00010Z2\b\u0010`\u001a\u0004\u0018\u00010Z2\u0006\u0010a\u001a\u00020Z2\b\u0010b\u001a\u0004\u0018\u00010Z2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010E\u001a\u0002042\u0006\u00107\u001a\u000208H\u0002\u001a\u0014\u0010g\u001a\u00020$*\u00020$2\u0006\u0010h\u001a\u00020$H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006i"}, m195d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "TextField", "", DownloadUtil.CookieScheme.VALUE, "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", "from", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = C1979Dp.m6801constructorimpl(8);

    public static final void TextField(final String value, final Function1<? super String, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int i3;
        TextStyle textStyle2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        boolean isError2;
        int maxLines2;
        Shape shape2;
        Modifier modifier2;
        boolean enabled2;
        int $dirty;
        int $dirty1;
        Shape shape3;
        TextFieldColors colors2;
        int $dirty2;
        boolean readOnly2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource mutableInteractionSource;
        long textColor;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Function2<? super Composer, ? super Integer, Unit> function17;
        TextStyle textStyle3;
        Modifier modifier3;
        boolean readOnly3;
        Function2<? super Composer, ? super Integer, Unit> function18;
        Function2<? super Composer, ? super Integer, Unit> function19;
        Function2<? super Composer, ? super Integer, Unit> function20;
        Function2<? super Composer, ? super Integer, Unit> function21;
        Function2<? super Composer, ? super Integer, Unit> function22;
        boolean isError3;
        boolean enabled3;
        TextFieldColors colors3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation($composer2, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)199@10512L7,215@11308L5,216@11363L8,227@11923L1824,227@11836L1911:TextField.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        int $dirty5 = $changed2;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer2.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer2.changed(textStyle)) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer2.changedInstance(function5) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty4 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty4 |= $composer2.changedInstance(function6) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty4 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function7) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty4 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty4 |= $composer2.changedInstance(function8) ? 256 : 128;
        }
        int i14 = i & 8192;
        if (i14 != 0) {
            $dirty4 |= 3072;
            i2 = i14;
        } else {
            i2 = i14;
            if (($changed1 & 3072) == 0) {
                $dirty4 |= $composer2.changed(isError) ? 2048 : 1024;
            }
        }
        int i15 = i & 16384;
        if (i15 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            i3 = i15;
        } else {
            i3 = i15;
            if (($changed1 & CpioConstants.C_ISBLK) == 0) {
                $dirty4 |= $composer2.changed(visualTransformation) ? 16384 : 8192;
            }
        }
        int i16 = i & 32768;
        if (i16 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= $composer2.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i17 = i & 65536;
        if (i17 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty4 |= $composer2.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i18 = i & 131072;
        if (i18 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty4 |= $composer2.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty4 |= ((i & 262144) == 0 && $composer2.changed(maxLines)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i19 = i & 524288;
        if (i19 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed1 & 805306368) == 0) {
            $dirty4 |= $composer2.changed(minLines) ? 536870912 : 268435456;
        }
        int i20 = i & 1048576;
        if (i20 != 0) {
            $dirty5 |= 6;
        } else if (($changed2 & 6) == 0) {
            $dirty5 |= $composer2.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 48) == 0) {
            $dirty5 |= ((i & 2097152) == 0 && $composer2.changed(shape)) ? 32 : 16;
        }
        if (($changed2 & 384) == 0) {
            $dirty5 |= ((i & 4194304) == 0 && $composer2.changed(colors)) ? 256 : 128;
        }
        if (($dirty3 & 306783379) == 306783378 && (306783379 & $dirty4) == 306783378 && ($dirty5 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly3 = readOnly;
            textStyle3 = textStyle;
            function22 = function2;
            function18 = function3;
            function19 = function4;
            function20 = function5;
            function21 = function6;
            function17 = function7;
            function16 = function8;
            isError3 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines3 = maxLines;
            minLines2 = minLines;
            interactionSource2 = interactionSource;
            shape3 = shape;
            colors3 = colors;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i5 != 0 ? true : enabled;
                boolean readOnly4 = i6 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty3 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                function9 = i7 != 0 ? null : function2;
                function10 = i8 != 0 ? null : function3;
                function11 = i9 != 0 ? null : function4;
                function12 = i10 != 0 ? null : function5;
                function13 = i11 != 0 ? null : function6;
                function14 = i12 != 0 ? null : function7;
                function15 = i13 != 0 ? null : function8;
                isError2 = i2 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i3 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i16 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i17 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine3 = i18 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine3 ? 1 : Integer.MAX_VALUE;
                    $dirty4 &= -234881025;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines3 = i19 != 0 ? 1 : minLines;
                MutableInteractionSource interactionSource3 = i20 != 0 ? null : interactionSource;
                int $dirty6 = $dirty3;
                if ((i & 2097152) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty5 &= -113;
                } else {
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    $dirty = $dirty6;
                    $dirty1 = $dirty4;
                    shape3 = shape2;
                    colors2 = TextFieldDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 = $dirty5 & (-897);
                    readOnly2 = readOnly4;
                    visualTransformation2 = visualTransformation3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    singleLine2 = singleLine3;
                    maxLines3 = maxLines2;
                    minLines2 = minLines3;
                    interactionSource2 = interactionSource3;
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                } else {
                    Shape shape4 = shape2;
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    $dirty = $dirty6;
                    $dirty1 = $dirty4;
                    shape3 = shape4;
                    colors2 = colors;
                    $dirty2 = $dirty5;
                    readOnly2 = readOnly4;
                    visualTransformation2 = visualTransformation3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    singleLine2 = singleLine3;
                    maxLines3 = maxLines2;
                    minLines2 = minLines3;
                    interactionSource2 = interactionSource3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty5 &= -113;
                }
                if ((i & 4194304) != 0) {
                    $dirty5 &= -897;
                }
                textStyle2 = textStyle;
                function9 = function2;
                function10 = function3;
                function11 = function4;
                function12 = function5;
                function13 = function6;
                function14 = function7;
                function15 = function8;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines3 = maxLines;
                minLines2 = minLines;
                interactionSource2 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty = $dirty3;
                $dirty1 = $dirty4;
                $dirty2 = $dirty5;
                modifier2 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-676242365, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:217)");
            }
            $composer2.startReplaceGroup(-1263330142);
            ComposerKt.sourceInformation($composer2, "219@11457L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1263330121, "CC(remember):TextField.kt#9igjgp");
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
                mutableInteractionSource = interactionSource2;
            }
            $composer2.endReplaceGroup();
            final MutableInteractionSource interactionSource4 = mutableInteractionSource;
            $composer2.startReplaceGroup(-1263329962);
            ComposerKt.sourceInformation($composer2, "*222@11669L25");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle2.m6281getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != 16) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                boolean focused = FocusInteractionKt.collectIsFocusedAsState(interactionSource4, $composer2, 0).getValue().booleanValue();
                textColor = colors2.m2785textColorXeAY9LY$material3_release(enabled2, isError2, focused);
            }
            $composer2.endReplaceGroup();
            final TextStyle mergedTextStyle = textStyle2.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            TextStyle textStyle4 = textStyle2;
            final Modifier modifier5 = modifier2;
            final boolean z = isError2;
            final TextFieldColors textFieldColors = colors2;
            final boolean z2 = enabled2;
            final boolean z3 = readOnly2;
            final KeyboardOptions keyboardOptions4 = keyboardOptions2;
            final KeyboardActions keyboardActions4 = keyboardActions2;
            final boolean z4 = singleLine2;
            final int i21 = maxLines3;
            final int i22 = minLines2;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function27 = function13;
            final Function2 function28 = function14;
            final Function2 function29 = function15;
            final Shape shape5 = shape3;
            Modifier modifier6 = modifier2;
            boolean enabled5 = enabled2;
            boolean readOnly5 = readOnly2;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.1
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

                public final void invoke(Composer $composer3, int $changed3) {
                    ComposerKt.sourceInformation($composer3, "C231@12056L38,248@12827L904,228@11933L1808:TextField.kt#uh7d8r");
                    if (($changed3 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1859145987, $changed3, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:228)");
                        }
                        Modifier modifier7 = modifier5;
                        boolean z5 = z;
                        Strings.Companion companion = Strings.INSTANCE;
                        Modifier modifierM897defaultMinSizeVpY3zN4 = SizeKt.m897defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier7, z5, Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1733R.string.default_error_message), $composer3, 0)), TextFieldDefaults.INSTANCE.m2802getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2801getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(textFieldColors.m2735cursorColorvNxB06k$material3_release(z), null);
                        String str = value;
                        Function1<String, Unit> function30 = function1;
                        boolean z6 = z2;
                        boolean z7 = z3;
                        TextStyle textStyle5 = mergedTextStyle;
                        KeyboardOptions keyboardOptions5 = keyboardOptions4;
                        KeyboardActions keyboardActions5 = keyboardActions4;
                        boolean z8 = z4;
                        int i23 = i21;
                        int i24 = i22;
                        VisualTransformation visualTransformation5 = visualTransformation4;
                        MutableInteractionSource mutableInteractionSource2 = interactionSource4;
                        SolidColor solidColor2 = solidColor;
                        final String str2 = value;
                        final boolean z9 = z2;
                        final boolean z10 = z4;
                        final VisualTransformation visualTransformation6 = visualTransformation4;
                        final MutableInteractionSource mutableInteractionSource3 = interactionSource4;
                        final boolean z11 = z;
                        final Function2<Composer, Integer, Unit> function31 = function23;
                        final Function2<Composer, Integer, Unit> function32 = function24;
                        final Function2<Composer, Integer, Unit> function33 = function25;
                        final Function2<Composer, Integer, Unit> function34 = function26;
                        final Function2<Composer, Integer, Unit> function35 = function27;
                        final Function2<Composer, Integer, Unit> function36 = function28;
                        final Function2<Composer, Integer, Unit> function37 = function29;
                        final Shape shape6 = shape5;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        BasicTextFieldKt.BasicTextField(str, function30, modifierM897defaultMinSizeVpY3zN4, z6, z7, textStyle5, keyboardOptions5, keyboardActions5, z8, i23, i24, visualTransformation5, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, solidColor2, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function38, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function38, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function38, Composer $composer4, int $changed4) {
                                ComposerKt.sourceInformation($composer4, "C250@12974L743:TextField.kt#uh7d8r");
                                int $dirty7 = $changed4;
                                if (($changed4 & 6) == 0) {
                                    $dirty7 |= $composer4.changedInstance(function38) ? 4 : 2;
                                }
                                int $dirty8 = $dirty7;
                                if (($dirty8 & 19) != 18 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-288211827, $dirty8, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:250)");
                                    }
                                    TextFieldDefaults.INSTANCE.DecorationBox(str2, function38, z9, z10, visualTransformation6, mutableInteractionSource3, z11, function31, function32, function33, function34, function35, function36, function37, shape6, textFieldColors2, null, null, $composer4, ($dirty8 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.f245xf2722a21);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 0, ProfileVerifier.CompilationStatus.f245xf2722a21, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function16 = function15;
            function17 = function14;
            textStyle3 = textStyle4;
            modifier3 = modifier6;
            readOnly3 = readOnly5;
            function18 = function10;
            function19 = function11;
            function20 = function12;
            function21 = function13;
            function22 = function9;
            isError3 = isError2;
            enabled3 = enabled5;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final boolean z5 = enabled3;
            final boolean z6 = readOnly3;
            final TextStyle textStyle5 = textStyle3;
            final Function2<? super Composer, ? super Integer, Unit> function30 = function22;
            final Function2<? super Composer, ? super Integer, Unit> function31 = function18;
            final Function2<? super Composer, ? super Integer, Unit> function32 = function19;
            final Function2<? super Composer, ? super Integer, Unit> function33 = function20;
            final Function2<? super Composer, ? super Integer, Unit> function34 = function21;
            final Function2<? super Composer, ? super Integer, Unit> function35 = function17;
            final Function2<? super Composer, ? super Integer, Unit> function36 = function16;
            final boolean z7 = isError3;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final KeyboardOptions keyboardOptions5 = keyboardOptions2;
            final KeyboardActions keyboardActions5 = keyboardActions2;
            final boolean z8 = singleLine2;
            final int i23 = maxLines3;
            final int i24 = minLines2;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            final Shape shape6 = shape3;
            final TextFieldColors textFieldColors2 = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.2
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

                public final void invoke(Composer composer, int i25) {
                    TextFieldKt.TextField(value, function1, modifier7, z5, z6, textStyle5, function30, function31, function32, function33, function34, function35, function36, z7, visualTransformation5, keyboardOptions5, keyboardActions5, z8, i23, i24, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    public static final void TextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Function2<? super Composer, ? super Integer, Unit> function7, Function2<? super Composer, ? super Integer, Unit> function8, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        int i3;
        TextStyle textStyle2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Function2<? super Composer, ? super Integer, Unit> function15;
        boolean isError2;
        int maxLines2;
        Shape shape2;
        Modifier modifier2;
        boolean enabled2;
        int $dirty;
        int $dirty1;
        Shape shape3;
        TextFieldColors colors2;
        int $dirty2;
        boolean readOnly2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource mutableInteractionSource;
        long textColor;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Function2<? super Composer, ? super Integer, Unit> function17;
        TextStyle textStyle3;
        Modifier modifier3;
        boolean readOnly3;
        Function2<? super Composer, ? super Integer, Unit> function18;
        Function2<? super Composer, ? super Integer, Unit> function19;
        Function2<? super Composer, ? super Integer, Unit> function20;
        Function2<? super Composer, ? super Integer, Unit> function21;
        Function2<? super Composer, ? super Integer, Unit> function22;
        boolean isError3;
        boolean enabled3;
        TextFieldColors colors3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation($composer2, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)349@18864L7,365@19660L5,366@19715L8,377@20275L1829,377@20188L1916:TextField.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        int $dirty5 = $changed2;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer2.changed(readOnly) ? 16384 : 8192;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer2.changed(textStyle)) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer2.changedInstance(function5) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty4 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty4 |= $composer2.changedInstance(function6) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty4 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function7) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty4 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty4 |= $composer2.changedInstance(function8) ? 256 : 128;
        }
        int i14 = i & 8192;
        if (i14 != 0) {
            $dirty4 |= 3072;
            i2 = i14;
        } else {
            i2 = i14;
            if (($changed1 & 3072) == 0) {
                $dirty4 |= $composer2.changed(isError) ? 2048 : 1024;
            }
        }
        int i15 = i & 16384;
        if (i15 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            i3 = i15;
        } else {
            i3 = i15;
            if (($changed1 & CpioConstants.C_ISBLK) == 0) {
                $dirty4 |= $composer2.changed(visualTransformation) ? 16384 : 8192;
            }
        }
        int i16 = i & 32768;
        if (i16 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= $composer2.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i17 = i & 65536;
        if (i17 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty4 |= $composer2.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i18 = i & 131072;
        if (i18 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty4 |= $composer2.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty4 |= ((i & 262144) == 0 && $composer2.changed(maxLines)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i19 = i & 524288;
        if (i19 != 0) {
            $dirty4 |= 805306368;
        } else if (($changed1 & 805306368) == 0) {
            $dirty4 |= $composer2.changed(minLines) ? 536870912 : 268435456;
        }
        int i20 = i & 1048576;
        if (i20 != 0) {
            $dirty5 |= 6;
        } else if (($changed2 & 6) == 0) {
            $dirty5 |= $composer2.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 48) == 0) {
            $dirty5 |= ((i & 2097152) == 0 && $composer2.changed(shape)) ? 32 : 16;
        }
        if (($changed2 & 384) == 0) {
            $dirty5 |= ((i & 4194304) == 0 && $composer2.changed(colors)) ? 256 : 128;
        }
        if (($dirty3 & 306783379) == 306783378 && (306783379 & $dirty4) == 306783378 && ($dirty5 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            readOnly3 = readOnly;
            textStyle3 = textStyle;
            function22 = function2;
            function18 = function3;
            function19 = function4;
            function20 = function5;
            function21 = function6;
            function17 = function7;
            function16 = function8;
            isError3 = isError;
            visualTransformation2 = visualTransformation;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines3 = maxLines;
            minLines2 = minLines;
            interactionSource2 = interactionSource;
            shape3 = shape;
            colors3 = colors;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i5 != 0 ? true : enabled;
                boolean readOnly4 = i6 != 0 ? false : readOnly;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    textStyle2 = (TextStyle) objConsume;
                    $dirty3 &= -458753;
                } else {
                    textStyle2 = textStyle;
                }
                function9 = i7 != 0 ? null : function2;
                function10 = i8 != 0 ? null : function3;
                function11 = i9 != 0 ? null : function4;
                function12 = i10 != 0 ? null : function5;
                function13 = i11 != 0 ? null : function6;
                function14 = i12 != 0 ? null : function7;
                function15 = i13 != 0 ? null : function8;
                isError2 = i2 != 0 ? false : isError;
                VisualTransformation visualTransformation3 = i3 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions3 = i16 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions3 = i17 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine3 = i18 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine3 ? 1 : Integer.MAX_VALUE;
                    $dirty4 &= -234881025;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines3 = i19 != 0 ? 1 : minLines;
                MutableInteractionSource interactionSource3 = i20 != 0 ? null : interactionSource;
                int $dirty6 = $dirty3;
                if ((i & 2097152) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty5 &= -113;
                } else {
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    $dirty = $dirty6;
                    $dirty1 = $dirty4;
                    shape3 = shape2;
                    colors2 = TextFieldDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 = $dirty5 & (-897);
                    readOnly2 = readOnly4;
                    visualTransformation2 = visualTransformation3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    singleLine2 = singleLine3;
                    maxLines3 = maxLines2;
                    minLines2 = minLines3;
                    interactionSource2 = interactionSource3;
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                } else {
                    Shape shape4 = shape2;
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    $dirty = $dirty6;
                    $dirty1 = $dirty4;
                    shape3 = shape4;
                    colors2 = colors;
                    $dirty2 = $dirty5;
                    readOnly2 = readOnly4;
                    visualTransformation2 = visualTransformation3;
                    keyboardOptions2 = keyboardOptions3;
                    keyboardActions2 = keyboardActions3;
                    singleLine2 = singleLine3;
                    maxLines3 = maxLines2;
                    minLines2 = minLines3;
                    interactionSource2 = interactionSource3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty5 &= -113;
                }
                if ((i & 4194304) != 0) {
                    $dirty5 &= -897;
                }
                textStyle2 = textStyle;
                function9 = function2;
                function10 = function3;
                function11 = function4;
                function12 = function5;
                function13 = function6;
                function14 = function7;
                function15 = function8;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                keyboardOptions2 = keyboardOptions;
                keyboardActions2 = keyboardActions;
                singleLine2 = singleLine;
                maxLines3 = maxLines;
                minLines2 = minLines;
                interactionSource2 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty = $dirty3;
                $dirty1 = $dirty4;
                $dirty2 = $dirty5;
                modifier2 = modifier;
                enabled2 = enabled;
                readOnly2 = readOnly;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1268528240, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:367)");
            }
            $composer2.startReplaceGroup(-1263321790);
            ComposerKt.sourceInformation($composer2, "369@19809L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1263321769, "CC(remember):TextField.kt#9igjgp");
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
                mutableInteractionSource = interactionSource2;
            }
            $composer2.endReplaceGroup();
            final MutableInteractionSource interactionSource4 = mutableInteractionSource;
            $composer2.startReplaceGroup(-1263321610);
            ComposerKt.sourceInformation($composer2, "*372@20021L25");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle2.m6281getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != 16) {
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                boolean focused = FocusInteractionKt.collectIsFocusedAsState(interactionSource4, $composer2, 0).getValue().booleanValue();
                textColor = colors2.m2785textColorXeAY9LY$material3_release(enabled2, isError2, focused);
            }
            $composer2.endReplaceGroup();
            final TextStyle mergedTextStyle = textStyle2.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            TextStyle textStyle4 = textStyle2;
            final Modifier modifier5 = modifier2;
            final boolean z = isError2;
            final TextFieldColors textFieldColors = colors2;
            final boolean z2 = enabled2;
            final boolean z3 = readOnly2;
            final KeyboardOptions keyboardOptions4 = keyboardOptions2;
            final KeyboardActions keyboardActions4 = keyboardActions2;
            final boolean z4 = singleLine2;
            final int i21 = maxLines3;
            final int i22 = minLines2;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function27 = function13;
            final Function2 function28 = function14;
            final Function2 function29 = function15;
            final Shape shape5 = shape3;
            Modifier modifier6 = modifier2;
            boolean enabled5 = enabled2;
            boolean readOnly5 = readOnly2;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-1163788208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.3
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

                public final void invoke(Composer $composer3, int $changed3) {
                    ComposerKt.sourceInformation($composer3, "C381@20408L38,398@21179L909,378@20285L1813:TextField.kt#uh7d8r");
                    if (($changed3 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1163788208, $changed3, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:378)");
                        }
                        Modifier modifier7 = modifier5;
                        boolean z5 = z;
                        Strings.Companion companion = Strings.INSTANCE;
                        Modifier modifierM897defaultMinSizeVpY3zN4 = SizeKt.m897defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier7, z5, Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1733R.string.default_error_message), $composer3, 0)), TextFieldDefaults.INSTANCE.m2802getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2801getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(textFieldColors.m2735cursorColorvNxB06k$material3_release(z), null);
                        TextFieldValue textFieldValue = value;
                        Function1<TextFieldValue, Unit> function30 = function1;
                        boolean z6 = z2;
                        boolean z7 = z3;
                        TextStyle textStyle5 = mergedTextStyle;
                        KeyboardOptions keyboardOptions5 = keyboardOptions4;
                        KeyboardActions keyboardActions5 = keyboardActions4;
                        boolean z8 = z4;
                        int i23 = i21;
                        int i24 = i22;
                        VisualTransformation visualTransformation5 = visualTransformation4;
                        MutableInteractionSource mutableInteractionSource2 = interactionSource4;
                        SolidColor solidColor2 = solidColor;
                        final TextFieldValue textFieldValue2 = value;
                        final boolean z9 = z2;
                        final boolean z10 = z4;
                        final VisualTransformation visualTransformation6 = visualTransformation4;
                        final MutableInteractionSource mutableInteractionSource3 = interactionSource4;
                        final boolean z11 = z;
                        final Function2<Composer, Integer, Unit> function31 = function23;
                        final Function2<Composer, Integer, Unit> function32 = function24;
                        final Function2<Composer, Integer, Unit> function33 = function25;
                        final Function2<Composer, Integer, Unit> function34 = function26;
                        final Function2<Composer, Integer, Unit> function35 = function27;
                        final Function2<Composer, Integer, Unit> function36 = function28;
                        final Function2<Composer, Integer, Unit> function37 = function29;
                        final Shape shape6 = shape5;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        BasicTextFieldKt.BasicTextField(textFieldValue, function30, modifierM897defaultMinSizeVpY3zN4, z6, z7, textStyle5, keyboardOptions5, keyboardActions5, z8, i23, i24, visualTransformation5, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, solidColor2, ComposableLambdaKt.rememberComposableLambda(1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function38, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function38, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function38, Composer $composer4, int $changed4) {
                                ComposerKt.sourceInformation($composer4, "C400@21326L748:TextField.kt#uh7d8r");
                                int $dirty7 = $changed4;
                                if (($changed4 & 6) == 0) {
                                    $dirty7 |= $composer4.changedInstance(function38) ? 4 : 2;
                                }
                                int $dirty8 = $dirty7;
                                if (($dirty8 & 19) == 18 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1751957978, $dirty8, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:400)");
                                }
                                TextFieldDefaults.INSTANCE.DecorationBox(textFieldValue2.getText(), function38, z9, z10, visualTransformation6, mutableInteractionSource3, z11, function31, function32, function33, function34, function35, function36, function37, shape6, textFieldColors2, null, null, $composer4, ($dirty8 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.f245xf2722a21);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, 0, ProfileVerifier.CompilationStatus.f245xf2722a21, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function16 = function15;
            function17 = function14;
            textStyle3 = textStyle4;
            modifier3 = modifier6;
            readOnly3 = readOnly5;
            function18 = function10;
            function19 = function11;
            function20 = function12;
            function21 = function13;
            function22 = function9;
            isError3 = isError2;
            enabled3 = enabled5;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final boolean z5 = enabled3;
            final boolean z6 = readOnly3;
            final TextStyle textStyle5 = textStyle3;
            final Function2<? super Composer, ? super Integer, Unit> function30 = function22;
            final Function2<? super Composer, ? super Integer, Unit> function31 = function18;
            final Function2<? super Composer, ? super Integer, Unit> function32 = function19;
            final Function2<? super Composer, ? super Integer, Unit> function33 = function20;
            final Function2<? super Composer, ? super Integer, Unit> function34 = function21;
            final Function2<? super Composer, ? super Integer, Unit> function35 = function17;
            final Function2<? super Composer, ? super Integer, Unit> function36 = function16;
            final boolean z7 = isError3;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final KeyboardOptions keyboardOptions5 = keyboardOptions2;
            final KeyboardActions keyboardActions5 = keyboardActions2;
            final boolean z8 = singleLine2;
            final int i23 = maxLines3;
            final int i24 = minLines2;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            final Shape shape6 = shape3;
            final TextFieldColors textFieldColors2 = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.4
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

                public final void invoke(Composer composer, int i25) {
                    TextFieldKt.TextField(value, function1, modifier7, z5, z6, textStyle5, function30, function31, function32, function33, function34, function35, function36, z7, visualTransformation5, keyboardOptions5, keyboardActions5, z8, i23, i24, mutableInteractionSource2, shape6, textFieldColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, final Function2<? super Composer, ? super Integer, Unit> function7, final Function2<? super Composer, ? super Integer, Unit> function8, final boolean singleLine, final float animationProgress, final Function2<? super Composer, ? super Integer, Unit> function9, final Function2<? super Composer, ? super Integer, Unit> function10, final PaddingValues paddingValues, Composer $composer, final int $changed, final int $changed1) {
        PaddingValues paddingValues2;
        Object value$iv;
        Function0<ComposeUiNode> function0;
        float startPadding;
        float endPadding;
        String str;
        String str2;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function11;
        Function0<ComposeUiNode> function12;
        Function0<ComposeUiNode> function13;
        Function0<ComposeUiNode> function14;
        Function0<ComposeUiNode> function15;
        Function0<ComposeUiNode> function16;
        Composer $composer2 = $composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation($composer2, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)443@22794L139,446@22981L7,447@22993L3994:TextField.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function6) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function7) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function8) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer2.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & $changed) == 0) {
            $dirty |= $composer2.changed(animationProgress) ? 536870912 : 268435456;
        }
        int $dirty2 = $dirty;
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function9) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changedInstance(function10) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            paddingValues2 = paddingValues;
            $dirty1 |= $composer2.changed(paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        int $dirty3 = $dirty1;
        if (($dirty2 & 306783379) != 306783378 || ($dirty3 & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, $dirty2, $dirty3, "androidx.compose.material3.TextFieldLayout (TextField.kt:442)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 243137142, "CC(remember):TextField.kt#9igjgp");
            boolean invalid$iv = ((234881024 & $dirty2) == 67108864) | ((1879048192 & $dirty2) == 536870912) | (($dirty3 & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new TextFieldMeasurePolicy(singleLine, animationProgress, paddingValues2);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            TextFieldMeasurePolicy measurePolicy = (TextFieldMeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            int $changed$iv = ($dirty2 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -95273827, "C453@23312L11,536@26308L229:TextField.kt#uh7d8r");
            function9.invoke($composer2, Integer.valueOf($dirty3 & 14));
            $composer2.startReplaceGroup(-95273802);
            ComposerKt.sourceInformation($composer2, "456@23376L269");
            if (function5 != null) {
                Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function16 = constructor2;
                    $composer2.createNode(function16);
                } else {
                    function16 = constructor2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i3 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1219122288, "C462@23618L9:TextField.kt#uh7d8r");
                function5.invoke($composer2, Integer.valueOf(($dirty2 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-95273467);
            ComposerKt.sourceInformation($composer2, "466@23712L271");
            if (function6 != null) {
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function15 = constructor3;
                    $composer2.createNode(function15);
                } else {
                    function15 = constructor3;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1219122625, "C472@23955L10:TextField.kt#uh7d8r");
                function6.invoke($composer2, Integer.valueOf(($dirty2 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            float startTextFieldPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float endTextFieldPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function5 != null) {
                float other$iv = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv2 = C1979Dp.m6801constructorimpl(startTextFieldPadding - other$iv);
                float minimumValue$iv = C1979Dp.m6801constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv = C1979Dp.m6801constructorimpl(RangesKt.coerceAtLeast(other$iv2, minimumValue$iv));
                startPadding = $this$coerceAtLeast_u2dYgX7TsA$iv;
            } else {
                startPadding = startTextFieldPadding;
            }
            if (function6 != null) {
                float other$iv3 = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv4 = C1979Dp.m6801constructorimpl(endTextFieldPadding - other$iv3);
                float minimumValue$iv2 = C1979Dp.m6801constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv2 = C1979Dp.m6801constructorimpl(RangesKt.coerceAtLeast(other$iv4, minimumValue$iv2));
                endPadding = $this$coerceAtLeast_u2dYgX7TsA$iv2;
            } else {
                endPadding = endTextFieldPadding;
            }
            $composer2.startReplaceGroup(-95272527);
            ComposerKt.sourceInformation($composer2, "491@24650L334");
            if (function7 != null) {
                Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m901heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), startPadding, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv4 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function14 = constructor4;
                    $composer2.createNode(function14);
                } else {
                    function14 = constructor4;
                    $composer2.useNode();
                }
                str = "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp";
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                int i7 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1219123628, "C498@24958L8:TextField.kt#uh7d8r");
                function7.invoke($composer2, Integer.valueOf(($dirty2 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                str = r8;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-95272128);
            ComposerKt.sourceInformation($composer2, "502@25049L332");
            String str3 = str;
            if (function8 != null) {
                Modifier modifier$iv4 = PaddingKt.m872paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m901heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, endPadding, 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                int $changed$iv$iv5 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, str3);
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function13 = constructor5;
                    $composer2.createNode(function13);
                } else {
                    function13 = constructor5;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                    $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash5);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                int i9 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1219124025, "C509@25355L8:TextField.kt#uh7d8r");
                function8.invoke($composer2, Integer.valueOf(($dirty2 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-95271730);
            ComposerKt.sourceInformation($composer2, "514@25446L347");
            if (function3 != null) {
                str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                Modifier modifier$iv5 = PaddingKt.m872paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m901heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "Label"), DpKt.m6844lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), animationProgress), 0.0f, 2, null), null, false, 3, null), startPadding, 0.0f, endPadding, 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv5 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv5, false);
                int $changed$iv$iv6 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str2);
                int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, str3);
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function12 = constructor6;
                    $composer2.createNode(function12);
                } else {
                    function12 = constructor6;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv5.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                    $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
                    $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash6);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                int i10 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                int i11 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1219124454, "C520@25784L7:TextField.kt#uh7d8r");
                function3.invoke($composer2, Integer.valueOf(($dirty2 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                str2 = r6;
            }
            $composer2.endReplaceGroup();
            Modifier textPadding = PaddingKt.m872paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m901heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), function7 == null ? startPadding : C1979Dp.m6801constructorimpl(0), 0.0f, function8 == null ? endPadding : C1979Dp.m6801constructorimpl(0), 0.0f, 10, null);
            $composer2.startReplaceGroup(-95271006);
            ComposerKt.sourceInformation($composer2, "532@26176L105");
            if (function4 != null) {
                function4.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(textPadding), $composer2, Integer.valueOf(($dirty2 >> 6) & 112));
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv6 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(textPadding);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv6 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv6, true);
            int $changed$iv$iv7 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str2);
            int compositeKeyHash$iv$iv6 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv6 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer2, modifier$iv6);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv7 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, str3);
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor7;
                $composer2.createNode(function1);
            } else {
                function1 = constructor7;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv6.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv6.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv6))) {
                $this$Layout_u24lambda_u240$iv$iv6.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv6));
                $this$Layout_u24lambda_u240$iv$iv6.apply(Integer.valueOf(compositeKeyHash$iv$iv6), setCompositeKeyHash7);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
            int i12 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            int i13 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1219125182, "C542@26512L11:TextField.kt#uh7d8r");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(243140899);
            ComposerKt.sourceInformation($composer2, "547@26649L269");
            if (function10 != null) {
                Modifier modifier$iv7 = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m901heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m2793supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv7 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv7, false);
                int $changed$iv$iv8 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str2);
                int compositeKeyHash$iv$iv7 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv7 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer2, modifier$iv7);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv7 = (($changed$iv$iv8 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, str3);
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function11 = constructor8;
                    $composer2.createNode(function11);
                } else {
                    function11 = constructor8;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv7.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv7.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv7))) {
                    $this$Layout_u24lambda_u240$iv$iv7.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv7));
                    $this$Layout_u24lambda_u240$iv$iv7.apply(Integer.valueOf(compositeKeyHash$iv$iv7), setCompositeKeyHash8);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                int i14 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                int i15 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1219125574, "C552@26904L12:TextField.kt#uh7d8r");
                function10.invoke($composer2, Integer.valueOf(($dirty3 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            $dirty3 = $dirty3;
            $composer2 = $composer2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextFieldLayout.2
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

                public final void invoke(Composer composer, int i16) {
                    TextFieldKt.TextFieldLayout(modifier, function2, function3, function4, function5, function6, function7, function8, singleLine, animationProgress, function9, function10, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m2815calculateWidthyeHjK3Y(int leadingWidth, int trailingWidth, int prefixWidth, int suffixWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        int affixTotalWidth = prefixWidth + suffixWidth;
        int middleSection = Math.max(textFieldWidth + affixTotalWidth, Math.max(placeholderWidth + affixTotalWidth, labelWidth));
        int wrappedWidth = leadingWidth + middleSection + trailingWidth;
        return Math.max(wrappedWidth, Constraints.m6746getMinWidthimpl(constraints));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m2814calculateHeightmKXJcVc(int textFieldHeight, int labelHeight, int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int placeholderHeight, int supportingHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        float actualVerticalPadding;
        boolean hasLabel = labelHeight > 0;
        float arg0$iv = paddingValues.getTop();
        float other$iv = paddingValues.getBottom();
        float verticalPadding = C1979Dp.m6801constructorimpl(arg0$iv + other$iv) * density;
        if (hasLabel) {
            float arg0$iv2 = TextFieldImplKt.getTextFieldPadding();
            actualVerticalPadding = MathHelpersKt.lerp(C1979Dp.m6801constructorimpl(2 * arg0$iv2) * density, verticalPadding, animationProgress);
        } else {
            actualVerticalPadding = verticalPadding;
        }
        int inputFieldHeight = ComparisonsKt.maxOf(textFieldHeight, placeholderHeight, prefixHeight, suffixHeight, MathHelpersKt.lerp(labelHeight, 0, animationProgress));
        float middleSectionHeight = MathHelpersKt.lerp(0, labelHeight, animationProgress) + actualVerticalPadding + inputFieldHeight;
        return Math.max(Constraints.m6745getMinHeightimpl(constraints), Math.max(leadingHeight, Math.max(trailingHeight, MathKt.roundToInt(middleSectionHeight))) + supportingHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int totalHeight, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int iRoundToInt;
        Placeable.PlacementScope.m5706place70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.INSTANCE.m6943getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                iRoundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int startPosition = iRoundToInt;
            int distance = startPosition - labelEndPosition;
            int positionY = startPosition - MathKt.roundToInt(distance * animationProgress);
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, labelPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), positionY, 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), textPosition, 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int totalHeight, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        Placeable.PlacementScope.m5706place70tqf50$default($this$placeWithoutLabel, containerPlaceable, IntOffset.INSTANCE.m6943getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, prefixPlaceable), 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, suffixPlaceable), 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, textPlaceable), 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, placeholderPlaceable), 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable placeable) {
        if ($singleLine) {
            return Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), height);
        }
        return topPadding;
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, final BorderStroke indicatorBorder) {
        final float strokeWidthDp = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt.drawIndicatorLine.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$drawWithContent) {
                $this$drawWithContent.drawContent();
                if (C1979Dp.m6806equalsimpl0(strokeWidthDp, C1979Dp.INSTANCE.m6819getHairlineD9Ej5fM())) {
                    return;
                }
                float strokeWidth = strokeWidthDp * $this$drawWithContent.getDensity();
                float y = Size.m4115getHeightimpl($this$drawWithContent.mo4773getSizeNHjbRc()) - (strokeWidth / 2);
                DrawScope.CC.m4849drawLine1RTmtNc$default($this$drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, y), OffsetKt.Offset(Size.m4118getWidthimpl($this$drawWithContent.mo4773getSizeNHjbRc()), y), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}
