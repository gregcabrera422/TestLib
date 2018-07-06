package com.gospce.adc.gospcelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

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

        GradientDrawable bgShape = (GradientDrawable)getBackground();
        bgShape.mutate();
        bgShape.setColor(attributes.getColor(R.styleable.CustomButton_buttonColor, 0));
    }


}
