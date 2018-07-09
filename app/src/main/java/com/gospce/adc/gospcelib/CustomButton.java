package com.gospce.adc.gospcelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
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
        setText(attributes.getString(R.styleable.CustomButton_buttonText));
        setBackgroundResource(R.drawable.custom_button);
        setGravity(Gravity.CENTER);

        GradientDrawable border = (GradientDrawable)getBackground();
        border.mutate();
        border.setColor(attributes.getColor(R.styleable.CustomButton_buttonColor, getResources().getColor(R.color.gray)));
        border.setStroke(attributes.getInt(R.styleable.CustomButton_buttonBorderWidth,0), attributes.getColor(R.styleable.CustomButton_buttonBorderColor,0));
        border.setCornerRadius(attributes.getDimension(R.styleable.CustomButton_buttonRadius,0));
        attributes.recycle();
    }


}
