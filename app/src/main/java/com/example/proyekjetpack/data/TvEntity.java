package com.example.proyekjetpack.data;

public class TvEntity {
    private String id;
    private String name;
    private String desc;
    private String first_air_date;
    private String vote_average;
    private String photo;
    private String genre;
    private boolean bookmarked;

    public TvEntity(String id, String name, String desc, String first_air_date, String vote_average, String photo, String genre, Boolean bookmarked) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.first_air_date = first_air_date;
        this.vote_average = vote_average;
        this.photo = photo;
        this.genre = genre;
        if (bookmarked != null){
            this.bookmarked = bookmarked;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
