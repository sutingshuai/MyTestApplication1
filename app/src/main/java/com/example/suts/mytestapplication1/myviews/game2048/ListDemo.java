package com.example.suts.mytestapplication1.myviews.game2048;

/**
 * Created by 15423 on 2017/10/14.
 */

public class ListDemo {
    private int picture;
    private String name;
    private String text;

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ListDemo(int picture, String name, String text) {
        this.picture = picture;
        this.name = name;
        this.text = text;
    }
}
