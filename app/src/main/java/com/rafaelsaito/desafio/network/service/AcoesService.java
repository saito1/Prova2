package com.rafaelsaito.desafio.network.service;

import com.rafaelsaito.desafio.Entity.AcaoListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public interface AcoesService {
    @GET("s/50vmlj7dhfaibpj/sociais.json")
    Call<AcaoListEntity> getAcaoList();
}
