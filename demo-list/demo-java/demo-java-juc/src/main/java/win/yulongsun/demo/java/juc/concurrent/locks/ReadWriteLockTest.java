package win.yulongsun.demo.java.juc.concurrent.locks;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Sun.YuLong on 2018/4/10.
 */
public class ReadWriteLockTest {

    @Test
    public void testPutAndGet() {
        Cache.put("name", "zhangsan");
        Assert.assertEquals("zhangsan", Cache.get("name"));
    }

    @Test
    public void testClear() {
        Cache.put("name", "zhangsan");
        Cache.clear();
        Assert.assertNull(Cache.get("name"));
    }

}

class Cache {
    private static HashMap<String, Object> cache         = new HashMap<String, Object>();
    private static ReentrantReadWriteLock  readWriteLock = new ReentrantReadWriteLock();

    public static Object get(String key) {
        readWriteLock.readLock().lock();
        try {
            return cache.get(key);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static Object put(String key, Object object) {
        readWriteLock.readLock().lock();
        try {
            return cache.put(key, object);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static void clear() {
        readWriteLock.readLock().lock();
        try {
            cache.clear();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}