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
}
