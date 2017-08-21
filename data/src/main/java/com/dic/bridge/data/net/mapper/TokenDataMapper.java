package com.dic.bridge.data.net.mapper;

import com.dic.bridge.data.cache.database.model.TokenModel;
import com.dic.bridge.data.net.entity.TokenEntity;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class TokenDataMapper {

    public TokenDataMapper() {
    }

    public TokenModel transform(TokenEntity tokenEntity) {
        TokenModel tokenModel=new TokenModel();
        tokenModel.setRefreshToken(tokenEntity.getRefreshToken());
        tokenModel.setAccessToken(tokenEntity.getAccessToken());
        tokenModel.setExpiresIn(tokenEntity.getExpiresIn());
        return tokenModel;
    }
}
