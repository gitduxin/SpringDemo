package com.dx.test;

import com.dx.aop.RequiredLog;
import com.dx.domain.User;
import com.dx.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Data_T2 {

    @Autowired
    @Qualifier("testServiceImpl2")
    private TestService testService;

    @Test
    public void test1(){
        testService.selectUsers();
    }
}
