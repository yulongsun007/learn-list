package win.yulongsun.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import win.yulongsun.demo.mybatis.dto.UserDto;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sun.YuLong on 2018/9/3.
 */
public class MyBatisSample {

    @Test
    public void testInsert() throws IOException {
        String      resource         = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 从工厂得到session
        SqlSession sqlSession = sessionFactory.openSession();
        //
        UserDto userDto = new UserDto();
        userDto.setUid("002");
        userDto.setUsername("sunyulong");
        userDto.setPassword("pwd");
        sqlSession.insert("win.yulongsun.demo.mybatis.dao.mapper.UserDtoMapper.insert", userDto);
        //
        sqlSession.commit();
    }

    @Test
    public void testSelect() throws IOException {
        String      resource         = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 从工厂得到session
        SqlSession sqlSession = sessionFactory.openSession();
        UserDto    userDto    = sqlSession.selectOne("win.yulongsun.demo.mybatis.dao.mapper.UserDtoMapper.selectByPrimaryKey", "002");
        System.out.println(userDto.getUsername());
    }
}
