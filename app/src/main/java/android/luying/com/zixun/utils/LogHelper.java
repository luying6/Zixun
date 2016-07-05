package android.luying.com.zixun.utils;

import android.util.Log;

/**
 * Created by luying on 16/6/30.
 */
public class LogHelper {
    private static final String TAG = "百思不得姐";
    public static boolean DEBUG = true;

    /**
     * 调试
     * @param msg
     */
    public static void logD(String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    /**
     * 错误
     * @param msg
     */
    public static void logE(String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }
}
