package com.example.projecthive.Objects;

public class Task {

    private final String title;
    private final String deadline;

    public Task(String title, String deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    public String getTitle(){
        return title;
    }

    public String getDeadline(){
        return deadline;
    }

}
