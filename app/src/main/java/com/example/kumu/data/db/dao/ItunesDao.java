package com.example.kumu.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kumu.data.db.models.ItunesDetails;

import java.util.List;

@Dao
public interface ItunesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ItunesDetails> itunesDetails);

    @Query("SELECT DISTINCT * FROM itunedetails ORDER BY releaseDate ASC")
    LiveData<List<ItunesDetails>> getAllResults();

    @Query("SELECT DISTINCT * FROM itunedetails WHERE LOWER(trackName)  LIKE LOWER(:query) ORDER BY releaseDate ASC")
    LiveData<List<ItunesDetails>> getResultsBasedOnQuery(String query);

    @Query("SELECT DISTINCT * FROM itunedetails WHERE id=:id LIMIT 1")
    LiveData<ItunesDetails> findFirstById(Long id);

    @Query("DELETE FROM itunedetails")
    void deleteAll();

    @Update
    int update(ItunesDetails itunesDetails);

    @Query("SELECT id FROM itunedetails where collectionId=:collectionId AND artistId=:artistId AND trackName=:trackName LIMIT 1")
    Long getIdOfExistingRecord(int collectionId, int artistId, String trackName);
}
