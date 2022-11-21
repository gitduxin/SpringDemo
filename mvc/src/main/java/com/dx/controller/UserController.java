package com.dx.controller;

import com.dx.domain.User;
import com.dx.service.TestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.java2d.pipe.SpanIterator;

@Controller
public class UserController {

    private TestService testService;
    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

//    @PostMapping("/login")
//    public String login(@RequestParam("username")String username, @RequestParam("password")String password){
//        User user = testService.selectUser(username);
//        System.out.println(user);
//        if(null != user){
//            if(password.equals(user.getPassword())){
//                return "success";
//            }
//                return "404";
//        }else {
//            return "500";
//        }
//
//    }

    /**
     * ModelAttribute 作用于方法时,当前controller的每一次请求都将触发该方法
     * 该方法都返回值将自动存入model中
     */
//    @ModelAttribute
//    public User getB(@RequestParam("username") String userid) {
//        return testService.selectUser(userid);
//    }

    /**
     * ModelAttribute 作用于参数时，将自动绑定model中存入的值，且将参数替换为请求参数的值
     * 如果model中没有该值，则根据请求参数自动创建该值并绑定到方法参数中
     */
//    @PostMapping("/login")
//    @ResponseBody
//    public String login(@ModelAttribute("user")User user){
//        System.out.println(user.toString());
//        return "ok";
//    }

}
