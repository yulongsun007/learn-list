package win.yulongsun.demo.basic.java8;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Sun.YuLong on 2017/10/9.
 *
 * Optional是一个容器类,代表一个值存在或者不存在。
 *
 */
public class OptionalCase {

    //1. Optional.of(...) 创建一个Optional实例,如果参数为null,则会报NPE
    @Test(expected = NullPointerException.class)
    public void test1() {
        //正常输出
        Optional<String> op = Optional.of(new String());
        System.out.println(op.get());
        //NPE
        Optional<String> optional = Optional.of(null);
        System.out.println(optional.get()); //NullPointerException
    }

    //2.Optional.empty() 创建一个空的Optional实例
    @Test(expected = NoSuchElementException.class)
    public void test2(){
        Optional<Object> optional = Optional.empty();
        System.out.println(optional.get()); //java.util.NoSuchElementException: No value present
    }

    //3.Optional.ofNullable(..)
    @Test
    public void test3(){
        Optional<String> optional = Optional.ofNullable(new String());
        if(optional.isPresent()){
            System.out.println(optional.get());
        }

    }

}
