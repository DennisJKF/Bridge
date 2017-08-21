package com.dic.bridge.app.architecture.di.modules;

import android.app.Activity;

import com.dic.bridge.app.architecture.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dennis.jiang on 2017/6/19.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.activity;
    }
}
