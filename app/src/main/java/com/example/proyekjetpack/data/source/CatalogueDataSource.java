package com.example.proyekjetpack.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;


import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.vo.Resource;

import java.util.List;

public interface CatalogueDataSource {
    LiveData<Resource<List<MovieModel>>> getAllMovies();

    LiveData<Resource<List<TvShowModel>>> getAllTvShow();

    LiveData<Resource<MovieDetail>> getDetailMovie(String movieId);

    LiveData<Resource<TvShowDetail>> getDetailTv(String tvId);

    LiveData<Resource<List<MovieDetail>>> getFavoriteMovie();

    LiveData<Resource<List<TvShowDetail>>> getFavoriteTv();

    LiveData<Resource<PagedList<MovieDetail>>> getFavoriteMoviePaged();

    LiveData<Resource<PagedList<TvShowDetail>>> getFavoriteTvPaged();

    void setMovieFavorite(MovieDetail movieFavorite, boolean state);

    void setTvFavorite(TvShowDetail tvFavorite, boolean state);
}
