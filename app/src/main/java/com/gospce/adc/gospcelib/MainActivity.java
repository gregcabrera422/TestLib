package com.gospce.adc.gospcelib;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomButton myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.myButton);

        myButton.setOnClickListener(new CustomButton.OnClickListener(){
            public void onClick(View v){
                System.out.println("test click");
            }
        });
    }
}
