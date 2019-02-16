package com.amatda.addcarrier;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.amatda.R;

import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddDateFragment extends Fragment
        implements View.OnClickListener {

    private Button buttonAddDateNext;
    private EditText editAddDateDay;
    private EditText editAddDateTime;

    private Calendar calendar = Calendar.getInstance();
    private int mYear = calendar.get(Calendar.YEAR);
    private int mMonth = calendar.get(Calendar.MONTH);
    private int mDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    private int mHour = calendar.get(Calendar.HOUR_OF_DAY);
    private int mMinute = calendar.get(Calendar.MINUTE);

    public AddDateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_date, container, false);

        buttonAddDateNext = view.findViewById(R.id.buttonAddDateNext);
        editAddDateDay = view.findViewById(R.id.editAddDateDay);
        editAddDateTime = view.findViewById(R.id.editAddDateTime);

        buttonAddDateNext.setOnClickListener(this);
        editAddDateDay.setOnClickListener(this);
        editAddDateTime.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAddDateNext:
                AddOptionFragment fragment = new AddOptionFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.layoutAddCarrier, fragment);
                transaction.commit();
                break;
            case R.id.editAddDateDay:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, month, dayOfMonth);
                                SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
                                editAddDateDay.setText(format.format(calendar.getTime()));
                                mYear = year;
                                mMonth = month;
                                mDayOfMonth = dayOfMonth;
                                Log.d("AddDateFragment", " * * * Day : " + mDayOfMonth);
                            }
                        }, mYear, mMonth, mDayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
                break;
            case R.id.editAddDateTime:
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Time tripTime = new Time(hourOfDay, minute,0);  // seconds by default set to zero
                                Format formatter = new SimpleDateFormat("h:mm a", Locale.US);
                                editAddDateTime.setText(formatter.format(tripTime));
                                mHour = hourOfDay;
                                mMinute = minute;
                                Log.d("AddDateFragment", " * * * time : " + mHour);
                            }
                        }, mHour, mMinute,false);
                timePickerDialog.show();
                break;
            default:
                break;
        }
    }
}
