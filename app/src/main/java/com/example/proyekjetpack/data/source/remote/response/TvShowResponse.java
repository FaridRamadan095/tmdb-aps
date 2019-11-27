package com.example.proyekjetpack.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TvShowResponse {
    @SerializedName("results")
    private List<TvShowModel> tvShowModelList;

    public TvShowResponse(List<TvShowModel> tvShowModelList) {
        this.tvShowModelList = tvShowModelList;
    }

    public List<TvShowModel> getTvShowModelList() {
        return tvShowModelList;
    }

    public void setTvShowModelList(List<TvShowModel> tvShowModelList) {
        this.tvShowModelList = tvShowModelList;
    }
}
