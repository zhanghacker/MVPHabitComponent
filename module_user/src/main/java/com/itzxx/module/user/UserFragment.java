package com.itzxx.module.user;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.itzxx.module.router.ARouterPath;
import com.zhangxiaoxiao.helperlibrary.base.BaseFragment;

@Route(path = ARouterPath.User.USER_MAIN_F)
public class UserFragment extends BaseFragment {

    @Override
    public int getContentLayout() {
        return R.layout.fragment_user;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
