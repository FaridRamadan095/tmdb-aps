package com.example.proyekjetpack.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    private List<MovieModel> movieList;

    public MovieResponse(List<MovieModel> movieList) {
        this.movieList = movieList;
    }

    public List<MovieModel> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieModel> movieList) {
        this.movieList = movieList;
    }
}
