package win.yulongsun.demo.cloud.template.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import win.yulongsun.demo.cloud.template.entity.User;

/**
 * @author sunyulong on 2017/6/5.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
