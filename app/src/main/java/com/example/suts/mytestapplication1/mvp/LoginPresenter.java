package com.example.suts.mytestapplication1.mvp;

/**
 * Created by suts on 2017/9/6.
 */

public interface LoginPresenter {

    public void validateCredential(String userName, String userPassword);

    public void onDestroy();

}
