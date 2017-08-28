package com.example.suts.mytestapplication1.component.recyclerview;

/**
 * Created by suts on 2017/8/28.
 */

public class Birds {

    private String name;
    private String contry;
    private String imageUrl;
    private long id;

    public Birds(String name, String contry, String imageUrl, long id) {
        this.name = name;
        this.contry = contry;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
