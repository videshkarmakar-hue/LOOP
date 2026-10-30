package com.videshkarmakar.loop.ui.page.settings.command;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AssignmentReturnKt;
import androidx.compose.material.icons.outlined.ContentPasteGoKt;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material.icons.outlined.DeleteSweepKt;
import androidx.compose.material.icons.outlined.HelpOutlineKt;
import androidx.compose.material.icons.outlined.MoreVertKt;
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

/* JADX INFO: compiled from: TemplateListPage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$TemplateListPageKt {
    public static final ComposableSingletons$TemplateListPageKt INSTANCE = new ComposableSingletons$TemplateListPageKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f270lambda1 = ComposableLambdaKt.composableLambdaInstance(-150203103, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C159@6965L100,157@6848L239:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-150203103, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-1.<anonymous> (TemplateListPage.kt:157)");
                }
                IconKt.m2044Iconww6aTOc(HelpOutlineKt.getHelpOutline(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.how_does_it_work, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function2<Composer, Integer, Unit> f273lambda2 = ComposableLambdaKt.composableLambdaInstance(-1144324000, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C171@7459L112,170@7375L226:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1144324000, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-2.<anonymous> (TemplateListPage.kt:170)");
                }
                IconKt.m2044Iconww6aTOc(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.show_more_actions, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function2<Composer, Integer, Unit> f274lambda3 = ComposableLambdaKt.composableLambdaInstance(-246751384, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C184@8068L44,184@8063L50:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-246751384, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-3.<anonymous> (TemplateListPage.kt:184)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.export_to_clipboard, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f275lambda4 = ComposableLambdaKt.composableLambdaInstance(-2042926997, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C180@7879L111:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2042926997, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-4.<anonymous> (TemplateListPage.kt:180)");
                }
                IconKt.m2044Iconww6aTOc(ContentPasteGoKt.getContentPasteGo(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f276lambda5 = ComposableLambdaKt.composableLambdaInstance(-1092517089, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C204@9139L46,204@9134L52:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1092517089, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-5.<anonymous> (TemplateListPage.kt:204)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.import_from_clipboard, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f277lambda6 = ComposableLambdaKt.composableLambdaInstance(-640428190, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C200@8948L113:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-640428190, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-6.<anonymous> (TemplateListPage.kt:200)");
                }
                IconKt.m2044Iconww6aTOc(AssignmentReturnKt.getAssignmentReturn(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
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
    public static Function2<Composer, Integer, Unit> f278lambda7 = ComposableLambdaKt.composableLambdaInstance(-1922123734, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C286@13137L119,284@13001L285:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1922123734, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-7.<anonymous> (TemplateListPage.kt:284)");
                }
                IconKt.m2044Iconww6aTOc(ContentPasteGoKt.getContentPasteGo(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.export_to_clipboard, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function2<Composer, Integer, Unit> f279lambda8 = ComposableLambdaKt.composableLambdaInstance(-1465862637, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C300@13794L36,298@13661L199:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1465862637, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-8.<anonymous> (TemplateListPage.kt:298)");
                }
                IconKt.m2044Iconww6aTOc(DeleteSweepKt.getDeleteSweep(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.remove, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function2<Composer, Integer, Unit> f280lambda9 = ComposableLambdaKt.composableLambdaInstance(240886630, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C368@16577L33:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(240886630, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-9.<anonymous> (TemplateListPage.kt:368)");
            }
            IconKt.m2044Iconww6aTOc(DeleteKt.getDelete(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f271lambda10 = ComposableLambdaKt.composableLambdaInstance(1188053573, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C369@16641L40,369@16636L46:TemplateListPage.kt#fk5gu5");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1188053573, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-10.<anonymous> (TemplateListPage.kt:369)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.remove_template, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f272lambda11 = ComposableLambdaKt.composableLambdaInstance(198413503, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C411@18125L40,411@18113L53:TemplateListPage.kt#fk5gu5");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(198413503, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.command.ComposableSingletons$TemplateListPageKt.lambda-11.<anonymous> (TemplateListPage.kt:411)");
            }
            TextKt.m2569Text4IGK_g(StringResources_androidKt.stringResource(R.string.learn_more, $composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7322getLambda1$app_debug() {
        return f270lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7323getLambda10$app_debug() {
        return f271lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7324getLambda11$app_debug() {
        return f272lambda11;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7325getLambda2$app_debug() {
        return f273lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7326getLambda3$app_debug() {
        return f274lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7327getLambda4$app_debug() {
        return f275lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7328getLambda5$app_debug() {
        return f276lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7329getLambda6$app_debug() {
        return f277lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7330getLambda7$app_debug() {
        return f278lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7331getLambda8$app_debug() {
        return f279lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7332getLambda9$app_debug() {
        return f280lambda9;
    }
}
