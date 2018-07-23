package com.example.sankeerthiv.firstapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ukinih on 19-07-2018.
 */

public interface ApiData {


    @FormUrlEncoded
    @POST("login")
    Call<DataModel> getData(@Field("username") String username,@Field("password")String password);
}