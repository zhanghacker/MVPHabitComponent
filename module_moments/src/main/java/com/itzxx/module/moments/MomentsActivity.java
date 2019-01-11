package com.itzxx.module.moments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.itzxx.module.router.ARouterPath;
import com.zhangxiaoxiao.helperlibrary.base.BaseActivity;
@Route(path= ARouterPath.Moment.MOMENT_MAIN_A)

public class MomentsActivity extends BaseActivity {

    @Override
    public int getContentLayout() {
        return R.layout.activity_moments;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        MomentsFragment navigation = ARouter.getInstance().navigation(MomentsFragment.class);
        fragmentTransaction.add(R.id.moments_container,navigation).commit();
    }

    @Override
    public void initData() {

    }
}
