package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.database.AppDatabase;
import com.videshkarmakar.loop.database.VideoInfoDao;
import com.videshkarmakar.loop.database.backup.Backup;
import com.videshkarmakar.loop.database.backup.BackupUtil;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.CookieProfile;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.database.objects.OptionShortcut;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal.p009ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: DatabaseUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u001f\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0015H\u0086@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150%J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150%J\u0016\u0010)\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015H\u0086@¢\u0006\u0002\u0010'J\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00150%J\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00150%J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020!0\u0015H\u0086@¢\u0006\u0002\u0010'J$\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0086@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u001f\u00109\u001a\u00020\u000b2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160:\"\u00020\u0016¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u0016\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020!H\u0086@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010B\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020!H\u0086@¢\u0006\u0002\u0010@R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, m195d2 = {"Lcom/videshkarmakar/loop/util/DatabaseUtil;", "", "()V", "DATABASE_NAME", "", "TAG", "dao", "Lcom/videshkarmakar/loop/database/VideoInfoDao;", "db", "Lcom/videshkarmakar/loop/database/AppDatabase;", "deleteCookieProfile", "", "profile", "Lcom/videshkarmakar/loop/database/objects/CookieProfile;", "(Lcom/videshkarmakar/loop/database/objects/CookieProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInfoById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInfoList", "infoList", "", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "deleteFile", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteShortcut", "shortcut", "Lcom/videshkarmakar/loop/database/objects/OptionShortcut;", "(Lcom/videshkarmakar/loop/database/objects/OptionShortcut;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTemplateById", "deleteTemplates", "templates", "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCookieById", "getCookiesFlow", "Lkotlinx/coroutines/flow/Flow;", "getDownloadHistory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadHistoryFlow", "getInfoById", "getShortcutList", "getShortcuts", "getTemplateFlow", "getTemplateList", "importBackup", "backup", "Lcom/videshkarmakar/loop/database/backup/Backup;", "types", "", "Lcom/videshkarmakar/loop/database/backup/BackupUtil$BackupType;", "(Lcom/videshkarmakar/loop/database/backup/Backup;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importTemplatesFromJson", "json", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCookieProfile", "insertInfo", "", "([Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;)V", "insertShortcut", "", "insertTemplate", "commandTemplate", "(Lcom/videshkarmakar/loop/database/objects/CommandTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCookieProfile", "updateTemplate", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DatabaseUtil {
    public static final int $stable;
    private static final String TAG = "DatabaseUtil";
    public static final DatabaseUtil INSTANCE = new DatabaseUtil();
    private static final String DATABASE_NAME = "app_database";
    private static final AppDatabase db = (AppDatabase) Room.databaseBuilder(App.INSTANCE.getContext(), AppDatabase.class, DATABASE_NAME).build();
    private static final VideoInfoDao dao = db.videoInfoDao();

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.DatabaseUtil$deleteInfoList$1 */
    /* JADX INFO: compiled from: DatabaseUtil.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.DatabaseUtil", m210f = "DatabaseUtil.kt", m211i = {0, 0}, m212l = {63}, m213m = "deleteInfoList", m214n = {"infoList", "deleteFile"}, m215s = {"L$0", "Z$0"})
    static final class C40401 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C40401(Continuation<? super C40401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatabaseUtil.this.deleteInfoList(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.DatabaseUtil$importBackup$1 */
    /* JADX INFO: compiled from: DatabaseUtil.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.DatabaseUtil", m210f = "DatabaseUtil.kt", m211i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5}, m212l = {83, 86, TarConstants.SPARSELEN_GNU, 97, 105, 107}, m213m = "importBackup", m214n = {"types", "cnt", "$this$importBackup_u24lambda_u2410", "types", "cnt", "$this$importBackup_u24lambda_u2410", "types", "cnt", "$this$importBackup_u24lambda_u2410", "types", "cnt", "$this$importBackup_u24lambda_u2410", "cnt", "$this$importBackup_u24lambda_u2410", "cnt"}, m215s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
    static final class C40411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C40411(Continuation<? super C40411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatabaseUtil.this.importBackup(null, null, this);
        }
    }

    private DatabaseUtil() {
    }

    static {
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), null, null, new C40391(null), 3, null);
        $stable = 8;
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.DatabaseUtil$insertInfo$1 */
    /* JADX INFO: compiled from: DatabaseUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.DatabaseUtil$insertInfo$1", m210f = "DatabaseUtil.kt", m211i = {0}, m212l = {26}, m213m = "invokeSuspend", m214n = {"$this$forEach$iv"}, m215s = {"L$0"})
    static final class C40421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadedVideoInfo[] $infoList;
        int I$0;
        int I$1;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40421(DownloadedVideoInfo[] downloadedVideoInfoArr, Continuation<? super C40421> continuation) {
            super(2, continuation);
            this.$infoList = downloadedVideoInfoArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40421(this.$infoList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x004c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:12:0x004d  */
        /* JADX WARN: Code duplicated, block: B:9:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004d -> B:13:0x004f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r14.label
                r2 = 1
                switch(r1) {
                    case 0: goto L24;
                    case 1: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L12:
                r1 = r14
                r3 = 0
                r4 = 0
                int r5 = r1.I$1
                int r6 = r1.I$0
                java.lang.Object r7 = r1.L$0
                com.videshkarmakar.loop.database.objects.DownloadedVideoInfo[] r7 = (com.videshkarmakar.loop.database.objects.DownloadedVideoInfo[]) r7
                kotlin.ResultKt.throwOnFailure(r15)
                r9 = r3
                r10 = r5
                r12 = r7
                goto L4f
            L24:
                kotlin.ResultKt.throwOnFailure(r15)
                r1 = r14
                com.videshkarmakar.loop.database.objects.DownloadedVideoInfo[] r3 = r1.$infoList
                r4 = 0
                int r5 = r3.length
                r6 = 0
                r12 = r3
                r9 = r4
                r10 = r5
                r11 = 0
            L31:
                if (r11 >= r10) goto L53
                r4 = r12[r11]
                r13 = 0
                com.videshkarmakar.loop.database.VideoInfoDao r3 = com.videshkarmakar.loop.util.DatabaseUtil.access$getDao$p()
                r1.L$0 = r12
                r1.I$0 = r11
                r1.I$1 = r10
                r1.label = r2
                r5 = 0
                r7 = 2
                r8 = 0
                r6 = r1
                java.lang.Object r3 = com.videshkarmakar.loop.database.VideoInfoDao.DefaultImpls.insertInfoDistinctByPath$default(r3, r4, r5, r6, r7, r8)
                if (r3 != r0) goto L4d
                return r0
            L4d:
                r6 = r11
                r4 = r13
            L4f:
                int r11 = r6 + 1
                goto L31
            L53:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.videshkarmakar.loop.util.DatabaseUtil.C40421.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void insertInfo(DownloadedVideoInfo... infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        BuildersKt__Builders_commonKt.launch$default(App.INSTANCE.getApplicationScope(), Dispatchers.getIO(), null, new C40421(infoList, null), 2, null);
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.util.DatabaseUtil$1 */
    /* JADX INFO: compiled from: DatabaseUtil.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.util.DatabaseUtil$1", m210f = "DatabaseUtil.kt", m211i = {}, m212l = {32}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C40391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C40391(Continuation<? super C40391> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40391(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DatabaseUtil.INSTANCE.getTemplateFlow().collect(new FlowCollector() { // from class: com.videshkarmakar.loop.util.DatabaseUtil.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((List<CommandTemplate>) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(List<CommandTemplate> list, Continuation<? super Unit> continuation) {
                            Object objInitializeTemplateSample;
                            return (list.isEmpty() && (objInitializeTemplateSample = PreferenceUtil.INSTANCE.initializeTemplateSample(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objInitializeTemplateSample : Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
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

    public final Flow<List<DownloadedVideoInfo>> getDownloadHistoryFlow() {
        return dao.getDownloadHistoryFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getDownloadHistory(Continuation<? super List<DownloadedVideoInfo>> continuation) {
        return dao.getDownloadHistory(continuation);
    }

    public final Flow<List<CommandTemplate>> getTemplateFlow() {
        return dao.getTemplateFlow();
    }

    public final Flow<List<CookieProfile>> getCookiesFlow() {
        return dao.getCookieProfileFlow();
    }

    public final Flow<List<OptionShortcut>> getShortcuts() {
        return dao.getOptionShortcuts();
    }

    public final Object deleteShortcut(OptionShortcut shortcut, Continuation<? super Unit> continuation) {
        Object objDeleteShortcut = dao.deleteShortcut(shortcut, continuation);
        return objDeleteShortcut == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteShortcut : Unit.INSTANCE;
    }

    public final Object insertShortcut(OptionShortcut shortcut, Continuation<? super Long> continuation) {
        return dao.insertShortcut(shortcut, continuation);
    }

    public final Object getCookieById(int id, Continuation<? super CookieProfile> continuation) {
        return dao.getCookieById(id, continuation);
    }

    public final Object deleteCookieProfile(CookieProfile profile, Continuation<? super Unit> continuation) {
        Object objDeleteCookieProfile = dao.deleteCookieProfile(profile, continuation);
        return objDeleteCookieProfile == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteCookieProfile : Unit.INSTANCE;
    }

    public final Object insertCookieProfile(CookieProfile profile, Continuation<? super Unit> continuation) {
        Object objInsertCookieProfile = dao.insertCookieProfile(profile, continuation);
        return objInsertCookieProfile == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsertCookieProfile : Unit.INSTANCE;
    }

    public final Object updateCookieProfile(CookieProfile profile, Continuation<? super Unit> continuation) {
        Object objUpdateCookieProfile = dao.updateCookieProfile(profile, continuation);
        return objUpdateCookieProfile == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateCookieProfile : Unit.INSTANCE;
    }

    public final Object getTemplateList(Continuation<? super List<CommandTemplate>> continuation) {
        return dao.getTemplateList(continuation);
    }

    public final Object getShortcutList(Continuation<? super List<OptionShortcut>> continuation) {
        return dao.getShortcutList(continuation);
    }

    public static /* synthetic */ Object deleteInfoList$default(DatabaseUtil databaseUtil, List list, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return databaseUtil.deleteInfoList(list, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteInfoList(List<DownloadedVideoInfo> list, boolean deleteFile, Continuation<? super Unit> continuation) {
        C40401 c40401;
        Iterable iterable;
        boolean deleteFile2;
        if (continuation instanceof C40401) {
            c40401 = (C40401) continuation;
            if ((c40401.label & Integer.MIN_VALUE) != 0) {
                c40401.label -= Integer.MIN_VALUE;
            } else {
                c40401 = new C40401(continuation);
            }
        } else {
            c40401 = new C40401(continuation);
        }
        C40401 c40402 = c40401;
        Object $result = c40402.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c40402.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                VideoInfoDao videoInfoDao = dao;
                c40402.L$0 = list;
                c40402.Z$0 = deleteFile;
                c40402.label = 1;
                if (videoInfoDao.deleteInfoList(list, c40402) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                iterable = list;
                deleteFile2 = deleteFile;
                break;
                break;
            case 1:
                deleteFile2 = c40402.Z$0;
                iterable = (List) c40402.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$forEach$iv = iterable;
        for (Object element$iv : $this$forEach$iv) {
            DownloadedVideoInfo info = (DownloadedVideoInfo) element$iv;
            if (deleteFile2) {
                FileUtil.INSTANCE.m7677deleteFileIoAF18A(info.getVideoPath());
            }
        }
        return Unit.INSTANCE;
    }

    public final Object getInfoById(int id, Continuation<? super DownloadedVideoInfo> continuation) {
        return dao.getInfoById(id, continuation);
    }

    public final Object deleteInfoById(int id, Continuation<? super Unit> continuation) {
        Object objDeleteInfoById = dao.deleteInfoById(id, continuation);
        return objDeleteInfoById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteInfoById : Unit.INSTANCE;
    }

    public final Object insertTemplate(CommandTemplate commandTemplate, Continuation<? super Long> continuation) {
        return dao.insertTemplate(commandTemplate, continuation);
    }

    public final Object updateTemplate(CommandTemplate commandTemplate, Continuation<? super Unit> continuation) {
        Object objUpdateTemplate = dao.updateTemplate(commandTemplate, continuation);
        return objUpdateTemplate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateTemplate : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x026a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:40:0x0125 A[LOOP:5: B:38:0x011f->B:40:0x0125, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x016a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x016b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0173  */
    /* JADX WARN: Code duplicated, block: B:49:0x0180  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ee A[LOOP:3: B:63:0x01e8->B:65:0x01ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x0229 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0237  */
    /* JADX WARN: Code duplicated, block: B:75:0x0249 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x024a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0255  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:82:0x0270  */
    /* JADX WARN: Code duplicated, block: B:88:0x02a2 A[LOOP:1: B:86:0x029c->B:88:0x02a2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:91:0x02db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:94:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:98:0x027e A[SYNTHETIC] */
    public final Object importBackup(Backup backup, Set<? extends BackupUtil.BackupType> set, Continuation<? super Integer> continuation) {
        C40411 c40411;
        Set<? extends BackupUtil.BackupType> set2;
        Backup $this$importBackup_u24lambda_u2410;
        Ref.IntRef cnt;
        Set types;
        Object downloadHistory;
        Set<? extends BackupUtil.BackupType> set3;
        Set types2;
        List itemList;
        List<DownloadedVideoInfo> downloadHistory2;
        VideoInfoDao videoInfoDao;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        List it;
        Backup $this$importBackup_u24lambda_u2411;
        Ref.IntRef cnt2;
        Set<? extends BackupUtil.BackupType> set4;
        Backup $this$importBackup_u24lambda_u2412;
        Object templateList;
        Ref.IntRef cnt3;
        Set<? extends BackupUtil.BackupType> set5;
        Set types3;
        List templateList2;
        VideoInfoDao videoInfoDao2;
        Collection destination$iv$iv3;
        Collection destination$iv$iv4;
        List it2;
        Object shortcutList;
        Object obj;
        Ref.IntRef cnt4;
        Set set6;
        List shortcutList2;
        VideoInfoDao videoInfoDao3;
        Collection destination$iv$iv5;
        Collection destination$iv$iv6;
        List it3;
        Ref.IntRef cnt5;
        if (continuation instanceof C40411) {
            C40411 c40412 = (C40411) continuation;
            if ((c40412.label & Integer.MIN_VALUE) != 0) {
                c40412.label -= Integer.MIN_VALUE;
                c40411 = c40412;
            } else {
                c40411 = new C40411(continuation);
            }
        } else {
            c40411 = new C40411(continuation);
        }
        Object $result = c40411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c40411.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                set2 = set;
                $this$importBackup_u24lambda_u2410 = backup;
                cnt = new Ref.IntRef();
                types = null;
                if (set2.contains(BackupUtil.BackupType.DownloadHistory)) {
                    DatabaseUtil databaseUtil = INSTANCE;
                    c40411.L$0 = set2;
                    c40411.L$1 = cnt;
                    c40411.L$2 = $this$importBackup_u24lambda_u2410;
                    c40411.label = 1;
                    downloadHistory = databaseUtil.getDownloadHistory(c40411);
                    if (downloadHistory == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    set3 = set2;
                    types2 = null;
                    itemList = (List) downloadHistory;
                    downloadHistory2 = $this$importBackup_u24lambda_u2410.getDownloadHistory();
                    if (downloadHistory2 != null && !downloadHistory2.isEmpty()) {
                        z = false;
                    }
                    if (z) {
                        Set<? extends BackupUtil.BackupType> set7 = set3;
                        types = types2;
                        set2 = set7;
                    } else {
                        videoInfoDao = dao;
                        Iterable $this$filterNotTo$iv$iv = $this$importBackup_u24lambda_u2410.getDownloadHistory();
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filterNotTo$iv$iv) {
                            if (!itemList.contains((DownloadedVideoInfo) element$iv$iv)) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        Iterable $this$map$iv = (List) destination$iv$iv;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            destination$iv$iv2.add(DownloadedVideoInfo.copy$default((DownloadedVideoInfo) item$iv$iv, 0, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
                        }
                        it = (List) destination$iv$iv2;
                        cnt.element += it.size();
                        c40411.L$0 = set3;
                        c40411.L$1 = cnt;
                        c40411.L$2 = $this$importBackup_u24lambda_u2410;
                        c40411.label = 2;
                        if (videoInfoDao.insertAll(it, c40411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$importBackup_u24lambda_u2411 = $this$importBackup_u24lambda_u2410;
                        cnt2 = cnt;
                        set4 = set3;
                        types = types2;
                        set2 = set4;
                        cnt = cnt2;
                        $this$importBackup_u24lambda_u2410 = $this$importBackup_u24lambda_u2411;
                    }
                    if (set2.contains(BackupUtil.BackupType.CommandTemplate) || $this$importBackup_u24lambda_u2410.getTemplates() == null) {
                        $this$importBackup_u24lambda_u2412 = $this$importBackup_u24lambda_u2410;
                    } else {
                        DatabaseUtil databaseUtil2 = INSTANCE;
                        c40411.L$0 = set2;
                        c40411.L$1 = cnt;
                        c40411.L$2 = $this$importBackup_u24lambda_u2410;
                        c40411.label = 3;
                        templateList = databaseUtil2.getTemplateList(c40411);
                        if (templateList == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$importBackup_u24lambda_u2412 = $this$importBackup_u24lambda_u2410;
                        cnt3 = cnt;
                        set5 = set2;
                        types3 = types;
                        templateList2 = (List) templateList;
                        videoInfoDao2 = dao;
                        Iterable $this$filterNotTo$iv$iv2 = $this$importBackup_u24lambda_u2412.getTemplates();
                        destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv2 : $this$filterNotTo$iv$iv2) {
                            if (!templateList2.contains((CommandTemplate) element$iv$iv2)) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                        }
                        Iterable $this$map$iv2 = (List) destination$iv$iv3;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        for (Object item$iv$iv2 : $this$map$iv2) {
                            destination$iv$iv4.add(CommandTemplate.copy$default((CommandTemplate) item$iv$iv2, 0, null, null, 6, null));
                        }
                        it2 = (List) destination$iv$iv4;
                        cnt3.element += it2.size();
                        c40411.L$0 = set5;
                        c40411.L$1 = cnt3;
                        c40411.L$2 = $this$importBackup_u24lambda_u2412;
                        c40411.label = 4;
                        if (videoInfoDao2.importTemplates(it2, c40411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        types = types3;
                        set2 = set5;
                        cnt = cnt3;
                    }
                } else {
                    if (set2.contains(BackupUtil.BackupType.CommandTemplate)) {
                    }
                    $this$importBackup_u24lambda_u2412 = $this$importBackup_u24lambda_u2410;
                }
                if (set2.contains(BackupUtil.BackupType.CommandShortcut)) {
                    DatabaseUtil databaseUtil3 = INSTANCE;
                    c40411.L$0 = cnt;
                    c40411.L$1 = $this$importBackup_u24lambda_u2412;
                    c40411.L$2 = null;
                    c40411.label = 5;
                    shortcutList = databaseUtil3.getShortcutList(c40411);
                    if (shortcutList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = shortcutList;
                    cnt4 = cnt;
                    set6 = types;
                    shortcutList2 = (List) obj;
                    if ($this$importBackup_u24lambda_u2412.getShortcuts() != null) {
                        videoInfoDao3 = dao;
                        Iterable $this$filterNotTo$iv$iv3 = $this$importBackup_u24lambda_u2412.getShortcuts();
                        destination$iv$iv5 = new ArrayList();
                        for (Object element$iv$iv3 : $this$filterNotTo$iv$iv3) {
                            if (!shortcutList2.contains((OptionShortcut) element$iv$iv3)) {
                                destination$iv$iv5.add(element$iv$iv3);
                            }
                        }
                        Iterable $this$map$iv3 = (List) destination$iv$iv5;
                        destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        for (Object item$iv$iv3 : $this$map$iv3) {
                            destination$iv$iv6.add(OptionShortcut.copy$default((OptionShortcut) item$iv$iv3, 0L, null, 2, null));
                        }
                        it3 = (List) destination$iv$iv6;
                        cnt4.element += it3.size();
                        c40411.L$0 = cnt4;
                        c40411.L$1 = null;
                        c40411.label = 6;
                        if (videoInfoDao3.insertAllShortcuts(it3, c40411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cnt5 = cnt4;
                        cnt = cnt5;
                    } else {
                        cnt = cnt4;
                    }
                }
                return Boxing.boxInt(cnt.element);
            case 1:
                types2 = null;
                $this$importBackup_u24lambda_u2410 = (Backup) c40411.L$2;
                cnt = (Ref.IntRef) c40411.L$1;
                set3 = (Set) c40411.L$0;
                ResultKt.throwOnFailure($result);
                downloadHistory = $result;
                itemList = (List) downloadHistory;
                downloadHistory2 = $this$importBackup_u24lambda_u2410.getDownloadHistory();
                if (downloadHistory2 != null) {
                    z = false;
                }
                if (z) {
                    videoInfoDao = dao;
                    Iterable $this$filterNotTo$iv$iv4 = $this$importBackup_u24lambda_u2410.getDownloadHistory();
                    destination$iv$iv = new ArrayList();
                    while (r16.hasNext()) {
                        if (!itemList.contains((DownloadedVideoInfo) element$iv$iv)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    Iterable $this$map$iv4 = (List) destination$iv$iv;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    while (r14.hasNext()) {
                        destination$iv$iv2.add(DownloadedVideoInfo.copy$default((DownloadedVideoInfo) item$iv$iv, 0, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
                    }
                    it = (List) destination$iv$iv2;
                    cnt.element += it.size();
                    c40411.L$0 = set3;
                    c40411.L$1 = cnt;
                    c40411.L$2 = $this$importBackup_u24lambda_u2410;
                    c40411.label = 2;
                    if (videoInfoDao.insertAll(it, c40411) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$importBackup_u24lambda_u2411 = $this$importBackup_u24lambda_u2410;
                    cnt2 = cnt;
                    set4 = set3;
                    types = types2;
                    set2 = set4;
                    cnt = cnt2;
                    $this$importBackup_u24lambda_u2410 = $this$importBackup_u24lambda_u2411;
                } else {
                    Set<? extends BackupUtil.BackupType> set8 = set3;
                    types = types2;
                    set2 = set8;
                }
                if (set2.contains(BackupUtil.BackupType.CommandTemplate)) {
                    break;
                }
                $this$importBackup_u24lambda_u2412 = $this$importBackup_u24lambda_u2410;
                if (set2.contains(BackupUtil.BackupType.CommandShortcut)) {
                    DatabaseUtil databaseUtil4 = INSTANCE;
                    c40411.L$0 = cnt;
                    c40411.L$1 = $this$importBackup_u24lambda_u2412;
                    c40411.L$2 = null;
                    c40411.label = 5;
                    shortcutList = databaseUtil4.getShortcutList(c40411);
                    if (shortcutList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = shortcutList;
                    cnt4 = cnt;
                    set6 = types;
                    shortcutList2 = (List) obj;
                    if ($this$importBackup_u24lambda_u2412.getShortcuts() != null) {
                        videoInfoDao3 = dao;
                        Iterable $this$filterNotTo$iv$iv5 = $this$importBackup_u24lambda_u2412.getShortcuts();
                        destination$iv$iv5 = new ArrayList();
                        while (r12.hasNext()) {
                            if (!shortcutList2.contains((OptionShortcut) element$iv$iv3)) {
                                destination$iv$iv5.add(element$iv$iv3);
                            }
                        }
                        Iterable $this$map$iv5 = (List) destination$iv$iv5;
                        destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        while (r11.hasNext()) {
                            destination$iv$iv6.add(OptionShortcut.copy$default((OptionShortcut) item$iv$iv3, 0L, null, 2, null));
                        }
                        it3 = (List) destination$iv$iv6;
                        cnt4.element += it3.size();
                        c40411.L$0 = cnt4;
                        c40411.L$1 = null;
                        c40411.label = 6;
                        if (videoInfoDao3.insertAllShortcuts(it3, c40411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cnt5 = cnt4;
                        cnt = cnt5;
                    } else {
                        cnt = cnt4;
                    }
                }
                return Boxing.boxInt(cnt.element);
            case 2:
                types2 = null;
                $this$importBackup_u24lambda_u2411 = (Backup) c40411.L$2;
                cnt2 = (Ref.IntRef) c40411.L$1;
                set4 = (Set) c40411.L$0;
                ResultKt.throwOnFailure($result);
                types = types2;
                set2 = set4;
                cnt = cnt2;
                $this$importBackup_u24lambda_u2410 = $this$importBackup_u24lambda_u2411;
                if (set2.contains(BackupUtil.BackupType.CommandTemplate)) {
                    break;
                }
                $this$importBackup_u24lambda_u2412 = $this$importBackup_u24lambda_u2410;
                if (set2.contains(BackupUtil.BackupType.CommandShortcut)) {
                    DatabaseUtil databaseUtil5 = INSTANCE;
                    c40411.L$0 = cnt;
                    c40411.L$1 = $this$importBackup_u24lambda_u2412;
                    c40411.L$2 = null;
                    c40411.label = 5;
                    shortcutList = databaseUtil5.getShortcutList(c40411);
                    if (shortcutList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = shortcutList;
                    cnt4 = cnt;
                    set6 = types;
                    shortcutList2 = (List) obj;
                    if ($this$importBackup_u24lambda_u2412.getShortcuts() != null) {
                        videoInfoDao3 = dao;
                        Iterable $this$filterNotTo$iv$iv6 = $this$importBackup_u24lambda_u2412.getShortcuts();
                        destination$iv$iv5 = new ArrayList();
                        while (r12.hasNext()) {
                            if (!shortcutList2.contains((OptionShortcut) element$iv$iv3)) {
                                destination$iv$iv5.add(element$iv$iv3);
                            }
                        }
                        Iterable $this$map$iv6 = (List) destination$iv$iv5;
                        destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                        while (r11.hasNext()) {
                            destination$iv$iv6.add(OptionShortcut.copy$default((OptionShortcut) item$iv$iv3, 0L, null, 2, null));
                        }
                        it3 = (List) destination$iv$iv6;
                        cnt4.element += it3.size();
                        c40411.L$0 = cnt4;
                        c40411.L$1 = null;
                        c40411.label = 6;
                        if (videoInfoDao3.insertAllShortcuts(it3, c40411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cnt5 = cnt4;
                        cnt = cnt5;
                    } else {
                        cnt = cnt4;
                    }
                }
                return Boxing.boxInt(cnt.element);
            case 3:
                types3 = null;
                $this$importBackup_u24lambda_u2412 = (Backup) c40411.L$2;
                cnt3 = (Ref.IntRef) c40411.L$1;
                set5 = (Set) c40411.L$0;
                ResultKt.throwOnFailure($result);
                templateList = $result;
                templateList2 = (List) templateList;
                videoInfoDao2 = dao;
                Iterable $this$filterNotTo$iv$iv7 = $this$importBackup_u24lambda_u2412.getTemplates();
                destination$iv$iv3 = new ArrayList();
                while (r15.hasNext()) {
                    if (!templateList2.contains((CommandTemplate) element$iv$iv2)) {
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                }
                Iterable $this$map$iv7 = (List) destination$iv$iv3;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                while (r13.hasNext()) {
                    destination$iv$iv4.add(CommandTemplate.copy$default((CommandTemplate) item$iv$iv2, 0, null, null, 6, null));
                }
                it2 = (List) destination$iv$iv4;
                cnt3.element += it2.size();
                c40411.L$0 = set5;
                c40411.L$1 = cnt3;
                c40411.L$2 = $this$importBackup_u24lambda_u2412;
                c40411.label = 4;
                if (videoInfoDao2.importTemplates(it2, c40411) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                types = types3;
                set2 = set5;
                cnt = cnt3;
                if (set2.contains(BackupUtil.BackupType.CommandShortcut)) {
                    DatabaseUtil databaseUtil6 = INSTANCE;
                    c40411.L$0 = cnt;
                    c40411.L$1 = $this$importBackup_u24lambda_u2412;
                    c40411.L$2 = null;
                    c40411.label = 5;
                    shortcutList = databaseUtil6.getShortcutList(c40411);
                    if (shortcutList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = shortcutList;
                    cnt4 = cnt;
                    set6 = types;
                    shortcutList2 = (List) obj;
                    if ($this$importBackup_u24lambda_u2412.getShortcuts() != null) {
                        videoInfoDao3 = dao;
                        Iterable $this$filterNotTo$iv$iv8 = $this$importBackup_u24lambda_u2412.getShortcuts();
                        destination$iv$iv5 = new ArrayList();
                        while (r12.hasNext()) {
                            if (!shortcutList2.contains((OptionShortcut) element$iv$iv3)) {
                                destination$iv$iv5.add(element$iv$iv3);
                            }
                        }
                        Iterable $this$map$iv8 = (List) destination$iv$iv5;
                        destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv8, 10));
                        while (r11.hasNext()) {
                            destination$iv$iv6.add(OptionShortcut.copy$default((OptionShortcut) item$iv$iv3, 0L, null, 2, null));
                        }
                        it3 = (List) destination$iv$iv6;
                        cnt4.element += it3.size();
                        c40411.L$0 = cnt4;
                        c40411.L$1 = null;
                        c40411.label = 6;
                        if (videoInfoDao3.insertAllShortcuts(it3, c40411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cnt5 = cnt4;
                        cnt = cnt5;
                    } else {
                        cnt = cnt4;
                    }
                }
                return Boxing.boxInt(cnt.element);
            case 4:
                types3 = null;
                $this$importBackup_u24lambda_u2412 = (Backup) c40411.L$2;
                cnt3 = (Ref.IntRef) c40411.L$1;
                set5 = (Set) c40411.L$0;
                ResultKt.throwOnFailure($result);
                types = types3;
                set2 = set5;
                cnt = cnt3;
                if (set2.contains(BackupUtil.BackupType.CommandShortcut)) {
                    DatabaseUtil databaseUtil7 = INSTANCE;
                    c40411.L$0 = cnt;
                    c40411.L$1 = $this$importBackup_u24lambda_u2412;
                    c40411.L$2 = null;
                    c40411.label = 5;
                    shortcutList = databaseUtil7.getShortcutList(c40411);
                    if (shortcutList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = shortcutList;
                    cnt4 = cnt;
                    set6 = types;
                    shortcutList2 = (List) obj;
                    if ($this$importBackup_u24lambda_u2412.getShortcuts() != null) {
                        videoInfoDao3 = dao;
                        Iterable $this$filterNotTo$iv$iv9 = $this$importBackup_u24lambda_u2412.getShortcuts();
                        destination$iv$iv5 = new ArrayList();
                        while (r12.hasNext()) {
                            if (!shortcutList2.contains((OptionShortcut) element$iv$iv3)) {
                                destination$iv$iv5.add(element$iv$iv3);
                            }
                        }
                        Iterable $this$map$iv9 = (List) destination$iv$iv5;
                        destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv9, 10));
                        while (r11.hasNext()) {
                            destination$iv$iv6.add(OptionShortcut.copy$default((OptionShortcut) item$iv$iv3, 0L, null, 2, null));
                        }
                        it3 = (List) destination$iv$iv6;
                        cnt4.element += it3.size();
                        c40411.L$0 = cnt4;
                        c40411.L$1 = null;
                        c40411.label = 6;
                        if (videoInfoDao3.insertAllShortcuts(it3, c40411) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cnt5 = cnt4;
                        cnt = cnt5;
                    } else {
                        cnt = cnt4;
                    }
                }
                return Boxing.boxInt(cnt.element);
            case 5:
                set6 = null;
                $this$importBackup_u24lambda_u2412 = (Backup) c40411.L$1;
                cnt4 = (Ref.IntRef) c40411.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                shortcutList2 = (List) obj;
                if ($this$importBackup_u24lambda_u2412.getShortcuts() != null) {
                    videoInfoDao3 = dao;
                    Iterable $this$filterNotTo$iv$iv10 = $this$importBackup_u24lambda_u2412.getShortcuts();
                    destination$iv$iv5 = new ArrayList();
                    while (r12.hasNext()) {
                        if (!shortcutList2.contains((OptionShortcut) element$iv$iv3)) {
                            destination$iv$iv5.add(element$iv$iv3);
                        }
                    }
                    Iterable $this$map$iv10 = (List) destination$iv$iv5;
                    destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv10, 10));
                    while (r11.hasNext()) {
                        destination$iv$iv6.add(OptionShortcut.copy$default((OptionShortcut) item$iv$iv3, 0L, null, 2, null));
                    }
                    it3 = (List) destination$iv$iv6;
                    cnt4.element += it3.size();
                    c40411.L$0 = cnt4;
                    c40411.L$1 = null;
                    c40411.label = 6;
                    if (videoInfoDao3.insertAllShortcuts(it3, c40411) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cnt5 = cnt4;
                    cnt = cnt5;
                } else {
                    cnt = cnt4;
                }
                return Boxing.boxInt(cnt.element);
            case 6:
                cnt5 = (Ref.IntRef) c40411.L$0;
                ResultKt.throwOnFailure($result);
                cnt = cnt5;
                return Boxing.boxInt(cnt.element);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object importTemplatesFromJson(String json, Continuation<? super Integer> continuation) {
        Object objM7232decodeToBackupIoAF18A = BackupUtil.INSTANCE.m7232decodeToBackupIoAF18A(json);
        if (Result.m7700isSuccessimpl(objM7232decodeToBackupIoAF18A)) {
            Backup backup = (Backup) objM7232decodeToBackupIoAF18A;
            return INSTANCE.importBackup(backup, SetsKt.setOf((Object[]) new BackupUtil.BackupType[]{BackupUtil.BackupType.CommandTemplate, BackupUtil.BackupType.CommandShortcut}), continuation);
        }
        Throwable it = Result.m7696exceptionOrNullimpl(objM7232decodeToBackupIoAF18A);
        if (it != null) {
            it.printStackTrace();
        }
        return Boxing.boxInt(0);
    }

    public final Object deleteTemplateById(int id, Continuation<? super Unit> continuation) {
        Object objDeleteTemplateById = dao.deleteTemplateById(id, continuation);
        return objDeleteTemplateById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTemplateById : Unit.INSTANCE;
    }

    public final Object deleteTemplates(List<CommandTemplate> list, Continuation<? super Unit> continuation) {
        Object objDeleteTemplates = dao.deleteTemplates(list, continuation);
        return objDeleteTemplates == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTemplates : Unit.INSTANCE;
    }
}
