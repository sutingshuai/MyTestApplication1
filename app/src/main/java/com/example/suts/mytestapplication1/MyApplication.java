package com.example.suts.mytestapplication1;

import android.app.Application;
import android.util.Log;

import com.orhanobut.logger.*;

/**
 * Created by suts on 2017/9/3.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }


    }
}
