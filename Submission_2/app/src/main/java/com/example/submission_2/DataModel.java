package com.example.submission_2;

public class DataModel {

    String name;
    String Description;
    int id_;
    int image;

    public DataModel(String name, String Description, int id_, int image) {
        this.name = name;
        this.Description = Description;
        this.id_ = id_;
        this.image=image;
    }


    public String getName() {
        return name;
    }


    public String getDesc() {
        return Description;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }

}