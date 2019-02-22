package com.amatda.main.model;

/**
 * Created by barley on 22/02/2019
 */
public class Carrier {
    private String cName;

    private String cCountry;

    private String startDate;

    private String cId;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcCountry() {
        return cCountry;
    }

    public void setcCountry(String cCountry) {
        this.cCountry = cCountry;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "cName='" + cName + '\'' +
                ", cCountry='" + cCountry + '\'' +
                ", startDate='" + startDate + '\'' +
                ", cId='" + cId + '\'' +
                '}';
    }
}
