package com.videshkarmakar.loop.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p004db.SupportSQLiteStatement;
import com.videshkarmakar.loop.database.objects.CommandTemplate;
import com.videshkarmakar.loop.database.objects.CookieProfile;
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo;
import com.videshkarmakar.loop.database.objects.OptionShortcut;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes5.dex */
public final class VideoInfoDao_Impl implements VideoInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<CommandTemplate> __deletionAdapterOfCommandTemplate;
    private final EntityDeletionOrUpdateAdapter<CookieProfile> __deletionAdapterOfCookieProfile;
    private final EntityDeletionOrUpdateAdapter<DownloadedVideoInfo> __deletionAdapterOfDownloadedVideoInfo;
    private final EntityDeletionOrUpdateAdapter<OptionShortcut> __deletionAdapterOfOptionShortcut;
    private final EntityInsertionAdapter<CommandTemplate> __insertionAdapterOfCommandTemplate;
    private final EntityInsertionAdapter<CookieProfile> __insertionAdapterOfCookieProfile;
    private final EntityInsertionAdapter<DownloadedVideoInfo> __insertionAdapterOfDownloadedVideoInfo;
    private final EntityInsertionAdapter<OptionShortcut> __insertionAdapterOfOptionShortcut;
    private final SharedSQLiteStatement __preparedStmtOfDeleteInfoById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteInfoByPath;
    private final SharedSQLiteStatement __preparedStmtOfDeleteTemplateById;
    private final EntityDeletionOrUpdateAdapter<CommandTemplate> __updateAdapterOfCommandTemplate;
    private final EntityDeletionOrUpdateAdapter<CookieProfile> __updateAdapterOfCookieProfile;

    public VideoInfoDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDownloadedVideoInfo = new EntityInsertionAdapter<DownloadedVideoInfo>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `DownloadedVideoInfo` (`id`,`videoTitle`,`videoAuthor`,`videoUrl`,`thumbnailUrl`,`videoPath`,`extractor`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final DownloadedVideoInfo entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getVideoTitle());
                statement.bindString(3, entity.getVideoAuthor());
                statement.bindString(4, entity.getVideoUrl());
                statement.bindString(5, entity.getThumbnailUrl());
                statement.bindString(6, entity.getVideoPath());
                statement.bindString(7, entity.getExtractor());
            }
        };
        this.__insertionAdapterOfCommandTemplate = new EntityInsertionAdapter<CommandTemplate>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `CommandTemplate` (`id`,`name`,`template`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CommandTemplate entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getName());
                statement.bindString(3, entity.getTemplate());
            }
        };
        this.__insertionAdapterOfCookieProfile = new EntityInsertionAdapter<CookieProfile>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `CookieProfile` (`id`,`url`,`content`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CookieProfile entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUrl());
                statement.bindString(3, entity.getContent());
            }
        };
        this.__insertionAdapterOfOptionShortcut = new EntityInsertionAdapter<OptionShortcut>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `OptionShortcut` (`id`,`option`) VALUES (nullif(?, 0),?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final OptionShortcut entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getOption());
            }
        };
        this.__deletionAdapterOfDownloadedVideoInfo = new EntityDeletionOrUpdateAdapter<DownloadedVideoInfo>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.5
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `DownloadedVideoInfo` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final DownloadedVideoInfo entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__deletionAdapterOfCommandTemplate = new EntityDeletionOrUpdateAdapter<CommandTemplate>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.6
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `CommandTemplate` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CommandTemplate entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__deletionAdapterOfCookieProfile = new EntityDeletionOrUpdateAdapter<CookieProfile>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.7
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `CookieProfile` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CookieProfile entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__deletionAdapterOfOptionShortcut = new EntityDeletionOrUpdateAdapter<OptionShortcut>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.8
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `OptionShortcut` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final OptionShortcut entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfCommandTemplate = new EntityDeletionOrUpdateAdapter<CommandTemplate>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.9
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `CommandTemplate` SET `id` = ?,`name` = ?,`template` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CommandTemplate entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getName());
                statement.bindString(3, entity.getTemplate());
                statement.bindLong(4, entity.getId());
            }
        };
        this.__updateAdapterOfCookieProfile = new EntityDeletionOrUpdateAdapter<CookieProfile>(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.10
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `CookieProfile` SET `id` = ?,`url` = ?,`content` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CookieProfile entity) {
                statement.bindLong(1, entity.getId());
                statement.bindString(2, entity.getUrl());
                statement.bindString(3, entity.getContent());
                statement.bindLong(4, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteInfoById = new SharedSQLiteStatement(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM DownloadedVideoInfo WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteInfoByPath = new SharedSQLiteStatement(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM DownloadedVideoInfo WHERE videoPath = ?";
            }
        };
        this.__preparedStmtOfDeleteTemplateById = new SharedSQLiteStatement(__db) { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from CommandTemplate where id=?";
            }
        };
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object insert(final DownloadedVideoInfo info, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.14
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__insertionAdapterOfDownloadedVideoInfo.insert(info);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object insertAll(final List<DownloadedVideoInfo> infoList, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.15
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__insertionAdapterOfDownloadedVideoInfo.insert((Iterable) infoList);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object insertTemplate(final CommandTemplate template, final Continuation<? super Long> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    Long _result = Long.valueOf(VideoInfoDao_Impl.this.__insertionAdapterOfCommandTemplate.insertAndReturnId(template));
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return _result;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object importTemplates(final List<CommandTemplate> templateList, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.17
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__insertionAdapterOfCommandTemplate.insert((Iterable) templateList);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object insertCookieProfile(final CookieProfile cookieProfile, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.18
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__insertionAdapterOfCookieProfile.insert(cookieProfile);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object insertShortcut(final OptionShortcut optionShortcut, final Continuation<? super Long> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    Long _result = Long.valueOf(VideoInfoDao_Impl.this.__insertionAdapterOfOptionShortcut.insertAndReturnId(optionShortcut));
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return _result;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object insertAllShortcuts(final List<OptionShortcut> shortcuts, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.20
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__insertionAdapterOfOptionShortcut.insert((Iterable) shortcuts);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteInfo(final DownloadedVideoInfo[] info, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.21
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__deletionAdapterOfDownloadedVideoInfo.handleMultiple(info);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteInfoList(final List<DownloadedVideoInfo> idList, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.22
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__deletionAdapterOfDownloadedVideoInfo.handleMultiple(idList);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteTemplate(final CommandTemplate template, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.23
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__deletionAdapterOfCommandTemplate.handle(template);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteCookieProfile(final CookieProfile cookieProfile, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.24
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__deletionAdapterOfCookieProfile.handle(cookieProfile);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteTemplates(final List<CommandTemplate> templates, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.25
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__deletionAdapterOfCommandTemplate.handleMultiple(templates);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteShortcut(final OptionShortcut optionShortcut, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.26
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__deletionAdapterOfOptionShortcut.handle(optionShortcut);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object updateTemplate(final CommandTemplate template, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.27
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__updateAdapterOfCommandTemplate.handle(template);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object updateCookieProfile(final CookieProfile cookieProfile, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.28
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                VideoInfoDao_Impl.this.__db.beginTransaction();
                try {
                    VideoInfoDao_Impl.this.__updateAdapterOfCookieProfile.handle(cookieProfile);
                    VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    VideoInfoDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object insertInfoDistinctByPath(final DownloadedVideoInfo videoInfo, final String path, final Continuation<? super Unit> $completion) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.m182xb8e03cfd(videoInfo, path, (Continuation) obj);
            }
        }, $completion);
    }

    /* JADX INFO: renamed from: lambda$insertInfoDistinctByPath$0$com-videshkarmakar-loop-database-VideoInfoDao_Impl */
    /* synthetic */ Object m182xb8e03cfd(DownloadedVideoInfo videoInfo, String path, Continuation __cont) {
        return VideoInfoDao.DefaultImpls.insertInfoDistinctByPath(this, videoInfo, path, __cont);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteInfoById(final int id, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.29
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = VideoInfoDao_Impl.this.__preparedStmtOfDeleteInfoById.acquire();
                _stmt.bindLong(1, id);
                try {
                    VideoInfoDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        VideoInfoDao_Impl.this.__db.endTransaction();
                        VideoInfoDao_Impl.this.__preparedStmtOfDeleteInfoById.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        VideoInfoDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    VideoInfoDao_Impl.this.__preparedStmtOfDeleteInfoById.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteInfoByPath(final String path, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.30
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = VideoInfoDao_Impl.this.__preparedStmtOfDeleteInfoByPath.acquire();
                _stmt.bindString(1, path);
                try {
                    VideoInfoDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        VideoInfoDao_Impl.this.__db.endTransaction();
                        VideoInfoDao_Impl.this.__preparedStmtOfDeleteInfoByPath.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        VideoInfoDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    VideoInfoDao_Impl.this.__preparedStmtOfDeleteInfoByPath.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object deleteTemplateById(final int id, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.31
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = VideoInfoDao_Impl.this.__preparedStmtOfDeleteTemplateById.acquire();
                _stmt.bindLong(1, id);
                try {
                    VideoInfoDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        VideoInfoDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        VideoInfoDao_Impl.this.__db.endTransaction();
                        VideoInfoDao_Impl.this.__preparedStmtOfDeleteTemplateById.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        VideoInfoDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    VideoInfoDao_Impl.this.__preparedStmtOfDeleteTemplateById.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Flow<List<DownloadedVideoInfo>> getDownloadHistoryFlow() {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from DownloadedVideoInfo", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"DownloadedVideoInfo"}, new Callable<List<DownloadedVideoInfo>>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.32
            @Override // java.util.concurrent.Callable
            public List<DownloadedVideoInfo> call() throws Exception {
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfVideoTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "videoTitle");
                    int _cursorIndexOfVideoAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "videoAuthor");
                    int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
                    int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
                    int _cursorIndexOfVideoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "videoPath");
                    int _cursorIndexOfExtractor = CursorUtil.getColumnIndexOrThrow(_cursor, "extractor");
                    List<DownloadedVideoInfo> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpVideoTitle = _cursor.getString(_cursorIndexOfVideoTitle);
                        String _tmpVideoAuthor = _cursor.getString(_cursorIndexOfVideoAuthor);
                        String _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
                        String _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
                        String _tmpVideoPath = _cursor.getString(_cursorIndexOfVideoPath);
                        String _tmpExtractor = _cursor.getString(_cursorIndexOfExtractor);
                        DownloadedVideoInfo _item = new DownloadedVideoInfo(_tmpId, _tmpVideoTitle, _tmpVideoAuthor, _tmpVideoUrl, _tmpThumbnailUrl, _tmpVideoPath, _tmpExtractor);
                        _result.add(_item);
                    }
                    _cursor.close();
                    return _result;
                } catch (Throwable th) {
                    _cursor.close();
                    throw th;
                }
            }

            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object getDownloadHistory(final Continuation<? super List<DownloadedVideoInfo>> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from DownloadedVideoInfo", 0);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<List<DownloadedVideoInfo>>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.33
            @Override // java.util.concurrent.Callable
            public List<DownloadedVideoInfo> call() throws Exception {
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfVideoTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "videoTitle");
                    int _cursorIndexOfVideoAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "videoAuthor");
                    int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
                    int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
                    int _cursorIndexOfVideoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "videoPath");
                    int _cursorIndexOfExtractor = CursorUtil.getColumnIndexOrThrow(_cursor, "extractor");
                    List<DownloadedVideoInfo> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpVideoTitle = _cursor.getString(_cursorIndexOfVideoTitle);
                        String _tmpVideoAuthor = _cursor.getString(_cursorIndexOfVideoAuthor);
                        String _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
                        String _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
                        String _tmpVideoPath = _cursor.getString(_cursorIndexOfVideoPath);
                        String _tmpExtractor = _cursor.getString(_cursorIndexOfExtractor);
                        DownloadedVideoInfo _item = new DownloadedVideoInfo(_tmpId, _tmpVideoTitle, _tmpVideoAuthor, _tmpVideoUrl, _tmpThumbnailUrl, _tmpVideoPath, _tmpExtractor);
                        _result.add(_item);
                    }
                    _cursor.close();
                    _statement.release();
                    return _result;
                } catch (Throwable th) {
                    _cursor.close();
                    _statement.release();
                    throw th;
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object getInfoById(final int id, final Continuation<? super DownloadedVideoInfo> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from DownloadedVideoInfo where id=?", 1);
        _statement.bindLong(1, id);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<DownloadedVideoInfo>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DownloadedVideoInfo call() throws Exception {
                DownloadedVideoInfo _result;
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfVideoTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "videoTitle");
                    int _cursorIndexOfVideoAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "videoAuthor");
                    int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
                    int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
                    int _cursorIndexOfVideoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "videoPath");
                    int _cursorIndexOfExtractor = CursorUtil.getColumnIndexOrThrow(_cursor, "extractor");
                    if (_cursor.moveToFirst()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpVideoTitle = _cursor.getString(_cursorIndexOfVideoTitle);
                        String _tmpVideoAuthor = _cursor.getString(_cursorIndexOfVideoAuthor);
                        String _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
                        String _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
                        String _tmpVideoPath = _cursor.getString(_cursorIndexOfVideoPath);
                        String _tmpExtractor = _cursor.getString(_cursorIndexOfExtractor);
                        _result = new DownloadedVideoInfo(_tmpId, _tmpVideoTitle, _tmpVideoAuthor, _tmpVideoUrl, _tmpThumbnailUrl, _tmpVideoPath, _tmpExtractor);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _cursor.close();
                    _statement.release();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object getInfoByPath(final String path, final Continuation<? super DownloadedVideoInfo> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from DownloadedVideoInfo where videoPath = ?", 1);
        _statement.bindString(1, path);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<DownloadedVideoInfo>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DownloadedVideoInfo call() throws Exception {
                DownloadedVideoInfo _result;
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfVideoTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "videoTitle");
                    int _cursorIndexOfVideoAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "videoAuthor");
                    int _cursorIndexOfVideoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "videoUrl");
                    int _cursorIndexOfThumbnailUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailUrl");
                    int _cursorIndexOfVideoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "videoPath");
                    int _cursorIndexOfExtractor = CursorUtil.getColumnIndexOrThrow(_cursor, "extractor");
                    if (_cursor.moveToFirst()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpVideoTitle = _cursor.getString(_cursorIndexOfVideoTitle);
                        String _tmpVideoAuthor = _cursor.getString(_cursorIndexOfVideoAuthor);
                        String _tmpVideoUrl = _cursor.getString(_cursorIndexOfVideoUrl);
                        String _tmpThumbnailUrl = _cursor.getString(_cursorIndexOfThumbnailUrl);
                        String _tmpVideoPath = _cursor.getString(_cursorIndexOfVideoPath);
                        String _tmpExtractor = _cursor.getString(_cursorIndexOfExtractor);
                        _result = new DownloadedVideoInfo(_tmpId, _tmpVideoTitle, _tmpVideoAuthor, _tmpVideoUrl, _tmpThumbnailUrl, _tmpVideoPath, _tmpExtractor);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _cursor.close();
                    _statement.release();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Flow<List<CommandTemplate>> getTemplateFlow() {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM CommandTemplate", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"CommandTemplate"}, new Callable<List<CommandTemplate>>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.36
            @Override // java.util.concurrent.Callable
            public List<CommandTemplate> call() throws Exception {
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
                    int _cursorIndexOfTemplate = CursorUtil.getColumnIndexOrThrow(_cursor, Route.TEMPLATE);
                    List<CommandTemplate> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpName = _cursor.getString(_cursorIndexOfName);
                        String _tmpTemplate = _cursor.getString(_cursorIndexOfTemplate);
                        CommandTemplate _item = new CommandTemplate(_tmpId, _tmpName, _tmpTemplate);
                        _result.add(_item);
                    }
                    _cursor.close();
                    return _result;
                } catch (Throwable th) {
                    _cursor.close();
                    throw th;
                }
            }

            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object getTemplateList(final Continuation<? super List<CommandTemplate>> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM CommandTemplate", 0);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<List<CommandTemplate>>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.37
            @Override // java.util.concurrent.Callable
            public List<CommandTemplate> call() throws Exception {
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
                    int _cursorIndexOfTemplate = CursorUtil.getColumnIndexOrThrow(_cursor, Route.TEMPLATE);
                    List<CommandTemplate> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpName = _cursor.getString(_cursorIndexOfName);
                        String _tmpTemplate = _cursor.getString(_cursorIndexOfTemplate);
                        CommandTemplate _item = new CommandTemplate(_tmpId, _tmpName, _tmpTemplate);
                        _result.add(_item);
                    }
                    _cursor.close();
                    _statement.release();
                    return _result;
                } catch (Throwable th) {
                    _cursor.close();
                    _statement.release();
                    throw th;
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Flow<List<CookieProfile>> getCookieProfileFlow() {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from CookieProfile", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"CookieProfile"}, new Callable<List<CookieProfile>>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.38
            @Override // java.util.concurrent.Callable
            public List<CookieProfile> call() throws Exception {
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
                    int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
                    List<CookieProfile> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
                        String _tmpContent = _cursor.getString(_cursorIndexOfContent);
                        CookieProfile _item = new CookieProfile(_tmpId, _tmpUrl, _tmpContent);
                        _result.add(_item);
                    }
                    _cursor.close();
                    return _result;
                } catch (Throwable th) {
                    _cursor.close();
                    throw th;
                }
            }

            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object getTemplateById(final int id, final Continuation<? super CommandTemplate> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM CommandTemplate where id = ?", 1);
        _statement.bindLong(1, id);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<CommandTemplate>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.39
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CommandTemplate call() throws Exception {
                CommandTemplate _result;
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
                    int _cursorIndexOfTemplate = CursorUtil.getColumnIndexOrThrow(_cursor, Route.TEMPLATE);
                    if (_cursor.moveToFirst()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpName = _cursor.getString(_cursorIndexOfName);
                        String _tmpTemplate = _cursor.getString(_cursorIndexOfTemplate);
                        _result = new CommandTemplate(_tmpId, _tmpName, _tmpTemplate);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _cursor.close();
                    _statement.release();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object getCookieById(final int id, final Continuation<? super CookieProfile> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from CookieProfile where id=?", 1);
        _statement.bindLong(1, id);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<CookieProfile>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.40
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CookieProfile call() throws Exception {
                CookieProfile _result;
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
                    int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
                    if (_cursor.moveToFirst()) {
                        int _tmpId = _cursor.getInt(_cursorIndexOfId);
                        String _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
                        String _tmpContent = _cursor.getString(_cursorIndexOfContent);
                        _result = new CookieProfile(_tmpId, _tmpUrl, _tmpContent);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _cursor.close();
                    _statement.release();
                }
            }
        }, $completion);
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Flow<List<OptionShortcut>> getOptionShortcuts() {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from OptionShortcut", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"OptionShortcut"}, new Callable<List<OptionShortcut>>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.41
            @Override // java.util.concurrent.Callable
            public List<OptionShortcut> call() throws Exception {
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfOption = CursorUtil.getColumnIndexOrThrow(_cursor, "option");
                    List<OptionShortcut> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        long _tmpId = _cursor.getLong(_cursorIndexOfId);
                        String _tmpOption = _cursor.getString(_cursorIndexOfOption);
                        OptionShortcut _item = new OptionShortcut(_tmpId, _tmpOption);
                        _result.add(_item);
                    }
                    _cursor.close();
                    return _result;
                } catch (Throwable th) {
                    _cursor.close();
                    throw th;
                }
            }

            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override // com.videshkarmakar.loop.database.VideoInfoDao
    public Object getShortcutList(final Continuation<? super List<OptionShortcut>> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("select * from OptionShortcut", 0);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<List<OptionShortcut>>() { // from class: com.videshkarmakar.loop.database.VideoInfoDao_Impl.42
            @Override // java.util.concurrent.Callable
            public List<OptionShortcut> call() throws Exception {
                Cursor _cursor = DBUtil.query(VideoInfoDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfOption = CursorUtil.getColumnIndexOrThrow(_cursor, "option");
                    List<OptionShortcut> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        long _tmpId = _cursor.getLong(_cursorIndexOfId);
                        String _tmpOption = _cursor.getString(_cursorIndexOfOption);
                        OptionShortcut _item = new OptionShortcut(_tmpId, _tmpOption);
                        _result.add(_item);
                    }
                    _cursor.close();
                    _statement.release();
                    return _result;
                } catch (Throwable th) {
                    _cursor.close();
                    _statement.release();
                    throw th;
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
