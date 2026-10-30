package com.videshkarmakar.loop.database;

import androidx.room.migration.Migration;
import androidx.sqlite.p004db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
final class AppDatabase_AutoMigration_4_5_Impl extends Migration {
    public AppDatabase_AutoMigration_4_5_Impl() {
        super(4, 5);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `OptionShortcut` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `option` TEXT NOT NULL)");
    }
}
