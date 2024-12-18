package com.example.lab5second.aspects;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HouseholdAspects {

    @Before("execution(* com.example.lab5second.services.*.*(..))")
    public void logBefore() {
        System.out.println("Before Method: Method execution is about to begin...");
    }

    @After("execution(* com.example.lab5second.services.*.*(..))")
    public void logAfter() {
        System.out.println("After Method: Method execution has completed.");
    }

    @AfterThrowing(value = "execution(* com.example.lab5second.services.*.*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("After Throwing: Exception occurred - " + exception.getMessage());
    }
}
