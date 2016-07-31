package com.example.mike.johnlewisjobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mike on 29/07/2016.
 */
public class AllBikesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allbikes);

        final Button bStart = (Button) findViewById(R.id.bStart);

        //I didn't have time to finish this panel within the application i would of liked to have been able to display all the bikes in a table which would of included any
        //additions the user had entered.

        //Currently this page will link to a blank page with a button to go back to the main menu.

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToStartIntent = new Intent(AllBikesActivity.this, MainActivity.class);
                AllBikesActivity.this.startActivity(backToStartIntent);
            }
        });
    }
}
