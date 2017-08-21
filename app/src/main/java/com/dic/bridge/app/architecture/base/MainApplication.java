package com.dic.bridge.app.architecture.base;

import com.dic.bridge.app.architecture.di.DaggerApplication;
import com.dic.bridge.data.cache.manager.GreenDaoHandler;
import com.dic.bridge.data.cache.manager.GreenDaoManager;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class MainApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        setup();
    }

    private void setup() {
        GreenDaoManager.getInstance().build(getApplicationContext(), new GreenDaoHandler());
    }
}
