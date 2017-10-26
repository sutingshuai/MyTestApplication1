package com.example.suts.mytestapplication1;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.suts.mytestapplication1.fragments.FragmentTest1;
import com.example.suts.mytestapplication1.fragments.ViewPagerDesignViewTestAdapter;
import com.orhanobut.logger.Logger;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AndroidDesignViewTest extends BaseActivity {

    @BindView(R.id.abl_appBarLayoutTest)
    AppBarLayout ablAppBarLayoutTest;
    @BindView(R.id.tb_toolbarDesignTest)
    Toolbar tbToolbarDesignTest;
    @BindView(R.id.cl_coordinatorLayout)
    CoordinatorLayout clCoordinatorLayout;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
//    @BindView(R.id.linearLayout)
//    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_design_view_test);
        ButterKnife.bind(this);

        initToolbar();
        initTabLayout();



    }

    public void initViewpager(){
        ViewPagerDesignViewTestAdapter viewPagerAdapter = new ViewPagerDesignViewTestAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentTest1(), "瑞文");
        viewPagerAdapter.addFragment(new FragmentTest1(), "诺克萨斯");
        viewPagerAdapter.addFragment(new FragmentTest1(), "盖伦");
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void initTabLayout(){
        initViewpager();
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setupWithViewPager(viewPager);
    }


    public void initToolbar(){
        setSupportActionBar(tbToolbarDesignTest);
        tbToolbarDesignTest.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tbToolbarDesignTest.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Snackbar.make(clCoordinatorLayout, menuItem.getTitle(), Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });

    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Logger.e("onPrepareOptionsMenu");
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    Logger.e(getClass().getSimpleName() + "onMenuOpened...unable to set icons for overflow menu" + e);
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Logger.e("onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.android_design_testmenu, menu);
        return true;
    }
}
