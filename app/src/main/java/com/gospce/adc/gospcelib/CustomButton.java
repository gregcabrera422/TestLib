package com.gospce.adc.gospcelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.annotation.Dimension;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;

public class CustomButton extends AppCompatButton {

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attrs){
        TypedArray attributes = getContext().obtainStyledAttributes(attrs,R.styleable.CustomButton);
        setBackgroundResource(R.drawable.custom_button);
        setGravity(Gravity.CENTER);

        GradientDrawable background = (GradientDrawable)getBackground();
        background.setColor(attributes.getColor(R.styleable.CustomButton_buttonColor, getResources().getColor(R.color.gray)));
        background.setStroke(attributes.getInt(R.styleable.CustomButton_buttonBorderWidth,0), attributes.getColor(R.styleable.CustomButton_buttonBorderColor,0));
        background.setCornerRadius(attributes.getDimension(R.styleable.CustomButton_buttonRadius,0));
        attributes.recycle();
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

}
