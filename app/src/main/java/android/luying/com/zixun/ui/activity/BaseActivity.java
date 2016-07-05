package android.luying.com.zixun.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.luying.com.zixun.application.AppConstants;
import android.luying.com.zixun.utils.AppManager;
import android.luying.com.zixun.utils.LogHelper;
import android.luying.com.zixun.utils.ThreadPoolManager;
import android.luying.com.zixun.view.BaseView;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by luying on 16/6/30.
 */
public class BaseActivity extends AppCompatActivity  implements  View.OnClickListener,BaseView {
    protected Context mContext;
    protected ThreadPoolManager mThreadPoolManager;
    protected ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppManager.getAppManager().addActivity(this);
        mContext = this;
        LogHelper.logD(this.getClass().getSimpleName() + "----------onCreat");
        mProgressDialog = getProgress("正在加载,请稍候...");
        mThreadPoolManager = ThreadPoolManager.getInstance();
    }

    /**
     * 自定义进度条对话框
     * @param msg
     * @return
     */
    public ProgressDialog getProgress(String msg) {
        ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(true);
        return progressDialog;
    }

    /**
     * 显示进度条对话框
     */
    public void showProgressDialog() {
        runOnUI(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog != null) {
                    mProgressDialog.show();
                }
            }
        });
    }

    /**
     * 隐藏进度条对话框
     */
    public void hideProgressDialog() {
        runOnUI(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
            }
        });
    }

    /**
     * 显示吐司
     * @param msg
     */
    public void showToast(final String msg) {
        runOnUI(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 在主线程中运行
     * @param runnable
     */
    public void runOnUI(Runnable runnable) {
        runOnUiThread(runnable);
    }

    /**
     * 执行任务
     * @param runnable
     */
    public void executeTask(Runnable runnable) {
        mThreadPoolManager.executeTask(runnable);
    }

    /**
     * 加载网络图片
     * @param simpleDraweeView
     * @param url
     */
    public void loadImg(SimpleDraweeView simpleDraweeView, String url) {
        Uri imageUri = Uri.parse(url);
        simpleDraweeView.setImageURI(imageUri);
    }

    /**
     * 加载本地图片
     * @param simpleDraweeView
     * @param resId
     */
    public void loadImg(SimpleDraweeView simpleDraweeView, int resId) {
        Uri imageUri = Uri.parse("res://com.sunwenou.sybl/" + resId);
        simpleDraweeView.setImageURI(imageUri);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogHelper.logD(this.getClass().getSimpleName() + "----------onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogHelper.logD(this.getClass().getSimpleName() + "----------onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogHelper.logD(this.getClass().getSimpleName() + "----------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogHelper.logD(this.getClass().getSimpleName() + "----------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogHelper.logD(this.getClass().getSimpleName() + "----------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideProgressDialog();
        LogHelper.logD(this.getClass().getSimpleName() + "----------onDestroy");
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void accessError() {
        showToast(AppConstants.ACCESS_ERROR);
    }

    @Override
    public void connectError() {
        showToast(AppConstants.CONNECT_ERROR);
    }
}
