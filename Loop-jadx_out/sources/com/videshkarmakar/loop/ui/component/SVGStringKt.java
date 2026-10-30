package com.videshkarmakar.loop.ui.component;

import android.util.Log;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.kyant.monet.TonalPalettes;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SVGString.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "autoDark", "", "isDarkTheme", "", "parseDynamicColor", "tonalPalettes", "Lcom/kyant/monet/TonalPalettes;", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SVGStringKt {
    private static final String TAG = "SVGString";

    public static final String parseDynamicColor(final String $this$parseDynamicColor, final TonalPalettes tonalPalettes, final boolean isDarkTheme) {
        Intrinsics.checkNotNullParameter($this$parseDynamicColor, "<this>");
        Intrinsics.checkNotNullParameter(tonalPalettes, "tonalPalettes");
        return new Regex("fill=\"(.+?)\"").replace($this$parseDynamicColor, new Function1<MatchResult, CharSequence>() { // from class: com.videshkarmakar.loop.ui.component.SVGStringKt.parseDynamicColor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult it) {
                Object objM7557constructorimpl;
                long jM7065accent1vNxB06k;
                Intrinsics.checkNotNullParameter(it, "it");
                String value = it.getGroupValues().get(1);
                Log.i(SVGStringKt.TAG, "parseDynamicColor: " + value);
                if (StringsKt.startsWith$default(value, "#", false, 2, (Object) null)) {
                    return it.getValue();
                }
                String str = $this$parseDynamicColor;
                TonalPalettes tonalPalettes2 = tonalPalettes;
                boolean z = isDarkTheme;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    List<String> listSplit = new Regex("(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)").split(value, 0);
                    String scheme = listSplit.get(0);
                    String tone = listSplit.get(1);
                    switch (scheme.hashCode()) {
                        case 110:
                            jM7065accent1vNxB06k = !scheme.equals("n") ? Color.INSTANCE.m4078getTransparent0d7_KjU() : tonalPalettes2.m7069neutral1vNxB06k(SVGStringKt.autoDark(tone, z));
                            break;
                        case 112:
                            if (scheme.equals("p")) {
                                jM7065accent1vNxB06k = tonalPalettes2.m7065accent1vNxB06k(SVGStringKt.autoDark(tone, z));
                            }
                            break;
                        case 115:
                            if (scheme.equals("s")) {
                                jM7065accent1vNxB06k = tonalPalettes2.m7066accent2vNxB06k(SVGStringKt.autoDark(tone, z));
                            }
                            break;
                        case 116:
                            if (scheme.equals("t")) {
                                jM7065accent1vNxB06k = tonalPalettes2.m7067accent3vNxB06k(SVGStringKt.autoDark(tone, z));
                            }
                            break;
                        case 3528:
                            if (scheme.equals("nv")) {
                                jM7065accent1vNxB06k = tonalPalettes2.m7070neutral2vNxB06k(SVGStringKt.autoDark(tone, z));
                            }
                            break;
                        default:
                            break;
                    }
                    int argb = ColorKt.m4097toArgb8_81llA(jM7065accent1vNxB06k);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & argb)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    objM7557constructorimpl = Result.m7557constructorimpl("fill=\"" + str2 + "\"");
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7557constructorimpl = Result.m7557constructorimpl(ResultKt.createFailure(th));
                }
                String value2 = it.getValue();
                if (Result.m7563isFailureimpl(objM7557constructorimpl)) {
                    objM7557constructorimpl = value2;
                }
                return (CharSequence) objM7557constructorimpl;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double autoDark(String $this$autoDark, boolean isDarkTheme) {
        if (!isDarkTheme) {
            return Double.parseDouble($this$autoDark);
        }
        double d = Double.parseDouble($this$autoDark);
        if (d == 10.0d) {
            return 99.0d;
        }
        if (d == 20.0d) {
            return 95.0d;
        }
        if (d == 25.0d) {
            return 90.0d;
        }
        if (d == 30.0d) {
            return 90.0d;
        }
        if (d == 40.0d) {
            return 80.0d;
        }
        if (d == 50.0d) {
            return 60.0d;
        }
        if (d == 60.0d) {
            return 50.0d;
        }
        if (d == 70.0d) {
            return 40.0d;
        }
        if (d == 80.0d) {
            return 40.0d;
        }
        if (d == 90.0d) {
            return 30.0d;
        }
        if (d == 95.0d) {
            return 20.0d;
        }
        if (d == 98.0d) {
            return 10.0d;
        }
        if (d == 99.0d) {
            return 10.0d;
        }
        if (d == 100.0d) {
            return 20.0d;
        }
        return Double.parseDouble($this$autoDark);
    }
}
