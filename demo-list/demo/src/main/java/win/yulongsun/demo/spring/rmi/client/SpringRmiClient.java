package win.yulongsun.demo.spring.rmi.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import win.yulongsun.demo.spring.rmi.server.IHelloWorld;

/**
 * @author Sun.YuLong on 2017/12/26.
 */
public class SpringRmiClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context            = new ClassPathXmlApplicationContext("spring-client.xml");
        IHelloWorld                    sayHelloServiceRmi = context.getBean("sayHelloServiceRmi", IHelloWorld.class);
        System.out.println(sayHelloServiceRmi.sayHelloToSomeBody("sunyulong"));
        System.out.println(sayHelloServiceRmi.helloWorld());
    }
}
