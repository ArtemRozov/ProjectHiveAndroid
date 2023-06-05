package com.example.projecthive.Objects;

public class Project {
    private final String title;
    private final String info1;
    private final String info2;
    private int photoResId;

    public Project(String title, String info1, String info2, int photoResId) {
        this.title = title;
        this.info1 = info1;
        this.info2 = info2;
        this.photoResId = photoResId;
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

    public int getPhotoResId(){
        return photoResId;
    }

    public void setPhotoResId(int photoResId){
        this.photoResId = photoResId;
    }

}
