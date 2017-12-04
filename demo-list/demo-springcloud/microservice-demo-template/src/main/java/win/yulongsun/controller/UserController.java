package win.yulongsun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import win.yulongsun.dao.UserRepository;
import win.yulongsun.entity.User;

import javax.annotation.Resource;

/**
 * @author sunyulong on 2017/6/5.
 */
@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;


    //GetMapping等价于@RequestMapping(method=RequestMethod.GET)
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.findOne(id);
    }

}
