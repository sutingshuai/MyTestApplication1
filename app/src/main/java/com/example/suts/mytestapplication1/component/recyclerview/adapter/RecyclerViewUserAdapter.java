package com.example.suts.mytestapplication1.component.recyclerview.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.suts.mytestapplication1.R;
import com.example.suts.mytestapplication1.component.recyclerview.bean.Birds;
import com.example.suts.mytestapplication1.utils.glideutil.GlideApp;
import com.example.suts.mytestapplication1.utils.glideutil.GlideLoadUtil;
import com.example.suts.mytestapplication1.utils.glideutil.glidepalette.BitmapPalette;
import com.example.suts.mytestapplication1.utils.glideutil.glidepalette.GlidePalette;

/**
 * Created by suts on 2017/8/29.
 */

public class RecyclerViewUserAdapter extends BaseQuickAdapter<Birds, BaseViewHolder> {


    public RecyclerViewUserAdapter() {
        super(R.layout.recyclerview_test_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, Birds item) {
        helper.setText(R.id.tv_rv_BirdName, item.getName())
//                .setText(R.id.tv_rv_BirdCountry, item.getName())
                .setText(R.id.tv_rv_BirdId, item.getId()+ "");
        if (item.getId() %2 == 0) {
            GlideApp.with(mContext).load(item.getImageUrl()).apply(GlideLoadUtil.getCircleCropRequestOp()).into((ImageView) helper.getView(R.id.iv_rv_BirdImage));
        } else {
            GlideApp.with(mContext).load(item.getImageUrl()).apply(GlideLoadUtil.getRoundedCornersRequestOp(20)).into((ImageView) helper.getView(R.id.iv_rv_BirdImage));
        }
    }
}
