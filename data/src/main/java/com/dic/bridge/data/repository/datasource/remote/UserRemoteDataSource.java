package com.dic.bridge.data.repository.datasource.remote;

import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.entity.UserEntity;
import com.dic.bridge.data.net.impl.UserServiceImpl;
import com.dic.bridge.data.repository.datasource.UserDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class UserRemoteDataSource implements UserDataSource.Remote {

    private UserServiceImpl userService = new UserServiceImpl();

    @Inject
    public UserRemoteDataSource() {
    }

    @Override
    public Flowable<TokenEntity> login(String username, String password) {
        return userService.login(username, password);
    }

    @Override
    public Flowable<UserEntity> getInfo(String accessToken, String userId) {
        return userService.getInfo(accessToken, userId);
    }

    @Override
    public Flowable<List<UserEntity>> getFriendList(String accessToken, String userId, int skip, int limit) {
        return userService.getFriendList(accessToken, userId, skip, limit);
    }
}
