package com.videshkarmakar.loop.database.backup;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.App;
import com.videshkarmakar.loop.C3070R;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.database.objects.OptionShortcut;
import com.videshkarmakar.loop.p006ui.common.Route;
import com.videshkarmakar.loop.util.DatabaseUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.apache.commons.p013io.IOUtils;

/* JADX INFO: compiled from: BackupUtil.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m194d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007J\"\u0010\u0005\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00160\tJ\u0010\u0010\u0017\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00160\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m195d2 = {"Lcom/videshkarmakar/loop/database/backup/BackupUtil;", "", "()V", Route.FORMAT_SELECTION, "Lkotlinx/serialization/json/Json;", "exportTemplatesToJson", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "templates", "", "Lcom/videshkarmakar/loop/database/objects/CommandTemplate;", "shortcuts", "Lcom/videshkarmakar/loop/database/objects/OptionShortcut;", "getDownloadHistoryExportFilename", "context", "Landroid/content/Context;", "decodeToBackup", "Lkotlin/Result;", "Lcom/videshkarmakar/loop/database/backup/Backup;", "decodeToBackup-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "toJsonString", "Lcom/videshkarmakar/loop/database/objects/DownloadedVideoInfo;", "toURLListString", "BackupDestination", "BackupType", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BackupUtil {
    public static final BackupUtil INSTANCE = new BackupUtil();
    private static final Json format = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.videshkarmakar.loop.database.backup.BackupUtil$format$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setPrettyPrint(true);
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: BackupUtil.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m195d2 = {"Lcom/videshkarmakar/loop/database/backup/BackupUtil$BackupDestination;", "", "(Ljava/lang/String;I)V", "File", "Clipboard", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum BackupDestination {
        File,
        Clipboard;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<BackupDestination> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: BackupUtil.kt */
    @Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m195d2 = {"Lcom/videshkarmakar/loop/database/backup/BackupUtil$BackupType;", "", "(Ljava/lang/String;I)V", "DownloadHistory", "URLList", "CommandTemplate", "CommandShortcut", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum BackupType {
        DownloadHistory,
        URLList,
        CommandTemplate,
        CommandShortcut;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<BackupType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: com.videshkarmakar.loop.database.backup.BackupUtil$exportTemplatesToJson$1 */
    /* JADX INFO: compiled from: BackupUtil.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.videshkarmakar.loop.database.backup.BackupUtil", m210f = "BackupUtil.kt", m211i = {}, m212l = {23, 24}, m213m = "exportTemplatesToJson", m214n = {}, m215s = {})
    static final class C31151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31151(Continuation<? super C31151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BackupUtil.this.exportTemplatesToJson(this);
        }
    }

    private BackupUtil() {
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object exportTemplatesToJson(Continuation<? super String> continuation) {
        C31151 c31151;
        BackupUtil backupUtil;
        Object templateList;
        List<CommandTemplate> list;
        Object shortcutList;
        List<CommandTemplate> list2;
        if (continuation instanceof C31151) {
            c31151 = (C31151) continuation;
            if ((c31151.label & Integer.MIN_VALUE) != 0) {
                c31151.label -= Integer.MIN_VALUE;
            } else {
                c31151 = new C31151(continuation);
            }
        } else {
            c31151 = new C31151(continuation);
        }
        C31151 c31152 = c31151;
        Object $result = c31152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c31152.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                backupUtil = this;
                DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                c31152.L$0 = backupUtil;
                c31152.label = 1;
                templateList = databaseUtil.getTemplateList(c31152);
                if (templateList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) templateList;
                DatabaseUtil databaseUtil2 = DatabaseUtil.INSTANCE;
                c31152.L$0 = backupUtil;
                c31152.L$1 = list;
                c31152.label = 2;
                shortcutList = databaseUtil2.getShortcutList(c31152);
                if (shortcutList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list2 = list;
                return backupUtil.exportTemplatesToJson(list2, (List) shortcutList);
            case 1:
                backupUtil = (BackupUtil) c31152.L$0;
                ResultKt.throwOnFailure($result);
                templateList = $result;
                list = (List) templateList;
                DatabaseUtil databaseUtil3 = DatabaseUtil.INSTANCE;
                c31152.L$0 = backupUtil;
                c31152.L$1 = list;
                c31152.label = 2;
                shortcutList = databaseUtil3.getShortcutList(c31152);
                if (shortcutList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list2 = list;
                return backupUtil.exportTemplatesToJson(list2, (List) shortcutList);
            case 2:
                list2 = (List) c31152.L$1;
                backupUtil = (BackupUtil) c31152.L$0;
                ResultKt.throwOnFailure($result);
                shortcutList = $result;
                return backupUtil.exportTemplatesToJson(list2, (List) shortcutList);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final String exportTemplatesToJson(List<CommandTemplate> templates, List<OptionShortcut> shortcuts) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        StringFormat $this$encodeToString$iv = format;
        Backup backup = new Backup(templates, shortcuts, (List) null, 4, (DefaultConstructorMarker) null);
        $this$encodeToString$iv.getSerializersModule();
        return $this$encodeToString$iv.encodeToString(Backup.INSTANCE.serializer(), backup);
    }

    public final String toJsonString(List<DownloadedVideoInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        StringFormat $this$encodeToString$iv = format;
        Backup backup = new Backup((List) null, (List) null, list, 3, (DefaultConstructorMarker) null);
        $this$encodeToString$iv.getSerializersModule();
        return $this$encodeToString$iv.encodeToString(Backup.INSTANCE.serializer(), backup);
    }

    public final String toURLListString(List<DownloadedVideoInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<DownloadedVideoInfo> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DownloadedVideoInfo it = (DownloadedVideoInfo) item$iv$iv;
            destination$iv$iv.add(it.getVideoUrl());
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.videshkarmakar.loop.database.backup.BackupUtil.toURLListString.2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return it2;
            }
        }, 30, null);
    }

    /* JADX INFO: renamed from: decodeToBackup-IoAF18A, reason: not valid java name */
    public final Object m7232decodeToBackupIoAF18A(String decodeToBackup) {
        Intrinsics.checkNotNullParameter(decodeToBackup, "$this$decodeToBackup");
        Json $this$decodeToBackup_IoAF18A_u24lambda_u241 = format;
        try {
            Result.Companion companion = Result.INSTANCE;
            $this$decodeToBackup_IoAF18A_u24lambda_u241.getSerializersModule();
            return Result.m7693constructorimpl((Backup) $this$decodeToBackup_IoAF18A_u24lambda_u241.decodeFromString(Backup.INSTANCE.serializer(), decodeToBackup));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7693constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final String getDownloadHistoryExportFilename(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{context.getString(C3070R.string.app_name), App.INSTANCE.getPackageInfo().versionName, new Date().toString()}), "-", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.videshkarmakar.loop.database.backup.BackupUtil.getDownloadHistoryExportFilename.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it) {
                Intrinsics.checkNotNull(it);
                return it;
            }
        }, 30, null);
    }
}
