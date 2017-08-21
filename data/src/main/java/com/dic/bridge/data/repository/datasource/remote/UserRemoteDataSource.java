package com.dic.bridge.data.repository.datasource.remote;

import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.entity.UserEntity;
import com.dic.bridge.data.net.impl.UserDaoImpl;
import com.dic.bridge.data.repository.datasource.UserDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class UserRemoteDataSource implements UserDataSource.Remote {

    private UserDaoImpl userDao = new UserDaoImpl();

    private static UserRemoteDataSource INSTANCE;

    @Inject
    public UserRemoteDataSource() {
    }

    public static UserRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Flowable<TokenEntity> login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public Flowable<UserEntity> getInfo(String accessToken, String userId) {
        return userDao.getInfo(accessToken, userId);
    }

    @Override
    public Flowable<List<UserEntity>> getFriendList(String accessToken, String userId, int skip, int limit) {
        return userDao.getFriendList(accessToken, userId, skip, limit);
    }
}
