package android.luying.com.zixun.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by luying on 16/6/30.
 */
public class ThreadPoolManager {
    private ExecutorService service;

    private ThreadPoolManager() {
        service = Executors.newCachedThreadPool();
    }

    private static final ThreadPoolManager manager = new ThreadPoolManager();

    public static ThreadPoolManager getInstance() {
        return manager;
    }

    public void executeTask(Runnable runnable) {
        service.execute(runnable);
    }
}
