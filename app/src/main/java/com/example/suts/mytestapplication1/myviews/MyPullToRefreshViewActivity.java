package com.example.suts.mytestapplication1.myviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.suts.mytestapplication1.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyPullToRefreshViewActivity extends AppCompatActivity {

    @BindView(R.id.lv_pulltorefreshtest)
    ListView lvPulltorefreshtest;
    @BindView(R.id.mypulltrv_test)
    MyPulltoRefreshView mypulltrvTest;

    List<String> list;
    MyPullToRefreListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pull_to_refresh_view);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        list.add("所以我");
        list.add("开始变了");
        list.add("变得像");
        list.add("一直找不到方向的野鸽");
        list.add("所以我");
        list.add("开始醉了");

        adapter = new MyPullToRefreListAdapter(this, list);
        lvPulltorefreshtest.setAdapter(adapter);

    }
}
