package win.yulongsun.demo.hystrix;

import com.netflix.hystrix.*;

/**
 * @author Sun.YuLong on 2018/6/9.
 */
public class HelloWorldHystrixCommand extends HystrixCommand<String> {

    HelloWorldHystrixCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloWordGroup"))
        );
    }

    @Override
    protected String run() {
        return "hello world , i am sun";
    }
}
