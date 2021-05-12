package com.example.nikeapp.network;


import com.example.nikeapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MovieApiInterface {

    @GET("movie/now_playing")
    Call<MovieResponse> getMovies(@Query("language") String language, @Query("page") Integer page, @Query("region") String region);

}
