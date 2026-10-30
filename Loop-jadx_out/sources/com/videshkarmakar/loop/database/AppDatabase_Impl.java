package com.videshkarmakar.loop.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p004db.SupportSQLiteDatabase;
import androidx.sqlite.p004db.SupportSQLiteOpenHelper;
import com.videshkarmakar.loop.p006ui.common.Route;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private volatile VideoInfoDao _videoInfoDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) { // from class: com.videshkarmakar.loop.database.AppDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `DownloadedVideoInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `videoTitle` TEXT NOT NULL, `videoAuthor` TEXT NOT NULL, `videoUrl` TEXT NOT NULL, `thumbnailUrl` TEXT NOT NULL, `videoPath` TEXT NOT NULL, `extractor` TEXT NOT NULL DEFAULT 'Unknown')");
                db.execSQL("CREATE TABLE IF NOT EXISTS `CommandTemplate` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `template` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `CookieProfile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT NOT NULL, `content` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `OptionShortcut` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `option` TEXT NOT NULL)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5eab3a1c93713521f1197fa2e2903231')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `DownloadedVideoInfo`");
                db.execSQL("DROP TABLE IF EXISTS `CommandTemplate`");
                db.execSQL("DROP TABLE IF EXISTS `CookieProfile`");
                db.execSQL("DROP TABLE IF EXISTS `OptionShortcut`");
                List<? extends RoomDatabase.Callback> _callbacks = AppDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List<? extends RoomDatabase.Callback> _callbacks = AppDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                AppDatabase_Impl.this.mDatabase = db;
                AppDatabase_Impl.this.internalInitInvalidationTracker(db);
                List<? extends RoomDatabase.Callback> _callbacks = AppDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap<String, TableInfo.Column> _columnsDownloadedVideoInfo = new HashMap<>(7);
                _columnsDownloadedVideoInfo.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsDownloadedVideoInfo.put("videoTitle", new TableInfo.Column("videoTitle", "TEXT", true, 0, null, 1));
                _columnsDownloadedVideoInfo.put("videoAuthor", new TableInfo.Column("videoAuthor", "TEXT", true, 0, null, 1));
                _columnsDownloadedVideoInfo.put("videoUrl", new TableInfo.Column("videoUrl", "TEXT", true, 0, null, 1));
                _columnsDownloadedVideoInfo.put("thumbnailUrl", new TableInfo.Column("thumbnailUrl", "TEXT", true, 0, null, 1));
                _columnsDownloadedVideoInfo.put("videoPath", new TableInfo.Column("videoPath", "TEXT", true, 0, null, 1));
                _columnsDownloadedVideoInfo.put("extractor", new TableInfo.Column("extractor", "TEXT", true, 0, "'Unknown'", 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysDownloadedVideoInfo = new HashSet<>(0);
                HashSet<TableInfo.Index> _indicesDownloadedVideoInfo = new HashSet<>(0);
                TableInfo _infoDownloadedVideoInfo = new TableInfo("DownloadedVideoInfo", _columnsDownloadedVideoInfo, _foreignKeysDownloadedVideoInfo, _indicesDownloadedVideoInfo);
                TableInfo _existingDownloadedVideoInfo = TableInfo.read(db, "DownloadedVideoInfo");
                if (!_infoDownloadedVideoInfo.equals(_existingDownloadedVideoInfo)) {
                    return new RoomOpenHelper.ValidationResult(false, "DownloadedVideoInfo(com.videshkarmakar.loop.database.objects.DownloadedVideoInfo).\n Expected:\n" + _infoDownloadedVideoInfo + "\n Found:\n" + _existingDownloadedVideoInfo);
                }
                HashMap<String, TableInfo.Column> _columnsCommandTemplate = new HashMap<>(3);
                _columnsCommandTemplate.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsCommandTemplate.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                _columnsCommandTemplate.put(Route.TEMPLATE, new TableInfo.Column(Route.TEMPLATE, "TEXT", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysCommandTemplate = new HashSet<>(0);
                HashSet<TableInfo.Index> _indicesCommandTemplate = new HashSet<>(0);
                TableInfo _infoCommandTemplate = new TableInfo("CommandTemplate", _columnsCommandTemplate, _foreignKeysCommandTemplate, _indicesCommandTemplate);
                TableInfo _existingCommandTemplate = TableInfo.read(db, "CommandTemplate");
                if (!_infoCommandTemplate.equals(_existingCommandTemplate)) {
                    return new RoomOpenHelper.ValidationResult(false, "CommandTemplate(com.videshkarmakar.loop.database.objects.CommandTemplate).\n Expected:\n" + _infoCommandTemplate + "\n Found:\n" + _existingCommandTemplate);
                }
                HashMap<String, TableInfo.Column> _columnsCookieProfile = new HashMap<>(3);
                _columnsCookieProfile.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsCookieProfile.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, 1));
                _columnsCookieProfile.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysCookieProfile = new HashSet<>(0);
                HashSet<TableInfo.Index> _indicesCookieProfile = new HashSet<>(0);
                TableInfo _infoCookieProfile = new TableInfo("CookieProfile", _columnsCookieProfile, _foreignKeysCookieProfile, _indicesCookieProfile);
                TableInfo _existingCookieProfile = TableInfo.read(db, "CookieProfile");
                if (!_infoCookieProfile.equals(_existingCookieProfile)) {
                    return new RoomOpenHelper.ValidationResult(false, "CookieProfile(com.videshkarmakar.loop.database.objects.CookieProfile).\n Expected:\n" + _infoCookieProfile + "\n Found:\n" + _existingCookieProfile);
                }
                HashMap<String, TableInfo.Column> _columnsOptionShortcut = new HashMap<>(2);
                _columnsOptionShortcut.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsOptionShortcut.put("option", new TableInfo.Column("option", "TEXT", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysOptionShortcut = new HashSet<>(0);
                HashSet<TableInfo.Index> _indicesOptionShortcut = new HashSet<>(0);
                TableInfo _infoOptionShortcut = new TableInfo("OptionShortcut", _columnsOptionShortcut, _foreignKeysOptionShortcut, _indicesOptionShortcut);
                TableInfo _existingOptionShortcut = TableInfo.read(db, "OptionShortcut");
                return !_infoOptionShortcut.equals(_existingOptionShortcut) ? new RoomOpenHelper.ValidationResult(false, "OptionShortcut(com.videshkarmakar.loop.database.objects.OptionShortcut).\n Expected:\n" + _infoOptionShortcut + "\n Found:\n" + _existingOptionShortcut) : new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "5eab3a1c93713521f1197fa2e2903231", "30e7295678fb35c74a0fabc4c1663dff");
        SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
        SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
        return _helper;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        HashMap<String, String> _shadowTablesMap = new HashMap<>(0);
        HashMap<String, Set<String>> _viewTables = new HashMap<>(0);
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "DownloadedVideoInfo", "CommandTemplate", "CookieProfile", "OptionShortcut");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            _db.execSQL("DELETE FROM `DownloadedVideoInfo`");
            _db.execSQL("DELETE FROM `CommandTemplate`");
            _db.execSQL("DELETE FROM `CookieProfile`");
            _db.execSQL("DELETE FROM `OptionShortcut`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            _db.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!_db.inTransaction()) {
                _db.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<>();
        _typeConvertersMap.put(VideoInfoDao.class, VideoInfoDao_Impl.getRequiredConverters());
        return _typeConvertersMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<>();
        return _autoMigrationSpecsSet;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        List<Migration> _autoMigrations = new ArrayList<>();
        _autoMigrations.add(new AppDatabase_AutoMigration_1_2_Impl());
        _autoMigrations.add(new AppDatabase_AutoMigration_2_3_Impl());
        _autoMigrations.add(new AppDatabase_AutoMigration_3_4_Impl());
        _autoMigrations.add(new AppDatabase_AutoMigration_4_5_Impl());
        return _autoMigrations;
    }

    @Override // com.videshkarmakar.loop.database.AppDatabase
    public VideoInfoDao videoInfoDao() {
        VideoInfoDao videoInfoDao;
        if (this._videoInfoDao != null) {
            return this._videoInfoDao;
        }
        synchronized (this) {
            if (this._videoInfoDao == null) {
                this._videoInfoDao = new VideoInfoDao_Impl(this);
            }
            videoInfoDao = this._videoInfoDao;
        }
        return videoInfoDao;
    }
}
