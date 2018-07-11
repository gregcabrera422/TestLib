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

public class ButtonFragment extends Fragment implements View.OnClickListener{

    CustomButton myButton;
    EditText etText, etWidth, etHeight, etColor, etRadius, etBorderWidth, etBorderColor;

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
                myButton.setText(etText.getText().toString());
                break;
            case R.id.btnWidth:
                String strWidth = etWidth.getText().toString();
                if(!TextUtils.isEmpty(strWidth)) {
                    ViewGroup.LayoutParams widthParam = myButton.getLayoutParams();
                    widthParam.width = Integer.parseInt(strWidth);
                    myButton.setLayoutParams(widthParam);
                }
                break;
            case R.id.btnHeight:
                String strHeight = etHeight.getText().toString();

                if(!TextUtils.isEmpty(strHeight)) {
                    ViewGroup.LayoutParams heightParam = myButton.getLayoutParams();
                    heightParam.height = Integer.parseInt(strHeight);
                    myButton.setLayoutParams(heightParam);
                }
                break;
            case R.id.btnColor:
                String strColor = etColor.getText().toString();

                if(!TextUtils.isEmpty(strColor)){
                    myButton.setColor(strColor);
                }
                break;
            case R.id.btnRadius:

                if(!TextUtils.isEmpty(etRadius.getText().toString())){
                    int radius = Integer.parseInt(etRadius.getText().toString());
                    myButton.setRadius(radius);
                }
                break;
            case R.id.btnStoke:
                String strBorderColor = etBorderColor.getText().toString();

                if(!TextUtils.isEmpty(strBorderColor)&&TextUtils.isEmpty(etBorderWidth.getText().toString())){
                    int borderWidth = Integer.parseInt(etBorderWidth.getText().toString());
                    myButton.setStroke(borderWidth, strBorderColor);
                }
        }
    }
}
