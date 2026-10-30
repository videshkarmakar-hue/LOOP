package androidx.compose.material3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import org.apache.commons.p013io.FilenameUtils;

/* JADX INFO: compiled from: CalendarLocale.jvm.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002\u001a*\u0010\n\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\n\u0010\u000b\"\u00020\f2\u00020\f¨\u0006\r"}, m195d2 = {"cachedFormatters", "Ljava/util/WeakHashMap;", "", "Ljava/text/NumberFormat;", "getCachedDateTimeFormatter", "minDigits", "", "maxDigits", "isGroupingUsed", "", "toLocalString", "CalendarLocale", "Ljava/util/Locale;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CalendarLocale_jvmKt {
    private static final WeakHashMap<String, NumberFormat> cachedFormatters = new WeakHashMap<>();

    public static /* synthetic */ String toLocalString$default(int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 1;
        }
        if ((i4 & 2) != 0) {
            i3 = 40;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return toLocalString(i, i2, i3, z);
    }

    public static final String toLocalString(int $this$toLocalString, int minDigits, int maxDigits, boolean isGroupingUsed) {
        return getCachedDateTimeFormatter(minDigits, maxDigits, isGroupingUsed).format(Integer.valueOf($this$toLocalString));
    }

    private static final NumberFormat getCachedDateTimeFormatter(int minDigits, int maxDigits, boolean isGroupingUsed) {
        NumberFormat numberFormat;
        String key = minDigits + FilenameUtils.EXTENSION_SEPARATOR + maxDigits + FilenameUtils.EXTENSION_SEPARATOR + isGroupingUsed + FilenameUtils.EXTENSION_SEPARATOR + Locale.getDefault().toLanguageTag();
        Map $this$getOrPut$iv = cachedFormatters;
        NumberFormat numberFormat2 = $this$getOrPut$iv.get(key);
        if (numberFormat2 == null) {
            NumberFormat $this$getCachedDateTimeFormatter_u24lambda_u241_u24lambda_u240 = NumberFormat.getIntegerInstance();
            $this$getCachedDateTimeFormatter_u24lambda_u241_u24lambda_u240.setGroupingUsed(isGroupingUsed);
            $this$getCachedDateTimeFormatter_u24lambda_u241_u24lambda_u240.setMinimumIntegerDigits(minDigits);
            $this$getCachedDateTimeFormatter_u24lambda_u241_u24lambda_u240.setMaximumIntegerDigits(maxDigits);
            numberFormat = $this$getCachedDateTimeFormatter_u24lambda_u241_u24lambda_u240;
            $this$getOrPut$iv.put(key, numberFormat);
        } else {
            numberFormat = numberFormat2;
        }
        return numberFormat;
    }
}
