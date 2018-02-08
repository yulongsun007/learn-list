package win.yulongsun.demo.springboot.test.repository;

import org.springframework.data.repository.CrudRepository;
import win.yulongsun.demo.springboot.test.pojo.dto.UserDto;

/**
 * @author Sun.YuLong on 2018/2/8.
 */
public interface UserInfoRepository extends CrudRepository<UserDto,Integer> {
}
