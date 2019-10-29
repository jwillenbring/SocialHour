package com.example.socialhour;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

public class GroupManager extends AppCompatActivity {

    private Button accept, refuse;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //instead of activity_main, it would be a group xml file
        /*accept = findViewById(R.id.btnName);
        refuse = findViewById(R.id.btnName);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveFromPendingToGroups(group);
                addUserToGroup(username);
            }
        });

        refuse.setOnClickListener(new View,OnClickListener() {
            @Override
            public void onClick(View w) {
                removeFromPending();
            }
        });
         */


    }

    public void moveFromPendingToGroups(Array groups){


    }

    public void addUserToGroup(String username){
        mDatabase.child("Groups").child("members").setValue(username);
    }

    public void removeFromPending(String groupToRemove){
        mDatabase.child("Users").child("pendingGroups").child(groupToRemove).removeValue();
    }

}
