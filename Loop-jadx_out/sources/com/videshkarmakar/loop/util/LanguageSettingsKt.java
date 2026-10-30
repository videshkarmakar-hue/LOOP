package com.videshkarmakar.loop.util;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.LocaleListCompat;
import com.videshkarmakar.loop.C3070R;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/* JADX INFO: compiled from: LanguageSettings.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0015\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00108\u001a\u0010\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u001b\u001a\u0013\u0010<\u001a\u000206*\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"%\u0010\u0019\u001a\u0016\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006>"}, m195d2 = {"ARABIC", "", "AZERBAIJANI", "BASQUE", "BELARUSIAN", "BENGALI", "CATALAN", "CROATIAN", "CZECH", "DANISH", "DUTCH", "ENGLISH", "FILIPINO", "FRENCH", "GERMAN", "GREEK", "HEBREW", "HINDI", "HUNGARIAN", "INDONESIAN", "ITALIAN", "JAPANESE", "KANNADA", "KHMER", "KOREAN", "LocaleLanguageCodeMap", "", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "getLocaleLanguageCodeMap", "()Ljava/util/Map;", "MALAY", "MALAYALAM", "NORWEGIAN_BOKMAL", "NORWEGIAN_NYNORSK", "PERSIAN", "POLISH", "PORTUGUESE", "PORTUGUESE_BRAZIL", "PORTUGUESE_PORTUGAL", "PUNJABI", "RUSSIAN", "SERBIAN", "SIMPLIFIED_CHINESE", "SINHALA", "SPANISH", "SWEDISH", "TAMIL", "THAI", "TRADITIONAL_CHINESE", "TURKISH", "UKRAINIAN", "VIETNAMESE", "getLanguageDesc", "", "language", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "setLanguage", "", "locale", "toDisplayName", "(Ljava/util/Locale;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LanguageSettingsKt {
    private static final int ARABIC = 12;
    private static final int AZERBAIJANI = 32;
    private static final int BASQUE = 27;
    private static final int BELARUSIAN = 25;
    private static final int BENGALI = 43;
    private static final int CATALAN = 39;
    private static final int CROATIAN = 26;
    private static final int CZECH = 3;
    private static final int DANISH = 7;
    private static final int DUTCH = 17;
    private static final int ENGLISH = 2;
    private static final int FILIPINO = 15;
    private static final int FRENCH = 4;
    private static final int GERMAN = 5;
    private static final int GREEK = 46;
    private static final int HEBREW = 40;
    private static final int HINDI = 28;
    private static final int HUNGARIAN = 21;
    private static final int INDONESIAN = 14;
    private static final int ITALIAN = 16;
    private static final int JAPANESE = 19;
    private static final int KANNADA = 45;
    private static final int KHMER = 44;
    private static final int KOREAN = 36;
    private static final Map<Locale, Integer> LocaleLanguageCodeMap = MapsKt.mapOf(TuplesKt.m202to(new Locale(ArchiveStreamFactory.f563AR), 12), TuplesKt.m202to(new Locale("az"), 32), TuplesKt.m202to(new Locale("eu"), 27), TuplesKt.m202to(new Locale("be"), 25), TuplesKt.m202to(new Locale("bn"), 43), TuplesKt.m202to(new Locale("ca"), 39), TuplesKt.m202to(Locale.forLanguageTag("zh-Hans"), 1), TuplesKt.m202to(Locale.forLanguageTag("zh-Hant"), 23), TuplesKt.m202to(new Locale("hr"), 26), TuplesKt.m202to(new Locale("cs"), 3), TuplesKt.m202to(new Locale("da"), 7), TuplesKt.m202to(new Locale("nl"), 17), TuplesKt.m202to(new Locale("en", "US"), 2), TuplesKt.m202to(new Locale("fil"), 15), TuplesKt.m202to(new Locale("fr"), 4), TuplesKt.m202to(new Locale("de"), 5), TuplesKt.m202to(new Locale("el"), 46), TuplesKt.m202to(new Locale("he"), 40), TuplesKt.m202to(new Locale("hi"), 28), TuplesKt.m202to(new Locale("hu"), 21), TuplesKt.m202to(new Locale("in"), 14), TuplesKt.m202to(new Locale("it"), 16), TuplesKt.m202to(new Locale("ja"), 19), TuplesKt.m202to(new Locale("kn"), 45), TuplesKt.m202to(new Locale("km"), 44), TuplesKt.m202to(new Locale("ko"), 36), TuplesKt.m202to(new Locale("ms"), 22), TuplesKt.m202to(new Locale("ml"), 29), TuplesKt.m202to(new Locale("nb"), 6), TuplesKt.m202to(new Locale("nn"), 33), TuplesKt.m202to(new Locale("fa"), 13), TuplesKt.m202to(new Locale("pl"), 20), TuplesKt.m202to(new Locale("pt"), 41), TuplesKt.m202to(new Locale("pt", "PT"), 38), TuplesKt.m202to(new Locale("pt", "BR"), 18), TuplesKt.m202to(new Locale("pa"), 34), TuplesKt.m202to(new Locale("ru"), 11), TuplesKt.m202to(new Locale("sr"), 31), TuplesKt.m202to(new Locale("si"), 30), TuplesKt.m202to(new Locale("es"), 8), TuplesKt.m202to(new Locale("sv"), 37), TuplesKt.m202to(new Locale("ta"), 35), TuplesKt.m202to(new Locale("th"), 42), TuplesKt.m202to(new Locale("tr"), 9), TuplesKt.m202to(new Locale("uk"), 10), TuplesKt.m202to(new Locale("vi"), 24));
    private static final int MALAY = 22;
    private static final int MALAYALAM = 29;
    private static final int NORWEGIAN_BOKMAL = 6;
    private static final int NORWEGIAN_NYNORSK = 33;
    private static final int PERSIAN = 13;
    private static final int POLISH = 20;
    private static final int PORTUGUESE = 41;
    private static final int PORTUGUESE_BRAZIL = 18;
    private static final int PORTUGUESE_PORTUGAL = 38;
    private static final int PUNJABI = 34;
    private static final int RUSSIAN = 11;
    private static final int SERBIAN = 31;
    private static final int SIMPLIFIED_CHINESE = 1;
    private static final int SINHALA = 30;
    private static final int SPANISH = 8;
    private static final int SWEDISH = 37;
    private static final int TAMIL = 35;
    private static final int THAI = 42;
    private static final int TRADITIONAL_CHINESE = 23;
    private static final int TURKISH = 9;
    private static final int UKRAINIAN = 10;
    private static final int VIETNAMESE = 24;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "See Locale.toDisplayName()")
    public static final /* synthetic */ String getLanguageDesc(int language, Composer $composer, int $changed) {
        int i;
        $composer.startReplaceGroup(-1313311572);
        ComposerKt.sourceInformation($composer, "C(getLanguageDesc)13@428L1626:LanguageSettings.kt#o3b0ww");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1313311572, $changed, -1, "com.videshkarmakar.loop.util.getLanguageDesc (LanguageSettings.kt:12)");
        }
        switch (language) {
            case 1:
                i = C3070R.string.la_zh_CN;
                break;
            case 2:
                i = C3070R.string.la_en_US;
                break;
            case 3:
                i = C3070R.string.la_cs;
                break;
            case 4:
                i = C3070R.string.la_fr;
                break;
            case 5:
                i = C3070R.string.la_de;
                break;
            case 6:
                i = C3070R.string.la_nb;
                break;
            case 7:
                i = C3070R.string.la_da;
                break;
            case 8:
                i = C3070R.string.la_es;
                break;
            case 9:
                i = C3070R.string.la_tr;
                break;
            case 10:
                i = C3070R.string.la_uk;
                break;
            case 11:
                i = C3070R.string.la_ru;
                break;
            case 12:
                i = C3070R.string.la_ar;
                break;
            case 13:
                i = C3070R.string.la_fa;
                break;
            case 14:
                i = C3070R.string.la_in;
                break;
            case 15:
                i = C3070R.string.la_fil;
                break;
            case 16:
                i = C3070R.string.la_it;
                break;
            case 17:
                i = C3070R.string.la_nl;
                break;
            case 18:
                i = C3070R.string.la_pt_BR;
                break;
            case 19:
                i = C3070R.string.la_ja;
                break;
            case 20:
                i = C3070R.string.la_pl;
                break;
            case 21:
                i = C3070R.string.la_hu;
                break;
            case 22:
                i = C3070R.string.la_ms;
                break;
            case 23:
                i = C3070R.string.la_zh_TW;
                break;
            case 24:
                i = C3070R.string.la_vi;
                break;
            case 25:
                i = C3070R.string.la_be;
                break;
            case 26:
                i = C3070R.string.la_hr;
                break;
            case 27:
                i = C3070R.string.la_eu;
                break;
            case 28:
                i = C3070R.string.la_hi;
                break;
            case 29:
                i = C3070R.string.la_ml;
                break;
            case 30:
                i = C3070R.string.la_si;
                break;
            case 31:
                i = C3070R.string.la_sr;
                break;
            case 32:
                i = C3070R.string.la_az;
                break;
            case 33:
                i = C3070R.string.la_nn;
                break;
            case 34:
                i = C3070R.string.la_pa;
                break;
            case 35:
                i = C3070R.string.la_ta;
                break;
            case 36:
                i = C3070R.string.la_ko;
                break;
            case 37:
                i = C3070R.string.la_sv;
                break;
            case 38:
                i = C3070R.string.la_pt;
                break;
            default:
                i = C3070R.string.follow_system;
                break;
        }
        String strStringResource = StringResources_androidKt.stringResource(i, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return strStringResource;
    }

    public static final Map<Locale, Integer> getLocaleLanguageCodeMap() {
        return LocaleLanguageCodeMap;
    }

    public static final String toDisplayName(Locale $this$toDisplayName, Composer $composer, int $changed) {
        $composer.startReplaceGroup(-993791512);
        ComposerKt.sourceInformation($composer, "C(toDisplayName)158@5325L49:LanguageSettings.kt#o3b0ww");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-993791512, $changed, -1, "com.videshkarmakar.loop.util.toDisplayName (LanguageSettings.kt:158)");
        }
        String displayName = $this$toDisplayName != null ? $this$toDisplayName.getDisplayName($this$toDisplayName) : null;
        if (displayName == null) {
            displayName = StringResources_androidKt.stringResource(C3070R.string.follow_system, $composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return displayName;
    }

    public static final void setLanguage(Locale locale) {
        LocaleListCompat localeList;
        if (locale == null || (localeList = LocaleListCompat.create(locale)) == null) {
            localeList = LocaleListCompat.getEmptyLocaleList();
        }
        Intrinsics.checkNotNull(localeList);
        AppCompatDelegate.setApplicationLocales(localeList);
    }
}
