package com.amatda.addcarrier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amatda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddOptionFragment extends Fragment implements View.OnClickListener {

    private View layoutAddOptionNone;
    private View layoutAddOptionEssential;
    private View layoutAddOptionSwimming;
    private View layoutAddOptionWinter;
    private View layoutAddOptionCamping;
    private View layoutAddOptionBusiness;
    private View layoutAddOptionBaby;

    public AddOptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_option, container, false);

        layoutAddOptionNone = view.findViewById(R.id.layoutAddOptionNone);
        layoutAddOptionEssential = view.findViewById(R.id.layoutAddOptionEssential);
        layoutAddOptionSwimming = view.findViewById(R.id.layoutAddOptionSwimming);
        layoutAddOptionWinter = view.findViewById(R.id.layoutAddOptionWinter);
        layoutAddOptionCamping = view.findViewById(R.id.layoutAddOptionCamping);
        layoutAddOptionBusiness = view.findViewById(R.id.layoutAddOptionBusiness);
        layoutAddOptionBaby = view.findViewById(R.id.layoutAddOptionBaby);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutAddOptionNone:
                break;
            case R.id.layoutAddOptionEssential:
                break;
            case R.id.layoutAddOptionSwimming:
                break;
            case R.id.layoutAddOptionWinter:
                break;
            case R.id.layoutAddOptionCamping:
                break;
            case R.id.layoutAddOptionBusiness:
                break;
            case R.id.layoutAddOptionBaby:
                break;
            default:
                break;
        }
    }
}
