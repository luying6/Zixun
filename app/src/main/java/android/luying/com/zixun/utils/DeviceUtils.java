package android.luying.com.zixun.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * Created by luying on 16/6/30.
 */
public class DeviceUtils {
    /**
     * 需要权限<uses-permission android:name="android.permission.READ_PHONE_STATE" />
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context
                .TELEPHONY_SERVICE);
        String deviceId = manager.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = String.valueOf(System.currentTimeMillis());
        }
        return deviceId;
    }

    /**
     * 获得手机型号
     * @return
     */
    public static String getModel() {
        return Build.MODEL;
    }
}
