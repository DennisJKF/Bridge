package com.dic.bridge.app.architecture.event;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class MessageEvent {

    public static final int EVENT_CODE = 0x001;


    public int code;
    public Object obj;

    public MessageEvent(int code) {
        this.code = code;
    }

    public MessageEvent(int code, Object obj) {
        this.code = code;
        this.obj = obj;
    }
}
