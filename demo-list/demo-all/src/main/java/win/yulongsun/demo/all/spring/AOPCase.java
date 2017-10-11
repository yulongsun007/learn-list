package win.yulongsun.demo.all.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Sun.YuLong on 2017/9/30.
 *
 * http://blog.csdn.net/xiaoxian8023/article/details/17258933
 *
 */
@Aspect
public class AOPCase {

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
        Object obj = proceedingJoinPoint.proceed();
        return obj;
    }

}
