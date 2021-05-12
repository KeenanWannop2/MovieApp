package com.example.nikeapp.network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nikeapp.BuildConfig;
import com.example.nikeapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepository {


    private static NetworkRepository networkInstance;
    private final static String baseURL = "https://api.themoviedb.org/3/";
    private final static String api_key = BuildConfig.THE_MOVIEDB_KEY;
    private MovieApiInterface apiService;

    public static NetworkRepository getInstance() {
        if (networkInstance == null) {
            synchronized (NetworkRepository.class) {
                networkInstance = new NetworkRepository();
            }
        }
        return networkInstance;
    }

    public NetworkRepository() {
        apiService = NetworkConnection.getConnection(baseURL).create(MovieApiInterface.class);
    }

    public LiveData<MovieResponse> getMovieData() {
        return onRetrofitRequest(apiService.getMovies("en-US", 1, "US"));
    }

    public LiveData<MovieResponse> onRetrofitRequest(Call<MovieResponse> call) {
        final MutableLiveData<MovieResponse> data = new MutableLiveData<>();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful())
                    data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                t.getMessage();
                data.setValue(null);
            }
        });
        return data;
    }

}
