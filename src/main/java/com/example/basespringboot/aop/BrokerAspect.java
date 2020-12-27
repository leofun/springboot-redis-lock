package com.example.basespringboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class BrokerAspect {
    @Pointcut("execution(public * com.example.basespringboot..*.*(..)))")
    public void BrokerAspect(){}

    @Before("BrokerAspect()")
    public void doBeforeGame(){
        //System.out.println("经纪人正在处理球星赛前事务！");
    }

    @Around("BrokerAspect()")
    public void doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        try{
            long before = System.currentTimeMillis();
            pjp.proceed();
            long after = System.currentTimeMillis();
            System.out.println("调用接口耗时时间为："+(after-before));
        }
        catch(Throwable e){
            System.out.println("异常通知：球迷要求退票！");
        }
    }

}
