package com.example.suts.mytestapplication1.myviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.suts.mytestapplication1.R;

/**
 * Created by suts on 2017/9/14.
 */

public class MyPulltoRefreshView extends LinearLayout {

    private ListView mListView;
    private View mHeaderView;
    MarginLayoutParams layoutParams;
    public boolean layoutonce = false;

    public MyPulltoRefreshView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mHeaderView = LayoutInflater.from(context).inflate(R.layout.my_pulltorefresh_header, null, true);

        addView(mHeaderView, 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!layoutonce) {
            int hideHeightSize = -mHeaderView.getHeight() + 20;
            layoutParams = (MarginLayoutParams) mHeaderView.getLayoutParams();
            layoutParams.topMargin = hideHeightSize;
            mListView = (ListView) getChildAt(1);
            layoutonce = true;
        }
    }

    float downY;
    int disdance;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                disdance = (int) (event.getRawY() - downY);
                layoutParams.topMargin = disdance;
                mHeaderView.setLayoutParams(layoutParams);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return true;
    }

    public ListView getmListView() {
        return mListView;
    }

    public View getmHeaderView() {
        return mHeaderView;
    }
}
