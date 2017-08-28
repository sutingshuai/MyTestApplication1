package com.example.suts.mytestapplication1.event_dispatch;

import android.view.MotionEvent;

/**
 * Created by suts on 2017/8/23.
 */

public class ActionToStringUtil {


    public static String getString(int action){
        switch (action){
            case MotionEvent.ACTION_DOWN:
                return "MotionEvent.ACTION_DOWN";
            case MotionEvent.ACTION_MOVE:
                return "MotionEvent.ACTION_MOVE";
            case MotionEvent.ACTION_UP:
                return "MotionEvent.ACTION_UP";
        }
        return "down move up 以外事件";
    }

}
