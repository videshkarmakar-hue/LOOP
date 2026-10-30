package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.LayoutUtilsKt;
import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.ColorProducer;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.Placeholder;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: BasicText.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010 \u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010!\u001a°\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010#\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0002\u001a\u001e\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207062\b\u00108\u001a\u0004\u0018\u000109H\u0002\u001aÂ\u0001\u0010:\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0014\u0010;\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010-2\u001c\u0010>\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010?0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0003X\u008a\u008e\u0002"}, m195d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "LayoutWithLinksAndInlineContent", "hasInlineContent", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "LayoutWithLinksAndInlineContent-vOo2fZY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "textModifier-cFh6CEA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "foundation_release", "displayedText"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BasicTextKt {
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    public static final void m1158BasicTextVhcvRP8(final String text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, int minLines, ColorProducer color, Composer $composer, final int $changed, final int i) {
        int i2;
        boolean z;
        Modifier.Companion modifier2;
        SelectionController selectionController;
        int i3;
        Modifier finalModifier;
        int minLines2;
        final Function0<ComposeUiNode> function0;
        ColorProducer color2;
        TextStyle style2;
        Function1<? super TextLayoutResult, Unit> function2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1186827822);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)102@5073L7,152@6927L41:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(style) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            i2 = overflow;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = softWrap;
        } else if ((196608 & $changed) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(minLines) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(color) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            style2 = style;
            function2 = function1;
            maxLines2 = maxLines;
            minLines2 = minLines;
            color2 = color;
            softWrap2 = z;
            overflow2 = i2;
        } else {
            modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
            TextStyle style3 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : style;
            Function1<? super TextLayoutResult, Unit> function3 = i6 != 0 ? null : function1;
            int overflow3 = i7 != 0 ? TextOverflow.INSTANCE.m6707getClipgIe3tQ8() : i2;
            boolean softWrap3 = i8 != 0 ? true : z;
            int maxLines3 = i9 != 0 ? Integer.MAX_VALUE : maxLines;
            int minLines3 = i10 != 0 ? 1 : minLines;
            ColorProducer color3 = i11 != 0 ? null : color;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1186827822, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:97)");
            }
            HeightInLinesModifierKt.validateMinMaxLines(minLines3, maxLines3);
            ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localSelectionRegistrar);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) objConsume;
            $composer2.startReplaceGroup(959238947);
            ComposerKt.sourceInformation($composer2, "104@5209L7,106@5355L69,106@5272L152,109@5433L234");
            if (selectionRegistrar != null) {
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer2.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                long backgroundSelectionColor = ((SelectionColors) objConsume2).getSelectionBackgroundColor();
                Object[] objArr = {selectionRegistrar};
                Saver<Long, Long> saverSelectionIdSaver = selectionIdSaver(selectionRegistrar);
                ComposerKt.sourceInformationMarkerStart($composer2, 959239191, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(selectionRegistrar);
                Object value$iv2 = $composer2.rememberedValue();
                if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function0) new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(selectionRegistrar.nextSelectableId());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                long selectableId = ((Number) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (String) null, (Function0) value$iv2, $composer2, 0, 4)).longValue();
                ComposerKt.sourceInformationMarkerStart($composer2, 959239269, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(selectableId) | $composer2.changed(selectionRegistrar) | $composer2.changed(backgroundSelectionColor);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new SelectionController(selectableId, selectionRegistrar, backgroundSelectionColor, null, 8, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                selectionController = (SelectionController) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                selectionController = null;
            }
            $composer2.endReplaceGroup();
            SelectionController selectionController2 = selectionController;
            if (selectionController2 == null && function3 == null) {
                $composer2.startReplaceGroup(959240339);
                ComposerKt.sourceInformation($composer2, "144@6740L7");
                Modifier modifierM4452graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer2.consume(localFontFamilyResolver);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i3 = 0;
                finalModifier = modifierM4452graphicsLayerAp8cVGQ$default.then(new TextStringSimpleElement(text, style3, (FontFamily.Resolver) objConsume3, overflow3, softWrap3, maxLines3, minLines3, color3, null));
                $composer2.endReplaceGroup();
            } else {
                i3 = 0;
                $composer2.startReplaceGroup(959239738);
                ComposerKt.sourceInformation($composer2, "131@6247L7");
                Modifier modifierM4452graphicsLayerAp8cVGQ$default2 = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                AnnotatedString annotatedString = new AnnotatedString(text, null, null, 6, null);
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver2 = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = $composer2.consume(localFontFamilyResolver2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                finalModifier = m1161textModifiercFh6CEA(modifierM4452graphicsLayerAp8cVGQ$default2, annotatedString, style3, function3, overflow3, softWrap3, maxLines3, minLines3, (FontFamily.Resolver) objConsume4, null, null, selectionController2, color3, null);
                $composer2.endReplaceGroup();
            }
            MeasurePolicy measurePolicy$iv = EmptyMeasurePolicy.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, i3);
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, finalModifier);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            minLines2 = minLines3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(new Function0<ComposeUiNode>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText-VhcvRP8$$inlined$Layout$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final ComposeUiNode invoke() {
                        return function0.invoke();
                    }
                });
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u241$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u241$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u241$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u241$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u241$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            color2 = color3;
            style2 = style3;
            function2 = function3;
            overflow2 = overflow3;
            softWrap2 = softWrap3;
            maxLines2 = maxLines3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final TextStyle textStyle = style2;
            final Function1<? super TextLayoutResult, Unit> function4 = function2;
            final int i12 = overflow2;
            final boolean z2 = softWrap2;
            final int i13 = maxLines2;
            final int i14 = minLines2;
            final ColorProducer colorProducer = color2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
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

                public final void invoke(Composer composer, int i15) {
                    BasicTextKt.m1158BasicTextVhcvRP8(text, modifier3, textStyle, function4, i12, z2, i13, i14, colorProducer, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    public static final void m1156BasicTextRWo7tUw(final AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> map, ColorProducer color, Composer $composer, final int $changed, final int i) {
        Function1<? super TextLayoutResult, Unit> function2;
        int i2;
        Modifier modifier2;
        TextStyle style2;
        Function1<? super TextLayoutResult, Unit> function3;
        int overflow2;
        boolean softWrap2;
        Map<String, InlineTextContent> mapEmptyMap;
        ColorProducer color2;
        int $dirty;
        SelectionController selectionController;
        int minLines2;
        int maxLines2;
        Composer $composer2;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer3 = $composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation($composer3, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)197@9326L7:BasicText.kt#423gt5");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(text) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(style) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            function2 = function1;
        } else if (($changed & 3072) == 0) {
            function2 = function1;
            $dirty2 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            i2 = overflow;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = overflow;
            $dirty2 |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer3.changed(softWrap) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(maxLines) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(minLines) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(map) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changedInstance(color) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            style2 = style;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            minLines2 = minLines;
            mapEmptyMap = map;
            color2 = color;
            function3 = function2;
            overflow2 = i2;
            $composer2 = $composer3;
        } else {
            modifier2 = i3 != 0 ? Modifier.INSTANCE : modifier;
            style2 = i4 != 0 ? TextStyle.INSTANCE.getDefault() : style;
            function3 = i5 != 0 ? null : function2;
            overflow2 = i6 != 0 ? TextOverflow.INSTANCE.m6707getClipgIe3tQ8() : i2;
            softWrap2 = i7 != 0 ? true : softWrap;
            int maxLines3 = i8 != 0 ? Integer.MAX_VALUE : maxLines;
            int minLines3 = i9 != 0 ? 1 : minLines;
            mapEmptyMap = i10 != 0 ? MapsKt.emptyMap() : map;
            color2 = i11 != 0 ? null : color;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1064305212, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:192)");
            }
            HeightInLinesModifierKt.validateMinMaxLines(minLines3, maxLines3);
            ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localSelectionRegistrar);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) objConsume;
            $composer3.startReplaceGroup(959243200);
            ComposerKt.sourceInformation($composer3, "199@9462L7,201@9608L69,201@9525L152,204@9686L234");
            if (selectionRegistrar != null) {
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                int $dirty3 = $dirty2;
                long backgroundSelectionColor = ((SelectionColors) objConsume2).getSelectionBackgroundColor();
                Object[] objArr = {selectionRegistrar};
                Saver<Long, Long> saverSelectionIdSaver = selectionIdSaver(selectionRegistrar);
                ComposerKt.sourceInformationMarkerStart($composer3, 959243444, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv = $composer3.changedInstance(selectionRegistrar);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = (Function0) new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(selectionRegistrar.nextSelectableId());
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                long selectableId = ((Number) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (String) null, (Function0) value$iv3, $composer3, 0, 4)).longValue();
                ComposerKt.sourceInformationMarkerStart($composer3, 959243522, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv2 = $composer3.changed(selectableId) | $composer3.changed(selectionRegistrar) | $composer3.changed(backgroundSelectionColor);
                $dirty = $dirty3;
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new SelectionController(selectableId, selectionRegistrar, backgroundSelectionColor, null, 8, null);
                    $composer3.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                selectionController = (SelectionController) value$iv4;
            } else {
                $dirty = $dirty2;
                selectionController = null;
            }
            $composer3.endReplaceGroup();
            boolean hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(text);
            boolean hasLinks = TextAnnotatedStringNodeKt.hasLinks(text);
            if (hasInlineContent || hasLinks) {
                minLines2 = minLines3;
                maxLines2 = maxLines3;
                $composer2 = $composer3;
                int $dirty4 = $dirty;
                $composer2.startReplaceGroup(959244960);
                ComposerKt.sourceInformation($composer2, "242@11145L39,255@11643L7,258@11766L256,244@11194L838");
                ComposerKt.sourceInformationMarkerStart($composer2, 959244981, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv3 = ($dirty4 & 14) == 4;
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(text, null, 2, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv3;
                }
                final MutableState displayedText$delegate = (MutableState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AnnotatedString annotatedStringBasicText_RWo7tUw$lambda$5 = BasicText_RWo7tUw$lambda$5(displayedText$delegate);
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer2.consume(localFontFamilyResolver);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                FontFamily.Resolver resolver = (FontFamily.Resolver) objConsume3;
                ComposerKt.sourceInformationMarkerStart($composer2, 959245602, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv4 = $composer2.changed(displayedText$delegate);
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                            invoke2(textSubstitutionValue);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue substitutionValue) {
                            AnnotatedString original;
                            MutableState<AnnotatedString> mutableState = displayedText$delegate;
                            if (substitutionValue.isShowingSubstitution()) {
                                original = substitutionValue.getSubstitution();
                            } else {
                                original = substitutionValue.getOriginal();
                            }
                            mutableState.setValue(original);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                m1159LayoutWithLinksAndInlineContentvOo2fZY(modifier2, annotatedStringBasicText_RWo7tUw$lambda$5, function3, hasInlineContent, mapEmptyMap, style2, overflow2, softWrap2, maxLines2, minLines2, resolver, selectionController, color2, (Function1) value$iv2, $composer2, (($dirty4 >> 3) & 14) | (($dirty4 >> 3) & 896) | (($dirty4 >> 12) & 57344) | (($dirty4 << 9) & 458752) | (($dirty4 << 6) & 3670016) | (($dirty4 << 6) & 29360128) | (($dirty4 << 6) & 234881024) | (($dirty4 << 6) & 1879048192), ($dirty4 >> 21) & 896, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(959243994);
                ComposerKt.sourceInformation($composer3, "230@10672L7,218@10158L814");
                Modifier modifierM4452graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver2 = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = $composer3.consume(localFontFamilyResolver2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                minLines2 = minLines3;
                maxLines2 = maxLines3;
                Modifier modifier$iv = m1161textModifiercFh6CEA(modifierM4452graphicsLayerAp8cVGQ$default, text, style2, function3, overflow2, softWrap2, maxLines3, minLines3, (FontFamily.Resolver) objConsume4, null, null, selectionController, color2, null);
                MeasurePolicy measurePolicy$iv = EmptyMeasurePolicy.INSTANCE;
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer2, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
                final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart($composer2, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(new Function0<ComposeUiNode>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText-RWo7tUw$$inlined$Layout$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final ComposeUiNode invoke() {
                            return constructor.invoke();
                        }
                    });
                } else {
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u241$iv = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m3802setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u241$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u241$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                    $this$Layout_u24lambda_u241$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u241$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
                }
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final TextStyle textStyle = style2;
            final Function1<? super TextLayoutResult, Unit> function4 = function3;
            final int i12 = overflow2;
            final boolean z = softWrap2;
            final int i13 = maxLines2;
            final int i14 = minLines2;
            final Map<String, InlineTextContent> map2 = mapEmptyMap;
            final ColorProducer colorProducer = color2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$3
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

                public final void invoke(Composer composer, int i15) {
                    BasicTextKt.m1156BasicTextRWo7tUw(text, modifier3, textStyle, function4, i12, z, i13, i14, map2, colorProducer, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final AnnotatedString BasicText_RWo7tUw$lambda$5(MutableState<AnnotatedString> mutableState) {
        MutableState<AnnotatedString> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-BpD7jsM, reason: not valid java name */
    public static final /* synthetic */ void m1155BasicTextBpD7jsM(final String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle;
        Function1 onTextLayout2;
        int i2;
        boolean z;
        Modifier modifier2;
        TextStyle style2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        Function1 onTextLayout3;
        Composer $composer2 = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)280@12424L234:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            textStyle = style;
        } else if (($changed & 384) == 0) {
            textStyle = style;
            $dirty |= $composer2.changed(textStyle) ? 256 : 128;
        } else {
            textStyle = style;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onTextLayout2 = onTextLayout;
        } else if (($changed & 3072) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty |= $composer2.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            i2 = overflow;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = softWrap;
        } else if ((196608 & $changed) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            maxLines2 = maxLines;
            onTextLayout3 = onTextLayout2;
            softWrap2 = z;
            overflow2 = i2;
            style2 = textStyle;
        } else {
            Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
            TextStyle style3 = i4 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
            if (i5 != 0) {
                onTextLayout2 = null;
            }
            int overflow3 = i6 != 0 ? TextOverflow.INSTANCE.m6707getClipgIe3tQ8() : i2;
            boolean softWrap3 = i7 != 0 ? true : z;
            int maxLines3 = i8 != 0 ? Integer.MAX_VALUE : maxLines;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1022429478, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:279)");
            }
            m1158BasicTextVhcvRP8(text, modifier3, style3, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, overflow3, softWrap3, maxLines3, 1, (ColorProducer) null, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            style2 = style3;
            overflow2 = overflow3;
            softWrap2 = softWrap3;
            maxLines2 = maxLines3;
            onTextLayout3 = onTextLayout2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final TextStyle textStyle2 = style2;
            final Function1 function1 = onTextLayout3;
            final int i9 = overflow2;
            final boolean z2 = softWrap2;
            final int i10 = maxLines2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$4
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

                public final void invoke(Composer composer, int i11) {
                    BasicTextKt.m1155BasicTextBpD7jsM(text, modifier4, textStyle2, function1, i9, z2, i10, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    public static final /* synthetic */ void m1153BasicText4YKlhWE(final AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Map inlineContent, Composer $composer, final int $changed, final int i) {
        Function1 onTextLayout2;
        int i2;
        boolean z;
        Map inlineContent2;
        Modifier modifier2;
        TextStyle style2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        Function1 onTextLayout3;
        Composer $composer2 = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)304@13115L273:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(style) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onTextLayout2 = onTextLayout;
        } else if (($changed & 3072) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty |= $composer2.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            i2 = overflow;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = softWrap;
        } else if ((196608 & $changed) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(inlineContent) ? 8388608 : 4194304;
        }
        if (($dirty & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            maxLines2 = maxLines;
            inlineContent2 = inlineContent;
            onTextLayout3 = onTextLayout2;
            softWrap2 = z;
            overflow2 = i2;
            style2 = style;
        } else {
            Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
            TextStyle style3 = i4 != 0 ? TextStyle.INSTANCE.getDefault() : style;
            if (i5 != 0) {
                onTextLayout2 = null;
            }
            int overflow3 = i6 != 0 ? TextOverflow.INSTANCE.m6707getClipgIe3tQ8() : i2;
            boolean softWrap3 = i7 != 0 ? true : z;
            int maxLines3 = i8 != 0 ? Integer.MAX_VALUE : maxLines;
            Map inlineContent3 = i9 != 0 ? MapsKt.emptyMap() : inlineContent;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-648605928, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:303)");
            }
            m1156BasicTextRWo7tUw(text, modifier3, style3, onTextLayout2, overflow3, softWrap3, maxLines3, 1, inlineContent3, null, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (($dirty << 3) & 234881024), 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            inlineContent2 = inlineContent3;
            modifier2 = modifier3;
            style2 = style3;
            overflow2 = overflow3;
            softWrap2 = softWrap3;
            maxLines2 = maxLines3;
            onTextLayout3 = onTextLayout2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final TextStyle textStyle = style2;
            final Function1 function1 = onTextLayout3;
            final int i10 = overflow2;
            final boolean z2 = softWrap2;
            final int i11 = maxLines2;
            final Map map = inlineContent2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$5
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
                    BasicTextKt.m1153BasicText4YKlhWE(text, modifier4, textStyle, function1, i10, z2, i11, map, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    public static final /* synthetic */ void m1154BasicText4YKlhWE(final String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Composer $composer, final int $changed, final int i) {
        Function1 onTextLayout2;
        int i2;
        boolean z;
        Modifier.Companion modifier2;
        TextStyle style2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        int minLines2;
        int minLines3;
        Modifier modifier3;
        TextStyle style3;
        int overflow3;
        boolean softWrap3;
        int maxLines3;
        Function1 onTextLayout3;
        Composer $composer2 = $composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)328@13786L86:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(style) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onTextLayout2 = onTextLayout;
        } else if (($changed & 3072) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty |= $composer2.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            i2 = overflow;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = softWrap;
        } else if ((196608 & $changed) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(minLines) ? 8388608 : 4194304;
        }
        if (($dirty & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            maxLines3 = maxLines;
            minLines3 = minLines;
            onTextLayout3 = onTextLayout2;
            softWrap3 = z;
            overflow3 = i2;
            style3 = style;
        } else {
            if (i3 != 0) {
                modifier2 = Modifier.INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (i4 == 0) {
                style2 = style;
            } else {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i5 != 0) {
                onTextLayout2 = null;
            }
            if (i6 == 0) {
                overflow2 = i2;
            } else {
                overflow2 = TextOverflow.INSTANCE.m6707getClipgIe3tQ8();
            }
            if (i7 == 0) {
                softWrap2 = z;
            } else {
                softWrap2 = true;
            }
            if (i8 == 0) {
                maxLines2 = maxLines;
            } else {
                maxLines2 = Integer.MAX_VALUE;
            }
            if (i9 == 0) {
                minLines2 = minLines;
            } else {
                minLines2 = 1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1542716361, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:328)");
            }
            m1158BasicTextVhcvRP8(text, modifier2, style2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, overflow2, softWrap2, maxLines2, minLines2, (ColorProducer) null, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            minLines3 = minLines2;
            modifier3 = modifier2;
            style3 = style2;
            overflow3 = overflow2;
            softWrap3 = softWrap2;
            maxLines3 = maxLines2;
            onTextLayout3 = onTextLayout2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final TextStyle textStyle = style3;
            final Function1 function1 = onTextLayout3;
            final int i10 = overflow3;
            final boolean z2 = softWrap3;
            final int i11 = maxLines3;
            final int i12 = minLines3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
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

                public final void invoke(Composer composer, int i13) {
                    BasicTextKt.m1154BasicText4YKlhWE(text, modifier4, textStyle, function1, i10, z2, i11, i12, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    public static final /* synthetic */ void m1157BasicTextVhcvRP8(final AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map inlineContent, Composer $composer, final int $changed, final int i) {
        int i2;
        boolean z;
        int minLines2;
        Modifier modifier2;
        Map inlineContent2;
        TextStyle style2;
        Function1 onTextLayout2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        Composer $composer2 = $composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)342@14338L240:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(style) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(onTextLayout) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            i2 = overflow;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            i2 = overflow;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            z = softWrap;
        } else if ((196608 & $changed) == 0) {
            z = softWrap;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = softWrap;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(minLines) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(inlineContent) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            style2 = style;
            maxLines2 = maxLines;
            minLines2 = minLines;
            inlineContent2 = inlineContent;
            overflow2 = i2;
            softWrap2 = z;
            modifier2 = modifier;
            onTextLayout2 = onTextLayout;
        } else {
            Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
            TextStyle style3 = i4 != 0 ? TextStyle.INSTANCE.getDefault() : style;
            Function1 onTextLayout3 = i5 != 0 ? null : onTextLayout;
            int overflow3 = i6 != 0 ? TextOverflow.INSTANCE.m6707getClipgIe3tQ8() : i2;
            boolean softWrap3 = i7 != 0 ? true : z;
            int maxLines3 = i8 != 0 ? Integer.MAX_VALUE : maxLines;
            int minLines3 = i9 != 0 ? 1 : minLines;
            Map inlineContent3 = i10 != 0 ? MapsKt.emptyMap() : inlineContent;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851408699, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:342)");
            }
            m1156BasicTextRWo7tUw(text, modifier3, style3, onTextLayout3, overflow3, softWrap3, maxLines3, minLines3, inlineContent3, null, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty), 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            minLines2 = minLines3;
            modifier2 = modifier3;
            inlineContent2 = inlineContent3;
            style2 = style3;
            onTextLayout2 = onTextLayout3;
            overflow2 = overflow3;
            softWrap2 = softWrap3;
            maxLines2 = maxLines3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final TextStyle textStyle = style2;
            final Function1 function1 = onTextLayout2;
            final int i11 = overflow2;
            final boolean z2 = softWrap2;
            final int i12 = maxLines2;
            final int i13 = minLines2;
            final Map map = inlineContent2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$7
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

                public final void invoke(Composer composer, int i14) {
                    BasicTextKt.m1157BasicTextVhcvRP8(text, modifier4, textStyle, function1, i11, z2, i12, i13, map, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2<SaverScope, Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt.selectionIdSaver.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(SaverScope saverScope, Long l) {
                return invoke(saverScope, l.longValue());
            }

            public final Long invoke(SaverScope $this$Saver, long it) {
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar, it)) {
                    return Long.valueOf(it);
                }
                return null;
            }
        }, new Function1<Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt.selectionIdSaver.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Long invoke(long it) {
                return Long.valueOf(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (function0.invoke().booleanValue()) {
            TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
            List<? extends Measurable> list2 = list;
            int $i$f$fastMapIndexedNotNull = 0;
            ArrayList target$iv = new ArrayList(list2.size());
            int index$iv$iv = 0;
            int size = list2.size();
            while (index$iv$iv < size) {
                Object item$iv$iv = list2.get(index$iv$iv);
                Measurable measurable = (Measurable) item$iv$iv;
                Object parentData = measurable.getParentData();
                Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
                TextRangeScopeMeasurePolicy rangeMeasurePolicy = ((TextRangeLayoutModifier) parentData).getMeasurePolicy();
                TextRangeLayoutMeasureResult rangeMeasureResult = rangeMeasurePolicy.measure(textRangeLayoutMeasureScope);
                TextRangeLayoutMeasureScope textRangeLayoutMeasureScope2 = textRangeLayoutMeasureScope;
                Constraints.Companion companion = Constraints.INSTANCE;
                List<? extends Measurable> list3 = list2;
                int width = rangeMeasureResult.getWidth();
                int $i$f$fastMapIndexedNotNull2 = $i$f$fastMapIndexedNotNull;
                int $i$f$fastMapIndexedNotNull3 = rangeMeasureResult.getHeight();
                Placeable placeable = measurable.mo5644measureBRTryo0(LayoutUtilsKt.fixedCoerceHeightAndWidthForBits(companion, width, $i$f$fastMapIndexedNotNull3));
                target$iv.add(new Pair(placeable, rangeMeasureResult.getPlace()));
                index$iv$iv++;
                textRangeLayoutMeasureScope = textRangeLayoutMeasureScope2;
                list2 = list3;
                $i$f$fastMapIndexedNotNull = $i$f$fastMapIndexedNotNull2;
            }
            return target$iv;
        }
        return null;
    }

    /* JADX INFO: renamed from: textModifier-cFh6CEA, reason: not valid java name */
    private static final Modifier m1161textModifiercFh6CEA(Modifier $this$textModifier_u2dcFh6CEA, AnnotatedString text, TextStyle style, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, int minLines, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function2, SelectionController selectionController, ColorProducer color, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function3) {
        if (selectionController == null) {
            TextAnnotatedStringElement staticTextModifier = new TextAnnotatedStringElement(text, style, fontFamilyResolver, function1, overflow, softWrap, maxLines, minLines, list, function2, null, color, function3, null);
            return $this$textModifier_u2dcFh6CEA.then(Modifier.INSTANCE).then(staticTextModifier);
        }
        SelectableTextAnnotatedStringElement selectableTextModifier = new SelectableTextAnnotatedStringElement(text, style, fontFamilyResolver, function1, overflow, softWrap, maxLines, minLines, list, function2, selectionController, color, null);
        return $this$textModifier_u2dcFh6CEA.then(selectionController.getModifier()).then(selectableTextModifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:260:0x0557  */
    /* JADX WARN: Code duplicated, block: B:263:0x056d  */
    /* JADX WARN: Code duplicated, block: B:264:0x0574  */
    /* JADX WARN: Code duplicated, block: B:267:0x05a4  */
    /* JADX INFO: renamed from: LayoutWithLinksAndInlineContent-vOo2fZY, reason: not valid java name */
    public static final void m1159LayoutWithLinksAndInlineContentvOo2fZY(final Modifier modifier, final AnnotatedString text, final Function1<? super TextLayoutResult, Unit> function1, final boolean hasInlineContent, Map<String, InlineTextContent> map, final TextStyle style, final int overflow, final boolean softWrap, final int maxLines, final int minLines, final FontFamily.Resolver fontFamilyResolver, final SelectionController selectionController, final ColorProducer color, final Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        Map<String, InlineTextContent> mapEmptyMap;
        TextLinkScope textLinkScope;
        Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> pair;
        Function1 function3;
        MutableState mutableState;
        Object value$iv;
        Composer $composer2;
        final TextLinkScope textScope;
        Object value$iv2;
        final MutableState measuredPlaceholderPositions;
        Object value$iv3;
        MeasurePolicy measurePolicy$iv;
        MutableState measuredPlaceholderPositions2;
        Map<String, InlineTextContent> map2;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Composer $composer3 = $composer.startRestartGroup(645129368);
        ComposerKt.sourceInformation($composer3, "C(LayoutWithLinksAndInlineContent)P(6,13,8,2,3,12,9:c#ui.text.style.TextOverflow,11,4,5,1,10)570@21961L117,557@21529L1451:BasicText.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(hasInlineContent) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            mapEmptyMap = map;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            mapEmptyMap = map;
            $dirty |= $composer3.changedInstance(mapEmptyMap) ? 16384 : 8192;
        } else {
            mapEmptyMap = map;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer3.changed(style) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(overflow) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(softWrap) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changed(maxLines) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if ((805306368 & $changed) == 0) {
            $dirty |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(fontFamilyResolver) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(selectionController) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(color) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty & 306783379) != 306783378 || ($dirty1 & 1171) != 1170 || !$composer3.getSkipping()) {
            if (i2 != 0) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(645129368, $dirty, $dirty1, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)");
            }
            $composer3.startReplaceGroup(960247627);
            ComposerKt.sourceInformation($composer3, "539@20949L38");
            if (TextAnnotatedStringNodeKt.hasLinks(text)) {
                ComposerKt.sourceInformationMarkerStart($composer3, 960247658, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv = ($dirty & 112) == 32;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv7 = new TextLinkScope(text);
                    $composer3.updateRememberedValue(value$iv7);
                } else {
                    value$iv7 = it$iv;
                }
                textLinkScope = (TextLinkScope) value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                textLinkScope = null;
            }
            $composer3.endReplaceGroup();
            final TextLinkScope textScope2 = textLinkScope;
            if (hasInlineContent) {
                pair = AnnotatedStringResolveInlineContentKt.resolveInlineContent(text, mapEmptyMap);
            } else {
                pair = new Pair<>(null, null);
            }
            List<AnnotatedString.Range<Placeholder>> listComponent1 = pair.component1();
            List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> listComponent2 = pair.component2();
            $composer3.startReplaceGroup(960247973);
            ComposerKt.sourceInformation($composer3, "550@21296L61");
            if (hasInlineContent) {
                ComposerKt.sourceInformationMarkerStart($composer3, 960248005, "CC(remember):BasicText.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    function3 = null;
                    value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    $composer3.updateRememberedValue(value$iv6);
                } else {
                    function3 = null;
                    value$iv6 = it$iv2;
                }
                mutableState = (MutableState) value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                function3 = null;
                mutableState = null;
            }
            $composer3.endReplaceGroup();
            final MutableState measuredPlaceholderPositions3 = mutableState;
            $composer3.startReplaceGroup(960248140);
            ComposerKt.sourceInformation($composer3, "554@21463L44");
            if (hasInlineContent) {
                ComposerKt.sourceInformationMarkerStart($composer3, 960248172, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv2 = $composer3.changed(measuredPlaceholderPositions3);
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = (Function1) new Function1<List<? extends Rect>, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$onPlaceholderLayout$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Rect> list) {
                            invoke2((List<Rect>) list);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<Rect> list) {
                            MutableState<List<Rect>> mutableState2 = measuredPlaceholderPositions3;
                            if (mutableState2 == null) {
                                return;
                            }
                            mutableState2.setValue(list);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv5);
                } else {
                    value$iv5 = it$iv3;
                }
                function3 = (Function1) value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            $composer3.endReplaceGroup();
            Function1 onPlaceholderLayout = function3;
            Modifier modifierM4452graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4452graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 960248670, "CC(remember):BasicText.kt#9igjgp");
            int $dirty2 = $dirty;
            boolean invalid$iv3 = $composer3.changed(textScope2) | (($dirty & 896) == 256);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        TextLinkScope textLinkScope2 = textScope2;
                        if (textLinkScope2 != null) {
                            textLinkScope2.setTextLayoutResult(it);
                        }
                        Function1<TextLayoutResult, Unit> function4 = function1;
                        if (function4 != null) {
                            function4.invoke(it);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Map<String, InlineTextContent> map3 = mapEmptyMap;
            $composer2 = $composer3;
            Modifier modifier$iv = m1161textModifiercFh6CEA(modifierM4452graphicsLayerAp8cVGQ$default, text, style, (Function1) value$iv, overflow, softWrap, maxLines, minLines, fontFamilyResolver, listComponent1, onPlaceholderLayout, selectionController, color, function2);
            if (hasInlineContent) {
                textScope = textScope2;
                $composer2.startReplaceGroup(960249478);
                ComposerKt.sourceInformation($composer2, "591@22825L55,592@22911L39");
                ComposerKt.sourceInformationMarkerStart($composer2, 960249534, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv4 = $composer2.changed(textScope);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv4 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$4$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextLinkScope it = textScope;
                            return Boolean.valueOf(it != null ? it.getShouldMeasureLinks().invoke().booleanValue() : false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv5;
                }
                Function0 function0 = (Function0) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 960249620, "CC(remember):BasicText.kt#9igjgp");
                measuredPlaceholderPositions = measuredPlaceholderPositions3;
                boolean invalid$iv5 = $composer2.changed(measuredPlaceholderPositions);
                Object it$iv6 = $composer2.rememberedValue();
                if (invalid$iv5 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function0<List<? extends Rect>>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final List<? extends Rect> invoke() {
                            MutableState<List<Rect>> mutableState2 = measuredPlaceholderPositions;
                            if (mutableState2 != null) {
                                return mutableState2.getValue();
                            }
                            return null;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                MeasurePolicy textMeasurePolicy = new TextMeasurePolicy(function0, (Function0) value$iv3);
                $composer2.endReplaceGroup();
                measurePolicy$iv = textMeasurePolicy;
            } else {
                $composer2.startReplaceGroup(960249318);
                ComposerKt.sourceInformation($composer2, "587@22670L55");
                ComposerKt.sourceInformationMarkerStart($composer2, 960249379, "CC(remember):BasicText.kt#9igjgp");
                textScope = textScope2;
                boolean invalid$iv6 = $composer2.changed(textScope);
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv6 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$3$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextLinkScope it = textScope;
                            return Boolean.valueOf(it != null ? it.getShouldMeasureLinks().invoke().booleanValue() : false);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                MeasurePolicy linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0) value$iv4);
                $composer2.endReplaceGroup();
                measurePolicy$iv = linksTextMeasurePolicy;
                measuredPlaceholderPositions = measuredPlaceholderPositions3;
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting()) {
                measuredPlaceholderPositions2 = measuredPlaceholderPositions;
            } else {
                measuredPlaceholderPositions2 = measuredPlaceholderPositions;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -121207689, "C:BasicText.kt#423gt5");
                $composer2.startReplaceGroup(-121207678);
                ComposerKt.sourceInformation($composer2, "559@21580L18");
                if (textScope != null) {
                    textScope.LinksComposables($composer2, 0);
                    Unit unit = Unit.INSTANCE;
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(960248339);
                ComposerKt.sourceInformation($composer2, "*561@21652L48");
                if (listComponent2 == null) {
                    AnnotatedStringResolveInlineContentKt.InlineChildren(text, listComponent2, $composer2, ($dirty2 >> 3) & 14);
                    Unit unit2 = Unit.INSTANCE;
                    Unit unit3 = Unit.INSTANCE;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                map2 = map3;
            }
            $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
            $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -121207689, "C:BasicText.kt#423gt5");
            $composer2.startReplaceGroup(-121207678);
            ComposerKt.sourceInformation($composer2, "559@21580L18");
            if (textScope != null) {
                textScope.LinksComposables($composer2, 0);
                Unit unit4 = Unit.INSTANCE;
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(960248339);
            ComposerKt.sourceInformation($composer2, "*561@21652L48");
            if (listComponent2 == null) {
                AnnotatedStringResolveInlineContentKt.InlineChildren(text, listComponent2, $composer2, ($dirty2 >> 3) & 14);
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            map2 = map3;
        } else {
            $composer3.skipToGroupEnd();
            map2 = mapEmptyMap;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Map<String, InlineTextContent> map4 = map2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$6
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
                    BasicTextKt.m1159LayoutWithLinksAndInlineContentvOo2fZY(modifier, text, function1, hasInlineContent, map4, style, overflow, softWrap, maxLines, minLines, fontFamilyResolver, selectionController, color, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
