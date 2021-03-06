package com.houarizegai.placefinder.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.houarizegai.placefinder.activity.MapsActivity;
import com.houarizegai.placefinder.database.GeonamesDB;
import com.houarizegai.placefinder.model.Geoname;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HttpGetGeonamesTask extends AsyncTask<String, String, String> {

	public static Geoname locationGeoname;

	public MapsActivity activity;

	private static final String TAG = "HttpGetGeonamesTask";

	private static final String USER_NAME = "houarizegai";
	private static String endPointNearByPlace;

	public HttpGetGeonamesTask(MapsActivity activity) {
		this.activity = activity;
	}

	@Override
	protected String doInBackground(String... params) {
		endPointNearByPlace = new StringBuilder("http://api.geonames.org/searchJSON?q=").append(params[0])
				.append("&maxRows=10&username=").append(USER_NAME).toString();

		String data = null;
		HttpURLConnection httpUrlConnection = null;

		Log.e(TAG, "Params length:" + params.length + " url=" + endPointNearByPlace);
		try {
			httpUrlConnection = (HttpURLConnection) new URL(endPointNearByPlace).openConnection();
			Log.e(TAG, "Success passed -> httpUrlConnection");
			InputStream in = new BufferedInputStream(httpUrlConnection.getInputStream());
			Log.e(TAG, "Success passed -> InputStream");
			data = readStream(in);

		} catch (MalformedURLException exception) {
			Log.e(TAG, "MalformedURLException");
		} catch (IOException exception) {
			Log.e(TAG, "IOException " + exception);
		} finally {
			if (null != httpUrlConnection)
				httpUrlConnection.disconnect();
		}
		return data;
	}

	@Override
	protected void onPostExecute(String result) {
		ArrayList<Geoname> geonames = Utils.extractGeonames(result);

		if(geonames == null || geonames.size() < 1) {
			Toast.makeText(activity, "Internet connection failed or place not found!", Toast.LENGTH_LONG).show();
			return;
		}

		locationGeoname = geonames.get(0);

		GeonamesDB geonamesDB = new GeonamesDB(activity.getApplicationContext());
		geonamesDB.addAll(geonames);

		new HttpGetEarthquakeTask(activity).execute();
	}

	private String readStream(InputStream in) {
		BufferedReader reader = null;
		StringBuffer data = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				data.append(line);
			}
		} catch (IOException e) {
			Log.e(TAG, "IOException");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data.toString();
	}
}