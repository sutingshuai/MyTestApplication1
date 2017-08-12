package com.example.suts.mytestapplication1.liudayuanze.rsp;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by suts on 2017/8/3.
 */

public class ImageCache {

    private LruCache<String, Bitmap> mImageCache;

    public ImageCache() {
       initCache();
    }

    private void initCache(){
        int maxsize = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxsize/4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public Bitmap get(String url){
        return mImageCache.get(url);
    }

    public void put(String url, Bitmap bitmap){
        mImageCache.put(url, bitmap);
    }


}
