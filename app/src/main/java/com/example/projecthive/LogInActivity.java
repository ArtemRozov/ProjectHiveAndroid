package com.example.projecthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
            String email = emailEditText.getText().toString();
            EditText pswEditText = findViewById(R.id.editTextTextPassword);
            String psw = pswEditText.getText().toString();

            if(email.equals("admin@gmail.com") && psw.equals("12345")){
                Intent intent = new Intent(LogInActivity.this, ProjectActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

}