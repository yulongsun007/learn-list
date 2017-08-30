package win.yulongsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceProUserMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProUserMovieApplication.class, args);
	}
}
