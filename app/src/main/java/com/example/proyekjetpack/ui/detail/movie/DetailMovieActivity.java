package com.example.proyekjetpack.ui.detail.movie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.source.remote.response.GenreModel;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tvTitle, tvOverview, tvRelease, tvGenre;
    private ImageView imgBack, imgPoster, imgBackdrop, btnFavorite;
    private RatingBar ratingMovie;
    private DetailMovieViewModel viewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        viewModel = obtainViewModel(this);

        tvTitle = findViewById(R.id.tvTitleMovie);
        tvOverview = findViewById(R.id.tvOverviewMovie);
        tvRelease = findViewById(R.id.tvReleaseMovie);
        imgBack = findViewById(R.id.imgBackMovie);
        imgBackdrop = findViewById(R.id.imgBackdropMovie);
        imgPoster = findViewById(R.id.imgPosterMovie);
        ratingMovie = findViewById(R.id.ratingStarMovie);
        tvGenre = findViewById(R.id.tvGenreMovie);
        progressBar = findViewById(R.id.progress_bar);
        btnFavorite = findViewById(R.id.btnFavoriteMovie);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int movieId = extras.getInt(EXTRA_MOVIE);
            if (movieId != 0) {
                String id = String.valueOf(movieId);
                viewModel.setMovieId(id);
            }
        }

        viewModel.setUsername("dadhe");
        viewModel.movies.observe(this, movieDetailResource -> {
            if (movieDetailResource != null){
                switch (movieDetailResource.status){
                    case LOADING:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        if (movieDetailResource.data != null){
                            progressBar.setVisibility(View.GONE);
                            populateMovie(movieDetailResource.data);
                            boolean state = movieDetailResource.data.isFavorite();
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
            viewModel.setFavoriteMovie();
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    private void setFavoriteState(boolean state){
        if (state){
            btnFavorite.setImageResource(R.drawable.ic_favorite_red);
        }else {
            btnFavorite.setImageResource(R.drawable.ic_favorite_grey);
        }
    }

    private void populateMovie(MovieDetail movieModel) {
        tvTitle.setText(movieModel.getTitle());
        tvRelease.setText(movieModel.getRelease_date());
        tvOverview.setText(movieModel.getOverview());
        tvGenre.setText(getGenre(movieModel.getGenreModels()));
        float rating = Float.parseFloat(movieModel.getVote_average()) / 2;
        ratingMovie.setRating(rating);

        supportPostponeEnterTransition();

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w500" + movieModel.getBackdrop_path())
                .apply(new RequestOptions().centerCrop())
                .into(imgBackdrop);
        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w500" + movieModel.getPoster_path())
                .into(imgPoster);


        imgBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    private String getGenre(ArrayList<GenreModel> genreModels) {
        List<String> movieGenres = new ArrayList<>();

        for (int i = 0; i < genreModels.size(); i++) {
            movieGenres.add(genreModels.get(i).getName());
        }

        return TextUtils.join(", ", movieGenres);
    }


    @NonNull
    private static DetailMovieViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel.class);
    }
}
