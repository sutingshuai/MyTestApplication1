package com.example.suts.mytestapplication1.utils.glideutil;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.suts.mytestapplication1.R;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by suts on 2017/9/12.
 */

public class GlideLoadUtil {

    private static RequestOptions mRequestOptions = new RequestOptions().placeholder(R.mipmap.ic_image_loading).error(R.mipmap.ic_image_error).centerInside();

    public static RequestOptions getDefaultRequestOp(){
        return mRequestOptions.transform(new CenterInside());
    }

    public static RequestOptions getRoundedCornersRequestOp(int radius){
        return mRequestOptions.transform(new RoundedCornersTransformation(radius, 0));
    }

    public static RequestOptions getCircleCropRequestOp(){
        return mRequestOptions.transform(new CircleCrop());
    }

    public static RequestOptions getBlurRequestOp(){
        return mRequestOptions.transform(new BlurTransformation(25));
    }

}
