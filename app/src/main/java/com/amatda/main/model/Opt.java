package com.amatda.main.model;

/**
 * Created by barley on 22/02/2019
 */
public class Opt {
    private String oCategory;

    public String getoCategory() {
        return oCategory;
    }

    public void setoCategory(String oCategory) {
        this.oCategory = oCategory;
    }

    @Override
    public String toString() {
        return "Opt{" +
                "oCategory='" + oCategory + '\'' +
                '}';
    }
}
