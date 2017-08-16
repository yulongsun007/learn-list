package win.yulongsun.demo.sb.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.yulongsun.demo.sb.pojo.User;
import win.yulongsun.demo.sb.service.impl.UserServiceImpl;

import javax.annotation.Resource;

/**
 * Created by sunyl21830 on 2017/7/11.
 */
@RestController
public class DemoController {

    @Resource
    UserServiceImpl userService;

    @RequestMapping("/add")
    public void addUser() {
        User user = new User();
        user.setName("123");
        userService.insertUser(user);
    }


}
