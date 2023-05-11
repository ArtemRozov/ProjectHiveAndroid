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

import com.example.projecthive.Adapters.ProjectsAdapter;
import com.example.projecthive.Objects.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ProjectsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        mRecyclerView = (RecyclerView) findViewById(R.id.projects);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("Название проекта 1", "Описание проекта 1", "Описание проекта 5"));
        projectList.add(new Project("Название проекта 2", "Описание проекта 2", "Описание проекта 6"));
        projectList.add(new Project("Название проекта 3", "Описание проекта 3", "Описание проекта 7"));
        projectList.add(new Project("Название проекта 4", "Описание проекта 4", "Описание проекта 8"));

        // Создаем адаптер и передаем список проектов в конструктор
        mAdapter = new ProjectsAdapter(projectList);

        // Устанавливаем адаптер на RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }

}