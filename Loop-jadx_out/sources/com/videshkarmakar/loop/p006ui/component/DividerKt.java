package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DividerDefaults;
import androidx.compose.p001ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Divider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, m195d2 = {"HorizontalDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "HorizontalDivider-iJQMabo", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DividerKt {
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a6  */
    /* JADX INFO: renamed from: HorizontalDivider-iJQMabo, reason: not valid java name */
    public static final void m7300HorizontalDivideriJQMabo(Modifier modifier, long color, Composer $composer, final int $changed, final int i) {
        int $dirty;
        Composer $composer2 = $composer.startRestartGroup(-2088673869);
        ComposerKt.sourceInformation($composer2, "C(HorizontalDivider)P(1,0:c#ui.graphics.Color)12@379L5,14@420L150:Divider.kt#g7nzpb");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= ((i & 2) == 0 && $composer2.changed(color)) ? 32 : 16;
        }
        if (($dirty2 & 91) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    color = DividerDefaults.INSTANCE.getColor($composer2, DividerDefaults.$stable);
                } else {
                    $dirty = $dirty2;
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2088673869, $dirty, -1, "com.videshkarmakar.loop.ui.component.HorizontalDivider (Divider.kt:13)");
                }
                androidx.compose.material3.DividerKt.m2223HorizontalDivider9IZ8Weo(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), DividerDefaults.INSTANCE.m2221getThicknessD9Ej5fM(), color, $composer2, ($dirty << 3) & 896, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                }
                $dirty = $dirty2;
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2088673869, $dirty, -1, "com.videshkarmakar.loop.ui.component.HorizontalDivider (Divider.kt:13)");
                }
                androidx.compose.material3.DividerKt.m2223HorizontalDivider9IZ8Weo(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), DividerDefaults.INSTANCE.m2221getThicknessD9Ej5fM(), color, $composer2, ($dirty << 3) & 896, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $dirty2 &= -113;
            $dirty = $dirty2;
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2088673869, $dirty, -1, "com.videshkarmakar.loop.ui.component.HorizontalDivider (Divider.kt:13)");
            }
            androidx.compose.material3.DividerKt.m2223HorizontalDivider9IZ8Weo(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), DividerDefaults.INSTANCE.m2221getThicknessD9Ej5fM(), color, $composer2, ($dirty << 3) & 896, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            final long j = color;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.DividerKt$HorizontalDivider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    DividerKt.m7300HorizontalDivideriJQMabo(modifier2, j, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
