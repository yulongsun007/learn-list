package win.yulongsun.demo.all.basic.juc.concurrenthashmap;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap关键点：
 * 1、
 *
 * @author Sun.YuLong on 2018/3/30.
 */
public class ConcurrentHashMapTest {

    /**
     * putIfAbsent
     * 当Key存在时就不放入，当key不存在时放入
     */
    @Test
    public void testPutIfAbsent() {
        ConcurrentHashMap<String, String> map     = new ConcurrentHashMap<>();
        String                            result1 = map.putIfAbsent("key1", "value1");
        System.out.println("result1=" + result1);//-->null
        //
        String result2 = map.putIfAbsent("key1", "value2");
        System.out.println("result2=" + result2);//-->value1
    }

    /**
     * value=null
     * default0=
     * default1=value1
     */
    @Test
    public void testGetIfDefault() {
        ConcurrentHashMap<String, String> map   = new ConcurrentHashMap<>();
        String                            value = map.get("key1");
        System.out.println("value=" + value);
        //
        String default0 = map.getOrDefault("key1", "");
        System.out.println("default0=" + default0);
        //
        map.putIfAbsent("key1", "value1");
        //
        String default1 = map.getOrDefault("key1", "default1");
        System.out.println("default1=" + default1);
    }

}
