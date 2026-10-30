package com.videshkarmakar.loop.ui.page.settings.network;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.SignalCellular4BarKt;
import androidx.compose.material.icons.outlined.SignalCellularConnectedNoInternet4BarKt;
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

/* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.ComposableSingletons$NetworkPreferencesKt$lambda-4$1, reason: invalid class name */
/* JADX INFO: compiled from: NetworkPreferences.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ComposableSingletons$NetworkPreferencesKt$lambda4$1 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$NetworkPreferencesKt$lambda4$1 INSTANCE = new ComposableSingletons$NetworkPreferencesKt$lambda4$1();

    ComposableSingletons$NetworkPreferencesKt$lambda4$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C116@5149L100,120@5320L47,121@5407L52,125@5745L302,119@5270L799:NetworkPreferences.kt#sffru");
        if (($changed & 81) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-710412783, $changed, -1, "com.videshkarmakar.loop.ui.page.settings.network.ComposableSingletons$NetworkPreferencesKt.lambda-4.<anonymous> (NetworkPreferences.kt:116)");
            }
            $composer.startReplaceGroup(-1815562660);
            ComposerKt.sourceInformation($composer, "CC(remember):NetworkPreferences.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(PreferenceUtil.INSTANCE.getValue(PreferenceUtilKt.CELLULAR_DOWNLOAD)), null, 2, null);
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState isDownloadWithCellularEnabled$delegate = (MutableState) value$iv;
            $composer.endReplaceGroup();
            String strStringResource = StringResources_androidKt.stringResource(R.string.download_with_cellular, $composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.download_with_cellular_desc, $composer, 0);
            ImageVector signalCellular4Bar = invoke$lambda$1(isDownloadWithCellularEnabled$delegate) ? SignalCellular4BarKt.getSignalCellular4Bar(Icons.Outlined.INSTANCE) : SignalCellularConnectedNoInternet4BarKt.getSignalCellularConnectedNoInternet4Bar(Icons.Outlined.INSTANCE);
            boolean zInvoke$lambda$1 = invoke$lambda$1(isDownloadWithCellularEnabled$delegate);
            $composer.startReplaceGroup(-1815562064);
            ComposerKt.sourceInformation($composer, "CC(remember):NetworkPreferences.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.settings.network.ComposableSingletons$NetworkPreferencesKt$lambda-4$1$1$1
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
                        ComposableSingletons$NetworkPreferencesKt$lambda4$1.invoke$lambda$2(isDownloadWithCellularEnabled$delegate, !ComposableSingletons$NetworkPreferencesKt$lambda4$1.invoke$lambda$1(isDownloadWithCellularEnabled$delegate));
                        PreferenceUtil.INSTANCE.updateValue(PreferenceUtilKt.CELLULAR_DOWNLOAD, ComposableSingletons$NetworkPreferencesKt$lambda4$1.invoke$lambda$1(isDownloadWithCellularEnabled$delegate));
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer.endReplaceGroup();
            PreferenceItemsKt.PreferenceSwitch(strStringResource, strStringResource2, signalCellular4Bar, false, zInvoke$lambda$1, null, (Function0) value$iv2, $composer, 1572864, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
