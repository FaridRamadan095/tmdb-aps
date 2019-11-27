package com.example.proyekjetpack.ui.favorite.tv;

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
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.ui.detail.tv.DetailTvActivity;

public class FavoriteTvPagerAdapter extends PagedListAdapter<TvShowDetail, FavoriteTvPagerAdapter.FavoriteTvViewHolder> {

    private FavoriteTvFragmentCallback callback;
    private final Activity activity;

    FavoriteTvPagerAdapter(FavoriteTvFragmentCallback callback, Activity activity){
        super(DIFF_CALLBACK);

        this.callback = callback;
        this.activity = activity;
    }


    @NonNull
    @Override
    public FavoriteTvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvshow, parent, false);
        return new FavoriteTvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTvViewHolder holder, int position) {
        final TvShowDetail favorite = getItem(position);
        if (favorite != null){
            holder.imgShare.setVisibility(View.VISIBLE);
            holder.tvTitle.setText(favorite.getName());
            holder.tvRelease.setText(favorite.getFirst_air_date().split("-")[0]);
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
                TvShowDetail tv = new TvShowDetail(favorite.getId(),
                        favorite.getName(),
                        favorite.getVote_average(),
                        favorite.getBackdrop_path(),
                        favorite.getPoster_path(),
                        favorite.getOverview(),
                        favorite.getFirst_air_date(),
                        false,
                        favorite.getGenreModels());
                callback.onShareClick(tv);
            });

            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(activity, DetailTvActivity.class);
                int tvId = favorite.getId();
                intent.putExtra(DetailTvActivity.EXTRA_TV, tvId);
                Pair<View, String> p1 = Pair.create(holder.imgIcon, "postertv");
                Pair<View, String> p2 = Pair.create(holder.tvTitle, "titletv");
                Pair<View, String> p3 = Pair.create(holder.tvRelease, "releasetv");
                Pair<View, String> p4 = Pair.create(holder.tvDesc, "overviewtv");
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(activity, p1, p2, p3, p4);
                activity.startActivity(intent, options.toBundle());
            });
        }
    }

    private static DiffUtil.ItemCallback<TvShowDetail> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvShowDetail>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvShowDetail oldItem, @NonNull TvShowDetail newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvShowDetail oldItem, @NonNull TvShowDetail newItem) {
                    return oldItem.equals(newItem);
                }
            };

    TvShowDetail getItemById(int swipedPosition){
        return getItem(swipedPosition);
    }

    class FavoriteTvViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle, tvRelease, tvDesc;
        private final ImageView imgIcon;
        private final ImageButton imgShare;
        FavoriteTvViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleTv);
            tvRelease = itemView.findViewById(R.id.tvReleaseTv);
            tvDesc = itemView.findViewById(R.id.tvOverviewTv);
            imgIcon = itemView.findViewById(R.id.imgPosterTv);
            imgShare = itemView.findViewById(R.id.img_share);
        }
    }
}
