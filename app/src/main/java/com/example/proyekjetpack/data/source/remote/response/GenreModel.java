package com.example.proyekjetpack.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class GenreModel {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public GenreModel(){}

    public GenreModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
