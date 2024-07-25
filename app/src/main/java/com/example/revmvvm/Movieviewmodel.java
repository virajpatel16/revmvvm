package com.example.revmvvm;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movieviewmodel extends AndroidViewModel {
    public MutableLiveData<List<Moviemodel>> movielist;

    public Movieviewmodel(@NonNull Application application) {
        super(application);
        movielist = new MutableLiveData<>();
    }

    public MutableLiveData<List<Moviemodel>> getMovielist() {
        return movielist;
    }

    public void getapi() {
        Apiservice apiservice = RetrofitIn.getRetroClient().create(Apiservice.class);
        Call<List<Moviemodel>> call = apiservice.getmovie();
        call.enqueue(new Callback<List<Moviemodel>>() {
            @Override
            public void onResponse(Call<List<Moviemodel>> call, Response<List<Moviemodel>> response) {
                movielist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Moviemodel>> call, Throwable t) {
                Log.e("Error :", t.getMessage());
            }
        });
    }
}
