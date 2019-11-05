package com.example.socialhour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.services.DBConnection;
import com.google.firebase.database.DataSnapshot;

public class GroupsPage extends AppCompatActivity {

    Button createGroup, viewPending, group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DBConnection dbc = LogOn.dbc;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_page);

        createGroup = (Button) findViewById(R.id.createGroup);
        viewPending = (Button) findViewById(R.id.pendingGroups);
        group = (Button) findViewById(R.id.groupName);
        //System.out.println("NAME: " + dbc.getCurrentUser().getFirstName());
        DataSnapshot users = dbc.getUserDataSnapshot();
        for(DataSnapshot snapshot : users.getChildren()){
            System.out.println(snapshot.child("email").getValue(String.class));
        }

        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CreateGroup.class));
            }
        });

        viewPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PendingGroups.class));
            }
        });
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SingleGroupPage.class));
            }
        });
    }


}
