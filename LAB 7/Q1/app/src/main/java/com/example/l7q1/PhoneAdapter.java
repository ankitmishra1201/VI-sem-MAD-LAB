package com.example.l7q1;



import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PhoneAdapter extends ArrayAdapter<Customer>
{
    private Context context;
    private ArrayList<Customer> list;

    public PhoneAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Customer> objects)
    {
        super(context, 0, objects);
        this.context = context;
        this.list = objects;
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
        View v;
        if(convertView==null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        else
            v = convertView;

        Customer object = list.get(position);
        ((TextView)v.findViewById(R.id.name)).setText(object.getName());
        ((TextView)v.findViewById(R.id.phone_num)).setText(object.getNum());
        return v;
    }
}