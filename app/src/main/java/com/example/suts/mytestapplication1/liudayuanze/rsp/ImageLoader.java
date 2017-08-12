package com.example.suts.mytestapplication1.liudayuanze.rsp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by suts on 2017/8/3.
 * 功能描述：1.加载图片 2.图片缓存
 */

public class ImageLoader {

    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    Handler mainHandler = new Handler(Looper.getMainLooper());
    ImageCache imageCache;

    public ImageLoader() {
        imageCache = new ImageCache();
    }

    public void displayImage(final String url, final ImageView imageView){
        Bitmap bitmap = imageCache.get(url);
        if (bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadBitmap(url);
                if (bitmap == null){
                    return;
                }
                if (imageView.getTag().equals(url)){
                    updateImage(bitmap, imageView);
                }
                imageCache.put(url, bitmap);
            }
        });

    }

    public void updateImage(final Bitmap bitmap, final ImageView imageView){
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    public Bitmap downloadBitmap(String url){
        Bitmap bitmap = null;
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}
