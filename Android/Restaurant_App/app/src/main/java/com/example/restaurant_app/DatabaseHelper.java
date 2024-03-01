package com.example.restaurant_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_LOCATION = "LOCATION";
    public static final String COLUMN_TYPE = "FOOD_TYPE";
    public static final String COLUMN_MENU = "MENU";
    public static final String COLUMN_ID = "ID";
    private static String RESTAURANT_TABLE = "RESTAURANT LISTING";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "studentDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create database using constants declared above
        String createTableStatement = "CREATE TABLE " + RESTAURANT_TABLE + " (" +
                COLUMN_ID + " INT," +
                COLUMN_NAME + " TEXT," +
                COLUMN_LOCATION + " TEXT," +
                COLUMN_TYPE + " TEXT," +
                COLUMN_MENU + " TEXT" +
                ")";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not used with project since database version won't upgrade
    }

    // Include functions to edit database
    // Add, remove, update, edit, etc.

    // Function to add a row to database
    public boolean add(String nameValue, String locationValue, String typeValue, String menuValue, Integer idValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, idValue);
        cv.put(COLUMN_NAME, nameValue);
        cv.put(COLUMN_LOCATION, locationValue);
        cv.put(COLUMN_TYPE, typeValue);
        cv.put(COLUMN_MENU, menuValue);

        // Insert ContentValue to database
        long insert = db.insert(RESTAURANT_TABLE, null, cv);
        // Number of rows affected, if not -1 then operation was successful
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // Function to get data from table and return as a List<String>
    public List<String> getTable() {
        // Return array of rows
        List<String> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Create cursor for entire table
        Cursor cursor = db.rawQuery("SELECT * FROM " + RESTAURANT_TABLE, null);

        // Iterate through Cursor, adding each row to returnList as a String
        if (cursor.moveToFirst()) {
            do {
                int idValue = cursor.getInt(0);

                String nameValue = cursor.getString(1);
                String locationValue = cursor.getString(2);
                String typeValue = cursor.getString(3);
                String menuValue = cursor.getString(4);

                returnList.add(idValue + " , " + nameValue + ", " + locationValue + ", " + typeValue + ", " + menuValue);
            } while (cursor.moveToNext());
        }
        else {
            // Unable to find first row in cursor
        }

        cursor.close();
        db.close();
        return returnList;
    }

    // Function to delete a database entry using ID value
    public boolean deleteID(Integer idValue) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete rows with matching ID number
        long delete = db.delete(RESTAURANT_TABLE, COLUMN_ID + " = " + idValue, null);

        // Num of rows affected, if not -1, successful operation
        if (delete == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    // Function to update a database entry using ID value
    public boolean updateID(String nameValue, String locationValue, String typeValue, String menuValue, Integer idValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, idValue);
        cv.put(COLUMN_NAME, nameValue);
        cv.put(COLUMN_LOCATION, locationValue);
        cv.put(COLUMN_TYPE, typeValue);
        cv.put(COLUMN_MENU, menuValue);

        // Update rows with matching ID number
        long update = db.update(STUDENT_TABLE, cv, COLUMN_ID + " = " + idValue, null);

        // Num of rows affected, if not -1, successful operation
        if (update == -1) {
            return false;
        }
        else {
            return true;
        }
    }

}
