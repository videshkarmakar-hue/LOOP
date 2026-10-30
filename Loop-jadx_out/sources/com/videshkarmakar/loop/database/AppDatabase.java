package com.videshkarmakar.loop.database;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.RoomDatabase;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppDatabase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m194d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, m195d2 = {"Lcom/videshkarmakar/loop/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "videoInfoDao", "Lcom/videshkarmakar/loop/database/VideoInfoDao;", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class AppDatabase extends RoomDatabase {
    public static final int $stable = 0;

    public abstract VideoInfoDao videoInfoDao();
}
