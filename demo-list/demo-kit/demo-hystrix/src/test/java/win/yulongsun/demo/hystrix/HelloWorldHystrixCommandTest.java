package win.yulongsun.demo.hystrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sun.YuLong on 2018/6/9.
 */
public class HelloWorldHystrixCommandTest {


    @Test
    public void test() {
        HelloWorldHystrixCommand hystrix      = new HelloWorldHystrixCommand();
        String                   commandGroup = hystrix.getCommandGroup().name();
        Assert.assertEquals("helloWordGroup", commandGroup);
        //
        String result = hystrix.execute();
        Assert.assertEquals("hello world , i am sun", result);
    }
}