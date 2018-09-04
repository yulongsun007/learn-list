package win.yulongsun.demo.mybatis.dao.mapper;

import win.yulongsun.demo.mybatis.dto.UserDto;

public interface UserDtoMapper {
    int deleteByPrimaryKey(String uid);

    int insert(UserDto record);

    int insertSelective(UserDto record);

    UserDto selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);
}