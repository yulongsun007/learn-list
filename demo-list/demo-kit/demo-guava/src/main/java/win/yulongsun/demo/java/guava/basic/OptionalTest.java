package win.yulongsun.demo.java.guava.basic;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @author Sun.YuLong on 2018/6/12.
 */
public class OptionalTest {

    @Test
    public void testOptional(){
        Optional<Integer> optional = Optional.of(5);
        //
        System.out.println(optional.isPresent()); //true
        System.out.println(optional.get());     //5
        //
        optional = Optional.absent();
        System.out.println(optional.isPresent());   //false
        
    }
}
