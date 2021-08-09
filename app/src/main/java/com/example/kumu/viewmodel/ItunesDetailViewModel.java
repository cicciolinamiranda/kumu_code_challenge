package com.example.kumu.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kumu.data.db.models.ItunesDetails;
import com.example.kumu.data.repository.ItunesDetailsRepository;
import com.example.kumu.data.repository.ItunesRepository;

import java.util.List;

public class ItunesDetailViewModel extends AndroidViewModel {
    private ItunesDetailsRepository itunesDetailsRepository;
    public LiveData<ItunesDetails> selectedData;


    public ItunesDetailViewModel(@NonNull Application application) {
        super(application);
        itunesDetailsRepository = new ItunesDetailsRepository(application);
    }

    public LiveData<ItunesDetails> getSelectedData(Long id)
    {
        return itunesDetailsRepository.getSelectedData(id);
    }
}

