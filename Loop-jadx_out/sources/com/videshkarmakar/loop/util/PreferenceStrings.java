package com.videshkarmakar.loop.util;

import androidx.compose.material3.internal.CalendarModelKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferenceUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u001a"}, m195d2 = {"Lcom/videshkarmakar/loop/util/PreferenceStrings;", "", "()V", "getAudioConvertDesc", "", "audioFormatCode", "", "getAudioFormatDesc", "getAudioQualityDesc", "audioQualityCode", "getSubtitleConversionFormat", "subtitleFormat", "getUpdateIntervalText", "interval", "", "(JLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "getVideoFormatDesc", "videoFormatCode", "getVideoFormatDescComp", "(ILandroidx/compose/runtime/Composer;II)Ljava/lang/String;", "getVideoFormatLabel", "videoFormatPreference", "getVideoResolutionDesc", "videoQualityCode", "getVideoResolutionDescComp", "getVideoResolutionDescRes", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PreferenceStrings {
    public static final int $stable = 0;
    public static final PreferenceStrings INSTANCE = new PreferenceStrings();

    private PreferenceStrings() {
    }

    public static /* synthetic */ String getSubtitleConversionFormat$default(PreferenceStrings preferenceStrings, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = PreferenceUtil.getInt$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CONVERT_SUBTITLE, 0, 1, null);
        }
        return preferenceStrings.getSubtitleConversionFormat(i);
    }

    public final String getSubtitleConversionFormat(int subtitleFormat) {
        switch (subtitleFormat) {
            case 1:
                String string = App.INSTANCE.getContext().getString(C3070R.string.convert_to, "ass");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = App.INSTANCE.getContext().getString(C3070R.string.convert_to, "lrc");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = App.INSTANCE.getContext().getString(C3070R.string.convert_to, "srt");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = App.INSTANCE.getContext().getString(C3070R.string.convert_to, "vtt");
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            default:
                String string5 = App.INSTANCE.getContext().getString(C3070R.string.not_convert);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
        }
    }

    public static /* synthetic */ String getAudioFormatDesc$default(PreferenceStrings preferenceStrings, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = PreferenceUtil.INSTANCE.getAudioFormat();
        }
        return preferenceStrings.getAudioFormatDesc(i);
    }

    public final String getAudioFormatDesc(int audioFormatCode) {
        switch (audioFormatCode) {
            case 1:
                return "OPUS";
            case 2:
                return "M4A";
            default:
                String string = App.INSTANCE.getContext().getString(C3070R.string.not_specified);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
        }
    }

    public static /* synthetic */ String getAudioQualityDesc$default(PreferenceStrings preferenceStrings, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = PreferenceUtil.INSTANCE.getAudioQuality();
        }
        return preferenceStrings.getAudioQualityDesc(i);
    }

    public final String getAudioQualityDesc(int audioQualityCode) {
        switch (audioQualityCode) {
            case 0:
                String string = App.INSTANCE.getContext().getString(C3070R.string.unlimited);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 1:
                return "192 Kbps";
            case 2:
                return "128 Kbps";
            case 3:
                return "64 Kbps";
            case 4:
                return "32 Kbps";
            default:
                String string2 = App.INSTANCE.getContext().getString(C3070R.string.lowest_bitrate);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
        }
    }

    public static /* synthetic */ String getAudioConvertDesc$default(PreferenceStrings preferenceStrings, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = PreferenceUtil.INSTANCE.getAudioConvertFormat();
        }
        return preferenceStrings.getAudioConvertDesc(i);
    }

    public final String getAudioConvertDesc(int audioFormatCode) {
        if (audioFormatCode == 0) {
            String string = App.INSTANCE.getContext().getString(C3070R.string.convert_to);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{"mp3"}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        String string2 = App.INSTANCE.getContext().getString(C3070R.string.convert_to);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str2 = String.format(string2, Arrays.copyOf(new Object[]{"m4a"}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static /* synthetic */ String getVideoFormatDesc$default(PreferenceStrings preferenceStrings, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = PreferenceUtil.INSTANCE.getVideoFormat();
        }
        return preferenceStrings.getVideoFormatDesc(i);
    }

    public final String getVideoFormatDesc(int videoFormatCode) {
        switch (videoFormatCode) {
            case 1:
                String string = App.INSTANCE.getContext().getString(C3070R.string.prefer_compatibility_desc);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = App.INSTANCE.getContext().getString(C3070R.string.prefer_quality_desc);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            default:
                String string3 = App.INSTANCE.getContext().getString(C3070R.string.not_specified);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
        }
    }

    public final String getVideoFormatDescComp(int videoFormatCode, Composer $composer, int $changed, int i) {
        String strStringResource;
        $composer.startReplaceGroup(1149059444);
        ComposerKt.sourceInformation($composer, "C(getVideoFormatDescComp):PreferenceUtil.kt#o3b0ww");
        if ((i & 1) != 0) {
            videoFormatCode = PreferenceUtil.INSTANCE.getVideoFormat();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1149059444, $changed, -1, "com.videshkarmakar.loop.util.PreferenceStrings.getVideoFormatDescComp (PreferenceUtil.kt:458)");
        }
        switch (videoFormatCode) {
            case 1:
                $composer.startReplaceGroup(8271498);
                ComposerKt.sourceInformation($composer, "460@16251L50");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.prefer_compatibility_desc, $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 2:
                $composer.startReplaceGroup(8271579);
                ComposerKt.sourceInformation($composer, "461@16332L44");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.prefer_quality_desc, $composer, 0);
                $composer.endReplaceGroup();
                break;
            default:
                $composer.startReplaceGroup(8271644);
                ComposerKt.sourceInformation($composer, "462@16397L38");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.not_specified, $composer, 0);
                $composer.endReplaceGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return strStringResource;
    }

    public final String getVideoResolutionDescRes(int videoQualityCode, Composer $composer, int $changed, int i) {
        String strStringResource;
        $composer.startReplaceGroup(530727758);
        ComposerKt.sourceInformation($composer, "C(getVideoResolutionDescRes):PreferenceUtil.kt#o3b0ww");
        if ((i & 1) != 0) {
            videoQualityCode = PreferenceUtil.INSTANCE.getVideoResolution();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(530727758, $changed, -1, "com.videshkarmakar.loop.util.PreferenceStrings.getVideoResolutionDescRes (PreferenceUtil.kt:467)");
        }
        switch (videoQualityCode) {
            case 1:
                $composer.startReplaceGroup(-1827722937);
                $composer.endReplaceGroup();
                strStringResource = "2160p";
                break;
            case 2:
                $composer.startReplaceGroup(-1828558232);
                $composer.endReplaceGroup();
                strStringResource = "1440p";
                break;
            case 3:
                $composer.startReplaceGroup(-1828672777);
                $composer.endReplaceGroup();
                strStringResource = "1080p";
                break;
            case 4:
                $composer.startReplaceGroup(-1873721760);
                $composer.endReplaceGroup();
                strStringResource = "720p";
                break;
            case 5:
                $composer.startReplaceGroup(-1873804623);
                $composer.endReplaceGroup();
                strStringResource = "480p";
                break;
            case 6:
                $composer.startReplaceGroup(-1873835592);
                $composer.endReplaceGroup();
                strStringResource = "360p";
                break;
            case 7:
                $composer.startReplaceGroup(1047881634);
                ComposerKt.sourceInformation($composer, "475@16779L39");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.lowest_quality, $composer, 0);
                $composer.endReplaceGroup();
                break;
            default:
                $composer.startReplaceGroup(1047881694);
                ComposerKt.sourceInformation($composer, "476@16839L37");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.best_quality, $composer, 0);
                $composer.endReplaceGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return strStringResource;
    }

    public static /* synthetic */ String getVideoResolutionDesc$default(PreferenceStrings preferenceStrings, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = PreferenceUtil.INSTANCE.getVideoResolution();
        }
        return preferenceStrings.getVideoResolutionDesc(i);
    }

    public final String getVideoResolutionDesc(int videoQualityCode) {
        switch (videoQualityCode) {
            case 1:
                return "2160p";
            case 2:
                return "1440p";
            case 3:
                return "1080p";
            case 4:
                return "720p";
            case 5:
                return "480p";
            case 6:
                return "360p";
            case 7:
                String string = App.INSTANCE.getContext().getString(C3070R.string.lowest_quality);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            default:
                String string2 = App.INSTANCE.getContext().getString(C3070R.string.best_quality);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
        }
    }

    public final String getVideoResolutionDescComp(int videoQualityCode, Composer $composer, int $changed, int i) {
        String strStringResource;
        $composer.startReplaceGroup(1916995103);
        ComposerKt.sourceInformation($composer, "C(getVideoResolutionDescComp):PreferenceUtil.kt#o3b0ww");
        if ((i & 1) != 0) {
            videoQualityCode = PreferenceUtil.INSTANCE.getVideoResolution();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1916995103, $changed, -1, "com.videshkarmakar.loop.util.PreferenceStrings.getVideoResolutionDescComp (PreferenceUtil.kt:494)");
        }
        switch (videoQualityCode) {
            case 1:
                $composer.startReplaceGroup(1603737552);
                $composer.endReplaceGroup();
                strStringResource = "2160p";
                break;
            case 2:
                $composer.startReplaceGroup(1602902257);
                $composer.endReplaceGroup();
                strStringResource = "1440p";
                break;
            case 3:
                $composer.startReplaceGroup(1602787712);
                $composer.endReplaceGroup();
                strStringResource = "1080p";
                break;
            case 4:
                $composer.startReplaceGroup(1557738729);
                $composer.endReplaceGroup();
                strStringResource = "720p";
                break;
            case 5:
                $composer.startReplaceGroup(1557655866);
                $composer.endReplaceGroup();
                strStringResource = "480p";
                break;
            case 6:
                $composer.startReplaceGroup(1557624897);
                $composer.endReplaceGroup();
                strStringResource = "360p";
                break;
            case 7:
                $composer.startReplaceGroup(-1889467399);
                ComposerKt.sourceInformation($composer, "502@17663L39");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.lowest_quality, $composer, 0);
                $composer.endReplaceGroup();
                break;
            default:
                $composer.startReplaceGroup(-1889467339);
                ComposerKt.sourceInformation($composer, "503@17723L37");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.best_quality, $composer, 0);
                $composer.endReplaceGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return strStringResource;
    }

    public final String getVideoFormatLabel(int videoFormatPreference, Composer $composer, int $changed, int i) {
        String strStringResource;
        $composer.startReplaceGroup(1114901012);
        ComposerKt.sourceInformation($composer, "C(getVideoFormatLabel):PreferenceUtil.kt#o3b0ww");
        if ((i & 1) != 0) {
            videoFormatPreference = PreferenceUtil.INSTANCE.getVideoFormat();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1114901012, $changed, -1, "com.videshkarmakar.loop.util.PreferenceStrings.getVideoFormatLabel (PreferenceUtil.kt:508)");
        }
        if (videoFormatPreference == 1) {
            $composer.startReplaceGroup(-464855083);
            ComposerKt.sourceInformation($composer, "510@17976L36");
            strStringResource = StringResources_androidKt.stringResource(C3070R.string.legacy, $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-464855026);
            ComposerKt.sourceInformation($composer, "511@18033L37");
            strStringResource = StringResources_androidKt.stringResource(C3070R.string.quality, $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return strStringResource;
    }

    public final String getUpdateIntervalText(long interval, Composer $composer, int $changed) {
        int i;
        $composer.startReplaceGroup(-1124642780);
        ComposerKt.sourceInformation($composer, "C(getUpdateIntervalText)517@18175L275:PreferenceUtil.kt#o3b0ww");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1124642780, $changed, -1, "com.videshkarmakar.loop.util.PreferenceStrings.getUpdateIntervalText (PreferenceUtil.kt:516)");
        }
        if (interval == CalendarModelKt.MillisecondsIn24Hours) {
            i = C3070R.string.every_day;
        } else if (interval == PreferenceUtilKt.DEFAULT_INTERVAL) {
            i = C3070R.string.every_week;
        } else {
            i = interval == 2592000000L ? C3070R.string.every_month : C3070R.string.disabled;
        }
        String strStringResource = StringResources_androidKt.stringResource(i, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return strStringResource;
    }
}
