package com.example.suts.mytestapplication1.component.recyclerview.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by suts on 2017/8/31.
 */

public class Ball {

    String header;

    private String name;
    private String  imageUrl;
    private String comeFrom;
    private long id;

    public Ball(String header, String name, String imageUrl, String comeFrom, long id) {
        this.header = header;
        this.name = name;
        this.imageUrl = imageUrl;
        this.comeFrom = comeFrom;
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
