package com.example.suts.mytestapplication1.mainactiviy_mvp;

/**
 * Created by suts on 2017/9/7.
 */

public interface IMainPresenter {

    public void onCreate();
    public void onResume();

    public void onPause();
    public void ondestroy();

    public void addData();

}
