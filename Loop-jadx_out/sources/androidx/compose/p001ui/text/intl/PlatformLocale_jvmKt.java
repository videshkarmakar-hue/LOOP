package androidx.compose.p001ui.text.intl;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlatformLocale.jvm.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\n\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u001c\u0010\b\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005*\n\u0010\u000b\"\u00020\u00022\u00020\u0002¨\u0006\f"}, m195d2 = {"language", "", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "getLanguage", "(Ljava/util/Locale;)Ljava/lang/String;", "region", "getRegion", "script", "getScript", "getLanguageTag", "PlatformLocale", "ui-text_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlatformLocale_jvmKt {
    public static final String getLanguage(Locale $this$language) {
        return $this$language.getLanguage();
    }

    public static final String getScript(Locale $this$script) {
        return $this$script.getScript();
    }

    public static final String getRegion(Locale $this$region) {
        return $this$region.getCountry();
    }

    public static final String getLanguageTag(Locale $this$getLanguageTag) {
        return $this$getLanguageTag.toLanguageTag();
    }
}
