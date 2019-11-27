package com.example.proyekjetpack.utils;

import com.example.proyekjetpack.data.source.remote.response.GenreModel;

import java.util.ArrayList;

public class FakeDataGenre {

    public static ArrayList<GenreModel> generateGenreMovie(int id) {
        ArrayList<GenreModel> genreModels = new ArrayList<>();

        if (id == 475557) {
            genreModels.add(new GenreModel(80,
                    "Crime"));
            genreModels.add(new GenreModel(54,
                    "Thriller"));
            genreModels.add(new GenreModel(18,
                    "Drama"));
        } else if (id == 420809) {
            genreModels.add(new GenreModel(14,
                    "Fantasy"));
            genreModels.add(new GenreModel(12,
                    "Adventure"));
            genreModels.add(new GenreModel(10751,
                    "Family"));
        } else {
            genreModels.add(new GenreModel(14,
                    "Fantasy"));
            genreModels.add(new GenreModel(12,
                    "Adventure"));
            genreModels.add(new GenreModel(10751,
                    "Family"));
        }

        return genreModels;

    }

    public static ArrayList<GenreModel> generateGenreTv(int id) {
        ArrayList<GenreModel> genreModels = new ArrayList<>();

        if (id == 1412) {
            genreModels.add(new GenreModel(80,
                    "Crime"));
            genreModels.add(new GenreModel(18,
                    "Drama"));
            genreModels.add(new GenreModel(9648,
                    "Mystery"));
            genreModels.add(new GenreModel(10759,
                    "Action & Adventure"));
        } else if (id == 62286) {
            genreModels.add(new GenreModel(18,
                    "Drama"));
            genreModels.add(new GenreModel(27,
                    "Horor"));
        } else {
            genreModels.add(new GenreModel(14,
                    "Fantasy"));
            genreModels.add(new GenreModel(12,
                    "Adventure"));
            genreModels.add(new GenreModel(10751,
                    "Family"));
        }

        return genreModels;
    }
}
