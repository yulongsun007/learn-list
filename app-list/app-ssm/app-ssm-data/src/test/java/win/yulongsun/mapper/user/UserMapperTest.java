package win.yulongsun.mapper.user;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import win.yulongsun.base.AppBaseTest;
import win.yulongsun.mapper.UserMapper;
import win.yulongsun.po.data.UserPO;
import win.yulongsun.po.request.UserPORequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyulong on 2017/1/20.
 */

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserMapperTest extends AppBaseTest {


    @Resource
    UserMapper mapper;

    @Test
    public void testInsert() {
        //插入一条数据
        UserPO userPO = general();
        int    insert = mapper.insert(userPO);
        Assert.assertTrue(1 == insert);
        //判断插入数据
        UserPORequest request = new UserPORequest();
        request.setId(userPO.getId());
        List<UserPO> userPOList = mapper.queryByRequest(request);
        UserPO       result     = userPOList.get(0);
        Assert.assertNotNull(result);
        Assert.assertEquals(userPO.getName(), result.getName());
        Assert.assertEquals(userPO.getMobile(), result.getMobile());
        Assert.assertEquals(userPO.getPassword(), result.getPassword());
        Assert.assertEquals(userPO.getAccount(), result.getAccount());
    }


    @Test
    public void testUpdate() {
        //插入一条数据
        UserPO userPO = general();
        int    insert = mapper.insert(userPO);
        Assert.assertTrue(1 == insert);

        //修改这条数据
        UserPO newUserPO = general();
        newUserPO.setId(userPO.getId());
        int update = mapper.update(newUserPO);
        Assert.assertTrue(1 == update);

        //判断修改数据
        UserPORequest request = new UserPORequest();
        request.setId(userPO.getId());
        List<UserPO> userPOList = mapper.queryByRequest(request);
        UserPO       result     = userPOList.get(0);
        Assert.assertNotNull(result);
        Assert.assertEquals(newUserPO.getName(), result.getName());
        Assert.assertEquals(newUserPO.getMobile(), result.getMobile());
        Assert.assertEquals(newUserPO.getPassword(), result.getPassword());
        Assert.assertEquals(newUserPO.getAccount(), result.getAccount());
    }


    @Test
    public void delete() {
        //插入一条数据
        UserPO userPO = general();
        int    insert = mapper.insert(userPO);
        Assert.assertTrue(1 == insert);

        //删除这条数据
        int delete = mapper.delete(userPO.getId());
        Assert.assertTrue(1 == delete);

        //判断删除结果
        UserPORequest request = new UserPORequest();
        request.setId(userPO.getId());
        List<UserPO> userPOList = mapper.queryByRequest(request);
        Assert.assertTrue(0 == userPOList.size());
    }

    private UserPO general() {
        UserPO userPO = new UserPO();
        userPO.setId(getIntRadom());
        userPO.setName(String.valueOf(getIntRadom()));
        userPO.setAccount(String.valueOf(getIntRadom()));
        userPO.setPassword(String.valueOf(getIntRadom()));
        userPO.setMobile(String.valueOf(getIntRadom()));
        return userPO;
    }


}
