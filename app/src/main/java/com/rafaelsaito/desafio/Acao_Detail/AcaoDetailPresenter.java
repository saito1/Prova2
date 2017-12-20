package com.rafaelsaito.desafio.Acao_Detail;

import com.rafaelsaito.desafio.Entity.AcaoEntity;
import com.rafaelsaito.desafio.network.api.AcoesAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public class AcaoDetailPresenter {

    public AcaoDetailPresenter(AcaoDetailView acaoDetailView) {
        this.acaoDetailView = acaoDetailView;
    }

    AcaoDetailView acaoDetailView;

    private AcaoEntity acaoDetails;

    public void getAcaoDetails(AcaoEntity acaoEntity) {
        acaoDetailView.showDetail(acaoEntity);
    }
}
