package com.itzxx.module.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * ProjectName:  MVPHabitComponent
 * Author:  xxzhang
 * CreateAt:  2019/1/9  14:39
 * Description:  判断是否是debug
 * Copyright © andacx Inc. All Rights Reserved
 */
public class DebugConfig {

    public static boolean isDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
