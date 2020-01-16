package com.houarizegai.placefinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.houarizegai.placefinder.R;
import com.houarizegai.placefinder.adapter.EarthquakeAdapter;
import com.houarizegai.placefinder.model.Earthquake;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ListView listViewEarthquake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        listViewEarthquake = findViewById(R.id.listViewEarthquake);

        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        // Need to load data from SQLite database

        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);
        listViewEarthquake.setAdapter(earthquakeAdapter);
    }

    public void onBack(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
