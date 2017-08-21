package com.dic.bridge.base.wrapper;

/**
 * Created by dennis.jiang on 2017/8/2.
 * <p>
 * 用于初始化dagger
 */

public interface DiWrapper {

    /**
     * activity中：onSetContentView()后调用
     * fragment中：onFragmentCreate()后调用
     */
    void onInject();
}
