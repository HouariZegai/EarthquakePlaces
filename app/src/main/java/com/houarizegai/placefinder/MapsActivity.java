package com.houarizegai.placefinder;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.houarizegai.placefinder.network.HttpGetTask;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private TextView txtLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        txtLocation = findViewById(R.id.txtLocation);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void onSearch(View view) {
        String location = txtLocation.getText().toString();
        if(location.isEmpty()) {
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            return;
        }

        Geocoder geocoder = new Geocoder(getApplicationContext());
        List<Address> addressList;
        try {
            addressList = geocoder.getFromLocationName(location, 6);

            for(int i = 0; i < addressList.size(); i++) {
                Address userAddress = addressList.get(i);
                LatLng latLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());

                mMap.addMarker(new MarkerOptions().position(latLng).title("Selected Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            }

//                    MarkerOptions markerOptions = new MarkerOptions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDetails(View view) {
        new HttpGetTask(this).execute();
    }
}
