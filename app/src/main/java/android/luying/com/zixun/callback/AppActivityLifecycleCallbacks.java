package android.luying.com.zixun.callback;

import android.app.Activity;
import android.app.Application;
import android.luying.com.zixun.utils.AppManager;
import android.os.Bundle;

/**
 * Created by luying on 16/6/30.
 */
public class AppActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks{
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        AppManager.getAppManager().addActivity(activity);
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
        if (activity != null) {
            AppManager.getAppManager().finishActivity(activity);
        }
    }
}
