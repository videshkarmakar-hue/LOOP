package com.videshkarmakar.loop.util;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PreferenceUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\r\u0010\u0013\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0017"}, m195d2 = {"Lcom/videshkarmakar/loop/util/DarkThemePreference;", "", "darkThemeValue", "", "isHighContrastModeEnabled", "", "(IZ)V", "getDarkThemeValue", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "getDarkThemeDesc", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "hashCode", "isDarkTheme", "(Landroidx/compose/runtime/Composer;I)Z", "toString", "Companion", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class DarkThemePreference {
    public static final int $stable = 0;
    public static final int FOLLOW_SYSTEM = 1;
    public static final int OFF = 3;

    /* JADX INFO: renamed from: ON */
    public static final int f509ON = 2;
    private final int darkThemeValue;
    private final boolean isHighContrastModeEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public DarkThemePreference() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public static /* synthetic */ DarkThemePreference copy$default(DarkThemePreference darkThemePreference, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = darkThemePreference.darkThemeValue;
        }
        if ((i2 & 2) != 0) {
            z = darkThemePreference.isHighContrastModeEnabled;
        }
        return darkThemePreference.copy(i, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDarkThemeValue() {
        return this.darkThemeValue;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsHighContrastModeEnabled() {
        return this.isHighContrastModeEnabled;
    }

    public final DarkThemePreference copy(int darkThemeValue, boolean isHighContrastModeEnabled) {
        return new DarkThemePreference(darkThemeValue, isHighContrastModeEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DarkThemePreference)) {
            return false;
        }
        DarkThemePreference darkThemePreference = (DarkThemePreference) other;
        return this.darkThemeValue == darkThemePreference.darkThemeValue && this.isHighContrastModeEnabled == darkThemePreference.isHighContrastModeEnabled;
    }

    public int hashCode() {
        return (this.darkThemeValue * 31) + DarkThemePreference$$ExternalSyntheticBackport0.m190m(this.isHighContrastModeEnabled);
    }

    public String toString() {
        return "DarkThemePreference(darkThemeValue=" + this.darkThemeValue + ", isHighContrastModeEnabled=" + this.isHighContrastModeEnabled + ")";
    }

    public DarkThemePreference(int darkThemeValue, boolean isHighContrastModeEnabled) {
        this.darkThemeValue = darkThemeValue;
        this.isHighContrastModeEnabled = isHighContrastModeEnabled;
    }

    public /* synthetic */ DarkThemePreference(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? false : z);
    }

    public final int getDarkThemeValue() {
        return this.darkThemeValue;
    }

    public final boolean isHighContrastModeEnabled() {
        return this.isHighContrastModeEnabled;
    }

    public final boolean isDarkTheme(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1778420190);
        ComposerKt.sourceInformation($composer, "C(isDarkTheme)400@13848L21:PreferenceUtil.kt#o3b0ww");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1778420190, $changed, -1, "com.videshkarmakar.loop.util.DarkThemePreference.isDarkTheme (PreferenceUtil.kt:399)");
        }
        boolean zIsSystemInDarkTheme = false;
        if (this.darkThemeValue == 1) {
            zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme($composer, 0);
        } else if (this.darkThemeValue == 2) {
            zIsSystemInDarkTheme = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return zIsSystemInDarkTheme;
    }

    public final String getDarkThemeDesc(Composer $composer, int $changed) {
        String strStringResource;
        $composer.startReplaceGroup(1622856224);
        ComposerKt.sourceInformation($composer, "C(getDarkThemeDesc):PreferenceUtil.kt#o3b0ww");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1622856224, $changed, -1, "com.videshkarmakar.loop.util.DarkThemePreference.getDarkThemeDesc (PreferenceUtil.kt:405)");
        }
        switch (this.darkThemeValue) {
            case 1:
                $composer.startReplaceGroup(-1813453004);
                ComposerKt.sourceInformation($composer, "407@14032L38");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.follow_system, $composer, 0);
                $composer.endReplaceGroup();
                break;
            case 2:
                $composer.startReplaceGroup(-1813452947);
                ComposerKt.sourceInformation($composer, "408@14089L27");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.f457on, $composer, 0);
                $composer.endReplaceGroup();
                break;
            default:
                $composer.startReplaceGroup(-1813452899);
                ComposerKt.sourceInformation($composer, "409@14137L28");
                strStringResource = StringResources_androidKt.stringResource(C3070R.string.off, $composer, 0);
                $composer.endReplaceGroup();
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return strStringResource;
    }
}
