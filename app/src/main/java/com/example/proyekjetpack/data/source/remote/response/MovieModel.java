package com.example.proyekjetpack.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "movieentity")
public class MovieModel implements Serializable, Parcelable{

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

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

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    private String release_date;

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    private String popularity;

    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "genres")
    @SerializedName("genres")
    private ArrayList<GenreModel> genreModels;

    @ColumnInfo(name = "favorite")
    private boolean favorite = false;

    public MovieModel(){}

    public MovieModel(int id, String title, String vote_average, String backdrop_path, String poster_path, String overview, String release_date, Boolean favorite, ArrayList<GenreModel> genreModels) {
        this.id = id;
        this.title = title;
        this.vote_average = vote_average;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        if (favorite != null){
            this.favorite = favorite;
        }
        this.genreModels = genreModels;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public ArrayList<GenreModel> getGenreModels() {
        return genreModels;
    }

    public void setGenreModels(ArrayList<GenreModel> genreModels) {
        this.genreModels = genreModels;
    }

    public boolean isFavorite(){
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
        dest.writeString(this.title);
        dest.writeString(this.vote_average);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.poster_path);
        dest.writeString(this.overview);
        dest.writeString(this.release_date);
        dest.writeList(this.genreModels);

    }


    public MovieModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        vote_average = in.readString();
        backdrop_path = in.readString();
        poster_path = in.readString();
        overview = in.readString();
        release_date = in.readString();
        genreModels = new ArrayList<GenreModel>();
        in.readList(genreModels, Integer.class.getClassLoader());

    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
