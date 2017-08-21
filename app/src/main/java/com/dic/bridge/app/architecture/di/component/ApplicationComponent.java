package com.dic.bridge.app.architecture.di.component;

import android.content.Context;

import com.dic.bridge.app.architecture.di.modules.ApplicationModule;
import com.dic.bridge.base.BaseActivity;
import com.dic.bridge.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dennis.jiang on 2017/6/19.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context context();

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);
}
