package win.yulongsun.demo.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @SpringBootApplication 注解等价于
 * 默认属性使用@Configuration+@EnableAutoConfiguration+@ComponentScan
 */
@SpringBootApplication()
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoSbApplication {

    public static void main(String[] args) {

//        System.setProperty("spring.devtools.restart.enabled", "false");//关闭自动重启
        SpringApplication.run(DemoSbApplication.class, args);
    }
}
