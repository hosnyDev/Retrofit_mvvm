package com.hosnydevtest.retrofit.repositry;

import androidx.annotation.NonNull;

import com.hosnydevtest.retrofit.api.RetrofitClint;
import com.hosnydevtest.retrofit.model.PostModel;
import com.hosnydevtest.retrofit.ui.main.PostListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private PostListener postListener;

    public PostRepository(PostListener postListener) {
        this.postListener = postListener;
    }

    public void getData() {

        postListener.isProgress(true);

        RetrofitClint.getInstance().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostModel>> call, @NonNull Response<List<PostModel>> response) {

                postListener.listDataAdded(response.body());
                postListener.isProgress(false);
            }

            @Override
            public void onFailure(@NonNull Call<List<PostModel>> call, @NonNull Throwable t) {

                postListener.isProgress(false);
                postListener.onError(t.getMessage());

            }
        });
    }

}
