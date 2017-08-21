package com.dic.bridge.app.architecture.di.component;


import com.dic.bridge.app.architecture.di.modules.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dennis.jiang on 2017/6/20.
 */
@Singleton
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {

//    WeatherInfoGetTask weatherInfoGetTask();

//    void inject(WeatherPresenter presenter);
//
//    void inject(CityPresenter presenter);
//
//    void inject(CityEditPresenter presenter);
//
//    void inject(AlertPresenter presenter);
}
