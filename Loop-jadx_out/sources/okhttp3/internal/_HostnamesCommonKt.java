package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.apache.commons.p013io.FilenameUtils;

/* JADX INFO: compiled from: -HostnamesCommon.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0000\u001a\"\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0005\u001a\f\u0010\u000f\u001a\u00020\u0003*\u00020\u0005H\u0000\u001a\f\u0010\u0010\u001a\u00020\u0003*\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m195d2 = {"VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "inet6AddressToAscii", "canParseAsIpAddress", "containsInvalidHostnameAsciiCodes", "containsInvalidLabelLengths", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _HostnamesCommonKt {
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String $this$canParseAsIpAddress) {
        Intrinsics.checkNotNullParameter($this$canParseAsIpAddress, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches($this$canParseAsIpAddress);
    }

    public static final boolean containsInvalidLabelLengths(String $this$containsInvalidLabelLengths) {
        Intrinsics.checkNotNullParameter($this$containsInvalidLabelLengths, "<this>");
        int length = $this$containsInvalidLabelLengths.length();
        if (!(1 <= length && length < 254)) {
            return true;
        }
        int labelStart = 0;
        while (true) {
            int dot = StringsKt.indexOf$default((CharSequence) $this$containsInvalidLabelLengths, FilenameUtils.EXTENSION_SEPARATOR, labelStart, false, 4, (Object) null);
            int labelLength = dot == -1 ? $this$containsInvalidLabelLengths.length() - labelStart : dot - labelStart;
            if (!(1 <= labelLength && labelLength < 64)) {
                return true;
            }
            if (dot == -1 || dot == $this$containsInvalidLabelLengths.length() - 1) {
                return false;
            }
            labelStart = dot + 1;
        }
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String $this$containsInvalidHostnameAsciiCodes) {
        Intrinsics.checkNotNullParameter($this$containsInvalidHostnameAsciiCodes, "<this>");
        int length = $this$containsInvalidHostnameAsciiCodes.length();
        for (int i = 0; i < length; i++) {
            char c = $this$containsInvalidHostnameAsciiCodes.charAt(i);
            if (Intrinsics.compare((int) c, 31) <= 0 || Intrinsics.compare((int) c, 127) >= 0 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", c, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c A[LOOP:1: B:29:0x0060->B:32:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0074 A[EDGE_INSN: B:54:0x0074->B:33:0x0074 BREAK  A[LOOP:1: B:29:0x0060->B:32:0x006c], SYNTHETIC] */
    public static final byte[] decodeIpv6(String input, int pos, int limit) {
        int value;
        int groupLength;
        int hexDigit;
        Intrinsics.checkNotNullParameter(input, "input");
        byte[] address = new byte[16];
        int b = 0;
        int compress = -1;
        int groupOffset = -1;
        int i = pos;
        while (i < limit) {
            if (b == address.length) {
                return null;
            }
            if (i + 2 <= limit && StringsKt.startsWith$default(input, "::", i, false, 4, (Object) null)) {
                if (compress != -1) {
                    return null;
                }
                i += 2;
                b += 2;
                compress = b;
                if (i == limit) {
                    break;
                }
                value = 0;
                groupOffset = i;
                while (i < limit) {
                    hexDigit = _UtilCommonKt.parseHexDigit(input.charAt(i));
                    if (hexDigit != -1) {
                        break;
                        break;
                    }
                    value = (value << 4) + hexDigit;
                    i++;
                }
                groupLength = i - groupOffset;
                if (groupLength != 0) {
                }
                return null;
            }
            if (b != 0) {
                if (StringsKt.startsWith$default(input, ":", i, false, 4, (Object) null)) {
                    i++;
                } else {
                    if (!StringsKt.startsWith$default(input, ".", i, false, 4, (Object) null) || !decodeIpv4Suffix(input, groupOffset, limit, address, b - 2)) {
                        return null;
                    }
                    b += 2;
                    break;
                }
            }
            value = 0;
            groupOffset = i;
            while (i < limit) {
                hexDigit = _UtilCommonKt.parseHexDigit(input.charAt(i));
                if (hexDigit != -1) {
                    break;
                }
                value = (value << 4) + hexDigit;
                i++;
            }
            groupLength = i - groupOffset;
            if (groupLength != 0 || groupLength > 4) {
                return null;
            }
            int b2 = b + 1;
            address[b] = (byte) ((value >>> 8) & 255);
            b = b2 + 1;
            address[b2] = (byte) (value & 255);
        }
        int value2 = address.length;
        if (b != value2) {
            if (compress == -1) {
                return null;
            }
            ArraysKt.copyInto(address, address, address.length - (b - compress), compress, b);
            ArraysKt.fill(address, (byte) 0, compress, (address.length - b) + compress);
        }
        return address;
    }

    public static final boolean decodeIpv4Suffix(String input, int pos, int limit, byte[] address, int addressOffset) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(address, "address");
        int b = addressOffset;
        int i = pos;
        while (i < limit) {
            if (b == address.length) {
                return false;
            }
            if (b != addressOffset) {
                if (input.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int value = 0;
            int groupOffset = i;
            while (i < limit) {
                char c = input.charAt(i);
                if (Intrinsics.compare((int) c, 48) < 0 || Intrinsics.compare((int) c, 57) > 0) {
                    break;
                }
                if ((value == 0 && groupOffset != i) || (value = ((value * 10) + c) - 48) > 255) {
                    return false;
                }
                i++;
            }
            int groupLength = i - groupOffset;
            if (groupLength == 0) {
                return false;
            }
            address[b] = (byte) value;
            b++;
        }
        return b == addressOffset + 4;
    }

    public static final String inet6AddressToAscii(byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        int longestRunOffset = -1;
        int longestRunLength = 0;
        int i = 0;
        while (i < address.length) {
            int currentRunOffset = i;
            while (i < 16 && address[i] == 0 && address[i + 1] == 0) {
                i += 2;
            }
            int currentRunLength = i - currentRunOffset;
            if (currentRunLength > longestRunLength && currentRunLength >= 4) {
                longestRunOffset = currentRunOffset;
                longestRunLength = currentRunLength;
            }
            i += 2;
        }
        Buffer result = new Buffer();
        int i2 = 0;
        while (i2 < address.length) {
            if (i2 == longestRunOffset) {
                result.writeByte(58);
                i2 += longestRunLength;
                if (i2 == 16) {
                    result.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    result.writeByte(58);
                }
                int group = (_UtilCommonKt.and(address[i2], 255) << 8) | _UtilCommonKt.and(address[i2 + 1], 255);
                result.writeHexadecimalUnsignedLong(group);
                i2 += 2;
            }
        }
        return result.readUtf8();
    }
}
