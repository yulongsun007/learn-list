package win.yulongsun.demo.springboot.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sun.YuLong on 2018/2/6.
 */
@Controller
public class UserController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
