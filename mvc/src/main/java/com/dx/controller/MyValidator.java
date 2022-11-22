package com.dx.controller;

import com.dx.domain.User2;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;

/**
 * 数据校验
 * 可以显示调用 new MyValidator().validate(Object target, Errors errors)
 * 可以将此Validator注册到WebDataBinder中，并使用@Validated和@Valid注释
 */
public class MyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User2.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User2 user2 = (User2) target;
//        System.out.println("MyValidator...........");
        if("3".equals(user2.getC())){
            errors.reject("500","字段c到值不能为3");
        }
    }
}
