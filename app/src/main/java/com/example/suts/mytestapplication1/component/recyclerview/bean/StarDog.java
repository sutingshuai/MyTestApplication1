package com.example.suts.mytestapplication1.component.recyclerview.bean;

/**
 * Created by suts on 2017/8/31.
 */

public class StarDog {

    private String name;
    private String introduce;
    private String imageUrl;

    public StarDog(String name, String introduce, String imageUrl) {
        this.name = name;
        this.introduce = introduce;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
