package spring.customer.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

/**
 * Created by SBTJavastudent on 20.10.2016.
 */
@Aspect
@Component
public class LoggingAspectExample {

    @After("execution(* spring.customer.CustomerService.getNameByID(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("logAfter");
    }
}
