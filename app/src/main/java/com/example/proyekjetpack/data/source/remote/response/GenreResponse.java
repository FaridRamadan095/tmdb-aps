package com.example.proyekjetpack.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GenreResponse {
    @SerializedName("genres")
    private ArrayList<GenreModel> genreModels;

    public ArrayList<GenreModel> getGenreModels() {
        return genreModels;
    }

    public void setGenreModels(ArrayList<GenreModel> genreModels) {
        this.genreModels = genreModels;
    }
}
