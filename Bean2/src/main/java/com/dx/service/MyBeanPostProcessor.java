package com.dx.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if(beanName.equals("testService")){
           System.out.println("testService初始化之前");
       }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("testService")){
            System.out.println("testService初始化之后");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
