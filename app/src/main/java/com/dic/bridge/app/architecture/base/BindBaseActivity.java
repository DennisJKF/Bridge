package com.dic.bridge.app.architecture.base;

import android.app.Activity;

import com.dic.bridge.base.BaseActivity;
import com.dic.bridge.base.wrapper.BindWrapper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dennis.jiang on 2017/8/3.
 */

public abstract class BindBaseActivity extends BaseActivity implements BindWrapper {

    private Unbinder unbinder;

    @Override
    protected void onSetContentView() {
        onBind(this);
    }

    @Override
    protected void onDestroy() {
        onUnbind();
        super.onDestroy();
    }

    @Override
    public void onBind(Object target) {
        unbinder = ButterKnife.bind((Activity) target);
    }

    @Override
    public void onUnbind() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
