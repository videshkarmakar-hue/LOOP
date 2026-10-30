package com.videshkarmakar.loop.database;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.CookieProfile;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.database.objects.OptionShortcut;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: VideoInfoDao.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m194d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H§@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u001c\u0010!\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016H§@¢\u0006\u0002\u0010\u0017J\u0018\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00160%H'J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H§@¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00160%H'J\u0016\u0010)\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u0018\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160%H'J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H§@¢\u0006\u0002\u0010'J\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u0014\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00160%H'J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016H§@¢\u0006\u0002\u0010'J\u001c\u00100\u001a\u00020\u00032\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016H§@¢\u0006\u0002\u0010\u0017J\u0016\u00102\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH§@¢\u0006\u0002\u00103J\u001c\u00104\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H§@¢\u0006\u0002\u0010\u0017J\u001c\u00106\u001a\u00020\u00032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H§@¢\u0006\u0002\u0010\u0017J\u0016\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0097@¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020=2\u0006\u0010\u0019\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ\u0016\u0010>\u001a\u00020=2\u0006\u0010\u001d\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ\u0016\u0010?\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010@\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001f¨\u0006A"}, m195d2 = {"Lcom/videshkarmakar/loop/database/VideoInfoDao;", "", "deleteCookieProfile", "", "cookieProfile", "Lcom/videshkarmakar/loop/database/objects/CookieProfile;", "(Lcom/videshkarmakar/loop/database/objects/CookieProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInfo", "info", "", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "([Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInfoById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInfoByPath", DownloadUtil.CookieScheme.PATH, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteInfoList", "idList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteShortcut", "optionShortcut", "Lcom/videshkarmakar/loop/database/objects/OptionShortcut;", "(Lcom/videshkarmakar/loop/database/objects/OptionShortcut;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTemplate", Route.TEMPLATE, "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "(Lcom/videshkarmakar/loop/database/objects/CommandTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTemplateById", "deleteTemplates", "templates", "getCookieById", "getCookieProfileFlow", "Lkotlinx/coroutines/flow/Flow;", "getDownloadHistory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadHistoryFlow", "getInfoById", "getInfoByPath", "getOptionShortcuts", "getShortcutList", "getTemplateById", "getTemplateFlow", "getTemplateList", "importTemplates", "templateList", "insert", "(Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "infoList", "insertAllShortcuts", "shortcuts", "insertCookieProfile", "insertInfoDistinctByPath", "videoInfo", "(Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertShortcut", "", "insertTemplate", "updateCookieProfile", "updateTemplate", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface VideoInfoDao {

    /* JADX INFO: renamed from: com.videshkarmakar.loop.database.VideoInfoDao$insertInfoDistinctByPath$1 */
    /* JADX INFO: compiled from: VideoInfoDao.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.database.VideoInfoDao$DefaultImpls", m210f = "VideoInfoDao.kt", m211i = {0, 0}, m212l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX}, m213m = "insertInfoDistinctByPath", m214n = {"$this", "videoInfo"}, m215s = {"L$0", "L$1"})
    static final class C30721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30721(Continuation<? super C30721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.insertInfoDistinctByPath(null, null, null, this);
        }
    }

    Object deleteCookieProfile(CookieProfile cookieProfile, Continuation<? super Unit> continuation);

    Object deleteInfo(DownloadedVideoInfo[] downloadedVideoInfoArr, Continuation<? super Unit> continuation);

    Object deleteInfoById(int i, Continuation<? super Unit> continuation);

    Object deleteInfoByPath(String str, Continuation<? super Unit> continuation);

    Object deleteInfoList(List<DownloadedVideoInfo> list, Continuation<? super Unit> continuation);

    Object deleteShortcut(OptionShortcut optionShortcut, Continuation<? super Unit> continuation);

    Object deleteTemplate(CommandTemplate commandTemplate, Continuation<? super Unit> continuation);

    Object deleteTemplateById(int i, Continuation<? super Unit> continuation);

    Object deleteTemplates(List<CommandTemplate> list, Continuation<? super Unit> continuation);

    Object getCookieById(int i, Continuation<? super CookieProfile> continuation);

    Flow<List<CookieProfile>> getCookieProfileFlow();

    Object getDownloadHistory(Continuation<? super List<DownloadedVideoInfo>> continuation);

    Flow<List<DownloadedVideoInfo>> getDownloadHistoryFlow();

    Object getInfoById(int i, Continuation<? super DownloadedVideoInfo> continuation);

    Object getInfoByPath(String str, Continuation<? super DownloadedVideoInfo> continuation);

    Flow<List<OptionShortcut>> getOptionShortcuts();

    Object getShortcutList(Continuation<? super List<OptionShortcut>> continuation);

    Object getTemplateById(int i, Continuation<? super CommandTemplate> continuation);

    Flow<List<CommandTemplate>> getTemplateFlow();

    Object getTemplateList(Continuation<? super List<CommandTemplate>> continuation);

    Object importTemplates(List<CommandTemplate> list, Continuation<? super Unit> continuation);

    Object insert(DownloadedVideoInfo downloadedVideoInfo, Continuation<? super Unit> continuation);

    Object insertAll(List<DownloadedVideoInfo> list, Continuation<? super Unit> continuation);

    Object insertAllShortcuts(List<OptionShortcut> list, Continuation<? super Unit> continuation);

    Object insertCookieProfile(CookieProfile cookieProfile, Continuation<? super Unit> continuation);

    Object insertInfoDistinctByPath(DownloadedVideoInfo downloadedVideoInfo, String str, Continuation<? super Unit> continuation);

    Object insertShortcut(OptionShortcut optionShortcut, Continuation<? super Long> continuation);

    Object insertTemplate(CommandTemplate commandTemplate, Continuation<? super Long> continuation);

    Object updateCookieProfile(CookieProfile cookieProfile, Continuation<? super Unit> continuation);

    Object updateTemplate(CommandTemplate commandTemplate, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: VideoInfoDao.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        /* JADX WARN: Code duplicated, block: B:19:0x0054  */
        /* JADX WARN: Code duplicated, block: B:21:0x0062 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public static Object insertInfoDistinctByPath(VideoInfoDao $this, DownloadedVideoInfo videoInfo, String path, Continuation<? super Unit> continuation) {
            C30721 c30721;
            Object infoByPath;
            VideoInfoDao $this2;
            DownloadedVideoInfo videoInfo2;
            if (continuation instanceof C30721) {
                c30721 = (C30721) continuation;
                if ((c30721.label & Integer.MIN_VALUE) != 0) {
                    c30721.label -= Integer.MIN_VALUE;
                } else {
                    c30721 = new C30721(continuation);
                }
            } else {
                c30721 = new C30721(continuation);
            }
            C30721 c30722 = c30721;
            Object $result = c30722.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (c30722.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c30722.L$0 = $this;
                    c30722.L$1 = videoInfo;
                    c30722.label = 1;
                    infoByPath = $this.getInfoByPath(path, c30722);
                    if (infoByPath == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this2 = $this;
                    videoInfo2 = videoInfo;
                    if (infoByPath == null) {
                        c30722.L$0 = null;
                        c30722.L$1 = null;
                        c30722.label = 2;
                        if ($this2.insert(videoInfo2, c30722) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    videoInfo2 = (DownloadedVideoInfo) c30722.L$1;
                    $this2 = (VideoInfoDao) c30722.L$0;
                    ResultKt.throwOnFailure($result);
                    infoByPath = $result;
                    if (infoByPath == null) {
                        c30722.L$0 = null;
                        c30722.L$1 = null;
                        c30722.label = 2;
                        if ($this2.insert(videoInfo2, c30722) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public static /* synthetic */ Object insertInfoDistinctByPath$default(VideoInfoDao videoInfoDao, DownloadedVideoInfo downloadedVideoInfo, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertInfoDistinctByPath");
            }
            if ((i & 2) != 0) {
                str = downloadedVideoInfo.getVideoPath();
            }
            return videoInfoDao.insertInfoDistinctByPath(downloadedVideoInfo, str, continuation);
        }
    }
}
