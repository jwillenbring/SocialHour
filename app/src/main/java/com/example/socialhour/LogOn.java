package com.example.socialhour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TextView;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogOn extends AppCompatActivity {

    private String username, password;
    private EditText usernameInput;
    private EditText passwordInput;

    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;

    Button logOnButton;
    Button signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_on);

        mAuth = FirebaseAuth.getInstance();

        usernameInput = (EditText) findViewById(R.id.username);
        passwordInput = (EditText) findViewById(R.id.password);

        logOnButton = (Button) findViewById(R.id.logOnbutton);
        signOutButton = (Button) findViewById(R.id.signOut);

        logOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameInput.getText().toString().trim();
                password = passwordInput.getText().toString().trim();

                int failCount = 0;

                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener(LogOn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                } else {
                                    TextView errMsg = (TextView) findViewById(R.id.errorMessage);
                                    errMsg.setText("Did not work buddy!");
                                }
                            }
                        });
            }
        });

    }
}