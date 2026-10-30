package com.videshkarmakar.loop.database;

import androidx.room.migration.Migration;
import androidx.sqlite.p004db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
final class AppDatabase_AutoMigration_1_2_Impl extends Migration {
    public AppDatabase_AutoMigration_1_2_Impl() {
        super(1, 2);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("ALTER TABLE `DownloadedVideoInfo` ADD COLUMN `extractor` TEXT NOT NULL DEFAULT 'Unknown'");
    }
}
