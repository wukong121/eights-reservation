package com.bupt.eights.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
@Slf4j
public class Myadvice {
    
    @Pointcut("execution(int com.bupt.eights.service.LoginService.equals())")
    private void genericPointCut() {
    }
    
    @After("genericPointCut()")
    public void method() {
        log.info("New user created");
    }
    
}
