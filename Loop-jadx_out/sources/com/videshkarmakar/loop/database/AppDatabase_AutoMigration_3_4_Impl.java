package com.videshkarmakar.loop.database;

import androidx.room.migration.Migration;
import androidx.sqlite.p004db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
final class AppDatabase_AutoMigration_3_4_Impl extends Migration {
    public AppDatabase_AutoMigration_3_4_Impl() {
        super(3, 4);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `CookieProfile` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT NOT NULL, `content` TEXT NOT NULL)");
    }
}
