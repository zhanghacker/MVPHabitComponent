package com.itzxx.module.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.itzxx.module.main.adapter.MainPageAdapter;
import com.itzxx.module.router.ARouterPath;
import com.zhangxiaoxiao.helperlibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.Main.MAIN_MAIN_A)
public class MainActivity extends BaseActivity {


    private BottomNavigationView mNavbar;
    private ViewPager mVpcontent;

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        mNavbar = (BottomNavigationView) findViewById(R.id.nav_bar);
        mVpcontent = (ViewPager) findViewById(R.id.vp_content);
    }

    @Override
    public void initData() {
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(ARouterPath.Home.HOME_MAIN_F).navigation();
        Fragment momentFragment = (Fragment) ARouter.getInstance().build(ARouterPath.Moment.MOMENT_MAIN_F).navigation();
        Fragment usertFragment = (Fragment) ARouter.getInstance().build(ARouterPath.User.USER_MAIN_F).navigation();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(momentFragment);
        fragments.add(usertFragment);
        MainPageAdapter mainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), fragments);
        mVpcontent.setAdapter(mainPageAdapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mNavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.navigation_home) {
                    mVpcontent.setCurrentItem(0);
                } else if (itemId == R.id.navigation_moments) {
                    mVpcontent.setCurrentItem(1);
                } else if (itemId == R.id.navigation_user) {
                    mVpcontent.setCurrentItem(2);
                }
                return true;
            }
        });
    }
}
