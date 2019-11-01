package com.example.socialhour;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

public class GroupManager extends AppCompatActivity {

    private Button accept, refuse;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //instead of activity_main, it would be a group xml file
        /*accept = findViewById(R.id.btnName);
        refuse = findViewById(R.id.btnName);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveFromPendingToGroups(group);
                addUserToGroup(username);
            }
        });

        refuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                removeFromPending(groupToRemove);
            }
        });
         */


    }

    public void moveFromPendingToGroups(String group){
        databaseReference.child("Users").child("groups").child("name").setValue(group);
        databaseReference.child("Users").child("pendingGroups").child(group).removeValue();

    }

    public void addUserToGroup(String username){
        databaseReference.child("Groups").child("members").setValue(username);
        Toast.makeText(this, "User successfully added to Group", Toast.LENGTH_LONG)
                .show();
    }

    public void removeFromPending(String groupToRemove){
        databaseReference.child("Users").child("pendingGroups").child(groupToRemove).removeValue();
        Toast.makeText(this, "Group removed from the list of pending groups",
                Toast.LENGTH_LONG).show();
    }

}
