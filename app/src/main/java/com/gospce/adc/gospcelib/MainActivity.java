package com.gospce.adc.gospcelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private CustomButton myButton;
    private CustomSearch mySearch;
    private CustomInputField myInputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.myButton);
        mySearch = findViewById(R.id.myEditText);
        myInputField = findViewById(R.id.myInputField);

//        myInputField.setError();

    }

}
