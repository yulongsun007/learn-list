package win.yulongsun.demo.utils.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Sun.YuLong on 2018/6/12.
 */
public class CacheTest {

    @Test
    public void testBuildCache() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .concurrencyLevel(4)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(2)
                .softValues()
                .build();
        cache.put("name", "sunyulong");
        System.out.println(cache.getIfPresent("name"));
    }
}
