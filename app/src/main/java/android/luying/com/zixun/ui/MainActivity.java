package android.luying.com.zixun.ui;

import android.luying.com.zixun.R;
import android.luying.com.zixun.ui.activity.BaseActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luying on 16/6/30.
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.main_home)
    RadioButton mainHome;
    @BindView(R.id.main_select)
    RadioButton mainSelect;
    @BindView(R.id.main_category)
    RadioButton mainCategory;
    @BindView(R.id.main_profile)
    RadioButton mainProfile;
    @BindView(R.id.main_group)
    RadioGroup mainGroup;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add();
    }
}
