package com.example.socialhour;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import com.example.services.importCalendar;
import android.widget.TextView;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String nextEvent;
        try {
            nextEvent = importCalendar.getNextEvent();
        }
        catch(IOException | GeneralSecurityException ex){
            ex.printStackTrace();
            nextEvent = "XXX";
        }
        TextView eventText= findViewById(R.id.textView5);
        eventText.setText(nextEvent);
        System.out.println(nextEvent);

    }
}
