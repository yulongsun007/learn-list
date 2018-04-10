package win.yulongsun.demo.springboot.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Sun.YuLong on 2018/4/10.
 */
@RunWith(SpringRunner.class)
public class LogComponentTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testPrint() {
        logger.debug("this is debug {}", "1");
    }
}
