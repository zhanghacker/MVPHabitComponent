package com.itzxx.module.home;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.itzxx.module.router.ARouterPath;
import com.zhangxiaoxiao.helperlibrary.base.BaseActivity;


@Route(path = ARouterPath.Home.HOME_MAIN_A)
public class HomeActivity extends BaseActivity {

    @Override
    public int getContentLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        HomeFragment navigation = ARouter.getInstance().navigation(HomeFragment.class);
        fm.add(R.id.home_container,navigation);
        fm.commit();
    }

    @Override
    public void initData() {

    }
}
