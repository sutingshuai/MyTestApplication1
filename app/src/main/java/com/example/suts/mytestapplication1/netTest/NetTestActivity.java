package com.example.suts.mytestapplication1.netTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.suts.mytestapplication1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NetTestActivity extends AppCompatActivity {


    @BindView(R.id.btn_netTest_1)
    Button btnNetTest1;
    @BindView(R.id.btn_netTest_2)
    Button btnNetTest2;
    @BindView(R.id.btn_netTest_3)
    Button btnNetTest3;
    @BindView(R.id.btn_netTest_4)
    Button btnNetTest4;
    @BindView(R.id.btn_netTest_5)
    Button btnNetTest5;
    @BindView(R.id.btn_netTest_6)
    Button btnNetTest6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_test);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_netTest_1, R.id.btn_netTest_2, R.id.btn_netTest_3, R.id.btn_netTest_4, R.id.btn_netTest_5, R.id.btn_netTest_6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_netTest_1:
                break;
            case R.id.btn_netTest_2:
                break;
            case R.id.btn_netTest_3:
                break;
            case R.id.btn_netTest_4:
                break;
            case R.id.btn_netTest_5:
                break;
            case R.id.btn_netTest_6:
                break;
        }
    }
}
