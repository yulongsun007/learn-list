package win.yulongsun.demo.interv.程序员面试金典.原串翻转;

import org.junit.Test;

/**
 * Created by : yulongsun
 * Date on : 2016/8/25
 * Desc : 原串翻转
 */
public class ReverseSample {


    /**
     * 题目描述
     * <p>
     * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
     * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
     * 测试样例：
     * "This is nowcoder"
     * 返回："redocwon si sihT"
     */
    @Test
    public void testReverse() {
        String s = "This is nowcoder";
        System.out.println(reverseString(s));
    }


    public String reverseString(String iniString) {
        String[] strings = iniString.split(" ");
        String resultStr = "";
        for (String s : strings) {
            resultStr = reverseUnit(s) + " " + resultStr;
        }
        return resultStr.substring(0, resultStr.length() - 1);
    }

    private String reverseUnit(String str) {
        char[] charArray = str.toCharArray();
        char[] resultArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            resultArray[charArray.length - i - 1] = charArray[i];
        }
        return new String(resultArray);
    }

}
