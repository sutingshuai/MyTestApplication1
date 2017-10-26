package com.example.suts.mytestapplication1.myviews.game2048;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.suts.mytestapplication1.R;

import java.util.ArrayList;

/**
 * Created by 15423 on 2017/10/14.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<ListDemo> arrayList;
    LayoutInflater inflater;
    private ImageView imageView;

    public MyAdapter(Context context, ArrayList<ListDemo> arrayList) {
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (convertview == null) {
            viewHolder = new ViewHolder();
            convertview = inflater.inflate(R.layout.layout_item, null);
            viewHolder.imageView = (ImageView) convertview.findViewById(R.id.img);
            viewHolder.text01 = (TextView) convertview.findViewById(R.id.text01);
            viewHolder.text02 = (TextView) convertview.findViewById(R.id.text02);

            convertview.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertview.getTag();
        }
        ListDemo listDemo = arrayList.get(position);
        //viewHolder.imageView.setImageResource(listDemo.getPicture());
        viewHolder.text01.setText(listDemo.getName());
        viewHolder.text02.setText(listDemo.getText());
        return convertview;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView text01;
        TextView text02;
    }
}
