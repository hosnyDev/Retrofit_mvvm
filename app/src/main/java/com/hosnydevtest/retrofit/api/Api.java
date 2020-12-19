package com.hosnydevtest.retrofit.api;

import com.hosnydevtest.retrofit.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("posts")
    Call<List<PostModel>> getPosts();

}
