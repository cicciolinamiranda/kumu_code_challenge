package com.example.kumu.api.itunes;

import com.example.kumu.data.dto.ItunesResultsDTO;

import java.math.BigInteger;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItunesRestService {

    @GET("search")
    Call<ItunesResultsDTO> getItunesResults(@Query("term") String term);
}
