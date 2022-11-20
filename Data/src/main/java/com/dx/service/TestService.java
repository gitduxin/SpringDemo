package com.dx.service;

import com.dx.domain.User;

import java.util.List;

public interface TestService {
    void insertUser(User user);
    User selectUser(String userid);
    List<User> selectUsers();
}
