package com.houarizegai.placefinder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.houarizegai.placefinder.model.Geoname;

import java.util.ArrayList;

public class GeonamesDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "geonames_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_EARTHQUAKE = "geonames";

    public GeonamesDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = new StringBuilder("CREATE TABLE ").append(TABLE_EARTHQUAKE)
                .append(" (")
                .append(" adminCode1 VARCHAR(30),")
                .append(" lng VARCHAR(30),")
                .append(" geonameId INT,")
                .append(" toponymName VARCHAR(30),")
                .append(" countryId VARCHAR(30),")
                .append(" fcl VARCHAR(30),")
                .append(" population VARCHAR(30),")
                .append(" countryCode VARCHAR(30),")
                .append(" name VARCHAR(30),")
                .append(" fclName VARCHAR(30),")
                .append(" countryName VARCHAR(30),")
                .append(" fcodeName VARCHAR(30),")
                .append(" adminName1 VARCHAR(30),")
                .append(" lat VARCHAR(30),")
                .append(" fcode VARCHAR(30)")
                .append(");")
                .toString();
        
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteQuery = "DROP TABLE " + TABLE_EARTHQUAKE+ " IF EXISTS;";
        db.execSQL(deleteQuery);

        onCreate(db);
    }

    public void addAll(ArrayList<Geoname> geonames) {
        SQLiteDatabase db = this.getWritableDatabase();

        String deleteTableContentQuery = "DELETE FROM " + TABLE_EARTHQUAKE;
        db.execSQL(deleteTableContentQuery);

        for(Geoname geoname : geonames) {
            ContentValues values = new ContentValues();
            values.put("adminCode1", geoname.getAdminCode1());
            values.put("lng", geoname.getLng());
            values.put("geonameId", geoname.getGeonameId());
            values.put("toponymName", geoname.getToponymName());
            values.put("countryId", geoname.getCountryId());
            values.put("fcl", geoname.getFcl());
            values.put("population", geoname.getPopulation());
            values.put("countryCode", geoname.getCountryCode());
            values.put("name", geoname.getName());
            values.put("fclName", geoname.getFclName());
            values.put("countryName", geoname.getCountryName());
            values.put("fcodeName", geoname.getFcodeName());
            values.put("adminName1", geoname.getAdminName1());
            values.put("lat", geoname.getLat());
            values.put("fcode", geoname.getFcode());

            db.insert(TABLE_EARTHQUAKE, null, values);
        }
    }

    public ArrayList<Geoname> getAll() {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_EARTHQUAKE;
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<Geoname> geonames = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                geonames.add(new Geoname(
                        cursor.getString(cursor.getColumnIndex("adminCode1")),
                        cursor.getString(cursor.getColumnIndex("lng")),
                        cursor.getInt(cursor.getColumnIndex("geonameId")),
                        cursor.getString(cursor.getColumnIndex("toponymName")),
                        cursor.getString(cursor.getColumnIndex("countryId")),
                        cursor.getString(cursor.getColumnIndex("fcl")),
                        cursor.getString(cursor.getColumnIndex("population")),
                        cursor.getString(cursor.getColumnIndex("countryCode")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("fclName")),
                        cursor.getString(cursor.getColumnIndex("countryName")),
                        cursor.getString(cursor.getColumnIndex("fcodeName")),
                        cursor.getString(cursor.getColumnIndex("adminName1")),
                        cursor.getString(cursor.getColumnIndex("lat")),
                        cursor.getString(cursor.getColumnIndex("fcode"))));

            } while(cursor.moveToNext());
        }

        return geonames;

    }
}
