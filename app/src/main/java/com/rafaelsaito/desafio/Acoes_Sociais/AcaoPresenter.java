package com.rafaelsaito.desafio.Acoes_Sociais;

import com.rafaelsaito.desafio.Entity.AcaoEntity;
import com.rafaelsaito.desafio.Entity.AcaoListEntity;
import com.rafaelsaito.desafio.network.api.AcoesAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public class AcaoPresenter {

    private AcaoView acaoView;
    private List<AcaoEntity> acaoList;
    private AcaoListEntity acaoListEntity;

    AcaoPresenter(AcaoView acaoView){
        this.acaoView = acaoView;
    }

    void updateList(){
        final AcoesAPI acoesAPI = AcoesAPI.getInstance();
        acaoView.showLoading();
        acoesAPI.getAcoes().enqueue(new Callback<AcaoListEntity>() {
            @Override
            public void onResponse(Call<AcaoListEntity> call, Response<AcaoListEntity> response) {
                acaoListEntity = response.body();
                if(acaoListEntity != null && acaoListEntity.getAcoes() != null){
                    acaoView.updateList(acaoListEntity.getAcoes());
                }
                acaoView.hideLoading();
            }

            @Override
            public void onFailure(Call<AcaoListEntity> call, Throwable t) {
                acaoView.showMessage("Falha no acesso ao servidor");
            }
        });
    }

    AcaoEntity getAcaoId(int position) throws IndexOutOfBoundsException {
        return acaoListEntity.getAcoes().get(position);
    }
}
