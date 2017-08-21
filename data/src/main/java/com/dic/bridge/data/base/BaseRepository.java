package com.dic.bridge.data.base;

/**
 * Created by dennis.jiang on 2017/3/13.
 */

public class BaseRepository {

    protected boolean mCacheIsDirty = false;

    public void refresh() {
        mCacheIsDirty = true;
    }

}
