package com.amatda.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.amatda.R;
import com.amatda.addcarrier.AddCarrierActivity;
import com.amatda.data.source.CarrierData;
import com.amatda.main.CarrierMainActivity;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class SplashActivity extends Activity {

    LottieAnimationView lottieSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<CarrierData> query = realm.where(CarrierData.class);
        RealmResults<CarrierData> results = query.findAll();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (results.isEmpty()) {
                    AddCarrierActivity.startAddCarrierActivity(getApplicationContext());
                    Log.d("SplashActivity", " * * * result empty");
                } else {
                    CarrierData carrierData = realm.where(CarrierData.class).findAll().last();
                    CarrierMainActivity.startCarrierMainActivity(getApplicationContext(), carrierData.getCarrierId());
                    Log.d("SplashActivity", " * * * result : " + results.toString());
                }
                finish();
            }
        }, 2000);

        setContentView(R.layout.activity_splash);
    }
}