package com.dic.bridge.base.manager.net;

/**
 * Created by dennis.jiang on 2017/2/10.
 */

public interface NetHandler<P, B> {

    void doBack(RequestParams<P> requestValues, RequestCallback<ResponseData<B>> callback);

    void doSync(RequestParams<P> requestValues, RequestCallback<ResponseData<B>> callback);

}
