package com.example.proyekjetpack.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.ui.detail.movie.DetailMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final Activity activity;
    private List<MovieModel> mMovie = new ArrayList<>();

    public MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<MovieModel> getListMovies() {
        return mMovie;
    }

    void setListMoview(List<MovieModel> listMovies) {
        if (listMovies == null) return;
        this.mMovie.clear();
        this.mMovie.addAll(listMovies);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getListMovies().get(position).getTitle());
        holder.tvRelease.setText(getListMovies().get(position).getRelease_date().split("-")[0]);
        int length = getListMovies().get(position).getOverview().length();
        if (length > 120) {
            holder.tvDesc.setText(getListMovies().get(position).getOverview().substring(0, 100) + "...");
        } else {
            holder.tvDesc.setText(getListMovies().get(position).getOverview());
        }

        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" + getListMovies().get(position).getPoster_path())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgIcon);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getListMovies().get(position).getId());
            Pair<View, String> p1 = Pair.create(holder.imgIcon, "postermovie");
            Pair<View, String> p2 = Pair.create(holder.tvTitle, "titlemovie");
            Pair<View, String> p3 = Pair.create(holder.tvRelease, "releasemovie");
            Pair<View, String> p4 = Pair.create(holder.tvDesc, "overviewmovie");
            ActivityOptionsCompat options = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(activity, p1, p2, p3, p4);
            activity.startActivity(intent, options.toBundle());

        });

    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvRelease, tvDesc;
        final ImageView imgIcon;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleMovie);
            tvRelease = itemView.findViewById(R.id.tvReleaseMovie);
            tvDesc = itemView.findViewById(R.id.tvOverviewMovie);
            imgIcon = itemView.findViewById(R.id.imgPosterMovie);
        }
    }
}
