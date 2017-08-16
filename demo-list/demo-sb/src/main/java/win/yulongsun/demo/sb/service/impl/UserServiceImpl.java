package win.yulongsun.demo.sb.service.impl;

import org.springframework.stereotype.Service;
import win.yulongsun.demo.sb.pojo.User;
import win.yulongsun.demo.sb.repository.UserRepository;
import win.yulongsun.demo.sb.service.UserService;

import javax.annotation.Resource;

/**
 * Created by sunyl21830 on 2017/7/11.
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserRepository userRepository;

    @Override
    public void insertUser(User user) {
        userRepository.insert(user);
    }

    @Override
    public void deleteUser(String uuid) {
        userRepository.delete(uuid);
    }
}
