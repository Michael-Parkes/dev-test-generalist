package com.example.mike.johnlewisjobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mike on 29/07/2016.
 */
public class SingleBikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlebike);

        final EditText etBikeID = (EditText) findViewById(R.id.etBikeID);
        final EditText etBikeName = (EditText) findViewById(R.id.etBikeName);

        final Button bStart = (Button) findViewById(R.id.bStart);
        final Button bSearch = (Button) findViewById(R.id.bSearch);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToStartIntent = new Intent(SingleBikeActivity.this, MainActivity.class);
                SingleBikeActivity.this.startActivity(backToStartIntent);
            }
        });

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String bikeid = etBikeID.getText().toString();
                final String bikename = etBikeName.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {//If the user puts a correct bikeid and bikename into the search bar the application will send the information to the SearchResult class to be displayed for theuser.
                                String bikeid = jsonResponse.getString("bikeid");
                                String bikename = jsonResponse.getString("bikename");
                                String description = jsonResponse.getString("description");
                                int price = jsonResponse.getInt("price");

                                Intent intent = new Intent(SingleBikeActivity.this, SearchResultActivity.class);
                                intent.putExtra("bikeid", bikeid);
                                intent.putExtra("bikename", bikename);
                                intent.putExtra("description", description);
                                intent.putExtra("price", price);//This is the process of sending all the information of the bike into the class where it will be displayed.
                            } else {
                                AlertDialog.Builder errorMessage = new AlertDialog.Builder(SingleBikeActivity.this);//If the user enters a wrong bikeid or bikename which doesn't match an error message will appear and give the user another try.
                                errorMessage.setMessage("Bike not found")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                SingleBikeRequest singlebikerequest = new SingleBikeRequest(bikeid, bikename, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SingleBikeActivity.this);
                queue.add(singlebikerequest);//This will add the users request to a queue.
            }
        });
    }
}