package com.amatda.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by barley on 22/02/2019
 */
public class CarrierDto {
    @SerializedName("list")
    @Expose
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CarrierDto{" +
                "list=" + list +
                '}';
    }
}
