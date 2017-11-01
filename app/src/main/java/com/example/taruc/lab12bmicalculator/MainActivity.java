package com.example.taruc.lab12bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Global Variable
    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById(R.id.imageViewMessage);

    }

    public void calculateBMI(View view){
        double weight, height ,bmi;
        //TODO: calculate BMI and display the result
        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        height = height/100;

        bmi = weight/(Math.pow(height,2));

        if(bmi <= 18.5){
            textViewResult.setText("Your BMI is " + Math.round(bmi *100)/100 + ". You are under weight");
            //Set image type


            imageViewResult.setImageResource(R.drawable.under);
        }
        else if(bmi >= 21){
            textViewResult.setText("Your BMI is " + Math.round(bmi *100)/100 + ". You are over weight");
            //Set image type
            imageViewResult.setImageResource(R.drawable.over);
        }
        else{
            textViewResult.setText("Your BMI is " + Math.round(bmi *100)/100 + ". You are normal weight");
            //Set image type
            imageViewResult.setImageResource(R.drawable.normal);
        }

    }

    public void reset(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
