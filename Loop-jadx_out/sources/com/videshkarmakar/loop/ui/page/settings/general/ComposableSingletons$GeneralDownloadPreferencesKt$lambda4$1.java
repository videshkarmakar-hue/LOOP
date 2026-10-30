package com.videshkarmakar.loop.ui.page.settings.general;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.DoneAllKt;
import androidx.compose.material.icons.outlined.RemoveDoneKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.R;
import com.videshkarmakar.loop.ui.component.PreferenceItemsKt;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-4$1, reason: invalid class name */
/* JADX INFO: compiled from: GeneralDownloadPreferences.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1 INSTANCE = new ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1();

    ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$0(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C281@13817L12,282@13875L54,283@13969L113,288@14294L259,282@13850L704:GeneralDownloadPreferences.kt#wlpkv4");
        if (($changed & 81) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-219682725, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt.lambda-4.<anonymous> (GeneralDownloadPreferences.kt:281)");
            }
            $composer.startReplaceGroup(-2044908879);
            ComposerKt.sourceInformation($composer, "CC12@469L46:Ext.kt#x6o9ax");
            $composer.startReplaceGroup(-204592788);
            ComposerKt.sourceInformation($composer, "CC(remember):Ext.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.CONFIGURE, false, 1, null)), null, 2, null);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            final MutableState configureBeforeDownload$delegate = (MutableState) value$iv$iv;
            $composer.endReplaceGroup();
            $composer.endReplaceGroup();
            String strStringResource = StringResources_androidKt.stringResource(R.string.settings_before_download, $composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.settings_before_download_desc, $composer, 0);
            ImageVector doneAll = invoke$lambda$0(configureBeforeDownload$delegate) ? DoneAllKt.getDoneAll(Icons.Outlined.INSTANCE) : RemoveDoneKt.getRemoveDone(Icons.Outlined.INSTANCE);
            boolean zInvoke$lambda$0 = invoke$lambda$0(configureBeforeDownload$delegate);
            $composer.startReplaceGroup(-1318393555);
            ComposerKt.sourceInformation($composer, "CC(remember):GeneralDownloadPreferences.kt#9igjgp");
            boolean invalid$iv = $composer.changed(configureBeforeDownload$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.general.ComposableSingletons$GeneralDownloadPreferencesKt$lambda-4$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1.invoke$lambda$1(configureBeforeDownload$delegate, !ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1.invoke$lambda$0(configureBeforeDownload$delegate));
                        PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.CONFIGURE, ComposableSingletons$GeneralDownloadPreferencesKt$lambda4$1.invoke$lambda$0(configureBeforeDownload$delegate));
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, doneAll, false, zInvoke$lambda$0, null, (Function0) value$iv, $composer, 0, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
