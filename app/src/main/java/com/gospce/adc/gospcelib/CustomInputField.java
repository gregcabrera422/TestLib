package com.gospce.adc.gospcelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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

import java.text.AttributedCharacterIterator;

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
        setBackgroundResource(R.drawable.custom_input_field);
        etInput = findViewById(R.id.etInput);
        tvTitle = findViewById(R.id.tvTitle);

        tvTitle.setText(attributes.getString(R.styleable.CustomInputField_inputTitle));
        etInput.setHint(attributes.getString(R.styleable.CustomInputField_inputHint));
        etInput.setHintTextColor(attributes.getColor(R.styleable.CustomInputField_inputHintColor,getResources().getColor(R.color.gray)));


        GradientDrawable border = (GradientDrawable)getBackground();
        border.mutate();
        border.setColor(attributes.getColor(R.styleable.CustomInputField_inputColor, getResources().getColor(R.color.white)));
        border.setStroke(attributes.getInt(R.styleable.CustomInputField_inputBorderWidth,5), attributes.getColor(R.styleable.CustomInputField_inputBorderColor,getResources().getColor(R.color.black)));
        border.setCornerRadius(attributes.getDimension(R.styleable.CustomInputField_inputRadius,8));

    }

    public void setColor(String color){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setColor(Color.parseColor(color));
    }
    public void setRadius(int radius){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setCornerRadius(radius);
    }

    public void setStroke(int borderWidth, String color){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setStroke(borderWidth, Color.parseColor(color));
    }

    public void setCornerRadius(int radius){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setCornerRadius(Float.valueOf(radius));
    }

    public Editable getText() {
        return etInput.getText();
    }

    public void setText(String str) {
        etInput.setText(str);
    }

    public void setError(){
        GradientDrawable border = (GradientDrawable)getBackground();
        border.mutate();
        border.setStroke(5, getResources().getColor(R.color.red));
    }

}
