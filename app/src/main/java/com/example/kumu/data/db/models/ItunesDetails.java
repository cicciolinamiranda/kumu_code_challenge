package com.example.kumu.data.db.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.kumu.data.db.Converters;

import java.util.Date;

@Entity(tableName = "itunedetails")
@TypeConverters(Converters.class)
public class ItunesDetails {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;
    public String wrapperType;
    public String kind;
    public int collectionId;
    public int trackId;
    public String artistName;
    public String collectionName;
    public String trackName;
    public String collectionCensoredName;
    public String trackCensoredName;
    public int collectionArtistId;
    public String collectionArtistViewUrl;
    public String collectionViewUrl;
    public String trackViewUrl;
    public String previewUrl;
    public String artworkUrl30;
    public String artworkUrl60;
    public String artworkUrl100;
    public double collectionPrice;
    public double trackPrice;
    public double trackRentalPrice;
    public double collectionHdPrice;
    public double trackHdPrice;
    public double trackHdRentalPrice;
    public Date releaseDate;
    public String collectionExplicitness;
    public String trackExplicitness;
    public int discCount;
    public int discNumber;
    public int trackCount;
    public int trackNumber;
    public int trackTimeMillis;
    public String country;
    public String currency;
    public String primaryGenreName;
    public String contentAdvisoryRating;
    public String longDescription;
    public boolean hasITunesExtras;
    public String shortDescription;
    public int artistId;
    public String artistViewUrl;
    public boolean isStreamable;
    public String collectionArtistName;
    public String copyright;
    public String description;

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public int getCollectionArtistId() {
        return collectionArtistId;
    }

    public void setCollectionArtistId(int collectionArtistId) {
        this.collectionArtistId = collectionArtistId;
    }

    public String getCollectionArtistViewUrl() {
        return collectionArtistViewUrl;
    }

    public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
        this.collectionArtistViewUrl = collectionArtistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public double getTrackRentalPrice() {
        return trackRentalPrice;
    }

    public void setTrackRentalPrice(double trackRentalPrice) {
        this.trackRentalPrice = trackRentalPrice;
    }

    public double getCollectionHdPrice() {
        return collectionHdPrice;
    }

    public void setCollectionHdPrice(double collectionHdPrice) {
        this.collectionHdPrice = collectionHdPrice;
    }

    public double getTrackHdPrice() {
        return trackHdPrice;
    }

    public void setTrackHdPrice(double trackHdPrice) {
        this.trackHdPrice = trackHdPrice;
    }

    public double getTrackHdRentalPrice() {
        return trackHdRentalPrice;
    }

    public void setTrackHdRentalPrice(double trackHdRentalPrice) {
        this.trackHdRentalPrice = trackHdRentalPrice;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public int getDiscCount() {
        return discCount;
    }

    public void setDiscCount(int discCount) {
        this.discCount = discCount;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(int trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isHasITunesExtras() {
        return hasITunesExtras;
    }

    public void setHasITunesExtras(boolean hasITunesExtras) {
        this.hasITunesExtras = hasITunesExtras;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public boolean isStreamable() {
        return isStreamable;
    }

    public void setStreamable(boolean streamable) {
        isStreamable = streamable;
    }

    public String getCollectionArtistName() {
        return collectionArtistName;
    }

    public void setCollectionArtistName(String collectionArtistName) {
        this.collectionArtistName = collectionArtistName;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return trackName != null ? trackName : "";
    }
}
