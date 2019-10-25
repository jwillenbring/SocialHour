package com.example.socialhour;


import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = LogOn.username;
        name = name.replace("@gmail.com", "");
        //String name = CreateAccount.name;
        TextView welcomeText = (TextView) findViewById(R.id.textView);
        welcomeText.setText("Welcome, " + name);
    }
}
