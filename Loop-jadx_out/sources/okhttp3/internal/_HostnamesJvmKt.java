package okhttp3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: -HostnamesJvm.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001¨\u0006\u0002"}, m195d2 = {"toCanonicalHost", "", "okhttp"}, m196k = 2, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _HostnamesJvmKt {
    public static final String toCanonicalHost(String $this$toCanonicalHost) {
        Intrinsics.checkNotNullParameter($this$toCanonicalHost, "<this>");
        if (StringsKt.contains$default((CharSequence) $this$toCanonicalHost, (CharSequence) ":", false, 2, (Object) null)) {
            byte[] inetAddressByteArray = (StringsKt.startsWith$default($this$toCanonicalHost, "[", false, 2, (Object) null) && StringsKt.endsWith$default($this$toCanonicalHost, "]", false, 2, (Object) null)) ? _HostnamesCommonKt.decodeIpv6($this$toCanonicalHost, 1, $this$toCanonicalHost.length() - 1) : _HostnamesCommonKt.decodeIpv6($this$toCanonicalHost, 0, $this$toCanonicalHost.length());
            if (inetAddressByteArray == null) {
                return null;
            }
            InetAddress inetAddress = InetAddress.getByAddress(inetAddressByteArray);
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                Intrinsics.checkNotNullExpressionValue(address, "address");
                return _HostnamesCommonKt.inet6AddressToAscii(address);
            }
            if (address.length == 4) {
                return inetAddress.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + $this$toCanonicalHost + '\'');
        }
        try {
            String ascii = IDN.toASCII($this$toCanonicalHost);
            Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String result = _UtilJvmKt.lowercase(ascii, US);
            if (result.length() == 0) {
                return null;
            }
            if (_HostnamesCommonKt.containsInvalidHostnameAsciiCodes(result)) {
                return null;
            }
            if (_HostnamesCommonKt.containsInvalidLabelLengths(result)) {
                return null;
            }
            return result;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
