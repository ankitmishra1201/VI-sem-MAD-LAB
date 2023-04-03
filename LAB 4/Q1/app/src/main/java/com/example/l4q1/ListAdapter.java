package com.example.l4q1;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter
{
    ArrayList<String>list;
    Context context;

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects)
    {
        super(context, 0, objects);
        this.list = objects;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        ((ImageView) v.findViewById(R.id.img)).setImageResource(R.drawable.android);
        ((TextView) v.findViewById(R.id.text)).setText(list.get(position));
        return v;
    }
}