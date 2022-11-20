package com.dx.factory;

import com.dx.domain.User;
import com.dx.domain.User1;

/**
 * 实例工厂
 */
public class UserFactory1 {

    public User getUser(){
        return new User();
    }

    public User getUser(String userId, String userName, String password, User1 user1) {
        return new User(userId,userName,password,user1);
    }

    public User getUser(String userId) {
        return new User(userId);
    }
}
