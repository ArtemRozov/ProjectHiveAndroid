package com.example.projecthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // go to the projects activity
        Button button = findViewById(R.id.create_project);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, ProjectActivity.class);
            startActivity(intent);
        });

        // go to the calendar
        Button calendarButton = findViewById(R.id.calendar_button);
        calendarButton.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, ProjectActivity.class);
            startActivity(intent);
        });
    }

    public void myButtonClickHandler(View view) {
        Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show();
    }

}