package com.example.sankeerthiv.firstapp;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ukinih on 19-07-2018.
 */

public class RetrofitClient {
    public static final String BASE_URL ="http://10.106.122.1:5003/";

    public static ApiData getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiData dataReference = retrofit.create(ApiData.class);
        return dataReference;
    }
}
