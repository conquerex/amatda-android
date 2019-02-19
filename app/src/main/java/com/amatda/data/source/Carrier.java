package com.amatda.data.source;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Carrier extends RealmObject {

    @PrimaryKey
    private int carrierId;

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "carrierId=" + carrierId +
                '}';
    }
}
