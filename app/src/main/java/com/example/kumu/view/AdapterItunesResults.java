package com.example.kumu.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kumu.R;
import com.example.kumu.data.db.models.ItunesDetails;

import java.util.ArrayList;
import java.util.List;

public class AdapterItunesResults extends RecyclerView.Adapter<AdapterItunesResults.ViewHolder> {

    private Context mContext;
    private List<ItunesDetails> mValues;
    private Listener mListener;

    public AdapterItunesResults(Context mContext, List<ItunesDetails> mValues, Listener mListener) {
        this.mContext = mContext;
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_itunes_details_list, parent, false);

        return new AdapterItunesResults.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setSelectedItunesResult(holder.mItem);
            }
        });
        Glide.with(mContext)
                .load(holder.mItem.getArtworkUrl60())
                .into(holder.imageView);

        holder.trackName.setText(holder.mItem.getTrackName());

        holder.genre.setText(holder.mItem.getPrimaryGenreName());
        holder.price.setText("Price:"+holder.mItem.getTrackPrice() +" USD");
    }

    @Override
    public int getItemCount() {
        return this.mValues != null ? this.mValues.size() : 0;
    }

    public void getAllDatas(List<ItunesDetails> values, String query) {
        this.mValues = values;

        if (query == null || query.isEmpty()) {

            this.mValues = values;
        } else {

            ArrayList<ItunesDetails> filteredList = new ArrayList<>();


            if(values != null) {
                for (ItunesDetails model : values) {

                    if (model.toString() != null &&
                            model.toString().toLowerCase().indexOf(query.toLowerCase()) > -1) {

                        filteredList.add(model);
                    }
                }
            }

            this.mValues = filteredList;
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public LinearLayout container;
        public ImageView imageView;
        public TextView trackName;
        public TextView genre;
        public TextView price;
        public ItunesDetails mItem;

        public ViewHolder(@NonNull View convertView) {
            super(convertView);
            mView = convertView;
            container = (LinearLayout) convertView.findViewById(R.id.container);

            imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);

            trackName = (TextView) convertView.findViewById(R.id.trackName);

            genre = (TextView) convertView.findViewById(R.id.genre);

            price = (TextView) convertView.findViewById(R.id.price);
        }

    }

    public interface Listener {
        void setSelectedItunesResult(ItunesDetails itunesDetails);
    }
}
