package com.videshkarmakar.loop.p006ui.page.settings.network;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.database.objects.CookieProfile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.ComposableSingletons$CookieProfilesPageKt$lambda-19$1, reason: invalid class name */
/* JADX INFO: compiled from: CookieProfilesPage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m195d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ComposableSingletons$CookieProfilesPageKt$lambda19$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$CookieProfilesPageKt$lambda19$1 INSTANCE = new ComposableSingletons$CookieProfilesPageKt$lambda19$1();

    ComposableSingletons$CookieProfilesPageKt$lambda19$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformation($composer, "C503@20693L54,517@21223L25,506@20756L502:CookieProfilesPage.kt#sffru");
        if (($changed & 11) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(926352079, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.network.ComposableSingletons$CookieProfilesPageKt.lambda-19.<anonymous> (CookieProfilesPage.kt:503)");
        }
        $composer.startReplaceGroup(-1676777111);
        ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState isCookiesEnabled$delegate = (MutableState) value$iv;
        $composer.endReplaceGroup();
        List $this$invoke_u24lambda_u244 = new ArrayList();
        for (int i = 0; i < 4; i++) {
            int it = i;
            $this$invoke_u24lambda_u244.add(new CookieProfile(it, "https://www.example" + it + ".com", ""));
        }
        Unit unit = Unit.INSTANCE;
        boolean zInvoke$lambda$1 = invoke$lambda$1(isCookiesEnabled$delegate);
        $composer.startReplaceGroup(-1676776581);
        ComposerKt.sourceInformation($composer, "CC(remember):CookieProfilesPage.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new Function1<Boolean, Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.ComposableSingletons$CookieProfilesPageKt$lambda-19$1$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean it2) {
                    ComposableSingletons$CookieProfilesPageKt$lambda19$1.invoke$lambda$2(isCookiesEnabled$delegate, it2);
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        $composer.endReplaceGroup();
        CookieProfilesPageKt.CookiesQuickSettingsDialog(null, null, $this$invoke_u24lambda_u244, null, zInvoke$lambda$1, (Function1) value$iv2, $composer, 197120, 11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
