package com.amatda.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MockPreparationData extends RealmObject {
    @PrimaryKey
    private int id;
    private int carrierId;
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

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    @Override
    public String toString() {
        return "MockPreparationData{" +
                "id=" + id +
                ", carrierId=" + carrierId +
                ", name='" + name + '\'' +
                ", options=" + options +
                ", isRecommend=" + isRecommend +
                ", createDate=" + createDate +
                '}';
    }
}
