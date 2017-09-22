package com.example.suts.mytestapplication1.myviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.suts.mytestapplication1.R;
import com.example.suts.mytestapplication1.utils.ConvertUtil;

/**
 * Created by suts on 2017/9/14.
 */

public class MyPulltoRefreshView extends LinearLayout {

    private ListView mListView;
    private View mHeaderView;
    MarginLayoutParams layoutParams;
    public boolean layoutonce = false;
    int screenWidth = getWidth();

    //view in header
    ImageView ivHeader_Bg;
    TextView tvHeader_tip;

    public MyPulltoRefreshView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mHeaderView = LayoutInflater.from(context).inflate(R.layout.my_pulltorefresh_header, null, true);
        ivHeader_Bg = mHeaderView.findViewById(R.id.iv_HeaderBg);
        tvHeader_tip = mHeaderView.findViewById(R.id.tv_HeaderTip);
        addView(mHeaderView, 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!layoutonce) {
            int hideHeightSize = -mHeaderView.getHeight() + 20;
            layoutParams = (MarginLayoutParams) mHeaderView.getLayoutParams();
            //layoutParams.topMargin = hideHeightSize;
            mListView = (ListView) getChildAt(1);
            screenWidth = getWidth();
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
                //layoutParams.topMargin = disdance;
                if (layoutParams.height < ConvertUtil.px2dip(getContext().getApplicationContext(), 100f)){
                    layoutParams.width = screenWidth;
                    ivHeader_Bg.getLayoutParams().width = screenWidth;
                } else {
                    layoutParams.width = screenWidth+disdance;
                    ivHeader_Bg.getLayoutParams().width = screenWidth+disdance;
                }
                layoutParams.height = disdance;
                ivHeader_Bg.getLayoutParams().height = disdance;
                layoutParams.leftMargin = -disdance/2;
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
