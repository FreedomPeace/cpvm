package com.example.mvp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {LogInfo.class}, version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LogInfoDao getLogInfoDao();

    private static AppDatabase ourInstance;

    public static AppDatabase getInstance(Context context) {
        synchronized (AppDatabase.class) {
            if (ourInstance == null) {
                synchronized (AppDatabase.class) {
                    ourInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "jack.db")
                            .build();
                }
            }
        }
        return ourInstance;
    }

    public AppDatabase() {
    }
}
