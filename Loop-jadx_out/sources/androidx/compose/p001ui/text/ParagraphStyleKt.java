package androidx.compose.p001ui.text;

import androidx.compose.p001ui.text.style.Hyphens;
import androidx.compose.p001ui.text.style.LineBreak;
import androidx.compose.p001ui.text.style.LineHeightStyle;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDirection;
import androidx.compose.p001ui.text.style.TextIndent;
import androidx.compose.p001ui.text.style.TextIndentKt;
import androidx.compose.p001ui.text.style.TextMotion;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParagraphStyle.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001af\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m195d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m7009getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle start, ParagraphStyle stop, float fraction) {
        int value = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m6651boximpl(start.getTextAlign()), TextAlign.m6651boximpl(stop.getTextAlign()), fraction)).getValue();
        int value2 = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m6665boximpl(start.getTextDirection()), TextDirection.m6665boximpl(stop.getTextDirection()), fraction)).getValue();
        long jM6205lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m6205lerpTextUnitInheritableC3pnCVY(start.getLineHeight(), stop.getLineHeight(), fraction);
        TextIndent textIndent = start.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = stop.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.INSTANCE.getNone();
        }
        return new ParagraphStyle(value, value2, jM6205lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, fraction), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), fraction), (LineHeightStyle) SpanStyleKt.lerpDiscrete(start.getLineHeightStyle(), stop.getLineHeightStyle(), fraction), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m6571boximpl(start.getLineBreak()), LineBreak.m6571boximpl(stop.getLineBreak()), fraction)).getMask(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m6561boximpl(start.getHyphens()), Hyphens.m6561boximpl(stop.getHyphens()), fraction)).getValue(), (TextMotion) SpanStyleKt.lerpDiscrete(start.getTextMotion(), stop.getTextMotion(), fraction), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle start, PlatformParagraphStyle stop, float fraction) {
        if (start == null && stop == null) {
            return null;
        }
        PlatformParagraphStyle startNonNull = start == null ? PlatformParagraphStyle.INSTANCE.getDefault() : start;
        PlatformParagraphStyle stopNonNull = stop == null ? PlatformParagraphStyle.INSTANCE.getDefault() : stop;
        return AndroidTextStyle_androidKt.lerp(startNonNull, stopNonNull, fraction);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle style, LayoutDirection direction) {
        int iM6663getStarte0LSkKk = TextAlign.m6654equalsimpl0(style.getTextAlign(), TextAlign.INSTANCE.m6664getUnspecifiede0LSkKk()) ? TextAlign.INSTANCE.m6663getStarte0LSkKk() : style.getTextAlign();
        int iM6297resolveTextDirectionIhaHGbI = TextStyleKt.m6297resolveTextDirectionIhaHGbI(direction, style.getTextDirection());
        long lineHeight = TextUnitKt.m7016isUnspecifiedR2X_6o(style.getLineHeight()) ? DefaultLineHeight : style.getLineHeight();
        TextIndent textIndent = style.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = style.getPlatformStyle();
        LineHeightStyle lineHeightStyle = style.getLineHeightStyle();
        int iM6590getSimplerAG3T2k = LineBreak.m6577equalsimpl0(style.getLineBreak(), LineBreak.INSTANCE.m6591getUnspecifiedrAG3T2k()) ? LineBreak.INSTANCE.m6590getSimplerAG3T2k() : style.getLineBreak();
        int iM6569getNonevmbZdU8 = Hyphens.m6564equalsimpl0(style.getHyphens(), Hyphens.INSTANCE.m6570getUnspecifiedvmbZdU8()) ? Hyphens.INSTANCE.m6569getNonevmbZdU8() : style.getHyphens();
        TextMotion textMotion = style.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(iM6663getStarte0LSkKk, iM6297resolveTextDirectionIhaHGbI, lineHeight, textIndent2, platformStyle, lineHeightStyle, iM6590getSimplerAG3T2k, iM6569getNonevmbZdU8, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    public static final ParagraphStyle m6158fastMergej5T8yCg(ParagraphStyle $this$fastMerge_u2dj5T8yCg, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        long j;
        long lineHeight2;
        boolean z = true;
        if (TextAlign.m6654equalsimpl0(textAlign, TextAlign.INSTANCE.m6664getUnspecifiede0LSkKk()) || TextAlign.m6654equalsimpl0(textAlign, $this$fastMerge_u2dj5T8yCg.getTextAlign())) {
            if (!TextUnitKt.m7016isUnspecifiedR2X_6o(lineHeight)) {
                j = lineHeight;
                if (TextUnit.m6995equalsimpl0(j, $this$fastMerge_u2dj5T8yCg.getLineHeight())) {
                }
            } else {
                j = lineHeight;
            }
            if ((textIndent == null || Intrinsics.areEqual(textIndent, $this$fastMerge_u2dj5T8yCg.getTextIndent())) && ((TextDirection.m6668equalsimpl0(textDirection, TextDirection.INSTANCE.m6677getUnspecifieds_7Xco()) || TextDirection.m6668equalsimpl0(textDirection, $this$fastMerge_u2dj5T8yCg.getTextDirection())) && ((platformStyle == null || Intrinsics.areEqual(platformStyle, $this$fastMerge_u2dj5T8yCg.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, $this$fastMerge_u2dj5T8yCg.getLineHeightStyle())) && ((LineBreak.m6577equalsimpl0(lineBreak, LineBreak.INSTANCE.m6591getUnspecifiedrAG3T2k()) || LineBreak.m6577equalsimpl0(lineBreak, $this$fastMerge_u2dj5T8yCg.getLineBreak())) && ((Hyphens.m6564equalsimpl0(hyphens, Hyphens.INSTANCE.m6570getUnspecifiedvmbZdU8()) || Hyphens.m6564equalsimpl0(hyphens, $this$fastMerge_u2dj5T8yCg.getHyphens())) && (textMotion == null || Intrinsics.areEqual(textMotion, $this$fastMerge_u2dj5T8yCg.getTextMotion())))))))) {
                z = false;
            }
        } else {
            j = lineHeight;
        }
        boolean requiresAlloc = z;
        if (!requiresAlloc) {
            return $this$fastMerge_u2dj5T8yCg;
        }
        if (TextUnitKt.m7016isUnspecifiedR2X_6o(lineHeight)) {
            lineHeight2 = $this$fastMerge_u2dj5T8yCg.getLineHeight();
        } else {
            lineHeight2 = j;
        }
        return new ParagraphStyle(!TextAlign.m6654equalsimpl0(textAlign, TextAlign.INSTANCE.m6664getUnspecifiede0LSkKk()) ? textAlign : $this$fastMerge_u2dj5T8yCg.getTextAlign(), !TextDirection.m6668equalsimpl0(textDirection, TextDirection.INSTANCE.m6677getUnspecifieds_7Xco()) ? textDirection : $this$fastMerge_u2dj5T8yCg.getTextDirection(), lineHeight2, textIndent == null ? $this$fastMerge_u2dj5T8yCg.getTextIndent() : textIndent, mergePlatformStyle($this$fastMerge_u2dj5T8yCg, platformStyle), lineHeightStyle == null ? $this$fastMerge_u2dj5T8yCg.getLineHeightStyle() : lineHeightStyle, !LineBreak.m6577equalsimpl0(lineBreak, LineBreak.INSTANCE.m6591getUnspecifiedrAG3T2k()) ? lineBreak : $this$fastMerge_u2dj5T8yCg.getLineBreak(), !Hyphens.m6564equalsimpl0(hyphens, Hyphens.INSTANCE.m6570getUnspecifiedvmbZdU8()) ? hyphens : $this$fastMerge_u2dj5T8yCg.getHyphens(), textMotion == null ? $this$fastMerge_u2dj5T8yCg.getTextMotion() : textMotion, (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle $this$mergePlatformStyle, PlatformParagraphStyle other) {
        if ($this$mergePlatformStyle.getPlatformStyle() == null) {
            return other;
        }
        return other == null ? $this$mergePlatformStyle.getPlatformStyle() : $this$mergePlatformStyle.getPlatformStyle().merge(other);
    }
}
