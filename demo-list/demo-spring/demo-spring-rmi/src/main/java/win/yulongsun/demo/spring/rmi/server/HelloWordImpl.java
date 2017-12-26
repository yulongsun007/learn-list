package win.yulongsun.demo.spring.rmi.server;

/**
 * @author Sun.YuLong on 2017/12/26.
 */
public class HelloWordImpl implements IHelloWorld {

    public String helloWorld() {
        return "helloworld";
    }

    public String sayHelloToSomeBody(String someBody) {
        return "hellowrold:" + someBody;
    }
}
