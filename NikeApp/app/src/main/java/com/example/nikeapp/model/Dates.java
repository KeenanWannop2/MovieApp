package com.example.nikeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dates {

    @com.squareup.moshi.Json(name = "maximum")
    private String maximum;
    @com.squareup.moshi.Json(name = "minimum")
    private String minimum;

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

}
