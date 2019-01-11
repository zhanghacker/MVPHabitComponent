package com.itzxx.module.user;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.itzxx.module.router.ARouterPath;
import com.zhangxiaoxiao.helperlibrary.base.BaseActivity;

@Route(path = ARouterPath.User.USER_MAIN_A)
public class UserActivity extends BaseActivity {

    @Override
    public int getContentLayout() {
        return R.layout.activity_user;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        UserFragment navigation = ARouter.getInstance().navigation(UserFragment.class);
        fragmentTransaction.add(R.id.user_container,navigation).commit();
    }

    @Override
    public void initData() {

    }
}
