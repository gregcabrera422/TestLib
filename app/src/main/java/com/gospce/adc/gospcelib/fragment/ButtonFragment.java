package com.gospce.adc.gospcelib.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.gospce.adc.gospcelib.CustomButton;
import com.gospce.adc.gospcelib.R;
import com.gospce.adc.gospcelib.utility.TestMethods;

public class ButtonFragment extends Fragment implements View.OnClickListener{

    CustomButton myButton;
    EditText etText, etWidth, etHeight, etColor, etRadius, etBorderWidth, etBorderColor;
    TestMethods testMethods = new TestMethods();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_button, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myButton = view.findViewById(R.id.myButton);
        etText = view.findViewById(R.id.etText);
        etWidth = view.findViewById(R.id.etWidth);
        etHeight = view.findViewById(R.id.etHeight);
        etColor = view.findViewById(R.id.etColor);
        etRadius = view.findViewById(R.id.etRadius);
        etBorderWidth = view.findViewById(R.id.etBorderWidth);
        etBorderColor = view.findViewById(R.id.etBorderColor);

        view.findViewById(R.id.btnText).setOnClickListener(this);
        view.findViewById(R.id.btnWidth).setOnClickListener(this);
        view.findViewById(R.id.btnHeight).setOnClickListener(this);
        view.findViewById(R.id.btnColor).setOnClickListener(this);
        view.findViewById(R.id.btnRadius).setOnClickListener(this);
        view.findViewById(R.id.btnStoke).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btnText:
                testMethods.editText(myButton, etText);
                break;
            case R.id.btnWidth:
                testMethods.editWidth(myButton, etWidth);
                break;
            case R.id.btnHeight:
                testMethods.editHeight(myButton, etHeight);
                break;
            case R.id.btnColor:
                testMethods.editColor(myButton, etColor);
                break;
            case R.id.btnRadius:
                testMethods.editRadius(myButton, etRadius);
                break;
            case R.id.btnStoke:
                testMethods.editStroke(myButton, etBorderWidth, etBorderColor);
                break;
        }
    }
}
