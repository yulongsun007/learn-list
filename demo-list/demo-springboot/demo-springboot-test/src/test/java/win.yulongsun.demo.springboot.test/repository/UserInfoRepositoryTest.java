package win.yulongsun.demo.springboot.test.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import win.yulongsun.demo.springboot.test.BaseTest;
import win.yulongsun.demo.springboot.test.pojo.dto.UserDto;

/**
 * @author Sun.YuLong on 2018/2/8.
 */
@DataJpaTest
public class UserInfoRepositoryTest extends BaseTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void testSave() {
        UserDto userDto = new UserDto();
        userDto.setName("sunyulong");
        userDto.setName("password");
        userInfoRepository.save(userDto);
        //
        Assert.assertEquals(userDto.getName(), userInfoRepository.findOne(1).getName());
    }


}