package com.dx.test;

import com.dx.config.SpringConfig2;
import com.dx.service.TestService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean后置处理器
 */
public class Bean2_T4 {
    private static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("classpath:application.xml");
    }

    @Test
    public void test1(){
        TestService testService = (TestService) ac.getBean("testService");
        testService.ts();
    }

}
