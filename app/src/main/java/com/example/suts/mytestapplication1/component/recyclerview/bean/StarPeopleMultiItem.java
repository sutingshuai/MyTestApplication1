package com.example.suts.mytestapplication1.component.recyclerview.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.suts.mytestapplication1.component.recyclerview.adapter.MultiItemRecylerViewAdapter;

/**
 * Created by suts on 2017/8/31.
 */

public class StarPeopleMultiItem implements MultiItemEntity {


    private StarPeople starPeople;
    private int type;

    public StarPeopleMultiItem(StarPeople starPeople, int type) {
        this.starPeople = starPeople;
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }

    public StarPeople getStarPeople() {
        return starPeople;
    }

    public void setStarPeople(StarPeople starPeople) {
        this.starPeople = starPeople;
    }
}
