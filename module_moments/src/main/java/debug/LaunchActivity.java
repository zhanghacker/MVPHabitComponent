package debug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.itzxx.module.moments.MomentsActivity;

/**
 * ProjectName:  MVPHabitComponent
 * Author:  xxzhang
 * CreateAt:  2019/1/9  13:32
 * Description:  朋友圈调试启动
 * Copyright © itzxx Inc. All Rights Reserved
 */
public class LaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().navigation(MomentsActivity.class);
    }
}
