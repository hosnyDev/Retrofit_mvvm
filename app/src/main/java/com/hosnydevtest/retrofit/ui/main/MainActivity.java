package com.hosnydevtest.retrofit.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hosnydevtest.retrofit.R;

public class MainActivity extends AppCompatActivity {

    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progress);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getMutableLiveDataError().observe(this, s -> Toast.makeText(MainActivity.this, "Error " + s, Toast.LENGTH_SHORT).show());

        viewModel.getMutableLiveDataProgress().observe(this, aBoolean -> {
            if (aBoolean)
                progressBar.setVisibility(View.VISIBLE);
            else
                progressBar.setVisibility(View.GONE);
        });

        viewModel.getMutableLiveDataList().observe(this, postModels -> {
            adapter = new PostAdapter(postModels);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        });


    }
}