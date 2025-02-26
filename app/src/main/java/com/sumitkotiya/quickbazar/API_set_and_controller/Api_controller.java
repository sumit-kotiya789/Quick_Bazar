package com.sumitkotiya.quickbazar.API_set_and_controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_controller {

    //path
    static final String url = "http://10.0.2.2/ecommapi/";
    private static Api_controller clientObj;
    private static Retrofit retrofit;


    //constructor
    Api_controller(){
        retrofit = new Retrofit.Builder().
                                baseUrl(url).
                                addConverterFactory(GsonConverterFactory.create()).
                                build();
    }

    //runtime object
    public static synchronized Api_controller getInstance(){
        if (clientObj == null){
            clientObj = new Api_controller();
        }
        return clientObj;
    }


    //select api
    public api_set getApi(){
        return retrofit.create(api_set.class);
    }

}
