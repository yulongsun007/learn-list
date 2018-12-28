package win.yulongsun.demo.guava.utilites;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Sun.YuLong on 2017/10/7.
 * <p>
 * http://www.365yg.com/item/6473810475082580494/
 */
public class JoinerTest {
    private final List<String> stringList              = Arrays.asList("Google", "Guava", "Java", "Scala", "Kafka");
    private final List<String> stringListWithNullValue = Arrays.asList("Google", "Guava", "Java", "Scala", null);

    @Test
    public void testJoinOnJoin() {
        String result = Joiner.on("#").join(stringList);
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
    }


    @Test(expected = NullPointerException.class)
    public void testJoinOnJoinWithNullValue() {
        String result = Joiner.on("#").join(stringListWithNullValue);
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
    }

    @Test
    public void testJoinOnJoinWithNullValueButSkip() {
        String result = Joiner.on("#").skipNulls().join(stringListWithNullValue);
        assertThat(result, equalTo("Google#Guava#Java#Scala"));
    }

}
