package com.dx.controller;

import com.dx.domain.User;
import com.dx.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *@PathVariable 和 @MatrixVariable
 */
@Controller
@RequestMapping("/tc4")
public class TestController4 {

    private TestService testService;
    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(path = "/userid/{userid}",method = RequestMethod.GET)
    @ResponseBody
    public User t1(@PathVariable String userid){
        return testService.selectUser(userid);
    }

//    @RequestMapping(path = "/userid/{userid}/username/{username}",method = RequestMethod.GET)
//    @ResponseBody
//    public String t2(@PathVariable String userid, @PathVariable String username){
//        User user = testService.selectUser(userid);
//        user.setUsername(username);
//        testService.updateUser(user);
//        System.out.println(user);
//        return "ok";
//    }


    @RequestMapping(path = "/userid/{userid}/username/{username}",method = RequestMethod.GET)
    @ResponseBody
    public String t2(@PathVariable Map<String, String> values){
        User user = testService.selectUser(values.get("userid"));
        user.setUsername(values.get("username"));
        testService.updateUser(user);
        System.out.println(user);
        return "ok";
    }
}
