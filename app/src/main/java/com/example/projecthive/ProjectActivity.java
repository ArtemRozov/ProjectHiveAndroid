package com.example.projecthive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.projecthive.Adapters.OnProjectClickListener;
import com.example.projecthive.Adapters.ProjectsAdapter;
import com.example.projecthive.Objects.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        RecyclerView mRecyclerView = findViewById(R.id.projects);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("Название проекта 1", "Описание проекта 1", "Описание проекта 5", ""));
        projectList.add(new Project("Название проекта 2", "Описание проекта 2", "Описание проекта 6", ""));
        projectList.add(new Project("Название проекта 3", "Описание проекта 3", "Описание проекта 7", ""));
        projectList.add(new Project("Название проекта 4", "Описание проекта 4", "Описание проекта 8", ""));

        ProjectsAdapter mAdapter = new ProjectsAdapter(projectList, new OnProjectClickListener(this));

        mRecyclerView.setAdapter(mAdapter);


        // go to profile
        Button button = findViewById(R.id.auth_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // go to calendar
        Button calendarButton = findViewById(R.id.calendar_button);
        calendarButton.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectActivity.this, CalendarActivity.class);
            startActivity(intent);
        });
    }

}