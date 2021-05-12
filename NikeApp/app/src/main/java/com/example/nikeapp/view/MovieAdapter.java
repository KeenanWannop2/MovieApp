package com.example.nikeapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nikeapp.R;
import com.example.nikeapp.model.MovieResponse;
import com.example.nikeapp.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Result> data;

    public MovieAdapter(MovieResponse data) {
        this.data = data.getResults();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_movie_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions().centerInside();
        if (data.get(position).getPosterPath() != null) {
            //tmdb gives us poster path, append to address, access with Glide
            String jpgPath = "https://image.tmdb.org/t/p/w500" + data.get(position).getPosterPath();

            Glide.with(holder.itemView.getContext())
                    .load(jpgPath)
                    .apply(requestOptions)
                    .into(holder.image);
        }
        //Set the movie title and user rating
        holder.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private final TextView tvMovieTitle;
        private final TextView tvMovieRating;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivMoviePoster);
            tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);
            tvMovieRating = itemView.findViewById(R.id.tvMovieRating);
        }

        public void setText(Result result) {
            if (result.getTitle() != null)
                tvMovieTitle.setText(result.getTitle());
            if (result.getVoteAverage() != null)
                tvMovieRating.setText("" + result.getVoteAverage());
        }
    }
}
