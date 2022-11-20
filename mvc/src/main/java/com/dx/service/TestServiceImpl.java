package com.dx.service;

import com.dx.dao.TestDao;
import com.dx.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestDao testDao;
    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public void insertUser(User user) {
        testDao.insertUser(user);
    }

    @Override
    public User selectUser(String userid) {
        return testDao.selectUser(userid);
    }

    @Override
    public List<User> selectUsers() {
        return testDao.selectUsers();
    }
}
