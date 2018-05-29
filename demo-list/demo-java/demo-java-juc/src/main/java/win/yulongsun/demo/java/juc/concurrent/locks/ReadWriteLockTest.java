package win.yulongsun.demo.java.juc.concurrent.locks;


import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Sun.YuLong on 2018/4/10.
 */
public class ReadWriteLockTest {


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