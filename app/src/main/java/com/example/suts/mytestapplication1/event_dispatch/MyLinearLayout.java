package com.example.suts.mytestapplication1.event_dispatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by suts on 2017/8/23.
 */

public class MyLinearLayout extends LinearLayout {

    private static final String TAG = "Linearlayout市长";

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "分发事件" + ActionToStringUtil.getString(ev.getAction()) + "需要分发");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean b = false;
        Log.e(TAG, "拦截事件" + ActionToStringUtil.getString(ev.getAction()) + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = false;
        Log.e(TAG, "处理事件" + ActionToStringUtil.getString(event.getAction()) + b);
        return b;
    }
}
