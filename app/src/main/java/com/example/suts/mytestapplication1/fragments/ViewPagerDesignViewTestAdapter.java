package com.example.suts.mytestapplication1.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suts on 2017/9/27.
 */

public class ViewPagerDesignViewTestAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> name;

    public ViewPagerDesignViewTestAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        name = new ArrayList<>();
    }

    public void addFragment(Fragment fragment, String name){
        this.list.add(fragment);
        this.name.add(name);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return name.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
