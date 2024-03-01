package com.example.restaurant_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Create Database for App
    // Contains Restaurant Details
    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

    // Objects in XML file
    EditText locationEditText;
    EditText typeEditText;
    Button buttonRestaurant1;
    Button buttonRestaurant2;
    Button buttonRestaurant3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create listeners for EditTexts when "Enter" is pressed
        // Would interact with the database
        locationEditText = (EditText) findViewById(R.id.locationEditText);
        locationEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Toast.makeText(MainActivity.this, "Filter Database using Location", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        typeEditText = (EditText) findViewById(R.id.typeEditText);
        typeEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Toast.makeText(MainActivity.this, "Filter Database using Type of Food", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        // Create listeners for EditTexts when "Enter" is pressed
        // Would interact with the database
        buttonRestaurant1 = (Button) findViewById(R.id.restaurant1Button);
        buttonRestaurant1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Go to Restaurant Website", Toast.LENGTH_SHORT).show();
            }
        });

        // Handlers for buttons, would direct to restaurant's website
        buttonRestaurant2 = (Button) findViewById(R.id.restaurant2Button);
        buttonRestaurant2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Go to Restaurant Website", Toast.LENGTH_SHORT).show();
            }
        });

        // Handlers for buttons, would direct to restaurant's website
        buttonRestaurant3 = (Button) findViewById(R.id.restaurant3Button);
        buttonRestaurant3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Go to Restaurant Website", Toast.LENGTH_SHORT).show();
            }
        });
    }
}