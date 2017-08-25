package com.dic.bridge.data.remote;

import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.manager.OkHttpManager;

import org.junit.Before;

import io.reactivex.subscribers.TestSubscriber;
import retrofit2.Retrofit;
import retrofit2.mock.NetworkBehavior;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by dennis.jiang on 8/24/17.
 */

public abstract class BaseRemoteUnitTest {
    protected Retrofit retrofit;
    protected TestSubscriber<TokenEntity> testSubscriber;
    private final NetworkBehavior behavior = NetworkBehavior.create();
    @Before
    public void init() {
        retrofit = OkHttpManager.getInstance().getRetrofitByGson("http://localhost:12306/");
        testSubscriber = TestSubscriber.create();
    }


    protected void givenNetworkFailurePercentIs(int failurePercent) {
        behavior.setDelay(0, MILLISECONDS);
        behavior.setVariancePercent(0);
        behavior.setFailurePercent(failurePercent);
    }
}
