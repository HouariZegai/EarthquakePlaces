package com.houarizegai.placefinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.houarizegai.placefinder.R;
import com.houarizegai.placefinder.model.Geoname;

import java.util.ArrayList;

public class GeonamesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Geoname> geonames;

    public GeonamesAdapter(Context context, ArrayList<Geoname> geonames) {
        this.context = context;
        this.geonames = geonames;
    }

    @Override
    public int getCount() {
        return geonames.size();
    }

    @Override
    public Object getItem(int position) {
        return geonames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.details_list_view, null);

        TextView txtToponymName = view.findViewById(R.id.txtToponymName);
        TextView txtLng = view.findViewById(R.id.txtLng);
        TextView txtGeonameId = view.findViewById(R.id.txtGeonameId);
        TextView txtPopulation = view.findViewById(R.id.txtPopulation);
        TextView txtCountryName = view.findViewById(R.id.txtCountryName);
        TextView txtAdminName1 = view.findViewById(R.id.txtAdminName1);
        TextView txtLat = view.findViewById(R.id.txtLat);

        txtToponymName.setText(String.valueOf(geonames.get(position).getToponymName()));
        txtLng.setText(String.valueOf(geonames.get(position).getLng()));
        txtGeonameId.setText(String.valueOf(geonames.get(position).getGeonameId()));
        txtPopulation.setText(String.valueOf(geonames.get(position).getPopulation()));
        txtCountryName.setText(String.valueOf(geonames.get(position).getCountryName()));
        txtAdminName1.setText(String.valueOf(geonames.get(position).getAdminName1()));
        txtLat.setText(String.valueOf(geonames.get(position).getLat()));

        return view;
    }
}
