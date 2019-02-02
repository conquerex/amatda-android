/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amatda.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.NavigationView;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.amatda.Injection;
import com.amatda.R;
import com.amatda.statistics.StatisticsActivity;
import com.amatda.util.ActivityUtils;
import com.amatda.util.EspressoIdlingResource;

public class CarrierMainActivity extends AppCompatActivity {

//    private DrawerLayout mDrawerLayout;

    private CarrierMainPresenter mCarrierMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrier_main);

        CarrierMainFragment carrierMainFragment =
                (CarrierMainFragment) getSupportFragmentManager().findFragmentById(R.id.layoutCarrierMain);
        if (carrierMainFragment == null) {
            // Create the fragment
            carrierMainFragment = CarrierMainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), carrierMainFragment, R.id.layoutCarrierMain);
        }

        // Api test
//        mCarrierMainPresenter.getJKStest();

        // Create the presenter
        mCarrierMainPresenter = new CarrierMainPresenter(
                Injection.provideUseCaseHandler(),
                carrierMainFragment,
                Injection.provideGetTasks(getApplicationContext()),
                Injection.provideCompleteTasks(getApplicationContext()),
                Injection.provideActivateTask(getApplicationContext()),
                Injection.provideClearCompleteTasks(getApplicationContext())
                );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }
}
