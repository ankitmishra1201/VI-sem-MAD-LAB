package com.example.l5q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView type,vchno,rcno;
    Button edit,preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i=getIntent();
        String type1=i.getStringExtra("type");
        String vchno1=i.getStringExtra("vchno");
        String rcno1=i.getStringExtra("rcno");
        String message= "Type"+type1+"\n"+"Vechile no"+vchno1+"\n"+"RC no"+rcno1+"\n";
        preview=findViewById(R.id.Preview);
        edit=findViewById(R.id.Edit);
        type.setText(type1);
        vchno.setText(vchno1);
        rcno.setText(rcno1);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
}