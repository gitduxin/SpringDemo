package com.dx.test;

import com.dx.domain.User;
import com.dx.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mvc_T1 {

    @Autowired
    @Qualifier("testServiceImpl1")
    private TestService testService;

    @Test
    public void test1(){
        User user = testService.selectUser("111111");
        System.out.println(user.toString());
    }

    @Test
    public void test2(){
        List<User> users = testService.selectUsers();
        System.out.println(users);
    }

    @Test
    @Transactional
    public void test3(){
        User user = new User();
        user.setUserid("222");
        user.setUsername("username");
        user.setPassword("password");
        testService.insertUser(user);
        testService.insertUser(user);
    }
}
