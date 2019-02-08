package com.amatda.data;

import io.realm.RealmObject;

/**
 * Created by barley on 08/02/2019
 */
public class MockOptionData extends RealmObject {
    private String option;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
