package com.amatda.addcarrier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.amatda.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddOptionFragment extends Fragment implements View.OnClickListener {

    private static final String KEY_VALUE_DATE = "KEY_VALUE_DATE";

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

    private ArrayList<Integer> listOptions;

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
        viewAddOptionNone.setOnClickListener(this);
        viewAddOptionEssential.setOnClickListener(this);
        viewAddOptionSwimming.setOnClickListener(this);
        viewAddOptionWinter.setOnClickListener(this);
        viewAddOptionCamping.setOnClickListener(this);
        viewAddOptionBusiness.setOnClickListener(this);
        viewAddOptionBaby.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewAddOptionNone:
                checkAddOptionNone.setChecked(!checkAddOptionNone.isChecked());
                noneSelect(checkAddOptionNone.isChecked());
                break;
            case R.id.viewAddOptionEssential:
                checkAddOptionEssential.setChecked(!checkAddOptionEssential.isChecked());
                break;
            case R.id.viewAddOptionSwimming:
                checkAddOptionSwimming.setChecked(!checkAddOptionSwimming.isChecked());
                break;
            case R.id.viewAddOptionWinter:
                checkAddOptionWinter.setChecked(!checkAddOptionWinter.isChecked());
                break;
            case R.id.viewAddOptionCamping:
                checkAddOptionCamping.setChecked(!checkAddOptionCamping.isChecked());
                break;
            case R.id.viewAddOptionBusiness:
                checkAddOptionBusiness.setChecked(!checkAddOptionBusiness.isChecked());
                break;
            case R.id.viewAddOptionBaby:
                checkAddOptionBaby.setChecked(!checkAddOptionBaby.isChecked());
                break;
            default:
                break;
        }
    }

    private void noneSelect(boolean noneStatus) {
        if (noneStatus) {
            checkAddOptionEssential.setChecked(false);
            checkAddOptionSwimming.setChecked(false);
            checkAddOptionWinter.setChecked(false);
            checkAddOptionCamping.setChecked(false);
            checkAddOptionBusiness.setChecked(false);
            checkAddOptionBaby.setChecked(false);
        }
        
    }
}
