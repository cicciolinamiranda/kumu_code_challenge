package com.example.kumu.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.kumu.data.db.dao.ItunesDao;
import com.example.kumu.data.db.models.ItunesDetails;

@Database(entities = {ItunesDetails.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ItunesDao itunesDao();

    public static AppDatabase getDatabase(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "kumu_for_android.db")


                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
