package com.example.kumu.data.dto;

import com.example.kumu.data.db.models.ItunesDetails;

import java.util.List;

public class ItunesResultsDTO {
    public int resultCount;
    public List<ItunesDetails> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<ItunesDetails> getResults() {
        return results;
    }

    public void setResults(List<ItunesDetails> results) {
        this.results = results;
    }
}
