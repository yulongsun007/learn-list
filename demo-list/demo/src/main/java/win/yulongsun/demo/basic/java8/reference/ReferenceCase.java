package win.yulongsun.demo.basic.java8.reference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Sun.YuLong on 2017/10/8.
 */
public class ReferenceCase {

    //对象::实例方法
    @Test
    public void test() {
        Employee         employee = new Employee();
        PrintStream      ps       = System.out;
        Consumer<String> consumer = str -> ps.println(str);
        consumer.accept("hello world");
        //
        System.out.println("------------");
        consumer = ps::println;
        consumer.accept("hello world2");
    }


    @Test
    public void test2() {
        Employee         employee = new Employee(1, "zhangsan", 25, 33.3);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println(supplier.get());
        //
        Supplier<Integer> supplierAge = employee::getAge;
        System.out.println(supplierAge.get());
    }

    //类名::静态方法
    @Test
    public void test3(){

    }
}