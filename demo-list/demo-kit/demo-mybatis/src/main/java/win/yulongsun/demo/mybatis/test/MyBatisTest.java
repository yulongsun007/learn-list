package win.yulongsun.demo.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import win.yulongsun.demo.mybatis.model.UserPo;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sun.YuLong on 2018/9/3.
 */
public class MyBatisTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void init() throws IOException {
        String      resource         = "mybatis/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void testInsert() throws IOException {
        // 从工厂得到session
        SqlSession sqlSession = sessionFactory.openSession();
        //
        UserPo userDto = new UserPo();
        userDto.setUsername("user2");
        userDto.setPassword("pwd2");
        sqlSession.insert("win.yulongsun.demo.mybatis.dao.mapper.UserPoMapper.insert", userDto);
        //
        sqlSession.commit();
    }

    @Test
    public void testSelect() throws IOException {
        // 从工厂得到session
        SqlSession sqlSession = sessionFactory.openSession();
        //
        UserPo userDto = sqlSession.selectOne("win.yulongsun.demo.mybatis.dao.mapper.UserPoMapper.selectByPrimaryKey", 1);
        sqlSession.commit();
        //
        System.out.println(userDto.getUsername());
    }


    @Test
    public void testUpdate() {
        SqlSession sqlSession = sessionFactory.openSession();
        UserPo     userDto    = sqlSession.selectOne("win.yulongsun.demo.mybatis.dao.mapper.UserPoMapper.selectByPrimaryKey", 1);
        userDto.setUsername("new name");
        int update = sqlSession.update("win.yulongsun.demo.mybatis.dao.mapper.UserPoMapper.updateByPrimaryKeySelective", userDto);
        sqlSession.commit();
        //
        System.out.println("更新结果：" + update);
    }


    @Test
    public void testDelete() {
        SqlSession sqlSession = sessionFactory.openSession();
        int        delete     = sqlSession.delete("win.yulongsun.demo.mybatis.dao.mapper.UserPoMapper.deleteByPrimaryKey", 1);
        sqlSession.commit();
        System.out.println("删除结果：" + delete);
    }
}
