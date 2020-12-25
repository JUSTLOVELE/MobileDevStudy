package com.example.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogService {

    /**
     * 切面这个helloaction的所有方法
     */
    @Pointcut("within(com.example.action.HelloAction)")
    public void aspectHelloAction() {

    }

    @Around("aspectHelloAction()")
    public Object aroundaspectHelloAction(ProceedingJoinPoint joinPoint){

        try {
            System.out.println("around:" + joinPoint.getKind());
            return joinPoint.proceed();
        }catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
//    //匹配标注有AdminOnly注解的方法
//    @Pointcut("@annotation(com.aop.annotation.AdminOnly)")
//    public void matchAnno() {}

//    //匹配com.aop.service包及其子包下所有类的方法
//    @Pointcut("within(com.aop.service..*)")
//    public void matchPackage() {}
//
//    //匹配AOP对象的目标对象为指定类型的方法，即ProductServiceImpl的aop代理对象的方法
//    @Pointcut("this(com.aop.service.impl.ProductServiceImpl)")
//    public void matchThis() {}
//
//    //匹配实现ProductService接口的目标对象
//    @Pointcut("target(com.aop.service.ProductService)")
//    public void matchTarget() {}
//
//    //匹配所有以Service结尾的bean里面的方法
//    @Pointcut("bean(*Service)")
//    public void matchBean() {}
//
//    //匹配第一个参数为Long类型的方法
//    @Pointcut("args(Long, ..) ")
//    public void matchArgs() {}
//
//    //匹配标注有Beta的类底下的方法，要求annotation的Retention级别为CLASS
//    @Pointcut("@within(com.google.common.annotations.Beta)")
//    public void matchWithin() {}
//
//    //匹配标注有Repository的类底下的方法，要求annotation的Retention级别为RUNTIME
//    @Pointcut("@target(org.springframework.stereotype.Repository)")
//    public void matchTarget() {}
//
//    //匹配传入的参数类标注有Repository注解的方法
//    @Pointcut("@args(org.springframework.stereotype.Repository)")
//    public void matchArgs() {}

// ---------------------------------------------------------------------------------------

//    @Pointcut("execution(** com.example.action.HelloAction.aspectTestCase01())")
//    public void aspectTestCase01PointCut() {
//
//    }

    //启用这个around就不用下面的了
//    @Around("aspectTestCase01PointCut()")
//    public void around(ProceedingJoinPoint joinPoint) {
//        System.out.println(joinPoint.getKind());
//    }

//    @AfterThrowing("aspectTestCase01PointCut()")
//    public void afterThrow() {
//        System.out.println("afterThrow");
//    }
//
//    @AfterReturning("aspectTestCase01PointCut()")
//    public void afterReturn() {
//        System.out.println("afterReturning");
//    }
//
//    @After("aspectTestCase01PointCut()")
//    public void afteraspectTestCase01() {
//        System.out.println("afteraspectTestCase01");
//    }
//
//    @Before("execution(** com.example.action.HelloAction.aspectTestCase01())")
//    public void beforeAspectTestCase01() {
//        System.out.println("beforeAspectTestCase01");
//    }
}
