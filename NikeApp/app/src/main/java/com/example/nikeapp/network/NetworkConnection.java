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
    private final static String api_key = BuildConfig.THE_MOVIEDB_KEY;
    public static Retrofit getConnection(String baseURL){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().
                addInterceptor(interceptor)
                .addInterceptor(provideInterceptor())
        .build();
//        client.interceptors().add(new Interceptor(){
//            @Override public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                String format = String.format("\nrequest:\n%s\nheaders:\n%s",
//                        request.body().toString(), request.headers());
//                int e = Log.e("REQUEST: " , format);
//
//                Response response = chain.proceed(request);
//                return response;
//            }
//        });
        Moshi moshi = new Moshi.Builder().build();
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build();
    }
   private static Interceptor provideInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", api_key)
                        .build();

                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }
}
