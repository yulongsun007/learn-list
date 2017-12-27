package win.yulongsun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import win.yulongsun.entity.User;

import javax.annotation.Resource;

/**
 * @author sunyulong on 2017/6/6.
 */
@RestController
public class MovieController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("user/{id}")
    public User findById(@PathVariable long id) {
        return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    }
}
