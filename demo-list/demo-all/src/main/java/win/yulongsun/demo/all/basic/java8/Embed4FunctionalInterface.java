package win.yulongsun.demo.all.basic.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8内置的四大核心函数式接口
 *
 * @author Sun.YuLong on 2017/10/9.
 */
public class Embed4FunctionalInterface {

    //1.测试消费型接口
    @Test
    public void testConsumer() {
//        consumer(100, new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
        //
        consumer(100, integer -> System.out.println(integer)); //System.out::println
    }

    private void consumer(int num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }

    //2.测试供给型接口
    @Test
    public void testSupplier() {
//        List<Integer> numList = generateNumList(100, new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return (int) (Math.random() * 100);
//            }
//        });
        //Lambda负责供给数字给Supplier
        List<Integer> numList = generateNumList(100, () -> (int) (Math.random() * 100));
        for (Integer i : numList) {
            System.out.println(i);
        }
    }

    private List<Integer> generateNumList(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();   //获取数字
            list.add(integer);
        }
        return list;
    }


    //3. 测试函数型接口
    @Test
    public void testFunction() {
//        getStr(" 12345 ", new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.trim();
//            }
//        });
        //
        String string = getStr(" 12345 ", str -> str.trim());   //去除两边空格 String::trim
        System.out.println(string);
        //
        string = getStr("123456", str -> str.substring(0, 2));
        System.out.println(string);
    }

    private String getStr(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //4. 测试断言型接口
    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("SunYulong", "123");
//        filterList(list, new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length()>3;
//            }
//        });
        //
        List<String> result = filterList(list, str -> str.length() > 3);
        for (String str : result) {
            System.out.println(str);
        }
    }

    private List<String> filterList(List<String> list, Predicate<String> predicate) {
        ArrayList<String> data = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                data.add(str);
            }
        }
        return data;
    }
}
