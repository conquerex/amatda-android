package com.amatda.main.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CarrierItem extends RealmObject {

    @PrimaryKey
    private int itemId;
    private String itemName;
    private int itemLabel;
    private boolean prepareState;
    private long createDate;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(int itemLabel) {
        this.itemLabel = itemLabel;
    }

    public boolean isPrepareState() {
        return prepareState;
    }

    public void setPrepareState(boolean prepareState) {
        this.prepareState = prepareState;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "CarrierItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemLabel=" + itemLabel +
                ", prepareState=" + prepareState +
                ", createDate=" + createDate +
                '}';
    }
}
