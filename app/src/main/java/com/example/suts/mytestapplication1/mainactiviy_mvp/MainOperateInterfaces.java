package com.example.suts.mytestapplication1.mainactiviy_mvp;

import com.example.suts.mytestapplication1.component.recyclerview.bean.Birds;

import java.util.List;

/**
 * Created by suts on 2017/9/7.
 */

public class MainOperateInterfaces {

    public static interface IMainSetDataFinished{
        public void onDataNull();
        public void onSuccess(List<Birds> birdses);
    };

}
