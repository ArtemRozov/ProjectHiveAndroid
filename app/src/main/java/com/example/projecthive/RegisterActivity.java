package com.example.projecthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // go to the sign in activity
        Button button = findViewById(R.id.sign_in_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
            startActivity(intent);
        });

        // go to the Main activity from the back button
        button = findViewById(R.id.back_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}