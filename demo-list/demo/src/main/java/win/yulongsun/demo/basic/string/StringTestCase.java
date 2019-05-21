package win.yulongsun.demo.basic.string;

import org.junit.Test;

/**
 * @author yulong.sun
 * @version StringTestCase.java, v 0.1 2019-05-20 22:41 yulong.sun Exp $
 */
public class StringTestCase {


    @Test
    public void test1() {
        String abc = new String("abc");
        System.out.println(abc.intern() == abc); //falase
    }

    @Test
    public void test2() {
        String abc = "abc";
        System.out.println(abc.intern() == abc); //true
    }

    @Test
    public void test3() {
        String java = "JA" + "VA";
        System.out.println(java.intern() == "JAVA"); //true
    }

    @Test
    public void test4() {
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);//true
    }

    @Test
    public void test5() {
        String str1 = "str01";
        String str2 = new String("str") + new String("01");
        str2.intern();
        System.out.println(str2 == str1); //false
    }

    @Test
    public void test6() {
        String s1 = "abc";
        final String s2 = "a";
        final String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);//true
    }

    @Test
    public void test7() {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);//false
    }


    @Test
    public void test8() {
        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());
    }
}
