package com.example.projecthive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
        projectList.add(new Project("Project1", "project under the number 1", "the first project", R.drawable.camera));
        projectList.add(new Project("Project2", "project under the number 2", "the second project", R.drawable.user_photo));
        projectList.add(new Project("Project3", "project under the number 3", "the third project", R.drawable.triangle));

        ProjectsAdapter mAdapter = new ProjectsAdapter(projectList, new OnProjectClickListener(this));

        mRecyclerView.setAdapter(mAdapter);


        // go to profile
        Button button = findViewById(R.id.auth_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(ProjectActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // go to profile by underbutton
        Button profileButton = findViewById(R.id.profile_btn);
        profileButton.setOnClickListener(view -> {
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