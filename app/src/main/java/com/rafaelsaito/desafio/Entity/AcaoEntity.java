package com.rafaelsaito.desafio.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Rafael Saito on 18/12/2017.
 */

public class AcaoEntity implements Serializable{
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("site")
    @Expose
    private String site;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoverImageUrl() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getSite(){return site;}
}
