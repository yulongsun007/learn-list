package win.yulongsun.doc.x.service;

import win.yulongsun.bo.param.UserBOParam;
import win.yulongsun.bo.result.UserBOResult;

/**
 * @author sunyulong on 2017/1/11.
 */
public interface UserService {

    UserBOResult login(UserBOParam param);
}
