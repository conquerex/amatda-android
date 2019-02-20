package com.amatda.addcarrier;

import android.support.annotation.NonNull;
import android.util.Log;

import com.amatda.data.source.CarrierData;
import com.amatda.util.ApiInterface;
import com.amatda.util.NetworkSetting;

import java.util.ArrayList;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddOptionPresenter implements AddOptionContract.Presenter {

    private final AddOptionContract.View mView;

    private ApiInterface apiInterface;
//    private Realm realm = Realm.getDefaultInstance();

    public AddOptionPresenter(@NonNull AddOptionContract.View mView) {
        this.mView = checkNotNull(mView, "mView cannot be null!");
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        //
    }

    @Override
    public void makeCarrier(int cCountry, String startDate, ArrayList<Integer> category_list) {
        apiInterface = NetworkSetting.getClient().create(ApiInterface.class);
        Call<Integer> call = apiInterface.makeCarrier(cCountry, startDate, category_list);
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
        });
    }
}
