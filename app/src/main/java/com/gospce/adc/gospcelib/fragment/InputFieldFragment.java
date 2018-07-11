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

import com.gospce.adc.gospcelib.CustomButton;
import com.gospce.adc.gospcelib.CustomInputField;
import com.gospce.adc.gospcelib.R;
import com.gospce.adc.gospcelib.utility.TestMethods;

import org.w3c.dom.Text;

public class InputFieldFragment extends Fragment implements View.OnClickListener{

    CustomInputField myInputField;
    EditText etTitle, etHint, etHintColor, etColor, etWidth, etHeight, etRadius;
    ToggleButton tbError;
    TestMethods testMethods = new TestMethods();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input_field, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myInputField = view.findViewById(R.id.myInputField);
        etTitle = view.findViewById(R.id.etTitle);
        etHint = view.findViewById(R.id.etHint);
        etColor = view.findViewById(R.id.etColor);
        etHintColor = view.findViewById(R.id.etHintColor);
        etWidth = view.findViewById(R.id.etWidth);
        etHeight = view.findViewById(R.id.etHeight);
        etRadius = view.findViewById(R.id.etRadius);
        tbError = view.findViewById(R.id.tbError);

        view.findViewById(R.id.btnTitle).setOnClickListener(this);
        view.findViewById(R.id.btnHint).setOnClickListener(this);
        view.findViewById(R.id.btnHintColor).setOnClickListener(this);
        view.findViewById(R.id.btnColor).setOnClickListener(this);
        view.findViewById(R.id.btnHeight).setOnClickListener(this);
        view.findViewById(R.id.btnWidth).setOnClickListener(this);
        view.findViewById(R.id.tbError).setOnClickListener(this);
        view.findViewById(R.id.btnRadius).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnTitle:
                testMethods.editTitle(myInputField, etTitle);
                break;
            case R.id.btnHint:
                String strHint = etHint.getText().toString();
                if(!TextUtils.isEmpty(strHint)){
                    myInputField.setHint(strHint);
                }
                break;
            case R.id.btnHintColor:
                String strHintColor = etHintColor.getText().toString();
                if(!TextUtils.isEmpty(strHintColor)){
                    myInputField.setHintColor(strHintColor);
                }
                break;
            case R.id.btnColor:
                testMethods.editColor(myInputField, etColor);
                break;
            case R.id.btnHeight:
                testMethods.editHeight(myInputField, etHeight);
                break;
            case R.id.btnWidth:
                testMethods.editHeight(myInputField, etWidth);
                break;
            case R.id.tbError:
                if(tbError.isChecked()){
                    myInputField.setError(true);
                }else{
                    myInputField.setError(false);
                }
                break;
            case R.id.btnRadius:
                testMethods.editRadius(myInputField, etRadius);
                break;
        }
    }
}
