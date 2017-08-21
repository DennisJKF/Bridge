package com.dic.bridge.app.architecture.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.dic.bridge.app.architecture.R;
import com.dic.bridge.app.architecture.di.DaggerBaseActivity;
import com.dic.bridge.base.utils.ToolBarUtil;

public class MainActivity extends DaggerBaseActivity {

    @Override
    public void onInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupView(Bundle savedInstanceState) {
        ToolBarUtil.setToolBarTitle(getToolbar(), "Main");
    }

    @Override
    protected void initData() {

    }

    public void openLogin(View view) {
        LoginActivity.goActivity(this);
    }
}
