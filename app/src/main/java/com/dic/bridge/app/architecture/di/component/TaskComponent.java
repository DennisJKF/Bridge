package com.dic.bridge.app.architecture.di.component;


import com.dic.bridge.app.architecture.di.modules.TaskModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dennis.jiang on 2017/6/20.
 */
@Singleton
@Component(modules = {TaskModule.class})
public interface TaskComponent {

//    AlertGetRemoteTask alertGetRemoteTask();
}
