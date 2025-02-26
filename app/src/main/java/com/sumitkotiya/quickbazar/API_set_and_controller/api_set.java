package com.sumitkotiya.quickbazar.API_set_and_controller;

import com.sumitkotiya.quickbazar.models.LoginResponseModel;
import com.sumitkotiya.quickbazar.models.SignupResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface api_set {

    @FormUrlEncoded
    @POST("signup.php")
    Call<SignupResponseModel> getRegistered(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") String mobile,
            @Field("address") String address
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponseModel> checkLogin(
            @Field("email") String email,
            @Field("password") String password
    );
}
