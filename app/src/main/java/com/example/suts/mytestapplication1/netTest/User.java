package com.example.suts.mytestapplication1.netTest;

/**
 * Created by suts on 2017/8/29.
 */

public class User {

    private String name;
    private String sex;
    private int age;
    private String avatar;

    public User(String name, String sex, int age, String avatar) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
