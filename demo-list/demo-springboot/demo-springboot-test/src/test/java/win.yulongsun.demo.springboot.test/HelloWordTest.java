package win.yulongsun.demo.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.yulongsun.demo.springboot.test.service.TestService;

import javax.annotation.Resource;

/**
 * 1、@RunWith(SpringRunner)：运行Junit并支持Spring-Test特性.
 * 2、@SpringBootTest：为SpringApplication创建上下文并支持SpringBoot特性.
 *      (webEnvironment=WebEnvironment.RANDOM_PORT)
 *
 * 3、@SpringApplicationConfiguration(classes=SpringBootApplication.class):
 * 4、@WebApplication: 因为Web项目需要模拟ServletContext,所以需要加上WebApplication.
 *
 * @author Sun.YuLong on 2018/2/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWordTest {

    @Resource
    TestService testService;

    @Test
    public void testService() {
        Assert.assertEquals("testService", testService.testService());
    }


}
