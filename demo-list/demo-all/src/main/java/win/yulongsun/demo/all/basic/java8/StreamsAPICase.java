package win.yulongsun.demo.all.basic.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Sun.YuLong on 2017/10/8.
 */
public class StreamsAPICase {

    //创建Stream
    @Test
    public void testCreateStream() {
        //1. Collections提供了两个方法 stream()和parallelStream();
        ArrayList<String> list           = new ArrayList<>();
        Stream<String>    stream         = list.stream();   //串行流
        Stream<String>    parallelStream = list.parallelStream();   //并行流

        //2. 通过Arrays中的stream()获取一个数据流
        stream = Arrays.stream(new String[]{});

        //3. 通过值创建流，用Stream的静态方法of创建
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        //4. 创建无限流
        //4.1 迭代
        Stream<Integer> stream2 = Stream.iterate(0, x -> x + 2);
        //流的终止操作，因为不终止的话，流的创建，中间操作是不会运行的，因为只有终止才会触发；
        stream2.forEach(System.out::println);
        //4.2 生成
        Stream<Double> stream3 = Stream.generate(() -> Math.random() * 100);
        stream3.forEach(System.out::println);
    }
}
