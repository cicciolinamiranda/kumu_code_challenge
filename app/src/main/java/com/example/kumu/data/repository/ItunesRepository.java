package com.example.kumu.data.repository;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.kumu.data.db.AppDatabase;
import com.example.kumu.data.db.models.ItunesDetails;
import com.example.kumu.data.repository.asynctask.InsertAsyncTask;

import java.util.List;

public class ItunesRepository {
    private AppDatabase db;

    public ItunesRepository(@NonNull Application application){
        db = AppDatabase.getDatabase(application);

    }

    public int update(ItunesDetails detail){
        return db.itunesDao().update(detail);
    }


    public void insertList(List<ItunesDetails> itunesDetails){
        new InsertAsyncTask(db).execute(itunesDetails);
    }

    public LiveData<List<ItunesDetails>> getAllResults(){
        return db.itunesDao().getAllResults();
    }

    public LiveData<List<ItunesDetails>> getResultsBasedOnQuery(String query){
        return db.itunesDao().getResultsBasedOnQuery("%"+query+"%");
    }

    public Long getIdOfExistingRecord(int collectionId, int artistId,String trackname) {
        return db.itunesDao().getIdOfExistingRecord(collectionId, artistId, trackname);
    }

}
