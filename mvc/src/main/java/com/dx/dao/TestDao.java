package com.dx.dao;

import com.dx.domain.User;

import java.util.List;

public interface TestDao {
    void insertUser(User user);
    User selectUser(String userid);
    List<User> selectUsers();
    void updateUser(User user);
}
