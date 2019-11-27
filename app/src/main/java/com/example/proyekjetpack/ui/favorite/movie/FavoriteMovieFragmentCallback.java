package com.example.proyekjetpack.ui.favorite.movie;

import com.example.proyekjetpack.data.source.remote.response.MovieDetail;

interface FavoriteMovieFragmentCallback {
    void onShareClick(MovieDetail movieDetail);
}
