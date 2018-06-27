package win.yulongsun.demo.spring.di.annotation.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sun.YuLong on 2018/6/27.
 */
@Configuration
public class ConfigurationContainer {
    public ConfigurationContainer() {
        System.out.println("configuration test container start");
    }


    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContainer.class);
        
    }
}
