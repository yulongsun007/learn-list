package win.yulongsun.demo.spring.core.aop.注解;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 注解方式实现AOP
 * @author Sun.YuLong on 2018/1/2.
 */
@Aspect
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
        return proceedingJoinPoint.proceed();
    }
}
