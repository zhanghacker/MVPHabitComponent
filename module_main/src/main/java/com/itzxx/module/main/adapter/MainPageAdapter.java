package com.itzxx.module.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * ProjectName:  MVPHabitComponent
 * Author:  xxzhang
 * CreateAt:  2019/1/10  16:30
 * Description:  底部导航栏页面adapter
 * Copyright © itzxx Inc. All Rights Reserved
 */
public class MainPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;

    public MainPageAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
