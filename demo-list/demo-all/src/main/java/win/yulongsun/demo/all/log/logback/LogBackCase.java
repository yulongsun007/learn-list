package win.yulongsun.demo.all.log.logback;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sun.Yulong on 2017/9/30.
 */
public class LogBackCase {


    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(LogBackCase.class);
        for (int i = 0; i < 100000; i++) {
            LOG.error("debug" + i);
        }
    }
}
