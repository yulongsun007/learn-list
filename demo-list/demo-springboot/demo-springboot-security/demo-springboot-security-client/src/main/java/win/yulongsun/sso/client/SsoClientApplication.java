package win.yulongsun.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sun.YuLong on 2018/7/5.
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SsoClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(SsoClientApplication.class, args);
    }
}
