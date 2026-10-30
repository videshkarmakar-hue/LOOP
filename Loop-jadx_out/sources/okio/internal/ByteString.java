package okio.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Base64;
import okio.Buffer;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: renamed from: okio.internal.-ByteString, reason: invalid class name */
/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0080\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0080\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0080\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0080\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\u0080\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\u0080\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0080\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, m195d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ByteString {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final String commonUtf8(okio.ByteString $this$commonUtf8) {
        Intrinsics.checkNotNullParameter($this$commonUtf8, "<this>");
        String result = $this$commonUtf8.getUtf8();
        if (result == null) {
            String result2 = _JvmPlatformKt.toUtf8String($this$commonUtf8.internalArray$okio());
            $this$commonUtf8.setUtf8$okio(result2);
            return result2;
        }
        return result;
    }

    public static final String commonBase64(okio.ByteString $this$commonBase64) {
        Intrinsics.checkNotNullParameter($this$commonBase64, "<this>");
        return Base64.encodeBase64$default($this$commonBase64.getData(), null, 1, null);
    }

    public static final String commonBase64Url(okio.ByteString $this$commonBase64Url) {
        Intrinsics.checkNotNullParameter($this$commonBase64Url, "<this>");
        return Base64.encodeBase64($this$commonBase64Url.getData(), Base64.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final String commonHex(okio.ByteString $this$commonHex) {
        Intrinsics.checkNotNullParameter($this$commonHex, "<this>");
        char[] result = new char[$this$commonHex.getData().length * 2];
        int c = 0;
        for (int b : $this$commonHex.getData()) {
            int c2 = c + 1;
            int other$iv = b >> 4;
            result[c] = getHEX_DIGIT_CHARS()[other$iv & 15];
            c = c2 + 1;
            int other$iv2 = 15 & b;
            result[c2] = getHEX_DIGIT_CHARS()[other$iv2];
        }
        return StringsKt.concatToString(result);
    }

    public static final okio.ByteString commonToAsciiLowercase(okio.ByteString $this$commonToAsciiLowercase) {
        Intrinsics.checkNotNullParameter($this$commonToAsciiLowercase, "<this>");
        for (int i = 0; i < $this$commonToAsciiLowercase.getData().length; i++) {
            byte c = $this$commonToAsciiLowercase.getData()[i];
            if (c >= 65 && c <= 90) {
                byte[] data = $this$commonToAsciiLowercase.getData();
                byte[] lowercase = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(lowercase, "copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c + 32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < 65 || c2 > 90) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 + 32);
                        i2++;
                    }
                }
                return new okio.ByteString(lowercase);
            }
        }
        return $this$commonToAsciiLowercase;
    }

    public static final okio.ByteString commonToAsciiUppercase(okio.ByteString $this$commonToAsciiUppercase) {
        Intrinsics.checkNotNullParameter($this$commonToAsciiUppercase, "<this>");
        for (int i = 0; i < $this$commonToAsciiUppercase.getData().length; i++) {
            byte c = $this$commonToAsciiUppercase.getData()[i];
            if (c >= 97 && c <= 122) {
                byte[] data = $this$commonToAsciiUppercase.getData();
                byte[] lowercase = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(lowercase, "copyOf(this, size)");
                int i2 = i + 1;
                lowercase[i] = (byte) (c - 32);
                while (i2 < lowercase.length) {
                    byte c2 = lowercase[i2];
                    if (c2 < 97 || c2 > 122) {
                        i2++;
                    } else {
                        lowercase[i2] = (byte) (c2 - 32);
                        i2++;
                    }
                }
                return new okio.ByteString(lowercase);
            }
        }
        return $this$commonToAsciiUppercase;
    }

    public static final okio.ByteString commonSubstring(okio.ByteString $this$commonSubstring, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$commonSubstring, "<this>");
        int endIndex2 = SegmentedByteString.resolveDefaultParameter($this$commonSubstring, endIndex);
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (!(endIndex2 <= $this$commonSubstring.getData().length)) {
            throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring.getData().length + ')').toString());
        }
        int subLen = endIndex2 - beginIndex;
        if (!(subLen >= 0)) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (beginIndex == 0 && endIndex2 == $this$commonSubstring.getData().length) {
            return $this$commonSubstring;
        }
        return new okio.ByteString(ArraysKt.copyOfRange($this$commonSubstring.getData(), beginIndex, endIndex2));
    }

    public static final byte commonGetByte(okio.ByteString $this$commonGetByte, int pos) {
        Intrinsics.checkNotNullParameter($this$commonGetByte, "<this>");
        return $this$commonGetByte.getData()[pos];
    }

    public static final int commonGetSize(okio.ByteString $this$commonGetSize) {
        Intrinsics.checkNotNullParameter($this$commonGetSize, "<this>");
        return $this$commonGetSize.getData().length;
    }

    public static final byte[] commonToByteArray(okio.ByteString $this$commonToByteArray) {
        Intrinsics.checkNotNullParameter($this$commonToByteArray, "<this>");
        byte[] data = $this$commonToByteArray.getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public static final byte[] commonInternalArray(okio.ByteString $this$commonInternalArray) {
        Intrinsics.checkNotNullParameter($this$commonInternalArray, "<this>");
        return $this$commonInternalArray.getData();
    }

    public static final boolean commonRangeEquals(okio.ByteString $this$commonRangeEquals, int offset, okio.ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(otherOffset, $this$commonRangeEquals.getData(), offset, byteCount);
    }

    public static final boolean commonRangeEquals(okio.ByteString $this$commonRangeEquals, int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= $this$commonRangeEquals.getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && SegmentedByteString.arrayRangeEquals($this$commonRangeEquals.getData(), offset, other, otherOffset, byteCount);
    }

    public static final void commonCopyInto(okio.ByteString $this$commonCopyInto, int offset, byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonCopyInto, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt.copyInto($this$commonCopyInto.getData(), target, targetOffset, offset, offset + byteCount);
    }

    public static final boolean commonStartsWith(okio.ByteString $this$commonStartsWith, okio.ByteString prefix) {
        Intrinsics.checkNotNullParameter($this$commonStartsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    public static final boolean commonStartsWith(okio.ByteString $this$commonStartsWith, byte[] prefix) {
        Intrinsics.checkNotNullParameter($this$commonStartsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return $this$commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }

    public static final boolean commonEndsWith(okio.ByteString $this$commonEndsWith, okio.ByteString suffix) {
        Intrinsics.checkNotNullParameter($this$commonEndsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEndsWith(okio.ByteString $this$commonEndsWith, byte[] suffix) {
        Intrinsics.checkNotNullParameter($this$commonEndsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return $this$commonEndsWith.rangeEquals($this$commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonIndexOf(okio.ByteString $this$commonIndexOf, byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int limit = $this$commonIndexOf.getData().length - other.length;
        int i = Math.max(fromIndex, 0);
        if (i <= limit) {
            while (!SegmentedByteString.arrayRangeEquals($this$commonIndexOf.getData(), i, other, 0, other.length)) {
                if (i == limit) {
                    return -1;
                }
                i++;
            }
            return i;
        }
        return -1;
    }

    public static final int commonLastIndexOf(okio.ByteString $this$commonLastIndexOf, okio.ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonLastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$commonLastIndexOf.lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    public static final int commonLastIndexOf(okio.ByteString $this$commonLastIndexOf, byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonLastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int fromIndex2 = SegmentedByteString.resolveDefaultParameter($this$commonLastIndexOf, fromIndex);
        int limit = $this$commonLastIndexOf.getData().length - other.length;
        for (int i = Math.min(fromIndex2, limit); -1 < i; i--) {
            if (SegmentedByteString.arrayRangeEquals($this$commonLastIndexOf.getData(), i, other, 0, other.length)) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean commonEquals(okio.ByteString $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        if (other == $this$commonEquals) {
            return true;
        }
        return (other instanceof okio.ByteString) && ((okio.ByteString) other).size() == $this$commonEquals.getData().length && ((okio.ByteString) other).rangeEquals(0, $this$commonEquals.getData(), 0, $this$commonEquals.getData().length);
    }

    public static final int commonHashCode(okio.ByteString $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        int result = $this$commonHashCode.getHashCode();
        if (result != 0) {
            return result;
        }
        int it = Arrays.hashCode($this$commonHashCode.getData());
        $this$commonHashCode.setHashCode$okio(it);
        return it;
    }

    public static final int commonCompareTo(okio.ByteString $this$commonCompareTo, okio.ByteString other) {
        Intrinsics.checkNotNullParameter($this$commonCompareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int sizeA = $this$commonCompareTo.size();
        int sizeB = other.size();
        int size = Math.min(sizeA, sizeB);
        for (int i = 0; i < size; i++) {
            int $this$and$iv = $this$commonCompareTo.getByte(i);
            int byteA = $this$and$iv & 255;
            byte $this$and$iv2 = other.getByte(i);
            int byteB = $this$and$iv2 & UByte.MAX_VALUE;
            if (byteA != byteB) {
                return byteA < byteB ? -1 : 1;
            }
        }
        if (sizeA == sizeB) {
            return 0;
        }
        return sizeA < sizeB ? -1 : 1;
    }

    public static final okio.ByteString commonOf(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return new okio.ByteString(bArrCopyOf);
    }

    public static final okio.ByteString commonToByteString(byte[] $this$commonToByteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonToByteString, "<this>");
        int byteCount2 = SegmentedByteString.resolveDefaultParameter($this$commonToByteString, byteCount);
        SegmentedByteString.checkOffsetAndCount($this$commonToByteString.length, offset, byteCount2);
        return new okio.ByteString(ArraysKt.copyOfRange($this$commonToByteString, offset, offset + byteCount2));
    }

    public static final okio.ByteString commonEncodeUtf8(String $this$commonEncodeUtf8) {
        Intrinsics.checkNotNullParameter($this$commonEncodeUtf8, "<this>");
        okio.ByteString byteString = new okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray($this$commonEncodeUtf8));
        byteString.setUtf8$okio($this$commonEncodeUtf8);
        return byteString;
    }

    public static final okio.ByteString commonDecodeBase64(String $this$commonDecodeBase64) {
        Intrinsics.checkNotNullParameter($this$commonDecodeBase64, "<this>");
        byte[] decoded = Base64.decodeBase64ToArray($this$commonDecodeBase64);
        if (decoded != null) {
            return new okio.ByteString(decoded);
        }
        return null;
    }

    public static final okio.ByteString commonDecodeHex(String $this$commonDecodeHex) {
        Intrinsics.checkNotNullParameter($this$commonDecodeHex, "<this>");
        if (!($this$commonDecodeHex.length() % 2 == 0)) {
            throw new IllegalArgumentException(("Unexpected hex string: " + $this$commonDecodeHex).toString());
        }
        byte[] result = new byte[$this$commonDecodeHex.length() / 2];
        int length = result.length;
        for (int i = 0; i < length; i++) {
            int d1 = decodeHexDigit($this$commonDecodeHex.charAt(i * 2)) << 4;
            int d2 = decodeHexDigit($this$commonDecodeHex.charAt((i * 2) + 1));
            result[i] = (byte) (d1 + d2);
        }
        return new okio.ByteString(result);
    }

    public static final void commonWrite(okio.ByteString $this$commonWrite, Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write($this$commonWrite.getData(), offset, byteCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return (c - 'a') + 10;
        }
        if ('A' <= c && c < 'G') {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final String commonToString(okio.ByteString $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        if ($this$commonToString.getData().length == 0) {
            return "[size=0]";
        }
        int i = codePointIndexToCharIndex($this$commonToString.getData(), 64);
        if (i == -1) {
            if ($this$commonToString.getData().length <= 64) {
                return "[hex=" + $this$commonToString.hex() + AbstractJsonLexerKt.END_LIST;
            }
            StringBuilder sbAppend = new StringBuilder().append("[size=").append($this$commonToString.getData().length).append(" hex=");
            okio.ByteString $this$commonSubstring$iv = $this$commonToString;
            int endIndex$iv = SegmentedByteString.resolveDefaultParameter($this$commonSubstring$iv, 64);
            if (!(endIndex$iv <= $this$commonSubstring$iv.getData().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring$iv.getData().length + ')').toString());
            }
            int subLen$iv = endIndex$iv - 0;
            if (!(subLen$iv >= 0)) {
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            if (endIndex$iv != $this$commonSubstring$iv.getData().length) {
                $this$commonSubstring$iv = new okio.ByteString(ArraysKt.copyOfRange($this$commonSubstring$iv.getData(), 0, endIndex$iv));
            }
            return sbAppend.append($this$commonSubstring$iv.hex()).append("…]").toString();
        }
        String text = $this$commonToString.utf8();
        String strSubstring = text.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String safeText = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), IOUtils.LINE_SEPARATOR_UNIX, "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (i < text.length()) {
            return "[size=" + $this$commonToString.getData().length + " text=" + safeText + "…]";
        }
        return "[text=" + safeText + AbstractJsonLexerKt.END_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:127:0x0156  */
    /* JADX WARN: Code duplicated, block: B:161:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:194:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:234:0x025f  */
    /* JADX WARN: Code duplicated, block: B:252:0x0290  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:280:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:317:0x0342  */
    /* JADX WARN: Code duplicated, block: B:352:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:391:0x0402  */
    /* JADX WARN: Code duplicated, block: B:423:0x0449  */
    /* JADX WARN: Code duplicated, block: B:462:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:488:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:489:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:517:0x0541  */
    /* JADX WARN: Code duplicated, block: B:554:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x0096  */
    /* JADX WARN: Code duplicated, block: B:592:0x060a  */
    /* JADX WARN: Code duplicated, block: B:626:0x0674  */
    /* JADX WARN: Code duplicated, block: B:665:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:699:0x071d  */
    /* JADX WARN: Code duplicated, block: B:731:0x0764  */
    /* JADX WARN: Code duplicated, block: B:764:0x07b2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00e7  */
    public static final int codePointIndexToCharIndex(byte[] s, int codePointCount) {
        int $i$f$isIsoControl;
        int $i$f$isIsoControl2;
        int j;
        boolean z;
        int j2;
        int $i$f$isIsoControl3;
        int j3;
        int $i$f$isIsoControl4;
        int charCount = 0;
        int j4 = 0;
        int beginIndex$iv = 0;
        int endIndex$iv = s.length;
        int index$iv = 0;
        while (index$iv < endIndex$iv) {
            byte b0$iv = s[index$iv];
            int i = 127;
            int i2 = 2;
            if (b0$iv >= 0) {
                int j5 = j4 + 1;
                if (j4 == codePointCount) {
                    return charCount;
                }
                if (b0$iv != 10 && b0$iv != 13) {
                    if (b0$iv >= 0 && b0$iv < 32) {
                        $i$f$isIsoControl2 = 1;
                    } else {
                        if (127 <= b0$iv && b0$iv < 160) {
                            $i$f$isIsoControl2 = 1;
                        } else {
                            $i$f$isIsoControl2 = 0;
                        }
                    }
                    if ($i$f$isIsoControl2 != 0) {
                        return -1;
                    }
                }
                if (b0$iv == 65533) {
                    return -1;
                }
                charCount += b0$iv < 65536 ? 1 : 2;
                index$iv++;
                j4 = j5;
                while (index$iv < endIndex$iv && s[index$iv] >= 0) {
                    int index$iv2 = index$iv + 1;
                    int c = s[index$iv];
                    int j6 = j4 + 1;
                    if (j4 == codePointCount) {
                        return charCount;
                    }
                    if (c != 10 && c != 13) {
                        if (c >= 0 && c < 32) {
                            $i$f$isIsoControl = 1;
                        } else {
                            if (i <= c && c < 160) {
                                $i$f$isIsoControl = 1;
                            } else {
                                $i$f$isIsoControl = 0;
                            }
                        }
                        if ($i$f$isIsoControl != 0) {
                            return -1;
                        }
                    }
                    if (c == 65533) {
                        return -1;
                    }
                    charCount += c < 65536 ? 1 : 2;
                    index$iv = index$iv2;
                    j4 = j6;
                    i = 127;
                }
            } else {
                int other$iv$iv = b0$iv >> 5;
                if (other$iv$iv == -2) {
                    if (endIndex$iv <= index$iv + 1) {
                        int j7 = j4 + 1;
                        if (j4 == codePointCount) {
                            return charCount;
                        }
                        if (65533 != 10 && 65533 != 13) {
                            if (!(65533 >= 0 && 65533 < 32)) {
                                z = 127 <= 65533 && 65533 < 160;
                            }
                            if (z) {
                                return -1;
                            }
                        }
                        if (65533 == 65533) {
                            return -1;
                        }
                        charCount += 65533 < 65536 ? 1 : 2;
                        Unit unit = Unit.INSTANCE;
                        j4 = j7;
                        i2 = 1;
                    } else {
                        byte b0$iv$iv = s[index$iv];
                        byte b1$iv$iv = s[index$iv + 1];
                        if ((b1$iv$iv & 192) == 128) {
                            int codePoint$iv$iv = (b1$iv$iv ^ ByteCompanionObject.MIN_VALUE) ^ (b0$iv$iv << 6);
                            if (codePoint$iv$iv < 128) {
                                j = j4 + 1;
                                if (j4 == codePointCount) {
                                    return charCount;
                                }
                                if (65533 != 10 && 65533 != 13) {
                                    int $i$f$isIsoControl5 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                    if ($i$f$isIsoControl5 == 0) {
                                        z = 127 <= 65533 && 65533 < 160;
                                    }
                                    if (z) {
                                        return -1;
                                    }
                                }
                                if (65533 == 65533) {
                                    return -1;
                                }
                                charCount += 65533 >= 65536 ? 2 : 1;
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                j = j4 + 1;
                                if (j4 == codePointCount) {
                                    return charCount;
                                }
                                if (codePoint$iv$iv != 10 && codePoint$iv$iv != 13) {
                                    int $i$f$isIsoControl6 = (codePoint$iv$iv < 0 || codePoint$iv$iv >= 32) ? 0 : 1;
                                    if ($i$f$isIsoControl6 == 0) {
                                        z = 127 <= codePoint$iv$iv && codePoint$iv$iv < 160;
                                    }
                                    if (z) {
                                        return -1;
                                    }
                                }
                                if (codePoint$iv$iv == 65533) {
                                    return -1;
                                }
                                charCount += codePoint$iv$iv >= 65536 ? 2 : 1;
                                Unit unit3 = Unit.INSTANCE;
                            }
                            j4 = j;
                        } else {
                            int j8 = j4 + 1;
                            if (j4 == codePointCount) {
                                return charCount;
                            }
                            if (65533 != 10 && 65533 != 13) {
                                int $i$f$isIsoControl7 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                if ($i$f$isIsoControl7 == 0) {
                                    z = 127 <= 65533 && 65533 < 160;
                                }
                                if (z) {
                                    return -1;
                                }
                            }
                            if (65533 == 65533) {
                                return -1;
                            }
                            charCount += 65533 < 65536 ? 1 : 2;
                            Unit unit4 = Unit.INSTANCE;
                            j4 = j8;
                            i2 = 1;
                        }
                    }
                    index$iv += i2;
                    beginIndex$iv = beginIndex$iv;
                } else {
                    int beginIndex$iv2 = beginIndex$iv;
                    int other$iv$iv2 = b0$iv >> 4;
                    if (other$iv$iv2 == -2) {
                        if (endIndex$iv <= index$iv + 2) {
                            int j9 = j4 + 1;
                            if (j4 == codePointCount) {
                                return charCount;
                            }
                            if (65533 != 10 && 65533 != 13) {
                                if (65533 >= 0 && 65533 < 32) {
                                    $i$f$isIsoControl3 = 1;
                                } else {
                                    if (127 <= 65533 && 65533 < 160) {
                                        $i$f$isIsoControl3 = 1;
                                    } else {
                                        $i$f$isIsoControl3 = 0;
                                    }
                                }
                                if ($i$f$isIsoControl3 != 0) {
                                    return -1;
                                }
                            }
                            if (65533 == 65533) {
                                return -1;
                            }
                            charCount += 65533 < 65536 ? 1 : 2;
                            Unit unit5 = Unit.INSTANCE;
                            if (endIndex$iv > index$iv + 1) {
                                int byte$iv$iv$iv = s[index$iv + 1];
                                int other$iv$iv$iv$iv = 192 & byte$iv$iv$iv;
                                if (other$iv$iv$iv$iv == 128) {
                                    j4 = j9;
                                } else {
                                    j4 = j9;
                                    i2 = 1;
                                }
                            } else {
                                j4 = j9;
                                i2 = 1;
                            }
                        } else {
                            byte b0$iv$iv2 = s[index$iv];
                            byte b1$iv$iv2 = s[index$iv + 1];
                            if ((b1$iv$iv2 & 192) == 128) {
                                int b2$iv$iv = s[index$iv + 2];
                                int other$iv$iv$iv$iv2 = b2$iv$iv & 192;
                                if (other$iv$iv$iv$iv2 == 128) {
                                    int codePoint$iv$iv2 = (((-123008) ^ b2$iv$iv) ^ (b1$iv$iv2 << 6)) ^ (b0$iv$iv2 << 12);
                                    if (codePoint$iv$iv2 < 2048) {
                                        j2 = j4 + 1;
                                        if (j4 == codePointCount) {
                                            return charCount;
                                        }
                                        if (65533 != 10 && 65533 != 13) {
                                            int $i$f$isIsoControl8 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                            if ($i$f$isIsoControl8 == 0) {
                                                z = 127 <= 65533 && 65533 < 160;
                                            }
                                            if (z) {
                                                return -1;
                                            }
                                        }
                                        if (65533 == 65533) {
                                            return -1;
                                        }
                                        charCount += 65533 < 65536 ? 1 : 2;
                                        Unit unit6 = Unit.INSTANCE;
                                    } else {
                                        if (55296 <= codePoint$iv$iv2 && codePoint$iv$iv2 < 57344) {
                                            j2 = j4 + 1;
                                            if (j4 == codePointCount) {
                                                return charCount;
                                            }
                                            if (65533 != 10 && 65533 != 13) {
                                                int $i$f$isIsoControl9 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                                if ($i$f$isIsoControl9 == 0) {
                                                    z = 127 <= 65533 && 65533 < 160;
                                                }
                                                if (z) {
                                                    return -1;
                                                }
                                            }
                                            if (65533 == 65533) {
                                                return -1;
                                            }
                                            charCount += 65533 < 65536 ? 1 : 2;
                                            Unit unit7 = Unit.INSTANCE;
                                        } else {
                                            j2 = j4 + 1;
                                            if (j4 == codePointCount) {
                                                return charCount;
                                            }
                                            if (codePoint$iv$iv2 != 10 && codePoint$iv$iv2 != 13) {
                                                int $i$f$isIsoControl10 = (codePoint$iv$iv2 < 0 || codePoint$iv$iv2 >= 32) ? 0 : 1;
                                                if ($i$f$isIsoControl10 == 0) {
                                                    z = 127 <= codePoint$iv$iv2 && codePoint$iv$iv2 < 160;
                                                }
                                                if (z) {
                                                    return -1;
                                                }
                                            }
                                            if (codePoint$iv$iv2 == 65533) {
                                                return -1;
                                            }
                                            charCount += codePoint$iv$iv2 < 65536 ? 1 : 2;
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    }
                                    j4 = j2;
                                    i2 = 3;
                                } else {
                                    int j10 = j4 + 1;
                                    if (j4 == codePointCount) {
                                        return charCount;
                                    }
                                    if (65533 != 10 && 65533 != 13) {
                                        int $i$f$isIsoControl11 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                        if ($i$f$isIsoControl11 == 0) {
                                            z = 127 <= 65533 && 65533 < 160;
                                        }
                                        if (z) {
                                            return -1;
                                        }
                                    }
                                    if (65533 == 65533) {
                                        return -1;
                                    }
                                    charCount += 65533 >= 65536 ? 2 : 1;
                                    Unit unit9 = Unit.INSTANCE;
                                    j4 = j10;
                                }
                            } else {
                                int j11 = j4 + 1;
                                if (j4 == codePointCount) {
                                    return charCount;
                                }
                                if (65533 != 10 && 65533 != 13) {
                                    int $i$f$isIsoControl12 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                    if ($i$f$isIsoControl12 == 0) {
                                        z = 127 <= 65533 && 65533 < 160;
                                    }
                                    if (z) {
                                        return -1;
                                    }
                                }
                                if (65533 == 65533) {
                                    return -1;
                                }
                                charCount += 65533 < 65536 ? 1 : 2;
                                Unit unit10 = Unit.INSTANCE;
                                j4 = j11;
                                i2 = 1;
                            }
                        }
                        index$iv += i2;
                        beginIndex$iv = beginIndex$iv2;
                    } else {
                        int other$iv$iv3 = b0$iv >> 3;
                        if (other$iv$iv3 == -2) {
                            if (endIndex$iv <= index$iv + 3) {
                                int j12 = j4 + 1;
                                if (j4 == codePointCount) {
                                    return charCount;
                                }
                                if (65533 != 10 && 65533 != 13) {
                                    if (65533 >= 0 && 65533 < 32) {
                                        $i$f$isIsoControl4 = 1;
                                    } else {
                                        if (127 <= 65533 && 65533 < 160) {
                                            $i$f$isIsoControl4 = 1;
                                        } else {
                                            $i$f$isIsoControl4 = 0;
                                        }
                                    }
                                    if ($i$f$isIsoControl4 != 0) {
                                        return -1;
                                    }
                                }
                                if (65533 == 65533) {
                                    return -1;
                                }
                                charCount += 65533 < 65536 ? 1 : 2;
                                Unit unit11 = Unit.INSTANCE;
                                if (endIndex$iv > index$iv + 1) {
                                    int byte$iv$iv$iv2 = s[index$iv + 1];
                                    int other$iv$iv$iv$iv3 = 192 & byte$iv$iv$iv2;
                                    byte byte$iv$iv$iv3 = other$iv$iv$iv$iv3 == 128 ? (byte) 1 : (byte) 0;
                                    if (byte$iv$iv$iv3 == 0) {
                                        j4 = j12;
                                        i2 = 1;
                                    } else if (endIndex$iv > index$iv + 2) {
                                        int byte$iv$iv$iv4 = s[index$iv + 2];
                                        int other$iv$iv$iv$iv4 = 192 & byte$iv$iv$iv4;
                                        if (other$iv$iv$iv$iv4 == 128) {
                                            j4 = j12;
                                            i2 = 3;
                                        } else {
                                            j4 = j12;
                                        }
                                    } else {
                                        j4 = j12;
                                    }
                                } else {
                                    j4 = j12;
                                    i2 = 1;
                                }
                            } else {
                                byte b0$iv$iv3 = s[index$iv];
                                int b1$iv$iv3 = s[index$iv + 1];
                                int other$iv$iv$iv$iv5 = 192 & b1$iv$iv3;
                                int $i$f$isUtf8Continuation = other$iv$iv$iv$iv5 == 128 ? 1 : 0;
                                if ($i$f$isUtf8Continuation == 0) {
                                    int j13 = j4 + 1;
                                    if (j4 == codePointCount) {
                                        return charCount;
                                    }
                                    if (65533 != 10 && 65533 != 13) {
                                        int $i$f$isIsoControl13 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                        if ($i$f$isIsoControl13 == 0) {
                                            z = 127 <= 65533 && 65533 < 160;
                                        }
                                        if (z) {
                                            return -1;
                                        }
                                    }
                                    if (65533 == 65533) {
                                        return -1;
                                    }
                                    charCount += 65533 < 65536 ? 1 : 2;
                                    Unit unit12 = Unit.INSTANCE;
                                    j4 = j13;
                                    i2 = 1;
                                } else {
                                    int b2$iv$iv2 = s[index$iv + 2];
                                    int other$iv$iv$iv$iv6 = 192 & b2$iv$iv2;
                                    int $i$f$isUtf8Continuation2 = other$iv$iv$iv$iv6 == 128 ? 1 : 0;
                                    if ($i$f$isUtf8Continuation2 == 0) {
                                        int j14 = j4 + 1;
                                        if (j4 == codePointCount) {
                                            return charCount;
                                        }
                                        if (65533 != 10 && 65533 != 13) {
                                            int $i$f$isIsoControl14 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                            if ($i$f$isIsoControl14 == 0) {
                                                z = 127 <= 65533 && 65533 < 160;
                                            }
                                            if (z) {
                                                return -1;
                                            }
                                        }
                                        if (65533 == 65533) {
                                            return -1;
                                        }
                                        charCount += 65533 >= 65536 ? 2 : 1;
                                        Unit unit13 = Unit.INSTANCE;
                                        j4 = j14;
                                    } else {
                                        int b3$iv$iv = s[index$iv + 3];
                                        int other$iv$iv$iv$iv7 = b3$iv$iv & 192;
                                        if (other$iv$iv$iv$iv7 == 128) {
                                            int codePoint$iv$iv3 = (((3678080 ^ b3$iv$iv) ^ (b2$iv$iv2 << 6)) ^ (b1$iv$iv3 << 12)) ^ (b0$iv$iv3 << 18);
                                            if (codePoint$iv$iv3 > 1114111) {
                                                j3 = j4 + 1;
                                                if (j4 == codePointCount) {
                                                    return charCount;
                                                }
                                                if (65533 != 10 && 65533 != 13) {
                                                    int $i$f$isIsoControl15 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                                    if ($i$f$isIsoControl15 == 0) {
                                                        z = 127 <= 65533 && 65533 < 160;
                                                    }
                                                    if (z) {
                                                        return -1;
                                                    }
                                                }
                                                if (65533 == 65533) {
                                                    return -1;
                                                }
                                                charCount += 65533 < 65536 ? 1 : 2;
                                                Unit unit14 = Unit.INSTANCE;
                                            } else {
                                                if (55296 <= codePoint$iv$iv3 && codePoint$iv$iv3 < 57344) {
                                                    j3 = j4 + 1;
                                                    if (j4 == codePointCount) {
                                                        return charCount;
                                                    }
                                                    if (65533 != 10 && 65533 != 13) {
                                                        int $i$f$isIsoControl16 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                                        if ($i$f$isIsoControl16 == 0) {
                                                            z = 127 <= 65533 && 65533 < 160;
                                                        }
                                                        if (z) {
                                                            return -1;
                                                        }
                                                    }
                                                    if (65533 == 65533) {
                                                        return -1;
                                                    }
                                                    charCount += 65533 < 65536 ? 1 : 2;
                                                    Unit unit15 = Unit.INSTANCE;
                                                } else if (codePoint$iv$iv3 < 65536) {
                                                    j3 = j4 + 1;
                                                    if (j4 == codePointCount) {
                                                        return charCount;
                                                    }
                                                    if (65533 != 10 && 65533 != 13) {
                                                        int $i$f$isIsoControl17 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                                        if ($i$f$isIsoControl17 == 0) {
                                                            z = 127 <= 65533 && 65533 < 160;
                                                        }
                                                        if (z) {
                                                            return -1;
                                                        }
                                                    }
                                                    if (65533 == 65533) {
                                                        return -1;
                                                    }
                                                    charCount += 65533 < 65536 ? 1 : 2;
                                                    Unit unit16 = Unit.INSTANCE;
                                                } else {
                                                    j3 = j4 + 1;
                                                    if (j4 == codePointCount) {
                                                        return charCount;
                                                    }
                                                    if (codePoint$iv$iv3 != 10 && codePoint$iv$iv3 != 13) {
                                                        int $i$f$isIsoControl18 = (codePoint$iv$iv3 < 0 || codePoint$iv$iv3 >= 32) ? 0 : 1;
                                                        if ($i$f$isIsoControl18 == 0) {
                                                            z = 127 <= codePoint$iv$iv3 && codePoint$iv$iv3 < 160;
                                                        }
                                                        if (z) {
                                                            return -1;
                                                        }
                                                    }
                                                    if (codePoint$iv$iv3 == 65533) {
                                                        return -1;
                                                    }
                                                    charCount += codePoint$iv$iv3 < 65536 ? 1 : 2;
                                                    Unit unit17 = Unit.INSTANCE;
                                                }
                                            }
                                            i2 = 4;
                                            j4 = j3;
                                        } else {
                                            int j15 = j4 + 1;
                                            if (j4 == codePointCount) {
                                                return charCount;
                                            }
                                            if (65533 != 10 && 65533 != 13) {
                                                int $i$f$isIsoControl19 = (65533 < 0 || 65533 >= 32) ? 0 : 1;
                                                if ($i$f$isIsoControl19 == 0) {
                                                    z = 127 <= 65533 && 65533 < 160;
                                                }
                                                if (z) {
                                                    return -1;
                                                }
                                            }
                                            if (65533 == 65533) {
                                                return -1;
                                            }
                                            charCount += 65533 < 65536 ? 1 : 2;
                                            Unit unit18 = Unit.INSTANCE;
                                            j4 = j15;
                                            i2 = 3;
                                        }
                                    }
                                }
                            }
                            index$iv += i2;
                            beginIndex$iv = beginIndex$iv2;
                        } else {
                            int j16 = j4 + 1;
                            if (j4 == codePointCount) {
                                return charCount;
                            }
                            if (65533 != 10 && 65533 != 13) {
                                if (!(65533 >= 0 && 65533 < 32)) {
                                    z = 127 <= 65533 && 65533 < 160;
                                }
                                if (z) {
                                    return -1;
                                }
                            }
                            if (65533 == 65533) {
                                return -1;
                            }
                            charCount += 65533 < 65536 ? 1 : 2;
                            index$iv++;
                            j4 = j16;
                            beginIndex$iv = beginIndex$iv2;
                        }
                    }
                }
            }
        }
        return charCount;
    }
}
