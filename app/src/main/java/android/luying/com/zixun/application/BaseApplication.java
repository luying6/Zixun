package android.luying.com.zixun.application;

import android.app.Application;
import android.content.Context;
import android.luying.com.zixun.callback.AppActivityLifecycleCallbacks;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by luying on 16/6/30.
 */
public class BaseApplication extends Application {
    private String userId;
    private static BaseApplication app;
    private AppActivityLifecycleCallbacks lifecycleCallbacks = new AppActivityLifecycleCallbacks();
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        app = this;
        context = getApplicationContext();
//        Vitamio.isInitialized(this);
//        ShareSDK.initSDK(this);
//        FrescoHelper.getInstance().init(this);
        registerActivityLifecycleCallbacks(lifecycleCallbacks);
    }

    public static BaseApplication getInstance() {
        return app;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static Context getContext() {
        return context;
    }

    public void unregistLifecycleCallbacks() {
        if (lifecycleCallbacks != null) {
            unregisterActivityLifecycleCallbacks(lifecycleCallbacks);
        }
    }
}
