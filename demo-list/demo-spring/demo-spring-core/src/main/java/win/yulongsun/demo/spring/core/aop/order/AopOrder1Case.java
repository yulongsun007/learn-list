package win.yulongsun.demo.spring.core.aop.order;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Sun.YuLong on 2018/3/16.
 */
@Aspect
@Order(1)
@Component
public class AopOrder1Case {
}
