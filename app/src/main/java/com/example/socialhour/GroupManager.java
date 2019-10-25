package com.example.socialhour;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GroupManager extends AppCompatActivity {

    Button accept, refuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //instead of activity_main, it would be a group xml file
        //accept = findViewById(R.id.btnName);
        //refuse = findViewById(R.id.btnName);


    }
}
