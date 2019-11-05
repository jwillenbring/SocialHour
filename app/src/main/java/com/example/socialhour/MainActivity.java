package com.example.socialhour;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.example.DataTypes.User;
import com.example.services.DBConnection;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity{

    Button groups, events;
    public static User currentUser;
    public static DataSnapshot userDataSnapshot;
    private FirebaseAuth mAuth;
    private DBConnection dbc;
    Button logOutButton;
    Button groupsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbc = new DBConnection();
        mAuth = FirebaseAuth.getInstance();
        //User newUser = dbc.getUser(LogOn.username);
        dbc.getUser(LogOn.username);
        String welcome = User.getUserKey(LogOn.username);
        TextView welcomeText = (TextView) findViewById(R.id.textView);
        welcomeText.setText("Welcome, " + welcome);

        groups = (Button) findViewById(R.id.groups);
        events = (Button) findViewById(R.id.events);

        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GroupsPage.class));
            }
        });

        logOutButton = (Button) findViewById(R.id.logOutButton);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),LogOn.class));
            }
        });

    }

    public static void setCurrentUser (User u){
        currentUser = u;
    }

    public static User getCurrentUser(){
        return currentUser;
    }

    public static void setUserDataSnapshot (DataSnapshot d){
        userDataSnapshot = d;
    }

    public static DataSnapshot getUserDataSnapshot(){
        return userDataSnapshot;
    }
}
