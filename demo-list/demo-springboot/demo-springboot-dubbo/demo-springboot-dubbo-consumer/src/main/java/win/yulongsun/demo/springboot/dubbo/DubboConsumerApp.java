package win.yulongsun.demo.springboot.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sun.YuLong on 2018/4/12.
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApp.class, args);
    }
}
