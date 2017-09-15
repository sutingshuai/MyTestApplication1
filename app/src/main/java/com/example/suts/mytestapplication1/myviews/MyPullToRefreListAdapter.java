package com.example.suts.mytestapplication1.myviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.suts.mytestapplication1.R;

import java.util.List;

/**
 * Created by suts on 2017/9/14.
 */

public class MyPullToRefreListAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public MyPullToRefreListAdapter( Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.my_pulltorefreshlist_cell, viewGroup, false);
            viewHolder.textView = view.findViewById(R.id.tv_pulltorefreshtest1);
            view.setTag(viewHolder);
        }  else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(list.get(i));
        return view;
    }

    public class ViewHolder{
        TextView textView;
    }

}
