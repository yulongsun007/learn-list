//package win.yulongsun.demo.springboot.dubbo;
//
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import org.junit.Test;
//import org.springframework.stereotype.Component;
//import win.yulongsun.demo.springboot.dubbo.api.IHelloService;
//
///**
// * @author Sun.YuLong on 2018/4/12.
// */
//@Component
//public class HelloConsumerTest extends BaseTest{
//
//    @Reference(version = "1.0.0",application = "${dubbo.application.id}",url = "dubbo://127.0.0.1:20880")
//    private IHelloService iHelloService;
//    @Test
//    public void testSay() {
//        iHelloService.sayHello();
//    }
//}