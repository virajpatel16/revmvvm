package com.example.revmvvm;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
public class RetrofitIn{

    private static String baseurl ="http://192.168.0.100/api/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
