package com.shiweile;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    @Pointcut("execution(void com.shiweile.Dao.UserDao.update())")
    public void pt(){}

    @Around("pt()")
    public void Around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(String.class)){
                args[i]=args[i].toString().trim();
            }
        }

        Object proceed = pjp.proceed(args);

    }
}
