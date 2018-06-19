package win.yulongsun.demo.spring.di.bean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sun.YuLong on 2018/6/19.
 */
public class BeanTest {

    private ClassPathXmlApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-bean.xml");
    }


    /**
     * Spring创建单例Bean
     * <p>
     * scope="singleton"
     */
    @Test
    public void testSpringSingleton() {
        System.out.println(context.getBean("bean"));
        System.out.println(context.getBean("bean"));
        /**
         * win.yulongsun.demo.spring.di.bean.Bean@63753b6d
         * win.yulongsun.demo.spring.di.bean.Bean@63753b6d
         */
    }

    /**
     * scope="prototype"
     */
    @Test
    public void testSpringSinnleton2() {
        System.out.println(context.getBean("bean2"));
        System.out.println(context.getBean("bean2"));
        /**
         * win.yulongsun.demo.spring.di.bean.Bean@370736d9
         * win.yulongsun.demo.spring.di.bean.Bean@5f9d02cb
         */
    }


}
