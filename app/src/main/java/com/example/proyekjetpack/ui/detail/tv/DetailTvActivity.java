package com.example.proyekjetpack.ui.detail.tv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.TvEntity;
import com.example.proyekjetpack.data.source.remote.response.GenreModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class DetailTvActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";
    private TextView tvTitle, tvOverview, tvRelease, tvGenre;
    private ImageView imgBack, imgPoster, imgBackdrop, btnFavorite;
    private RatingBar ratingTv;
    private DetailTvViewModel viewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        viewModel = obtainViewModel(this);

        tvTitle = findViewById(R.id.tvTitleTv);
        tvOverview = findViewById(R.id.tvOverviewTv);
        tvRelease = findViewById(R.id.tvReleaseTv);
        tvGenre = findViewById(R.id.tvGenreTv);
        imgBack = findViewById(R.id.imgBackTv);
        imgPoster = findViewById(R.id.imgPosterTv);
        imgBackdrop = findViewById(R.id.imgBackdropMovieTv);
        ratingTv = findViewById(R.id.ratingStarTv);
        progressBar = findViewById(R.id.progress_bar);
        btnFavorite = findViewById(R.id.btnFavoriteTv);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int tvId = extras.getInt(EXTRA_TV);
            if (tvId != 0) {
                String id = String.valueOf(tvId);
                viewModel.setTvId(id);
            }
        }

        viewModel.setUsername("dadhe");
        viewModel.tv.observe(this, tvShowDetailResource -> {
            if (tvShowDetailResource != null) {
                switch (tvShowDetailResource.status) {
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (tvShowDetailResource.data != null){
                            progressBar.setVisibility(View.GONE);
                            populateTv(tvShowDetailResource.data);
                            boolean state = tvShowDetailResource.data.isFavorite();
                            setFavoriteState(state);
                        }
                        break;
                    case ERROR:
                        progressBar.setVisibility(View.GONE);
                        break;
                }
            }
        });

        btnFavorite.setOnClickListener(view -> {
            viewModel.setFavoriteTv();
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private void populateTv(TvShowDetail tvShowModel) {
        tvTitle.setText(tvShowModel.getName());
        tvRelease.setText(tvShowModel.getFirst_air_date());
        tvOverview.setText(tvShowModel.getOverview());
        tvGenre.setText(getGenre(tvShowModel.getGenreModels()));
        float rating = Float.parseFloat(tvShowModel.getVote_average()) / 2;
        ratingTv.setRating(rating);

        supportPostponeEnterTransition();

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w500" + tvShowModel.getBackdrop_path())
                .apply(new RequestOptions().centerCrop())
                .into(imgBackdrop);
        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w500" + tvShowModel.getPoster_path())
                .into(imgPoster);

        imgBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    private void setFavoriteState(boolean state){
        if (state){
            btnFavorite.setImageResource(R.drawable.ic_favorite_red);
        }else {
            btnFavorite.setImageResource(R.drawable.ic_favorite_grey);
        }
    }

    private String getGenre(ArrayList<GenreModel> genreModels) {
        List<String> tvGenres = new ArrayList<>();

        for (int i = 0; i < genreModels.size(); i++) {
            tvGenres.add(genreModels.get(i).getName());
        }

        return TextUtils.join(", ", tvGenres);
    }

    @NonNull
    private static DetailTvViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailTvViewModel.class);
    }
}
