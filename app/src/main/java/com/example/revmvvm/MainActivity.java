package com.example.revmvvm;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    MovieListAdepter movieListAdepter;
    List<Moviemodel> movielist;
    Movieviewmodel movieviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            recyclerView = findViewById(R.id.rvmvvm);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

            // Initialize movielist
            movielist = new ArrayList<>();

            // Pass the initialized movielist to the adapter
            movieListAdepter = new MovieListAdepter(movielist);
            recyclerView.setAdapter(movieListAdepter);

            movieviewmodel = new ViewModelProvider(this).get(Movieviewmodel.class);
            movieviewmodel.getMovielist().observe(this, new Observer<List<Moviemodel>>() {
                @Override
                public void onChanged(List<Moviemodel> moviemodels) {
                    if (moviemodels != null) {
                        Log.d(TAG, "Movies list updated");
                        movielist.clear();
                        movielist.addAll(moviemodels);
                        movieListAdepter.notifyDataSetChanged();
                    } else {
                        Log.d(TAG, "Movies list is null");
                    }
                }
            });

            movieviewmodel.getapi();
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
        }
    }
}
