package com.hosnydevtest.retrofit.ui.main;

import com.hosnydevtest.retrofit.model.PostModel;

import java.util.List;

public interface PostListener {

    void listDataAdded(List<PostModel> getPosts);

    void onError(String error);

    void isProgress(Boolean isProgress);
}
