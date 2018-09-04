package win.yulongsun.demo.mybatis.dao.mapper;

import win.yulongsun.demo.mybatis.model.UserPo;

public interface UserPoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}