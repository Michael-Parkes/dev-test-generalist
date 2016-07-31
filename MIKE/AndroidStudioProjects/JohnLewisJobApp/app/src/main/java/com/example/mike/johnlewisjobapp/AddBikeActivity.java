package com.example.mike.johnlewisjobapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
/**
 * Created by Mike on 29/07/2016.
 */
public class AddBikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbike);

        final EditText etBikeName = (EditText) findViewById(R.id.etBikeName);
        final EditText etBikeID = (EditText) findViewById(R.id.etBikeID);
        final EditText etDescription = (EditText) findViewById(R.id.etDescription);
        final EditText etPrice = (EditText) findViewById(R.id.etPrice);
        final Button bStart = (Button) findViewById(R.id.bStart);
        final Button bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String bikename = etBikeName.getText().toString();
                final String bikeid = etBikeID.getText().toString();
                final String description = etDescription.getText().toString();
                final int price = Integer.parseInt(etPrice.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){//If the user enters a bike successfully to the database they will be taken back to the main menu.
                                //I would look for feedback on this as if you are adding more than one bike it would be annoying for the user to get thrown off the panel every time.
                           Intent intent = new Intent(AddBikeActivity.this, MainActivity.class);
                                AddBikeActivity.this.startActivity(intent);
                            }else{//If the user enters incorrect information they will be displayed with this error message. However, if a user leaves the fields blank and enters them,
                                //the database will record a blank entry, as development i would like to have made entering nothing throw an alert box at the user.
                                AlertDialog.Builder errorMessage = new AlertDialog.Builder(AddBikeActivity.this);
                                errorMessage.setMessage("Bike not added")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                BikeRequest bikeRequest = new BikeRequest(bikename, bikeid, description, price, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddBikeActivity.this);
                queue.add(bikeRequest);//Just like the search request the bike request needs to be added to a queue.
            }
        });

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToStartIntent = new Intent(AddBikeActivity.this, MainActivity.class);
                AddBikeActivity.this.startActivity(backToStartIntent);
            }

        });
    }
}
