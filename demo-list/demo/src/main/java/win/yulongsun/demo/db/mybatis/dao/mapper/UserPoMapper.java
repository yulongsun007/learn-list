package win.yulongsun.demo.db.mybatis.dao.mapper;

import win.yulongsun.demo.db.mybatis.model.UserPo;

public interface UserPoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}