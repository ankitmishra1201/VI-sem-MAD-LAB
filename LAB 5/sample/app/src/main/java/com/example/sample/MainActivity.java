package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    CheckBox a,b,c;
    RadioGroup difficulty;

    ArrayList<String> arrayList=new ArrayList<>();
    ArrayList<String> getList(){
        return arrayList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CHECKBOX DECLARATION
        a=(CheckBox) findViewById(R.id.c1);
        b=(CheckBox) findViewById(R.id.c2);
        c=(CheckBox) findViewById(R.id.c3);

        //RADIO GROUP DECLARATION
        difficulty=(RadioGroup) findViewById(R.id.difficulty);

        //LISTVIEW DECLARATION
        ListView mlist=(ListView) findViewById(R.id.list);

       arrayList.add("Hello");
       arrayList.add("Meow");
       arrayList.add("Hulk");
       arrayList.add("Iron");






       //ArrayAdapter

        Button button=(Button) findViewById(R.id.button) ;

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
        mlist.setAdapter(arrayAdapter);

        //CHECKBOX LISTENER
        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    arrayList.add("A");
                    Toast.makeText(MainActivity.this, "Checked A", Toast.LENGTH_SHORT).show();
                }
                else{
                    arrayList.remove("A");
                }
            }
        });
        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Checked B", Toast.LENGTH_SHORT).show();
                }
            }
        });
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Checked C", Toast.LENGTH_SHORT).show();
                }
            }
        });

//RADIOGROUP LISTENER
        difficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.easy:
                        Toast.makeText(MainActivity.this, "Easy Selected", Toast.LENGTH_SHORT).show();
                    case R.id.asian:
                        Toast.makeText(MainActivity.this, "Asian Selected", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //ArrayAdapter Stuff


       mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(MainActivity.this, arrayList.get(i).toString()+" Selected", Toast.LENGTH_SHORT).show();
           }
       });

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getList();
               Intent i=new Intent(MainActivity.this,SecondActivity.class);
               i.putStringArrayListExtra("arraylist",arrayList);
               startActivity(i);
           }
       });




    }
}