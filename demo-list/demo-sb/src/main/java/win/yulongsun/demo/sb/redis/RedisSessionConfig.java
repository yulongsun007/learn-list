package win.yulongsun.demo.sb.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Sun.Yulong on 2017/8/15.
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
