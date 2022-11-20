package com.dx.test;

import com.dx.dao.TestDao;
import com.dx.domain.User;
import com.dx.service.TestService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Data_T1 {

    @Test
    public void test1(){
        ApplicationContext ac = ac = new ClassPathXmlApplicationContext("classpath:application.xml");
        SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = factory.openSession();
        TestDao testDao =  session.getMapper(TestDao.class);
        User user = testDao.selectUser("123456");
        System.out.println(user.toString());
    }

    @Test
    public void test2(){
        ApplicationContext ac = ac = new ClassPathXmlApplicationContext("classpath:application.xml");
        SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = factory.openSession();
        TestDao testDao =  session.getMapper(TestDao.class);
        List<User> user = testDao.selectUsers();
        System.out.println("user.toString()");
    }

    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application.xml");
        TestService testService = (TestService) ac.getBean("testServiceImpl2");
        User user = new User();
        testService.insertUser(user);
    }
}
