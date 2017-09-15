package com.example.suts.mytestapplication1.mvp;

/**
 * Created by suts on 2017/9/6.
 */

public interface LoginModel {

    public void login(String userName, String userPassword, OnLoginFinishedListener onLoginFinishedListener);

}
