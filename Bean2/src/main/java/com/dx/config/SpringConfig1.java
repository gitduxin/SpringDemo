package com.dx.config;

import com.dx.domain.User;
import com.dx.domain.User1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class SpringConfig1 {

    @Bean("user_1")
    public User getUser(){
        return new User();
    }

    /**
     * 构造函数注入
     */
    @Bean(value = "user_2")
    @Lazy()
    public User getUser(@Value("userid") String userid, @Value("username")String username, @Value("password") String password,
                        //当配置此bean时自动装配,多个类型匹配异常
                        User1 user1) {
        return new User(userid,username,password,user1);
    }

    /**
     * set方法注入
     */
    @Bean(value = "user_3")
    public User user() {
        User user = new User();
        user.setUserid("userid");
        user.setUsername("username");
        user.setPassword("password");

        //显示装配
        user.setUser1(getUser1());

        return user;
    }


    @Bean("user1")
    public User1 getUser1(){
        return new User1();
    }

}
