package com.example.proyekjetpack.data;

public class MovieEntity {
    private String id;
    private String title;
    private String desc;
    private String release_date;
    private String vote_average;
    private String photo;
    private String genre;
    private boolean bookmarked;

    public MovieEntity(String id, String title, String desc, String release_date, String vote_average, String photo, String genre, Boolean bookmarked) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.release_date = release_date;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
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
