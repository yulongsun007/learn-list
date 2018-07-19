package win.yulongsun.demo.springboot.feature;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sun.YuLong on 2018/7/19.
 */
@SpringBootApplication
public class DemoSpringBootFeatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootFeatureApplication.class,args);
    }
}
