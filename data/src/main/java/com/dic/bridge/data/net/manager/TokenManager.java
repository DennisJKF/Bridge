package com.dic.bridge.data.net.manager;

import com.dic.bridge.data.cache.database.model.TokenModel;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;

/**
 * Created by dennis.jiang on 8/22/17.
 */

public class TokenManager implements ITokenManager {
    private TokenModel mTokenModel;

    @Override
    public String getAccessToken() {
        return mTokenModel.getAccessToken();
    }

    @Override
    public boolean hasToken() {
        return mTokenModel != null;
    }

    @Override
    public void clearToken() {
        mTokenModel = null;
    }

    @Override
    public String getRefreshToken() {
        return mTokenModel.getRefreshToken();
    }

    @Override
    public void initToken(TokenModel tokenModel) {
        mTokenModel = tokenModel;
    }

    @Override
    public void refreshToken(ResponseBody body) {
        mTokenModel = new GsonBuilder().create().fromJson(body.charStream(), TokenModel.class);
    }

    private static class InstanceHolder {
        private static final TokenManager sInstance = new TokenManager();
    }

    public static TokenManager getInstance() {
        return TokenManager.InstanceHolder.sInstance;
    }

    private TokenManager() {
    }
}
