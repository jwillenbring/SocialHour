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
    User currentUser;

    public DBConnection(){
        this.db = FirebaseDatabase.getInstance().getReference();
    }

    public void addUserToDB(User newUser){
        int indexOfAt = newUser.getEmail().indexOf("@");
        final String uniqueId = newUser.getEmail().substring(0, indexOfAt).replace('.', '-');
        db.child("Users").child(uniqueId).setValue(newUser);
    }

    public void getUser(String email){
        String userKey = User.getUserKey(email);
        currentUser = new User("RANDOM", "Test@gmail.com", "12345678");
        ValueEventListener readDB = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                currentUser = new User(dataSnapshot.child("firstName").getValue().toString(), dataSnapshot.child("email").getValue().toString(), dataSnapshot.child("password").getValue().toString());
                System.out.println("name : " + currentUser.getFirstName());
                System.out.println("email : " + currentUser.getEmail());
                System.out.println("password : " + currentUser.getPassword());
                MainActivity.setCurrentUser(currentUser);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        db.child("Users/" + userKey).addListenerForSingleValueEvent(readDB);
        db.child("Users/" + userKey + "/active").setValue(true);
        /*if(currentUser != null){
            System.out.print("name : " + currentUser.getFirstName());
        }
        else{
            System.out.println("Fuck firebase");
        }*/
    }


}
