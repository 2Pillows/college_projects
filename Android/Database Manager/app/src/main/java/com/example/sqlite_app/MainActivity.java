package com.example.sqlite_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Variables for EditTexts and variables
    EditText nameEditText;
    EditText surnameEditText;
    EditText markEditText;
    EditText idEditText;
    String nameValue;
    String surnameValue;
    Integer markValue;
    Integer idValue;

    // Object for DatabaseHelepr
    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign objects to values
        ListView tableListView = (ListView) findViewById(R.id.tableListView);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        markEditText = (EditText) findViewById(R.id.marksEditText);
        idEditText = (EditText) findViewById(R.id.idEditText);

        // Create button and add listener

        // Add Data takes data from EditText and adds to database
        Button addDataButton = (Button) findViewById(R.id.adDataButton);
        addDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getEditText();

                // Call add function and display result of button using Toast
                boolean success = databaseHelper.add(nameValue, surnameValue, markValue, idValue);
                if (success) {
                    Toast.makeText(MainActivity.this, "Successfully added to STUDENT_TABLE", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed to add to STUDENT_TABLE", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Takes data from database and displays using ListView
        Button viewAllButton = (Button) findViewById(R.id.viewAllButton);
        viewAllButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<String> tableData = databaseHelper.getTable();

                Collections.sort(tableData); // Sorts List by ID

                // Take list of data and add to list
                ArrayAdapter studentArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, tableData);
                tableListView.setAdapter(studentArrayAdapter);
            }
        });

        // Updates student ID using data in EditText
        Button updateButton = (Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getEditText();

                // Call update function and display result of button using Toast
                boolean success = databaseHelper.updateID(nameValue, surnameValue, markValue, idValue);
                if (success) {
                    Toast.makeText(MainActivity.this, "Successfully updated ID = " + idValue, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed to updated ID = " + idValue, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Deletes database entry using student ID
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getEditText();

                // Call delete function and display result of button using Toast
                boolean success = databaseHelper.deleteID(idValue);
                if (success) {
                    Toast.makeText(MainActivity.this, "Successfully deleted ID = " + idValue, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Failed to delete ID = " + idValue, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // Helper method to get data from EditText fields
    private void getEditText() {
        nameValue = nameEditText.getText().toString();

        surnameValue = surnameEditText.getText().toString();

        String tmpValue = markEditText.getText().toString(); // Store data from EditText and parse after
        markValue = Integer.parseInt( tmpValue );

        tmpValue = idEditText.getText().toString();
        idValue = Integer.parseInt( tmpValue );
    }


}