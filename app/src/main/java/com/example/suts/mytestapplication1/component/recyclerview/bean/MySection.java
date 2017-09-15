package com.example.suts.mytestapplication1.component.recyclerview.bean;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.example.suts.mytestapplication1.component.recyclerview.bean.Ball;

/**
 * Created by suts on 2017/8/31.
 */

public class MySection extends SectionEntity<Ball> {


    public MySection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public MySection(Ball ball) {
        super(ball);
    }

}
