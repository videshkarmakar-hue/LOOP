package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Headers;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: -HeadersCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001H\u0000¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0007*\u00020\u0011H\u0000\u001a\u0016\u0010\u0016\u001a\u00020\u0017*\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u0007H\u0000\u001a\u001e\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001f0\u001e*\u00020\u0007H\u0000\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0000\u001a\f\u0010\"\u001a\u00020\u0011*\u00020\u0007H\u0000\u001a\u0014\u0010#\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u001c\u0010$\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0018\u0010%\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010&H\u0000\u001a\f\u0010'\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\u0014\u0010(\u001a\u00020\u0001*\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0000\u001a\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010**\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006+"}, m195d2 = {"commonHeadersGet", "", "namesAndValues", "", "name", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "commonHeadersOf", "Lokhttp3/Headers;", "inputNamesAndValues", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersCheckName", "", "headersCheckValue", DownloadUtil.CookieScheme.VALUE, "charCode", "", "commonAdd", "Lokhttp3/Headers$Builder;", "commonAddAll", "headers", "commonAddLenient", "commonBuild", "commonEquals", "", "other", "", "commonGet", "commonHashCode", "", "commonIterator", "", "Lkotlin/Pair;", "commonName", "index", "commonNewBuilder", "commonRemoveAll", "commonSet", "commonToHeaders", "", "commonToString", "commonValue", "commonValues", "", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _HeadersCommonKt {
    public static final String commonName(Headers $this$commonName, int index) {
        Intrinsics.checkNotNullParameter($this$commonName, "<this>");
        String str = (String) ArraysKt.getOrNull($this$commonName.getNamesAndValues(), index * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + index + AbstractJsonLexerKt.END_LIST);
    }

    public static final String commonValue(Headers $this$commonValue, int index) {
        Intrinsics.checkNotNullParameter($this$commonValue, "<this>");
        String str = (String) ArraysKt.getOrNull($this$commonValue.getNamesAndValues(), (index * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + index + AbstractJsonLexerKt.END_LIST);
    }

    public static final List<String> commonValues(Headers $this$commonValues, String name) {
        Intrinsics.checkNotNullParameter($this$commonValues, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        List result = null;
        int size = $this$commonValues.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(name, $this$commonValues.name(i), true)) {
                if (result == null) {
                    List result2 = new ArrayList(2);
                    result = result2;
                }
                result.add($this$commonValues.value(i));
            }
        }
        List<String> list = result != null ? CollectionsKt.toList(result) : null;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final Iterator<Pair<String, String>> commonIterator(Headers $this$commonIterator) {
        Intrinsics.checkNotNullParameter($this$commonIterator, "<this>");
        int size = $this$commonIterator.size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.m202to($this$commonIterator.name(i), $this$commonIterator.value(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public static final Headers.Builder commonNewBuilder(Headers $this$commonNewBuilder) {
        Intrinsics.checkNotNullParameter($this$commonNewBuilder, "<this>");
        Headers.Builder result = new Headers.Builder();
        CollectionsKt.addAll(result.getNamesAndValues$okhttp(), $this$commonNewBuilder.getNamesAndValues());
        return result;
    }

    public static final boolean commonEquals(Headers $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        return (other instanceof Headers) && Arrays.equals($this$commonEquals.getNamesAndValues(), ((Headers) other).getNamesAndValues());
    }

    public static final int commonHashCode(Headers $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        return Arrays.hashCode($this$commonHashCode.getNamesAndValues());
    }

    public static final String commonToString(Headers $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        StringBuilder $this$commonToString_u24lambda_u2d0 = new StringBuilder();
        int size = $this$commonToString.size();
        for (int i = 0; i < size; i++) {
            String name = $this$commonToString.name(i);
            String value = $this$commonToString.value(i);
            $this$commonToString_u24lambda_u2d0.append(name);
            $this$commonToString_u24lambda_u2d0.append(": ");
            $this$commonToString_u24lambda_u2d0.append(_UtilCommonKt.isSensitiveHeader(name) ? "██" : value);
            $this$commonToString_u24lambda_u2d0.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        String string = $this$commonToString_u24lambda_u2d0.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String commonHeadersGet(String[] namesAndValues, String name) {
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = namesAndValues.length - 2;
        int i = length;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement <= i) {
            while (!StringsKt.equals(name, namesAndValues[i], true)) {
                if (i == progressionLastElement) {
                    return null;
                }
                i -= 2;
            }
            return namesAndValues[i + 1];
        }
        return null;
    }

    public static final Headers.Builder commonAdd(Headers.Builder $this$commonAdd, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonAdd, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        commonAddLenient($this$commonAdd, name, value);
        return $this$commonAdd;
    }

    public static final Headers.Builder commonAddAll(Headers.Builder $this$commonAddAll, Headers headers) {
        Intrinsics.checkNotNullParameter($this$commonAddAll, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            commonAddLenient($this$commonAddAll, headers.name(i), headers.value(i));
        }
        return $this$commonAddAll;
    }

    public static final Headers.Builder commonAddLenient(Headers.Builder $this$commonAddLenient, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonAddLenient, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$commonAddLenient.getNamesAndValues$okhttp().add(name);
        $this$commonAddLenient.getNamesAndValues$okhttp().add(StringsKt.trim((CharSequence) value).toString());
        return $this$commonAddLenient;
    }

    public static final Headers.Builder commonRemoveAll(Headers.Builder $this$commonRemoveAll, String name) {
        Intrinsics.checkNotNullParameter($this$commonRemoveAll, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        while (i < $this$commonRemoveAll.getNamesAndValues$okhttp().size()) {
            if (StringsKt.equals(name, $this$commonRemoveAll.getNamesAndValues$okhttp().get(i), true)) {
                $this$commonRemoveAll.getNamesAndValues$okhttp().remove(i);
                $this$commonRemoveAll.getNamesAndValues$okhttp().remove(i);
                i -= 2;
            }
            i += 2;
        }
        return $this$commonRemoveAll;
    }

    public static final Headers.Builder commonSet(Headers.Builder $this$commonSet, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonSet, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        $this$commonSet.removeAll(name);
        commonAddLenient($this$commonSet, name, value);
        return $this$commonSet;
    }

    public static final String commonGet(Headers.Builder $this$commonGet, String name) {
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int size = $this$commonGet.getNamesAndValues$okhttp().size() - 2;
        int i = size;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
        if (progressionLastElement <= i) {
            while (!StringsKt.equals(name, $this$commonGet.getNamesAndValues$okhttp().get(i), true)) {
                if (i == progressionLastElement) {
                    return null;
                }
                i -= 2;
            }
            return $this$commonGet.getNamesAndValues$okhttp().get(i + 1);
        }
        return null;
    }

    public static final Headers commonBuild(Headers.Builder $this$commonBuild) {
        Intrinsics.checkNotNullParameter($this$commonBuild, "<this>");
        Collection $this$toTypedArray$iv = $this$commonBuild.getNamesAndValues$okhttp();
        Object[] array = $this$toTypedArray$iv.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final void headersCheckName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(name.length() > 0)) {
            throw new IllegalArgumentException("name is empty".toString());
        }
        int length = name.length();
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            if (!('!' <= c && c < 127)) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(c) + " at " + i + " in header name: " + name).toString());
            }
        }
    }

    public static final void headersCheckValue(String value, String name) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            boolean z = true;
            if (c != '\t') {
                if (!(' ' <= c && c < 127)) {
                    z = false;
                }
            }
            if (!z) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(c) + " at " + i + " in " + name + " value" + (_UtilCommonKt.isSensitiveHeader(name) ? "" : ": " + value)).toString());
            }
        }
    }

    private static final String charCode(char $this$charCode) {
        String it = Integer.toString($this$charCode, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(it, "toString(this, checkRadix(radix))");
        if (it.length() < 2) {
            return '0' + it;
        }
        return it;
    }

    public static final Headers commonHeadersOf(String... inputNamesAndValues) {
        Intrinsics.checkNotNullParameter(inputNamesAndValues, "inputNamesAndValues");
        if (!(inputNamesAndValues.length % 2 == 0)) {
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
        String[] namesAndValues = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
        int length = namesAndValues.length;
        for (int i = 0; i < length; i++) {
            if (!(namesAndValues[i] != null)) {
                throw new IllegalArgumentException("Headers cannot be null".toString());
            }
            namesAndValues[i] = StringsKt.trim((CharSequence) inputNamesAndValues[i]).toString();
        }
        int i2 = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, namesAndValues.length - 1, 2);
        if (0 <= progressionLastElement) {
            while (true) {
                String name = namesAndValues[i2];
                String value = namesAndValues[i2 + 1];
                headersCheckName(name);
                headersCheckValue(value, name);
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 2;
            }
        }
        return new Headers(namesAndValues);
    }

    public static final Headers commonToHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String[] namesAndValues = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            String name = StringsKt.trim((CharSequence) k).toString();
            String value = StringsKt.trim((CharSequence) v).toString();
            headersCheckName(name);
            headersCheckValue(value, name);
            namesAndValues[i] = name;
            namesAndValues[i + 1] = value;
            i += 2;
        }
        return new Headers(namesAndValues);
    }
}
