package com.videshkarmakar.loop.p006ui.page.download;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.p006ui.component.DialogsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MeteredNetworkDialog.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m195d2 = {"MeteredNetworkDialog", "", "onDismissRequest", "Lkotlin/Function0;", "onAllowOnceConfirm", "onAllowAlwaysConfirm", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MeteredNetworkDialogKt {
    public static final void MeteredNetworkDialog(Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function3;
        Function0<Unit> function4;
        Function0<Unit> function5;
        Function0<Unit> function6;
        Function0<Unit> function7;
        Composer $composer2 = $composer.startRestartGroup(1769286645);
        ComposerKt.sourceInformation($composer2, "C(MeteredNetworkDialog)P(2,1)39@1510L643,24@925L1235:MeteredNetworkDialog.kt#y3famj");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function3 = function0;
        } else if (($changed & 14) == 0) {
            function3 = function0;
            $dirty |= $composer2.changedInstance(function3) ? 4 : 2;
        } else {
            function3 = function0;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            function4 = function1;
        } else if (($changed & 112) == 0) {
            function4 = function1;
            $dirty |= $composer2.changedInstance(function4) ? 32 : 16;
        } else {
            function4 = function1;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function5 = function2;
        } else if (($changed & 896) == 0) {
            function5 = function2;
            $dirty |= $composer2.changedInstance(function5) ? 256 : 128;
        } else {
            function5 = function2;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            function7 = function4;
            function6 = function3;
        } else {
            final C35161 c35161 = i2 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt.MeteredNetworkDialog.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function3;
            final C35172 c35172 = i3 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt.MeteredNetworkDialog.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function4;
            final C35183 c35183 = i4 != 0 ? new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt.MeteredNetworkDialog.3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            } : function5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1769286645, $dirty, -1, "com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialog (MeteredNetworkDialog.kt:23)");
            }
            DialogsKt.m7299LoopDialogVariantq4k6nM(c35161, null, ComposableLambdaKt.rememberComposableLambda(-203794847, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt.MeteredNetworkDialog.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    Object value$iv2;
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "C41@1572L42,43@1669L54,40@1524L199,47@1784L40,49@1882L52,46@1736L198,53@1995L40,55@2093L50,52@1947L196:MeteredNetworkDialog.kt#y3famj");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-203794847, $changed2, -1, "com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialog.<anonymous> (MeteredNetworkDialog.kt:40)");
                        }
                        String strStringResource = StringResources_androidKt.stringResource(C3070R.string.allow_always, $composer3, 0);
                        RoundedCornerShape topButtonShape = DialogsKt.getTopButtonShape();
                        $composer3.startReplaceGroup(1589379221);
                        ComposerKt.sourceInformation($composer3, "CC(remember):MeteredNetworkDialog.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(c35183);
                        final Function0<Unit> function8 = c35183;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt$MeteredNetworkDialog$4$1$1
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
                                    function8.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer3.endReplaceGroup();
                        DialogsKt.LoopDialogButtonVariant(null, topButtonShape, strStringResource, (Function0) value$iv, $composer3, 48, 1);
                        String strStringResource2 = StringResources_androidKt.stringResource(C3070R.string.allow_once, $composer3, 0);
                        RoundedCornerShape middleButtonShape = DialogsKt.getMiddleButtonShape();
                        $composer3.startReplaceGroup(1589379434);
                        ComposerKt.sourceInformation($composer3, "CC(remember):MeteredNetworkDialog.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(c35172);
                        final Function0<Unit> function9 = c35172;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt$MeteredNetworkDialog$4$2$1
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
                                    function9.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceGroup();
                        DialogsKt.LoopDialogButtonVariant(null, middleButtonShape, strStringResource2, (Function0) value$iv2, $composer3, 48, 1);
                        String strStringResource3 = StringResources_androidKt.stringResource(C3070R.string.dont_allow, $composer3, 0);
                        RoundedCornerShape bottomButtonShape = DialogsKt.getBottomButtonShape();
                        $composer3.startReplaceGroup(1589379645);
                        ComposerKt.sourceInformation($composer3, "CC(remember):MeteredNetworkDialog.kt#9igjgp");
                        boolean invalid$iv3 = $composer3.changed(c35161);
                        final Function0<Unit> function10 = c35161;
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt$MeteredNetworkDialog$4$3$1
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
                                    function10.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer3.endReplaceGroup();
                        DialogsKt.LoopDialogButtonVariant(null, bottomButtonShape, strStringResource3, (Function0) value$iv3, $composer3, 48, 1);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), ComposableSingletons$MeteredNetworkDialogKt.INSTANCE.m7375getLambda1$app_debug(), ComposableSingletons$MeteredNetworkDialogKt.INSTANCE.m7376getLambda2$app_debug(), null, null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, ($dirty & 14) | 28032, 0, 8162);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = c35161;
            function7 = c35172;
            function5 = c35183;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function8 = function6;
            final Function0<Unit> function9 = function7;
            final Function0<Unit> function10 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.download.MeteredNetworkDialogKt.MeteredNetworkDialog.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    MeteredNetworkDialogKt.MeteredNetworkDialog(function8, function9, function10, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
