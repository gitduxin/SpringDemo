package com.dx.test;

import com.dx.config.SpringConfig2;
import com.dx.service.TestService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解注入
 */
public class Bean2_T3 {
    private static AnnotationConfigApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new AnnotationConfigApplicationContext(SpringConfig2.class);
    }


    @Test
    public void test1(){
        TestService testService = (TestService) ac.getBean("testService");
        testService.ts();
    }


    /**
     * 生命周期方法回调 springconfig2中配置
     */
    @Test
    public void test2(){
        TestService testService = (TestService) ac.getBean("testService1");
        System.out.println(testService.toString());
    }
}
