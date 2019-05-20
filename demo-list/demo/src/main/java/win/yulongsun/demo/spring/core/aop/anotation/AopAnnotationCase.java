package win.yulongsun.demo.spring.core.aop.anotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 注解方式实现AOP
 *
 * @author Sun.YuLong on 2018/1/2.
 */
@Aspect
@Component
public class AopAnnotationCase {
    @Pointcut("execution(* find*(..))")
    private void aspectjMethod() {
    }

    @Before("aspectjMethod()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("beforeAdvice");
    }

    @After("aspectjMethod()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("afterAdvice");
    }

    @Around("aspectjMethod()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        proceedingJoinPoint.getArgs();

        return proceedingJoinPoint.proceed();
    }
}
