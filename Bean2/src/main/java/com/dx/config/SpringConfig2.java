package com.dx.config;

import com.dx.dao.TestDao;
import com.dx.dao.TestDaoImpl1;
import com.dx.dao.TestDaoImpl2;
import com.dx.service.TestService;
import com.dx.service.TestServiceImpl1;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfig2 {

    @Bean("testService")
    public TestService getTestService1(){
        return new TestServiceImpl1();
    }

    @Bean(value = "testService1",initMethod = "init",destroyMethod = "destory")
    public TestService getTestService2(){
        return new TestServiceImpl1();
    }

    @Bean("testDaoImpl1")
    @Qualifier("q1")
    @Primary
    public TestDao getTestDao1(){
        return new TestDaoImpl1();
    }

    @Bean("testDaoImpl2")
    @Qualifier("q1")
    public TestDao getTestDao2(){
        return new TestDaoImpl2();
    }

}
