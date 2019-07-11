package com.integra.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Model.class, version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase {

    private static DB db;

    public static synchronized DB getInstance(Context context) {
        if (null == db) {
            db = Room.databaseBuilder(context, DB.class, "DB").build();
        }
        return db;
    }

    public abstract ModelDao modelDao();
}
