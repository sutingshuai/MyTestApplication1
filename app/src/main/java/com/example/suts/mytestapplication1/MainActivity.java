package com.example.suts.mytestapplication1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.suts.mytestapplication1.liudayuanze.rsp.ImageLoader;

public class MainActivity extends Activity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv_rspImageTest);
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.displayImage("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=ca5abb5b7bf0f736ccf344536b3cd87c/29381f30e924b899c83ff41c6d061d950a7bf697.jpg", imageView);


    }
}
