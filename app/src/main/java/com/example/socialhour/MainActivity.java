package com.example.socialhour;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity{

    Button groups, events;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = LogOn.username;
        name = name.replace("@gmail.com", "");
        TextView welcomeText = (TextView) findViewById(R.id.textView);
        welcomeText.setText("Welcome, " + name);

        groups = (Button) findViewById(R.id.groups);
        events = (Button) findViewById(R.id.events);

        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GroupsPage.class));
            }
        });
    }
}
