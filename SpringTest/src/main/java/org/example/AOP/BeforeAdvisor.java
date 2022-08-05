package org.example.AOP;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author trinapal
 */

@Aspect
public class BeforeAdvisor {

    @Pointcut("execution(* MethodBeforeAdviceTest.*(..))")
    public void testMethod(){

    }

    @Before("testMethod()")//applying pointcut on before advice
    public void myadvice(JoinPoint jp)//it is advice (before advice)
    {
        System.out.println("additional concern");
        //System.out.println("Method Signature: "  + jp.getSignature());
    }
}
