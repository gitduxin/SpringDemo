package com.dx.controller;

import com.dx.domain.User;
import com.dx.service.TestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private TestService testService;
    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@Param("username")String username,@Param("password")String password){
        User user = testService.selectUser(username);
        if(null != user){
            if(password.equals(user.getPassword())){
                return "success";
            }
                return "404";
        }else {
            return "500";
        }

    }
}
