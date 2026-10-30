package com.videshkarmakar.loop.ui.page;

import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.Downloader;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.PreferenceUtilKt;
import com.yausername.youtubedl_android.YoutubeDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HomeEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$3$1", f = "HomeEntry.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
final class HomeEntryKt$HomeEntry$2$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Downloader.State> $downloaderState$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeEntryKt$HomeEntry$2$3$1(State<? extends Downloader.State> state, Continuation<? super HomeEntryKt$HomeEntry$2$3$1> continuation) {
        super(2, continuation);
        this.$downloaderState$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeEntryKt$HomeEntry$2$3$1 homeEntryKt$HomeEntry$2$3$1 = new HomeEntryKt$HomeEntry$2$3$1(this.$downloaderState$delegate, continuation);
        homeEntryKt$HomeEntry$2$3$1.L$0 = obj;
        return homeEntryKt$HomeEntry$2$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeEntryKt$HomeEntry$2$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object objM7557constructorimpl;
        Object $result3;
        Object $result4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!(HomeEntryKt.AnonymousClass2.invoke$lambda$1(this.$downloaderState$delegate) instanceof Downloader.State.Idle)) {
                        return Unit.INSTANCE;
                    }
                    if (!PreferenceUtil.getBoolean$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_AUTO_UPDATE, false, 1, null)) {
                        if (PreferenceUtil.getString$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_VERSION, null, 1, null).length() > 0) {
                            return Unit.INSTANCE;
                        }
                    }
                    if (!PreferenceUtil.INSTANCE.isNetworkAvailableForDownload()) {
                        return Unit.INSTANCE;
                    }
                    long lastUpdateTime = PreferenceUtil.getLong$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_UPDATE_TIME, 0L, 1, null);
                    long currentTime = System.currentTimeMillis();
                    if (currentTime < PreferenceUtil.getLong$default(PreferenceUtil.INSTANCE, PreferenceUtilKt.YT_DLP_UPDATE_INTERVAL, 0L, 1, null) + lastUpdateTime) {
                        return Unit.INSTANCE;
                    }
                    Result.Companion companion = Result.INSTANCE;
                    Downloader.INSTANCE.updateState(Downloader.State.Updating.INSTANCE);
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    HomeEntryKt$HomeEntry$2$3$1$1$1 homeEntryKt$HomeEntry$2$3$1$1$1 = new HomeEntryKt$HomeEntry$2$3$1$1$1(null);
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(io2, homeEntryKt$HomeEntry$2$3$1$1$1, this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result3 = $result;
                    $result4 = objWithContext;
                    break;
                    break;
                case 1:
                    $result4 = $result;
                    ResultKt.throwOnFailure($result4);
                    $result3 = $result4;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                $result2 = (YoutubeDL.UpdateStatus) $result4;
                objM7557constructorimpl = Result.m7557constructorimpl($result2);
            } catch (Throwable th) {
                th = th;
                $result2 = $result3;
                Object $result5 = Result.INSTANCE;
                objM7557constructorimpl = Result.m7557constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Throwable it = Result.m7560exceptionOrNullimpl(objM7557constructorimpl);
        if (it != null) {
            it.printStackTrace();
        }
        Downloader.INSTANCE.updateState(Downloader.State.Idle.INSTANCE);
        return Unit.INSTANCE;
    }
}
