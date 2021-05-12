package com.example.nikeapp.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @com.squareup.moshi.Json(name = "adult")
    private Boolean adult;
    @com.squareup.moshi.Json(name = "backdrop_path")
    private String backdropPath;
    @com.squareup.moshi.Json(name = "genre_ids")
    private List<Integer> genreIds = null;
    @com.squareup.moshi.Json(name = "id")
    private Integer id;
    @com.squareup.moshi.Json(name = "original_language")
    private String originalLanguage;
    @com.squareup.moshi.Json(name = "original_title")
    private String originalTitle;
    @com.squareup.moshi.Json(name = "overview")
    private String overview;
    @com.squareup.moshi.Json(name = "popularity")
    private Float popularity;
    @com.squareup.moshi.Json(name = "poster_path")
    private String posterPath;
    @com.squareup.moshi.Json(name = "release_date")
    private String releaseDate;
    @com.squareup.moshi.Json(name = "title")
    private String title;
    @com.squareup.moshi.Json(name = "video")
    private Boolean video;
    @com.squareup.moshi.Json(name = "vote_average")
    private Float voteAverage;
    @com.squareup.moshi.Json(name = "vote_count")
    private Integer voteCount;


    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

}