package com.dic.bridge.app.architecture.di;

import com.dic.bridge.app.architecture.base.BindBaseActivity;
import com.dic.bridge.app.architecture.di.component.ActivityComponent;
import com.dic.bridge.app.architecture.di.component.ApplicationComponent;
import com.dic.bridge.app.architecture.di.component.DaggerActivityComponent;
import com.dic.bridge.app.architecture.di.modules.ActivityModule;
import com.dic.bridge.base.wrapper.DiWrapper;

/**
 * Created by dennis.jiang on 2017/8/2.
 */

public abstract class DaggerBaseActivity extends BindBaseActivity implements DiWrapper {

    private ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    private ApplicationComponent getApplicationComponent() {
        return ((DaggerApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder().applicationComponent(getApplicationComponent()).activityModule
                (getActivityModule()).build();
    }

    @Override
    protected void onSetContentView() {
        super.onSetContentView();
        onInject();
    }

    @Override
    public void onInject() {
        getApplicationComponent().inject(this);
    }
}