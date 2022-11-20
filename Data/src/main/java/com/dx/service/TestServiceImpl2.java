package com.dx.service;

import com.dx.aop.RequiredLog;
import com.dx.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl2 implements TestService {

    @Override
    @RequiredLog
    public void insertUser(User user) {
        System.out.println("insertUser...................");

        //当需要调用其他方法时也出发通知,则需要将expose-proxy="true"将代理对象暴露出来
//        ((TestService)AopContext.currentProxy()).selectUser("1");
    }

    @Override
    public User selectUser(String userid) {
        System.out.println("selectUser...................");
        return null;
    }

    @Override
    public List<User> selectUsers() {
        System.out.println("selectUsers...................");
        return null;
    }
}
