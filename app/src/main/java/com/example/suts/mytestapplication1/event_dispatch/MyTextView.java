package com.example.suts.mytestapplication1.event_dispatch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by suts on 2017/8/23.
 */

public class MyTextView extends TextView {

    private static final String TAG = "textView农民";

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "分发事件" + ActionToStringUtil.getString(event.getAction()) + "需要分发");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = false;
        Log.e(TAG, "处理事件" + ActionToStringUtil.getString(event.getAction()) + b);
        return b;
    }
}
