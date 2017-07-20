package win.yulongsun.dao;

import org.springframework.stereotype.Repository;
import win.yulongsun.po.data.UserPO;
import win.yulongsun.po.request.UserPORequest;
import win.yulongsun.po.result.UserPOResult;

/**
 * @author sunyulong on 2017/1/10.
 */
@Repository
public interface UserDao {


    UserPOResult insert(UserPO userPO);


    UserPOResult queryByRequest(UserPORequest request);


    UserPOResult update(UserPO userPO);


    UserPOResult deleteById(Integer id);
}
