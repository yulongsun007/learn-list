package win.yulongsun.demo.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import win.yulongsun.demo.springboot.dubbo.api.IHelloService;

/**
 * @author Sun.YuLong on 2018/4/12.
 */
@Controller
@RequestMapping(value = "/consumer")
public class HelloConsumer {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private IHelloService iHelloService;

    @RequestMapping(value = "/say")
    public String consumerSay() {
        System.out.println("consumer say");
        return iHelloService.sayHello();
    }
}
