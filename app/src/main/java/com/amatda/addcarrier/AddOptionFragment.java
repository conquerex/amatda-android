package com.amatda.addcarrier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.amatda.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddOptionFragment extends Fragment implements View.OnClickListener {

    private static final String KEY_VALUE_DATE = "KEY_VALUE_DATE";
    private static final int SIZE_OPTIONS = 7;

//    private View layoutAddOptionNone;
//    private View layoutAddOptionEssential;
//    private View layoutAddOptionSwimming;
//    private View layoutAddOptionWinter;
//    private View layoutAddOptionCamping;
//    private View layoutAddOptionBusiness;
//    private View layoutAddOptionBaby;
    private CheckBox checkAddOptionNone;
    private CheckBox checkAddOptionEssential;
    private CheckBox checkAddOptionSwimming;
    private CheckBox checkAddOptionWinter;
    private CheckBox checkAddOptionCamping;
    private CheckBox checkAddOptionBusiness;
    private CheckBox checkAddOptionBaby;
    private TextView textAddOptionNone;
    private TextView textAddOptionEssential;
    private TextView textAddOptionSwimming;
    private TextView textAddOptionWinter;
    private TextView textAddOptionCamping;
    private TextView textAddOptionBusiness;
    private TextView textAddOptionBaby;
    private View viewAddOptionNone;
    private View viewAddOptionEssential;
    private View viewAddOptionSwimming;
    private View viewAddOptionWinter;
    private View viewAddOptionCamping;
    private View viewAddOptionBusiness;
    private View viewAddOptionBaby;
    private Button buttonAddOptionNext;

    private ArrayList<Integer> listOptions;
    private HashMap<Integer, Boolean> mapOptions;

    public AddOptionFragment() {
        // Required empty public constructor
    }

    public static AddOptionFragment newInstance(int valueCity) {
        AddOptionFragment fragment = new AddOptionFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_VALUE_DATE, valueCity);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_option, container, false);

//        layoutAddOptionNone = view.findViewById(R.id.layoutAddOptionNone);
//        layoutAddOptionEssential = view.findViewById(R.id.layoutAddOptionEssential);
//        layoutAddOptionSwimming = view.findViewById(R.id.layoutAddOptionSwimming);
//        layoutAddOptionWinter = view.findViewById(R.id.layoutAddOptionWinter);
//        layoutAddOptionCamping = view.findViewById(R.id.layoutAddOptionCamping);
//        layoutAddOptionBusiness = view.findViewById(R.id.layoutAddOptionBusiness);
//        layoutAddOptionBaby = view.findViewById(R.id.checkAddOptionNone);
        buttonAddOptionNext = view.findViewById(R.id.buttonAddOptionNext);
        checkAddOptionNone = view.findViewById(R.id.checkAddOptionNone);
        checkAddOptionEssential = view.findViewById(R.id.checkAddOptionEssential);
        checkAddOptionSwimming = view.findViewById(R.id.checkAddOptionSwimming);
        checkAddOptionWinter = view.findViewById(R.id.checkAddOptionWinter);
        checkAddOptionCamping = view.findViewById(R.id.checkAddOptionCamping);
        checkAddOptionBusiness = view.findViewById(R.id.checkAddOptionBusiness);
        checkAddOptionBaby = view.findViewById(R.id.checkAddOptionBaby);
        textAddOptionNone = view.findViewById(R.id.textAddOptionNone);
        textAddOptionEssential = view.findViewById(R.id.textAddOptionEssential);
        textAddOptionSwimming = view.findViewById(R.id.textAddOptionSwimming);
        textAddOptionWinter = view.findViewById(R.id.textAddOptionWinter);
        textAddOptionCamping = view.findViewById(R.id.textAddOptionCamping);
        textAddOptionBusiness = view.findViewById(R.id.textAddOptionBusiness);
        textAddOptionBaby = view.findViewById(R.id.textAddOptionBaby);
        viewAddOptionNone = view.findViewById(R.id.viewAddOptionNone);
        viewAddOptionEssential = view.findViewById(R.id.viewAddOptionEssential);
        viewAddOptionSwimming = view.findViewById(R.id.viewAddOptionSwimming);
        viewAddOptionWinter= view.findViewById(R.id.viewAddOptionWinter);
        viewAddOptionCamping= view.findViewById(R.id.viewAddOptionCamping);
        viewAddOptionBusiness= view.findViewById(R.id.viewAddOptionBusiness);
        viewAddOptionBaby = view.findViewById(R.id.viewAddOptionBaby);

