package com.example.suts.mytestapplication1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.suts.mytestapplication1.component.recyclerview.bean.MySection;
import com.example.suts.mytestapplication1.component.recyclerview.RecyclerViewDataServer;
import com.example.suts.mytestapplication1.component.recyclerview.adapter.MySectionRecylcerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionAdapterActivity extends BaseActivity {


    @BindView(R.id.rv_sectionTest)
    RecyclerView rvSectionTest;
    MySectionRecylcerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_adapter);
        ButterKnife.bind(this);

        setRecyclerView();


    }



    public void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSectionTest.setLayoutManager(linearLayoutManager);

        adapter = new MySectionRecylcerViewAdapter(R.layout.sectionadapter_test_layout, R.layout.rv_sectionheader_layout, RecyclerViewDataServer.getSectionDataList());

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MySection mSection = (MySection) adapter.getData().get(position);
                if (mSection.isHeader){
                    Toast.makeText(SectionAdapterActivity.this, "我是section Header", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rvSectionTest.setAdapter(adapter);


    }

}
