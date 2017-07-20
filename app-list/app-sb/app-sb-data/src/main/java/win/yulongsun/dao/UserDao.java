package win.yulongsun.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import win.yulongsun.po.data.UserPO;

/**
 * Created by sunyl21830 on 2017/7/12.
 */
public interface UserDao extends MongoRepository<UserPO,String> {
}