//        layoutAddOptionNone.setOnClickListener(this);
//        layoutAddOptionEssential.setOnClickListener(this);
//        layoutAddOptionSwimming.setOnClickListener(this);
//        layoutAddOptionWinter.setOnClickListener(this);
//        layoutAddOptionCamping.setOnClickListener(this);
//        layoutAddOptionBusiness.setOnClickListener(this);
//        layoutAddOptionBaby.setOnClickListener(this);
        buttonAddOptionNext.setOnClickListener(this);
        viewAddOptionNone.setOnClickListener(this);
        viewAddOptionEssential.setOnClickListener(this);
        viewAddOptionSwimming.setOnClickListener(this);
        viewAddOptionWinter.setOnClickListener(this);
        viewAddOptionCamping.setOnClickListener(this);
        viewAddOptionBusiness.setOnClickListener(this);
        viewAddOptionBaby.setOnClickListener(this);

        listOptions = new ArrayList();
        mapOptions = new HashMap<>();
        for (int i = 0; i < SIZE_OPTIONS; i++) {
            mapOptions.put(i, false);
        }

        return view;
    }

    @Override
    public void onClick(View v) {

        /**
         * 선택안함 클릭 했을 때
         */
        if (v.getId() == R.id.viewAddOptionNone) {
            noneSelect(!checkAddOptionNone.isChecked());
        } else {
            checkAddOptionNone.setChecked(false);
            textAddOptionNone.setTextColor(getResources().getColor(R.color.gray));
            mapOptions.put(0, false);
        }

        switch (v.getId()) {
            case R.id.buttonAddOptionNext:
                for (int i = 0; i < SIZE_OPTIONS; i++) {
                    if (mapOptions.get(i)) {
                        Log.d("AddOptionFragment", " * * * options : " + (i+1));
                    }
                }
                break;
            case R.id.viewAddOptionNone:
//                checkAddOptionNone.setChecked(!checkAddOptionNone.isChecked());
                changeOptionStatus(checkAddOptionNone, textAddOptionNone, 0);
                break;
            case R.id.viewAddOptionEssential:
//                checkAddOptionEssential.setChecked(!checkAddOptionEssential.isChecked());
//                mapOptions.put(1, !checkAddOptionEssential.isChecked());
                changeOptionStatus(checkAddOptionEssential, textAddOptionEssential, 1);
                break;
            case R.id.viewAddOptionSwimming:
//                checkAddOptionSwimming.setChecked(!checkAddOptionSwimming.isChecked());
//                mapOptions.put(2, true);
                changeOptionStatus(checkAddOptionSwimming, textAddOptionSwimming, 2);
                break;
            case R.id.viewAddOptionWinter:
//                checkAddOptionWinter.setChecked(!checkAddOptionWinter.isChecked());
//                mapOptions.put(3, true);
                changeOptionStatus(checkAddOptionWinter, textAddOptionWinter, 3);
                break;
            case R.id.viewAddOptionCamping:
//                checkAddOptionCamping.setChecked(!checkAddOptionCamping.isChecked());
//                mapOptions.put(4, true);
                changeOptionStatus(checkAddOptionCamping, textAddOptionCamping, 4);
                break;
            case R.id.viewAddOptionBusiness:
//                checkAddOptionBusiness.setChecked(!checkAddOptionBusiness.isChecked());
//                mapOptions.put(5, true);
                changeOptionStatus(checkAddOptionBusiness, textAddOptionBusiness, 5);
                break;
            case R.id.viewAddOptionBaby:
//                checkAddOptionBaby.setChecked(!checkAddOptionBaby.isChecked());
//                mapOptions.put(6, true);
                changeOptionStatus(checkAddOptionBaby, textAddOptionBaby, 6);
                break;
            default:
                break;
        }
    }

    private void changeOptionStatus(CheckBox checkBox, TextView textView, int valueOption) {
        checkBox.setChecked(!checkBox.isChecked());
        if (checkBox.isChecked()) {
            textView.setTextColor(getResources().getColor(R.color.rose));
        } else {
            textView.setTextColor(getResources().getColor(R.color.gray));
        }
        mapOptions.put(valueOption, checkBox.isChecked());
    }

    private void noneSelect(boolean noneStatus) {
        if (noneStatus) {
            checkAddOptionEssential.setChecked(false);
            checkAddOptionSwimming.setChecked(false);
            checkAddOptionWinter.setChecked(false);
            checkAddOptionCamping.setChecked(false);
            checkAddOptionBusiness.setChecked(false);
            checkAddOptionBaby.setChecked(false);
            textAddOptionEssential.setTextColor(getResources().getColor(R.color.gray));
            textAddOptionSwimming.setTextColor(getResources().getColor(R.color.gray));
            textAddOptionWinter.setTextColor(getResources().getColor(R.color.gray));
            textAddOptionCamping.setTextColor(getResources().getColor(R.color.gray));
            textAddOptionBusiness.setTextColor(getResources().getColor(R.color.gray));
            textAddOptionBaby.setTextColor(getResources().getColor(R.color.gray));

            textAddOptionNone.setTextColor(getResources().getColor(R.color.rose));
            for (int i = 0; i < SIZE_OPTIONS; i++) {
                if (i == 0) {
                    mapOptions.put(i, true);
                } else {
                    mapOptions.put(i, false);
                }
            }
        } else {
            textAddOptionNone.setTextColor(getResources().getColor(R.color.gray));
            mapOptions.put(0, false);
        }
        
    }
}
