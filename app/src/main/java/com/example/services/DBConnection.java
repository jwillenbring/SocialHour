package com.example.services;

import android.util.Log;

import com.example.DataTypes.User;
import com.example.socialhour.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class DBConnection {

    private DatabaseReference db;
    public User currentUser;
    private DataSnapshot userDataSnapshot;

    public DBConnection(){
        this.db = FirebaseDatabase.getInstance().getReference();
    }

    public void addUserToDB(User newUser){
        int indexOfAt = newUser.getEmail().indexOf("@");
        final String uniqueId = newUser.getEmail().substring(0, indexOfAt).replace('.', '-');
        db.child("Users").child(uniqueId).setValue(newUser);
    }

    public void getUser(String email){
        final String userKey = User.getUserKey(email);
        ValueEventListener readDB = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                setUserDataSnapshot(dataSnapshot);
                DataSnapshot userSnap = dataSnapshot.child(userKey);
                currentUser = new User(userSnap.child("firstName").getValue().toString(), userSnap.child("email").getValue().toString(), userSnap.child("password").getValue().toString());
                System.out.println("name : " + currentUser.getFirstName());
                System.out.println("email : " + currentUser.getEmail());
                System.out.println("password : " + currentUser.getPassword());
                setCurrentUser(currentUser);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        db.child("Users/").addValueEventListener(readDB);
    }

    public void setCurrentUser (User u){
        currentUser = u;
        printData();
    }

    public void printData(){
        System.out.println("name : " + currentUser.getFirstName());
        System.out.println("email : " + currentUser.getEmail());
        System.out.println("password : " + currentUser.getPassword());
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void setUserDataSnapshot (DataSnapshot d){
        userDataSnapshot = d;
    }

    public DataSnapshot getUserDataSnapshot(){
        return userDataSnapshot;
    }
}
