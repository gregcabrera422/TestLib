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
import android.widget.LinearLayout;

import com.gospce.adc.gospcelib.CustomButton;
import com.gospce.adc.gospcelib.R;

public class ButtonFragment extends Fragment implements View.OnClickListener{

    CustomButton myButton;
    EditText etText, etWidth, etHeight;

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

        view.findViewById(R.id.btnText).setOnClickListener(this);
        view.findViewById(R.id.btnWidth).setOnClickListener(this);
        view.findViewById(R.id.btnHeight).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btnText:
                myButton.setText(etText.getText().toString());
                break;
            case R.id.btnWidth:
                if(TextUtils.isEmpty(etWidth.getText())) {
                    ViewGroup.LayoutParams widthParam = myButton.getLayoutParams();
                    widthParam.width = Integer.parseInt(etWidth.getText().toString());
                    myButton.setLayoutParams(widthParam);
                }
                break;
            case R.id.btnHeight:
                if(!TextUtils.isEmpty(etHeight.getText())) {
                    ViewGroup.LayoutParams heightParam = myButton.getLayoutParams();
                    heightParam.height = Integer.parseInt(etHeight.getText().toString());
                    myButton.setLayoutParams(heightParam);
                }
                break;
        }
    }
}
