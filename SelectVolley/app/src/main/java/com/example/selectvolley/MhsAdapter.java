package com.example.selectvolley;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MhsAdapter extends BaseAdapter {
    Activity activity;
    List<Data> items;
    private LayoutInflater inflater;

    public MhsAdapter(Activity activity, List<Data> items) {
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
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) convertView = inflater.inflate(R.layout.list, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView data_temperature = (TextView) convertView.findViewById(R.id.data_temperature);
        TextView data_humidity = (TextView) convertView.findViewById(R.id.data_humidity);
        TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);
        ProgressBar progressBartemperature = (ProgressBar) convertView.findViewById(R.id.progress_bar_temperature);
        TextView nilai_temperature = (TextView) convertView.findViewById(R.id.nilai_data_temperature);
        ProgressBar progressBarhumidity = (ProgressBar) convertView.findViewById(R.id.progress_bar_humditiy);
        TextView nilai_humidity = (TextView) convertView.findViewById(R.id.nilai_data_humidity);

        Data data = items.get(position);

        id.setText(data.getId());
        data_temperature.setText(String.valueOf(data.getData_temperature()));
        data_humidity.setText(String.valueOf(data.getData_humidity()));
        timestamp.setText(data.getTimestamp());
        progressBartemperature.setProgress(Integer.parseInt(String.valueOf(data.getData_temperature())));
        nilai_temperature.setText(String.valueOf(data.getData_temperature()) + "%");
        progressBarhumidity.setProgress(Integer.parseInt(String.valueOf(data.getData_humidity())));
        nilai_humidity.setText(String.valueOf(data.getData_humidity()) + "%");

        return convertView;
    }
}
