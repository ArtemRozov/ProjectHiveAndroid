package com.example.projecthive.Objects;

public class Project {
    private String title;
    private String info1;
    private String info2;

    public Project(String title, String info1, String info2) {
        this.title = title;
        this.info1 = info1;
        this.info2 = info2;
    }

    public String getTitle(){
        return title;
    }

    public String getInfo1(){
        return info1;
    }

    public String getInfo2(){
        return info2;
    }
}
