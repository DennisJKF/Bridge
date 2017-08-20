package com.dic.bridge.domain.usecase;

import com.dic.bridge.base.manager.net.RequestCallback;
import com.dic.bridge.base.manager.net.ResponseData;
import com.dic.bridge.data.cache.database.model.UserModel;
import com.dic.bridge.data.net.entity.UserEntity;
import com.dic.bridge.data.net.mapper.UserDataMapper;
import com.dic.bridge.data.repository.Injection;
import com.dic.bridge.data.repository.UserRepository;
import com.dic.bridge.domain.base.BaseUseCase;

import java.util.List;

import retrofit2.Call;

/**
 * Created by jeanboy on 2017/7/27.
 */

public class GetFriendListRemoteTask extends BaseUseCase<GetFriendListRemoteTask.RequestValues, GetFriendListRemoteTask.ResponseValues> {

    private UserRepository userRepository = Injection.provideUserRepository();
    private Call<List<UserEntity>> call;

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        call = userRepository.getFriendList(requestValues.getAccessToken(), requestValues.getUserId(), requestValues.getSkip(),
                requestValues.getLimit(), new RequestCallback<ResponseData<List<UserEntity>>>() {

                    @Override
                    public void onSuccess(ResponseData<List<UserEntity>> response) {
                        List<UserEntity> body = response.getBody();
                        // TODO: 2017/7/28 mapper数据转换层
                        List<UserModel> modelList = new UserDataMapper().transform(body);
                        if (getUseCaseCallback() == null) return;
                        getUseCaseCallback().onSuccess(new ResponseValues(modelList));
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
        private final int skip;
        private final int limit;

        public RequestValues(String accessToken, String userId, int skip, int limit) {
            this.accessToken = accessToken;
            this.userId = userId;
            this.skip = skip;
            this.limit = limit;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getUserId() {
            return userId;
        }

        public int getSkip() {
            return skip;
        }

        public int getLimit() {
            return limit;
        }
    }

    public static final class ResponseValues implements BaseUseCase.ResponseValues {

        private final List<UserModel> userModel;

        public ResponseValues(List<UserModel> userModel) {
            this.userModel = userModel;
        }

        public List<UserModel> getUserModel() {
            return userModel;
        }
    }
}
