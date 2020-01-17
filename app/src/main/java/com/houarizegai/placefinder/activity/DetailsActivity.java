package com.houarizegai.placefinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.houarizegai.placefinder.R;
import com.houarizegai.placefinder.adapter.GeonamesAdapter;
import com.houarizegai.placefinder.database.GeonamesDB;
import com.houarizegai.placefinder.model.Geoname;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ListView listViewEarthquake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        listViewEarthquake = findViewById(R.id.listViewEarthquake);

        // Load data from SQLite database
        GeonamesDB geonamesDB = new GeonamesDB(this);
        ArrayList<Geoname> geonames = geonamesDB.getAll();

        GeonamesAdapter earthquakeAdapter = new GeonamesAdapter(this, geonames);
        listViewEarthquake.setAdapter(earthquakeAdapter);
    }

    public void onBack(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
