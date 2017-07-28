package test.liugang.com.myframework.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description:
 * @ Date:2017/7/13
 * @ Author:刘刚
 */

public class App extends Application {
    private static  App instance;
    private List<Activity> allActivity;
    public static Context mContext;

    public static App getInstance(){
        if (instance==null){
            synchronized (App.class){
                if (instance==null){
                    instance=new App();
                }
            }
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        instance=this;
        init();
        Fresco.initialize(this);
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                   removeActivity(activity);
            }
        });
    }

    private void init() {
        mContext = getApplicationContext();
    }

    public void addActivity(Activity act){
        if (allActivity==null){
            allActivity=new ArrayList<>();
        }
        allActivity.add(act);
    }
    public void removeActivity(Activity activity){
        if (allActivity!=null){
            allActivity.remove(activity);
        }
    }
    public void  exitApp(){
        if (allActivity!=null){
            synchronized (allActivity){
                for (Activity activity:allActivity){
                    activity.finish();
                }
            }
        }
        System.exit(0);
    }


}
