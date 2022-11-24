package com.dx.controller;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.dx.domain.User;
import com.dx.domain.User2;
import com.dx.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * RestFul Web
 */
@Controller
@RequestMapping("/tc3_1")
public class TestController3 {

    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    /**
     * 自定义类型转换
     */
    @InitBinder
    public void bind1(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new MyValidator2());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(){
       List<User> list = testService.selectUsers();
       if(null == list){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
       return ResponseEntity.ok(list);
   }

    @RequestMapping(method = RequestMethod.GET,params = "userid")
    public ResponseEntity<User> getUser(@RequestParam("userid") String userid){
        User user = testService.selectUser(userid);
        if(null == user){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(user);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<String> insertUser(@Valid User user, BindingResult result){
//        if(result.hasErrors()){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result.getAllErrors().get(0).getDefaultMessage());
//        }
//        testService.insertUser(user);
//        return ResponseEntity.ok("用户信息已添加");
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> insertUser(@Valid User user,BindingResult result){
       if(result.hasErrors()){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(result.getAllErrors().get(0).getDefaultMessage());
       }
            testService.insertUser(user);
       return ResponseEntity.ok("添加成功");
    }

}
