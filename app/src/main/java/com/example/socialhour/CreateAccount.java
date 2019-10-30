package com.example.socialhour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import android.os.Bundle;
import android.widget.Toast;

import com.example.DataTypes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;


public class CreateAccount extends AppCompatActivity {
    String name, email, password;

    EditText nameCreate, emailCreate, passwordCreate;
    Button submitCreate;

    private FirebaseAuth mAuth;
    private DatabaseReference db;
    private User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        nameCreate = findViewById(R.id.nameBox);
        emailCreate = findViewById(R.id.emailBox);
        passwordCreate = findViewById(R.id.passwordBox);

        submitCreate = findViewById(R.id.submitButton);

        mAuth = FirebaseAuth.getInstance();

        submitCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameCreate.getText().toString().trim();
                email = emailCreate.getText().toString().trim();
                password = passwordCreate.getText().toString().trim();
                int indexOfAt = email.indexOf("@");
                final String uniqueId = email.substring(0, indexOfAt).replace('.', '-');
                newUser = new User(name, email, password);
                db = FirebaseDatabase.getInstance().getReference();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    /*db.child("Users").child(mAuth.getCurrentUser().getUid()).child("name").setValue(name);
                                    db.child("Users").child(mAuth.getCurrentUser().getUid()).child("email").setValue(email);
                                    db.child("Users").child(mAuth.getCurrentUser().getUid()).child("password").setValue(password);*/
                                    db.child("Users").child(uniqueId).child("name").setValue(name);
                                    db.child("Users").child(uniqueId).child("email").setValue(email);
                                    db.child("Users").child(uniqueId).child("password").setValue(password);
                                    startActivity(new Intent(getApplicationContext(), LogOn.class));

                                } else {
                                    Toast.makeText(CreateAccount.this, "Account already exists with that email address", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}