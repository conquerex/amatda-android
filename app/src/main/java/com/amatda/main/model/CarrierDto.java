package com.amatda.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by barley on 22/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrierDto {
    @SerializedName("list")
    @Expose
    private CarrierList carrierList;

    public CarrierList getCarrierList() {
        return carrierList;
    }

    public void setCarrierList(CarrierList carrierList) {
        this.carrierList = carrierList;
    }

    @Override
    public String toString() {
        return "CarrierDto{" +
                "carrierList=" + carrierList +
                '}';
    }
}
