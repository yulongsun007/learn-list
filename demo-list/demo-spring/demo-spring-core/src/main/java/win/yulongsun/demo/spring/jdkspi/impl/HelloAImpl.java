package win.yulongsun.demo.spring.jdkspi.impl;

import win.yulongsun.demo.spring.jdkspi.spi.HelloSPIInterface;

/**
 * @author Sun.YuLong on 2018/1/4.
 */
public class HelloAImpl implements HelloSPIInterface {

    @Override
    public void sayHello() {
        System.out.printf("say a");
    }
}
