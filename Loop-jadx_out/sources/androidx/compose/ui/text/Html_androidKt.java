package androidx.compose.ui.text;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.HttpStatusCodesKt;
import okio.Utf8;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: Html.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000W\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002\u001a$\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0001\u001a\f\u0010\u0016\u001a\u00020\u0015*\u00020\u0013H\u0001\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001cH\u0002\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001e"}, d2 = {"AnnotationTag", "", Html_androidKt.ContentHandlerReplacementTag, "TagHandler", "androidx/compose/ui/text/Html_androidKt$TagHandler$1", "Landroidx/compose/ui/text/Html_androidKt$TagHandler$1;", "optionalFontFamilyFromName", "Landroidx/compose/ui/text/font/FontFamily;", "familyName", "addSpan", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "span", "", "start", "", "end", "addSpans", "spanned", "Landroid/text/Spanned;", "parseAsHtml", "Landroidx/compose/ui/text/AnnotatedString;", "toAnnotatedString", "toParagraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroid/text/style/AlignmentSpan;", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroid/text/style/StyleSpan;", "Landroid/text/style/TypefaceSpan;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Html_androidKt {
    private static final String AnnotationTag = "annotation";
    private static final String ContentHandlerReplacementTag = "ContentHandlerReplacementTag";
    private static final Html_androidKt$TagHandler$1 TagHandler = new Html.TagHandler() { // from class: androidx.compose.ui.text.Html_androidKt$TagHandler$1
        @Override // android.text.Html.TagHandler
        public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
            if (xmlReader != null && output != null && opening && Intrinsics.areEqual(tag, "ContentHandlerReplacementTag")) {
                ContentHandler currentContentHandler = xmlReader.getContentHandler();
                xmlReader.setContentHandler(new AnnotationContentHandler(currentContentHandler, output));
            }
        }
    };

    /* JADX INFO: compiled from: Html.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final AnnotatedString parseAsHtml(String $this$parseAsHtml) {
        String stringToParse = "<ContentHandlerReplacementTag />" + $this$parseAsHtml;
        Spanned spanned = HtmlCompat.fromHtml(stringToParse, 63, null, TagHandler);
        return toAnnotatedString(spanned);
    }

    public static final AnnotatedString toAnnotatedString(Spanned $this$toAnnotatedString) {
        AnnotatedString.Builder it = new AnnotatedString.Builder($this$toAnnotatedString.length()).append((CharSequence) $this$toAnnotatedString);
        addSpans(it, $this$toAnnotatedString);
        return it.toAnnotatedString();
    }

    private static final void addSpans(AnnotatedString.Builder $this$addSpans, Spanned spanned) {
        Object[] $this$forEach$iv = spanned.getSpans(0, $this$addSpans.getLength(), Object.class);
        for (Object element$iv : $this$forEach$iv) {
            long range = TextRangeKt.TextRange(spanned.getSpanStart(element$iv), spanned.getSpanEnd(element$iv));
            addSpan($this$addSpans, element$iv, TextRange.m6003getStartimpl(range), TextRange.m5998getEndimpl(range));
        }
    }

    private static final void addSpan(AnnotatedString.Builder $this$addSpan, Object span, int start, int end) {
        String it;
        if (!(span instanceof AbsoluteSizeSpan)) {
            if (span instanceof AlignmentSpan) {
                $this$addSpan.addStyle(toParagraphStyle((AlignmentSpan) span), start, end);
                return;
            }
            if (span instanceof AnnotationSpan) {
                $this$addSpan.addStringAnnotation(((AnnotationSpan) span).getKey(), ((AnnotationSpan) span).getValue(), start, end);
                return;
            }
            if (span instanceof BackgroundColorSpan) {
                $this$addSpan.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, ColorKt.Color(((BackgroundColorSpan) span).getBackgroundColor()), (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63487, (DefaultConstructorMarker) null), start, end);
                return;
            }
            if (span instanceof ForegroundColorSpan) {
                $this$addSpan.addStyle(new SpanStyle(ColorKt.Color(((ForegroundColorSpan) span).getForegroundColor()), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), start, end);
                return;
            }
            if (span instanceof RelativeSizeSpan) {
                $this$addSpan.addStyle(new SpanStyle(0L, TextUnitKt.getEm(((RelativeSizeSpan) span).getSizeChange()), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, Utf8.REPLACEMENT_CODE_POINT, (DefaultConstructorMarker) null), start, end);
                return;
            }
            if (span instanceof StrikethroughSpan) {
                $this$addSpan.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getLineThrough(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), start, end);
                return;
            }
            if (span instanceof StyleSpan) {
                SpanStyle it2 = toSpanStyle((StyleSpan) span);
                if (it2 != null) {
                    $this$addSpan.addStyle(it2, start, end);
                    return;
                }
                return;
            }
            if (span instanceof SubscriptSpan) {
                $this$addSpan.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.m6294boximpl(BaselineShift.INSTANCE.m6305getSubscripty9eOQZs()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), start, end);
                return;
            }
            if (span instanceof SuperscriptSpan) {
                $this$addSpan.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.m6294boximpl(BaselineShift.INSTANCE.m6306getSuperscripty9eOQZs()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), start, end);
                return;
            }
            if (span instanceof TypefaceSpan) {
                $this$addSpan.addStyle(toSpanStyle((TypefaceSpan) span), start, end);
                return;
            }
            if (span instanceof UnderlineSpan) {
                $this$addSpan.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), start, end);
            } else if ((span instanceof URLSpan) && (it = ((URLSpan) span).getURL()) != null) {
                $this$addSpan.addLink(new LinkAnnotation.Url(it), start, end);
            }
        }
    }

    private static final ParagraphStyle toParagraphStyle(AlignmentSpan $this$toParagraphStyle) {
        int alignment;
        Layout.Alignment alignment2 = $this$toParagraphStyle.getAlignment();
        switch (alignment2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[alignment2.ordinal()]) {
            case 1:
                alignment = TextAlign.INSTANCE.m6415getStarte0LSkKk();
                break;
            case 2:
                alignment = TextAlign.INSTANCE.m6410getCentere0LSkKk();
                break;
            case 3:
                alignment = TextAlign.INSTANCE.m6411getEnde0LSkKk();
                break;
            default:
                alignment = TextAlign.INSTANCE.m6416getUnspecifiede0LSkKk();
                break;
        }
        return new ParagraphStyle(alignment, 0, 0L, (TextIndent) null, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, HttpStatusCodesKt.HTTP_NOT_EXTENDED, (DefaultConstructorMarker) null);
    }

    private static final SpanStyle toSpanStyle(StyleSpan $this$toSpanStyle) {
        switch ($this$toSpanStyle.getStyle()) {
            case 1:
                return new SpanStyle(0L, 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null);
            case 2:
                return new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.m6113boximpl(FontStyle.INSTANCE.m6122getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null);
            case 3:
                return new SpanStyle(0L, 0L, FontWeight.INSTANCE.getBold(), FontStyle.m6113boximpl(FontStyle.INSTANCE.m6122getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65523, (DefaultConstructorMarker) null);
            default:
                return null;
        }
    }

    private static final SpanStyle toSpanStyle(TypefaceSpan $this$toSpanStyle) {
        FontFamily fontFamily;
        String family = $this$toSpanStyle.getFamily();
        if (Intrinsics.areEqual(family, FontFamily.INSTANCE.getCursive().getName())) {
            fontFamily = FontFamily.INSTANCE.getCursive();
        } else if (Intrinsics.areEqual(family, FontFamily.INSTANCE.getMonospace().getName())) {
            fontFamily = FontFamily.INSTANCE.getMonospace();
        } else if (Intrinsics.areEqual(family, FontFamily.INSTANCE.getSansSerif().getName())) {
            fontFamily = FontFamily.INSTANCE.getSansSerif();
        } else {
            fontFamily = Intrinsics.areEqual(family, FontFamily.INSTANCE.getSerif().getName()) ? FontFamily.INSTANCE.getSerif() : optionalFontFamilyFromName($this$toSpanStyle.getFamily());
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65503, (DefaultConstructorMarker) null);
    }

    private static final FontFamily optionalFontFamilyFromName(String familyName) {
        String str = familyName;
        if (str == null || str.length() == 0) {
            return null;
        }
        Typeface typeface = Typeface.create(familyName, 0);
        Typeface it = (Intrinsics.areEqual(typeface, Typeface.DEFAULT) || Intrinsics.areEqual(typeface, Typeface.create(Typeface.DEFAULT, 0))) ? false : true ? typeface : null;
        if (it != null) {
            return AndroidTypeface_androidKt.FontFamily(it);
        }
        return null;
    }
}
