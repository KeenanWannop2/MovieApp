package com.example.nikeapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nikeapp.R;
import com.example.nikeapp.model.MovieResponse;
import com.example.nikeapp.network.NetworkRepository;

public class MainActivityViewModel extends AndroidViewModel {

    LiveData<MovieResponse> data;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<MovieResponse> getMovieData(){
        return NetworkRepository.getInstance().getMovieData(getApiKey());
    }
     private String getApiKey(){
        return getApplication().getResources().getString(R.string.tmbd_api_key);
    }
}
