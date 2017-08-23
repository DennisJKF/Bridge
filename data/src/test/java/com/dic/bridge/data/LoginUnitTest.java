package com.dic.bridge.data;

import com.dic.bridge.data.net.entity.TokenEntity;
import com.dic.bridge.data.net.manager.OkHttpManager;
import com.dic.bridge.data.net.service.IUserService;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import io.reactivex.functions.Predicate;
import io.reactivex.subscribers.TestSubscriber;
import retrofit2.Retrofit;
import retrofit2.mock.NetworkBehavior;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class LoginUnitTest {

    private final NetworkBehavior behavior = NetworkBehavior.create();
    private final TestSubscriber<TokenEntity> testSubscriber = TestSubscriber.create();
    private IUserService mockService;

    @Before
    public void setUp() throws Exception {
        Retrofit retrofit = OkHttpManager.getInstance().getRetrofitByGson("http://localhost:12306/");
        mockService = retrofit.create(IUserService.class);
    }

    @Test
    public void testSuccessResponse() throws Exception {
        givenNetworkFailurePercentIs(0);
        mockService.login("AAA", "BBB").subscribe(testSubscriber);
        Predicate<TokenEntity> predicate = new Predicate<TokenEntity>() {
            @Override
            public boolean test(TokenEntity tokenEntity) throws Exception {
                return Objects.equals(tokenEntity.getAccessToken(), "a");
            }
        };
        testSubscriber.assertValue(predicate);
        testSubscriber.assertComplete();
    }

    @Test
    public void testFailureResponse() throws Exception {
        givenNetworkFailurePercentIs(100);

        mockService.login("AAA", "BBB").subscribe(testSubscriber);

//        testSubscriber.assertNoValues();
//        testSubscriber.assertError(IOException.class);
    }

    private void givenNetworkFailurePercentIs(int failurePercent) {
        behavior.setDelay(0, MILLISECONDS);
        behavior.setVariancePercent(0);
        behavior.setFailurePercent(failurePercent);
    }
}