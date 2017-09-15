package com.example.suts.mytestapplication1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.suts.mytestapplication1.component.recyclerview.RecyclerViewDataServer;
import com.example.suts.mytestapplication1.component.recyclerview.adapter.MultiItemRecylerViewAdapter;
import com.example.suts.mytestapplication1.component.recyclerview.adapter.MySectionRecylcerViewAdapter;
import com.example.suts.mytestapplication1.component.recyclerview.bean.MySection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MultiItemAdapterActivity extends BaseActivity {

    @BindView(R.id.rv_multiItemTest)
    RecyclerView rvMultiItemTest;

    MultiItemRecylerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_item_adapter);
        ButterKnife.bind(this);

        setRecyclerView();

    }


    public void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMultiItemTest.setLayoutManager(linearLayoutManager);

        adapter = new MultiItemRecylerViewAdapter(RecyclerViewDataServer.getMultiItemDataList());

        rvMultiItemTest.setAdapter(adapter);


    }

}
