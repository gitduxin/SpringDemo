package com.dx.test;

import com.dx.config.SpringConfig1;
import com.dx.domain.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * java config配置注入
 */
public class Bean2_T1 {
    private static AnnotationConfigApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new AnnotationConfigApplicationContext(SpringConfig1.class);
    }

    /**
     * 无参构造函数
     */
    @Test
    public void test1(){
        User user = (User) ac.getBean("user_1");
        User user1 = (User) ac.getBean("user_1");
        System.out.println(user == user1);
        System.out.println(user.toString());
        //user.getUser1().u1();
    }

    /**
     * 有参构造函数注入
     */
    @Test
    public void test2(){
        User user = (User) ac.getBean("user_2");
        User user1 = (User) ac.getBean("user_2");
        System.out.println(user == user1);
        System.out.println(user.toString());
        user.getUser1().u1();
    }

    /**
     * SET方法注入
     */
    @Test
    public void test3(){
        User user = (User) ac.getBean("user_3");
        User user1 = (User) ac.getBean("user_3");
        System.out.println(user == user1);
        System.out.println(user.toString());
        user.getUser1().u1();
    }
}
