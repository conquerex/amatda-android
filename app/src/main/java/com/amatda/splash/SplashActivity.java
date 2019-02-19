package com.amatda.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        if (results.isEmpty()) {
            AddCarrierActivity.startAddCarrierActivityfromSplash(getApplicationContext());
            Log.d("SplashActivity", " * * * result empty");
            for (int i = 1; i < 4; i++) {
                realm.beginTransaction();
                Carrier carrier = realm.createObject(Carrier.class, i);
                realm.commitTransaction();
            }
        } else {
            CarrierMainActivity.startCarrierMainActivity(getApplicationContext());
            Log.d("SplashActivity", " * * * result : " + results.toString());
        }

        setContentView(R.layout.activity_splash);

        lottieSplash = findViewById(R.id.lottieSplash);
        lottieSplash.setAnimation("ani_09_passport.json");
        lottieSplash.playAnimation();
    }
}