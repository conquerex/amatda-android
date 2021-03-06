package com.amatda.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.amatda.R;
import com.amatda.addcarrier.AddCarrierActivity;
import com.amatda.data.source.Carrier;
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
        RealmQuery<Carrier> query = realm.where(Carrier.class);
        RealmResults<Carrier> results = query.findAll();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (results.isEmpty()) {
                    // todo : AddCarrierActivity로 복원해야 함
                    Log.d("SplashActivity", " * * * result empty");
                    AddCarrierActivity.startAddCarrierActivity(getApplicationContext());
//                    CarrierMainActivity.startCarrierMainActivity(getApplicationContext());
                    /*
                    for (int i = 1; i < 4; i++) {
                        realm.beginTransaction();
                        Carrier carrier = realm.createObject(Carrier.class, i);
                        realm.commitTransaction();
                    }
                    */
                } else {
                    for (Carrier carrier : results) {
                        Log.d("SplashActivity", " * * * result : " + carrier.getCarrierId());
                    }
//                    CarrierMainActivity.startCarrierMainActivity(getApplicationContext());
//                    Log.d("SplashActivity", " * * * result : " + results.toString());
                }
                finish();
            }
        }, 2000);

        setContentView(R.layout.activity_splash);
    }
}