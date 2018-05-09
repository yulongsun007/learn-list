package win.yulongsun.demo.spring.di.scan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @author Sun.YuLong on 2018/5/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CustomBeanDefinitionRegistry.class})
public class CustomBeanDefinitionRegistryTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testAssertBean() {
        Assert.notNull(applicationContext.getBean(Foo.class));
        Foo bean = applicationContext.getBean(Foo.class);
        bean.say();
    }
}