package win.yulongsun.demo.spring.di.profile;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * @author Sun.YuLong on 2018/6/27.
 */
@Configurable
public class ProfileTest {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProfileTest.class);
        System.out.println(Arrays.asList(context.getBeanNamesForType(String.class)));
    }


    @Profile("dev")
    @Bean
    public String dev() {
        return "dev";
    }

    @Profile("test")
    @Bean
    public String test() {
        return "test";
    }

    public String defaultStr() {
        return "defaultStr";
    }

}
