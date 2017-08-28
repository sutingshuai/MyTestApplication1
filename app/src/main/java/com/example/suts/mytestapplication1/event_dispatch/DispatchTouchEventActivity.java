package com.example.suts.mytestapplication1.event_dispatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.suts.mytestapplication1.R;

public class DispatchTouchEventActivity extends AppCompatActivity {

    private static final String TAG = "Activity总统";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_touch_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "分发事件" + ActionToStringUtil.getString(ev.getAction()) + "需要分发");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = false;
        Log.e(TAG, "处理事件" + ActionToStringUtil.getString(event.getAction()) + b);
        return b;
    }
}
