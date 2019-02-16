package com.amatda.splash;

import android.app.Activity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.amatda.R;

public class SplashActivity extends Activity {

    LottieAnimationView lottieSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieSplash = findViewById(R.id.lottieSplash);
        lottieSplash.setAnimation("ani_09_passport.json");
        lottieSplash.playAnimation();
    }
}