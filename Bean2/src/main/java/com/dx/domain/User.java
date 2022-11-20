package com.dx.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class User {
    private String userid;
    private String username;
    private String password;
    private User1 user1;

    public User() {
    }

    public User(String userid, String username, String password, User1 user1) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.user1 = user1;
        System.out.println("构造函数执行。。。。。。");
    }

    public User(String userId) {
        this.userid = userid;
    }

}
