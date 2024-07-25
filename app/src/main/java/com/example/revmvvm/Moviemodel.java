package com.example.revmvvm;

public class Moviemodel {
    String name;
    String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Moviemodel(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
