# MVPHabitComponent
## 简介
&emsp;&emsp;随着项目越来越大，新功能不断增大，在外面对接项目的时候，需要交接源码，但是有些业务却要拿掉，不能交于客户,耦合性高，删除麻烦；再且单一项目增大了维护的成本，每个工程师都要去属性同样多的代码，多人协作开发会比较难。如果单一项目编译速度也是不能直视，有时候真他妈想砸电脑，所以必须要有更加优越和灵活的架构去替换过去的单一的架构，根据个人调研和实践，提供一套基于[MVPHabit](https://github.com/zhanghacker/MVPHabit)框架的组件化方案。

## 组件化方案
![image](https://github.com/zhanghacker/MVPHabitComponent/blob/master/jpg/module_guide.png?raw=true)

|名称|含义|
|:------:|:-------|
|集成模式|全部的业务都组件'module_app'依赖成一个完整的项目|
|组件模式|开发的时候可以单独运行的一个业务app|
|App壳工程|负责业务管理和打包apk,没有具体业务功能|
|Main组件|负责启动页、主页面|
|功能模块|各种工具依赖包|
|LibCommon|为所有业务组件基础,例如一些资源或网络请求|

</br>

##  1. 组件化架构
* [MVPHabit](https://github.com/zhanghacker/MVPHabit)：基于MVP模式开发框架，整合Rxjava+Retrofit+Dagger+Butterknife等主流模块，加入中一些比较常用的工具类，进行一些抽取和整理，让你更专注于业务自身的逻辑。demo给出相应的架构例子，可自行下载查看。
* [ARouter](https://github.com/alibaba/ARouter)：ARouter是阿里开源的一款android路由框架。通过路由进行界面跳转，区别于 Intent的显隐式跳转。在模块化的项目中，友好的解决了因模块互相依赖冲突，而界面互相跳转不了的问题，使用ARouter进行跳转，两个 library互相不依赖，也可以相互跳转。


##  2. 组件化实施流程
### 2.1 创建项目
>先把主项目（宿主项目）、Module业务项目的基本框架先搭建起来
#### 2.1.1 创建App壳工程：Module_App
&emsp;这个就是我们平常创建的Project项目，里面没有资源和activity，它的主要任务就是负责业务管理和打包apk。
#### 2.1.2 创建Module：LibCommon、Module_Main、Module_Home等
>File -> New -> New Module -> Android Library
#### 2.1.3 第三方框架集成准备
* [MVPHabit](https://github.com/zhanghacker/MVPHabit)

在根目录的build.gradle中加入
```
   allprojects {
        repositories {
            ...
            maven { url 'https://www.jitpack.io' }
        }
    } 
```
在主项目app的build.gradle中依赖
```
    dependencies {
                //x.x.x自行更换最新版本
    	        implementation 'com.github.zhanghacker:MVPHabit:x.x.x'
    	}
```
* [ARouter](https://github.com/alibaba/ARouter)
```
    defaultConfig {
        ...
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [AROUTER_MODULE_NAME: project.getName()]
            }
        }
    }
```
```
    dependencies {
        api 'com.alibaba:arouter-api:?'
        annotationProcessor 'com.alibaba:arouter-compiler:?'
    }
```
### 2.2 组件化的开始
#### 2.2.1 组件模式和集成模式的转换
Android Studio中的Module主要有两种属性，分别为：

1、application属性，可以独立运行的Android程序，也就是我们的APP；

```
apply plugin: 'com.android.application' 
```
2、library属性，不可以独立运行，一般是Android程序依赖的库文件；
```
apply plugin: 'com.android.library'
```

&emsp;&emsp;在项目的根目录中生成一个文件gradle.properties，我们将使用这个文件的一个重要属性：在Android项目中的任何一个build.gradle文件中都可以把gradle.properties中的常量读取出来；那么我们在上面提到解决办法就有了实际行动的方法，首先我们在gradle.properties中定义一个常量值isDebugModule（是否是组件开发模式，true为是，false为否）：
```
# 每次更改“isDebugModule”的值后，需要点击 "Sync Project" 按钮
isDebugModule=false
```
&emsp;&emsp;然后我们在业务组件的build.gradle中读取 isDebugModule，但是 gradle.properties 还有一个重要属性：gradle.properties中的数据类型都是String类型，使用其他数据类型需要自行转换；也就是说我们读到 isDebugModule 是个String类型的值，而我们需要的是Boolean值，代码如下：
```
if (isDebugModule.toBoolean()) {
    apply plugin: 'com.android.application'
} else {
    apply plugin: 'com.android.library'
}
```

#### 2.2.2 项目的依赖关系
App壳工程(宿主)依赖业务组件
```
dependencies {
    //如果独立运行就不依赖
    if (!isDebugModule.toBoolean()) {
        //主业务模块
        implementation project(':module_main')
        //首页业务模块
        implementation project(':module_home')
        //朋友圈业务模块
        implementation project(':module_moments')
        //用户模块
        implementation project(':module_user')
    }else{
        implementation project(':lib_common')
    }
}
```
LibCommon公共库的依赖
```
dependencies {
    //注意设置为api，提供给个个业务组件一起使用
    api deps.MVPHabit
    api deps.arouter_api
    api deps.support.multidex
    api deps.support.design
}
```
业务组件依赖LibCommon
```
dependencies {
    //用implementation，防止重复依赖
    implementation project(':lib_common')
    annotationProcessor deps.arouter_compiler
}
```
</br>
</br>

### 持续探索中...

