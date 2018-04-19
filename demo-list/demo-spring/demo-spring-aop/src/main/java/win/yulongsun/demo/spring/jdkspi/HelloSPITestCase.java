package win.yulongsun.demo.spring.jdkspi;

import win.yulongsun.demo.spring.jdkspi.spi.HelloSPIInterface;

import java.util.ServiceLoader;

/**
 * @author Sun.YuLong on 2018/1/4.
 */
public class HelloSPITestCase {

    public static void main(String[] args) {
        ServiceLoader<HelloSPIInterface> helloSPIInterfaces = ServiceLoader.load(HelloSPIInterface.class);
        for (HelloSPIInterface item : helloSPIInterfaces) {
            item.sayHello();
        }
    }
}
