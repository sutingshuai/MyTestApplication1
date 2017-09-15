package com.example.suts.mytestapplication1.mvp;

import android.os.Handler;

/**
 * Created by suts on 2017/9/6.
 */

public class LoginModelImpl implements LoginModel {
    private final String mUserName = "susan";
    private final String mUserPassword = "0000";

    @Override
    public void login(final String userName, final String userPassword, final OnLoginFinishedListener onLoginFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isError = false;
                if (!userName.equals(mUserName)){
                    onLoginFinishedListener.onUerNameErr();
                    isError = true;
                }
                if (!isError && !userPassword.equals(mUserPassword)){
                    onLoginFinishedListener.onUserPasswordErr();
                    isError = true;
                }
                if (!isError) {
                    onLoginFinishedListener.onSuccess();
                }
            }
        }, 2000);

    }
}
