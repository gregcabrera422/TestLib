package com.gospce.adc.gospcelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomInputField extends LinearLayout {

    private EditText etInput;
    private TextView tvTitle;

    public CustomInputField(@NonNull Context context) {
        super(context);
    }

    public CustomInputField(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomInputField(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs){
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.custom_input_field, this, true);

        TypedArray attributes = getContext().obtainStyledAttributes(attrs,R.styleable.CustomInputField);

        etInput = findViewById(R.id.etInput);
        tvTitle = findViewById(R.id.tvTitle);

        tvTitle.setText(attributes.getString(R.styleable.CustomInputField_textTitle));
        etInput.setHint(attributes.getString(R.styleable.CustomInputField_inputHint));
        etInput.setHintTextColor(attributes.getColor(R.styleable.CustomInputField_inputHintColor,0));

    }

    public Editable getText() {
        return etInput.getText();
    }

    public void setText(String str) {
        etInput.setText(str);
    }
}
