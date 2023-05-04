package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    private ListView listView;
    private TextView total_amount;
    private int amount;
    private ArrayList<CharSequence> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        listView=findViewById(R.id.listview);
        total_amount=findViewById(R.id.total_amount);
        amount=getIntent().getIntExtra("amount",0);
        items=new ArrayList<>();
        items=getIntent().getCharSequenceArrayListExtra("items");

        ArrayAdapter<CharSequence> arrayAdapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );
        listView.setAdapter(arrayAdapter);
        total_amount.setText(""+amount);

    }
}