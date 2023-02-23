package com.example.q3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter {
    ArrayList<String> list;
    Context context;

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, 0, objects);
        this.list = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        ((Button) v.findViewById(R.id.btn)).setText(list.get(position));
        v.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}