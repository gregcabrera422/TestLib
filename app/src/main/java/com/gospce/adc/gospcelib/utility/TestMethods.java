package com.gospce.adc.gospcelib.utility;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gospce.adc.gospcelib.CustomButton;
import com.gospce.adc.gospcelib.CustomInputField;

public class TestMethods {

    public void editText(Object object, EditText editText){
        if(object instanceof CustomButton){
            CustomButton button = (CustomButton) object;

            button.setText(editText.getText().toString());
        }
    }

    public void editTitle(Object object, EditText editTitle){
        if(object instanceof CustomInputField){
            CustomInputField inputField = (CustomInputField) object;

            String strTitle = editTitle.getText().toString();
            if(!TextUtils.isEmpty(strTitle)){
                inputField.setTitle(strTitle);
            }
        }
    }

    public void editWidth(Object object, EditText editWidth){
        if(object instanceof CustomButton){
            CustomButton button = (CustomButton) object;
            String strWidth = editWidth.getText().toString();

            if(!TextUtils.isEmpty(strWidth)) {
                ViewGroup.LayoutParams widthParam = button.getLayoutParams();
                widthParam.width = Integer.parseInt(strWidth);
                button.setLayoutParams(widthParam);
            }
        }else if(object instanceof CustomInputField){
            CustomInputField inputField = (CustomInputField) object;

            String strWidth = editWidth.getText().toString();
            if(!TextUtils.isEmpty(strWidth)) {
                ViewGroup.LayoutParams widthParam = inputField.getLayoutParams();
                widthParam.width = Integer.parseInt(strWidth);
                inputField.setLayoutParams(widthParam);
            }

        }
    }

    public void editHeight(Object object, EditText editHeight){
        if(object instanceof CustomButton){
            CustomButton button = (CustomButton) object;
            String strHeight = editHeight.getText().toString();

            if(!TextUtils.isEmpty(strHeight)) {
                ViewGroup.LayoutParams heightParam = button.getLayoutParams();
                heightParam.height = Integer.parseInt(strHeight);
                button.setLayoutParams(heightParam);
            }
        }else if(object instanceof CustomInputField){
            CustomInputField inputField = (CustomInputField) object;

            String strHeight = editHeight.getText().toString();
            if(!TextUtils.isEmpty(strHeight)) {
                ViewGroup.LayoutParams heightParam = inputField.getLayoutParams();
                heightParam.height = Integer.parseInt(strHeight);
                inputField.setLayoutParams(heightParam);
            }
        }
    }

    public void editColor(Object object, EditText editColor){
        if(object instanceof CustomButton){
            CustomButton button = (CustomButton) object;
            String strColor = editColor.getText().toString();

            if(!TextUtils.isEmpty(strColor)){
                button.setColor(strColor);
            }
        }else if(object instanceof CustomInputField){
            CustomInputField inputField = (CustomInputField) object;

            String strColor = editColor.getText().toString();
            if(!TextUtils.isEmpty(strColor)){
                inputField.setColor(strColor);
            }
        }
    }

    public void editRadius(Object object, EditText editRadius){
        if(object instanceof CustomButton){
            CustomButton button = (CustomButton) object;

            if(!TextUtils.isEmpty(editRadius.getText().toString())){
                int radius = Integer.parseInt(editRadius.getText().toString());
                button.setRadius(radius);
            }
        }else if(object instanceof CustomInputField){
            CustomInputField inputField = (CustomInputField) object;

            if(!TextUtils.isEmpty(editRadius.getText().toString())){
                int radius = Integer.parseInt(editRadius.getText().toString());

                inputField.setRadius(radius);
            }
        }


    }

    public void editStroke(Object object, EditText editBorderWidth, EditText editBorderColor){
        if(object instanceof CustomButton){
            CustomButton button = (CustomButton) object;
            String strBorderColor = editBorderColor.getText().toString();

            if(!TextUtils.isEmpty(strBorderColor)&&!TextUtils.isEmpty(editBorderWidth.getText().toString())) {
                int borderWidth = Integer.parseInt(editBorderWidth.getText().toString());
                button.setStroke(borderWidth, strBorderColor);
            }
        }else{

        }
    }

}
