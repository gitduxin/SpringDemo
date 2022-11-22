package com.dx.controller;

import com.dx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * model modelmap modelandview
 * @SessionAttributes 可以将指定类型或者指定属性名称的属性 从model modmap,modelandview中拷贝进session中
 * 但方法存在@ResponseBody时,无法@SessionAttributes的效果将失效.
 *
 * @SessionAttribute 可以将session域中的属性绑定到方法参数上
 *
 */
@SessionAttributes(value = {"user"})
@Controller
public class TestController1 {


    @RequestMapping("/tc1_1")
    public String setUser(Model model){
        User user = new User();
        user.setUserid("909090");
        user.setUsername("testname");
        user.setPassword("testpassword");
        model.addAttribute("user",user);
        System.out.println(user.toString());
        return "success";
    }

//    @RequestMapping("/tc1_1")
//    public ModelAndView setUser(ModelAndView model){
//        User user = new User();
//        user.setUserid("909090");
//        user.setUsername("testname");
//        user.setPassword("testpassword");
//        model.addObject("user",user);
//        model.setViewName("success");
//        return model;
//    }

    @RequestMapping("/tc1_2")
    @ResponseBody
    public String getUser1(HttpSession session){
        System.out.println(((User)session.getAttribute("user")).toString());
        return "success";
    }

    @RequestMapping("/tc1_3")
    @ResponseBody
    public String getUser2(Model model){
        User user = (User) model.getAttribute("user");
        System.out.println(user.toString());
        return "success";
    }

    @RequestMapping("/tc1_4")
    @ResponseBody
    public String getUser3(@ModelAttribute("user") User user){
        System.out.println(user.toString());
        return "success";
    }

    @RequestMapping("/tc1_5")
    @ResponseBody
    public String getUser4(@SessionAttribute("user") User user){
        System.out.println(user.toString());
        return "success";
    }

    @RequestMapping("/test6")
    @ResponseBody
    public String getUser5(ModelMap map){
        User user = (User) map.getAttribute("user");
        System.out.println(user.toString());
        return "success";
    }
}
