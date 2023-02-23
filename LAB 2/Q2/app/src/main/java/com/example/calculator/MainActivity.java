package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         num1=(EditText) findViewById(R.id.num1);
         num2=(EditText) findViewById(R.id.num2);
         result=(TextView) findViewById(R.id.result);

    }

    public void buttonsum(View view){
        int n1= Integer.parseInt(num1.getText().toString());
        int n2= Integer.parseInt(num2.getText().toString());
        int sum= n1+n2;
        result.setText(String.valueOf(sum));
    }
    public void buttonsub(View view){
        int n1= Integer.parseInt(num1.getText().toString());
        int n2= Integer.parseInt(num2.getText().toString());
        int sum= n1-n2;
        result.setText(String.valueOf(sum));
    }
    public void buttonprod(View view){
        int n1= Integer.parseInt(num1.getText().toString());
        int n2= Integer.parseInt(num2.getText().toString());
        int sum= n1*n2;
        result.setText(String.valueOf(sum));
    }
    public void buttondiv(View view){
        int n1= Integer.parseInt(num1.getText().toString());
        int n2= Integer.parseInt(num2.getText().toString());
        int sum= n1/n2;
        result.setText(String.valueOf(sum));
    }
}