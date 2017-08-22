package com.dic.bridge.data.net.manager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dennis.jiang on 8/22/17.
 */

public class TokenInterceptor implements Interceptor {
    private final ITokenManager mTokenManager;

    public TokenInterceptor(ITokenManager tokenManager) {
        mTokenManager = tokenManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request initialRequest = chain.request();
        Request modifiedRequest = initialRequest;
        if (mTokenManager.hasToken()) {
            modifiedRequest = initialRequest.newBuilder()
                    .addHeader("USER_TOKEN", mTokenManager.getAccessToken())
                    .build();
        }

        Response response = chain.proceed(modifiedRequest);
        if (response.code() == 401) {
            mTokenManager.clearToken();
            modifiedRequest = initialRequest.newBuilder()
                    .addHeader("REFRESH_TOKEN", mTokenManager.getRefreshToken())
                    .build();
            Response refreshResponse = chain.proceed(modifiedRequest);
            mTokenManager.refreshToken(refreshResponse.body());
            modifiedRequest = initialRequest.newBuilder()
                    .addHeader("USER_TOKEN", mTokenManager.getAccessToken())
                    .build();
            return chain.proceed(modifiedRequest);
        } else {
            return response;
        }
    }
}
