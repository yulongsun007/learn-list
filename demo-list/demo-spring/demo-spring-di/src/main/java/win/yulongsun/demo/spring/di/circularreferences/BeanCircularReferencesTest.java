package win.yulongsun.demo.spring.di.circularreferences;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sun.YuLong on 2018/6/26.
 */
public class BeanCircularReferencesTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-circular-references.xml");
    }
}
