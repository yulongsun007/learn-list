package win.yulongsun.demo.springboot.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sun.YuLong on 2018/2/6.
 */
@RestController
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
