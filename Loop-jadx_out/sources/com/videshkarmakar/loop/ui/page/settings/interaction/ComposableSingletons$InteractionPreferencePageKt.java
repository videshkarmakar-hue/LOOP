package com.videshkarmakar.loop.ui.page.settings.interaction;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.PreferenceItemsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InteractionPreferencePage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$InteractionPreferencePageKt {
    public static final ComposableSingletons$InteractionPreferencePageKt INSTANCE = new ComposableSingletons$InteractionPreferencePageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f379lambda1 = ComposableLambdaKt.composableLambdaInstance(1047369034, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.ComposableSingletons$InteractionPreferencePageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C44@1901L101,43@1868L152:InteractionPreferencePage.kt#tb24dy");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1047369034, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.ComposableSingletons$InteractionPreferencePageKt.lambda-1.<anonymous> (InteractionPreferencePage.kt:43)");
                }
                TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.interface_and_interaction, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f380lambda2 = ComposableLambdaKt.composableLambdaInstance(2054155724, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.interaction.ComposableSingletons$InteractionPreferencePageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C55@2281L54,55@2255L81:InteractionPreferencePage.kt#tb24dy");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054155724, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.interaction.ComposableSingletons$InteractionPreferencePageKt.lambda-2.<anonymous> (InteractionPreferencePage.kt:55)");
            }
            PreferenceItemsKt.m7176PreferenceSubtitleww6aTOc(null, null, StringResources_androidKt.stringResource(R.string.settings_before_download, $composer, 0), 0L, $composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7433getLambda1$app_debug() {
        return f379lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7434getLambda2$app_debug() {
        return f380lambda2;
    }
}
