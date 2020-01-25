package com.houarizegai.placefinder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.houarizegai.placefinder.R;
import com.houarizegai.placefinder.database.EarthquakeDB;
import com.houarizegai.placefinder.model.Earthquake;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ArrayList<Earthquake> earthquakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Load data from SQLite database
        EarthquakeDB earthquakeDB = new EarthquakeDB(this);
        earthquakes = earthquakeDB.getAll();

        fillInTable();
    }

    private void fillInTable() {
        ((TextView) findViewById(R.id.txtDatetime)).setText("Date Time");
        ((TextView) findViewById(R.id.txtLng)).setText("Lng");
        ((TextView) findViewById(R.id.txtSrc)).setText("Src");
        ((TextView) findViewById(R.id.txtEqid)).setText("Eqid");
        ((TextView) findViewById(R.id.txtMagnitude)).setText("Magnitude");
        ((TextView) findViewById(R.id.txtLat)).setText("Lat");

        int index = 0;

        ((TextView) findViewById(R.id.txtDatetime1)).setText(earthquakes.get(index).getDatetime());
        ((TextView) findViewById(R.id.txtLng1)).setText(String.valueOf(earthquakes.get(index).getDepth()));
        ((TextView) findViewById(R.id.txtSrc1)).setText(String.valueOf(earthquakes.get(index).getLng()));
        ((TextView) findViewById(R.id.txtEqid1)).setText(earthquakes.get(index).getEqid());
        ((TextView) findViewById(R.id.txtMagnitude1)).setText(String.valueOf(earthquakes.get(index).getMagnitude()));
        ((TextView) findViewById(R.id.txtLat1)).setText(String.valueOf(earthquakes.get(index).getLat()));
        index++;

        if (earthquakes.size() < index) return;

        ((TextView) findViewById(R.id.txtDatetime2)).setText(earthquakes.get(index).getDatetime());
        ((TextView) findViewById(R.id.txtLng2)).setText(String.valueOf(earthquakes.get(index).getDepth()));
        ((TextView) findViewById(R.id.txtSrc2)).setText(String.valueOf(earthquakes.get(index).getLng()));
        ((TextView) findViewById(R.id.txtEqid2)).setText(earthquakes.get(index).getEqid());
        ((TextView) findViewById(R.id.txtMagnitude2)).setText(String.valueOf(earthquakes.get(index).getMagnitude()));
        ((TextView) findViewById(R.id.txtLat2)).setText(String.valueOf(earthquakes.get(index).getLat()));
        index++;

        if (earthquakes.size() < index) return;

        ((TextView) findViewById(R.id.txtDatetime3)).setText(earthquakes.get(index).getDatetime());
        ((TextView) findViewById(R.id.txtLng3)).setText(String.valueOf(earthquakes.get(index).getDepth()));
        ((TextView) findViewById(R.id.txtSrc3)).setText(String.valueOf(earthquakes.get(index).getLng()));
        ((TextView) findViewById(R.id.txtEqid3)).setText(earthquakes.get(index).getEqid());
        ((TextView) findViewById(R.id.txtMagnitude3)).setText(String.valueOf(earthquakes.get(index).getMagnitude()));
        ((TextView) findViewById(R.id.txtLat3)).setText(String.valueOf(earthquakes.get(index).getLat()));
        index++;

        if (earthquakes.size() < index) return;

        ((TextView) findViewById(R.id.txtDatetime4)).setText(earthquakes.get(index).getDatetime());
        ((TextView) findViewById(R.id.txtLng4)).setText(String.valueOf(earthquakes.get(index).getDepth()));
        ((TextView) findViewById(R.id.txtSrc4)).setText(String.valueOf(earthquakes.get(index).getLng()));
        ((TextView) findViewById(R.id.txtEqid4)).setText(earthquakes.get(index).getEqid());
        ((TextView) findViewById(R.id.txtMagnitude4)).setText(String.valueOf(earthquakes.get(index).getMagnitude()));
        ((TextView) findViewById(R.id.txtLat4)).setText(String.valueOf(earthquakes.get(index).getLat()));
        index++;

        if (earthquakes.size() < index) return;

        ((TextView) findViewById(R.id.txtDatetime5)).setText(earthquakes.get(index).getDatetime());
        ((TextView) findViewById(R.id.txtLng5)).setText(String.valueOf(earthquakes.get(index).getDepth()));
        ((TextView) findViewById(R.id.txtSrc5)).setText(String.valueOf(earthquakes.get(index).getLng()));
        ((TextView) findViewById(R.id.txtEqid5)).setText(earthquakes.get(index).getEqid());
        ((TextView) findViewById(R.id.txtMagnitude5)).setText(String.valueOf(earthquakes.get(index).getMagnitude()));
        ((TextView) findViewById(R.id.txtLat5)).setText(String.valueOf(earthquakes.get(index).getLat()));
        index++;

        if (earthquakes.size() < index) return;

        ((TextView) findViewById(R.id.txtDatetime6)).setText(earthquakes.get(index).getDatetime());
        ((TextView) findViewById(R.id.txtLng6)).setText(String.valueOf(earthquakes.get(index).getDepth()));
        ((TextView) findViewById(R.id.txtSrc6)).setText(String.valueOf(earthquakes.get(index).getLng()));
        ((TextView) findViewById(R.id.txtEqid6)).setText(earthquakes.get(index).getEqid());
        ((TextView) findViewById(R.id.txtMagnitude6)).setText(String.valueOf(earthquakes.get(index).getMagnitude()));
        ((TextView) findViewById(R.id.txtLat6)).setText(String.valueOf(earthquakes.get(index).getLat()));
        index++;

        if (earthquakes.size() < index) return;

        ((TextView) findViewById(R.id.txtDatetime7)).setText(earthquakes.get(index).getDatetime());
        ((TextView) findViewById(R.id.txtLng7)).setText(String.valueOf(earthquakes.get(index).getDepth()));
        ((TextView) findViewById(R.id.txtSrc7)).setText(String.valueOf(earthquakes.get(index).getLng()));
        ((TextView) findViewById(R.id.txtEqid7)).setText(earthquakes.get(index).getEqid());
        ((TextView) findViewById(R.id.txtMagnitude7)).setText(String.valueOf(earthquakes.get(index).getMagnitude()));
        ((TextView) findViewById(R.id.txtLat7)).setText(String.valueOf(earthquakes.get(index).getLat()));
    }

    public void onBack(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
