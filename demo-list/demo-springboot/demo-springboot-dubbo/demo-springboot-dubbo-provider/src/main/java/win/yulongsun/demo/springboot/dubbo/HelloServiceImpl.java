package win.yulongsun.demo.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import win.yulongsun.demo.springboot.dubbo.api.IHelloService;

/**
 * @author Sun.YuLong on 2018/4/12.
 */
@Service(interfaceClass = IHelloService.class)
@Component
public class HelloServiceImpl implements IHelloService {
    public String sayHello() {
        System.out.println("hello,I'm server");
        return "hello,I'm server";
    }
}
