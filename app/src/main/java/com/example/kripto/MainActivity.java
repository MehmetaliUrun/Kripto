package com.example.kripto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kripto.Adapter.RecyclerViewAdapter;
import com.example.kripto.model.Cryto;
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

    ArrayList<Cryto>crytos;
    private String Base_url= "https://api.nomics.com/v1/";
    Retrofit retrofit;
    //currencies/ticker?key=a866875e05af5166dbb35089bdb3f2df225ed4b2

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerView);



        Gson gson=new GsonBuilder().setLenient().create();


        retrofit =new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadDataApi();


    }


    private void loadDataApi(){

        CryptoApi cryptoApi=retrofit.create(CryptoApi.class);
        Call<List<Cryto>> call=cryptoApi.getData();

        call.enqueue(new Callback<List<Cryto>>() {
            @Override
            public void onResponse(Call<List<Cryto>> call, Response<List<Cryto>> response) {
                if(response.isSuccessful()){

                    List<Cryto>responseList =response.body();
                    crytos = new ArrayList<>(responseList);

                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                    recyclerViewAdapter=new RecyclerViewAdapter(crytos);
                    recyclerView.setAdapter(recyclerViewAdapter);



                }
            }

            @Override
            public void onFailure(Call<List<Cryto>> call, Throwable t) {

                t.printStackTrace();

            }
        });

    }





}