package win.yulongsun.app.sb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import win.yulongsun.app.sb.po.data.UserPO;

/**
 * Created by sunyl21830 on 2017/7/12.
 */
public interface UserDao extends MongoRepository<UserPO,String> {
}
