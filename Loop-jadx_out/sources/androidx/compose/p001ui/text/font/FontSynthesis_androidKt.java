package androidx.compose.p001ui.text.font;

import android.graphics.Typeface;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontSynthesis.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m195d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FontSynthesis_androidKt {
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m6385synthesizeTypefaceFxwP2eA(int $this$synthesizeTypeface_u2dFxwP2eA, Object typeface, Font font, FontWeight requestedWeight, int requestedStyle) {
        int finalFontWeight;
        boolean finalFontStyle;
        if (!(typeface instanceof Typeface)) {
            return typeface;
        }
        boolean synthesizeWeight = FontSynthesis.m6378isWeightOnimpl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) && !Intrinsics.areEqual(font.getWeight(), requestedWeight) && requestedWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) < 0;
        boolean synthesizeStyle = FontSynthesis.m6377isStyleOnimpl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) && !FontStyle.m6364equalsimpl0(requestedStyle, font.getStyle());
        if (!synthesizeStyle && !synthesizeWeight) {
            return typeface;
        }
        if (Build.VERSION.SDK_INT < 28) {
            int targetStyle = AndroidFontUtils_androidKt.getAndroidTypefaceStyle(synthesizeWeight, synthesizeStyle && FontStyle.m6364equalsimpl0(requestedStyle, FontStyle.INSTANCE.m6370getItalic_LCdwA()));
            return Typeface.create((Typeface) typeface, targetStyle);
        }
        if (synthesizeWeight) {
            finalFontWeight = requestedWeight.getWeight();
        } else {
            finalFontWeight = font.getWeight().getWeight();
        }
        if (synthesizeStyle) {
            finalFontStyle = FontStyle.m6364equalsimpl0(requestedStyle, FontStyle.INSTANCE.m6370getItalic_LCdwA());
        } else {
            finalFontStyle = FontStyle.m6364equalsimpl0(font.getStyle(), FontStyle.INSTANCE.m6370getItalic_LCdwA());
        }
        return TypefaceHelperMethodsApi28.INSTANCE.create((Typeface) typeface, finalFontWeight, finalFontStyle);
    }
}
