package com.videshkarmakar.loop.ui.page.settings.network;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.videshkarmakar.loop.database.objects.CookieProfile;
import com.videshkarmakar.loop.util.DatabaseUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: CookiesViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "cookiesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/videshkarmakar/loop/database/objects/CookieProfile;", "getCookiesFlow", "()Lkotlinx/coroutines/flow/Flow;", "mutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel$ViewState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteCookieProfile", "", "cookieProfile", "generateNewCookies", "content", "", "hideDialog", "showDeleteCookieDialog", "showEditCookieDialog", "updateContent", "updateCookieProfile", "updateUrl", "url", "Companion", "ViewState", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CookiesViewModel extends ViewModel {
    public static final int NEW_PROFILE_ID = 0;
    private final Flow<List<CookieProfile>> cookiesFlow = DatabaseUtil.INSTANCE.getCookiesFlow();
    private final MutableStateFlow<ViewState> mutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, false, null, 7, null));
    private final StateFlow<ViewState> stateFlow = FlowKt.asStateFlow(this.mutableStateFlow);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CookiesViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/videshkarmakar/loop/ui/page/settings/network/CookiesViewModel$ViewState;", "", "showEditDialog", "", "showDeleteDialog", "editingCookieProfile", "Lcom/videshkarmakar/loop/database/objects/CookieProfile;", "(ZZLcom/videshkarmakar/loop/database/objects/CookieProfile;)V", "getEditingCookieProfile", "()Lcom/videshkarmakar/loop/database/objects/CookieProfile;", "getShowDeleteDialog", "()Z", "getShowEditDialog", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class ViewState {
        public static final int $stable = 0;
        private final CookieProfile editingCookieProfile;
        private final boolean showDeleteDialog;
        private final boolean showEditDialog;

        public ViewState() {
            this(false, false, null, 7, null);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, boolean z2, CookieProfile cookieProfile, int i, Object obj) {
            if ((i & 1) != 0) {
                z = viewState.showEditDialog;
            }
            if ((i & 2) != 0) {
                z2 = viewState.showDeleteDialog;
            }
            if ((i & 4) != 0) {
                cookieProfile = viewState.editingCookieProfile;
            }
            return viewState.copy(z, z2, cookieProfile);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowEditDialog() {
            return this.showEditDialog;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowDeleteDialog() {
            return this.showDeleteDialog;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CookieProfile getEditingCookieProfile() {
            return this.editingCookieProfile;
        }

        public final ViewState copy(boolean showEditDialog, boolean showDeleteDialog, CookieProfile editingCookieProfile) {
            Intrinsics.checkNotNullParameter(editingCookieProfile, "editingCookieProfile");
            return new ViewState(showEditDialog, showDeleteDialog, editingCookieProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.showEditDialog == viewState.showEditDialog && this.showDeleteDialog == viewState.showDeleteDialog && Intrinsics.areEqual(this.editingCookieProfile, viewState.editingCookieProfile);
        }

        public int hashCode() {
            return (((Cookie$$ExternalSyntheticBackport0.m(this.showEditDialog) * 31) + Cookie$$ExternalSyntheticBackport0.m(this.showDeleteDialog)) * 31) + this.editingCookieProfile.hashCode();
        }

        public String toString() {
            return "ViewState(showEditDialog=" + this.showEditDialog + ", showDeleteDialog=" + this.showDeleteDialog + ", editingCookieProfile=" + this.editingCookieProfile + ")";
        }

        public ViewState(boolean showEditDialog, boolean showDeleteDialog, CookieProfile editingCookieProfile) {
            Intrinsics.checkNotNullParameter(editingCookieProfile, "editingCookieProfile");
            this.showEditDialog = showEditDialog;
            this.showDeleteDialog = showDeleteDialog;
            this.editingCookieProfile = editingCookieProfile;
        }

        public /* synthetic */ ViewState(boolean z, boolean z2, CookieProfile cookieProfile, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? new CookieProfile(0, "", "") : cookieProfile);
        }

        public final boolean getShowEditDialog() {
            return this.showEditDialog;
        }

        public final boolean getShowDeleteDialog() {
            return this.showDeleteDialog;
        }

        public final CookieProfile getEditingCookieProfile() {
            return this.editingCookieProfile;
        }
    }

    public final Flow<List<CookieProfile>> getCookiesFlow() {
        return this.cookiesFlow;
    }

    public final StateFlow<ViewState> getStateFlow() {
        return this.stateFlow;
    }

    public static /* synthetic */ void showEditCookieDialog$default(CookiesViewModel cookiesViewModel, CookieProfile cookieProfile, int i, Object obj) {
        if ((i & 1) != 0) {
            cookieProfile = new CookieProfile(0, "https://", "");
        }
        cookiesViewModel.showEditCookieDialog(cookieProfile);
    }

    public final void showEditCookieDialog(CookieProfile cookieProfile) {
        ViewState value;
        ViewState it;
        Intrinsics.checkNotNullParameter(cookieProfile, "cookieProfile");
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, true, false, cookieProfile, 2, null)));
    }

    public final void showDeleteCookieDialog(CookieProfile cookieProfile) {
        ViewState value;
        ViewState it;
        Intrinsics.checkNotNullParameter(cookieProfile, "cookieProfile");
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, true, cookieProfile, 1, null)));
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$deleteCookieProfile$1, reason: invalid class name */
    /* JADX INFO: compiled from: CookiesViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$deleteCookieProfile$1", f = "CookiesViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CookieProfile $cookieProfile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CookieProfile cookieProfile, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cookieProfile = cookieProfile;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cookieProfile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DatabaseUtil.INSTANCE.deleteCookieProfile(this.$cookieProfile, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void deleteCookieProfile$default(CookiesViewModel cookiesViewModel, CookieProfile cookieProfile, int i, Object obj) {
        if ((i & 1) != 0) {
            cookieProfile = cookiesViewModel.stateFlow.getValue().getEditingCookieProfile();
        }
        cookiesViewModel.deleteCookieProfile(cookieProfile);
    }

    public final void deleteCookieProfile(CookieProfile cookieProfile) {
        Intrinsics.checkNotNullParameter(cookieProfile, "cookieProfile");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(cookieProfile, null), 2, null);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$generateNewCookies$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CookiesViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$generateNewCookies$1", f = "CookiesViewModel.kt", i = {0, 0, 0, 0}, l = {65}, m = "invokeSuspend", n = {"$this$update$iv", "prevValue$iv", "it", "newProfile"}, s = {"L$0", "L$2", "L$3", "L$4"})
    static final class C10761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10761(String str, Continuation<? super C10761> continuation) {
            super(2, continuation);
            this.$content = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CookiesViewModel.this.new C10761(this.$content, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0072 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:11:0x0073  */
        /* JADX WARN: Code duplicated, block: B:14:0x008f  */
        /* JADX WARN: Code duplicated, block: B:16:0x0092  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0073 -> B:12:0x0077). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r17
                int r2 = r1.label
                switch(r2) {
                    case 0: goto L34;
                    case 1: goto L13;
                    default: goto Lb;
                }
            Lb:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L13:
                r2 = r17
                r3 = r18
                r4 = 0
                r5 = 0
                java.lang.Object r6 = r2.L$4
                com.videshkarmakar.loop.database.objects.CookieProfile r6 = (com.videshkarmakar.loop.database.objects.CookieProfile) r6
                java.lang.Object r7 = r2.L$3
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$ViewState r7 = (com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.ViewState) r7
                java.lang.Object r8 = r2.L$2
                java.lang.Object r9 = r2.L$1
                java.lang.String r9 = (java.lang.String) r9
                java.lang.Object r10 = r2.L$0
                kotlinx.coroutines.flow.MutableStateFlow r10 = (kotlinx.coroutines.flow.MutableStateFlow) r10
                kotlin.ResultKt.throwOnFailure(r3)
                r12 = r6
                r14 = r7
                r13 = r8
                r15 = r9
                r11 = r10
                goto L77
            L34:
                kotlin.ResultKt.throwOnFailure(r18)
                r2 = r17
                r3 = r18
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel r4 = com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r4 = com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.access$getMutableStateFlow$p(r4)
                java.lang.String r5 = r2.$content
                r6 = 0
                r12 = r4
                r11 = r5
                r4 = r6
            L47:
                java.lang.Object r13 = r12.getValue()
                r14 = r13
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$ViewState r14 = (com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.ViewState) r14
                r15 = 0
                com.videshkarmakar.loop.database.objects.CookieProfile r5 = r14.getEditingCookieProfile()
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                r8 = r11
                com.videshkarmakar.loop.database.objects.CookieProfile r6 = com.videshkarmakar.loop.database.objects.CookieProfile.copy$default(r5, r6, r7, r8, r9, r10)
                com.videshkarmakar.loop.util.DatabaseUtil r5 = com.videshkarmakar.loop.util.DatabaseUtil.INSTANCE
                r2.L$0 = r12
                r2.L$1 = r11
                r2.L$2 = r13
                r2.L$3 = r14
                r2.L$4 = r6
                r7 = 1
                r2.label = r7
                java.lang.Object r5 = r5.updateCookieProfile(r6, r2)
                if (r5 != r0) goto L73
                return r0
            L73:
                r5 = r15
                r15 = r11
                r11 = r12
                r12 = r6
            L77:
                r10 = 3
                r16 = 0
                r7 = 0
                r8 = 0
                r6 = r14
                r9 = r12
                r18 = r0
                r0 = r11
                r11 = r16
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$ViewState r5 = com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.ViewState.copy$default(r6, r7, r8, r9, r10, r11)
                boolean r6 = r0.compareAndSet(r13, r5)
                if (r6 == 0) goto L92
            L8f:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L92:
                r12 = r0
                r11 = r15
                r0 = r18
                goto L47
            */
            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.C10761.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void generateNewCookies(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C10761(content, null), 2, null);
    }

    public final void updateUrl(String url) {
        ViewState value;
        ViewState it;
        Intrinsics.checkNotNullParameter(url, "url");
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, false, CookieProfile.copy$default(it.getEditingCookieProfile(), 0, url, null, 5, null), 3, null)));
    }

    public final void updateContent(String content) {
        ViewState value;
        ViewState it;
        Intrinsics.checkNotNullParameter(content, "content");
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, false, CookieProfile.copy$default(it.getEditingCookieProfile(), 0, null, content, 3, null), 3, null)));
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$updateCookieProfile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CookiesViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$updateCookieProfile$1", f = "CookiesViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {87, 89}, m = "invokeSuspend", n = {"$this$update$iv", "prevValue$iv", "it", "$this$update$iv", "prevValue$iv", "it"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C10771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C10771(Continuation<? super C10771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CookiesViewModel.this.new C10771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0053  */
        /* JADX WARN: Code duplicated, block: B:13:0x0068 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0069  */
        /* JADX WARN: Code duplicated, block: B:15:0x006d  */
        /* JADX WARN: Code duplicated, block: B:17:0x0082 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0098  */
        /* JADX WARN: Code duplicated, block: B:23:0x009b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0080 -> B:18:0x0083). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x0053
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
                switch(r1) {
                    case 0: goto L33;
                    case 1: goto L22;
                    case 2: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L11:
                r1 = r13
                r2 = 0
                r3 = 0
                java.lang.Object r4 = r1.L$2
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$ViewState r4 = (com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.ViewState) r4
                java.lang.Object r5 = r1.L$1
                java.lang.Object r6 = r1.L$0
                kotlinx.coroutines.flow.MutableStateFlow r6 = (kotlinx.coroutines.flow.MutableStateFlow) r6
                kotlin.ResultKt.throwOnFailure(r14)
                goto L83
            L22:
                r1 = r13
                r2 = 0
                r3 = 0
                java.lang.Object r4 = r1.L$2
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$ViewState r4 = (com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.ViewState) r4
                java.lang.Object r5 = r1.L$1
                java.lang.Object r6 = r1.L$0
                kotlinx.coroutines.flow.MutableStateFlow r6 = (kotlinx.coroutines.flow.MutableStateFlow) r6
                kotlin.ResultKt.throwOnFailure(r14)
                goto L69
            L33:
                kotlin.ResultKt.throwOnFailure(r14)
                r1 = r13
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel r2 = com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r2 = com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.access$getMutableStateFlow$p(r2)
                r3 = 0
                r6 = r2
                r2 = r3
            L40:
                java.lang.Object r5 = r6.getValue()
                r4 = r5
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$ViewState r4 = (com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.ViewState) r4
                r3 = 0
                com.videshkarmakar.loop.database.objects.CookieProfile r7 = r4.getEditingCookieProfile()
                int r7 = r7.getId()
                if (r7 != 0) goto L6d
                com.videshkarmakar.loop.util.DatabaseUtil r7 = com.videshkarmakar.loop.util.DatabaseUtil.INSTANCE
                com.videshkarmakar.loop.database.objects.CookieProfile r8 = r4.getEditingCookieProfile()
                r1.L$0 = r6
                r1.L$1 = r5
                r1.L$2 = r4
                r9 = 1
                r1.label = r9
                java.lang.Object r7 = r7.insertCookieProfile(r8, r1)
                if (r7 != r0) goto L69
                return r0
            L69:
                r10 = r4
                r11 = r5
                r12 = r6
                goto L86
            L6d:
                com.videshkarmakar.loop.util.DatabaseUtil r7 = com.videshkarmakar.loop.util.DatabaseUtil.INSTANCE
                com.videshkarmakar.loop.database.objects.CookieProfile r8 = r4.getEditingCookieProfile()
                r1.L$0 = r6
                r1.L$1 = r5
                r1.L$2 = r4
                r9 = 2
                r1.label = r9
                java.lang.Object r7 = r7.updateCookieProfile(r8, r1)
                if (r7 != r0) goto L83
                return r0
            L83:
                r10 = r4
                r11 = r5
                r12 = r6
            L86:
                r8 = 6
                r9 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r4 = r10
                com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel$ViewState r3 = com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.ViewState.copy$default(r4, r5, r6, r7, r8, r9)
                boolean r4 = r12.compareAndSet(r11, r3)
                if (r4 == 0) goto L9b
            L98:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L9b:
                r6 = r12
                goto L40
            */
            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.ui.page.settings.network.CookiesViewModel.C10771.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void updateCookieProfile() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C10771(null), 2, null);
    }

    public final void hideDialog() {
        ViewState value;
        ViewState it;
        MutableStateFlow<ViewState> mutableStateFlow = this.mutableStateFlow;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(it, false, false, null, 4, null)));
    }
}
