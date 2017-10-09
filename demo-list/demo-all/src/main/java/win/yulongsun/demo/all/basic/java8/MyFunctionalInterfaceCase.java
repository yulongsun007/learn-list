package win.yulongsun.demo.all.basic.java8;

import org.junit.Test;

/**
 * 自定义函数式接口
 * @author Sun.YuLong on 2017/10/9.
 */
public class MyFunctionalInterfaceCase {

    private double getVal(int num, MyFunctionalInterface<Integer, Double> fun) {
        return fun.getValue(num);
    }

    @Test
    public void test(){
        //等价
//        getVal(100, new MyFunctionalInterface<Integer, Double>() {
//            @Override
//            public Double getValue(Integer integer) {
//                return integer / 4d;
//            }
//        });
        //接口方法的实现：其实就是Lambda表达式(Lambda表达式==匿名对象)
        //
        double val = getVal(100, integer -> integer / 4d);  //入参是int,返回是double,对应函数式接口的泛型
        System.out.println(val);
    }
}

// 函数式接口声明@FunctionalInterface
@FunctionalInterface
interface MyFunctionalInterface<T,R> {
    R getValue(T t);
}
