package com.dic.bridge.app.architecture.di.modules;

import android.support.v4.app.Fragment;

import com.dic.bridge.app.architecture.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dennis.jiang on 2017/6/19.
 */
@Module
public class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerActivity
    Fragment provideFragment() {
        return fragment;
    }
}
