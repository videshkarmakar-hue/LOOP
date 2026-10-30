package com.videshkarmakar.loop.p006ui.theme;

import androidx.compose.material3.Typography;
import androidx.compose.p001ui.graphics.Shadow;
import androidx.compose.p001ui.graphics.drawscope.DrawStyle;
import androidx.compose.p001ui.text.PlatformTextStyle;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontFamilyKt;
import androidx.compose.p001ui.text.font.FontKt;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontSynthesis;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.BaselineShift;
import androidx.compose.p001ui.text.style.LineBreak;
import androidx.compose.p001ui.text.style.LineHeightStyle;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextDirection;
import androidx.compose.p001ui.text.style.TextGeometricTransform;
import androidx.compose.p001ui.text.style.TextIndent;
import androidx.compose.p001ui.text.style.TextMotion;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Type.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\f\u001a\u00020\t*\u00020\tH\u0002\u001a\f\u0010\r\u001a\u00020\t*\u00020\tH\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m195d2 = {"MilkerFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "getMilkerFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "Typography", "Landroidx/compose/material3/Typography;", "getTypography", "()Landroidx/compose/material3/Typography;", "preferenceTitle", "Landroidx/compose/ui/text/TextStyle;", "getPreferenceTitle", "()Landroidx/compose/ui/text/TextStyle;", "applyLinebreak", "applyTextDirection", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TypeKt {
    private static final FontFamily MilkerFontFamily;
    private static final Typography Typography;
    private static final TextStyle preferenceTitle;

    public static final Typography getTypography() {
        return Typography;
    }

    static {
        Typography $this$Typography_u24lambda_u240 = new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        TextStyle textStyleApplyTextDirection = applyTextDirection(applyLinebreak($this$Typography_u24lambda_u240.getBodyLarge()));
        TextStyle textStyleApplyTextDirection2 = applyTextDirection(applyLinebreak($this$Typography_u24lambda_u240.getBodyMedium()));
        TextStyle textStyleApplyTextDirection3 = applyTextDirection(applyLinebreak($this$Typography_u24lambda_u240.getBodySmall()));
        TextStyle textStyleApplyTextDirection4 = applyTextDirection($this$Typography_u24lambda_u240.getTitleLarge());
        TextStyle textStyleApplyTextDirection5 = applyTextDirection($this$Typography_u24lambda_u240.getTitleMedium());
        TextStyle textStyleApplyTextDirection6 = applyTextDirection($this$Typography_u24lambda_u240.getTitleSmall());
        TextStyle textStyleApplyTextDirection7 = applyTextDirection($this$Typography_u24lambda_u240.getHeadlineSmall());
        TextStyle textStyleApplyTextDirection8 = applyTextDirection($this$Typography_u24lambda_u240.getHeadlineMedium());
        TextStyle textStyleApplyTextDirection9 = applyTextDirection($this$Typography_u24lambda_u240.getHeadlineLarge());
        Typography = $this$Typography_u24lambda_u240.copy(applyTextDirection($this$Typography_u24lambda_u240.getDisplayLarge()), applyTextDirection($this$Typography_u24lambda_u240.getDisplayMedium()), applyTextDirection($this$Typography_u24lambda_u240.getDisplaySmall()), textStyleApplyTextDirection9, textStyleApplyTextDirection8, textStyleApplyTextDirection7, textStyleApplyTextDirection4, textStyleApplyTextDirection5, textStyleApplyTextDirection6, textStyleApplyTextDirection, textStyleApplyTextDirection2, textStyleApplyTextDirection3, applyTextDirection($this$Typography_u24lambda_u240.getLabelLarge()), applyTextDirection($this$Typography_u24lambda_u240.getLabelMedium()), applyTextDirection($this$Typography_u24lambda_u240.getLabelSmall()));
        preferenceTitle = new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getDefault(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, LineBreak.INSTANCE.m6589getParagraphrAG3T2k(), 0, (TextMotion) null, 14548953, (DefaultConstructorMarker) null);
        MilkerFontFamily = FontFamilyKt.FontFamily(FontKt.m6347FontYpTlLL0$default(C3070R.font.milker, FontWeight.INSTANCE.getNormal(), 0, 0, 12, null));
    }

    private static final TextStyle applyLinebreak(TextStyle $this$applyLinebreak) {
        return $this$applyLinebreak.m6277copyp1EtxEg((16777213 & 1) != 0 ? $this$applyLinebreak.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? $this$applyLinebreak.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? $this$applyLinebreak.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? $this$applyLinebreak.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? $this$applyLinebreak.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? $this$applyLinebreak.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? $this$applyLinebreak.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? $this$applyLinebreak.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? $this$applyLinebreak.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? $this$applyLinebreak.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? $this$applyLinebreak.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? $this$applyLinebreak.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? $this$applyLinebreak.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? $this$applyLinebreak.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? $this$applyLinebreak.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? $this$applyLinebreak.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? $this$applyLinebreak.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? $this$applyLinebreak.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? $this$applyLinebreak.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? $this$applyLinebreak.platformStyle : null, (16777213 & 1048576) != 0 ? $this$applyLinebreak.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? $this$applyLinebreak.paragraphStyle.getLineBreak() : LineBreak.INSTANCE.m6589getParagraphrAG3T2k(), (16777213 & 4194304) != 0 ? $this$applyLinebreak.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? $this$applyLinebreak.paragraphStyle.getTextMotion() : null);
    }

    private static final TextStyle applyTextDirection(TextStyle $this$applyTextDirection) {
        return $this$applyTextDirection.m6277copyp1EtxEg((16777213 & 1) != 0 ? $this$applyTextDirection.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? $this$applyTextDirection.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? $this$applyTextDirection.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? $this$applyTextDirection.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? $this$applyTextDirection.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? $this$applyTextDirection.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? $this$applyTextDirection.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? $this$applyTextDirection.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? $this$applyTextDirection.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? $this$applyTextDirection.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? $this$applyTextDirection.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? $this$applyTextDirection.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? $this$applyTextDirection.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? $this$applyTextDirection.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? $this$applyTextDirection.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? $this$applyTextDirection.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? $this$applyTextDirection.paragraphStyle.getTextDirection() : TextDirection.INSTANCE.m6672getContents_7Xco(), (16777213 & 131072) != 0 ? $this$applyTextDirection.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? $this$applyTextDirection.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? $this$applyTextDirection.platformStyle : null, (16777213 & 1048576) != 0 ? $this$applyTextDirection.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? $this$applyTextDirection.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? $this$applyTextDirection.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? $this$applyTextDirection.paragraphStyle.getTextMotion() : null);
    }

    public static final TextStyle getPreferenceTitle() {
        return preferenceTitle;
    }

    public static final FontFamily getMilkerFontFamily() {
        return MilkerFontFamily;
    }
}
