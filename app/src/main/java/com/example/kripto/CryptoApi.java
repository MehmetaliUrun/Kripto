package com.example.kripto;



import com.example.kripto.model.Cryto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoApi {

    //get, post, update, delete islemleri
    //https://api.nomics.com/v1/currencies/ticker?key=a866875e05af5166dbb35089bdb3f2df225ed4b2
    //BASE=https://api.nomics.com/v1
    //prices?key=a866875e05af5166dbb35089bdb3f2df225ed4b2

    @GET("currencies/ticker?key=a866875e05af5166dbb35089bdb3f2df225ed4b2")
    Call<List<Cryto>> getData();



}
