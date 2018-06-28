package win.yulongsun.demo.springboot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sun.YuLong on 2018/6/28.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("index")
    public String index() {
        return "index()";
    }
}
