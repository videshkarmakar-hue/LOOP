package com.videshkarmakar.loop.ui.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ArrowBackKt;
import androidx.compose.material.icons.outlined.AddKt;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material.icons.outlined.ContentPasteKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IconButtons.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ComposableSingletons$IconButtonsKt {
    public static final ComposableSingletons$IconButtonsKt INSTANCE = new ComposableSingletons$IconButtonsKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f124lambda1 = ComposableLambdaKt.composableLambdaInstance(1105390745, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C33@1280L30,31@1221L99:IconButtons.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1105390745, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt.lambda-1.<anonymous> (IconButtons.kt:31)");
                }
                IconKt.m2044Iconww6aTOc(ContentPasteKt.getContentPaste(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.paste, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function2<Composer, Integer, Unit> f125lambda2 = ComposableLambdaKt.composableLambdaInstance(146157635, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C45@1566L58,43@1481L153:IconButtons.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(146157635, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt.lambda-2.<anonymous> (IconButtons.kt:43)");
                }
                IconKt.m2044Iconww6aTOc(AddKt.getAdd(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.add, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public static Function2<Composer, Integer, Unit> f126lambda3 = ComposableLambdaKt.composableLambdaInstance(-1117980205, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C58@1872L35,59@1942L11,55@1739L241:IconButtons.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1117980205, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt.lambda-3.<anonymous> (IconButtons.kt:55)");
                }
                IconKt.m2044Iconww6aTOc(CancelKt.getCancel(Icons.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.clear, $composer, 0), SizeKt.m665size3ABfNKs(Modifier.INSTANCE, Dp.m6553constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m1810getOnSurfaceVariant0d7_KjU(), $composer, 384, 0);
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
    public static Function2<Composer, Integer, Unit> f127lambda4 = ComposableLambdaKt.composableLambdaInstance(-1302790993, false, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C73@2296L29,71@2192L144:IconButtons.kt#g7nzpb");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1302790993, $changed, -1, "com.videshkarmakar.loop.ui.component.ComposableSingletons$IconButtonsKt.lambda-4.<anonymous> (IconButtons.kt:71)");
                }
                IconKt.m2044Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Outlined.INSTANCE), StringResources_androidKt.stringResource(R.string.back, $composer, 0), (Modifier) null, 0L, $composer, 0, 12);
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
    public final Function2<Composer, Integer, Unit> m7141getLambda1$app_debug() {
        return f124lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7142getLambda2$app_debug() {
        return f125lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7143getLambda3$app_debug() {
        return f126lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7144getLambda4$app_debug() {
        return f127lambda4;
    }
}
