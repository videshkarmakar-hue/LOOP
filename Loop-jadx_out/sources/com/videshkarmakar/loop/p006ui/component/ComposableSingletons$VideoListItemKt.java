package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoListItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$VideoListItemKt {
    public static final ComposableSingletons$VideoListItemKt INSTANCE = new ComposableSingletons$VideoListItemKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f743lambda1 = ComposableLambdaKt.composableLambdaInstance(270626001, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$VideoListItemKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C52@2247L53,53@2327L95,51@2208L265:VideoListItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(270626001, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$VideoListItemKt.lambda-1.<anonymous> (VideoListItem.kt:51)");
                }
                VideoListItemKt.MediaListItem(null, StringResources_androidKt.stringResource(C3070R.string.video_title_sample_text, $composer, 0), StringResources_androidKt.stringResource(C3070R.string.video_creator_sample_text, $composer, 0), null, null, null, 5953814528L, null, null, null, null, null, null, $composer, 1572864, 0, 8121);
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
    public static Function2<Composer, Integer, Unit> f744lambda2 = ComposableLambdaKt.composableLambdaInstance(-443839028, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$VideoListItemKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C50@2184L299:VideoListItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-443839028, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$VideoListItemKt.lambda-2.<anonymous> (VideoListItem.kt:50)");
                }
                SurfaceKt.m2666SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableSingletons$VideoListItemKt.INSTANCE.m7294getLambda1$app_debug(), $composer, 12582912, 127);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f745lambda3 = ComposableLambdaKt.composableLambdaInstance(-51999455, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$VideoListItemKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C178@6774L47,175@6615L224:VideoListItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-51999455, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$VideoListItemKt.lambda-3.<anonymous> (VideoListItem.kt:175)");
                }
                IconKt.m2292Iconww6aTOc(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.show_more_actions, $composer, 0), SizeKt.m913size3ABfNKs(Modifier.INSTANCE, C1979Dp.m6801constructorimpl(18)), 0L, $composer, 384, 8);
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
    public final Function2<Composer, Integer, Unit> m7294getLambda1$app_debug() {
        return f743lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7295getLambda2$app_debug() {
        return f744lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7296getLambda3$app_debug() {
        return f745lambda3;
    }
}
