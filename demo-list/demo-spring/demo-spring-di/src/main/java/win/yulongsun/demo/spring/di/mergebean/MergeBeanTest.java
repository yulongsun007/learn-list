package win.yulongsun.demo.spring.di.mergebean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sun.YuLong on 2018/6/27.
 */
public class MergeBeanTest {
    /**
     *     <bean id="beanA" class="win.yulongsun.demo.spring.di.mergebean.BeanA">
     *         <property name="name" value="root"/>
     *     </bean>
     *
     *     <bean id="beanB" parent="beanA">
     *         <property name="name" value="child"/>
     *     </bean>
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-merge-bean.xml");
        System.out.println("root::" + context.getBean("beanA"));
        System.out.println("child::" + context.getBean("beanB"));
        /**
         * root::BeanA{name='root'}
         * child::BeanA{name='child'}
         */
    }
}
