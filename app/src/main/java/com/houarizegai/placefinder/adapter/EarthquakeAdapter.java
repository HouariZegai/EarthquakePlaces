package com.houarizegai.placefinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.houarizegai.placefinder.R;
import com.houarizegai.placefinder.model.Earthquake;

import java.util.ArrayList;

public class EarthquakeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Earthquake> earthquakes;

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        this.context = context;
        this.earthquakes = earthquakes;
    }

    @Override
    public int getCount() {
        return earthquakes.size();
    }

    @Override
    public Object getItem(int position) {
        return earthquakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.details_list_view, null);

        TextView txtDateTime = view.findViewById(R.id.txtDatetime);
        TextView txtDepth = view.findViewById(R.id.txtDepth);
        TextView txtLng = view.findViewById(R.id.txtLng);
        TextView txtSrc = view.findViewById(R.id.txtSrc);
        TextView txtEqid = view.findViewById(R.id.txtEqid);
        TextView txtMagnitude = view.findViewById(R.id.txtMagnitude);
        TextView txtLat = view.findViewById(R.id.txtLat);

        txtDateTime.setText(earthquakes.get(position).getDatetime());
        txtDepth.setText(String.valueOf(earthquakes.get(position).getDepth()));
        txtLng.setText(String.valueOf(earthquakes.get(position).getLng()));
        txtSrc.setText(earthquakes.get(position).getSrc());
        txtEqid.setText(earthquakes.get(position).getEqid());
        txtMagnitude.setText(String.valueOf(earthquakes.get(position).getMagnitude()));
        txtLat.setText(String.valueOf(earthquakes.get(position).getLat()));

        return view;
    }
}
