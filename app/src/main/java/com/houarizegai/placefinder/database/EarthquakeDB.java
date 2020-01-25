package com.houarizegai.placefinder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.houarizegai.placefinder.model.Earthquake;

import java.util.ArrayList;

public class EarthquakeDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "earthquake_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_EARTHQUAKE = "earthquake";

    public EarthquakeDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE " + TABLE_EARTHQUAKE+ " (datetime VARCHAR(30) PRIMARY KEY, depth DOUBLE, lng DOUBLE, src VARCHAR(30), eqid VARCHAR(30), magnitude DOUBLE, lat DOUBLE);";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteQuery = "DROP TABLE " + TABLE_EARTHQUAKE+ " IF EXISTS;";
        db.execSQL(deleteQuery);

        onCreate(db);
    }

    public void addAll(ArrayList<Earthquake> earthquakes) {
        SQLiteDatabase db = this.getWritableDatabase();

        String deleteTableContentQuery = "DELETE FROM " + TABLE_EARTHQUAKE;
        db.execSQL(deleteTableContentQuery);

        for(Earthquake earthquake : earthquakes) {
            ContentValues values = new ContentValues();
            values.put("datetime", earthquake.getDatetime());
            values.put("depth", earthquake.getDepth());
            values.put("lng", earthquake.getLng());
            values.put("src", earthquake.getSrc());
            values.put("eqid", earthquake.getEqid());
            values.put("magnitude", earthquake.getMagnitude());
            values.put("lat", earthquake.getLat());

            db.insert(TABLE_EARTHQUAKE, null, values);
        }
    }

    public ArrayList<Earthquake> getAll() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_EARTHQUAKE;
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                earthquakes.add(new Earthquake(
                        cursor.getString(cursor.getColumnIndex("datetime")),
                        cursor.getDouble(cursor.getColumnIndex("depth")),
                        cursor.getDouble(cursor.getColumnIndex("lng")),
                        cursor.getString(cursor.getColumnIndex("src")),
                        cursor.getString(cursor.getColumnIndex("eqid")),
                        cursor.getDouble(cursor.getColumnIndex("magnitude")),
                        cursor.getDouble(cursor.getColumnIndex("lat"))));

            } while(cursor.moveToNext());
        }


        return earthquakes;

    }
}