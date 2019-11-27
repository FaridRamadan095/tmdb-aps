package com.example.proyekjetpack.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;

import java.util.List;

@Dao
public interface CatalogueDao {
    @WorkerThread
    @Query("SELECT * FROM movieentity")
    LiveData<List<MovieModel>> getMovie();

    @WorkerThread
    @Query("SELECT * FROM tventity")
    LiveData<List<TvShowModel>> getTv();

    @WorkerThread
    @Query("SELECT * FROM moviedetail WHERE favorite = 1")
    LiveData<List<MovieDetail>> getFavoriteMovie();

    @WorkerThread
    @Query("SELECT * FROM tvdetail WHERE favorite = 1")
    LiveData<List<TvShowDetail>> getFavoriteTv();

    @Transaction
    @Query("SELECT * FROM moviedetail WHERE id = :id")
    LiveData<MovieDetail> getDetailMovie(String id);

    @Transaction
    @Query("SELECT * FROM tvdetail WHERE id = :id")
    LiveData<TvShowDetail> getDetailTv(String id);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateFavoriteMovie(MovieDetail movieDetail);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateFavoriteTv(TvShowDetail tvShowDetail);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovie(List<MovieModel> movies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] inserTv(List<TvShowModel> tv);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDetailMovie(MovieDetail movies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDetailTv(TvShowDetail tvShowModel);

    @Query("SELECT * FROM moviedetail WHERE favorite = 1")
    DataSource.Factory<Integer, MovieDetail> getFavoriteMovieAsPaged();

    @Query("SELECT * FROM tvdetail WHERE favorite = 1")
    DataSource.Factory<Integer, TvShowDetail> getFavoriteTvAsPaged();
}
