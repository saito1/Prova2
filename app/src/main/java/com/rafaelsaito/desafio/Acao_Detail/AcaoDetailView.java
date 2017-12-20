package com.rafaelsaito.desafio.Acao_Detail;

import com.rafaelsaito.desafio.Entity.AcaoEntity;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public interface AcaoDetailView {
    void showDetail(AcaoEntity acaoDetailEntity);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}
