package win.yulongsun.demo.java.jdk8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Sun.YuLong on 2018/6/7.
 */
public class StreamApiTestCase {

    private List<String> strings;

    @Before
    public void init() {
        strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    }

    @Test
    public void testForEach(){
        new Random().ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void testMap(){
        new Random().ints().limit(10).sorted().forEach(System.out::println);
    }

}
