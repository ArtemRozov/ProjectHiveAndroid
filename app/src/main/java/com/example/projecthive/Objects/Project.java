package com.example.projecthive.Objects;

public class Project {
    private final String title;
    private final String info1;
    private final String info2;
    private final String imagePath;

    public Project(String title, String info1, String info2, String imagePath) {
        this.title = title;
        this.info1 = info1;
        this.info2 = info2;
        this.imagePath = imagePath;
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
    public String getImagePath(){
        return imagePath;
    }
}
