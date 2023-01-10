package com.myapplication.myapi;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Money> arrCrypto;
    String BASE_URL="https://raw.githubusercontent.com/";
    Retrofit retrofit;
    RecyclerView rcyc;
    adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
        Gson gson=new GsonBuilder().create();
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadData();
        rcyc=findViewById(R.id.rcyc);



    }
    public void loadData(){
        Currency cryptoApi=retrofit.create(Currency.class);
        Call<List<Money>> load=cryptoApi.getData();
        load.enqueue(new Callback<List<Money>>() {
            @Override
            public void onResponse(Call<List<Money>> call, Response<List<Money>> response) {
                if(response.isSuccessful()){
                    List<Money> cryptos=response.body();
                    arrCrypto=new ArrayList<>(cryptos);
                    LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
                    rcyc.setLayoutManager(manager);
                    adapter=new adapter(arrCrypto);
                    rcyc.setAdapter(adapter);

                }}

            @Override
            public void onFailure(Call<List<Money>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}