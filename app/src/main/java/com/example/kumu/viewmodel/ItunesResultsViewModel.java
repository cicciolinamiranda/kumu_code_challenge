package com.example.kumu.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kumu.data.db.AppDatabase;
import com.example.kumu.data.db.models.ItunesDetails;
import com.example.kumu.data.repository.ItunesRepository;

import java.util.List;

public class ItunesResultsViewModel extends AndroidViewModel {
    private ItunesRepository itunesRepository;


    public ItunesResultsViewModel(@NonNull Application application) {
        super(application);
        itunesRepository = new ItunesRepository(application);
    }

    public void insertList(List<ItunesDetails> itunesDetails){
        itunesRepository.insertList(itunesDetails);
    }

    public int update(ItunesDetails detail){
        return itunesRepository.update(detail);
    }

    public LiveData<List<ItunesDetails>> getResultsBasedOnQuery(String query)
    {
        if(query == null || query.isEmpty()) {
            return itunesRepository.getAllResults();
        }
        return itunesRepository.getResultsBasedOnQuery(query);
    }

    public Long getIdOfExistingRecord(int collectionId, int artistId,String trackname)
    {
        return itunesRepository.getIdOfExistingRecord(collectionId, artistId, trackname);
    }
}

