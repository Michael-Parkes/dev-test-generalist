package com.example.mike.johnlewisjobapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //This panel is purely for navigation i have created buttons for all of the panels making sure the user can access all of my panels. This is also the first page that loads.
        final Button bBikes = (Button) findViewById(R.id.bBikes);
        final Button bSingle = (Button) findViewById(R.id.bSingle);
        final Button bAdd = (Button) findViewById(R.id.bAdd);
        final Button bDelete = (Button) findViewById(R.id.bDelete);

        bBikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bikeDataIntent = new Intent(MainActivity.this, AllBikesActivity.class);
                MainActivity.this.startActivity(bikeDataIntent);
            }

            });

        bSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singleBikeIntent = new Intent(MainActivity.this, SingleBikeActivity.class);
                MainActivity.this.startActivity(singleBikeIntent);
            }
        });

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addBikeIntent = new Intent(MainActivity.this, AddBikeActivity.class);
                MainActivity.this.startActivity(addBikeIntent);
            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteTabIntent = new Intent(MainActivity.this, DeleteBikeActivity.class);
                MainActivity.this.startActivity(deleteTabIntent);
            }
        });
        }
    }
