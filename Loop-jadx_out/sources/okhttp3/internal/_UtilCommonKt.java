package okhttp3.internal;

import androidx.compose.p001ui.geometry.InlineClassHelperKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Options;
import okio.Path;

/* JADX INFO: compiled from: -UtilCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000æ\u0001\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001c\"\u0004\b\u0000\u0010\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001d0 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000\u001a \u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0000\u001a\u001a\u0010(\u001a\u00020!2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020!0*H\u0080\bø\u0001\u0000\u001a0\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0\u001c\"\u0004\b\u0000\u0010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H,0.H\u0000\u001a\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0013H\u0000\u001a%\u00103\u001a\u00020!\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0 2\u0006\u00104\u001a\u0002H\u001dH\u0000¢\u0006\u0002\u00105\u001a\u0015\u00106\u001a\u00020\u0015*\u0002072\u0006\u00108\u001a\u00020\u0015H\u0080\u0004\u001a\u0015\u00106\u001a\u00020%*\u00020\u00152\u0006\u00108\u001a\u00020%H\u0080\u0004\u001a\u0015\u00106\u001a\u00020\u0015*\u0002092\u0006\u00108\u001a\u00020\u0015H\u0080\u0004\u001a\u000e\u0010:\u001a\u00020!*\u00060;j\u0002`<\u001a%\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130>*\b\u0012\u0004\u0012\u00020\u00130>2\u0006\u0010?\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0010@\u001a\u0014\u0010A\u001a\u00020!*\u00020B2\u0006\u0010C\u001a\u00020DH\u0000\u001a\u0014\u0010E\u001a\u00020!*\u00020B2\u0006\u0010F\u001a\u00020DH\u0000\u001a&\u0010G\u001a\u00020\u0015*\u00020\u00132\u0006\u0010H\u001a\u00020\u00162\b\b\u0002\u0010I\u001a\u00020\u00152\b\b\u0002\u0010J\u001a\u00020\u0015\u001a&\u0010G\u001a\u00020\u0015*\u00020\u00132\u0006\u0010K\u001a\u00020\u00132\b\b\u0002\u0010I\u001a\u00020\u00152\b\b\u0002\u0010J\u001a\u00020\u0015\u001a;\u0010L\u001a\b\u0012\u0004\u0012\u0002H,0\u001c\"\u0004\b\u0000\u0010,*\b\u0012\u0004\u0012\u0002H,0.2\u0017\u0010M\u001a\u0013\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002010\u001f¢\u0006\u0002\b\"H\u0080\bø\u0001\u0000\u001aC\u0010N\u001a\u000201*\b\u0012\u0004\u0012\u00020\u00130>2\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010>2\u001a\u0010P\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00130Qj\n\u0012\u0006\b\u0000\u0012\u00020\u0013`RH\u0000¢\u0006\u0002\u0010S\u001a7\u0010T\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00130>2\u0006\u0010?\u001a\u00020\u00132\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020\u00130Qj\b\u0012\u0004\u0012\u00020\u0013`RH\u0000¢\u0006\u0002\u0010U\u001a\f\u0010V\u001a\u00020\u0015*\u00020\u0013H\u0000\u001a \u0010W\u001a\u00020\u0015*\u00020\u00132\b\b\u0002\u0010I\u001a\u00020\u00152\b\b\u0002\u0010J\u001a\u00020\u0015H\u0000\u001a \u0010X\u001a\u00020\u0015*\u00020\u00132\b\b\u0002\u0010I\u001a\u00020\u00152\b\b\u0002\u0010J\u001a\u00020\u0015H\u0000\u001a\u0016\u0010Y\u001a\u00020\u0015*\u00020\u00132\b\b\u0002\u0010I\u001a\u00020\u0015H\u0000\u001aG\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00130>*\b\u0012\u0004\u0012\u00020\u00130>2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130>2\u001a\u0010P\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00130Qj\n\u0012\u0006\b\u0000\u0012\u00020\u0013`RH\u0000¢\u0006\u0002\u0010[\u001a\u0014\u0010\\\u001a\u000201*\u00020B2\u0006\u0010]\u001a\u00020DH\u0000\u001a\u001e\u0010^\u001a\u0004\u0018\u00010_*\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u0015H\u0000\u001a\f\u0010d\u001a\u00020\u0015*\u00020\u0016H\u0000\u001a\f\u0010e\u001a\u00020\u0015*\u00020fH\u0000\u001a\u0014\u0010g\u001a\u00020\u0015*\u00020h2\u0006\u0010/\u001a\u000207H\u0000\u001a\u0012\u0010i\u001a\u00020%*\u00020\u00132\u0006\u0010j\u001a\u00020%\u001a\u0016\u0010k\u001a\u00020\u0015*\u0004\u0018\u00010\u00132\u0006\u0010j\u001a\u00020\u0015H\u0000\u001a\u001e\u0010l\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010I\u001a\u00020\u00152\b\b\u0002\u0010J\u001a\u00020\u0015\u001a\"\u0010m\u001a\u00020n*\u00060oj\u0002`p2\u0010\u0010q\u001a\f\u0012\b\u0012\u00060oj\u0002`p0\u001cH\u0000\u001a\u0014\u0010r\u001a\u00020!*\u00020s2\u0006\u0010t\u001a\u00020\u0015H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00168Æ\u0002¢\u0006\f\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006u"}, m195d2 = {"EMPTY_BYTE_ARRAY", "", "UNICODE_BOMS", "Lokio/Options;", "getUNICODE_BOMS", "()Lokio/Options;", "commonEmptyHeaders", "Lokhttp3/Headers;", "getCommonEmptyHeaders", "()Lokhttp3/Headers;", "commonEmptyRequestBody", "Lokhttp3/RequestBody;", "getCommonEmptyRequestBody", "()Lokhttp3/RequestBody;", "commonEmptyResponse", "Lokhttp3/ResponseBody;", "getCommonEmptyResponse", "()Lokhttp3/ResponseBody;", "userAgent", "", "code", "", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "buildList", "", ExifInterface.LONGITUDE_EAST, "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "checkOffsetAndCount", "arrayLength", "", "offset", "count", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "interleave", ExifInterface.GPS_DIRECTION_TRUE, "a", "", "b", "isSensitiveHeader", "", "name", "addIfAbsent", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "closeQuietly", "Ljava/io/Closeable;", "Lokio/Closeable;", "concat", "", DownloadUtil.CookieScheme.VALUE, "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "deleteContents", "Lokio/FileSystem;", "directory", "Lokio/Path;", "deleteIfExists", DownloadUtil.CookieScheme.PATH, "delimiterOffset", "delimiter", "startIndex", "endIndex", "delimiters", "filterList", "predicate", "hasIntersection", "other", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "file", "matchAtPolyfill", "Lkotlin/text/MatchResult;", "Lkotlin/text/Regex;", "input", "", "index", "parseHexDigit", "readMedium", "Lokio/BufferedSource;", "skipAll", "Lokio/Buffer;", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final Options UNICODE_BOMS = Options.INSTANCE.m247of(ByteString.INSTANCE.decodeHex("efbbbf"), ByteString.INSTANCE.decodeHex("feff"), ByteString.INSTANCE.decodeHex("fffe"), ByteString.INSTANCE.decodeHex("0000ffff"), ByteString.INSTANCE.decodeHex("ffff0000"));
    private static final Headers commonEmptyHeaders = Headers.INSTANCE.m239of(new String[0]);
    private static final RequestBody commonEmptyRequestBody = RequestBody.Companion.create$default(RequestBody.INSTANCE, EMPTY_BYTE_ARRAY, (MediaType) null, 0, 0, 7, (Object) null);
    private static final ResponseBody commonEmptyResponse = ResponseBody.Companion.create$default(ResponseBody.INSTANCE, EMPTY_BYTE_ARRAY, (MediaType) null, 1, (Object) null);
    public static final String userAgent = "okhttp/5.0.0-alpha.10";

    public static /* synthetic */ void getCode$annotations(char c) {
    }

    public static final MatchResult matchAtPolyfill(Regex $this$matchAtPolyfill, CharSequence input, int index) {
        Intrinsics.checkNotNullParameter($this$matchAtPolyfill, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        MatchResult candidate = $this$matchAtPolyfill.find(input, index);
        if (candidate != null && candidate.getRange().getFirst() == index) {
            return candidate;
        }
        return null;
    }

    public static final Options getUNICODE_BOMS() {
        return UNICODE_BOMS;
    }

    public static final String[] intersect(String[] $this$intersect, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter($this$intersect, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        List result = new ArrayList();
        for (String a : $this$intersect) {
            for (String b : other) {
                if (comparator.compare(a, b) == 0) {
                    result.add(a);
                    break;
                }
            }
        }
        List $this$toTypedArray$iv = result;
        Object[] array = $this$toTypedArray$iv.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean hasIntersection(String[] $this$hasIntersection, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter($this$hasIntersection, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!($this$hasIntersection.length == 0) && other != null) {
            if (!(other.length == 0)) {
                for (String a : $this$hasIntersection) {
                    Iterator it = ArrayIteratorKt.iterator(other);
                    while (it.hasNext()) {
                        String b = (String) it.next();
                        if (comparator.compare(a, b) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static final int indexOf(String[] $this$indexOf, String value, Comparator<String> comparator) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = $this$indexOf.length;
        for (int index$iv = 0; index$iv < length; index$iv++) {
            String it = $this$indexOf[index$iv];
            if (comparator.compare(it, value) == 0) {
                return index$iv;
            }
        }
        return -1;
    }

    public static final String[] concat(String[] $this$concat, String value) {
        Intrinsics.checkNotNullParameter($this$concat, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf($this$concat, $this$concat.length + 1);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        String[] result = (String[]) objArrCopyOf;
        result[ArraysKt.getLastIndex(result)] = value;
        return result;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfFirstNonAsciiWhitespace(String $this$indexOfFirstNonAsciiWhitespace, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfFirstNonAsciiWhitespace, "<this>");
        for (int i = startIndex; i < endIndex; i++) {
            char cCharAt = $this$indexOfFirstNonAsciiWhitespace.charAt(i);
            if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                return i;
            }
        }
        return endIndex;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String $this$indexOfLastNonAsciiWhitespace, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfLastNonAsciiWhitespace, "<this>");
        int i = endIndex - 1;
        if (startIndex <= i) {
            while (true) {
                char cCharAt = $this$indexOfLastNonAsciiWhitespace.charAt(i);
                if ((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ') {
                    if (i != startIndex) {
                        i--;
                    }
                } else {
                    return i + 1;
                }
            }
        }
        return startIndex;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final String trimSubstring(String $this$trimSubstring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$trimSubstring, "<this>");
        int start = indexOfFirstNonAsciiWhitespace($this$trimSubstring, startIndex, endIndex);
        int end = indexOfLastNonAsciiWhitespace($this$trimSubstring, start, endIndex);
        String strSubstring = $this$trimSubstring.substring(start, end);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final int delimiterOffset(String $this$delimiterOffset, String delimiters, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$delimiterOffset, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        for (int i = startIndex; i < endIndex; i++) {
            if (StringsKt.contains$default((CharSequence) delimiters, $this$delimiterOffset.charAt(i), false, 2, (Object) null)) {
                return i;
            }
        }
        return endIndex;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final int delimiterOffset(String $this$delimiterOffset, char delimiter, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$delimiterOffset, "<this>");
        for (int i = startIndex; i < endIndex; i++) {
            if ($this$delimiterOffset.charAt(i) == delimiter) {
                return i;
            }
        }
        return endIndex;
    }

    public static final int indexOfControlOrNonAscii(String $this$indexOfControlOrNonAscii) {
        Intrinsics.checkNotNullParameter($this$indexOfControlOrNonAscii, "<this>");
        int length = $this$indexOfControlOrNonAscii.length();
        for (int i = 0; i < length; i++) {
            char c = $this$indexOfControlOrNonAscii.charAt(i);
            if (Intrinsics.compare((int) c, 31) <= 0 || Intrinsics.compare((int) c, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean isSensitiveHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.equals(name, "Authorization", true) || StringsKt.equals(name, "Cookie", true) || StringsKt.equals(name, "Proxy-Authorization", true) || StringsKt.equals(name, "Set-Cookie", true);
    }

    public static final int parseHexDigit(char $this$parseHexDigit) {
        if ('0' <= $this$parseHexDigit && $this$parseHexDigit < ':') {
            return $this$parseHexDigit - '0';
        }
        if ('a' <= $this$parseHexDigit && $this$parseHexDigit < 'g') {
            return ($this$parseHexDigit - 'a') + 10;
        }
        if ('A' <= $this$parseHexDigit && $this$parseHexDigit < 'G') {
            return ($this$parseHexDigit - 'A') + 10;
        }
        return -1;
    }

    public static final int and(byte $this$and, int mask) {
        return $this$and & mask;
    }

    public static final int and(short $this$and, int mask) {
        return $this$and & mask;
    }

    public static final long and(int $this$and, long mask) {
        return ((long) $this$and) & mask;
    }

    public static final void writeMedium(BufferedSink $this$writeMedium, int medium) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeMedium, "<this>");
        $this$writeMedium.writeByte((medium >>> 16) & 255);
        $this$writeMedium.writeByte((medium >>> 8) & 255);
        $this$writeMedium.writeByte(medium & 255);
    }

    public static final int readMedium(BufferedSource $this$readMedium) throws IOException {
        Intrinsics.checkNotNullParameter($this$readMedium, "<this>");
        return (and($this$readMedium.readByte(), 255) << 16) | (and($this$readMedium.readByte(), 255) << 8) | and($this$readMedium.readByte(), 255);
    }

    public static final void ignoreIoExceptions(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke();
        } catch (IOException e) {
        }
    }

    public static final int skipAll(Buffer $this$skipAll, byte b) throws EOFException {
        Intrinsics.checkNotNullParameter($this$skipAll, "<this>");
        int count = 0;
        while (!$this$skipAll.exhausted() && $this$skipAll.getByte(0L) == b) {
            count++;
            $this$skipAll.readByte();
        }
        return count;
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    public static final int indexOfNonWhitespace(String $this$indexOfNonWhitespace, int startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfNonWhitespace, "<this>");
        int length = $this$indexOfNonWhitespace.length();
        for (int i = startIndex; i < length; i++) {
            char c = $this$indexOfNonWhitespace.charAt(i);
            if (c != ' ' && c != '\t') {
                return i;
            }
        }
        int i2 = $this$indexOfNonWhitespace.length();
        return i2;
    }

    public static final long toLongOrDefault(String $this$toLongOrDefault, long defaultValue) {
        Intrinsics.checkNotNullParameter($this$toLongOrDefault, "<this>");
        try {
            return Long.parseLong($this$toLongOrDefault);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static final int toNonNegativeInt(String $this$toNonNegativeInt, int defaultValue) {
        if ($this$toNonNegativeInt == null) {
            return defaultValue;
        }
        try {
            long value = Long.parseLong($this$toNonNegativeInt);
            if (value > InlineClassHelperKt.FloatNonFiniteMask) {
                return Integer.MAX_VALUE;
            }
            if (value < 0) {
                return 0;
            }
            return (int) value;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static final void closeQuietly(Closeable $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (RuntimeException rethrown) {
            throw rethrown;
        } catch (Exception e) {
        }
    }

    public static final boolean isCivilized(FileSystem $this$isCivilized, Path file) throws Throwable {
        Intrinsics.checkNotNullParameter($this$isCivilized, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        Closeable $this$use$iv = $this$isCivilized.sink(file);
        Object result$iv = null;
        Throwable thrown$iv = null;
        try {
            try {
                $this$isCivilized.delete(file);
                return true;
            } catch (IOException e) {
                result$iv = Unit.INSTANCE;
                if ($this$use$iv != null) {
                    try {
                        $this$use$iv.close();
                    } catch (Throwable t$iv) {
                        if (thrown$iv == null) {
                            thrown$iv = t$iv;
                        } else {
                            ExceptionsKt.addSuppressed(thrown$iv, t$iv);
                        }
                    }
                }
                if (thrown$iv != null) {
                    throw thrown$iv;
                }
                Intrinsics.checkNotNull(result$iv);
                $this$isCivilized.delete(file);
                return false;
            }
        } catch (Throwable t$iv2) {
            thrown$iv = t$iv2;
        }
    }

    public static final void deleteIfExists(FileSystem $this$deleteIfExists, Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteIfExists, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            $this$deleteIfExists.delete(path);
        } catch (FileNotFoundException e) {
        }
    }

    public static final void deleteContents(FileSystem $this$deleteContents, Path directory) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteContents, "<this>");
        Intrinsics.checkNotNullParameter(directory, "directory");
        IOException exception = null;
        try {
            for (Path file : $this$deleteContents.list(directory)) {
                try {
                    if ($this$deleteContents.metadata(file).getIsDirectory()) {
                        deleteContents($this$deleteContents, file);
                    }
                    $this$deleteContents.delete(file);
                } catch (IOException ioe) {
                    if (exception == null) {
                        exception = ioe;
                    }
                }
            }
            if (exception != null) {
                throw exception;
            }
        } catch (FileNotFoundException e) {
        }
    }

    public static final <E> void addIfAbsent(List<E> list, E e) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.contains(e)) {
            list.add(e);
        }
    }

    public static final Throwable withSuppressed(Exception $this$withSuppressed, List<? extends Exception> suppressed) {
        Intrinsics.checkNotNullParameter($this$withSuppressed, "<this>");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        for (Exception e : suppressed) {
            ExceptionsKt.addSuppressed($this$withSuppressed, e);
        }
        return $this$withSuppressed;
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List listEmptyList = CollectionsKt.emptyList();
        for (Object i : iterable) {
            if (predicate.invoke(i).booleanValue()) {
                if (listEmptyList.isEmpty()) {
                    List result = new ArrayList();
                    listEmptyList = result;
                }
                TypeIntrinsics.asMutableList(listEmptyList).add(i);
            }
        }
        return listEmptyList;
    }

    public static final void checkOffsetAndCount(long arrayLength, long offset, long count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException("length=" + arrayLength + ", offset=" + offset + ", count=" + offset);
        }
    }

    public static final Headers getCommonEmptyHeaders() {
        return commonEmptyHeaders;
    }

    public static final RequestBody getCommonEmptyRequestBody() {
        return commonEmptyRequestBody;
    }

    public static final ResponseBody getCommonEmptyResponse() {
        return commonEmptyResponse;
    }

    public static final <T> List<T> interleave(Iterable<? extends T> a, Iterable<? extends T> b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Iterator<? extends T> it = a.iterator();
        Iterator<? extends T> it2 = b.iterator();
        List $this$buildList_u24lambda_u2d4$iv = new ArrayList();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return $this$buildList_u24lambda_u2d4$iv;
            }
            if (it.hasNext()) {
                $this$buildList_u24lambda_u2d4$iv.add(it.next());
            }
            if (it2.hasNext()) {
                $this$buildList_u24lambda_u2d4$iv.add(it2.next());
            }
        }
    }

    public static final int getCode(char $this$code) {
        return $this$code;
    }

    public static final <E> List<E> buildList(Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List $this$buildList_u24lambda_u2d4 = new ArrayList();
        builderAction.invoke($this$buildList_u24lambda_u2d4);
        return $this$buildList_u24lambda_u2d4;
    }
}
