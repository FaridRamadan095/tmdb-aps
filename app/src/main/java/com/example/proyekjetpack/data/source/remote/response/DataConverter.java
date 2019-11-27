package com.example.proyekjetpack.data.source.remote.response;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataConverter implements Serializable {

    @TypeConverter
    public String fromGenre(ArrayList<GenreModel> genreModels){
        if (genreModels == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<GenreModel>>(){

        }.getType();
        String json = gson.toJson(genreModels, type);
        return json;
    }

    @TypeConverter
    public ArrayList<GenreModel> toGenreModelList(String genreString){
        if (genreString == null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<GenreModel>>(){

        }.getType();
        ArrayList<GenreModel> genreList = gson.fromJson(genreString, type);
        return genreList;
    }
}
