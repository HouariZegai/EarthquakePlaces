package com.houarizegai.placefinder.network;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.houarizegai.placefinder.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetTask extends AsyncTask<Void, Void, String> {

	public Activity activity;

	private static final String TAG = "HttpGetTask";

	// Get your own user name at http://www.geonames.org/login
	private static final String USER_NAME = "houarizegai";
	private static final String URL = "http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username="
			+ USER_NAME;

	public HttpGetTask(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected String doInBackground(Void... params) {
		String data = null;
		HttpURLConnection httpUrlConnection = null;

		try {
			httpUrlConnection = (HttpURLConnection) new URL(URL).openConnection();
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
		TextView txtData = activity.findViewById(R.id.txtData);
		txtData.setText(String.valueOf(Utils.extractEarthquake(result)));
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