package com.dic.bridge.data.net.impl;

import com.dic.bridge.base.manager.net.RequestCallback;
import com.dic.bridge.base.manager.net.RequestParams;
import com.dic.bridge.base.manager.net.ResponseData;
import com.dic.bridge.data.net.manager.OkHttpManager;
import com.dic.bridge.data.net.dao.UserDao;
import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.entity.UserEntity;
import com.dic.bridge.data.repository.datasource.UserDataSource;

import java.util.List;

import retrofit2.Call;

/**
 * Created by jeanboy on 2017/7/27.
 */

public class UserDaoImpl implements UserDataSource.Remote {

    private UserDao userDao = OkHttpManager.getInstance().create(UserDao.BASE_URL, UserDao.class);

    @Override
    public Call<TokenEntity> login(String username, String password, RequestCallback<ResponseData<TokenEntity>> callback) {
        Call<TokenEntity> call = userDao.login(username, password);
        OkHttpManager.getInstance().doBack(new RequestParams<>(call), callback);
        return call;
    }

    @Override
    public Call<UserEntity> getInfo(String accessToken, String userId, RequestCallback<ResponseData<UserEntity>> callback) {
        Call<UserEntity> call = userDao.getInfo(accessToken, userId);
        OkHttpManager.getInstance().doBack(new RequestParams<>(call), callback);
        return call;
    }

    @Override
    public Call<List<UserEntity>> getFriendList(String accessToken, String userId, int skip, int limit, RequestCallback<ResponseData<List
            <UserEntity>>> callback) {
        Call<List<UserEntity>> call = userDao.getFriendList(accessToken, userId, skip, limit);
        OkHttpManager.getInstance().doBack(new RequestParams<>(call), callback);
        return call;
    }
}
