package win.yulongsun.demo.spring.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sun.YuLong on 2018/3/13.
 */
public class BeanLifeCycleTest {


    @Test
    public void testBeanLifeCycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        BeanLifeCycle                  contextBean = context.getBean("beanLifeCycle", BeanLifeCycle.class);
    }


}