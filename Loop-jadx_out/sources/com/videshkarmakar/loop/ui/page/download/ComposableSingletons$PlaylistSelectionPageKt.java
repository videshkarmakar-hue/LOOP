package com.videshkarmakar.loop.ui.page.download;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.PlaylistAddKt;
import androidx.compose.material3.IconKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaylistSelectionPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$PlaylistSelectionPageKt {
    public static final ComposableSingletons$PlaylistSelectionPageKt INSTANCE = new ComposableSingletons$PlaylistSelectionPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f216lambda1 = ComposableLambdaKt.composableLambdaInstance(369460874, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C90@3909L30,90@3882L58:PlaylistSelectionPage.kt#y3famj");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(369460874, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionPageKt.lambda-1.<anonymous> (PlaylistSelectionPage.kt:90)");
            }
            IconKt.m2044Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.close, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f217lambda2 = ComposableLambdaKt.composableLambdaInstance(-1282797509, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C105@4696L39,105@4684L52:PlaylistSelectionPage.kt#y3famj");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1282797509, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionPageKt.lambda-2.<anonymous> (PlaylistSelectionPage.kt:105)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.start_download, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f218lambda3 = ComposableLambdaKt.composableLambdaInstance(1962570181, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C148@6835L111,146@6710L262:PlaylistSelectionPage.kt#y3famj");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1962570181, $changed, -1, "com.videshkarmakar.loop.ui.page.download.ComposableSingletons$PlaylistSelectionPageKt.lambda-3.<anonymous> (PlaylistSelectionPage.kt:146)");
                }
                IconKt.m2044Iconww6aTOc(PlaylistAddKt.getPlaylistAdd(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.download_range_selection, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7250getLambda1$app_debug() {
        return f216lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7251getLambda2$app_debug() {
        return f217lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7252getLambda3$app_debug() {
        return f218lambda3;
    }
}
