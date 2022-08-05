package org.example.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author trinapal
 */

@Aspect
public class AfterAdvisor {

    @Pointcut("execution(* MethodBeforeAdviceTest.*(..))")
    public void testAfterMethod(){

    }

    /*@Pointcut("execution(*MethodBeforeAdviceTest.*(..)")
    public void myAfterAdvice(JoinPoint jp){
        System.out.println("after advise concern");
    }*/

    @After("testAfterMethod()")
    public void afterAdvise(JoinPoint jp){
        System.out.println("after advise test");
    }
}
