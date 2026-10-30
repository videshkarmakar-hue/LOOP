package com.videshkarmakar.loop.ui.theme;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.Window;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t\u001a \u0010\n\u001a\u00020\u00012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0013H\u0082\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"LoopTheme", "", "darkTheme", "", "isHighContrastModeEnabled", "isDynamicColorEnabled", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PreviewThemeLight", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "applyOpacity", "Landroidx/compose/ui/graphics/Color;", "enabled", "applyOpacity-DxMtmZc", "(JZ)J", "findWindow", "Landroid/view/Window;", "Landroid/content/Context;", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ThemeKt {
    /* JADX INFO: renamed from: applyOpacity-DxMtmZc, reason: not valid java name */
    public static final long m7529applyOpacityDxMtmZc(long $this$applyOpacity_u2dDxMtmZc, boolean enabled) {
        if (enabled) {
            return $this$applyOpacity_u2dDxMtmZc;
        }
        return Color.m4041copywmQWz5c($this$applyOpacity_u2dDxMtmZc, (14 & 1) != 0 ? Color.m4045getAlphaimpl($this$applyOpacity_u2dDxMtmZc) : 0.62f, (14 & 2) != 0 ? Color.m4049getRedimpl($this$applyOpacity_u2dDxMtmZc) : 0.0f, (14 & 4) != 0 ? Color.m4048getGreenimpl($this$applyOpacity_u2dDxMtmZc) : 0.0f, (14 & 8) != 0 ? Color.m4046getBlueimpl($this$applyOpacity_u2dDxMtmZc) : 0.0f);
    }

    private static final Window findWindow(Context $this$findWindow) {
        while (!($this$findWindow instanceof Activity)) {
            if (!($this$findWindow instanceof ContextWrapper)) {
                return null;
            }
            Context baseContext = ((ContextWrapper) $this$findWindow).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            $this$findWindow = baseContext;
        }
        return ((Activity) $this$findWindow).getWindow();
    }

    public static final void LoopTheme(boolean darkTheme, boolean isHighContrastModeEnabled, boolean isDynamicColorEnabled, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        boolean z;
        final ColorScheme colorScheme;
        boolean darkTheme2;
        boolean isHighContrastModeEnabled2;
        boolean isDynamicColorEnabled2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1704066523);
        ComposerKt.sourceInformation($composer2, "C(LoopTheme)P(1,3,2)46@1471L7,47@1525L7,53@1650L34,56@1784L7,60@1909L175,55@1735L349:Theme.kt#lfpg37");
        int $dirty = $changed;
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            z = isHighContrastModeEnabled;
        } else if (($changed & 112) == 0) {
            z = isHighContrastModeEnabled;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = isHighContrastModeEnabled;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5201) == 1040 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            darkTheme2 = darkTheme;
            isDynamicColorEnabled2 = isDynamicColorEnabled;
            isHighContrastModeEnabled2 = z;
        } else {
            boolean darkTheme3 = (i & 1) != 0 ? true : darkTheme;
            boolean isHighContrastModeEnabled3 = i2 != 0 ? false : z;
            boolean isDynamicColorEnabled3 = (i & 4) != 0 ? false : isDynamicColorEnabled;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1704066523, $dirty2, -1, "com.videshkarmakar.loop.ui.theme.LoopTheme (Theme.kt:36)");
            }
            if (isHighContrastModeEnabled3) {
                colorScheme = ColorScheme.m1792copyCXl9yA$default(ColorSchemeKt.getLoopColorScheme(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, Color.INSTANCE.m4069getBlack0d7_KjU(), 0L, Color.INSTANCE.m4069getBlack0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -40961, 15, null);
            } else {
                colorScheme = ColorSchemeKt.getLoopColorScheme();
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Context context = ((View) objConsume).getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Window window = findWindow(context);
            ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localView2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            View view = (View) objConsume2;
            if (window != null) {
                WindowCompat.getInsetsController(window, view).setAppearanceLightStatusBars(false);
            }
            SystemUiController.CC.m6971setSystemBarsColorIv8Zu3U$default(SystemUiControllerKt.rememberSystemUiController(window, $composer2, 8, 0), Color.INSTANCE.m4078getTransparent0d7_KjU(), false, false, null, 12, null);
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextStyle textStyle = (TextStyle) objConsume3;
            TextKt.ProvideTextStyle(textStyle.m6029copyp1EtxEg((16777213 & 1) != 0 ? textStyle.spanStyle.m5951getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (16777213 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : TextDirection.INSTANCE.m6424getContents_7Xco(), (16777213 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyle.platformStyle : null, (16777213 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : LineBreak.INSTANCE.m6341getParagraphrAG3T2k(), (16777213 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null), ComposableLambdaKt.rememberComposableLambda(1739078796, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.theme.ThemeKt.LoopTheme.2
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C61@1919L159:Theme.kt#lfpg37");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1739078796, $changed2, -1, "com.videshkarmakar.loop.ui.theme.LoopTheme.<anonymous> (Theme.kt:61)");
                        }
                        Typography typography = TypeKt.getTypography();
                        MaterialThemeKt.MaterialTheme(colorScheme, ShapeKt.getShapes(), typography, content, $composer3, 432, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            darkTheme2 = darkTheme3;
            isHighContrastModeEnabled2 = isHighContrastModeEnabled3;
            isDynamicColorEnabled2 = isDynamicColorEnabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = darkTheme2;
            final boolean z3 = isHighContrastModeEnabled2;
            final boolean z4 = isDynamicColorEnabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.theme.ThemeKt.LoopTheme.3
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

                public final void invoke(Composer composer, int i3) {
                    ThemeKt.LoopTheme(z2, z3, z4, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void PreviewThemeLight(final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1962835959);
        ComposerKt.sourceInformation($composer2, "C(PreviewThemeLight)74@2167L143:Theme.kt#lfpg37");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1962835959, $dirty2, -1, "com.videshkarmakar.loop.ui.theme.PreviewThemeLight (Theme.kt:73)");
            }
            MaterialThemeKt.MaterialTheme(ColorSchemeKt.getLoopColorScheme(), ShapeKt.getShapes(), TypeKt.getTypography(), content, $composer2, (($dirty2 << 9) & 7168) | 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.theme.ThemeKt.PreviewThemeLight.1
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
                    ThemeKt.PreviewThemeLight(content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
