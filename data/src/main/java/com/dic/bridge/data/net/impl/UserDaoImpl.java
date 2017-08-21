package com.dic.bridge.data.net.impl;

import com.dic.bridge.data.net.dao.UserDao;
import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.entity.UserEntity;
import com.dic.bridge.data.net.manager.OkHttpManager;
import com.dic.bridge.data.repository.datasource.UserDataSource;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class UserDaoImpl implements UserDataSource.Remote {

    private UserDao userDao = OkHttpManager.getInstance().create(UserDao.BASE_URL, UserDao.class);

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
