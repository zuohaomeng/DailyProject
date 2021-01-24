package com.meng.daily.javabase.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ZuoHao
 * @date 2021/1/20
 */
@Component
@Aspect
public class MyAnnotationAspect {
    /**
     * AspectServiceImpl类下的任何方法
     */
    @Pointcut("execution(* com.meng.daily.javabase.service.impl.AspectServiceImpl.*(..))")
    public void pointcut(){}


    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("afterReturn");
    }
    @AfterThrowing(value = "pointcut()",throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex){
        System.out.println("afterThrow");
        System.out.println(ex.getMessage());
    }

    @Around("pointcut()")
    public Object around(JoinPoint joinPoint){
        System.out.println("around start");
        Object proceed = null;
        try {
            proceed = ((ProceedingJoinPoint)joinPoint).proceed(joinPoint.getArgs());
        }catch (Throwable e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println(e);
        }
        System.out.println("around end");
        return proceed;
    }
}
