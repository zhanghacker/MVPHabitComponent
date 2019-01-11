package com.itzxx.module.moments;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.itzxx.module.router.ARouterPath;
import com.zhangxiaoxiao.helperlibrary.base.BaseFragment;


@Route(path = ARouterPath.Moment.MOMENT_MAIN_F)
public class MomentsFragment extends BaseFragment {


    @Override
    public int getContentLayout() {
        return R.layout.fragment_moments;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
