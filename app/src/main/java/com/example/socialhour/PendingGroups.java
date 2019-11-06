package com.example.socialhour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.*;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PendingGroups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_groups);

        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        //User currentUser = dbConnection.getUser();
        //ArrayList<String> pendingGroups = currentUser.getPending();

        ArrayList<String> pendingGroups = new ArrayList<String>(Arrays.asList("PendGroup1", "PendGroup2", "PendGroup3", "PendGroup4", "PendGroup5"
                , "PendGroup2", "PendGroup3", "PendGroup4", "PendGroup5", "PendGroup2", "PendGroup3", "PendGroup4", "PendGroup5"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < pendingGroups.size(); i++){
            Button button = new Button(this);
            button.setText(pendingGroups.get(i));
            button.setLayoutParams(params);
            button.setId(i);
            //set android:background="@android:drawable/screen_background_light_transparent"
            button.setBackground(Drawable.createFromPath("@android:drawable/screen_background_light_transparent"));
            button.setTextSize(30);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),AcceptInvite.class));
                }
            });

            linearLayout.addView(button);

        }
    }
}
