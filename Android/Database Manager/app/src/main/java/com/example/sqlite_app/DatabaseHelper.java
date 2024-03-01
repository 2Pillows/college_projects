package com.example.sqlite_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COLUMN_NAME = "STUDENT_NAME";
    public static final String COLUMN_SURNAME = "STUDENT_SURNAME";
    public static final String COLUMN_MARK = "STUDENT_MARK";
    public static final String COLUMN_ID = "ID";
    private static String STUDENT_TABLE = "STUDENT_TABLE";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "studentDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create database using constants declared above
        String createTableStatement = "CREATE TABLE " + STUDENT_TABLE + " (" +
                COLUMN_ID + " INT," +
                COLUMN_NAME + " TEXT," +
                COLUMN_SURNAME + " TEXT," +
                COLUMN_MARK + " INT" +
                ")";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not used with project since database version won't upgrade
    }

    // Function to add a row to database
    public boolean add(String nameValue, String surnameValue, Integer markValue, Integer idValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        // Put data into ContentValue
        cv.put(COLUMN_ID, idValue);
        cv.put(COLUMN_NAME, nameValue);
        cv.put(COLUMN_SURNAME, surnameValue);
        cv.put(COLUMN_MARK, markValue);

        // Insert ContentValue to database
        long insert = db.insert(STUDENT_TABLE, null, cv);
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
        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        // Iterate through Cursor, adding each row to returnList as a String
        if (cursor.moveToFirst()) {
            do {
                int idValue = cursor.getInt(0);
                String nameValue = cursor.getString(1);
                String surnameValue = cursor.getString(2);
                int markValue = cursor.getInt(3);

                returnList.add(idValue + " , " + nameValue + ", " + surnameValue + ", " + markValue);
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
        long delete = db.delete(STUDENT_TABLE, COLUMN_ID + " = " + idValue, null);

        // Num of rows affected, if not -1, successful operation
        if (delete == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    // Function to update a database entry using ID value
    public boolean updateID(String nameValue, String surnameValue, Integer markValue, Integer idValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, idValue);
        cv.put(COLUMN_NAME, nameValue);
        cv.put(COLUMN_SURNAME, surnameValue);
        cv.put(COLUMN_MARK, markValue);

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
