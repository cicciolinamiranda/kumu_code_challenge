package com.example.kumu.data.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.kumu.data.db.AppDatabase;
import com.example.kumu.data.db.models.ItunesDetails;
import com.example.kumu.data.repository.asynctask.InsertAsyncTask;

import java.util.List;

public class ItunesDetailsRepository {
    private AppDatabase db;

    public ItunesDetailsRepository(@NonNull Application application){
        db = AppDatabase.getDatabase(application);
    }

    public LiveData<ItunesDetails> getSelectedData(Long id){
        return db.itunesDao().findFirstById(id);
    }

}
