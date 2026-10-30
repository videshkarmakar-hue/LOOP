package com.videshkarmakar.loop.p006ui.page;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.PreferenceUtil;
import com.videshkarmakar.loop.util.UpdateUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: HomeEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$4$1", m210f = "HomeEntry.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class HomeEntryKt$HomeEntry$2$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<UpdateUtil.LatestRelease> $latestRelease$delegate;
    final /* synthetic */ MutableState<Boolean> $showUpdateDialog$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeEntryKt$HomeEntry$2$4$1(MutableState<UpdateUtil.LatestRelease> mutableState, MutableState<Boolean> mutableState2, Continuation<? super HomeEntryKt$HomeEntry$2$4$1> continuation) {
        super(2, continuation);
        this.$latestRelease$delegate = mutableState;
        this.$showUpdateDialog$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeEntryKt$HomeEntry$2$4$1 homeEntryKt$HomeEntry$2$4$1 = new HomeEntryKt$HomeEntry$2$4$1(this.$latestRelease$delegate, this.$showUpdateDialog$delegate, continuation);
        homeEntryKt$HomeEntry$2$4$1.L$0 = obj;
        return homeEntryKt$HomeEntry$2$4$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeEntryKt$HomeEntry$2$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
                if (PreferenceUtil.INSTANCE.isNetworkAvailableForDownload() && PreferenceUtil.INSTANCE.isAutoUpdateEnabled()) {
                    BuildersKt__Builders_commonKt.launch$default($this$LaunchedEffect, Dispatchers.getIO(), null, new C33321(this.$latestRelease$delegate, this.$showUpdateDialog$delegate, null), 2, null);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$4$1$1 */
    /* JADX INFO: compiled from: HomeEntry.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.ui.page.HomeEntryKt$HomeEntry$2$4$1$1", m210f = "HomeEntry.kt", m211i = {}, m212l = {HttpStatusCodesKt.HTTP_PERM_REDIRECT}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C33321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<UpdateUtil.LatestRelease> $latestRelease$delegate;
        final /* synthetic */ MutableState<Boolean> $showUpdateDialog$delegate;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C33321(MutableState<UpdateUtil.LatestRelease> mutableState, MutableState<Boolean> mutableState2, Continuation<? super C33321> continuation) {
            super(2, continuation);
            this.$latestRelease$delegate = mutableState;
            this.$showUpdateDialog$delegate = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C33321 c33321 = new C33321(this.$latestRelease$delegate, this.$showUpdateDialog$delegate, continuation);
            c33321.L$0 = obj;
            return c33321;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C33321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x004b A[Catch: all -> 0x005a, TryCatch #2 {all -> 0x005a, blocks: (B:16:0x0047, B:18:0x004b, B:19:0x0055), top: B:35:0x0047 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C33321 c33321;
            MutableState<UpdateUtil.LatestRelease> mutableState;
            MutableState<Boolean> mutableState2;
            Throwable th;
            C33321 c33322;
            Object $result2;
            Throwable it;
            UpdateUtil.LatestRelease it2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Unit unit = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c33321 = this;
                    mutableState = c33321.$latestRelease$delegate;
                    mutableState2 = c33321.$showUpdateDialog$delegate;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        UpdateUtil updateUtil = UpdateUtil.INSTANCE;
                        c33321.L$0 = mutableState;
                        c33321.L$1 = mutableState2;
                        c33321.label = 1;
                        Object objCheckForUpdate$default = UpdateUtil.checkForUpdate$default(updateUtil, null, c33321, 1, null);
                        if (objCheckForUpdate$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objCheckForUpdate$default;
                        try {
                            it2 = (UpdateUtil.LatestRelease) $result;
                            if (it2 != null) {
                                mutableState.setValue(it2);
                                HomeEntryKt.HomeEntry$lambda$1(mutableState2, true);
                                unit = Unit.INSTANCE;
                            }
                            $result2 = Result.m7693constructorimpl(unit);
                            break;
                        } catch (Throwable th2) {
                            C33321 c33323 = c33321;
                            th = th2;
                            $result = $result;
                            c33322 = c33323;
                            Result.Companion companion2 = Result.INSTANCE;
                            $result2 = Result.m7693constructorimpl(ResultKt.createFailure(th));
                        }
                        it = Result.m7696exceptionOrNullimpl($result2);
                        if (it != null) {
                            it.printStackTrace();
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        c33322 = c33321;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result2 = Result.m7693constructorimpl(ResultKt.createFailure(th));
                        it = Result.m7696exceptionOrNullimpl($result2);
                        if (it != null) {
                            it.printStackTrace();
                        }
                        return Unit.INSTANCE;
                    }
                case 1:
                    c33322 = this;
                    MutableState<Boolean> mutableState3 = (MutableState) c33322.L$1;
                    mutableState = (MutableState) c33322.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        mutableState2 = mutableState3;
                        c33321 = c33322;
                        it2 = (UpdateUtil.LatestRelease) $result;
                        if (it2 != null) {
                            mutableState.setValue(it2);
                            HomeEntryKt.HomeEntry$lambda$1(mutableState2, true);
                            unit = Unit.INSTANCE;
                        }
                        $result2 = Result.m7693constructorimpl(unit);
                        break;
                    } catch (Throwable th4) {
                        th = th4;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result2 = Result.m7693constructorimpl(ResultKt.createFailure(th));
                        it = Result.m7696exceptionOrNullimpl($result2);
                        if (it != null) {
                            it.printStackTrace();
                        }
                        return Unit.INSTANCE;
                    }
                    it = Result.m7696exceptionOrNullimpl($result2);
                    if (it != null) {
                        it.printStackTrace();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
