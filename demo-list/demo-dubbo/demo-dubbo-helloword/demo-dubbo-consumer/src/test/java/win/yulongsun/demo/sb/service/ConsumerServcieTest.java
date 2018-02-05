package win.yulongsun.demo.sb.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import win.yulongsun.demo.dubbo.TestService;

import java.io.IOException;

/**
 * @author by sunyulong on 2016/12/29.
 */
public class ConsumerServcieTest {

    public static void main(String args[]) {
        ClassPathXmlApplicationContext context     = new ClassPathXmlApplicationContext(new String[]{"app.xml"});
        TestService                    testService = (TestService) context.getBean("testService");
        System.out.println(testService.getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
