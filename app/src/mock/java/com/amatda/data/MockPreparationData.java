package com.amatda.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MockPreparationData extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<MockOptionData> options;
    private boolean isRecommend;
    private long createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<MockOptionData> getOptions() {
        return options;
    }

    public void setOptions(RealmList<MockOptionData> options) {
        this.options = options;
    }

    public boolean isRecommend() {
        return isRecommend;
    }

    public void setRecommend(boolean recommend) {
        isRecommend = recommend;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}
