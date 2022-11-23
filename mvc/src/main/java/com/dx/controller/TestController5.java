package com.dx.controller;

import com.dx.domain.User;
import com.dx.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

/**
 *SpringMessage
 */
@Controller
@RequestMapping("/tc5")
public class TestController5 {

    private TestService testService;
    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestBody User user){
        testService.updateUser(user);
        return "ok";
    }
}
