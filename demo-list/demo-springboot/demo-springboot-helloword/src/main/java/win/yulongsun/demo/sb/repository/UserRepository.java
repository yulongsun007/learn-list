package win.yulongsun.demo.sb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import win.yulongsun.demo.sb.pojo.User;

/**
 * Created by sunyl21830 on 2017/7/11.
 */
public interface UserRepository extends MongoRepository<User,String>{
}
