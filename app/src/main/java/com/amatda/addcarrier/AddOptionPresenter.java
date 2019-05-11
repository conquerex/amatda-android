package com.amatda.addcarrier;

import android.support.annotation.NonNull;

import com.amatda.data.source.CarrierData;
import com.amatda.util.ApiInterface;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddOptionPresenter implements AddOptionContract.Presenter {

    private final AddOptionContract.View mView;
    private Realm realm;

    private ApiInterface apiInterface;
//    private Realm realm = Realm.getDefaultInstance();

    public AddOptionPresenter(@NonNull AddOptionContract.View mView) {
        this.mView = checkNotNull(mView, "mView cannot be null!");
        this.mView.setPresenter(this);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void start() {
        //
    }

    @Override
    public void makeCarrier(int cCountry, String startDate, String dayDate, ArrayList<Integer> category_list) {

        if (startDate == null || dayDate == null || category_list == null || category_list.size() == 0) {
            mView.onError();
            return;
        }

        realm.beginTransaction();

        RealmResults<CarrierData> results = realm.where(CarrierData.class).findAll();

        CarrierData data = new CarrierData();
        data.setCarrierId(results.size() + 1);
        data.setCountry(cCountry);
        data.setStartDate(startDate);
        data.setDayDate(dayDate);

        RealmList<Integer> list = new RealmList<>();
        for (int i : category_list) {
            list.add(i);
        }
        data.setOptionList(list);

        data.setCreateDate(System.currentTimeMillis());
        data.setActivate(true);
        realm.copyToRealm(data);
        realm.commitTransaction();

        mView.onStartCarrierMain(data.getCarrierId());

        /* todo Local DB 사용으로 아래 폐기
        apiInterface = NetworkSetting.getClient().create(ApiInterface.class);
        Call<Integer> call = apiInterface.makeCarrier(cCountry, startDate, dayDate, category_list);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.d("AddOptionPresenter", " * * * cId : " + response.body().toString());
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.createObject(CarrierData.class, response.body());
                realm.commitTransaction();
                mView.onStartCarrierMain(response.body());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.d("AddOptionPresenter", " * * * Err message : " + t.getMessage());
            }
        });*/
    }
}
