package com.example.nikeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @com.squareup.moshi.Json(name = "dates")
    private Dates dates;
    @com.squareup.moshi.Json(name = "page")
    private Integer page;
    @com.squareup.moshi.Json(name = "results")
    private List<Result> results = null;
    @com.squareup.moshi.Json(name = "total_pages")
    private Integer totalPages;
    @com.squareup.moshi.Json(name = "total_results")
    private Integer totalResults;

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

}
