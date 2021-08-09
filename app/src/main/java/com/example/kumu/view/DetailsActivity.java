package com.example.kumu.view;

import android.os.Bundle;

import com.example.kumu.data.db.models.ItunesDetails;
import com.example.kumu.viewmodel.ItunesDetailViewModel;
import com.example.kumu.viewmodel.ItunesResultsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.kumu.R;

import java.util.List;

import static com.example.kumu.util.Constants.INTENT_EXTRA_SELECTED_ID;

public class DetailsActivity extends AppCompatActivity {

    private long selectedId;
    private ItunesDetailViewModel itunesDetailViewModel;
    private TextView kind;
    private TextView wrappertype;
    private TextView currency;
    private TextView country;
    private TextView collectionname;
    private TextView artistid;
    private TextView artistname;
    private TextView trackcensoredname;
    private TextView releasedate;
    private TextView trackname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        kind = (TextView)findViewById(R.id.kind);
        wrappertype = (TextView)findViewById(R.id.wrapperType);
        currency = (TextView)findViewById(R.id.currency);
        country = (TextView)findViewById(R.id.country);
        collectionname = (TextView)findViewById(R.id.collectionname);
        artistid = (TextView)findViewById(R.id.artistid);
        artistname = (TextView)findViewById(R.id.artistname);
        trackcensoredname = (TextView)findViewById(R.id.trackcensoredname);
        releasedate = (TextView)findViewById(R.id.releasedate);
        trackname = (TextView)findViewById(R.id.trackname);

        selectedId = getIntent().getLongExtra(INTENT_EXTRA_SELECTED_ID, 0);
        itunesDetailViewModel=new ViewModelProvider(this).get(ItunesDetailViewModel.class);

        if(selectedId > 0l) {
            itunesDetailViewModel.getSelectedData(selectedId).observe(this, new Observer<ItunesDetails>() {
                @Override
                public void onChanged(ItunesDetails itunesDetail) {

                    kind.setText("kind  :  ");
                    if(itunesDetail.getKind() != null) {
                        kind.setText("kind  :  " + itunesDetail.getKind());
                    }

                    wrappertype.setText("kind  :  ");
                    if(itunesDetail.getWrapperType() != null) {
                        wrappertype.setText("wrapper type  :  " + itunesDetail.getWrapperType());
                    }

                    artistname.setText("artistName  :  ");
                    if(itunesDetail.getArtistName() != null) {
                        artistname.setText("artistName  :  "+itunesDetail.getArtistName());
                    }

                    artistid.setText("artistId  :  ");
                    if(itunesDetail.getArtistId() > 0) {
                        artistid.setText("artistId  :  "+itunesDetail.getArtistId());
                    }

                    collectionname.setText("collectionName  :  ");
                    if(itunesDetail.getCollectionName() != null) {
                        collectionname.setText("collectionName  :  "+itunesDetail.getCollectionName());
                    }

                    trackname.setText("trackName  :  ");
                    if(itunesDetail.getTrackName() != null) {
                        trackname.setText("trackName  :  "+itunesDetail.getTrackName());
                    }

                    releasedate.setText("releaseDate  :  ");
                    if(itunesDetail.getReleaseDate() != null) {
                        releasedate.setText("releaseDate  :  "+itunesDetail.getReleaseDate());
                    }

                    trackcensoredname.setText("trackCensoredName  :  ");
                    if(itunesDetail.getTrackCensoredName() != null) {
                        trackcensoredname.setText("trackCensoredName  :  "+itunesDetail.getTrackCensoredName());
                    }

                    currency.setText("currency  :  ");
                    if(itunesDetail.getCurrency() != null) {
                        currency.setText("currency  :  "+itunesDetail.getCurrency());
                    }

                    country.setText("country  :  ");
                    if(itunesDetail.getCountry() != null) {
                        country.setText("country  :  "+itunesDetail.getCountry());
                    }

                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}