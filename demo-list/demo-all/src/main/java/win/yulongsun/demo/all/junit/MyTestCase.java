package win.yulongsun.demo.all.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sun.YuLong on 2017/11/16.
 */
public class MyTestCase {

    @Test
    public void testSuccess() {
        Assert.assertEquals("1", "1");
    }
}
