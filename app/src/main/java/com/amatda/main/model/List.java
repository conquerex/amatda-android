package com.amatda.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by barley on 22/02/2019
 */
public class List {
    @SerializedName("carrier")
    @Expose
    private ArrayList<Carrier> carrier;

    @SerializedName("opt")
    @Expose
    private ArrayList<Opt> opt;

    @Override
    public String toString() {
        return "List{" +
                "carrier=" + carrier +
                ", opt=" + opt +
                '}';
    }
}
