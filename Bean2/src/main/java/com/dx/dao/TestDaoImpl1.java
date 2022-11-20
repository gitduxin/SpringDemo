package com.dx.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("testDaoImpl1")
@Qualifier("q1") //当该注解作用于类时,可以做为别名使用,当有多个相同名字的别名时,可以注入到集合字段中@Qualifier("q1")List<TestDao>
@Primary  //主要候选项
public class TestDaoImpl1 implements TestDao{
    @Override
    public void td() {
        System.out.println("TestDaoImpl1.td()......");
    }
}
