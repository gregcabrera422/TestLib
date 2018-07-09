package com.gospce.adc.gospcelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomButton myButton;
    private CustomSearch myEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.myButton);
        myEditText = findViewById(R.id.myEditText);
        myEditText.setText("Test input");
        myButton.setOnClickListener(new CustomButton.OnClickListener(){
            public void onClick(View v){

                System.out.println("TEXT: " + myEditText.getText());
                Toast.makeText(getApplicationContext(), myEditText.getText(), Toast.LENGTH_LONG);

            }
        });
    }
}
