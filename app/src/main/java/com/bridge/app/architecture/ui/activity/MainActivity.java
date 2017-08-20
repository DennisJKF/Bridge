package com.bridge.app.architecture.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.bridge.app.architecture.R;
import com.bridge.app.architecture.base.BindBaseActivity;
import com.bridge.base.utils.ToolBarUtil;

public class MainActivity extends BindBaseActivity {

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
