package win.yulongsun.demo.all.basic.java8;

import org.junit.Test;
import win.yulongsun.demo.all.basic.java8.reference.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sun.YuLong on 2017/10/8.
 */
public class StreamsAPICase {
    //预留集合，方便测试
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵五", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

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

    //map(Function f): 接收一个函数作为一个参数。该函数会被应用到每一个元素上，将其映射为一个新的元素
    @Test
    public void testMap() {
        emps.stream().map(Employee::getName).forEach(System.out::println);
    }

    @Test
    public void testMap2() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    //FlatMap
    @Test
    public void testFlatMap() {

    }


    //Distinct()
    @Test
    public void testDistinct() {
        emps.stream().distinct().forEach(System.out::println);
    }

    //Sorted
    @Test
    public void testSorted() {
        emps.stream().map(Employee::getAge).sorted().forEach(System.out::println);
        //
        System.out.println("---------------------");
        //
        emps.stream().sorted((x, y) -> Integer.compare(y.getId(), x.getAge())).map(Employee::getAge).forEach(System.out::println);//倒叙

    }
}
