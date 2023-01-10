package com.myapplication.myapi;

import java.lang.annotation.Target;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Currency {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    Call<List<Money>>getData();

}
