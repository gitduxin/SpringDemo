package com.dx.controller;

import com.dx.domain.User;
import com.dx.domain.User2;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 数据绑定
 */
@Controller
public class TestController2 {

    /**
     * 自定义类型转换
     * @param webDataBinder
     */
    @InitBinder
    public void bind1(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new MyValidator());

        webDataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
//        webDataBinder.registerCustomEditor(Date.class,
//                new MyDatePropertyEditor("yyyy-MM-dd"));
    }

    /**
     *  BindingResult 用于检测参数绑定过程中是否有异常
     *  如果定义了多个模型绑定参数@RequestParam、@ModelAttribute时，每个绑定参数后面应跟着一个BindingResult
     *  例子：@ModelAttribute Date a,BindingResult aresult,@ModelAttribute Date b,BindingResult bresult
     *
     *  对于请求参数写在url上时，请求参数可以转换成java对象
     */
    @PostMapping("tc2_1")
    @ResponseBody
    public User2 getUser2(@Validated User2 user2, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors().get(0).getDefaultMessage());
            return new User2();
        }
        return user2;
    }

    /**
     * 属性名绑定：请求参数和方法参数相同时，可以自动绑定
     */
    @PostMapping("tc2_2")
    @ResponseBody
    public String getValue1(int a, double b, String c, Date d){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        return "ok";
    }

    @PostMapping("tc2_3")
    @ResponseBody
    public String getValue2(@RequestParam Map<String,Object> map){
        System.out.println(map);
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println(map.get("d"));
        return "ok";
    }

}
