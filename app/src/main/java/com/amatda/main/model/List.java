package com.amatda.main.model;

import java.util.Arrays;

/**
 * Created by barley on 22/02/2019
 */
public class List {
    private Carrier[] carrier;

    private Opt[] opt;

    public Carrier[] getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier[] carrier) {
        this.carrier = carrier;
    }

    public Opt[] getOpt() {
        return opt;
    }

    public void setOpt(Opt[] opt) {
        this.opt = opt;
    }

    @Override
    public String toString() {
        return "List{" +
                "carrier=" + Arrays.toString(carrier) +
                ", opt=" + Arrays.toString(opt) +
                '}';
    }
}
