package com.dic.bridge.base.manager.net;

/**
 * Created by dennis.jiang on 2017/5/17.
 */

public class RequestParams<P> {

    private P params;

    public RequestParams(P body) {
        this.params = body;
    }

    public P getParams() {
        return params;
    }
}
