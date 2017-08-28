package com.example.suts.mytestapplication1.component.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suts.mytestapplication1.R;
import java.util.List;

/**
 * Created by suts on 2017/8/28.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{
    private List<Birds> dataList;

    public MyRecyclerViewAdapter(List<Birds> dataList) {
        this.dataList = dataList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_contruy;
        TextView tv_id;
        ImageView iv_image;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_rv_BirdName);
            tv_contruy = itemView.findViewById(R.id.tv_rv_BirdCountry);
            tv_id = itemView.findViewById(R.id.tv_rv_BirdId);
            iv_image = itemView.findViewById(R.id.iv_rv_BirdImage);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_test_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Birds bird = dataList.get(position);
        holder.tv_name.setText(bird.getName());
        holder.tv_contruy.setText(bird.getContry());
        holder.tv_id.setText(bird.getId() + "");
        holder.iv_image.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
