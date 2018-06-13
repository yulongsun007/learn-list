package win.yulongsun.demo.java.juc.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 底层用的是AtomicInteger
 * <p>
 * CAS CPU级别的Lock，应用层面的Lock Free
 * <p>
 * 应用：
 * 1、多线程下操作某个开关
 * 2、优雅关闭某个线程
 *
 * @author Sun.YuLong on 2018/6/12.
 */
public class AtomicBooleanTest {

    @Test
    public void testCreateWithOutArguments() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        assertFalse(atomicBoolean.get());
    }

    @Test
    public void testCreateWithArguments() {
        //初始化值 默认是false
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        assertTrue(atomicBoolean.get());
    }


    @Test
    public void testGetAndSet() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        //先get后set
        assertTrue(atomicBoolean.getAndSet(false));
        assertFalse(atomicBoolean.get());
    }

    @Test
    public void testCompareAndSet() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        //当前值和expect相同时，才更新值为update
        atomicBoolean.compareAndSet(true, false);
        assertFalse(atomicBoolean.get());
    }


    @Test
    public void testCompareAndSetFailed() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        boolean       result        = atomicBoolean.compareAndSet(false, true);
        assertFalse(result);
        assertTrue(atomicBoolean.get());
    }
}
