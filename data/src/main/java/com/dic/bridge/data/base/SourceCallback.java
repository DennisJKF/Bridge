package com.dic.bridge.data.base;

/**
 * Created by dennis.jiang on 2017/3/9.
 */

public interface SourceCallback<T> {

    void onLoaded(T t);

    void onDataNotAvailable();
}
