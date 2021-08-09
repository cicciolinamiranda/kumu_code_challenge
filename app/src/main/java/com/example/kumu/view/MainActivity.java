package com.example.kumu.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.kumu.R;
import com.example.kumu.api.Api;
import com.example.kumu.api.itunes.ItunesRestService;
import com.example.kumu.data.db.models.ItunesDetails;
import com.example.kumu.data.dto.ItunesResultsDTO;
import com.example.kumu.data.repository.ItunesRepository;
import com.example.kumu.viewmodel.ItunesResultsViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.recyclerview.widget.DividerItemDecoration.VERTICAL;
import static com.example.kumu.util.Constants.INTENT_EXTRA_SELECTED_ID;

public class MainActivity extends AppCompatActivity implements AdapterItunesResults.Listener {

    private ItunesResultsViewModel itunesResultsViewModel;
    private List<ItunesDetails> getItunesResults;
    private AdapterItunesResults adapterItunesResults;
    private DividerItemDecoration itemDecor;

    private RecyclerView recyclerView;
//    private ItunesRepository repository;
    private androidx.appcompat.widget.SearchView searchView;
    private String query = "";

    private Observer<? super List<ItunesDetails>> repositoryObserver = new Observer<List<ItunesDetails>>() {
        @Override
        public void onChanged(List<ItunesDetails> itunesDetails) {
            recyclerView.setAdapter(adapterItunesResults);
            adapterItunesResults.getAllDatas(itunesDetails, query);
            Log.d(MainActivity.class.getSimpleName(),  "onChanged: "+itunesDetails);
        }
    };

    private SearchView.OnQueryTextListener searchViewListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            searchView.clearFocus();
            return true;
        }

        @Override
        public boolean onQueryTextChange(String query) {
            MainActivity.this.query = query;
            makeRequest();
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getItunesResults=new ArrayList<>();
        recyclerView=findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemDecor = new DividerItemDecoration(recyclerView.getContext(), VERTICAL) {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                // hide the divider for the last child
                if (position == state.getItemCount() - 1) {
                    outRect.setEmpty();
                } else {
                    super.getItemOffsets(outRect, view, parent, state);
                }
            }
        };
        itemDecor.setDrawable(ContextCompat.getDrawable(this, R.drawable.dark_grey_divider));
        recyclerView.addItemDecoration(itemDecor);

        searchView = findViewById(R.id.search);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setIconified(false);
            }
        });

        searchView.setOnQueryTextListener(searchViewListener);
        itunesResultsViewModel=new ViewModelProvider(this).get(ItunesResultsViewModel.class);

        adapterItunesResults=new AdapterItunesResults(this, getItunesResults, this);
        makeRequest();
    }

    private void makeRequest() {
        itunesResultsViewModel.getResultsBasedOnQuery(query).observe(MainActivity.this, repositoryObserver);
        ItunesRestService itunesRestService= Api.getClient(this).create(ItunesRestService.class);

        Call<ItunesResultsDTO> requestDTOcall = itunesRestService.getItunesResults(query);
        requestDTOcall.enqueue(new Callback<ItunesResultsDTO>() {
            @Override
            public void onResponse(Call<ItunesResultsDTO> call, Response<ItunesResultsDTO> response) {
                if(response != null && response.body() != null && response.body().getResults() != null) {
                    List<ItunesDetails> toBeInserted = new ArrayList<>();
                    for(ItunesDetails recordsFromServer: response.body().getResults()) {
                        Long existingId = itunesResultsViewModel.getIdOfExistingRecord(recordsFromServer.collectionId, recordsFromServer.getArtistId(), recordsFromServer.getTrackName());
                        if(existingId != null) {
                            recordsFromServer.setId(existingId);
                            itunesResultsViewModel.update(recordsFromServer);
                        } else {
                            toBeInserted.add(recordsFromServer);
                        }
                    }
                    if(!toBeInserted.isEmpty()) {
                        itunesResultsViewModel.insertList(toBeInserted);
                    }
                }
            }

            @Override
            public void onFailure(Call<ItunesResultsDTO> call, Throwable t) {
                Log.d(MainActivity.class.getSimpleName(), "onFailure: "+t.getMessage());
            }
        });

    }

    @Override
    public void setSelectedItunesResult(ItunesDetails itunesDetails) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(INTENT_EXTRA_SELECTED_ID, itunesDetails.getId());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}