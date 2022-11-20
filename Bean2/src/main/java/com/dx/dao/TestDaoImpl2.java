package com.dx.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("testDaoImpl2")
@Qualifier("q1") //当该注解作用于类时,可以做为别名使用,当有多个相同名字的别名时,可以注入到集合字段中@Qualifier("q1")List<TestDao>
public class TestDaoImpl2 implements TestDao{
    @Override
    public void td() {
        System.out.println("TestDaoImpl2.td()......");
    }
}
