package com.example.anan.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

//trying to fucking update it !!!

public class MainActivity extends AppCompatActivity {

    private Button send_button;
    private EditText myText;
    public final static String EXTRA_MESSAGE = "il.ac.technion.ee.nssl.example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_button = (Button)findViewById(R.id.button_send);
        myText = (EditText)findViewById(R.id.editTextHeight2);

        final Intent intent = new Intent(this, DisplayMessageActivity.class);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = myText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

        /* EditText Height listener */
        EditText editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        editTextHeight.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (!(s.toString().equals(""))) {
                    // My code here
                    calcualteBMI();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        /* EditText Weight listener */
        EditText editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextWeight.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (!(s.toString().equals(""))) {
                    // My code here
                    calcualteBMI();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }


    void calcualteBMI() {

        // Get Height
        EditText editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        String heightString = editTextHeight.getText().toString();

        double height = 0;
        try {
            height = Double.parseDouble(heightString);
        }
        catch (NumberFormatException nfe){
            //Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
        }
        height = height * 1/100;
        height = height*height;

        // Get Weight
        EditText editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        String weightString = editTextWeight.getText().toString();

        double weight = 0;
        try {
            weight = Double.parseDouble(weightString);
        }
        catch (NumberFormatException nfe){
            //Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
        }

        // Calculate result
        double result = Math.round(weight/height);


        // Print result
        TextView TextViewResult = (TextView)findViewById(R.id.textViewResult);


        // If or else for values

        if(result < 18.5){
            TextViewResult.setText("Your BMI is " + result + "\nYou are categorized as underweight.");
        }
        else{
            if(result < 24.9){
                TextViewResult.setText("Your BMI is " + result + "\nYou are categorized as normal weight.");
            }
            else {
                if (result < 29.9) {
                    TextViewResult.setText("Your BMI is " + result + "\nYou are categorized as overweight.");
                }
                else{
                    if(result > 30 && result < 34.9){
                        TextViewResult.setText("Your BMI is " + result + "\nYou are categorized as obese class I (Moderately obese).");
                    }
                    else {
                        if(result < 39.9){
                            TextViewResult.setText("Your BMI is " + result + "\nYou are categorized as obese class II (Severely obese).");
                        }
                        else{
                            if(result < 40){
                                TextViewResult.setText("Your BMI is " + result + "\nYou are categorized as obese class III (Very severely obese).");
                            }
                            else{
                                TextViewResult.setText("");
                            }
                        }
                    }
                }
            }
        }

    }
}