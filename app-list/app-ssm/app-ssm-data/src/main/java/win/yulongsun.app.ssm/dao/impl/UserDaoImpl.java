package win.yulongsun.dao.impl;

import win.yulongsun.constant.ResultConstant;
import win.yulongsun.dao.UserDao;
import win.yulongsun.mapper.UserMapper;
import win.yulongsun.po.data.UserPO;
import win.yulongsun.po.request.UserPORequest;
import win.yulongsun.po.result.UserPOResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyulong on 2017/1/10.
 */
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper mapper;

    @Override
    public UserPOResult insert(UserPO userPO) {
        UserPOResult result = new UserPOResult();
        try {
            int res = mapper.insert(userPO);
            if (res > 0) {
                result.setStatus(ResultConstant.CODE.SUCCESS);
                result.setMessage(ResultConstant.MESSAGE.DEFAULT_SUCCESS_MESSAGE);
                result.setCount(res);
                result.addValue(userPO);
            }
        } catch (Exception e) {
            result.setException(e);
        }


        return result;
    }

    @Override
    public UserPOResult queryByRequest(UserPORequest request) {
        UserPOResult result = new UserPOResult();
        try {
            List<UserPO> res = mapper.queryByRequest(request);
            if (res.size() > 0) {
                result.setStatus(ResultConstant.CODE.SUCCESS);
                result.setMessage(ResultConstant.MESSAGE.DEFAULT_SUCCESS_MESSAGE);
                result.setValues(res);
                result.setCount(res.size());
            }
        } catch (Exception e) {
            result.setException(e);
        }
        return result;
    }

    @Override
    public UserPOResult update(UserPO userPO) {
        UserPOResult result = new UserPOResult();
        try {
            int count = mapper.update(userPO);
            //将结果封装为result
            if (count > 0) {
                result.setStatus(ResultConstant.CODE.SUCCESS);
                result.setMessage(ResultConstant.MESSAGE.DEFAULT_SUCCESS_MESSAGE);
                result.setCount(count);
                result.addValue(userPO);
            }
        } catch (Exception e) {
            result.setException(e);
        }
        return result;
    }

    @Override
    public UserPOResult deleteById(Integer id) {
        UserPOResult result = new UserPOResult();
        try {
            int count = mapper.delete(id);
            //将结果封装为result,不管是否删除成功，都判断为成功
            result.setStatus(ResultConstant.CODE.SUCCESS);
            result.setMessage(ResultConstant.MESSAGE.DEFAULT_SUCCESS_MESSAGE);
            result.setCount(count);
        } catch (Exception e) {
            result.setException(e);
        }
        return result;
    }
}
