package com.example.socialhour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import android.os.Bundle;

public class LogOn extends AppCompatActivity {

    String username, password;

    EditText usernameInput;
    EditText passwordInput;

    Button logOnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_on);

        usernameInput = (EditText) findViewById(R.id.username);
        passwordInput = (EditText) findViewById(R.id.password);

        logOnButton = (Button) findViewById(R.id.logOnbutton);
        logOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                boolean loggedOn = validateCredientials(username, password);
                if(loggedOn){
                    openHomeScreen();
                }else{
                    ///display some error that incorrect information was given
                }
            }
        });
    }

    public boolean validateCredientials(String u, String p){
        /////validate the username exists and the password is correct
        return true;
    }

    public void openHomeScreen(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


