package com.dic.bridge.data.repository;

import com.dic.bridge.data.repository.datasource.local.UserLocalDataSource;
import com.dic.bridge.data.repository.datasource.remote.UserRemoteDataSource;

/**
 * Created by jeanboy on 2017/7/28.
 */

public class Injection {

    public static UserRepository provideUserRepository() {
        return UserRepository.getInstance(UserLocalDataSource.getInstance(), UserRemoteDataSource.getInstance());
    }
}
