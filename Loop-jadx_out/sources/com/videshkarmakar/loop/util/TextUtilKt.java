package com.videshkarmakar.loop.util;

import android.text.TextUtils;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mmkv.MMKV;
import com.videshkarmakar.loop.C3070R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: TextUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a+\u0010\u0007\u001a\u00020\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\t\"\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004\u001a\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001a\u0010\u0013\u001a\u00020\u000f*\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015\u001a\u0012\u0010\u0013\u001a\u00020\u000f*\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u0004*\u00020\u0015\u001a\u0013\u0010\u001a\u001a\u00020\u0004*\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\f\u0010\u001d\u001a\u00020\u0004*\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u001e\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00010\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, m195d2 = {"GIGA_BYTES", "", "MEGA_BYTES", "connectWithBlank", "", "s1", "s2", "connectWithDelimiter", "strings", "", "delimiter", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "matchUrlFromClipboard", "string", "isMatchingMultiLink", "", "matchUrlFromSharedText", "s", "matchUrlFromString", "isNumberInRange", "start", "", "end", "range", "Lkotlin/ranges/IntRange;", "toDurationText", "toFileSizeText", "", "(Ljava/lang/Number;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "toHttpsUrl", "toIntRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextUtilKt {
    private static final float GIGA_BYTES = 1.0737418E9f;
    private static final float MEGA_BYTES = 1048576.0f;

    public static final String toFileSizeText(Number $this$toFileSizeText, Composer $composer, int $changed) {
        String str;
        $composer.startReplaceGroup(1209468420);
        ComposerKt.sourceInformation($composer, "C(toFileSizeText):TextUtil.kt#o3b0ww");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1209468420, $changed, -1, "com.videshkarmakar.loop.util.toFileSizeText (TextUtil.kt:35)");
        }
        $composer.startReplaceGroup(1462632128);
        ComposerKt.sourceInformation($composer, "36@1100L37");
        if ($this$toFileSizeText == null) {
            String strStringResource = StringResources_androidKt.stringResource(C3070R.string.unknown, $composer, 0);
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return strStringResource;
        }
        $composer.endReplaceGroup();
        float $this$toFileSizeText_u24lambda_u240 = $this$toFileSizeText.floatValue();
        if ($this$toFileSizeText_u24lambda_u240 > GIGA_BYTES) {
            $composer.startReplaceGroup(120100369);
            ComposerKt.sourceInformation($composer, "*40@1214L36");
            str = String.format(StringResources_androidKt.stringResource(C3070R.string.filesize_gb, $composer, 0), Arrays.copyOf(new Object[]{Float.valueOf($this$toFileSizeText_u24lambda_u240 / GIGA_BYTES)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(120100445);
            ComposerKt.sourceInformation($composer, "*41@1290L36");
            str = String.format(StringResources_androidKt.stringResource(C3070R.string.filesize_mb, $composer, 0), Arrays.copyOf(new Object[]{Float.valueOf($this$toFileSizeText_u24lambda_u240 / MEGA_BYTES)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return str;
    }

    public static final String toDurationText(int $this$toDurationText) {
        if ($this$toDurationText > 3600) {
            String str = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf($this$toDurationText / MMKV.ExpireInHour), Integer.valueOf(($this$toDurationText % MMKV.ExpireInHour) / 60), Integer.valueOf($this$toDurationText % 60)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        String str2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf($this$toDurationText / 60), Integer.valueOf($this$toDurationText % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final boolean isNumberInRange(String $this$isNumberInRange, int start, int end) {
        Intrinsics.checkNotNullParameter($this$isNumberInRange, "<this>");
        if ($this$isNumberInRange.length() > 0) {
            String $this$isDigitsOnly$iv = $this$isNumberInRange;
            if (TextUtils.isDigitsOnly($this$isDigitsOnly$iv) && $this$isNumberInRange.length() < 10 && Integer.parseInt($this$isNumberInRange) >= start && Integer.parseInt($this$isNumberInRange) <= end) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isNumberInRange(String $this$isNumberInRange, IntRange range) {
        Intrinsics.checkNotNullParameter($this$isNumberInRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return isNumberInRange($this$isNumberInRange, range.getFirst(), range.getLast());
    }

    public static final IntRange toIntRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return new IntRange(MathKt.roundToInt(closedFloatingPointRange.getStart().floatValue()), MathKt.roundToInt(closedFloatingPointRange.getEndInclusive().floatValue()));
    }

    public static final String toHttpsUrl(String $this$toHttpsUrl) {
        if ($this$toHttpsUrl != null) {
            String $this$toHttpsUrl_u24lambda_u242 = $this$toHttpsUrl;
            if (new Regex("^(http:).*").matches($this$toHttpsUrl_u24lambda_u242)) {
                $this$toHttpsUrl_u24lambda_u242 = StringsKt.replaceFirst$default($this$toHttpsUrl_u24lambda_u242, "http", "https", false, 4, (Object) null);
            }
            if ($this$toHttpsUrl_u24lambda_u242 != null) {
                return $this$toHttpsUrl_u24lambda_u242;
            }
        }
        return "";
    }

    public static /* synthetic */ String matchUrlFromClipboard$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return matchUrlFromClipboard(str, z);
    }

    public static final String matchUrlFromClipboard(String string, boolean isMatchingMultiLink) {
        Intrinsics.checkNotNullParameter(string, "string");
        String $this$matchUrlFromClipboard_u24lambda_u243 = matchUrlFromString(string, isMatchingMultiLink);
        if ($this$matchUrlFromClipboard_u24lambda_u243.length() == 0) {
            ToastUtil.INSTANCE.makeToast(C3070R.string.paste_fail_msg);
        } else {
            ToastUtil.INSTANCE.makeToast(C3070R.string.paste_msg);
        }
        return $this$matchUrlFromClipboard_u24lambda_u243;
    }

    public static final String matchUrlFromSharedText(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        String $this$matchUrlFromSharedText_u24lambda_u244 = matchUrlFromString$default(s, false, 2, null);
        if ($this$matchUrlFromSharedText_u24lambda_u244.length() == 0) {
            ToastUtil.INSTANCE.makeToast(C3070R.string.share_fail_msg);
        }
        return $this$matchUrlFromSharedText_u24lambda_u244;
    }

    public static /* synthetic */ String matchUrlFromString$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return matchUrlFromString(str, z);
    }

    public static final String matchUrlFromString(String s, boolean isMatchingMultiLink) {
        Intrinsics.checkNotNullParameter(s, "s");
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("(http|https)://[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?");
        Matcher $this$matchUrlFromString_u24lambda_u245 = pattern.matcher(s);
        if (isMatchingMultiLink) {
            while ($this$matchUrlFromString_u24lambda_u245.find()) {
                if (builder.length() > 0) {
                    builder.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                builder.append($this$matchUrlFromString_u24lambda_u245.group());
            }
        } else if ($this$matchUrlFromString_u24lambda_u245.find()) {
            builder.append($this$matchUrlFromString_u24lambda_u245.group());
        }
        String string = builder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String connectWithDelimiter(String[] strings, String delimiter) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Iterable $this$filter$iv = ArraysKt.toList(strings);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            String str = it;
            if (!(str == null || StringsKt.isBlank(str))) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, delimiter, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.videshkarmakar.loop.util.TextUtilKt.connectWithDelimiter.2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it2) {
                return String.valueOf(it2);
            }
        }, 30, null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    public static final String connectWithBlank(String s1, String s2) {
        String blank;
        Intrinsics.checkNotNullParameter(s1, "s1");
        Intrinsics.checkNotNullParameter(s2, "s2");
        if (s1.length() == 0) {
            blank = "";
        } else {
            if (s2.length() == 0) {
                blank = "";
            } else {
                blank = " ";
            }
        }
        return s1 + blank + s2;
    }
}
