package win.yulongsun.common.config;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import win.yulongsun.common.App;
import win.yulongsun.common.BaseTest;

import javax.annotation.Resource;

/**
 * @author Sun.YuLong on 2018/6/28.
 */
@SpringBootTest(classes = App.class)
public class RedisTest extends BaseTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("name", "redis test name");
    }
}
