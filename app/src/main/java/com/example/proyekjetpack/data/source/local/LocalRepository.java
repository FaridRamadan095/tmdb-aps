package com.example.proyekjetpack.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.example.proyekjetpack.data.source.local.room.CatalogueDao;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;

import java.util.List;

public class LocalRepository {

    private final CatalogueDao mCatalogueDao;

    public LocalRepository(CatalogueDao mCatalogueDao) {
        this.mCatalogueDao = mCatalogueDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository getInstance(CatalogueDao catalogueDao){
        if (INSTANCE == null){
            INSTANCE = new LocalRepository(catalogueDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieModel>> getAllMovies(){
        return mCatalogueDao.getMovie();
    }

    public LiveData<List<TvShowModel>> getAllTv(){
        return mCatalogueDao.getTv();
    }

    public LiveData<MovieDetail> getDetailMovie(final String id){
        return mCatalogueDao.getDetailMovie(id);
    }

    public LiveData<TvShowDetail> getDetailTv(final String id){
        return mCatalogueDao.getDetailTv(id);
    }

    public void insertMovie(List<MovieModel> movies){
        mCatalogueDao.insertMovie(movies);
    }

    public void insertTv(List<TvShowModel> tv){
        mCatalogueDao.inserTv(tv);
    }

    public void insertDetailMovie(MovieDetail movies){
        mCatalogueDao.insertDetailMovie(movies);
    }

    public void insertDetailTv(TvShowDetail tvShowModel){
        mCatalogueDao.insertDetailTv(tvShowModel);
    }

    public void setFavoriteMovie(MovieDetail movie, boolean state){
        movie.setFavorite(state);
        mCatalogueDao.updateFavoriteMovie(movie);
    }

    public void setFavoriteTv(TvShowDetail tv, boolean state){
        tv.setFavorite(state);
        mCatalogueDao.updateFavoriteTv(tv);
    }

    public LiveData<List<MovieDetail>> getFavoriteMovies(){
        return mCatalogueDao.getFavoriteMovie();
    }

    public LiveData<List<TvShowDetail>> getFavoriteTv(){
        return mCatalogueDao.getFavoriteTv();
    }

    public DataSource.Factory<Integer, MovieDetail> getFavoriteMoviePaged(){
        return mCatalogueDao.getFavoriteMovieAsPaged();
    }

    public DataSource.Factory<Integer, TvShowDetail> getFavoriteTvPaged(){
        return mCatalogueDao.getFavoriteTvAsPaged();
    }
}
