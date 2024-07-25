package com.example.revmvvm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiservice {

    @GET("json_user_fetch.php")
    Call<List<Moviemodel>> getmovie();
}
