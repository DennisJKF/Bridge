package com.dic.bridge.app.architecture.di;

import com.dic.bridge.app.architecture.base.BindBaseFragment;
import com.dic.bridge.app.architecture.di.component.ApplicationComponent;
import com.dic.bridge.app.architecture.di.component.DaggerFragmentComponent;
import com.dic.bridge.app.architecture.di.component.FragmentComponent;
import com.dic.bridge.app.architecture.di.modules.ActivityModule;
import com.dic.bridge.app.architecture.di.modules.FragmentModule;
import com.dic.bridge.base.wrapper.DiWrapper;

/**
 * Created by dennis.jiang on 2017/8/2.
 */

public abstract class DaggerBaseFragment extends BindBaseFragment implements DiWrapper {

    private FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    private ActivityModule getActivityModule() {
        return new ActivityModule(getActivity());
    }

    private ApplicationComponent getApplicationComponent() {
        return ((DaggerApplication) getContext().getApplicationContext()).getApplicationComponent();
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder().applicationComponent(getApplicationComponent()).activityModule
                (getActivityModule()).fragmentModule(getFragmentModule()).build();
    }

    @Override
    protected void onFragmentCreate() {
        super.onFragmentCreate();
        onInject();
    }

    @Override
    public void onInject() {
        getApplicationComponent().inject(this);
    }
}
