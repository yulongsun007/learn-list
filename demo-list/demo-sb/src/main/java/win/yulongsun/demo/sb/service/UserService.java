package win.yulongsun.demo.sb.service;

import win.yulongsun.demo.sb.pojo.User;

/**
 * Created by sunyl21830 on 2017/7/11.
 */
public interface UserService {

    void insertUser(User user);

    void deleteUser(String uuid);
}
