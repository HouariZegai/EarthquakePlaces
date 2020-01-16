package com.houarizegai.placefinder.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.houarizegai.placefinder.model.Earthquake;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Earthquake> extractEarthquakes(String jsonResponse) {
        ArrayList<Earthquake> earthquakes = null;

        try {
            JSONObject reader = new JSONObject(jsonResponse);
            JSONArray features = reader.getJSONArray("earthquakes");

            earthquakes = new Gson().fromJson(String.valueOf(features), new TypeToken<ArrayList<Earthquake>>(){}.getType());

        } catch (JSONException e) {
            Log.e("ParsingError", "Problem parsing EarthQuake JSON result", e);
        }

        return earthquakes;
    }
}
