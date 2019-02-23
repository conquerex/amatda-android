package com.amatda.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by barley on 22/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrier {
    @SerializedName("cName")
    @Expose
    private String cName;

    @SerializedName("cCountry")
    @Expose
    private int cCountry;

    @SerializedName("startDate")
    @Expose
    private String startDate;

    @SerializedName("cId")
    @Expose
    private int cId;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcCountry() {
        return cCountry;
    }

    public void setcCountry(int cCountry) {
        this.cCountry = cCountry;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "cName='" + cName + '\'' +
                ", cCountry=" + cCountry +
                ", startDate='" + startDate + '\'' +
                ", cId=" + cId +
                '}';
    }
}
