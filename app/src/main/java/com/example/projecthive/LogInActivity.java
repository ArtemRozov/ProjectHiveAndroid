package com.example.projecthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // go to the register activity
        Button button = findViewById(R.id.register_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // go to the main activity from the back button
        button = findViewById(R.id.back_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // go to the projects after log in
        button = findViewById(R.id.sign_up);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(LogInActivity.this, ProjectActivity.class);
            startActivity(intent);
        });
    }
}