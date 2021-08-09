package com.example.kumu.data.repository.asynctask;

import android.os.AsyncTask;

import com.example.kumu.data.db.AppDatabase;
import com.example.kumu.data.db.models.ItunesDetails;

import java.util.List;

public class InsertAsyncTask extends AsyncTask<List<ItunesDetails>,Void,Void> {

    private AppDatabase db;

    public InsertAsyncTask(AppDatabase db)
    {
        this.db=db;
    }
    @Override
    protected Void doInBackground(List<ItunesDetails>... lists) {
        db.itunesDao().insert(lists[0]);
        return null;
    }
}
