package com.itzxx.mvphabitcomponent;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.itzxx.module.util.DebugConfig;

/**
 * ProjectName:  MVPHabitComponent
 * Author:  xxzhang
 * CreateAt:  2019/1/9  14:08this
 * Description:  公共基础类
 * Copyright © andacx Inc. All Rights Reserved
 */
public class BaseModuleApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        if (DebugConfig.isDebug(this)) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
