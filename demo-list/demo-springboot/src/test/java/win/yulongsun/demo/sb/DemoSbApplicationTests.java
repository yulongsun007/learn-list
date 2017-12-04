package win.yulongsun.demo.sb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSbApplication.class)
public class DemoSbApplicationTests {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Test
    public void contextLoads() {

    }

    @Test
    public void testLogger() {
        LOG.error("-------error----");
        LOG.warn("-------warn----");
        LOG.info("-------info----");
        LOG.trace("-------trace----");
        LOG.debug("-------debug----");

    }

}
