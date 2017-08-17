package win.yulongsun.mapper;

import win.yulongsun.po.data.UserPO;
import win.yulongsun.po.request.UserPORequest;

import java.util.List;

/**
 * @author sunyulong on 2017/1/11.
 */
public interface UserMapper {

    int insert(UserPO userPO);

    int update(UserPO userPO);

    List<UserPO> queryByRequest(UserPORequest request);

    int delete(Integer id);

}
