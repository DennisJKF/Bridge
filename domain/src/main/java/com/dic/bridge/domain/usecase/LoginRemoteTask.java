package com.dic.bridge.domain.usecase;

import com.dic.bridge.base.manager.net.RequestCallback;
import com.dic.bridge.base.manager.net.ResponseData;
import com.dic.bridge.data.cache.database.model.TokenModel;
import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.mapper.TokenDataMapper;
import com.dic.bridge.data.repository.Injection;
import com.dic.bridge.data.repository.UserRepository;
import com.dic.bridge.domain.base.BaseUseCase;

import retrofit2.Call;

/**
 * Created by jeanboy on 2017/7/27.
 */

public class LoginRemoteTask extends BaseUseCase<LoginRemoteTask.RequestValues, LoginRemoteTask.ResponseValues> {

    private UserRepository userRepository = Injection.provideUserRepository();
    private Call<TokenEntity> call;

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        call = userRepository.login(requestValues.getUsername(), requestValues.getPassword(), new
                RequestCallback<ResponseData<TokenEntity>>() {
                    @Override
                    public void onSuccess(ResponseData<TokenEntity> response) {
                        TokenEntity body = response.getBody();
                        if (body == null) return;
                        // TODO: 2017/7/28 mapper数据转换层
                        TokenModel tokenModel = new TokenDataMapper().transform(body);
                        if (getUseCaseCallback() == null) return;
                        getUseCaseCallback().onSuccess(new ResponseValues(tokenModel));
                    }

                    @Override
                    public void onError(int code, String msg) {
                        if (getUseCaseCallback() == null) return;
                        getUseCaseCallback().onError();
                    }
                });
    }

    @Override
    protected void cancelUseCase() {
        if (call != null) {
            call.cancel();
        }
    }

    public static final class RequestValues implements BaseUseCase.RequestValues {
        private final String username;
        private final String password;

        public RequestValues(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static final class ResponseValues implements BaseUseCase.ResponseValues {

        private final TokenModel tokenModel;

        public ResponseValues(TokenModel tokenModel) {
            this.tokenModel = tokenModel;
        }

        public TokenModel getTokenModel() {
            return tokenModel;
        }
    }
}
