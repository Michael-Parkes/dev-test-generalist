package com.example.mike.johnlewisjobapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mike on 29/07/2016.
 */
public class DeleteBikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletebike);

        final TextView deleteText = (TextView) findViewById(R.id.tvDeleteText);
        //I included a panel for this function if  had time at the end i was going to look at adding this function into the application however, i ran out of time.
        deleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteTextIntent = new Intent(DeleteBikeActivity.this, MainActivity.class);
                DeleteBikeActivity.this.startActivity(deleteTextIntent);
            }

        });
    }
}
