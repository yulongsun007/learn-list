package win.yulongsun.demo.springboot.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sun.YuLong on 2018/2/9.
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApp.class, args);
    }
}
