package com.dic.bridge.data.net.manager;

import com.dic.bridge.data.cache.database.model.TokenModel;

import okhttp3.ResponseBody;

/**
 * Created by dennis.jiang on 8/22/17.
 */

interface ITokenManager {
    String getAccessToken();

    boolean hasToken();

    void clearToken();

    String getRefreshToken();

    void initToken(TokenModel tokenModel);

    void refreshToken(ResponseBody body);
}
