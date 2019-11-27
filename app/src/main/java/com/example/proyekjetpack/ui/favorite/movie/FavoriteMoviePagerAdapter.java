package com.example.proyekjetpack.ui.favorite.movie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.ui.detail.movie.DetailMovieActivity;

public class FavoriteMoviePagerAdapter extends PagedListAdapter<MovieDetail, FavoriteMoviePagerAdapter.FavoriteMovieViewHolder> {

    private FavoriteMovieFragmentCallback callback;
    private final Activity activity;

    FavoriteMoviePagerAdapter(FavoriteMovieFragmentCallback callback, Activity activity) {
        super(DIFF_CALLBACK);

        this.callback = callback;
        this.activity = activity;
    }


    @NonNull
    @Override
    public FavoriteMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new FavoriteMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMovieViewHolder holder, int position) {
        final MovieDetail favorite = getItem(position);
        if (favorite != null){
            holder.imgShare.setVisibility(View.VISIBLE);
            holder.tvTitle.setText(favorite.getTitle());
            holder.tvRelease.setText(favorite.getRelease_date().split("-")[0]);
            int length = favorite.getOverview().length();
            if (length > 120){
                holder.tvDesc.setText(favorite.getOverview().substring(0, 100) + "...");
            }else {
                holder.tvDesc.setText(favorite.getOverview());
            }

            Glide.with(holder.itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500"+favorite.getPoster_path())
                    .apply(new RequestOptions().override(350, 550))
                    .into(holder.imgIcon);

            holder.imgShare.setOnClickListener(view -> {
                MovieDetail movie = new MovieDetail(favorite.getId(),
                        favorite.getTitle(),
                        favorite.getVote_average(),
                        favorite.getBackdrop_path(),
                        favorite.getPoster_path(),
                        favorite.getOverview(),
                        favorite.getRelease_date(),
                        false,
                        favorite.getGenreModels());
                callback.onShareClick(movie);
            });

            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(activity, DetailMovieActivity.class);
                int movieId = favorite.getId();
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movieId);
                Pair<View, String> p1 = Pair.create(holder.imgIcon, "postermovie");
                Pair<View, String> p2 = Pair.create(holder.tvTitle, "titlemovie");
                Pair<View, String> p3 = Pair.create(holder.tvRelease, "releasemovie");
                Pair<View, String> p4 = Pair.create(holder.tvDesc, "overviewmovie");
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(activity, p1, p2, p3, p4);
                activity.startActivity(intent, options.toBundle());
            });


        }
    }

    private static DiffUtil.ItemCallback<MovieDetail> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieDetail>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieDetail oldItem, @NonNull MovieDetail newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieDetail oldItem, @NonNull MovieDetail newItem) {
                    return oldItem.equals(newItem);
                }
            };

    MovieDetail getItemById(int swipedPosition){
        return getItem(swipedPosition);
    }

    class FavoriteMovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvRelease, tvDesc;
        final ImageView imgIcon;
        final ImageButton imgShare;
        FavoriteMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleMovie);
            tvRelease = itemView.findViewById(R.id.tvReleaseMovie);
            tvDesc = itemView.findViewById(R.id.tvOverviewMovie);
            imgIcon = itemView.findViewById(R.id.imgPosterMovie);
            imgShare = itemView.findViewById(R.id.img_share);

        }
    }
}
