package com.amatda.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by barley on 22/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrierList {
    @SerializedName("carrier")
    @Expose
    private ArrayList<Carrier> carrier;

    @SerializedName("opt")
    @Expose
    private ArrayList<Opt> opt;

    public ArrayList<Carrier> getCarrier() {
        return carrier;
    }

    public void setCarrier(ArrayList<Carrier> carrier) {
        this.carrier = carrier;
    }

    public ArrayList<Opt> getOpt() {
        return opt;
    }

    public void setOpt(ArrayList<Opt> opt) {
        this.opt = opt;
    }

    @Override
    public String toString() {
        return "CarrierList{" +
                "carrier=" + carrier +
                ", opt=" + opt +
                '}';
    }
}
