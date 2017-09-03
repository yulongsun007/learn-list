package win.yulongsun.demo.sb.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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


    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file) {
//        System.out.println(file.getName());
//        System.out.println(file.getOriginalFilename());
        return "SUCCESS";
    }
}
