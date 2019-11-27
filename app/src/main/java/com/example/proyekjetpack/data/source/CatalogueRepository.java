package com.example.proyekjetpack.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.proyekjetpack.data.source.local.LocalRepository;
import com.example.proyekjetpack.data.source.remote.ApiResponse;
import com.example.proyekjetpack.data.source.remote.RemoteRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.MovieResponse;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowResponse;
import com.example.proyekjetpack.utils.AppExecutors;
import com.example.proyekjetpack.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class CatalogueRepository implements CatalogueDataSource{

    private volatile static CatalogueRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;
    private final AppExecutors appExecutors;

    public CatalogueRepository(LocalRepository localRepository, RemoteRepository remoteRepository, AppExecutors appExecutors) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutors = appExecutors;
    }

    public static CatalogueRepository getInstance(LocalRepository local, RemoteRepository remoteData, AppExecutors appExecutors){
        if (INSTANCE == null){
            synchronized (CatalogueRepository.class){
                if (INSTANCE == null){
                    INSTANCE = new CatalogueRepository(local, remoteData, appExecutors);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public LiveData<Resource<List<MovieModel>>> getAllMovies() {
        return new NetworkBoundResource<List<MovieModel>, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<List<MovieModel>> loadFromDB() {
                return localRepository.getAllMovies();
            }

            @Override
            protected Boolean sholudFetch(List<MovieModel> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteRepository.getAllMovieAsLiveData();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<MovieModel> movieDetails = new ArrayList<>();

                for (MovieResponse movieResponse: data){
                    movieDetails = movieResponse.getMovieList();
                }

                localRepository.insertMovie(movieDetails);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvShowModel>>> getAllTvShow() {
        return new NetworkBoundResource<List<TvShowModel>, List<TvShowResponse>>(appExecutors) {
            @Override
            protected LiveData<List<TvShowModel>> loadFromDB() {
                return localRepository.getAllTv();
            }

            @Override
            protected Boolean sholudFetch(List<TvShowModel> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return remoteRepository.getAllTvAsLiveData();
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> tvShowResponses) {
                List<TvShowModel> tvShowModels = new ArrayList<>();

                for (TvShowResponse tvShowResponse: tvShowResponses){
                    tvShowModels = tvShowResponse.getTvShowModelList();
                }

                localRepository.insertTv(tvShowModels);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MovieDetail>> getDetailMovie(String movieId) {
        return new NetworkBoundResource<MovieDetail, MovieDetail>(appExecutors) {
            @Override
            protected LiveData<MovieDetail> loadFromDB() {
                return localRepository.getDetailMovie(movieId);
            }

            @Override
            protected Boolean sholudFetch(MovieDetail data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<MovieDetail>> createCall() {
                return remoteRepository.getDetailMovieAsLiveData(movieId);
            }

            @Override
            protected void saveCallResult(MovieDetail data) {
                localRepository.insertDetailMovie(data);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShowDetail>> getDetailTv(String tvId) {
        return new NetworkBoundResource<TvShowDetail, TvShowDetail>(appExecutors) {
            @Override
            protected LiveData<TvShowDetail> loadFromDB() {
                return localRepository.getDetailTv(tvId);
            }

            @Override
            protected Boolean sholudFetch(TvShowDetail data) {
                return (data == null);
            }

            @Override
            protected LiveData<ApiResponse<TvShowDetail>> createCall() {
                return remoteRepository.getDetailTvAsLiveData(tvId);
            }

            @Override
            protected void saveCallResult(TvShowDetail data) {
                localRepository.insertDetailTv(data);
            }
        }.asLiveData();
    }

    @Override
    public void setMovieFavorite(MovieDetail movieFavorite, boolean state) {
        Runnable runnable = () -> localRepository.setFavoriteMovie(movieFavorite, state);

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void setTvFavorite(TvShowDetail tvFavorite, boolean state) {
        Runnable runnable = () -> localRepository.setFavoriteTv(tvFavorite, state);

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public LiveData<Resource<List<MovieDetail>>> getFavoriteMovie() {
        return new NetworkBoundResource<List<MovieDetail>, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<List<MovieDetail>> loadFromDB() {
                return localRepository.getFavoriteMovies();
            }

            @Override
            protected Boolean sholudFetch(List<MovieDetail> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvShowDetail>>> getFavoriteTv() {
        return new NetworkBoundResource<List<TvShowDetail>, List<TvShowResponse>>(appExecutors) {
            @Override
            protected LiveData<List<TvShowDetail>> loadFromDB() {
                return localRepository.getFavoriteTv();
            }

            @Override
            protected Boolean sholudFetch(List<TvShowDetail> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<MovieDetail>>> getFavoriteMoviePaged() {
        return new NetworkBoundResource<PagedList<MovieDetail>, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<MovieDetail>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getFavoriteMoviePaged(), 20).build();
            }

            @Override
            protected Boolean sholudFetch(PagedList<MovieDetail> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<TvShowDetail>>> getFavoriteTvPaged() {
        return new NetworkBoundResource<PagedList<TvShowDetail>, List<TvShowResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<TvShowDetail>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getFavoriteTvPaged(), 20).build();
            }

            @Override
            protected Boolean sholudFetch(PagedList<TvShowDetail> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {

            }
        }.asLiveData();
    }
}
