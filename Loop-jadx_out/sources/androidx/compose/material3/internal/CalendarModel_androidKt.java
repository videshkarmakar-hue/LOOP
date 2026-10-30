package androidx.compose.material3.internal;

import android.os.Build;
import android.text.format.DateFormat;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: CalendarModel.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0000\u001a8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bH\u0000¨\u0006\r"}, m195d2 = {"createCalendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/internal/CalendarLocale;", "formatWithSkeleton", "", "utcTimeMillis", "", "skeleton", "cache", "", "", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CalendarModel_androidKt {
    public static final CalendarModel createCalendarModel(Locale locale) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new CalendarModelImpl(locale);
        }
        return new LegacyCalendarModelImpl(locale);
    }

    public static final String formatWithSkeleton(long utcTimeMillis, String skeleton, Locale locale, Map<String, Object> map) {
        Object answer$iv;
        String str = "S:" + skeleton + locale.toLanguageTag();
        Object value$iv = map.get(str);
        if (value$iv == null) {
            answer$iv = DateFormat.getBestDateTimePattern(locale, skeleton);
            map.put(str, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        String pattern = answer$iv.toString();
        if (Build.VERSION.SDK_INT >= 26) {
            return CalendarModelImpl.INSTANCE.formatWithPattern(utcTimeMillis, pattern, locale, map);
        }
        return LegacyCalendarModelImpl.INSTANCE.formatWithPattern(utcTimeMillis, pattern, locale, map);
    }
}
