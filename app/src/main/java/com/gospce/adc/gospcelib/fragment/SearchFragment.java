package com.gospce.adc.gospcelib.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.gospce.adc.gospcelib.CustomInputField;
import com.gospce.adc.gospcelib.CustomSearch;
import com.gospce.adc.gospcelib.R;

public class SearchFragment extends Fragment implements View.OnClickListener{

    CustomSearch mySearch;
    EditText etTitle, etHint, etHintColor, etColor, etWidth, etHeight, etRadius;
    ToggleButton tbError;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mySearch = view.findViewById(R.id.mySearch);
        etHint = view.findViewById(R.id.etHint);
        etColor = view.findViewById(R.id.etColor);
        etHintColor = view.findViewById(R.id.etHintColor);
        etWidth = view.findViewById(R.id.etWidth);
        etHeight = view.findViewById(R.id.etHeight);
        etRadius = view.findViewById(R.id.etRadius);

        view.findViewById(R.id.btnHint).setOnClickListener(this);
        view.findViewById(R.id.btnHintColor).setOnClickListener(this);
        view.findViewById(R.id.btnColor).setOnClickListener(this);
        view.findViewById(R.id.btnHeight).setOnClickListener(this);
        view.findViewById(R.id.btnWidth).setOnClickListener(this);
        view.findViewById(R.id.btnRadius).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnHint:
                String strHint = etHint.getText().toString();
                if(!TextUtils.isEmpty(strHint)){
                    mySearch.setHint(strHint);
                }
                break;
            case R.id.btnHintColor:
                String strHintColor = etHintColor.getText().toString();
                if(!TextUtils.isEmpty(strHintColor)){
                    mySearch.setHintColor(strHintColor);
                }
                break;
            case R.id.btnColor:
                String strColor = etColor.getText().toString();
                if(!TextUtils.isEmpty(strColor)){
                    mySearch.setColor(strColor);
                }
                break;
            case R.id.btnHeight:
                String strHeight = etHeight.getText().toString();
                if(!TextUtils.isEmpty(strHeight)) {
                    ViewGroup.LayoutParams heightParam = mySearch.getLayoutParams();
                    heightParam.height = Integer.parseInt(strHeight);
                    mySearch.setLayoutParams(heightParam);
                }
                break;
            case R.id.btnWidth:
                String strWidth = etWidth.getText().toString();
                if(!TextUtils.isEmpty(strWidth)) {
                    ViewGroup.LayoutParams widthParam = mySearch.getLayoutParams();
                    widthParam.width = Integer.parseInt(strWidth);
                    mySearch.setLayoutParams(widthParam);
                }
                break;
            case R.id.btnRadius:
                if(!TextUtils.isEmpty(etRadius.getText().toString())){
                    int radius = Integer.parseInt(etRadius.getText().toString());

                    mySearch.setRadius(radius);
                }
                break;
        }
    }
}
