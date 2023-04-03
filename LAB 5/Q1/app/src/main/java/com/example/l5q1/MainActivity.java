package com.example.l5q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner type;
    EditText vchno,rcno;
    Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        type=findViewById(R.id.spinner);
        vchno=findViewById(R.id.textfield1);
        rcno=findViewById(R.id.textfield2);
        submit=findViewById(R.id.Submit);
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item);
        adapter1.addAll(getResources().getStringArray(R.array.types));
        type.setAdapter(adapter1);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("type",type.getSelectedItemPosition());
                intent.putExtra("vchno",vchno.getText().toString());
                intent.putExtra("rcno",rcno.getText().toString());
                startActivity(intent);
            }
        });



    }
}