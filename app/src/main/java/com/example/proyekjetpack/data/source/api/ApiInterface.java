package com.example.proyekjetpack.data.source.api;


import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieResponse;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/popular")
    Call<MovieResponse> getMovie(@Query("api_key") String api_key,
                                 @Query("language") String language,
                                 @Query("page") int page);

    @GET("tv/popular")
    Call<TvShowResponse> getTvShow(@Query("api_key") String api_key,
                                   @Query("language") String language,
                                   @Query("page") int page);


    @GET("movie/{id}?")
    Call<MovieDetail> getDetailMovie(@Path("id") String id,
                                     @Query("api_key") String api_key);


    @GET("tv/{id}?")
    Call<TvShowDetail> getDetailTv(@Path("id") String id,
                                   @Query("api_key") String api_key);



}
