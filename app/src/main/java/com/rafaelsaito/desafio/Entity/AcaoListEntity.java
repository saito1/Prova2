package com.rafaelsaito.desafio.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public class AcaoListEntity {

    @SerializedName("acoes_sociais")
    @Expose
    public List<AcaoEntity> acoes_sociais;

    public List<AcaoEntity> getAcoes() {
        return acoes_sociais;
    }
}
