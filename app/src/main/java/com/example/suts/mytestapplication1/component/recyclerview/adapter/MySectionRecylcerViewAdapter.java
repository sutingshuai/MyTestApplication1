package com.example.suts.mytestapplication1.component.recyclerview.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.suts.mytestapplication1.R;
import com.example.suts.mytestapplication1.component.recyclerview.bean.MySection;
import com.example.suts.mytestapplication1.utils.glideutil.GlideLoadUtil;

import java.util.List;

/**
 * Created by suts on 2017/8/31.
 */

public class MySectionRecylcerViewAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder>{


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public MySectionRecylcerViewAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.tv_rv_sectionHeader, item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.tv_rv_BallName, item.t.getName())
                .setText(R.id.tv_rv_BallComeFrom, item.t.getComeFrom())
                .setText(R.id.tv_rv_BallId, item.t.getId()+"");
        Glide.with(mContext).load(item.t.getImageUrl()).apply(GlideLoadUtil.getDefaultRequestOp()).into((ImageView) helper.getView(R.id.iv_rv_BallImage));
    }
}
