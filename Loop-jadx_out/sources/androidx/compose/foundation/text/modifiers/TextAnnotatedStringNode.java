package androidx.compose.foundation.text.modifiers;

import androidx.compose.animation.C0176x19daea59;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.RectKt;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Canvas;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorProducer;
import androidx.compose.p001ui.graphics.Shadow;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawStyle;
import androidx.compose.p001ui.graphics.drawscope.Fill;
import androidx.compose.p001ui.layout.AlignmentLine;
import androidx.compose.p001ui.layout.AlignmentLineKt;
import androidx.compose.p001ui.layout.HorizontalAlignmentLine;
import androidx.compose.p001ui.layout.IntrinsicMeasurable;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.DrawModifierNode;
import androidx.compose.p001ui.node.DrawModifierNodeKt;
import androidx.compose.p001ui.node.LayoutModifierNode;
import androidx.compose.p001ui.node.LayoutModifierNodeKt;
import androidx.compose.p001ui.node.SemanticsModifierNode;
import androidx.compose.p001ui.node.SemanticsModifierNodeKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.MultiParagraph;
import androidx.compose.p001ui.text.Placeholder;
import androidx.compose.p001ui.text.TextLayoutInput;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.style.Hyphens;
import androidx.compose.p001ui.text.style.LineBreak;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextDirection;
import androidx.compose.p001ui.text.style.TextOverflow;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextAnnotatedStringNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001mBÅ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\u0010\"J\r\u0010;\u001a\u00020\u000eH\u0000¢\u0006\u0002\b<J&\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u0012J\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020DJ\u0010\u0010+\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002J\u001e\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0014J\u001e\u0010M\u001a\u00020\u00142\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0014J(\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010J\u001a\u00020S2\u0006\u0010T\u001a\u00020Uø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001e\u0010X\u001a\u00020\u00142\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0014J\u001e\u0010Y\u001a\u00020\u00142\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0014J\u0015\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\\JZ\u0010]\u001a\u00020\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fJ\u0018\u0010^\u001a\u00020\u00122\b\u0010_\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\bJV\u0010`\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u000e\u0010c\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010d\u001a\u00020\u000e*\u00020eH\u0016J\f\u0010f\u001a\u00020\u000e*\u00020DH\u0016J\u001c\u0010g\u001a\u00020\u0014*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0014H\u0016J\u001c\u0010h\u001a\u00020\u0014*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0014H\u0016J&\u0010i\u001a\u00020P*\u00020R2\u0006\u0010J\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0016ø\u0001\u0000¢\u0006\u0004\bj\u0010WJ\u001c\u0010k\u001a\u00020\u0014*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0014H\u0016J\u001c\u0010l\u001a\u00020\u0014*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0014H\u0016R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0014\u0018\u00010&X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b(\u0010)R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u00020\u0010X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010.\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0/\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R/\u00104\u001a\u0004\u0018\u00010!2\b\u00103\u001a\u0004\u0018\u00010!8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006n"}, m195d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "I", "semanticsTextLayoutResult", "", "shouldClearDescendantSemantics", "getShouldClearDescendantSemantics", "()Z", "<set-?>", "textSubstitution", "getTextSubstitution$foundation_release", "()Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "setTextSubstitution$foundation_release", "(Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;)V", "textSubstitution$delegate", "Landroidx/compose/runtime/MutableState;", "clearSubstitution", "clearSubstitution$foundation_release", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "drawNonExtension", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "density", "Landroidx/compose/ui/unit/Density;", "maxIntrinsicHeightNonExtension", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidthNonExtension", "height", "measureNonExtension", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeightNonExtension", "minIntrinsicWidthNonExtension", "setSubstitution", "updatedText", "setSubstitution$foundation_release", "updateCallbacks", "updateDraw", "color", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-MPT68mk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateText", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "measure-3p2s80s", "minIntrinsicHeight", "minIntrinsicWidth", "TextSubstitutionValue", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private MultiParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private Function1<? super List<Rect>, Unit> onPlaceholderLayout;
    private Function1<? super TextSubstitutionValue, Unit> onShowTranslation;
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private SelectionController selectionController;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    /* JADX INFO: renamed from: textSubstitution$delegate, reason: from kotlin metadata */
    private final MutableState textSubstitution;

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function2, SelectionController selectionController, ColorProducer colorProducer, Function1 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function2, selectionController, colorProducer, function3);
    }

    private static /* synthetic */ void getBaselineCache$annotations() {
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function2, SelectionController selectionController, ColorProducer colorProducer, Function1 function3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? null : function1, (i4 & 16) != 0 ? TextOverflow.INSTANCE.m6707getClipgIe3tQ8() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : function2, (i4 & 1024) != 0 ? null : selectionController, (i4 & 2048) != 0 ? null : colorProducer, (i4 & 4096) != 0 ? null : function3, null);
    }

    private TextAnnotatedStringNode(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function2, SelectionController selectionController, ColorProducer overrideColor, Function1<? super TextSubstitutionValue, Unit> function3) {
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.onTextLayout = function1;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = list;
        this.onPlaceholderLayout = function2;
        this.selectionController = selectionController;
        this.overrideColor = overrideColor;
        this.onShowTranslation = function3;
        this.textSubstitution = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache cache;
        TextSubstitutionValue textSubstitutionValue = getTextSubstitution$foundation_release();
        if (textSubstitutionValue != null && textSubstitutionValue.isShowingSubstitution() && (cache = textSubstitutionValue.getLayoutCache()) != null) {
            cache.setDensity$foundation_release(density);
            return cache;
        }
        MultiParagraphLayoutCache it = getLayoutCache();
        it.setDensity$foundation_release(density);
        return it;
    }

    public final boolean updateDraw(ColorProducer color, TextStyle style) {
        boolean changed = false;
        if (!Intrinsics.areEqual(color, this.overrideColor)) {
            changed = true;
        }
        this.overrideColor = color;
        boolean changed2 = changed || !style.hasSameDrawAffectingAttributes(this.style);
        return changed2;
    }

    public final boolean updateText(AnnotatedString text) {
        boolean anyDiff = true;
        boolean charDiff = !Intrinsics.areEqual(this.text.getText(), text.getText());
        boolean spanDiff = !Intrinsics.areEqual(this.text.getSpanStyles(), text.getSpanStyles());
        boolean paragraphDiff = !Intrinsics.areEqual(this.text.getParagraphStyles(), text.getParagraphStyles());
        boolean annotationDiff = !this.text.hasEqualsAnnotations(text);
        if (!charDiff && !spanDiff && !paragraphDiff && !annotationDiff) {
            anyDiff = false;
        }
        if (anyDiff) {
            this.text = text;
        }
        if (charDiff) {
            clearSubstitution$foundation_release();
        }
        return anyDiff;
    }

    /* JADX INFO: renamed from: updateLayoutRelatedArgs-MPT68mk, reason: not valid java name */
    public final boolean m1456updateLayoutRelatedArgsMPT68mk(TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int minLines, int maxLines, boolean softWrap, FontFamily.Resolver fontFamilyResolver, int overflow) {
        boolean changed = !this.style.hasSameLayoutAffectingAttributes(style);
        this.style = style;
        if (!Intrinsics.areEqual(this.placeholders, placeholders)) {
            this.placeholders = placeholders;
            changed = true;
        }
        if (this.minLines != minLines) {
            this.minLines = minLines;
            changed = true;
        }
        if (this.maxLines != maxLines) {
            this.maxLines = maxLines;
            changed = true;
        }
        if (this.softWrap != softWrap) {
            this.softWrap = softWrap;
            changed = true;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            changed = true;
        }
        if (!TextOverflow.m6700equalsimpl0(this.overflow, overflow)) {
            this.overflow = overflow;
            return true;
        }
        return changed;
    }

    public final boolean updateCallbacks(Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super List<Rect>, Unit> onPlaceholderLayout, SelectionController selectionController, Function1<? super TextSubstitutionValue, Unit> onShowTranslation) {
        boolean changed = false;
        if (!Intrinsics.areEqual(this.onTextLayout, onTextLayout)) {
            this.onTextLayout = onTextLayout;
            changed = true;
        }
        if (!Intrinsics.areEqual(this.onPlaceholderLayout, onPlaceholderLayout)) {
            this.onPlaceholderLayout = onPlaceholderLayout;
            changed = true;
        }
        if (!Intrinsics.areEqual(this.selectionController, selectionController)) {
            this.selectionController = selectionController;
            changed = true;
        }
        if (!Intrinsics.areEqual(this.onShowTranslation, onShowTranslation)) {
            this.onShowTranslation = onShowTranslation;
            return true;
        }
        return changed;
    }

    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged, boolean callbacksChanged) {
        if (textChanged || layoutChanged || callbacksChanged) {
            getLayoutCache().m1440updateZNqEYIc(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
        }
        if (!getIsAttached()) {
            return;
        }
        if (textChanged || (drawChanged && this.semanticsTextLayoutResult != null)) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (textChanged || layoutChanged || callbacksChanged) {
            LayoutModifierNodeKt.invalidateMeasurement(this);
            DrawModifierNodeKt.invalidateDraw(this);
        }
        if (drawChanged) {
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    /* JADX INFO: compiled from: TextAnnotatedStringNode.kt */
    @Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, m195d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "", "original", "Landroidx/compose/ui/text/AnnotatedString;", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;ZLandroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "getOriginal", "()Landroidx/compose/ui/text/AnnotatedString;", "getSubstitution", "setSubstitution", "(Landroidx/compose/ui/text/AnnotatedString;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private MultiParagraphLayoutCache layoutCache;
        private final AnnotatedString original;
        private AnnotatedString substitution;

        public static /* synthetic */ TextSubstitutionValue copy$default(TextSubstitutionValue textSubstitutionValue, AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z, MultiParagraphLayoutCache multiParagraphLayoutCache, int i, Object obj) {
            if ((i & 1) != 0) {
                annotatedString = textSubstitutionValue.original;
            }
            if ((i & 2) != 0) {
                annotatedString2 = textSubstitutionValue.substitution;
            }
            if ((i & 4) != 0) {
                z = textSubstitutionValue.isShowingSubstitution;
            }
            if ((i & 8) != 0) {
                multiParagraphLayoutCache = textSubstitutionValue.layoutCache;
            }
            return textSubstitutionValue.copy(annotatedString, annotatedString2, z, multiParagraphLayoutCache);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnnotatedString getOriginal() {
            return this.original;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final TextSubstitutionValue copy(AnnotatedString original, AnnotatedString substitution, boolean isShowingSubstitution, MultiParagraphLayoutCache layoutCache) {
            return new TextSubstitutionValue(original, substitution, isShowingSubstitution, layoutCache);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) other;
            return Intrinsics.areEqual(this.original, textSubstitutionValue.original) && Intrinsics.areEqual(this.substitution, textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && Intrinsics.areEqual(this.layoutCache, textSubstitutionValue.layoutCache);
        }

        public int hashCode() {
            return (((((this.original.hashCode() * 31) + this.substitution.hashCode()) * 31) + C0176x19daea59.m9m(this.isShowingSubstitution)) * 31) + (this.layoutCache == null ? 0 : this.layoutCache.hashCode());
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + ((Object) this.original) + ", substitution=" + ((Object) this.substitution) + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ')';
        }

        public TextSubstitutionValue(AnnotatedString original, AnnotatedString substitution, boolean isShowingSubstitution, MultiParagraphLayoutCache layoutCache) {
            this.original = original;
            this.substitution = substitution;
            this.isShowingSubstitution = isShowingSubstitution;
            this.layoutCache = layoutCache;
        }

        public /* synthetic */ TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z, MultiParagraphLayoutCache multiParagraphLayoutCache, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(annotatedString, annotatedString2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : multiParagraphLayoutCache);
        }

        public final AnnotatedString getOriginal() {
            return this.original;
        }

        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        public final void setSubstitution(AnnotatedString annotatedString) {
            this.substitution = annotatedString;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setShowingSubstitution(boolean z) {
            this.isShowingSubstitution = z;
        }

        public final MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final void setLayoutCache(MultiParagraphLayoutCache multiParagraphLayoutCache) {
            this.layoutCache = multiParagraphLayoutCache;
        }
    }

    public final TextSubstitutionValue getTextSubstitution$foundation_release() {
        State $this$getValue$iv = this.textSubstitution;
        return (TextSubstitutionValue) $this$getValue$iv.getValue();
    }

    public final void setTextSubstitution$foundation_release(TextSubstitutionValue textSubstitutionValue) {
        MutableState $this$setValue$iv = this.textSubstitution;
        $this$setValue$iv.setValue(textSubstitutionValue);
    }

    public final boolean setSubstitution$foundation_release(AnnotatedString updatedText) {
        Unit unit;
        TextSubstitutionValue currentTextSubstitution = getTextSubstitution$foundation_release();
        if (currentTextSubstitution != null) {
            if (Intrinsics.areEqual(updatedText, currentTextSubstitution.getSubstitution())) {
                return false;
            }
            currentTextSubstitution.setSubstitution(updatedText);
            MultiParagraphLayoutCache layoutCache = currentTextSubstitution.getLayoutCache();
            if (layoutCache != null) {
                layoutCache.m1440updateZNqEYIc(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit != null;
        }
        TextSubstitutionValue newTextSubstitution = new TextSubstitutionValue(this.text, updatedText, false, null, 12, null);
        MultiParagraphLayoutCache substitutionLayoutCache = new MultiParagraphLayoutCache(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
        substitutionLayoutCache.setDensity$foundation_release(getLayoutCache().getDensity());
        newTextSubstitution.setLayoutCache(substitutionLayoutCache);
        setTextSubstitution$foundation_release(newTextSubstitution);
        return true;
    }

    public final void clearSubstitution$foundation_release() {
        setTextSubstitution$foundation_release(null);
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Function1<? super List<TextLayoutResult>, Boolean> function1 = this.semanticsTextLayoutResult;
        if (function1 == null) {
            function1 = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.1
                {
                    super(1);
                }

                /* JADX WARN: Code duplicated, block: B:16:0x00ce  */
                /* JADX WARN: Code duplicated, block: B:17:0x00d0  */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(List<TextLayoutResult> list) {
                    TextLayoutResult it;
                    boolean z;
                    TextLayoutResult inputLayout = TextAnnotatedStringNode.this.getLayoutCache().getLayoutCache();
                    if (inputLayout != null) {
                        AnnotatedString text = inputLayout.getLayoutInput().getText();
                        TextStyle textStyle = TextAnnotatedStringNode.this.style;
                        ColorProducer colorProducer = TextAnnotatedStringNode.this.overrideColor;
                        it = TextLayoutResult.m6221copyO0kMr_c$default(inputLayout, new TextLayoutInput(text, textStyle.m6296mergedA7vx0o((16609105 & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : colorProducer != null ? colorProducer.mo1670invoke0d7_KjU() : Color.INSTANCE.m4327getUnspecified0d7_KjU(), (16609105 & 2) != 0 ? TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE() : 0L, (16609105 & 4) != 0 ? null : null, (16609105 & 8) != 0 ? null : null, (16609105 & 16) != 0 ? null : null, (16609105 & 32) != 0 ? null : null, (16609105 & 64) != 0 ? null : null, (16609105 & 128) != 0 ? TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE() : 0L, (16609105 & 256) != 0 ? null : null, (16609105 & 512) != 0 ? null : null, (16609105 & 1024) != 0 ? null : null, (16609105 & 2048) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : 0L, (16609105 & 4096) != 0 ? null : null, (16609105 & 8192) != 0 ? null : null, (16609105 & 16384) != 0 ? null : null, (16609105 & 32768) != 0 ? TextAlign.INSTANCE.m6664getUnspecifiede0LSkKk() : 0, (16609105 & 65536) != 0 ? TextDirection.INSTANCE.m6677getUnspecifieds_7Xco() : 0, (16609105 & 131072) != 0 ? TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE() : 0L, (16609105 & 262144) != 0 ? null : null, (16609105 & 524288) != 0 ? null : null, (16609105 & 1048576) != 0 ? LineBreak.INSTANCE.m6591getUnspecifiedrAG3T2k() : 0, (16609105 & 2097152) != 0 ? Hyphens.INSTANCE.m6570getUnspecifiedvmbZdU8() : 0, (16609105 & 4194304) != 0 ? null : null, (16609105 & 8388608) != 0 ? null : null), inputLayout.getLayoutInput().getPlaceholders(), inputLayout.getLayoutInput().getMaxLines(), inputLayout.getLayoutInput().getSoftWrap(), inputLayout.getLayoutInput().getOverflow(), inputLayout.getLayoutInput().getDensity(), inputLayout.getLayoutInput().getLayoutDirection(), inputLayout.getLayoutInput().getFontFamilyResolver(), inputLayout.getLayoutInput().getConstraints(), (DefaultConstructorMarker) null), 0L, 2, null);
                        if (it != null) {
                            list.add(it);
                        }
                        if (it != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                    it = null;
                    if (it != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            };
            this.semanticsTextLayoutResult = function1;
        }
        SemanticsPropertiesKt.setText($this$applySemantics, this.text);
        TextSubstitutionValue currentTextSubstitution = getTextSubstitution$foundation_release();
        if (currentTextSubstitution != null) {
            SemanticsPropertiesKt.setTextSubstitution($this$applySemantics, currentTextSubstitution.getSubstitution());
            SemanticsPropertiesKt.setShowingTextSubstitution($this$applySemantics, currentTextSubstitution.isShowingSubstitution());
        }
        SemanticsPropertiesKt.setTextSubstitution$default($this$applySemantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString updatedText) {
                TextAnnotatedStringNode.this.setSubstitution$foundation_release(updatedText);
                SemanticsModifierNodeKt.invalidateSemantics(TextAnnotatedStringNode.this);
                return true;
            }
        }, 1, null);
        SemanticsPropertiesKt.showTextSubstitution$default($this$applySemantics, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final Boolean invoke(boolean it) {
                if (TextAnnotatedStringNode.this.getTextSubstitution$foundation_release() != null) {
                    Function1 function2 = TextAnnotatedStringNode.this.onShowTranslation;
                    if (function2 != null) {
                        TextSubstitutionValue textSubstitution$foundation_release = TextAnnotatedStringNode.this.getTextSubstitution$foundation_release();
                        Intrinsics.checkNotNull(textSubstitution$foundation_release);
                        function2.invoke(textSubstitution$foundation_release);
                    }
                    TextSubstitutionValue textSubstitution$foundation_release2 = TextAnnotatedStringNode.this.getTextSubstitution$foundation_release();
                    if (textSubstitution$foundation_release2 != null) {
                        textSubstitution$foundation_release2.setShowingSubstitution(it);
                    }
                    SemanticsModifierNodeKt.invalidateSemantics(TextAnnotatedStringNode.this);
                    LayoutModifierNodeKt.invalidateMeasurement(TextAnnotatedStringNode.this);
                    DrawModifierNodeKt.invalidateDraw(TextAnnotatedStringNode.this);
                    return true;
                }
                return false;
            }
        }, 1, null);
        SemanticsPropertiesKt.clearTextSubstitution$default($this$applySemantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.applySemantics.4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextAnnotatedStringNode.this.clearSubstitution$foundation_release();
                SemanticsModifierNodeKt.invalidateSemantics(TextAnnotatedStringNode.this);
                LayoutModifierNodeKt.invalidateMeasurement(TextAnnotatedStringNode.this);
                DrawModifierNodeKt.invalidateDraw(TextAnnotatedStringNode.this);
                return true;
            }
        }, 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, null, function1, 1, null);
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: getShouldClearDescendantSemantics */
    public boolean getIsClearingSemantics() {
        return true;
    }

    /* JADX INFO: renamed from: measureNonExtension-3p2s80s, reason: not valid java name */
    public final MeasureResult m1455measureNonExtension3p2s80s(MeasureScope measureScope, Measurable measurable, long constraints) {
        return mo337measure3p2s80s(measureScope, measurable, constraints);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo337measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        MultiParagraphLayoutCache layoutCache = getLayoutCache($this$measure_u2d3p2s80s);
        boolean didChangeLayout = layoutCache.m1439layoutWithConstraintsK40F9xA(constraints, $this$measure_u2d3p2s80s.getLayoutDirection());
        TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
        if (didChangeLayout) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Function1<? super TextLayoutResult, Unit> function1 = this.onTextLayout;
            if (function1 != null) {
                function1.invoke(textLayoutResult);
            }
            SelectionController selectionController = this.selectionController;
            if (selectionController != null) {
                selectionController.updateTextLayout(textLayoutResult);
            }
            LinkedHashMap linkedHashMap = this.baselineCache;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap(2);
            }
            HorizontalAlignmentLine firstBaseline = AlignmentLineKt.getFirstBaseline();
            float $this$fastRoundToInt$iv = textLayoutResult.getFirstBaseline();
            linkedHashMap.put(firstBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv)));
            HorizontalAlignmentLine lastBaseline = AlignmentLineKt.getLastBaseline();
            float $this$fastRoundToInt$iv2 = textLayoutResult.getLastBaseline();
            linkedHashMap.put(lastBaseline, Integer.valueOf(Math.round($this$fastRoundToInt$iv2)));
            this.baselineCache = linkedHashMap;
        }
        Function1<? super List<Rect>, Unit> function2 = this.onPlaceholderLayout;
        if (function2 != null) {
            function2.invoke(textLayoutResult.getPlaceholderRects());
        }
        final Placeable placeable = measurable.mo5644measureBRTryo0(LayoutUtilsKt.fixedCoerceHeightAndWidthForBits(Constraints.INSTANCE, IntSize.m6975getWidthimpl(textLayoutResult.getSize()), IntSize.m6974getHeightimpl(textLayoutResult.getSize())));
        int iM6975getWidthimpl = IntSize.m6975getWidthimpl(textLayoutResult.getSize());
        int iM6974getHeightimpl = IntSize.m6974getHeightimpl(textLayoutResult.getSize());
        Map<AlignmentLine, Integer> map = this.baselineCache;
        Intrinsics.checkNotNull(map);
        return $this$measure_u2d3p2s80s.layout(iM6975getWidthimpl, iM6974getHeightimpl, map, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                Placeable.PlacementScope.place$default($this$layout, placeable, 0, 0, 0.0f, 4, null);
            }
        });
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return minIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return getLayoutCache($this$minIntrinsicWidth).minIntrinsicWidth($this$minIntrinsicWidth.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return minIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return getLayoutCache($this$minIntrinsicHeight).intrinsicHeight(width, $this$minIntrinsicHeight.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return maxIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return getLayoutCache($this$maxIntrinsicWidth).maxIntrinsicWidth($this$maxIntrinsicWidth.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return maxIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return getLayoutCache($this$maxIntrinsicHeight).intrinsicHeight(width, $this$maxIntrinsicHeight.getLayoutDirection());
    }

    public final void drawNonExtension(ContentDrawScope contentDrawScope) throws Throwable {
        draw(contentDrawScope);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0169  */
    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public void draw(ContentDrawScope $this$draw) throws Throwable {
        Canvas canvas;
        long jM4317getBlack0d7_KjU;
        boolean z;
        boolean zHasLinks;
        if (!getIsAttached()) {
            return;
        }
        SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            selectionController.draw($this$draw);
        }
        ContentDrawScope $this$drawIntoCanvas$iv = $this$draw;
        Canvas canvas2 = $this$drawIntoCanvas$iv.getDrawContext().getCanvas();
        MultiParagraphLayoutCache layoutCache = getLayoutCache($this$draw);
        TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        MultiParagraph localParagraph = textLayoutResult.getMultiParagraph();
        boolean willClip = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m6700equalsimpl0(this.overflow, TextOverflow.INSTANCE.m6709getVisiblegIe3tQ8());
        if (willClip) {
            float width = IntSize.m6975getWidthimpl(textLayoutResult.getSize());
            float height = IntSize.m6974getHeightimpl(textLayoutResult.getSize());
            Rect bounds = RectKt.m4089Recttz77jQw(Offset.INSTANCE.m4065getZeroF1C5BW0(), SizeKt.Size(width, height));
            canvas2.save();
            Canvas.CC.m4265clipRectmtrdDE$default(canvas2, bounds, 0, 2, null);
        }
        try {
            TextDecoration textDecoration = this.style.getTextDecoration();
            if (textDecoration == null) {
                try {
                    textDecoration = TextDecoration.INSTANCE.getNone();
                } catch (Throwable th) {
                    th = th;
                    canvas = canvas2;
                    if (willClip) {
                        canvas.restore();
                    }
                    throw th;
                }
            }
            TextDecoration textDecoration2 = textDecoration;
            Shadow shadow = this.style.getShadow();
            if (shadow == null) {
                shadow = Shadow.INSTANCE.getNone();
            }
            Shadow shadow2 = shadow;
            Fill drawStyle = this.style.getDrawStyle();
            if (drawStyle == null) {
                drawStyle = Fill.INSTANCE;
            }
            DrawStyle drawStyle2 = drawStyle;
            Brush brush = this.style.getBrush();
            if (brush == null) {
                ColorProducer colorProducer = this.overrideColor;
                long overrideColorVal = colorProducer != null ? colorProducer.mo1670invoke0d7_KjU() : Color.INSTANCE.m4327getUnspecified0d7_KjU();
                long $this$isSpecified$iv = overrideColorVal;
                if ($this$isSpecified$iv != 16) {
                    jM4317getBlack0d7_KjU = overrideColorVal;
                } else {
                    long $this$isSpecified$iv2 = this.style.m6281getColor0d7_KjU();
                    if ($this$isSpecified$iv2 != 16) {
                        jM4317getBlack0d7_KjU = this.style.m6281getColor0d7_KjU();
                    } else {
                        jM4317getBlack0d7_KjU = Color.INSTANCE.m4317getBlack0d7_KjU();
                    }
                }
                long color = jM4317getBlack0d7_KjU;
                z = true;
                canvas = canvas2;
                try {
                    localParagraph.m6119paintLG529CI(canvas2, (32 & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : color, (32 & 4) != 0 ? null : shadow2, (32 & 8) != 0 ? null : textDecoration2, (32 & 16) == 0 ? drawStyle2 : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m4861getDefaultBlendMode0nO6VwU() : 0);
                } catch (Throwable th2) {
                    th = th2;
                    if (willClip) {
                        canvas.restore();
                    }
                    throw th;
                }
            } else {
                float alpha = this.style.getAlpha();
                localParagraph.m6121painthn5TExg(canvas2, brush, (64 & 4) != 0 ? Float.NaN : alpha, (64 & 8) != 0 ? null : shadow2, (64 & 16) != 0 ? null : textDecoration2, (64 & 32) != 0 ? null : drawStyle2, (64 & 64) != 0 ? DrawScope.INSTANCE.m4861getDefaultBlendMode0nO6VwU() : 0);
                canvas = canvas2;
                z = true;
            }
            if (willClip) {
                canvas.restore();
            }
            TextSubstitutionValue textSubstitution$foundation_release = getTextSubstitution$foundation_release();
            if (textSubstitution$foundation_release != null && textSubstitution$foundation_release.isShowingSubstitution() == z) {
                zHasLinks = false;
            } else {
                zHasLinks = TextAnnotatedStringNodeKt.hasLinks(this.text);
            }
            boolean hasLinks = zHasLinks;
            if (!hasLinks) {
                List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
                if (list == null || list.isEmpty()) {
                    return;
                }
            }
            $this$draw.drawContent();
        } catch (Throwable th3) {
            th = th3;
            canvas = canvas2;
        }
    }
}
