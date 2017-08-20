package com.dic.bridge.app.architecture.base;

import android.view.View;

import com.dic.bridge.base.BaseActivity;
import com.dic.bridge.base.wrapper.BindWrapper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jeanboy on 2017/8/3.
 */

public abstract class BindBaseActivity extends BaseActivity implements BindWrapper {

    private Unbinder unbinder;

    @Override
    protected void onSetContentView() {
        onBind(getWindow().getDecorView());
    }

    @Override
    protected void onDestroy() {
        onUnbind();
        super.onDestroy();
    }

    @Override
    public void onBind(View target) {
        unbinder = ButterKnife.bind(target);
    }

    @Override
    public void onUnbind() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
