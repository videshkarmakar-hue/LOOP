package com.videshkarmakar.loop.p006ui.page.videolist;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.DriveFileMoveKt;
import androidx.compose.material.icons.outlined.DeleteSweepKt;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.material.icons.outlined.RestoreKt;
import androidx.compose.material.icons.outlined.SearchKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoListPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$VideoListPageKt {
    public static final ComposableSingletons$VideoListPageKt INSTANCE = new ComposableSingletons$VideoListPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1044lambda1 = ComposableLambdaKt.composableLambdaInstance(-1347318820, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C298@12146L42,296@12064L146:VideoListPage.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1347318820, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-1.<anonymous> (VideoListPage.kt:296)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.downloads_history, $composer, 0), (Modifier) Modifier.INSTANCE, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 48, 0, 131068);
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
    public static Function2<Composer, Integer, Unit> f1046lambda2 = ComposableLambdaKt.composableLambdaInstance(-1755516394, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C324@13369L31,322@13233L201:VideoListPage.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1755516394, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-2.<anonymous> (VideoListPage.kt:322)");
                }
                IconKt.m2292Iconww6aTOc(SearchKt.getSearch(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.search, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function2<Composer, Integer, Unit> f1047lambda3 = ComposableLambdaKt.composableLambdaInstance(566788960, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C335@13947L125,333@13809L297:VideoListPage.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(566788960, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-3.<anonymous> (VideoListPage.kt:333)");
                }
                IconKt.m2292Iconww6aTOc(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.show_more_actions, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1048lambda4 = ComposableLambdaKt.composableLambdaInstance(120349763, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C351@14865L43,351@14853L56:VideoListPage.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(120349763, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-4.<anonymous> (VideoListPage.kt:351)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.export_backup, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1049lambda5 = ComposableLambdaKt.composableLambdaInstance(606468486, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C346@14530L230:VideoListPage.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(606468486, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-5.<anonymous> (VideoListPage.kt:346)");
                }
                IconKt.m2292Iconww6aTOc(DriveFileMoveKt.getDriveFileMove(Icons.AutoMirrored.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
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
    public static Function2<Composer, Integer, Unit> f1050lambda6 = ComposableLambdaKt.composableLambdaInstance(1992966760, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C364@15609L43,364@15597L56:VideoListPage.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1992966760, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-6.<anonymous> (VideoListPage.kt:364)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.import_backup, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1051lambda7 = ComposableLambdaKt.composableLambdaInstance(954072939, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C359@15313L199:VideoListPage.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(954072939, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-7.<anonymous> (VideoListPage.kt:359)");
                }
                IconKt.m2292Iconww6aTOc(RestoreKt.getRestore(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1052lambda8 = ComposableLambdaKt.composableLambdaInstance(1929873207, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C423@18276L36,421@18151L187:VideoListPage.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1929873207, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-8.<anonymous> (VideoListPage.kt:421)");
                }
                IconKt.m2292Iconww6aTOc(DeleteSweepKt.getDeleteSweep(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(C3070R.string.remove, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1053lambda9 = ComposableLambdaKt.composableLambdaInstance(1655692367, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C575@24381L38:VideoListPage.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1655692367, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-9.<anonymous> (VideoListPage.kt:575)");
            }
            IconKt.m2292Iconww6aTOc(DeleteSweepKt.getDeleteSweep(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1045lambda10 = ComposableLambdaKt.composableLambdaInstance(1848623568, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C576@24450L36,576@24445L42:VideoListPage.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1848623568, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$VideoListPageKt.lambda-10.<anonymous> (VideoListPage.kt:576)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.delete_info, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7632getLambda1$app_debug() {
        return f1044lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7633getLambda10$app_debug() {
        return f1045lambda10;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7634getLambda2$app_debug() {
        return f1046lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7635getLambda3$app_debug() {
        return f1047lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7636getLambda4$app_debug() {
        return f1048lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7637getLambda5$app_debug() {
        return f1049lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7638getLambda6$app_debug() {
        return f1050lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7639getLambda7$app_debug() {
        return f1051lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7640getLambda8$app_debug() {
        return f1052lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7641getLambda9$app_debug() {
        return f1053lambda9;
    }
}
