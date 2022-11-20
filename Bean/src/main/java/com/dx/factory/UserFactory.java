package com.dx.factory;

import com.dx.domain.User;
import com.dx.domain.User1;

/**
 * 静态工厂
 */
public class UserFactory {

    public UserFactory() {
    }

    public static User getUser(){
        return new User();
    }

    public static User getUser(String userId, String userName, String password, User1 user1) {
        return new User(userId,userName,password,user1);
    }
}
