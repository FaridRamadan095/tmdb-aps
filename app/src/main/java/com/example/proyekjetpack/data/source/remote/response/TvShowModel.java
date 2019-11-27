package com.example.proyekjetpack.data.source.remote.response;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "tventity")
public class TvShowModel implements Serializable, Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    private String vote_average;

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    private String backdrop_path;

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    private String poster_path;

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview;

    @ColumnInfo(name = "first_air_date")
    @SerializedName("first_air_date")
    private String first_air_date;

    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "genres")
    @SerializedName("genres")
    private ArrayList<GenreModel> genreModels;

    @ColumnInfo(name = "favorite")
    private boolean favorite = false;



    public TvShowModel(int id, String name, String vote_average, String backdrop_path, String poster_path, String overview, String first_air_date, Boolean favorite, ArrayList<GenreModel> genreModels) {
        this.id = id;
        this.name = name;
        this.vote_average = vote_average;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.overview = overview;
        this.first_air_date = first_air_date;
        if (favorite != null){
            this.favorite =favorite;
        }
        this.genreModels = genreModels;

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

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public ArrayList<GenreModel> getGenreModels() {
        return genreModels;
    }

    public void setGenreModels(ArrayList<GenreModel> genreModels) {
        this.genreModels = genreModels;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.vote_average);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.poster_path);
        dest.writeString(this.overview);
        dest.writeString(this.first_air_date);

        dest.writeList(this.genreModels);
    }

    public TvShowModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        vote_average = in.readString();
        backdrop_path = in.readString();
        poster_path = in.readString();
        overview = in.readString();
        first_air_date = in.readString();

        genreModels = new ArrayList<GenreModel>();
        in.readList(genreModels, Integer.class.getClassLoader());
    }

    public static final Creator<TvShowModel> CREATOR = new Creator<TvShowModel>() {
        @Override
        public TvShowModel createFromParcel(Parcel in) {
            return new TvShowModel(in);
        }

        @Override
        public TvShowModel[] newArray(int size) {
            return new TvShowModel[size];
        }
    };


}
