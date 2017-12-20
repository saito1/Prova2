package com.rafaelsaito.desafio.network.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rafaelsaito.desafio.Entity.AcaoListEntity;
import com.rafaelsaito.desafio.network.service.AcoesService;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public class AcoesAPI {
    private static AcoesAPI instance;
    private AcoesService acoesService;

    public static AcoesAPI getInstance() {
        if (instance == null) {
            instance = new AcoesAPI();
        }
        return instance;
    }

    private AcoesAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(defaultConverterFactory())
                .build();
        this.acoesService = retrofit.create(AcoesService.class);
    }

    private Converter.Factory defaultConverterFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return GsonConverterFactory.create(gson);
    }

    public Call<AcaoListEntity> getAcoes() {
        return acoesService.getAcaoList();
    }
}
