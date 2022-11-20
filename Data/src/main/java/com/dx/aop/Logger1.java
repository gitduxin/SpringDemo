package com.dx.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 通知类
 */
@Repository
@Aspect
public class Logger1 {

//    @Pointcut("execution(* com.dx.service.TestServiceImpl2.*(..))")
//    public void point1() {
//    }

    @Pointcut("@annotation(RequiredLog)")
    public void point1() {
    }

    @Before("point1()")
    public void before(JoinPoint point){
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        System.out.println("类名:"+className);
        System.out.println("方法名:"+methodName);
        System.out.println("before..............");
    }
//
//    @After("point1()")
//    public void after(){
//        System.out.println("after..............");
//    }
//
//    @AfterThrowing("point1()")
//    public void exception(){
//        System.out.println("exception..............");
//    }
//
//    @AfterReturning("point1()")
//    public void finaly(){
//        System.out.println("finaly..............");
//    }


//    @Around("point1()")
//    public Object around(ProceedingJoinPoint pjc ){
//        Object object = null;
//        try{
//            System.out.println("before..............");
//            object =  pjc.proceed();
//            System.out.println("after..............");
//        }catch (Throwable e) {
//            e.printStackTrace();
//            System.out.println("exception..............");
//        }finally {
//            System.out.println("finaly..............");
//        }
//
//        return object;
//    }

}
