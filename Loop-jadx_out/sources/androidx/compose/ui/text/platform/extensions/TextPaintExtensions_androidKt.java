package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextPaintExtensions.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextPaintExtensions_androidKt {
    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0198  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ac  */
    public static final SpanStyle applySpanStyle(AndroidTextPaint $this$applySpanStyle, SpanStyle style, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, Density density, boolean requiresLetterSpacing) {
        Locale locale;
        long jM6749getTypeUIouoOA = TextUnit.m6749getTypeUIouoOA(style.getFontSize());
        if (TextUnitType.m6778equalsimpl0(jM6749getTypeUIouoOA, TextUnitType.INSTANCE.m6783getSpUIouoOA())) {
            $this$applySpanStyle.setTextSize(density.mo318toPxR2X_6o(style.getFontSize()));
        } else if (TextUnitType.m6778equalsimpl0(jM6749getTypeUIouoOA, TextUnitType.INSTANCE.m6782getEmUIouoOA())) {
            $this$applySpanStyle.setTextSize($this$applySpanStyle.getTextSize() * TextUnit.m6750getValueimpl(style.getFontSize()));
        }
        if (hasFontAttributes(style)) {
            FontFamily fontFamily = style.getFontFamily();
            FontWeight fontWeight = style.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = style.getFontStyle();
            FontStyle fontStyleM6113boximpl = FontStyle.m6113boximpl(fontStyle != null ? fontStyle.m6119unboximpl() : FontStyle.INSTANCE.m6123getNormal_LCdwA());
            FontSynthesis fontSynthesis = style.getFontSynthesis();
            $this$applySpanStyle.setTypeface(function4.invoke(fontFamily, fontWeight, fontStyleM6113boximpl, FontSynthesis.m6124boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m6133getAllGVVA2EU())));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual(style.getLocaleList(), LocaleList.INSTANCE.getCurrent())) {
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleListHelperMethods.INSTANCE.setTextLocales($this$applySpanStyle, style.getLocaleList());
            } else {
                if (style.getLocaleList().isEmpty()) {
                    locale = Locale.INSTANCE.getCurrent();
                } else {
                    locale = style.getLocaleList().get(0);
                }
                $this$applySpanStyle.setTextLocale(locale.getPlatformLocale());
            }
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
            $this$applySpanStyle.setFontFeatureSettings(style.getFontFeatureSettings());
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.INSTANCE.getNone$ui_text_release())) {
            $this$applySpanStyle.setTextScaleX($this$applySpanStyle.getTextScaleX() * style.getTextGeometricTransform().getScaleX());
            $this$applySpanStyle.setTextSkewX($this$applySpanStyle.getTextSkewX() + style.getTextGeometricTransform().getSkewX());
        }
        $this$applySpanStyle.m6275setColor8_81llA(style.m5951getColor0d7_KjU());
        $this$applySpanStyle.m6273setBrush12SF9DM(style.getBrush(), Size.INSTANCE.m3878getUnspecifiedNHjbRc(), style.getAlpha());
        $this$applySpanStyle.setShadow(style.getShadow());
        $this$applySpanStyle.setTextDecoration(style.getTextDecoration());
        $this$applySpanStyle.setDrawStyle(style.getDrawStyle());
        if (TextUnitType.m6778equalsimpl0(TextUnit.m6749getTypeUIouoOA(style.getLetterSpacing()), TextUnitType.INSTANCE.m6783getSpUIouoOA())) {
            if (!(TextUnit.m6750getValueimpl(style.getLetterSpacing()) == 0.0f)) {
                float emWidth = $this$applySpanStyle.getTextSize() * $this$applySpanStyle.getTextScaleX();
                float letterSpacingPx = density.mo318toPxR2X_6o(style.getLetterSpacing());
                if (!(emWidth == 0.0f)) {
                    $this$applySpanStyle.setLetterSpacing(letterSpacingPx / emWidth);
                }
            } else if (TextUnitType.m6778equalsimpl0(TextUnit.m6749getTypeUIouoOA(style.getLetterSpacing()), TextUnitType.INSTANCE.m6782getEmUIouoOA())) {
                $this$applySpanStyle.setLetterSpacing(TextUnit.m6750getValueimpl(style.getLetterSpacing()));
            }
        } else if (TextUnitType.m6778equalsimpl0(TextUnit.m6749getTypeUIouoOA(style.getLetterSpacing()), TextUnitType.INSTANCE.m6782getEmUIouoOA())) {
            $this$applySpanStyle.setLetterSpacing(TextUnit.m6750getValueimpl(style.getLetterSpacing()));
        }
        return m6289generateFallbackSpanStyle62GTOB8(style.getLetterSpacing(), requiresLetterSpacing, style.getBackground(), style.getBaselineShift());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX INFO: renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    private static final SpanStyle m6289generateFallbackSpanStyle62GTOB8(long letterSpacing, boolean requiresLetterSpacing, long background, BaselineShift baselineShift) {
        boolean hasLetterSpacing;
        boolean hasBaselineShift;
        if (requiresLetterSpacing && TextUnitType.m6778equalsimpl0(TextUnit.m6749getTypeUIouoOA(letterSpacing), TextUnitType.INSTANCE.m6783getSpUIouoOA())) {
            if (TextUnit.m6750getValueimpl(letterSpacing) == 0.0f) {
                hasLetterSpacing = false;
            } else {
                hasLetterSpacing = true;
            }
        } else {
            hasLetterSpacing = false;
        }
        boolean hasBackgroundColor = (Color.m4044equalsimpl0(background, Color.INSTANCE.m4079getUnspecified0d7_KjU()) || Color.m4044equalsimpl0(background, Color.INSTANCE.m4078getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
            hasBaselineShift = BaselineShift.m6297equalsimpl0(baselineShift.m6300unboximpl(), BaselineShift.INSTANCE.m6304getNoney9eOQZs()) ? false : true;
        }
        if (!hasLetterSpacing && !hasBackgroundColor && !hasBaselineShift) {
            return null;
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, hasLetterSpacing ? letterSpacing : TextUnit.INSTANCE.m6761getUnspecifiedXSAIIZE(), hasBaselineShift ? baselineShift : null, (TextGeometricTransform) null, (LocaleList) null, hasBackgroundColor ? background : Color.INSTANCE.m4079getUnspecified0d7_KjU(), (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63103, (DefaultConstructorMarker) null);
    }

    public static final void setTextMotion(AndroidTextPaint $this$setTextMotion, TextMotion textMotion) {
        int flags;
        TextMotion finalTextMotion = textMotion == null ? TextMotion.INSTANCE.getStatic() : textMotion;
        if (finalTextMotion.getSubpixelTextPositioning()) {
            flags = $this$setTextMotion.getFlags() | 128;
        } else {
            flags = $this$setTextMotion.getFlags() & (-129);
        }
        $this$setTextMotion.setFlags(flags);
        int linearity = finalTextMotion.getLinearity();
        if (TextMotion.Linearity.m6442equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m6447getLinear4e0Vf04())) {
            $this$setTextMotion.setFlags($this$setTextMotion.getFlags() | 64);
            $this$setTextMotion.setHinting(0);
        } else if (TextMotion.Linearity.m6442equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m6446getFontHinting4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(1);
        } else if (TextMotion.Linearity.m6442equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m6448getNone4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(0);
        } else {
            $this$setTextMotion.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle $this$hasFontAttributes) {
        return ($this$hasFontAttributes.getFontFamily() == null && $this$hasFontAttributes.getFontStyle() == null && $this$hasFontAttributes.getFontWeight() == null) ? false : true;
    }

    public static final float correctBlurRadius(float blurRadius) {
        if (blurRadius == 0.0f) {
            return Float.MIN_VALUE;
        }
        return blurRadius;
    }
}
