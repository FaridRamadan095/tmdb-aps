package com.example.proyekjetpack.ui.tv;

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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.ui.detail.tv.DetailTvActivity;

import java.util.ArrayList;
import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private Activity activity;
    private List<TvShowModel> mTv = new ArrayList<>();

    public TvAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShowModel> getListTv(){
        return mTv;
    }

    void setListTv(List<TvShowModel> listTv){
        if (listTv == null)return;
        this.mTv.clear();
        this.mTv.addAll(listTv);
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvshow, parent, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        holder.tvTitle.setText(getListTv().get(position).getName());
        holder.tvRelease.setText(getListTv().get(position).getFirst_air_date().split("-")[0]);
        int length = getListTv().get(position).getOverview().length();
        if (length > 120){
            holder.tvDesc.setText(getListTv().get(position).getOverview().substring(0, 100) + "...");
        }else {
            holder.tvDesc.setText(getListTv().get(position).getOverview());
        }
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500"+getListTv().get(position).getPoster_path())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgIcon);

        holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(activity, DetailTvActivity.class);
                intent.putExtra(DetailTvActivity.EXTRA_TV, getListTv().get(position).getId());
            Pair<View, String> p1 = Pair.create(holder.imgIcon, "postertv");
            Pair<View, String> p2 = Pair.create(holder.tvTitle, "titletv");
            Pair<View, String> p3 = Pair.create(holder.tvRelease, "releasetv");
            Pair<View, String> p4 = Pair.create(holder.tvDesc, "overviewtv");
            ActivityOptionsCompat options = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(activity, p1, p2, p3, p4);
                activity.startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return getListTv().size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle, tvRelease, tvDesc;
        private final ImageView imgIcon;

        public TvViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleTv);
            tvRelease = itemView.findViewById(R.id.tvReleaseTv);
            tvDesc = itemView.findViewById(R.id.tvOverviewTv);
            imgIcon = itemView.findViewById(R.id.imgPosterTv);
        }
    }
}
