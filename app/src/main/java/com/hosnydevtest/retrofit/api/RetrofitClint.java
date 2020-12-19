package com.hosnydevtest.retrofit.api;

import com.hosnydevtest.retrofit.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;
    private static RetrofitClint mInstance;

    public RetrofitClint() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClint getInstance() {
        if (mInstance == null)
            mInstance = new RetrofitClint();
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }

    public Call<List<PostModel>> getPosts (){
        return getApi().getPosts();
    }

}
