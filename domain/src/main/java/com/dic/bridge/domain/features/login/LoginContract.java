package com.dic.bridge.domain.features.login;

import com.dic.bridge.data.cache.database.model.TokenModel;
import com.dic.bridge.domain.base.BasePresenter;

/**
 * Created by dennis.jiang on 2017/7/27.
 */

public class LoginContract {

    public interface View {

        void loginSucceed(TokenModel tokenModel);

        void loginError();
    }

    public interface Presenter extends BasePresenter<View> {

        void login(String username, String password);
    }
}
