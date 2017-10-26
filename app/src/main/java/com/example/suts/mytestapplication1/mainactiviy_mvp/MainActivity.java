package com.example.suts.mytestapplication1.mainactiviy_mvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.suts.mytestapplication1.BaseActivity;
import com.example.suts.mytestapplication1.R;
import com.example.suts.mytestapplication1.component.recyclerview.RecyclerViewDataServer;
import com.example.suts.mytestapplication1.component.recyclerview.adapter.RecyclerViewUserAdapter;
import com.example.suts.mytestapplication1.component.recyclerview.bean.Birds;
import com.example.suts.mytestapplication1.utils.glideutil.GlideApp;
import com.example.suts.mytestapplication1.utils.glideutil.GlideLoadUtil;
import com.orhanobut.logger.Logger;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainView {

    private final String HeaderImageViewUrl = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=524829167,2100850017&fm=27&gp=0.jpg";

    @BindView(R.id.rv_RecyclerViewTest)
    RecyclerView rvRecyclerViewTest;
    @BindView(R.id.imageviewMainTop)
    ImageView imageviewMainTop;
    @BindView(R.id.toolbarMain)
    Toolbar toolbarMain;
    @BindView(R.id.collapsingtoolbarLayoutMain)
    CollapsingToolbarLayout collapsingtoolbarLayoutMain;
    @BindView(R.id.appBarLayoutMain)
    AppBarLayout appBarLayoutMain;
    @BindView(R.id.coordinatorLayout_main)
    CoordinatorLayout coordinatorLayoutMain;
//    @BindView(R.id.srl_recyclerViewTest)
//    SwipeRefreshLayout srlrecyclerViewTest;

    private RecyclerViewUserAdapter mAdapter;
    private int mCurrentCount = 0;
    private boolean isErr = false;
    private MainActivityUiHandler mUiHandler;
    private MainPresenterImpl mPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Logger.i("MainActivity has Create");
        if (mPresenter == null) {
            mPresenter = new MainPresenterImpl(this);
        }
        mPresenter.onCreate();
        mPresenter.addData();

        GlideApp.with(this).load(HeaderImageViewUrl).apply(GlideLoadUtil.getDefaultRequestOp()).into(imageviewMainTop);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void initRecyclerView() {
        rvRecyclerViewTest.setLayoutManager(getLayoutManager(2));
        rvRecyclerViewTest.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void initAndSetAdapter() {
        mAdapter = new RecyclerViewUserAdapter();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        mAdapter.isFirstOnly(false);

//        View headerView = LayoutInflater.from(this).inflate(R.layout.recyclerview_headerview1, null);
//        ImageView iv_recyclerViewHeader = headerView.findViewById(R.id.iv_recyclerViewHeader);
//        GlideApp.with(this).load(HeaderImageViewUrl).apply(GlideLoadUtil.getDefaultRequestOp()).into(iv_recyclerViewHeader);
//        mAdapter.addHeaderView(headerView);
//        View footerView = LayoutInflater.from(this).inflate(R.layout.recyclerview_footerview1, null);
//        mAdapter.addFooterView(footerView);
//        mAdapter.setFooterViewAsFlow(true);   //设置是否作为最后一个item 只对GridLayoutManager有用
//        mAdapter.setHeaderViewAsFlow(true);  //设置是否作为第一个item 只对GridLayoutManager有用
//        mAdapter.setHeaderAndEmpty(true);    //当data为空时 true显示emptyview和header false时不显示header
//        mAdapter.setHeaderFooterEmpty(true, true);  //同上

        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvRecyclerViewTest.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mCurrentCount >= 20) {
                            mAdapter.loadMoreEnd(true);
                        } else {
                            if (isErr) {
                                mAdapter.addData(RecyclerViewDataServer.getBirdDataList());
                                mCurrentCount = mAdapter.getData().size();
                                mAdapter.loadMoreComplete();
                            } else {
                                isErr = true;
                                Toast.makeText(MainActivity.this, "加载失败", Toast.LENGTH_LONG).show();
                                mAdapter.loadMoreFail();
                            }
                        }
                    }
                }, 1000);
            }
        }, rvRecyclerViewTest);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MainActivity.this, MainModelImpl.ACTIVITYS[position]));
            }
        });
        rvRecyclerViewTest.setAdapter(mAdapter);
    }

    @Override
    public void initUiHandler() {
        if (mUiHandler == null) {
            mUiHandler = new MainActivityUiHandler(this);
        }
    }

    @Override
    public void initSwipeRefreshView() {
//        srlrecyclerViewTest.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                srlrecyclerViewTest.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        srlrecyclerViewTest.setRefreshing(false);
//                    }
//                }, 500);
//            }
//        });
    }

    @Override
    public void refreshData(List<Birds> datas) {
        mAdapter.addData(datas);
        //mAdapter.notifyDataSetChanged();  //不需要执行notify操作
    }

    @Override
    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("loading...");
        }
        progressDialog.show();
    }

    @Override
    public void hidProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private static class MainActivityUiHandler extends Handler {
        private WeakReference<Context> mWeakReference;

        public MainActivityUiHandler(Context context) {
            mWeakReference = new WeakReference<Context>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    break;
            }
        }
    }

    public RecyclerView.LayoutManager getLayoutManager(int WhichLayoutManager) {
        if (WhichLayoutManager == 1) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            return gridLayoutManager;
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            return linearLayoutManager;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUiHandler = null;
        mPresenter.ondestroy();
    }
}
