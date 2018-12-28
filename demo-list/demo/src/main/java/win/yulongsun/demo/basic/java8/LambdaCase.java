package win.yulongsun.demo.basic.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @author Sun.YuLong on 2017/10/8.
 *
 * * 基础语法
 * 语法格式一：无参数，无返回值
 *      () -> {System.out.println("hello");};
 *      或者() -> System.out.println("hello");
 * 语法格式二：有一个参数，无返回值
 *      (x)->System.out.println("hello");
 * 语法格式三：如果只有一个参数，小括号可以省略不写；
 *      x->System.out.println("hello");
 * 语法格式四：有两个以上参数，有返回值
 * Comparator com = (x,y)->{
 *      System.out.println("函数式接口");
 *      return Integer.compare(x,y);
 * };
 * 语法格式五：如果Lambda表达体只有一条语句，return和大括号都可以省略不写；
 *      Comparator com = (x,y)->Integer.compare(x,y);
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出数据类型；
 *      (Integer x,Integer y)->Integer.compare(x,y);
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
        Runnable runnable2 = () -> System.out.println("hello");
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

    ///////////////////////////////////////////////////////////////////////////
    // Lambda使用
    ///////////////////////////////////////////////////////////////////////////

    //语法格式一：无参数，无返回值
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        };
        runnable.run();
        //
        Runnable runable2 = () -> System.out.println("hello lambda");
        runable2.run();
    }

    //语法格式二：有一个参数，无返回值
    //语法格式三：如果只有一个参数，小括号可以省略不写；
    @Test
    public void test2() {
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        consumer.accept(1);
        //
        Consumer<String> strConsumer = x -> System.out.println(x);
        strConsumer.accept("hello");
    }

    //语法格式四：有两个以上参数，有返回值
    @Test
    public void test3(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("函数式接口");
                return Integer.compare(o1, o2);
            }
        };
        //
        comparator = (o1, o2) -> {
            System.out.println("函数式接口");
            return Integer.compare(o1, o2);
        };
    }

    //语法格式五:如果Lambda表达体只有一条语句，那么return和大括号都可以省略不写
    @Test
    public void test4() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        //
        comparator = (o1, o2) -> Integer.compare(o1, o2);
    }

    // 自动推断
    @Test
    public void test5(){
        //jdk1.7开始支持后面不写泛型，自动推断类型
        ArrayList<String> list = new ArrayList<>();
        //jdk1.8升级了自动推断，如下
        show(new HashMap<>());
    }

    private void show(HashMap<String, Integer> map) {}


    //
//    @Test
//    public void test6(){
//       Integer num =  operationNum(100,x->x*x);
//    }
//
//    private int operationNum(Integer num, Functional functional){
//        return functional.getVal;
//    };

}
