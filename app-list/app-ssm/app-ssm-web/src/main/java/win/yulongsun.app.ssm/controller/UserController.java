package win.yulongsun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import win.yulongsun.bo.param.UserBOParam;
import win.yulongsun.demo.sb.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunyulong on 2017/1/10.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = {"/"})
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        UserBOParam param = new UserBOParam();
        param.setAccount("123");
        param.setPassword("123");
        userService.login(param);

        return "index/index";
    }
}
