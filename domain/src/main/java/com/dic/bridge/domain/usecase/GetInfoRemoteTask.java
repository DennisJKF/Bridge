package com.dic.bridge.domain.usecase;

import com.dic.bridge.base.manager.net.RequestCallback;
import com.dic.bridge.base.manager.net.ResponseData;
import com.dic.bridge.data.cache.database.model.UserModel;
import com.dic.bridge.data.net.entity.UserEntity;
import com.dic.bridge.data.net.mapper.UserDataMapper;
import com.dic.bridge.data.repository.Injection;
import com.dic.bridge.data.repository.UserRepository;
import com.dic.bridge.domain.base.BaseUseCase;

import retrofit2.Call;

/**
 * Created by jeanboy on 2017/7/27.
 */

public class GetInfoRemoteTask extends BaseUseCase<GetInfoRemoteTask.RequestValues, GetInfoRemoteTask.ResponseValues> {

    private UserRepository userRepository = Injection.provideUserRepository();
    private Call<UserEntity> call;

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        call = userRepository.getInfo(requestValues.getAccessToken(), requestValues.getUserId(), new
                RequestCallback<ResponseData<UserEntity>>() {


                    @Override
                    public void onSuccess(ResponseData<UserEntity> response) {
                        UserEntity body = response.getBody();
                        if (body == null) return;
                        // TODO: 2017/7/28 mapper数据转换层
                        UserModel userModel = new UserDataMapper().transform(body);
                        if (getUseCaseCallback() == null) return;
                        getUseCaseCallback().onSuccess(new ResponseValues(userModel));
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
        private final String accessToken;
        private final String userId;

        public RequestValues(String accessToken, String userId) {
            this.accessToken = accessToken;
            this.userId = userId;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getUserId() {
            return userId;
        }
    }

    public static final class ResponseValues implements BaseUseCase.ResponseValues {

        private final UserModel userModel;

        public ResponseValues(UserModel userModel) {
            this.userModel = userModel;
        }

        public UserModel getUserModel() {
            return userModel;
        }
    }
}
