package com.videshkarmakar.loop.p006ui.page;

import android.content.Context;
import android.os.Build;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.res.StringResources_androidKt;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.util.ToastUtil;
import com.videshkarmakar.loop.util.UpdateUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: UpdateDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a#\u0010\u0003\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aA\u0010\t\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u000fX\u008a\u0084\u0002"}, m195d2 = {"Preview", "", "(Landroidx/compose/runtime/Composer;I)V", "UpdateDialog", "onDismissRequest", "Lkotlin/Function0;", "latestRelease", "Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;", "(Lkotlin/jvm/functions/Function0;Lcom/videshkarmakar/loop/util/UpdateUtil$LatestRelease;Landroidx/compose/runtime/Composer;I)V", "UpdateDialogImpl", "title", "", "onConfirmUpdate", "releaseNote", "downloadStatus", "Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lcom/videshkarmakar/loop/util/UpdateUtil$DownloadStatus;Landroidx/compose/runtime/Composer;I)V", "app_debug", "currentDownloadStatus", "b", "", NotificationCompat.CATEGORY_STATUS}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UpdateDialogKt {
    public static final void UpdateDialog(final Function0<Unit> onDismissRequest, final UpdateUtil.LatestRelease latestRelease, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(latestRelease, "latestRelease");
        Composer $composer2 = $composer.startRestartGroup(-848190433);
        ComposerKt.sourceInformation($composer2, "C(UpdateDialog)P(1)41@1613L90,42@1735L7,44@1760L24,45@1789L1159:UpdateDialog.kt#hmxj0r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-848190433, $changed, -1, "com.videshkarmakar.loop.ui.page.UpdateDialog (UpdateDialog.kt:40)");
        }
        $composer2.startReplaceGroup(-1547829063);
        ComposerKt.sourceInformation($composer2, "CC(remember):UpdateDialog.kt#9igjgp");
        Object it$iv = $composer2.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            UpdateUtil.DownloadStatus.NotYet notYet = UpdateUtil.DownloadStatus.NotYet.INSTANCE;
            Intrinsics.checkNotNull(notYet, "null cannot be cast to non-null type com.videshkarmakar.loop.util.UpdateUtil.DownloadStatus");
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(notYet, null, 2, null);
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final MutableState currentDownloadStatus$delegate = (MutableState) value$iv;
        $composer2.endReplaceGroup();
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer2.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        final Context context = (Context) objConsume;
        ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer2.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer2);
        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd($composer2);
        UpdateDialogImpl(onDismissRequest, String.valueOf(latestRelease.getName()), new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.UpdateDialogKt$UpdateDialog$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: UpdateDialog.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.UpdateDialogKt$UpdateDialog$1$1", m210f = "UpdateDialog.kt", m211i = {}, m212l = {52, 53}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Context $context;
                final /* synthetic */ MutableState<UpdateUtil.DownloadStatus> $currentDownloadStatus$delegate;
                final /* synthetic */ UpdateUtil.LatestRelease $latestRelease;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(UpdateUtil.LatestRelease latestRelease, MutableState<UpdateUtil.DownloadStatus> mutableState, Context context, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$latestRelease = latestRelease;
                    this.$currentDownloadStatus$delegate = mutableState;
                    this.$context = context;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$latestRelease, this.$currentDownloadStatus$delegate, this.$context, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:21:0x0062 A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:22:0x0063  */
                /* JADX WARN: Code duplicated, block: B:32:0x008b  */
                /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v10 */
                /* JADX WARN: Type inference failed for: r0v11 */
                /* JADX WARN: Type inference failed for: r0v12 */
                /* JADX WARN: Type inference failed for: r0v2 */
                /* JADX WARN: Type inference failed for: r0v3 */
                /* JADX WARN: Type inference failed for: r0v4, types: [com.videshkarmakar.loop.ui.page.UpdateDialogKt$UpdateDialog$1$1] */
                /* JADX WARN: Type inference failed for: r0v5 */
                /* JADX WARN: Type inference failed for: r0v6 */
                /* JADX WARN: Type inference failed for: r0v7 */
                /* JADX WARN: Type inference failed for: r0v8 */
                /* JADX WARN: Type inference failed for: r0v9 */
                /* JADX WARN: Type inference failed for: r10v0 */
                /* JADX WARN: Type inference failed for: r1v0, types: [int] */
                /* JADX WARN: Type inference failed for: r1v1 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Throwable th;
                    ?? r0;
                    Object objM7693constructorimpl;
                    ?? r1;
                    Context context;
                    MutableState<UpdateUtil.DownloadStatus> mutableState;
                    Throwable thM7696exceptionOrNullimpl;
                    int i;
                    final MutableState<UpdateUtil.DownloadStatus> mutableState2;
                    Object obj2;
                    AnonymousClass1 anonymousClass1;
                    FlowCollector flowCollector;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    obj = this.label;
                    try {
                        switch (obj) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                UpdateUtil.LatestRelease latestRelease = this.$latestRelease;
                                MutableState<UpdateUtil.DownloadStatus> mutableState3 = this.$currentDownloadStatus$delegate;
                                Result.Companion companion = Result.INSTANCE;
                                i = 0;
                                UpdateUtil updateUtil = UpdateUtil.INSTANCE;
                                this.L$0 = mutableState3;
                                this.label = 1;
                                Object objDownloadApk$default = UpdateUtil.downloadApk$default(updateUtil, null, latestRelease, this, 1, null);
                                if (objDownloadApk$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutableState2 = mutableState3;
                                obj2 = objDownloadApk$default;
                                anonymousClass1 = this;
                                try {
                                    flowCollector = new FlowCollector() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt$UpdateDialog$1$1$1$1
                                        @Override // kotlinx.coroutines.flow.FlowCollector
                                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                            return emit((UpdateUtil.DownloadStatus) value, (Continuation<? super Unit>) $completion);
                                        }

                                        public final Object emit(UpdateUtil.DownloadStatus downloadStatus, Continuation<? super Unit> continuation) {
                                            UpdateDialogKt.UpdateDialog$lambda$2(mutableState2, downloadStatus);
                                            if ((downloadStatus instanceof UpdateUtil.DownloadStatus.Finished) && Build.VERSION.SDK_INT >= 23) {
                                                UpdateUtil.m7682installLatestApkIoAF18A$default(UpdateUtil.INSTANCE, null, 1, null);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.label = 2;
                                    if (((Flow) obj2).collect(flowCollector, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    r0 = anonymousClass1;
                                    objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
                                    r1 = r0;
                                    context = r1.$context;
                                    mutableState = r1.$currentDownloadStatus$delegate;
                                    thM7696exceptionOrNullimpl = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
                                    if (thM7696exceptionOrNullimpl == null) {
                                        return Unit.INSTANCE;
                                    }
                                    thM7696exceptionOrNullimpl.printStackTrace();
                                    UpdateDialogKt.UpdateDialog$lambda$2(mutableState, UpdateUtil.DownloadStatus.NotYet.INSTANCE);
                                    ToastUtil toastUtil = ToastUtil.INSTANCE;
                                    String string = context.getString(C3070R.string.app_update_failed);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                    toastUtil.makeToastSuspend(string);
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    r0 = anonymousClass1;
                                    th = th2;
                                    Result.Companion companion2 = Result.INSTANCE;
                                    objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
                                    r1 = r0;
                                }
                                break;
                            case 1:
                                mutableState2 = (MutableState) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                i = 0;
                                anonymousClass1 = this;
                                obj2 = obj;
                                flowCollector = new FlowCollector() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt$UpdateDialog$1$1$1$1
                                    @Override // kotlinx.coroutines.flow.FlowCollector
                                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                        return emit((UpdateUtil.DownloadStatus) value, (Continuation<? super Unit>) $completion);
                                    }

                                    public final Object emit(UpdateUtil.DownloadStatus downloadStatus, Continuation<? super Unit> continuation) {
                                        UpdateDialogKt.UpdateDialog$lambda$2(mutableState2, downloadStatus);
                                        if ((downloadStatus instanceof UpdateUtil.DownloadStatus.Finished) && Build.VERSION.SDK_INT >= 23) {
                                            UpdateUtil.m7682installLatestApkIoAF18A$default(UpdateUtil.INSTANCE, null, 1, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                anonymousClass1.L$0 = null;
                                anonymousClass1.label = 2;
                                if (((Flow) obj2).collect(flowCollector, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                r0 = anonymousClass1;
                                objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
                                r1 = r0;
                                context = r1.$context;
                                mutableState = r1.$currentDownloadStatus$delegate;
                                thM7696exceptionOrNullimpl = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
                                if (thM7696exceptionOrNullimpl == null) {
                                    return Unit.INSTANCE;
                                }
                                thM7696exceptionOrNullimpl.printStackTrace();
                                UpdateDialogKt.UpdateDialog$lambda$2(mutableState, UpdateUtil.DownloadStatus.NotYet.INSTANCE);
                                ToastUtil toastUtil2 = ToastUtil.INSTANCE;
                                String string2 = context.getString(C3070R.string.app_update_failed);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                toastUtil2.makeToastSuspend(string2);
                                return Unit.INSTANCE;
                            case 2:
                                r0 = this;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r0 = r0;
                                    objM7693constructorimpl = Result.m7693constructorimpl(Unit.INSTANCE);
                                    r1 = r0;
                                    break;
                                } catch (Throwable th3) {
                                    th = th3;
                                    Result.Companion companion3 = Result.INSTANCE;
                                    objM7693constructorimpl = Result.m7693constructorimpl(ResultKt.createFailure(th));
                                    r1 = r0;
                                }
                                context = r1.$context;
                                mutableState = r1.$currentDownloadStatus$delegate;
                                thM7696exceptionOrNullimpl = Result.m7696exceptionOrNullimpl(objM7693constructorimpl);
                                if (thM7696exceptionOrNullimpl == null) {
                                    return Unit.INSTANCE;
                                }
                                thM7696exceptionOrNullimpl.printStackTrace();
                                UpdateDialogKt.UpdateDialog$lambda$2(mutableState, UpdateUtil.DownloadStatus.NotYet.INSTANCE);
                                ToastUtil toastUtil3 = ToastUtil.INSTANCE;
                                String string3 = context.getString(C3070R.string.app_update_failed);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                toastUtil3.makeToastSuspend(string3);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Throwable th4) {
                        ?? r10 = obj;
                        th = th4;
                        r0 = r10;
                    }
                }
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new AnonymousClass1(latestRelease, currentDownloadStatus$delegate, context, null), 2, null);
            }
        }, String.valueOf(latestRelease.getBody()), UpdateDialog$lambda$1(currentDownloadStatus$delegate), $composer2, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialog.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    UpdateDialogKt.UpdateDialog(onDismissRequest, latestRelease, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final UpdateUtil.DownloadStatus UpdateDialog$lambda$1(MutableState<UpdateUtil.DownloadStatus> mutableState) {
        MutableState<UpdateUtil.DownloadStatus> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void UpdateDialog$lambda$2(MutableState<UpdateUtil.DownloadStatus> mutableState, UpdateUtil.DownloadStatus value) {
        mutableState.setValue(value);
    }

    public static final void UpdateDialogImpl(final Function0<Unit> onDismissRequest, final String title, final Function0<Unit> onConfirmUpdate, final String releaseNote, final UpdateUtil.DownloadStatus downloadStatus, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onConfirmUpdate, "onConfirmUpdate");
        Intrinsics.checkNotNullParameter(releaseNote, "releaseNote");
        Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
        Composer $composer2 = $composer.startRestartGroup(-533157377);
        ComposerKt.sourceInformation($composer2, "C(UpdateDialogImpl)P(2,4,1,3)84@3304L488,96@3810L121,83@3212L15,98@3940L128,81@3152L917:UpdateDialog.kt#hmxj0r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(title) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(onConfirmUpdate) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(releaseNote) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(downloadStatus) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-533157377, $dirty2, -1, "com.videshkarmakar.loop.ui.page.UpdateDialogImpl (UpdateDialog.kt:80)");
            }
            AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialogImpl.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, ComposableLambdaKt.rememberComposableLambda(-1882376009, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialogImpl.2
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
                    ComposerKt.sourceInformation($composer3, "C87@3353L80,87@3435L347,86@3319L463:UpdateDialog.kt#hmxj0r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1882376009, $changed2, -1, "com.videshkarmakar.loop.ui.page.UpdateDialogImpl.<anonymous> (UpdateDialog.kt:86)");
                        }
                        $composer3.startReplaceGroup(-767163546);
                        ComposerKt.sourceInformation($composer3, "CC(remember):UpdateDialog.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(downloadStatus) | $composer3.changed(onConfirmUpdate);
                        final UpdateUtil.DownloadStatus downloadStatus2 = downloadStatus;
                        final Function0<Unit> function0 = onConfirmUpdate;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt$UpdateDialogImpl$2$1$1
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
                                    if (downloadStatus2 instanceof UpdateUtil.DownloadStatus.Progress) {
                                        return;
                                    }
                                    function0.invoke();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer3.endReplaceGroup();
                        final UpdateUtil.DownloadStatus downloadStatus3 = downloadStatus;
                        ButtonKt.Button((Function0) value$iv, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1735803591, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialogImpl.2.2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope Button, Composer $composer4, int $changed3) {
                                String strStringResource;
                                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                                ComposerKt.sourceInformation($composer4, "C88@3453L315:UpdateDialog.kt#hmxj0r");
                                if (($changed3 & 81) != 16 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1735803591, $changed3, -1, "com.videshkarmakar.loop.ui.page.UpdateDialogImpl.<anonymous>.<anonymous> (UpdateDialog.kt:88)");
                                    }
                                    UpdateUtil.DownloadStatus downloadStatus4 = downloadStatus3;
                                    $composer4.startReplaceGroup(-245040507);
                                    ComposerKt.sourceInformation($composer4, "91@3630L31");
                                    if (downloadStatus4 instanceof UpdateUtil.DownloadStatus.Progress) {
                                        strStringResource = ((UpdateUtil.DownloadStatus.Progress) downloadStatus3).getPercent() + " %";
                                    } else {
                                        strStringResource = StringResources_androidKt.stringResource(C3070R.string.update, $composer4, 0);
                                    }
                                    $composer4.endReplaceGroup();
                                    TextKt.m2817Text4IGK_g(strStringResource, AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, null, null, 3, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(1489423861, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialogImpl.3
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
                    ComposerKt.sourceInformation($composer3, "C97@3824L97:UpdateDialog.kt#hmxj0r");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1489423861, $changed2, -1, "com.videshkarmakar.loop.ui.page.UpdateDialogImpl.<anonymous> (UpdateDialog.kt:97)");
                    }
                    ButtonKt.OutlinedButton(onDismissRequest, null, false, null, null, null, null, null, null, ComposableSingletons$UpdateDialogKt.INSTANCE.m7316getLambda1$app_debug(), $composer3, 805306368, HttpStatusCodesKt.HTTP_NOT_EXTENDED);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableSingletons$UpdateDialogKt.INSTANCE.m7317getLambda2$app_debug(), ComposableLambdaKt.rememberComposableLambda(566256435, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialogImpl.4
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
                    ComposerKt.sourceInformation($composer3, "C83@3214L11:UpdateDialog.kt#hmxj0r");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(566256435, $changed2, -1, "com.videshkarmakar.loop.ui.page.UpdateDialogImpl.<anonymous> (UpdateDialog.kt:83)");
                    }
                    TextKt.m2817Text4IGK_g(title, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-2042810926, true, new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialogImpl.5
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
                    ComposerKt.sourceInformation($composer3, "C99@3985L21,99@3954L104:UpdateDialog.kt#hmxj0r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2042810926, $changed2, -1, "com.videshkarmakar.loop.ui.page.UpdateDialogImpl.<anonymous> (UpdateDialog.kt:99)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                        String str = releaseNote;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -245039959, "C100@4027L17:UpdateDialog.kt#hmxj0r");
                        TextKt.m2817Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, 1797174, 0, 16260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.UpdateDialogImpl.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    UpdateDialogKt.UpdateDialogImpl(onDismissRequest, title, onConfirmUpdate, releaseNote, downloadStatus, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Preview(Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer2 = $composer.startRestartGroup(-219598070);
        ComposerKt.sourceInformation($composer2, "C(Preview)108@4131L46,111@4238L75,115@4319L281,126@4625L29,129@4705L13,131@4773L12,128@4660L205:UpdateDialog.kt#hmxj0r");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-219598070, $changed, -1, "com.videshkarmakar.loop.ui.page.Preview (UpdateDialog.kt:107)");
            }
            $composer2.startReplaceGroup(-575352962);
            ComposerKt.sourceInformation($composer2, "CC(remember):UpdateDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState b$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-575352855);
            ComposerKt.sourceInformation($composer2, "CC(remember):UpdateDialog.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = StateFlowKt.MutableStateFlow(UpdateUtil.DownloadStatus.NotYet.INSTANCE);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            MutableStateFlow flow = (MutableStateFlow) value$iv2;
            $composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(Boolean.valueOf(Preview$lambda$4(b$delegate)), new C33341(flow, b$delegate, null), $composer2, 64);
            State status$delegate = FlowExtKt.collectAsStateWithLifecycle(flow, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 8, 7);
            $composer2.startReplaceGroup(-575352388);
            ComposerKt.sourceInformation($composer2, "CC(remember):UpdateDialog.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt$Preview$2$1
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
                        UpdateDialogKt.Preview$lambda$5(b$delegate, false);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            Function0 function0 = (Function0) value$iv3;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(-575352320);
            ComposerKt.sourceInformation($composer2, "CC(remember):UpdateDialog.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new Function0<Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt$Preview$3$1
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
                        UpdateDialogKt.Preview$lambda$5(b$delegate, true);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer2.endReplaceGroup();
            UpdateDialogImpl(function0, "v1.12.0", (Function0) value$iv4, "ReleaseNoteHTML", Preview$lambda$7(status$delegate), $composer2, 3510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.videshkarmakar.loop.ui.page.UpdateDialogKt.Preview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    UpdateDialogKt.Preview(composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Preview$lambda$4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Preview$lambda$5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.UpdateDialogKt$Preview$1 */
    /* JADX INFO: compiled from: UpdateDialog.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.UpdateDialogKt$Preview$1", m210f = "UpdateDialog.kt", m211i = {}, m212l = {120}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C33341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $b$delegate;
        final /* synthetic */ MutableStateFlow<UpdateUtil.DownloadStatus> $flow;
        int I$0;
        int I$1;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C33341(MutableStateFlow<UpdateUtil.DownloadStatus> mutableStateFlow, MutableState<Boolean> mutableState, Continuation<? super C33341> continuation) {
            super(2, continuation);
            this.$flow = mutableStateFlow;
            this.$b$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C33341(this.$flow, this.$b$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C33341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0037  */
        /* JADX WARN: Code duplicated, block: B:16:0x0063 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:17:0x0064  */
        /* JADX WARN: Code duplicated, block: B:25:? A[LOOP:0: B:12:0x003b->B:25:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0064 -> B:18:0x0065). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 1
                switch(r1) {
                    case 0: goto L20;
                    case 1: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L12:
                r1 = r13
                r3 = 0
                int r4 = r1.I$1
                int r5 = r1.I$0
                java.lang.Object r6 = r1.L$0
                kotlinx.coroutines.flow.MutableStateFlow r6 = (kotlinx.coroutines.flow.MutableStateFlow) r6
                kotlin.ResultKt.throwOnFailure(r14)
                goto L65
            L20:
                kotlin.ResultKt.throwOnFailure(r14)
                r1 = r13
                androidx.compose.runtime.MutableState<java.lang.Boolean> r3 = r1.$b$delegate
                boolean r3 = com.videshkarmakar.loop.p006ui.page.UpdateDialogKt.access$Preview$lambda$4(r3)
                if (r3 == 0) goto L68
                kotlinx.coroutines.flow.MutableStateFlow<com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus> r3 = r1.$flow
                r4 = 100
                r5 = 0
                r6 = r3
                r4 = 0
                r5 = 100
            L35:
                if (r4 >= r5) goto L80
                r3 = r4
                r7 = 0
                r8 = r6
                r9 = 0
            L3b:
                java.lang.Object r10 = r8.getValue()
                r11 = r10
                com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus r11 = (com.videshkarmakar.loop.util.UpdateUtil.DownloadStatus) r11
                r11 = 0
                com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus$Progress r12 = new com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus$Progress
                r12.<init>(r3)
                com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus r12 = (com.videshkarmakar.loop.util.UpdateUtil.DownloadStatus) r12
                r11 = r12
                boolean r12 = r8.compareAndSet(r10, r11)
                if (r12 == 0) goto L3b
            L53:
                r1.L$0 = r6
                r1.I$0 = r5
                r1.I$1 = r4
                r1.label = r2
                r8 = 50
                java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r8, r1)
                if (r3 != r0) goto L64
                return r0
            L64:
                r3 = r7
            L65:
                int r4 = r4 + r2
                goto L35
            L68:
                kotlinx.coroutines.flow.MutableStateFlow<com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus> r0 = r1.$flow
                r2 = 0
            L6b:
                java.lang.Object r3 = r0.getValue()
                r4 = r3
                com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus r4 = (com.videshkarmakar.loop.util.UpdateUtil.DownloadStatus) r4
                r4 = 0
                com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus$NotYet r5 = com.videshkarmakar.loop.util.UpdateUtil.DownloadStatus.NotYet.INSTANCE
                com.videshkarmakar.loop.util.UpdateUtil$DownloadStatus r5 = (com.videshkarmakar.loop.util.UpdateUtil.DownloadStatus) r5
                r4 = r5
                boolean r5 = r0.compareAndSet(r3, r4)
                if (r5 == 0) goto L6b
            L80:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.p006ui.page.UpdateDialogKt.C33341.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private static final UpdateUtil.DownloadStatus Preview$lambda$7(State<? extends UpdateUtil.DownloadStatus> state) {
        Object thisObj$iv = state.getValue();
        return (UpdateUtil.DownloadStatus) thisObj$iv;
    }
}
