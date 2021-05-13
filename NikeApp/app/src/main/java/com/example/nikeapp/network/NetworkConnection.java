package com.example.nikeapp.network;

import android.util.Log;

import com.example.nikeapp.BuildConfig;
import com.facebook.stetho.Stetho;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkConnection {
    public static Retrofit getConnection(String baseURL){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().
                addInterceptor(interceptor)
        .build();
        Moshi moshi = new Moshi.Builder().build();
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build();
    }
}
