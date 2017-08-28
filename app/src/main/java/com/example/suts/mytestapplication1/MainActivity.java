package com.example.suts.mytestapplication1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.example.suts.mytestapplication1.component.recyclerview.Birds;
import com.example.suts.mytestapplication1.component.recyclerview.MyRecyclerViewAdapter;
import com.example.suts.mytestapplication1.event_dispatch.DispatchTouchEventActivity;
import com.example.suts.mytestapplication1.liudayuanze.rsp.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

public class MainActivity extends Activity {

    ImageView imageView;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    HandlerThread handlerThread;
    Handler sonThreadHandler;
    Handler mUiHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:

                    break;
                default:

                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv_rspImageTest);
        recyclerView = findViewById(R.id.rv_RecyclerViewTest);

        initRecyclerViewAndShow();

        useMyImagLoaderShowImage();

        //useHandlerThread();  //使用HandlerThread 异步处理机制
    }

    private void useMyImagLoaderShowImage(){
        //ImageLoader imageLoader = new ImageLoader();
        //imageLoader.displayImage("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=ca5abb5b7bf0f736ccf344536b3cd87c/29381f30e924b899c83ff41c6d061d950a7bf697.jpg",
        //                          imageView);
        RequestOptions options = new RequestOptions().centerCrop()
                                                      .placeholder(R.mipmap.ic_image_loading)
                                                      .error(R.mipmap.ic_image_error);
        Glide.with(this)
                .load("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=ca5abb5b7bf0f736ccf344536b3cd87c/29381f30e924b899c83ff41c6d061d950a7bf697.jpg")
                .apply(options)
                .into(imageView);
    }

    private void initRecyclerViewAndShow(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<Birds> list = new ArrayList<>();
        list.add(new Birds("大熊猫", "China", "www.baidu.com", 1001));
        list.add(new Birds("袋鼠", "Australian", "www.baidu.com", 1002));
        list.add(new Birds("棕熊", "US", "www.baidu.com", 1003));
        list.add(new Birds("眼镜蛇", "India", "www.baidu.com", 1004));
        adapter = new MyRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    public void useHandlerThread(){
        handlerThread = new HandlerThread("handler-thread");
        handlerThread.start();
        sonThreadHandler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:

                        break;
                    default:

                        break;
                }
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
        sonThreadHandler = null;
        mUiHandler = null;
    }
}
