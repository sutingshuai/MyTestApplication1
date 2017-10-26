package com.example.suts.mytestapplication1.mainactiviy_mvp;

import android.app.Activity;
import android.os.Handler;

import com.example.suts.mytestapplication1.AndroidDesignViewTest;
import com.example.suts.mytestapplication1.Game2048Activity;
import com.example.suts.mytestapplication1.MultiItemAdapterActivity;
import com.example.suts.mytestapplication1.SectionAdapterActivity;
import com.example.suts.mytestapplication1.aidltest.AidlTestActivity;
import com.example.suts.mytestapplication1.component.recyclerview.bean.Birds;
import com.example.suts.mytestapplication1.mvp.MVPTestActivity;
import com.example.suts.mytestapplication1.myviews.MyPullToRefreshViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suts on 2017/9/7.
 */

public class MainModelImpl implements IMainModel {
    public final static Class<?>[] ACTIVITYS = {AndroidDesignViewTest.class, SectionAdapterActivity.class, MultiItemAdapterActivity.class, AidlTestActivity.class, MVPTestActivity.class, MyPullToRefreshViewActivity.class, Game2048Activity.class};

    @Override
    public void setData(final MainOperateInterfaces.IMainSetDataFinished iMainSetDataFinished) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ACTIVITYS.length > 0){
                    List<Birds> list = new ArrayList<>();
                    for (int i=0; i<ACTIVITYS.length; i++){
                        list.add(new Birds(ACTIVITYS[i].getSimpleName(), "介绍", "http://img1.imgtn.bdimg.com/it/u=1495426651,3979437573&fm=214&gp=0.jpg", i));
                    }
                    iMainSetDataFinished.onSuccess(list);
                } else {
                    iMainSetDataFinished.onDataNull();
                }
            }
        }, 2000);
    }
}
