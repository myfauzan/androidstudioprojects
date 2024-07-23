package com.example.circleprogessbar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    Activity activity;
    List<Data> items;
    private LayoutInflater inflater;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //if (inflater == null)
          //  inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //if (convertView == null) convertView = inflater.inflate(R.layout.list, null);

        //TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView data_temperature = (TextView) convertView.findViewById(R.id.data_temperature);
        //TextView data_humidity = (TextView) convertView.findViewById(R.id.data_humidity);
        TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);

        Data data = items.get(position);

        //id.setText(data.getId());
        data_temperature.setText(String.valueOf(data.getData_temperature()));
        //data_humidity.setText(String.valueOf(data.getData_humidity()));
        timestamp.setText(data.getTimestamp());

        return convertView;
    }
}

