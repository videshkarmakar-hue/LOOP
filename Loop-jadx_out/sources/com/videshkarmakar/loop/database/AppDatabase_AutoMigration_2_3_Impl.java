package com.videshkarmakar.loop.database;

import androidx.room.migration.Migration;
import androidx.sqlite.p004db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
final class AppDatabase_AutoMigration_2_3_Impl extends Migration {
    public AppDatabase_AutoMigration_2_3_Impl() {
        super(2, 3);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `CommandTemplate` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `template` TEXT NOT NULL)");
    }
}
