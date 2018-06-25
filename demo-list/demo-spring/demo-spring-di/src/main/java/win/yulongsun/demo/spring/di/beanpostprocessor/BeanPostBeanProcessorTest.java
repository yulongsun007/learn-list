package win.yulongsun.demo.spring.di.beanpostprocessor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sun.YuLong on 2018/6/25.
 */
public class BeanPostBeanProcessorTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-post-processor.xml");
        context.getBean("testBean");
    }
}
