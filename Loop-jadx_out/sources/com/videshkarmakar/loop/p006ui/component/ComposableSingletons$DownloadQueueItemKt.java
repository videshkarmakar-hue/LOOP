package com.videshkarmakar.loop.p006ui.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.UnfoldMoreKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadQueueItem.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$DownloadQueueItemKt {
    public static final ComposableSingletons$DownloadQueueItemKt INSTANCE = new ComposableSingletons$DownloadQueueItemKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f703lambda1 = ComposableLambdaKt.composableLambdaInstance(-714253756, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C149@5765L50:DownloadQueueItem.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-714253756, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt.lambda-1.<anonymous> (DownloadQueueItem.kt:149)");
            }
            DownloadQueueItemKt.CustomCommandTaskItem(null, TaskStatus.RUNNING, 0.0f, null, null, null, null, null, null, null, null, $composer, 48, 0, 2045);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f704lambda2 = ComposableLambdaKt.composableLambdaInstance(238989741, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C152@5877L51:DownloadQueueItem.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238989741, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt.lambda-2.<anonymous> (DownloadQueueItem.kt:152)");
            }
            DownloadQueueItemKt.CustomCommandTaskItem(null, TaskStatus.FINISHED, 0.0f, null, null, null, null, null, null, null, null, $composer, 48, 0, 2045);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f705lambda3 = ComposableLambdaKt.composableLambdaInstance(68150284, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C155@5990L48:DownloadQueueItem.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(68150284, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt.lambda-3.<anonymous> (DownloadQueueItem.kt:155)");
            }
            DownloadQueueItemKt.CustomCommandTaskItem(null, TaskStatus.ERROR, 0.0f, null, null, null, null, null, null, null, null, $composer, 48, 0, 2045);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f706lambda4 = ComposableLambdaKt.composableLambdaInstance(-102689173, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C158@6100L51:DownloadQueueItem.kt#g7nzpb");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-102689173, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt.lambda-4.<anonymous> (DownloadQueueItem.kt:158)");
            }
            DownloadQueueItemKt.CustomCommandTaskItem(null, TaskStatus.CANCELED, 0.0f, null, null, null, null, null, null, null, null, $composer, 48, 0, 2045);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f707lambda5 = ComposableLambdaKt.composableLambdaInstance(574117208, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C147@5659L524:DownloadQueueItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(574117208, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt.lambda-5.<anonymous> (DownloadQueueItem.kt:147)");
                }
                LazyDslKt.LazyColumn(null, null, null, false, Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(8)), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-5$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                        invoke2(lazyListScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LazyListScope LazyColumn) {
                        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                        LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7254getLambda1$app_debug(), 3, null);
                        LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7255getLambda2$app_debug(), 3, null);
                        LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7256getLambda3$app_debug(), 3, null);
                        LazyListScope.CC.item$default(LazyColumn, null, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7257getLambda4$app_debug(), 3, null);
                    }
                }, $composer, 100687872, 239);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f708lambda6 = ComposableLambdaKt.composableLambdaInstance(1804357245, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C146@5637L556:DownloadQueueItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1804357245, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt.lambda-6.<anonymous> (DownloadQueueItem.kt:146)");
                }
                SurfaceKt.m2666SurfaceT9BRK9s(null, null, 0L, 0L, 0.0f, 0.0f, null, ComposableSingletons$DownloadQueueItemKt.INSTANCE.m7258getLambda5$app_debug(), $composer, 12582912, 127);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f709lambda7 = ComposableLambdaKt.composableLambdaInstance(442707238, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C314@12652L101,312@12528L251:DownloadQueueItem.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(442707238, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$DownloadQueueItemKt.lambda-7.<anonymous> (DownloadQueueItem.kt:312)");
                }
                IconKt.m2292Iconww6aTOc(UnfoldMoreKt.getUnfoldMore(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.show_logs, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7254getLambda1$app_debug() {
        return f703lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7255getLambda2$app_debug() {
        return f704lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7256getLambda3$app_debug() {
        return f705lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7257getLambda4$app_debug() {
        return f706lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7258getLambda5$app_debug() {
        return f707lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7259getLambda6$app_debug() {
        return f708lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7260getLambda7$app_debug() {
        return f709lambda7;
    }
}
