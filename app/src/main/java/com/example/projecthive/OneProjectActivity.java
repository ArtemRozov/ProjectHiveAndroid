package com.example.projecthive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.example.projecthive.Adapters.TasksAdapter;
import com.example.projecthive.Objects.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OneProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_project);

        ExpandableListView expandableListView = findViewById(R.id.expandable_list_view);

        // создаем заголовки для списков
        List<String> listGroup = new ArrayList<>();
        listGroup.add("Виконати");
        listGroup.add("В процесі");
        listGroup.add("Реалізовані");

        // создаем элементы для списков
        HashMap<String, List<Task>> listItem = new HashMap<>();

        List<Task> group1Tasks = new ArrayList<>();
        group1Tasks.add(new Task("Елемент 1", "20.12.2023"));
        group1Tasks.add(new Task("Елемент 2", "21.12.2023"));
        group1Tasks.add(new Task("Елемент 3", "22.12.2023"));

        List<Task> group2Tasks = new ArrayList<>();
        group2Tasks.add(new Task("Елемент 4", "23.12.2023"));
        group2Tasks.add(new Task("Елемент 5", "24.12.2023"));
        group2Tasks.add(new Task("Елемент 6", "25.12.2023"));

        List<Task> group3Tasks = new ArrayList<>();
        group3Tasks.add(new Task("Елемент 7", "26.12.2023"));
        group3Tasks.add(new Task("Елемент 8", "27.12.2023"));
        group3Tasks.add(new Task("Елемент 9", "28.12.2023"));

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
    }
}