package win.yulongsun.demo.spring.di;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Sun.YuLong on 2018/4/18.
 */
public class BeanFactoryTest {

    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("spring.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        factory.getBean("beanFactoryTest");
    }


//    @Test
    public void testBeanLifeCycle(){

    }
}
