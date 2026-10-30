package com.videshkarmakar.loop.p006ui.page.videolist;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.DriveFileMoveKt;
import androidx.compose.material.icons.outlined.RestoreKt;
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
import com.videshkarmakar.loop.database.backup.BackupUtil;
import com.videshkarmakar.loop.p006ui.component.ChipsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExportImportDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$ExportImportDialogKt {
    public static final ComposableSingletons$ExportImportDialogKt INSTANCE = new ComposableSingletons$ExportImportDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f1021lambda1 = ComposableLambdaKt.composableLambdaInstance(-808835170, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C49@2156L43,49@2144L56:ExportImportDialog.kt#861hqi");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-808835170, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-1.<anonymous> (ExportImportDialog.kt:49)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.export_backup, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f1031lambda2 = ComposableLambdaKt.composableLambdaInstance(-90908511, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation($composer, "C53@2329L36,53@2317L49:ExportImportDialog.kt#861hqi");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-90908511, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-2.<anonymous> (ExportImportDialog.kt:53)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.cancel, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1032lambda3 = ComposableLambdaKt.composableLambdaInstance(1990121392, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C60@2529L134:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1990121392, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-3.<anonymous> (ExportImportDialog.kt:60)");
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

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1033lambda4 = ComposableLambdaKt.composableLambdaInstance(-1356356175, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C57@2434L53,57@2422L66:ExportImportDialog.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1356356175, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-4.<anonymous> (ExportImportDialog.kt:57)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.export_download_history, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1034lambda5 = ComposableLambdaKt.composableLambdaInstance(-1759937273, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C89@3776L159,88@3734L235:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1759937273, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-5.<anonymous> (ExportImportDialog.kt:88)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.full_backup, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
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
    public static Function2<Composer, Integer, Unit> f1035lambda6 = ComposableLambdaKt.composableLambdaInstance(1582327728, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C102@4344L117,101@4295L200:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1582327728, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-6.<anonymous> (ExportImportDialog.kt:101)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.video_url, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
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
    public static Function2<Composer, Integer, Unit> f1036lambda7 = ComposableLambdaKt.composableLambdaInstance(-1840964418, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C124@5277L152,123@5235L228:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1840964418, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-7.<anonymous> (ExportImportDialog.kt:123)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.file, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
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
    public static Function2<Composer, Integer, Unit> f1037lambda8 = ComposableLambdaKt.composableLambdaInstance(1735131431, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C137@5870L117,136@5821L200:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1735131431, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-8.<anonymous> (ExportImportDialog.kt:136)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.clipboard, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
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
    public static Function3<RowScope, Composer, Integer, Unit> f1038lambda9 = ComposableLambdaKt.composableLambdaInstance(-6446551, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C162@6571L43,162@6559L56:ExportImportDialog.kt#861hqi");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6446551, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-9.<anonymous> (ExportImportDialog.kt:162)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.import_backup, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f1022lambda10 = ComposableLambdaKt.composableLambdaInstance(-1407759188, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation($composer, "C166@6744L36,166@6732L49:ExportImportDialog.kt#861hqi");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1407759188, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-10.<anonymous> (ExportImportDialog.kt:166)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.cancel, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1023lambda11 = ComposableLambdaKt.composableLambdaInstance(878783291, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C173@6944L115:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(878783291, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-11.<anonymous> (ExportImportDialog.kt:173)");
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

    /* JADX INFO: renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1024lambda12 = ComposableLambdaKt.composableLambdaInstance(800793020, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C170@6849L53,170@6837L66:ExportImportDialog.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(800793020, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-12.<anonymous> (ExportImportDialog.kt:170)");
            }
            TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.import_download_history, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-13, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1025lambda13 = ComposableLambdaKt.composableLambdaInstance(-273017838, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C196@7858L159,195@7816L235:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-273017838, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-13.<anonymous> (ExportImportDialog.kt:195)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.full_backup, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-14, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f1026lambda14 = ComposableLambdaKt.composableLambdaInstance(-1189061423, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C193@7697L410:ExportImportDialog.kt#861hqi");
            if (($changed & 81) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1189061423, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-14.<anonymous> (ExportImportDialog.kt:193)");
                }
                ChipsKt.SingleSelectChip(true, new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-14$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                }, ComposableSingletons$ExportImportDialogKt.INSTANCE.m7613getLambda13$app_debug(), null, false, null, null, null, null, $composer, 438, 504);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-15, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1027lambda15 = ComposableLambdaKt.composableLambdaInstance(-14670007, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C219@8835L152,218@8793L228:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-14670007, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-15.<anonymous> (ExportImportDialog.kt:218)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.file, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-16, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1028lambda16 = ComposableLambdaKt.composableLambdaInstance(-46946254, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C233@9456L117,232@9407L200:ExportImportDialog.kt#861hqi");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-46946254, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-16.<anonymous> (ExportImportDialog.kt:232)");
                }
                TextKt.m2817Text4IGK_g(StringResources_androidKt.stringResource(C3070R.string.clipboard, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-17, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1029lambda17 = ComposableLambdaKt.composableLambdaInstance(1393374692, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-17$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C251@9828L26:ExportImportDialog.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393374692, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-17.<anonymous> (ExportImportDialog.kt:251)");
            }
            ExportImportDialogKt.ExportDialog(null, 0, null, new Function2<BackupUtil.BackupType, BackupUtil.BackupDestination, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-17$1.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(BackupUtil.BackupType backupType, BackupUtil.BackupDestination backupDestination) {
                    invoke2(backupType, backupDestination);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BackupUtil.BackupType backupType, BackupUtil.BackupDestination backupDestination) {
                    Intrinsics.checkNotNullParameter(backupType, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(backupDestination, "<anonymous parameter 1>");
                }
            }, $composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-18, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1030lambda18 = ComposableLambdaKt.composableLambdaInstance(449174995, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-18$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C260@9997L23:ExportImportDialog.kt#861hqi");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(449174995, $changed, -1, "com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt.lambda-18.<anonymous> (ExportImportDialog.kt:260)");
            }
            ExportImportDialogKt.ImportDialog(null, null, new Function1<BackupUtil.BackupDestination, Unit>() { // from class: com.videshkarmakar.loop.ui.page.videolist.ComposableSingletons$ExportImportDialogKt$lambda-18$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BackupUtil.BackupDestination backupDestination) {
                    invoke2(backupDestination);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BackupUtil.BackupDestination backupDestination) {
                    Intrinsics.checkNotNullParameter(backupDestination, "<anonymous parameter 0>");
                }
            }, $composer, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7609getLambda1$app_debug() {
        return f1021lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7610getLambda10$app_debug() {
        return f1022lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7611getLambda11$app_debug() {
        return f1023lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7612getLambda12$app_debug() {
        return f1024lambda12;
    }

    /* JADX INFO: renamed from: getLambda-13$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7613getLambda13$app_debug() {
        return f1025lambda13;
    }

    /* JADX INFO: renamed from: getLambda-14$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7614getLambda14$app_debug() {
        return f1026lambda14;
    }

    /* JADX INFO: renamed from: getLambda-15$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7615getLambda15$app_debug() {
        return f1027lambda15;
    }

    /* JADX INFO: renamed from: getLambda-16$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7616getLambda16$app_debug() {
        return f1028lambda16;
    }

    /* JADX INFO: renamed from: getLambda-17$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7617getLambda17$app_debug() {
        return f1029lambda17;
    }

    /* JADX INFO: renamed from: getLambda-18$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7618getLambda18$app_debug() {
        return f1030lambda18;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7619getLambda2$app_debug() {
        return f1031lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7620getLambda3$app_debug() {
        return f1032lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7621getLambda4$app_debug() {
        return f1033lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7622getLambda5$app_debug() {
        return f1034lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7623getLambda6$app_debug() {
        return f1035lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7624getLambda7$app_debug() {
        return f1036lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7625getLambda8$app_debug() {
        return f1037lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7626getLambda9$app_debug() {
        return f1038lambda9;
    }
}
