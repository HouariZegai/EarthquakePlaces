package com.houarizegai.placefinder.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.houarizegai.placefinder.network.model.Earthquake;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    public static ArrayList<Earthquake> extractEarthquake(String jsonResponse) {
        ArrayList<Earthquake> earthquakes = null;

        try {
            JSONObject reader = new JSONObject(jsonResponse);
            JSONArray features = reader.getJSONArray("earthquakes");

            earthquakes = new Gson().fromJson(String.valueOf(features), new TypeToken<ArrayList<Earthquake>>(){}.getType());

        } catch (JSONException e) {
            Log.e("ParsingError", "Problem patsing EarthQuake JSON result", e);
        }

        return earthquakes;
    }
}
