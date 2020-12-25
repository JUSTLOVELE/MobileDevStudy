package com.example.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogService {

    @Pointcut("execution(** com.example.action.HelloAction.aspectTestCase01())")
    public void aspectTestCase01PointCut() {

    }

    //启用这个around就不用下面的了
//    @Around("aspectTestCase01PointCut()")
//    public void around(ProceedingJoinPoint joinPoint) {
//        System.out.println(joinPoint.getKind());
//    }

    @AfterThrowing("aspectTestCase01PointCut()")
    public void afterThrow() {
        System.out.println("afterThrow");
    }

    @AfterReturning("aspectTestCase01PointCut()")
    public void afterReturn() {
        System.out.println("afterReturning");
    }

    @After("aspectTestCase01PointCut()")
    public void afteraspectTestCase01() {
        System.out.println("afteraspectTestCase01");
    }

    @Before("execution(** com.example.action.HelloAction.aspectTestCase01())")
    public void beforeAspectTestCase01() {
        System.out.println("beforeAspectTestCase01");
    }
}
