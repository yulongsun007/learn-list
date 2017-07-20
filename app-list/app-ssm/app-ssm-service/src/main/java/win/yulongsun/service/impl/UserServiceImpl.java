package win.yulongsun.service.impl;

import org.springframework.stereotype.Service;
import win.yulongsun.bo.param.UserBOParam;
import win.yulongsun.bo.result.UserBOResult;
import win.yulongsun.dao.UserDao;
import win.yulongsun.po.request.UserPORequest;
import win.yulongsun.po.result.UserPOResult;
import win.yulongsun.service.UserService;
import win.yulongsun.util.convert.ConvertUtil;

import javax.annotation.Resource;

/**
 * @author sunyulong on 2017/1/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Resource
    ConvertUtil convertUtil;

    @Override
    public UserBOResult login(UserBOParam param) {

        String account  = param.getAccount();
        String password = param.getPassword();

        //check


        //query
        UserPORequest request = new UserPORequest();
        request.setAccount(account);
        request.setPassword(password);
        UserPOResult poResult = userDao.queryByRequest(request);

        UserBOResult boResult = convertUtil.tran(poResult, UserBOResult.class);

        return boResult;
    }
}
