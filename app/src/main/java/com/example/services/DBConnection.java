package com.example.services;

import com.example.DataTypes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBConnection {

    private DatabaseReference db;

    public DBConnection(){
        this.db = FirebaseDatabase.getInstance().getReference();
    }

    public void addUserToDB(User newUser){
        int indexOfAt = newUser.getEmail().indexOf("@");
        final String uniqueId = newUser.getEmail().substring(0, indexOfAt).replace('.', '-');
        db.child("Users").child(uniqueId).setValue(newUser);
    }

    /*public User getUser(String email){
        String userKey = User.getUserKey(email);
        return new User(db.child("Users").child(userKey).child("firstName"), email, db.child("Users").child(userKey).child("password").toString());
    }*/
}
