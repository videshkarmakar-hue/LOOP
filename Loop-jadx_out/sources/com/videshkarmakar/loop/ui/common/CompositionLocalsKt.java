package com.videshkarmakar.loop.ui.common;

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DarkThemePreference;
import com.videshkarmakar.loop.util.PreferenceUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompositionLocals.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0004\"\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"LocalDarkTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/videshkarmakar/loop/util/DarkThemePreference;", "getLocalDarkTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalDynamicColorSwitch", "", "getLocalDynamicColorSwitch", "LocalPaletteStyleIndex", "", "getLocalPaletteStyleIndex", "LocalSeedColor", "", "getLocalSeedColor", "LocalWindowWidthState", "Landroidx/compose/material3/windowsizeclass/WindowWidthSizeClass;", "getLocalWindowWidthState", "SettingsProvider", "", "windowWidthSizeClass", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "SettingsProvider-wsnAAM8", "(ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CompositionLocalsKt {
    private static final ProvidableCompositionLocal<DarkThemePreference> LocalDarkTheme = CompositionLocalKt.compositionLocalOf$default(null, new Function0<DarkThemePreference>() { // from class: com.videshkarmakar.loop.ui.common.CompositionLocalsKt$LocalDarkTheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DarkThemePreference invoke() {
            return new DarkThemePreference(0, false, 3, null);
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<Long> LocalSeedColor = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Long>() { // from class: com.videshkarmakar.loop.ui.common.CompositionLocalsKt$LocalSeedColor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return 4292290109L;
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<WindowWidthSizeClass> LocalWindowWidthState = CompositionLocalKt.staticCompositionLocalOf(new Function0<WindowWidthSizeClass>() { // from class: com.videshkarmakar.loop.ui.common.CompositionLocalsKt$LocalWindowWidthState$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ WindowWidthSizeClass invoke() {
            return WindowWidthSizeClass.m3487boximpl(m7100invokeY0FxcvE());
        }

        /* JADX INFO: renamed from: invoke-Y0FxcvE, reason: not valid java name */
        public final int m7100invokeY0FxcvE() {
            return WindowWidthSizeClass.INSTANCE.m3499getCompactY0FxcvE();
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalDynamicColorSwitch = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Boolean>() { // from class: com.videshkarmakar.loop.ui.common.CompositionLocalsKt$LocalDynamicColorSwitch$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return false;
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<Integer> LocalPaletteStyleIndex = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Integer>() { // from class: com.videshkarmakar.loop.ui.common.CompositionLocalsKt$LocalPaletteStyleIndex$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return 0;
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<DarkThemePreference> getLocalDarkTheme() {
        return LocalDarkTheme;
    }

    public static final ProvidableCompositionLocal<Long> getLocalSeedColor() {
        return LocalSeedColor;
    }

    public static final ProvidableCompositionLocal<WindowWidthSizeClass> getLocalWindowWidthState() {
        return LocalWindowWidthState;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalDynamicColorSwitch() {
        return LocalDynamicColorSwitch;
    }

    public static final ProvidableCompositionLocal<Integer> getLocalPaletteStyleIndex() {
        return LocalPaletteStyleIndex;
    }

    /* JADX INFO: renamed from: SettingsProvider-wsnAAM8, reason: not valid java name */
    public static final void m7099SettingsProviderwsnAAM8(final int windowWidthSizeClass, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1444985112);
        ComposerKt.sourceInformation($composer2, "C(SettingsProvider)P(1:c#material3.windowsizeclass.WindowWidthSizeClass)*25@1215L16,26@1252L364:CompositionLocals.kt#x6o9ax");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(windowWidthSizeClass) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 32 : 16;
        }
        if (($dirty & 91) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1444985112, $dirty, -1, "com.videshkarmakar.loop.ui.common.SettingsProvider (CompositionLocals.kt:24)");
            }
            PreferenceUtil.AppSettings $this$SettingsProvider_wsnAAM8_u24lambda_u240 = (PreferenceUtil.AppSettings) SnapshotStateKt.collectAsState(PreferenceUtil.INSTANCE.getAppSettingsStateFlow(), null, $composer2, 8, 1).getValue();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalDarkTheme.provides($this$SettingsProvider_wsnAAM8_u24lambda_u240.getDarkTheme()), LocalSeedColor.provides(Long.valueOf($this$SettingsProvider_wsnAAM8_u24lambda_u240.getSeedColor())), LocalPaletteStyleIndex.provides(Integer.valueOf($this$SettingsProvider_wsnAAM8_u24lambda_u240.getPaletteStyleIndex())), LocalWindowWidthState.provides(WindowWidthSizeClass.m3487boximpl(windowWidthSizeClass)), LocalDynamicColorSwitch.provides(Boolean.valueOf($this$SettingsProvider_wsnAAM8_u24lambda_u240.isDynamicColorEnabled()))}, content, $composer2, ($dirty & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.common.CompositionLocalsKt$SettingsProvider$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    CompositionLocalsKt.m7099SettingsProviderwsnAAM8(windowWidthSizeClass, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
