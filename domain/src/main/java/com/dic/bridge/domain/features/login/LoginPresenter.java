package com.dic.bridge.domain.features.login;

import com.dic.bridge.domain.base.BaseUseCase;
import com.dic.bridge.domain.usecase.LoginRemoteTask;

import javax.inject.Inject;

/**
 * Created by dennis.jiang on 2017/7/28.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    @Inject
    LoginRemoteTask task;

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.view = null;
        if (task != null) {
            task.cancel();
        }
    }

    @Override
    public void login(String username, String password) {
        task.setRequestValues(new LoginRemoteTask.RequestValues(username, password));
        task.setUseCaseCallback(new BaseUseCase.UseCaseCallback<LoginRemoteTask.ResponseValues>() {
            @Override
            public void onSuccess(LoginRemoteTask.ResponseValues response) {
                if (view == null) return;
                view.loginSucceed(response.getTokenModel());
            }

            @Override
            public void onError() {
                if (view == null) return;
                view.loginError();
            }
        });
        task.run();
    }
}
