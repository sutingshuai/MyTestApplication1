package com.example.suts.mytestapplication1.mvp;

/**
 * Created by suts on 2017/9/6.
 */

public interface LoginView {

    public void showProgressDialog();
    public void hideProgressDialog();

    public void setUserNameErr();
    public void setUserPasswordErr();

    public void navigateToHome();

}
