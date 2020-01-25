package com.houarizegai.placefinder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.houarizegai.placefinder.R;
import com.houarizegai.placefinder.network.HttpGetEarthquakeTask;
import com.houarizegai.placefinder.network.HttpGetGeonamesTask;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;

    private EditText editLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        editLocation = findViewById(R.id.editLocation);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void onSearch(View view) {
        String location = editLocation.getText().toString();

        if(location.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Location is empty!", Toast.LENGTH_LONG).show();
            return;
        }

        EditText editLocation = findViewById(R.id.editLocation);
        new HttpGetGeonamesTask(this).execute(editLocation.getText().toString());
    }

    public void onDetails(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}
