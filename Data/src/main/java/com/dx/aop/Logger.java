package com.dx.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 通知类
 */
@Repository
public class Logger{
    public void before(){
        System.out.println("before..............");
    }

    public void after(){
        System.out.println("after..............");
    }

    public void exception(){
        System.out.println("exception..............");
    }

    public void finaly(){
        System.out.println("finaly..............");
    }

    public void around(ProceedingJoinPoint pjc ){
        try{
            System.out.println("before..............");
            pjc.proceed();
            System.out.println("after..............");
        }catch (Throwable e) {
            e.printStackTrace();
            System.out.println("exception..............");
        }finally {
            System.out.println("finaly..............");
        }
    }

}
