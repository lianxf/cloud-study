package cn.lianxf.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @className LogAspect
 * @description Log 切面
 * @date 2021/8/12 下午11:32
 * @author little
 * @version 1.0.0
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(public * cn.lianxf.cloud.controller.*.*(..))")
    public void logPointCut(){
    }


    @Before("logPointCut()")
    public void before() {
        log.info("-------------before--------------");
    }

    @After("logPointCut()")
    public void after() {
        log.info("-------------after--------------");
    }

}
