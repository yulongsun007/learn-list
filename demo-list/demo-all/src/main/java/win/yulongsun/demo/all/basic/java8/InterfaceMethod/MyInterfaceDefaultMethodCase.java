package win.yulongsun.demo.all.basic.java8.InterfaceMethod;

import org.junit.Test;

/**
 * @author Sun.YuLong on 2017/10/9.
 */
public class MyInterfaceDefaultMethodCase {

    @Test
    public void test1(){
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());
    }

}
class SubClass extends MyClass implements MyInterfaceDefaultMethod{

}
