package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView pulse_amount,bread_amount,fruit_amount;
    private Button button;
    private int amount;
    private CheckBox pulse_checkbox,bread_checkbox,fruit_checkbox;
    private ArrayList<CharSequence> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pulse_amount=findViewById(R.id.amount1);
        bread_amount=findViewById(R.id.amount2);
        fruit_amount=findViewById(R.id.amount3);
        button=findViewById(R.id.button);
        amount=0;
        pulse_checkbox=findViewById(R.id.checkBox1);
        bread_checkbox=findViewById(R.id.checkBox2);
        fruit_checkbox=findViewById(R.id.checkBox3);
        items=new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pulse_checkbox.isChecked()){
                    items.add("Pulse");
                    amount=amount+Integer.parseInt(pulse_amount.getText().toString());
                }
                if(bread_checkbox.isChecked()){
                    items.add("Bread");
                    amount=amount+Integer.parseInt(bread_amount.getText().toString());
                }
                if(fruit_checkbox.isChecked()){
                    items.add("Fruit");
                    amount=amount+Integer.parseInt(fruit_amount.getText().toString());
                }
                Intent i=new Intent(MainActivity.this,ViewActivity.class);
                i.putCharSequenceArrayListExtra("items",items);
                i.putExtra("amount",amount);
                startActivity(i);
            }
        });

    }
}