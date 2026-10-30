package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.MediaType;

/* JADX INFO: compiled from: -MediaTypeCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\bH\u0000\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\f\u0010\u000f\u001a\u00020\b*\u00020\u0003H\u0000\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\b*\u00020\u0003\u001a\f\u0010\u0011\u001a\u00020\u0003*\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m195d2 = {"PARAMETER", "Lkotlin/text/Regex;", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "commonEquals", "", "Lokhttp3/MediaType;", "other", "", "commonHashCode", "", "commonParameter", "name", "commonToMediaType", "commonToMediaTypeOrNull", "commonToString", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _MediaTypeCommonKt {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Regex TYPE_SUBTYPE = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Regex PARAMETER = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final String commonParameter(MediaType $this$commonParameter, String name) {
        Intrinsics.checkNotNullParameter($this$commonParameter, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, $this$commonParameter.getParameterNamesAndValues().length - 1, 2);
        if (0 <= progressionLastElement) {
            while (!StringsKt.equals($this$commonParameter.getParameterNamesAndValues()[i], name, true)) {
                if (i == progressionLastElement) {
                    return null;
                }
                i += 2;
            }
            return $this$commonParameter.getParameterNamesAndValues()[i + 1];
        }
        return null;
    }

    public static final boolean commonEquals(MediaType $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        return (other instanceof MediaType) && Intrinsics.areEqual(((MediaType) other).getMediaType(), $this$commonEquals.getMediaType());
    }

    public static final String commonToString(MediaType $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return $this$commonToString.getMediaType();
    }

    public static final int commonHashCode(MediaType $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        return $this$commonHashCode.getMediaType().hashCode();
    }

    public static final MediaType commonToMediaType(String $this$commonToMediaType) {
        String value;
        Intrinsics.checkNotNullParameter($this$commonToMediaType, "<this>");
        MatchResult typeSubtype = _UtilCommonKt.matchAtPolyfill(TYPE_SUBTYPE, $this$commonToMediaType, 0);
        if (typeSubtype == null) {
            throw new IllegalArgumentException("No subtype found for: \"" + $this$commonToMediaType + '\"');
        }
        String $this$lowercase$iv = typeSubtype.getGroupValues().get(1);
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String type = $this$lowercase$iv.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(type, "this as java.lang.String).toLowerCase(locale)");
        String $this$lowercase$iv2 = typeSubtype.getGroupValues().get(2);
        Locale ROOT2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
        String subtype = $this$lowercase$iv2.toLowerCase(ROOT2);
        Intrinsics.checkNotNullExpressionValue(subtype, "this as java.lang.String).toLowerCase(locale)");
        Collection parameterNamesAndValues = (List) new ArrayList();
        int s = typeSubtype.getRange().getLast() + 1;
        while (s < s) {
            MatchResult parameter = _UtilCommonKt.matchAtPolyfill(PARAMETER, $this$commonToMediaType, s);
            if (!(parameter != null)) {
                StringBuilder sbAppend = new StringBuilder().append("Parameter is not formatted correctly: \"");
                String strSubstring = $this$commonToMediaType.substring(s);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                throw new IllegalArgumentException(sbAppend.append(strSubstring).append("\" for: \"").append($this$commonToMediaType).append('\"').toString().toString());
            }
            MatchGroup matchGroup = parameter.getGroups().get(1);
            String name = matchGroup != null ? matchGroup.getValue() : null;
            if (name == null) {
                s = parameter.getRange().getLast() + 1;
            } else {
                MatchGroup matchGroup2 = parameter.getGroups().get(2);
                String token = matchGroup2 != null ? matchGroup2.getValue() : null;
                if (token == null) {
                    MatchGroup matchGroup3 = parameter.getGroups().get(3);
                    Intrinsics.checkNotNull(matchGroup3);
                    value = matchGroup3.getValue();
                } else if (StringsKt.startsWith$default(token, "'", false, 2, (Object) null) && StringsKt.endsWith$default(token, "'", false, 2, (Object) null) && token.length() > 2) {
                    value = token.substring(1, token.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(value, "this as java.lang.String…ing(startIndex, endIndex)");
                } else {
                    value = token;
                }
                parameterNamesAndValues.add(name);
                parameterNamesAndValues.add(value);
                s = parameter.getRange().getLast() + 1;
            }
        }
        Collection $this$toTypedArray$iv = parameterNamesAndValues;
        Object[] array = $this$toTypedArray$iv.toArray(new String[0]);
        if (array != null) {
            return new MediaType($this$commonToMediaType, type, subtype, (String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final MediaType commonToMediaTypeOrNull(String $this$commonToMediaTypeOrNull) {
        Intrinsics.checkNotNullParameter($this$commonToMediaTypeOrNull, "<this>");
        try {
            return commonToMediaType($this$commonToMediaTypeOrNull);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
