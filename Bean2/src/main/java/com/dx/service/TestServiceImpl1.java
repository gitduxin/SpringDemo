package com.dx.service;


import com.dx.dao.TestDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
@Data
public class TestServiceImpl1 implements TestService {

    /**
     * 字段注入
     * Autowired 按照类型匹配 有且仅有一个匹配 则匹配成功,没有或者多个匹配失败
     * Qualifier 在按照类型匹配基础上,在按照名称进行匹配 有且仅有一个匹配 则匹配成功,没有或者多个匹配失败
     */
//    @Autowired
//    @Qualifier("testDaoImpl1")
//    private TestDao testDao;

    //set方法注入
    private TestDao testDao;
    @Autowired
    public void setTestDao( @Qualifier("testDaoImpl1")TestDao testDao) {
        this.testDao = testDao;
    }

    //构造函数注入
//    private TestDao testDao;
//    @Autowired
//    public TestServiceImpl1(@Qualifier("q1") TestDao testDao) {
//        this.testDao = testDao;
//    }

    private List<TestDao> testDaos;
    @Autowired
    public void setTestDaos(@Qualifier("q1") List<TestDao> testDaos) {
        this.testDaos = testDaos;
    }

    @Override
    public void ts() {
        System.out.println("TestServiceImpl1.ts()......");
        testDao.td();
    }

    @Override
    public void init() {
        System.out.println("TestService init.............");
    }

    @Override
    public void destory() {
        System.out.println("TestService destory.............");
    }
}
