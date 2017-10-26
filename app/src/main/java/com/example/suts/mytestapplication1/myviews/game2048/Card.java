package com.example.suts.mytestapplication1.myviews.game2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by 15423 on 2017/10/13.
 */

public class Card extends FrameLayout {
    public Card(Context context) {
        super(context);

        lobalText = new TextView(getContext());
        lobalText.setTextSize(45);
        lobalText.setGravity(Gravity.CENTER);

        lobalText.setBackgroundColor(0x33ffffff);
        //-1,-1 表示填满整个窗体,调整一下布局
        LayoutParams layoutParams = new LayoutParams(-1,-1);

        layoutParams.setMargins(20,20,0,0);
        //添加
        addView(lobalText,layoutParams);
        setNum(0);
        // getSum();
    }
    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        //规定sum小于0时，是一个空字符串
        if (num <= 0) {
            lobalText.setText("");
        }else {
            lobalText.setText(num + "");
        }


    }
    //当两个数字相等时
    public boolean equals(Card obj) {
        return getNum() == obj.getNum() ;
    }
    //如果要呈现数据，要有一个Text View
    private TextView lobalText;
}
