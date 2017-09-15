package com.example.suts.mytestapplication1.mainactiviy_mvp;

import com.example.suts.mytestapplication1.component.recyclerview.bean.Birds;

import java.util.List;

/**
 * Created by suts on 2017/9/7.
 */

public interface IMainView {

    public void initRecyclerView();

    public void initAndSetAdapter();

    public void initUiHandler();

    public void initSwipeRefreshView();

    public void refreshData(List<Birds> datas);

    public void showProgressDialog();

    public void hidProgressDialog();

}
