package com.amatda.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by barley on 22/02/2019
 */
public class Opt {
    @SerializedName("carrier")
    @Expose
    private int oCategory;

    public int getoCategory() {
        return oCategory;
    }

    public void setoCategory(int oCategory) {
        this.oCategory = oCategory;
    }

    @Override
    public String toString() {
        return "Opt{" +
                "oCategory=" + oCategory +
                '}';
    }
}
