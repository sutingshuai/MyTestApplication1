package com.example.suts.mytestapplication1.mainactiviy_mvp;

import com.example.suts.mytestapplication1.component.recyclerview.bean.Birds;

import java.util.List;

/**
 * Created by suts on 2017/9/7.
 */

public class MainPresenterImpl implements IMainPresenter, MainOperateInterfaces.IMainSetDataFinished{

    private MainModelImpl mainModel;
    private IMainView mainView;

    public MainPresenterImpl(IMainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModelImpl();
    }

    @Override
    public void onCreate() {
        mainView.initUiHandler();
        mainView.initRecyclerView();
        mainView.initAndSetAdapter();
        mainView.initSwipeRefreshView();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void ondestroy() {
        mainView = null;
    }

    @Override
    public void addData() {
        mainView.showProgressDialog();
        mainModel.setData(this);
    }


    @Override
    public void onDataNull() {
        mainView.hidProgressDialog();
    }

    @Override
    public void onSuccess(List<Birds> birdses) {
        mainView.refreshData(birdses);
        mainView.hidProgressDialog();
    }
}
