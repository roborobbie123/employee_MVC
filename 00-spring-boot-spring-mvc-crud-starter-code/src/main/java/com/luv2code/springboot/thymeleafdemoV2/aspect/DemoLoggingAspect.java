package com.luv2code.springboot.thymeleafdemoV2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemoV2.controller.*.*.(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemoV2.service.*.*.(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemoV2.dao.*.*.(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAllPackages() {}

    @Before("forAllPackages()")
    public void beforeAllPackages(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        logger.info(methodName + ": " + joinPoint.getArgs());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("=========> Argument: " + arg);
            System.out.println("=========> Argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAllPackages()",
    returning="result")
    public void afterAllPackages(JoinPoint joinPoint, Object result) {

        String methodName = joinPoint.getSignature().getName();
        logger.info("========> @AfterReturning: from method " + methodName);
        System.out.println("=========> Result: " + result);



    }
}


