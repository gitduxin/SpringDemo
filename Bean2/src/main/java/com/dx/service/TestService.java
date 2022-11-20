package com.dx.service;

public interface TestService {
    void ts();

    /**
     * bean初始化回调
     */
    void init();

    /**
     * bean销毁回调
     */
    void destory();
}
