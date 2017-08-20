package com.bridge.data.net.impl;

import com.bridge.base.manager.net.RequestCallback;
import com.bridge.base.manager.net.RequestParams;
import com.bridge.base.manager.net.ResponseData;
import com.bridge.data.net.manager.OkHttpManager;
import com.bridge.data.net.dao.UserDao;
import com.bridge.data.net.entity.TokenEntity;
import com.bridge.data.net.entity.UserEntity;
import com.bridge.data.repository.datasource.UserDataSource;

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
