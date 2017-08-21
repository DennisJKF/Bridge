package com.dic.bridge.app.architecture.di.component;

import android.app.Activity;

import com.dic.bridge.app.architecture.di.modules.ActivityModule;
import com.dic.bridge.app.architecture.di.scopes.PerActivity;
import com.dic.bridge.app.architecture.ui.activity.LoginActivity;
import com.dic.bridge.app.architecture.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by dennis.jiang on 2017/6/19.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();

    void inject(MainActivity activity);

    void inject(LoginActivity activity);
}
