package com.example.projecthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.example.projecthive.Objects.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OneProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_project);

        String projectId = getIntent().getStringExtra("title");

        ExpandableListView expandableListView = findViewById(R.id.expandable_list_view);

        // create titles
        List<String> listGroup = new ArrayList<>();
        listGroup.add("Виконати");
        listGroup.add("В процесі");
        listGroup.add("Реалізовані");

        // create elements
        HashMap<String, List<Task>> listItem = new HashMap<>();

        List<Task> group1Tasks = new ArrayList<>();
        List<Task> group2Tasks = new ArrayList<>();
        List<Task> group3Tasks = new ArrayList<>();

        if(projectId.equals("Project1")){
            group1Tasks.add(new Task("Task1", "06.06.2023"));
            group1Tasks.add(new Task("Task2", "21.12.2023"));
            group1Tasks.add(new Task("Task3", "22.12.2023"));

            group2Tasks.add(new Task("Task4", "23.12.2023"));
            group2Tasks.add(new Task("Task5", "24.12.2023"));
            group2Tasks.add(new Task("Task6", "25.12.2023"));

            group3Tasks.add(new Task("Task7", "--"));
            group3Tasks.add(new Task("Task8", "--"));
            group3Tasks.add(new Task("Task9", "--"));
        } else if(projectId.equals("Project2")){
            group1Tasks.add(new Task("First task", "17.06.2023"));
            group1Tasks.add(new Task("Second task", "21.12.2023"));
            group1Tasks.add(new Task("Third task", "22.12.2023"));

            group2Tasks.add(new Task("Fourth task", "23.12.2023"));
            group2Tasks.add(new Task("Fifth task", "24.12.2023"));
            group2Tasks.add(new Task("Sixth task", "25.12.2023"));

            group3Tasks.add(new Task("Seventh task", "--"));
            group3Tasks.add(new Task("Eighth task", "--"));
            group3Tasks.add(new Task("Ninth task", "--"));
        } else{
            group1Tasks.add(new Task("Елемент 1", "20.12.2023"));
            group1Tasks.add(new Task("Елемент 2", "21.12.2023"));
            group1Tasks.add(new Task("Елемент 3", "22.12.2023"));

            group2Tasks.add(new Task("Елемент 4", "23.12.2023"));
            group2Tasks.add(new Task("Елемент 5", "24.12.2023"));
            group2Tasks.add(new Task("Елемент 6", "25.12.2023"));

            group3Tasks.add(new Task("Елемент 7", "--"));
            group3Tasks.add(new Task("Елемент 8", "--"));
            group3Tasks.add(new Task("Елемент 9", "--"));
        }

        listItem.put(listGroup.get(0), group1Tasks);
        listItem.put(listGroup.get(1), group2Tasks);
        listItem.put(listGroup.get(2), group3Tasks);

        TasksAdapter adapter = new TasksAdapter(OneProjectActivity.this, listGroup, listItem);
        expandableListView.setAdapter(adapter);

        // go to profile
        Button button = findViewById(R.id.auth_button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(OneProjectActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // go to all projects
        Button projectButton = findViewById(R.id.create_project);
        projectButton.setOnClickListener(view -> {
            Intent intent = new Intent(OneProjectActivity.this, ProjectActivity.class);
            startActivity(intent);
        });

        // go to calendar
        Button calendarButton = findViewById(R.id.calendar_button);
        calendarButton.setOnClickListener(view -> {
            Intent intent = new Intent(OneProjectActivity.this, CalendarActivity.class);
            startActivity(intent);
        });
    }

}