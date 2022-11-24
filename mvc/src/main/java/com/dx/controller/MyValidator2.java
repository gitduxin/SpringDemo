package com.dx.controller;

import com.dx.domain.User;
import com.dx.domain.User2;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 数据校验
 * 可以显示调用 new MyValidator().validate(Object target, Errors errors)
 * 可以将此Validator注册到WebDataBinder中，并使用@Validated和@Valid注释
 */
public class MyValidator2 implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if("".equals(user.getUserid()) || "".equals(user.getUsername()) || "".equals(user.getPassword())){
            errors.reject("500","用户字段不能为空");
        }
    }
}
