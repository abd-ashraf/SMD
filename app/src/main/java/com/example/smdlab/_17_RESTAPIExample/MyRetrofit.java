package com.example.smdlab._17_RESTAPIExample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    public static Retrofit retrofit;
    public static String uRL = "https://jsonplaceholder.typicode.com/";

//    ye class connection bana ke return kr rha hy
    public static Retrofit getMyRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(uRL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
