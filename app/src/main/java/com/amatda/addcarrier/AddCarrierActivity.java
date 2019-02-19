package com.amatda.addcarrier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amatda.R;
import com.amatda.util.ActivityUtils;

public class AddCarrierActivity extends AppCompatActivity {

    public static final String KEY_VALUE_CITY = "KEY_VALUE_CITY";
    public static final String KEY_VALUE_DATE = "KEY_VALUE_DATE";
    public static final String KEY_VALUE_OPTION = "KEY_VALUE_OPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_carrier);

        AddCityFragment fragment =
                (AddCityFragment) getSupportFragmentManager().findFragmentById(R.id.layoutAddCarrier);
        if (fragment == null) {
            fragment = AddCityFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), fragment, R.id.layoutAddCarrier);
        }
    }

    public static void startAddCarrierActivity(Context context) {
        Intent intent = new Intent(context, AddCarrierActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
