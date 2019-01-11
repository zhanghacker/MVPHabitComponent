package com.itzxx.module.home;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhangxiaoxiao.helperlibrary.base.BaseFragment;
import com.itzxx.module.router.ARouterPath;
@Route(path=ARouterPath.Home.HOME_MAIN_F)
public class HomeFragment extends BaseFragment {

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
