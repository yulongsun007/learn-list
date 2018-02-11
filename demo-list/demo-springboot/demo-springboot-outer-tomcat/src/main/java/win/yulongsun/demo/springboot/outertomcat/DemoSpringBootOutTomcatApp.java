package win.yulongsun.demo.springboot.outertomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Sun.YuLong on 2018/2/11.
 */
@SpringBootApplication
public class DemoSpringBootOutTomcatApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoSpringBootOutTomcatApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootOutTomcatApp.class, args);
    }
}
