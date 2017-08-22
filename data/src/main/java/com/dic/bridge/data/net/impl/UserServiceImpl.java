package com.dic.bridge.data.net.impl;

import com.dic.bridge.data.net.service.IUserService;
import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.entity.UserEntity;
import com.dic.bridge.data.net.manager.OkHttpManager;
import com.dic.bridge.data.repository.datasource.UserDataSource;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class UserServiceImpl implements UserDataSource.Remote {

    private IUserService mUserService = OkHttpManager.getInstance().create(IUserService.BASE_URL, IUserService.class);

    @Override
    public Flowable<TokenEntity> login(String username, String password) {
        return mUserService.login(username, password);
    }

    @Override
    public Flowable<UserEntity> getInfo(String accessToken, String userId) {
        return mUserService.getInfo(accessToken, userId);
    }

    @Override
    public Flowable<List<UserEntity>> getFriendList(String accessToken, String userId, int skip, int limit) {
        return mUserService.getFriendList(accessToken, userId, skip, limit);
    }
}
