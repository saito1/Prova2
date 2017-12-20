package com.rafaelsaito.desafio.Acoes_Sociais;

import com.rafaelsaito.desafio.Entity.AcaoEntity;

import java.util.List;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public interface AcaoView {
    void updateList(List<AcaoEntity> acaoList);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}
