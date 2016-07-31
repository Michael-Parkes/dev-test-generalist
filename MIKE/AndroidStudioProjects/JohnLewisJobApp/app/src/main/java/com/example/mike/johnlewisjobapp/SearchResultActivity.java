package com.example.mike.johnlewisjobapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {
    //I made this class for the search results when a user is looking for one bike in particular.
    //The layout includes a welcome message and all of the bike details.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        //This GETs all of the information from the database.
        Intent intent = getIntent();
        String bikeid = intent.getStringExtra("bikeid");
        String bikename = intent.getStringExtra("bikename");
        String description = intent.getStringExtra("description");
        int price = intent.getIntExtra("price", -1);

        TextView tvWelcomeMessage = (TextView)findViewById(R.id.tvWelcomeMessage);
        EditText etBikeID = (EditText) findViewById(R.id.etBikeID);
        EditText etBikeName = (EditText) findViewById(R.id.etBikeName);
        EditText etDescription = (EditText)findViewById(R.id.etDescription);
        EditText etPrice = (EditText) findViewById(R.id.etPrice);

        //Display Bike Details
        String message = "Thank you for using or Bike Search Tool!";
        tvWelcomeMessage.setText(message);
        etBikeID.setText(bikeid);
        etBikeName.setText(bikename);
        etDescription.setText(description);
        etPrice.setText(price + "");

    }
}
