package com.chachaup.iprofile.network;

import static com.chachaup.iprofile.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomUserClient {
    public static Retrofit retrofit = null;
    public static RandomUserAPI getClient(){
        if (retrofit == null){
retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
        }
        return retrofit.create(RandomUserAPI.class);
    }
}
