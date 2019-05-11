package com.amatda.data.source;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CarrierData extends RealmObject {

    @PrimaryKey
    private int carrierId;
    private int country;
    private String startDate;
    private String dayDate;
    private RealmList<Integer> optionList;
    private long createDate;
    private boolean activate;

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    public RealmList<Integer> getOptionList() {
        return optionList;
    }

    public void setOptionList(RealmList<Integer> optionList) {
        this.optionList = optionList;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public String toString() {
        return "CarrierData{" +
                "carrierId=" + carrierId +
                ", country=" + country +
                ", startDate='" + startDate + '\'' +
                ", dayDate='" + dayDate + '\'' +
                ", optionList=" + optionList +
                ", createDate=" + createDate +
                ", activate=" + activate +
                '}';
    }
}
