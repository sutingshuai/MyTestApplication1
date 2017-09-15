package com.example.suts.mytestapplication1.component.recyclerview.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.suts.mytestapplication1.R;
import com.example.suts.mytestapplication1.component.recyclerview.bean.StarPeopleMultiItem;
import com.example.suts.mytestapplication1.utils.glideutil.GlideApp;
import com.example.suts.mytestapplication1.utils.glideutil.GlideLoadUtil;

import java.util.List;

/**
 * Created by suts on 2017/8/31.
 */

public class MultiItemRecylerViewAdapter extends BaseMultiItemQuickAdapter<StarPeopleMultiItem, BaseViewHolder> {

    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */

    public MultiItemRecylerViewAdapter(List<StarPeopleMultiItem> data) {
        super(data);
        addItemType(TYPE_1, R.layout.rv_multi_layout_type1);
        addItemType(TYPE_2, R.layout.rv_multi_layout_type2);
    }

//    public MultiItemRecylerViewAdapter(List<StarPeopleMultiItem> data){
//        super(data);
//        setMultiTypeDelegate(new MultiTypeDelegate<StarPeopleMultiItem>() {
//            @Override
//            protected int getItemType(StarPeopleMultiItem starPeopleMultiItem) {
//                return starPeopleMultiItem.getItemType();
//            }
//        });
//
//        getMultiTypeDelegate().registerItemType(TYPE_1, R.layout.rv_multi_layout_type1)
//                              .registerItemType(TYPE_2, R.layout.rv_multi_layout_type2);
//
//    }

    @Override
    protected void convert(BaseViewHolder helper, StarPeopleMultiItem item) {
        switch (item.getItemType()){
            case TYPE_1:
                    helper.setText(R.id.tv_rv_multi1_Name, item.getStarPeople().getName())
                            .setText(R.id.tv_rv_multi1_introduce, item.getStarPeople().getIntroduce());
                GlideApp.with(mContext).load(item.getStarPeople().getImageUrl()).apply(GlideLoadUtil.getRoundedCornersRequestOp(25)).into((ImageView) helper.getView(R.id.iv_rv_multi1_image));
                break;
            case TYPE_2:
                helper.setText(R.id.tv_rv_multi2_Name, item.getStarPeople().getName())
                    .setText(R.id.tv_rv_multi2_introduce, item.getStarPeople().getIntroduce());
                GlideApp.with(mContext).load(item.getStarPeople().getImageUrl()).apply(GlideLoadUtil.getCircleCropRequestOp()).into((ImageView) helper.getView(R.id.iv_rv_multi2_image));
                break;
        }

    }


}
