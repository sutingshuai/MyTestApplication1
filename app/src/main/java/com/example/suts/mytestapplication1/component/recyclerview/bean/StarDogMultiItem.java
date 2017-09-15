package com.example.suts.mytestapplication1.component.recyclerview.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.suts.mytestapplication1.component.recyclerview.adapter.MultiItemRecylerViewAdapter;

/**
 * Created by suts on 2017/8/31.
 */

public class StarDogMultiItem implements MultiItemEntity {


    StarDog starDog;

    public StarDogMultiItem(StarDog starDog) {
        this.starDog = starDog;
    }

    @Override
    public int getItemType() {
        return MultiItemRecylerViewAdapter.TYPE_2;
    }

    public StarDog getStarDog() {
        return starDog;
    }

    public void setStarDog(StarDog starDog) {
        this.starDog = starDog;
    }
}
