package win.yulongsun.demo.all.basic.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Sun.YuLong on 2017/10/8.
 */
public class LambdaCase {


    //1. 从匿名类到Lambda的转换
    @Test
    public void testLambda() {
        //原来写法，实现匿名内部类
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        runnable.run();

        System.out.println("---------------");
        //Lambda写法
        Runnable runnable2 = () -> {System.out.println("hello");};
        runnable2.run();
    }

    //2. 使用匿名内部类作为参数传递
    @Test
    public void testLambdaAsParam() {
        //原来写法
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        //
        treeSet = new TreeSet<String>((o1, o2) -> Integer.compare(o1.length(), o2.length()));
    }

}
