package win.yulongsun.demo.spring.rmi.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sun.YuLong on 2017/12/26.
 */
public class SpringRmiServer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-server.xml");
        System.out.println("server start");
    }
}
