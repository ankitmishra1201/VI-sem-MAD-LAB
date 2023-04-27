package com.example.insem2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private DBHandler dbHandler;
    EditText comission;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        update=findViewById(R.id.update);
        comission=findViewById(R.id.comissionET);
        dbHandler=new DBHandler(ThirdActivity.this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.updateComission(comission.getText().toString());
                Toast.makeText(ThirdActivity.this, "Success", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }


}