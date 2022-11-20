package com.dx.test;

import com.dx.domain.User;
import com.dx.domain.User2;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean_T1 {
    private static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("classpath:application.xml");
    }

    /**
     * 构造函数
     */
    @Test
    public void test1(){
        User user = (User) ac.getBean("user");
        User user1 = (User) ac.getBean("user");
        System.out.println(user == user1);
        System.out.println(user.toString());
        user.getUser1().u1();
    }

    /**
     * 静态工厂
     */
    @Test
    public void test2(){
        User user = (User) ac.getBean("userFactory");
        User user1 = (User) ac.getBean("userFactory");
        System.out.println(user == user1);
        System.out.println(user.toString());
        user.getUser1().u1();
    }

    /**
     * 实例工厂
     */
    @Test
    public void test3(){
        User user = (User) ac.getBean("factory1");
        User user1 = (User) ac.getBean("factory1");
        System.out.println(user == user1);
        System.out.println(user.toString());
        user.getUser1().u1();
    }

    /**
     * bean属性注入
     */
    @Test
    public void test4(){
        User2 user2 = (User2) ac.getBean("user2");
        System.out.println(user2.toString());
    }
}
