package win.yulongsun.demo.spring.core.aop;

import org.springframework.stereotype.Component;

/**
 * @author Sun.YuLong on 2018/3/15.
 */
@Component("userManagerImpl")
public class UserManagerImpl implements UserManager {
    @Override
    public String findUserById(Integer userId) {
        return "zhangsan";
    }
}
