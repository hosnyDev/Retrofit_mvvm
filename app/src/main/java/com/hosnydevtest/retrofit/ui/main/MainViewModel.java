package com.hosnydevtest.retrofit.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hosnydevtest.retrofit.model.PostModel;
import com.hosnydevtest.retrofit.repositry.PostRepository;

import java.util.List;

public class MainViewModel extends ViewModel implements PostListener {

    private MutableLiveData<List<PostModel>> mutableLiveDataList = new MutableLiveData<>();
    private MutableLiveData<String> mutableLiveDataError = new MutableLiveData<>();
    private MutableLiveData<Boolean> mutableLiveDataProgress = new MutableLiveData<>();

    public MainViewModel() {
        PostRepository repository = new PostRepository(this);
        repository.getData();
    }

    public LiveData<Boolean> getMutableLiveDataProgress() {
        return mutableLiveDataProgress;
    }

    public LiveData<String> getMutableLiveDataError() {
        return mutableLiveDataError;
    }

    public LiveData<List<PostModel>> getMutableLiveDataList() {
        return mutableLiveDataList;
    }


    @Override
    public void listDataAdded(List<PostModel> getPosts) {
        mutableLiveDataList.setValue(getPosts);
    }

    @Override
    public void onError(String error) {
        mutableLiveDataError.setValue(error);
    }

    @Override
    public void isProgress(Boolean isProgress) {
        mutableLiveDataProgress.setValue(isProgress);
    }
}