package com.itzxx.module.router;

/**
 * ProjectName:  MVPHabitComponent
 * Author:  xxzhang
 * CreateAt:  2019/1/10  11:02
 * Description:  阿里路由常量公共类
 * Copyright © andacx Inc. All Rights Reserved
 */
public class ARouterPath {

    //主业务组件
    public static class  Main{

        private static final String MAIN="/Main";

        //Main主页面Activity
        public static final String MAIN_MAIN_A=MAIN+"/mainA";

        //Main主页面Fragment
        public static final String MAIN_MAIN_F=MAIN+"/mainF";
    }

    //首页组件
    public static class  Home{

        private static final String HOME="/home";

        //home主页面Activity
        public static final String HOME_MAIN_A=HOME+"/mainA";

        //home主页面Fragment
        public static final String HOME_MAIN_F=HOME+"/mainF";
    }

    //朋友圈组件
    public static class  Moment{

        private static final String MOMENT="/moment";

        //home主页面Activity
        public static final String MOMENT_MAIN_A=MOMENT+"/mainA";

        //home主页面Fragment
        public static final String MOMENT_MAIN_F=MOMENT+"/mainF";
    }


    //用户组件
    public static class  User{

        private static final String USER="/user";

        //home主页面Activity
        public static final String USER_MAIN_A=USER+"/mainA";

        //home主页面Fragment
        public static final String USER_MAIN_F=USER+"/mainF";
    }
}
