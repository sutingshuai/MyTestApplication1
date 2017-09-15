package com.example.suts.mytestapplication1.mvp;

/**
 * Created by suts on 2017/9/6.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener{

    private LoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        this.mLoginModel = new LoginModelImpl();
    }

    @Override
    public void validateCredential(String userName, String userPassword) {
        mLoginView.showProgressDialog();

        mLoginModel.login(userName, userPassword, this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }

    @Override
    public void onUerNameErr() {
        mLoginView.hideProgressDialog();
        mLoginView.setUserNameErr();
    }

    @Override
    public void onUserPasswordErr() {
        mLoginView.hideProgressDialog();
        mLoginView.setUserPasswordErr();
    }

    @Override
    public void onSuccess() {
        mLoginView.hideProgressDialog();
        mLoginView.navigateToHome();
    }
}
