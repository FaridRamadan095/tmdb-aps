package com.example.proyekjetpack.data.source.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.proyekjetpack.BuildConfig;
import com.example.proyekjetpack.data.source.api.ApiClient;
import com.example.proyekjetpack.data.source.api.ApiInterface;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieResponse;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;

    private ApiInterface mApiInterface;
    private static final String LANGUAGE = "en-US";


    public RemoteRepository(ApiInterface apiInterface) {
        this.mApiInterface = apiInterface;
    }

    public static RemoteRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(ApiClient.getClient().create(ApiInterface.class));
        }

        return INSTANCE;
    }


    public LiveData<ApiResponse<List<MovieResponse>>> getAllMovieAsLiveData(){
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultMovie = new MutableLiveData<>();

        mApiInterface.getMovie(BuildConfig.API_TMDB, LANGUAGE, 1)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        ArrayList<MovieResponse> movieResponses = new ArrayList<>();
                        movieResponses.add(response.body());

                        resultMovie.setValue(ApiResponse.success(movieResponses));
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });

        return resultMovie;
    }

    public LiveData<ApiResponse<List<TvShowResponse>>> getAllTvAsLiveData(){
        MutableLiveData<ApiResponse<List<TvShowResponse>>> resultTv = new MutableLiveData<>();

        mApiInterface.getTvShow(BuildConfig.API_TMDB, "en-US", 1)
                .enqueue(new Callback<TvShowResponse>() {
                    @Override
                    public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                        ArrayList<TvShowResponse> tvShowModels = new ArrayList<>();
                        tvShowModels.add(response.body());

                        resultTv.setValue(ApiResponse.success(tvShowModels));
                    }

                    @Override
                    public void onFailure(Call<TvShowResponse> call, Throwable t) {

                    }
                });

        return resultTv;
    }

    public LiveData<ApiResponse<MovieDetail>> getDetailMovieAsLiveData(String id){
        MutableLiveData<ApiResponse<MovieDetail>> resultMovie = new MutableLiveData<>();

        mApiInterface.getDetailMovie(id, BuildConfig.API_TMDB)
                .enqueue(new Callback<MovieDetail>() {
                    @Override
                    public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                        resultMovie.setValue(ApiResponse.success(response.body()));
                    }

                    @Override
                    public void onFailure(Call<MovieDetail> call, Throwable t) {

                    }
                });

        return resultMovie;
    }

    public LiveData<ApiResponse<TvShowDetail>> getDetailTvAsLiveData(String id){
        MutableLiveData<ApiResponse<TvShowDetail>> resultTv = new MutableLiveData<>();

        mApiInterface.getDetailTv(id, BuildConfig.API_TMDB)
                .enqueue(new Callback<TvShowDetail>() {
                    @Override
                    public void onResponse(Call<TvShowDetail> call, Response<TvShowDetail> response) {
                        resultTv.setValue(ApiResponse.success(response.body()));
                    }

                    @Override
                    public void onFailure(Call<TvShowDetail> call, Throwable t) {

                    }
                });

        return resultTv;
    }
}
