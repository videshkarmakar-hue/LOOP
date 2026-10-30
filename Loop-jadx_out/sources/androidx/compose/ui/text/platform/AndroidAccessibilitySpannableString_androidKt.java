package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.collection.LongObjectMap;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidAccessibilitySpannableString.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001aB\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0007\u001a\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002¨\u0006\u0018"}, d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "linkActions", "Landroidx/collection/LongObjectMap;", "Lkotlin/Function0;", "accessibilityNodeId", "toUrl", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidAccessibilitySpannableString_androidKt {
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString $this$toAccessibilitySpannableString, Density density, FontFamily.Resolver fontFamilyResolver, URLSpanCache urlSpanCache, LongObjectMap<Function0<Unit>> longObjectMap, int accessibilityNodeId) {
        SpannableString spannableString = new SpannableString($this$toAccessibilitySpannableString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release = $this$toAccessibilitySpannableString.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            int size = spanStylesOrNull$ui_text_release.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = spanStylesOrNull$ui_text_release.get(index$iv);
                AnnotatedString.Range<SpanStyle> range = (AnnotatedString.Range) item$iv;
                SpanStyle style = range.component1();
                int start = range.getStart();
                int end = range.getEnd();
                SpanStyle noFontStyle = style.m5946copyGSF8kmg((65503 & 1) != 0 ? style.m5951getColor0d7_KjU() : 0L, (65503 & 2) != 0 ? style.fontSize : 0L, (65503 & 4) != 0 ? style.fontWeight : null, (65503 & 8) != 0 ? style.fontStyle : null, (65503 & 16) != 0 ? style.fontSynthesis : null, (65503 & 32) != 0 ? style.fontFamily : null, (65503 & 64) != 0 ? style.fontFeatureSettings : null, (65503 & 128) != 0 ? style.letterSpacing : 0L, (65503 & 256) != 0 ? style.baselineShift : null, (65503 & 512) != 0 ? style.textGeometricTransform : null, (65503 & 1024) != 0 ? style.localeList : null, (65503 & 2048) != 0 ? style.background : 0L, (65503 & 4096) != 0 ? style.textDecoration : null, (65503 & 8192) != 0 ? style.shadow : null, (65503 & 16384) != 0 ? style.platformStyle : null, (65503 & 32768) != 0 ? style.drawStyle : null);
                setSpanStyle(spannableString, noFontStyle, start, end, density, fontFamilyResolver);
            }
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = $this$toAccessibilitySpannableString.getTtsAnnotations(0, $this$toAccessibilitySpannableString.length());
        int size2 = ttsAnnotations.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = ttsAnnotations.get(index$iv2);
            AnnotatedString.Range<TtsAnnotation> range2 = (AnnotatedString.Range) item$iv2;
            TtsAnnotation ttsAnnotation = range2.component1();
            int start2 = range2.getStart();
            int end2 = range2.getEnd();
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan(ttsAnnotation), start2, end2, 33);
        }
        List<AnnotatedString.Range<UrlAnnotation>> urlAnnotations = $this$toAccessibilitySpannableString.getUrlAnnotations(0, $this$toAccessibilitySpannableString.length());
        int size3 = urlAnnotations.size();
        for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
            Object item$iv3 = urlAnnotations.get(index$iv3);
            AnnotatedString.Range<UrlAnnotation> range3 = (AnnotatedString.Range) item$iv3;
            UrlAnnotation urlAnnotation = range3.component1();
            int start3 = range3.getStart();
            int end3 = range3.getEnd();
            spannableString.setSpan(urlSpanCache.toURLSpan(urlAnnotation), start3, end3, 33);
        }
        List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = $this$toAccessibilitySpannableString.getLinkAnnotations(0, $this$toAccessibilitySpannableString.length());
        int size4 = linkAnnotations.size();
        for (int index$iv4 = 0; index$iv4 < size4; index$iv4++) {
            Object item$iv4 = linkAnnotations.get(index$iv4);
            AnnotatedString.Range<LinkAnnotation> range4 = (AnnotatedString.Range) item$iv4;
            if (longObjectMap != null && longObjectMap.isNotEmpty()) {
                spannableString.setSpan(urlSpanCache.toClickableSpan(range4, longObjectMap, accessibilityNodeId), range4.getStart(), range4.getEnd(), 33);
            } else if (range4.getItem() instanceof LinkAnnotation.Url) {
                spannableString.setSpan(urlSpanCache.toURLSpan(toUrl(range4)), range4.getStart(), range4.getEnd(), 33);
            }
        }
        return spannableString;
    }

    private static final void setSpanStyle(SpannableString $this$setSpanStyle, SpanStyle spanStyle, int start, int end, Density density, FontFamily.Resolver fontFamilyResolver) {
        SpannableExtensions_androidKt.m6285setColorRPmYEkk($this$setSpanStyle, spanStyle.m5951getColor0d7_KjU(), start, end);
        SpannableExtensions_androidKt.m6286setFontSizeKmRG4DE($this$setSpanStyle, spanStyle.getFontSize(), density, start, end);
        if (spanStyle.getFontWeight() != null || spanStyle.getFontStyle() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = spanStyle.getFontStyle();
            int fontStyle2 = fontStyle != null ? fontStyle.m6119unboximpl() : FontStyle.INSTANCE.m6123getNormal_LCdwA();
            $this$setSpanStyle.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m6069getAndroidTypefaceStyleFO1MlWM(fontWeight, fontStyle2)), start, end, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                $this$setSpanStyle.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), start, end, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
                Object value = FontFamily.Resolver.CC.m6091resolveDPcqOEQ$default(fontFamilyResolver, fontFamily, null, 0, fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m6133getAllGVVA2EU(), 6, null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                Typeface typeface = (Typeface) value;
                $this$setSpanStyle.setSpan(Api28Impl.INSTANCE.createTypefaceSpan(typeface), start, end, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            if (spanStyle.getTextDecoration().contains(TextDecoration.INSTANCE.getUnderline())) {
                $this$setSpanStyle.setSpan(new UnderlineSpan(), start, end, 33);
            }
            if (spanStyle.getTextDecoration().contains(TextDecoration.INSTANCE.getLineThrough())) {
                $this$setSpanStyle.setSpan(new StrikethroughSpan(), start, end, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            $this$setSpanStyle.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), start, end, 33);
        }
        SpannableExtensions_androidKt.setLocaleList($this$setSpanStyle, spanStyle.getLocaleList(), start, end);
        SpannableExtensions_androidKt.m6283setBackgroundRPmYEkk($this$setSpanStyle, spanStyle.getBackground(), start, end);
    }

    private static final AnnotatedString.Range<LinkAnnotation.Url> toUrl(AnnotatedString.Range<LinkAnnotation> range) {
        LinkAnnotation item = range.getItem();
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        return new AnnotatedString.Range<>((LinkAnnotation.Url) item, range.getStart(), range.getEnd());
    }
}
