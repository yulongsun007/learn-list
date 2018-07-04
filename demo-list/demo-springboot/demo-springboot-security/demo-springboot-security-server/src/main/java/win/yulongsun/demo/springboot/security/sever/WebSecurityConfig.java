package win.yulongsun.demo.springboot.security.sever;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 1. @EnableWebSecurity 作用：
     @Retention(RetentionPolicy.RUNTIME)
     @Target({ElementType.TYPE})
     @Documented
     @Import({WebSecurityConfiguration.class, SpringWebMvcImportSelector.class})
     @EnableGlobalAuthentication
     @Configuration
     public @interface EnableWebSecurity {
     boolean debug() default false;
     }

     - WebSecurityConfiguration : 配置web安全
     - SpringWebMvcImportSelector  ：
     - @EnableGlobalAuthentication :
         @Retention(RetentionPolicy.RUNTIME)
         @Target({ElementType.TYPE})
         @Documented
         @Import({AuthenticationConfiguration.class})
         @Configuration
         public @interface EnableGlobalAuthentication {
         }
         - AuthenticationConfiguration : 负责生成AuthenticationManager的生成


 *
 * 2. WebSecurityConfigurerAdapter 作用
      Adapter模式的体现。好处：选择性配置覆盖。


 * @author Sun.YuLong on 2018/7/4.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置HttpSecurity
     *
     * authorizeRequests：配置路径拦截
     * formLogin： 表单认证
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                //
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                //
                .logout().permitAll();

    }

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("admin");
    }
}
