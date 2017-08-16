package win.yulongsun.demo.dubbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import win.yulongsun.demo.dubbo.TestService;

/**
 * Created by sunyl21830 on 2017/7/21.
 */
public class RestController {

    @Autowired
    TestService testService;

}
